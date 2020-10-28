package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloHospedes;

public class ControleHospedes {

    ConectaBanco conHosp = new ConectaBanco();
    ConectaBanco conTrr = new ConectaBanco();
    ConectaBanco conApt = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    int codPs, codApt, codTrr;

    public void InserirHospede(ModeloHospedes mod) {

        achaPessoa(mod.getNomeHosp());
        achaApartamento(mod.getNumApt());
        achaTorre(mod.getTorreApt());
        conHosp.conexao();
        try {
            PreparedStatement pstHsp = (PreparedStatement) conHosp.conn.prepareStatement("insert into tab_hospedes (cod_ps,cod_apt,cod_trr) values (?,?,?)");
            pstHsp.setInt(1, codPs);
            pstHsp.setInt(2, codApt);
            pstHsp.setInt(3, codTrr);
            pstHsp.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o morador!!\n Erro: " + ex);
        }
        conHosp.desconecta();
    }

    public void achaPessoa(String nomePs) {

        conPs.conexao();
        try {
            conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + nomePs + "' ");
            conPs.rs.first();
            codPs = conPs.rs.getInt("cod_ps");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código da pessoa!!\n Erro: " + ex);
        }
        conPs.desconecta();
    }

    public void achaApartamento(String numApt) {

        conApt.conexao();
        try {
            conApt.executaSQL("select * from tab_apartamentos where num_apt ='" + numApt + "'");
            conApt.rs.first();
            codApt = conApt.rs.getInt("cod_apt");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do apartamento!!\n Erro: " + ex);
        }
        conApt.desconecta();
    }

    public void achaTorre(String trrApt) {

        conTrr.conexao();
        try {
            conTrr.executaSQL("select * from tab_torres where desc_trr ='" + trrApt + "'");
            conTrr.rs.first();
            codTrr = conTrr.rs.getInt("cod_trr");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do apartamento!!\n Erro: " + ex);
        }
        conTrr.desconecta();
    }

    public void ExcluirHospede(ModeloHospedes mod) {

        conHosp.conexao();
        try {
            PreparedStatement pstHsp = (PreparedStatement) conHosp.conn.prepareStatement("delete from tab_hospedes where cod_hsp=?");
            pstHsp.setInt(1, mod.getCodHosp());
            pstHsp.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o hóspede!!\n Erro: " + ex);
        }
        conHosp.desconecta();
    }

    public void AlterarHospede(ModeloHospedes mod) {

        achaApartamento(mod.getNumApt());
        achaTorre(mod.getTorreApt());
        conHosp.conexao();
        try {
            PreparedStatement pstHsp = (PreparedStatement) conHosp.conn.prepareStatement("update tab_hospedes set cod_apt =?,cod_trr =? where cod_hsp=?");
            pstHsp.setInt(1, codApt);
            pstHsp.setInt(2, codTrr);
            pstHsp.setInt(3, mod.getCodHosp());
            pstHsp.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o hóspede!!\n Erro: " + ex);
        }
        conHosp.desconecta();
    }
}

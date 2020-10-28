package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloMoradores;

public class ControleMoradores {

    ConectaBanco conMrd = new ConectaBanco();
    ConectaBanco conTrr = new ConectaBanco();
    ConectaBanco conApt = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
//    ModeloMoradores modMrd = new ModeloMoradores();
    int codPs, codApt, codTrr;

    public void InserirMorador(ModeloMoradores mod) {

        achaPessoa(mod.getNomeMrd());
        achaApartamento(mod.getNumApt());
        achaTorre(mod.getTorreApt());
        conMrd.conexao();
        try {
            PreparedStatement pstMrd = (PreparedStatement) conMrd.conn.prepareStatement("insert into tab_moradores (cod_ps,cod_apt,cod_trr) values (?,?,?)");
            pstMrd.setInt(1, codPs);
            pstMrd.setInt(2, codApt);
            pstMrd.setInt(3, codTrr);
            pstMrd.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o morador!!\n Erro: " + ex);
        }
        conMrd.desconecta();
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

    public void ExcluirMorador(ModeloMoradores mod) {

        conMrd.conexao();
        try {
            PreparedStatement pstMrd = (PreparedStatement) conMrd.conn.prepareStatement("delete from tab_moradores where cod_mr=?");
            pstMrd.setInt(1, mod.getCodMrd());
            pstMrd.execute();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o morador!!\n Erro: " + ex);
        }
        conMrd.desconecta();
    }

    public void AlterarMorador(ModeloMoradores mod) {

        achaPessoa(mod.getNomeMrd());
        achaApartamento(mod.getNumApt());
        achaTorre(mod.getTorreApt());
        conMrd.conexao();
        try {
            PreparedStatement pstMrd = (PreparedStatement) conMrd.conn.prepareStatement("update tab_moradores set cod_ps =?,cod_apt =?,cod_trr =? where cod_mr=?");
            pstMrd.setInt(1, codPs);
            pstMrd.setInt(2, codApt);
            pstMrd.setInt(3, codTrr);
            pstMrd.setInt(4, mod.getCodMrd());
            pstMrd.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o morador!!\n Erro: " + ex);
        }
        conMrd.desconecta();
    }
}

package ControleSistema;

import ModeloSistema.ModeloEntradasPessoas;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControleEntradasPessoas {

    ConectaBanco conEntPs = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conPort = new ConectaBanco();
    int codPs, codTpPs, codPort;
    String nomePs, RgPs;

    public void InserirEntradaPessoa(ModeloEntradasPessoas mod) {

        achaPessoa(mod.getRgPs());
        achaPorteiro(mod.getNomePort());
        conEntPs.conexao();
        try {
            PreparedStatement pstEntPessoa = (PreparedStatement) conEntPs.conn.prepareStatement("insert into Tab_Entradas_Pessoas (Data_Ent_Ps,Hora_Ent_Ps,Obs_Ent_Ps,Cod_Port,Rg_Ps,Cod_Ps,Cod_Tp_Ps,Detalhes_Ps,Entrou) values (?,?,?,?,?,?,?,?,?)");
            pstEntPessoa.setString(1, mod.getDataEnt());
            pstEntPessoa.setString(2, mod.getHoraEnt());
            pstEntPessoa.setString(3, mod.getObsEnt());
            pstEntPessoa.setInt(4, codPort);
            pstEntPessoa.setString(5, RgPs);
            pstEntPessoa.setInt(6, codPs);
            pstEntPessoa.setInt(7, codTpPs);
            pstEntPessoa.setString(8, mod.getDetalhesPs());
            pstEntPessoa.setInt(9, mod.getEntrou());
            pstEntPessoa.execute();
        } catch (SQLException ex) {
        }
        conEntPs.desconecta();
    }

    public void achaPessoa(String rgPs) {

        conPs.conexao();
        conPs.executaSQL("select * from vw_pessoa where rg_ps ='" + rgPs + "'");
        try {
            conPs.rs.first();
            codPs = conPs.rs.getInt("cod_ps");
            codTpPs = conPs.rs.getInt("cod_tp_ps");
            nomePs = conPs.rs.getString("nome_ps");
            RgPs = conPs.rs.getString("rg_ps");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradasPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPs.desconecta();
    }

    public void achaPorteiro(String nomePort) {

        conPort.conexao();
        conPort.executaSQL("select * from tab_porteiros where nome_port ='" + nomePort + "'");
        try {
            conPort.rs.first();
            codPort = conPort.rs.getInt("cod_port");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradasPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPort.desconecta();
    }

    public void AlterarEntradaPessoa(ModeloEntradasPessoas mod) {

        conEntPs.conexao();
        try {
            PreparedStatement pstEstoque = (PreparedStatement) conEntPs.conn.prepareStatement("update tab_entradas_veiculos set Entrou=? where cod_ent_vc=?");
            pstEstoque.setInt(1, mod.getEntrou());
            pstEstoque.setInt(2, mod.getCodEnt());
            pstEstoque.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de entradas de veículos!!\n Erro: " + ex);
        }
        conEntPs.desconecta();
    }
}

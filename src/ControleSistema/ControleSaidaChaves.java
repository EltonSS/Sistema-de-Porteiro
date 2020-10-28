package ControleSistema;

import ModeloSistema.ModeloSaidaChaves;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControleSaidaChaves {

    ConectaBanco conSaidPs = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conPort = new ConectaBanco();
    ConectaBanco conChv = new ConectaBanco();
    int codPs, codPort, codSet;
    String RgPs;

    public void InserirSaidaChaves(ModeloSaidaChaves mod) {

        achaPessoa(mod.getRgPs());
        achaPorteiro(mod.getNomePort());
        achaChaves(mod.getCodChv());
        conSaidPs.conexao();
        try {
            PreparedStatement pstEntPessoa = (PreparedStatement) conSaidPs.conn.prepareStatement("insert into Tab_Saida_Chaves (Data_Said_Chv,Hora_Said_Chv,Obs_Said_Chv,Cod_Port,Cod_Ps,Detalhes_Ps,Cod_Chv,Cod_Set,Saiu) values (?,?,?,?,?,?,?,?,?)");
            pstEntPessoa.setString(1, mod.getDataSaid());
            pstEntPessoa.setString(2, mod.getHoraSaid());
            pstEntPessoa.setString(3, mod.getObsSaid());
            pstEntPessoa.setInt(4, codPort);
            pstEntPessoa.setInt(5, codPs);
            pstEntPessoa.setString(6, mod.getDetalhesPs());
            pstEntPessoa.setInt(7, mod.getCodChv());
            pstEntPessoa.setInt(8, codSet);
            pstEntPessoa.setInt(9, mod.getSaiu());
            pstEntPessoa.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar a saída da chave!!\n Erro: " + ex);
        }
        conSaidPs.desconecta();
    }

    public void achaPessoa(String rgPs) {

        conPs.conexao();
        conPs.executaSQL("select * from vw_pessoa where rg_ps ='" + rgPs + "'");
        try {
            conPs.rs.first();
            codPs = conPs.rs.getInt("cod_ps");
        } catch (SQLException ex) {
            Logger.getLogger(ControleSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPort.desconecta();
    }

    public void achaChaves(int codChv) {

        conChv.conexao();
        conChv.executaSQL("select * from vw_chaves where cod_chv ='" + codChv + "'");
        try {
            conChv.rs.first();
            codChv = conChv.rs.getInt("cod_chv");
            codSet = conChv.rs.getInt("cod_set");
        } catch (SQLException ex) {
            Logger.getLogger(ControleSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        conChv.desconecta();
    }

    public void AlterarSaidaChaves(ModeloSaidaChaves mod) {

        conSaidPs.conexao();
        try {
            PreparedStatement pstSaidaChaves = (PreparedStatement) conSaidPs.conn.prepareStatement("update Tab_Saida_Chaves set Saiu=? where cod_said_chv = ?");
            pstSaidaChaves.setInt(1, mod.getSaiu());
            pstSaidaChaves.setInt(2, mod.getCodSaid());
            pstSaidaChaves.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de entradas de veículos!!\n Erro: " + ex);
        }
        conSaidPs.desconecta();
    }
}

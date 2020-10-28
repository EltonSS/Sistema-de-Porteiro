package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloRamaisAdministrativo;

public class ControleRamaisAdministrativo {

    ConectaBanco conRm = new ConectaBanco();
    ConectaBanco conSet = new ConectaBanco();
    int codSet;

    public void InserirRamal(ModeloRamaisAdministrativo mod) {

        achaSetor(mod.getDescSet());
        conRm.conexao();
        try {
            PreparedStatement pstMrd = (PreparedStatement) conRm.conn.prepareStatement("insert into tab_ramais_administrativo(num_rm,cod_set) values (?,?)");
            pstMrd.setString(1, mod.getNumRm());
            pstMrd.setInt(2, codSet);
            pstMrd.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o ramal!!\n Erro: " + ex);
        }
        conRm.desconecta();
    }

    public void achaSetor(String descSet) {

        conSet.conexao();
        try {
            conSet.executaSQL("select * from tab_setores where desc_set ='" + descSet + "' ");
            conSet.rs.first();
            codSet = conSet.rs.getInt("cod_set");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do ramal!!\n Erro: " + ex);
        }
        conSet.desconecta();
    }

    public void ExcluirRamal(ModeloRamaisAdministrativo mod) {

        conRm.conexao();
        try {
            PreparedStatement pstMrd = (PreparedStatement) conRm.conn.prepareStatement("delete from tab_ramais_administrativo where cod_rm=?");
            pstMrd.setInt(1, mod.getCodRm());
            pstMrd.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o ramal!!\n Erro: " + ex);
        }
        conRm.desconecta();
    }

    public void AlterarRamal(ModeloRamaisAdministrativo mod) {

        achaSetor(mod.getDescSet());
        conRm.conexao();
        try {
            PreparedStatement pstMrd = (PreparedStatement) conRm.conn.prepareStatement("update tab_ramais_administrativo set num_rm =?, cod_set =? where cod_rm=?");
            pstMrd.setString(1, mod.getNumRm());
            pstMrd.setInt(2, codSet);
            pstMrd.setInt(3, mod.getCodRm());
            pstMrd.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o ramal!!\n Erro: " + ex);
        }
        conRm.desconecta();
    }
}

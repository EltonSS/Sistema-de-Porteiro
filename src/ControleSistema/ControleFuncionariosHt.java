package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloFuncionariosHt;

public class ControleFuncionariosHt {

    ConectaBanco conFc = new ConectaBanco();
    ConectaBanco conRmSet = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    int codPs, codRm, codSet;

    public void InserirFuncionariosHt(ModeloFuncionariosHt mod) {

        achaPessoa(mod.getNomeFc());
        achaRamaisSetores(mod.getNumRm());
        conFc.conexao();
        try {
            PreparedStatement pstFunc = (PreparedStatement) conFc.conn.prepareStatement("insert into Tab_FuncionariosHt(cod_ps,cod_set,cod_rm) values (?,?,?)");
            pstFunc.setInt(1, codPs);
            pstFunc.setInt(2, codSet);
            pstFunc.setInt(3, codRm);
            pstFunc.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o funcionário!!\n Erro: " + ex);
        }
        conFc.desconecta();
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

    public void achaRamaisSetores(String numRm) {

        conRmSet.conexao();
        try {
            conRmSet.executaSQL("select * from vw_ramais_administrativo where num_rm ='" + numRm + "'");
            conRmSet.rs.first();
            codRm = conRmSet.rs.getInt("cod_rm");
            codSet = conRmSet.rs.getInt("cod_set");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do apartamento!!\n Erro: " + ex);
        }
        conRmSet.desconecta();
    }

    public void ExcluirFuncionariosHt(ModeloFuncionariosHt mod) {

        conFc.conexao();
        try {
            PreparedStatement pstFunc = (PreparedStatement) conFc.conn.prepareStatement("delete from Tab_FuncionariosHt where cod_fc=?");
            pstFunc.setInt(1, mod.getCodFc());
            pstFunc.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o funcionário!!\n Erro: " + ex);
        }
        conFc.desconecta();
    }

    public void AlterarFuncionariosHt(ModeloFuncionariosHt mod) {

        achaPessoa(mod.getNomeFc());
        achaRamaisSetores(mod.getNumRm());
        conFc.conexao();
        try {
            PreparedStatement pstFunc = (PreparedStatement) conFc.conn.prepareStatement("update Tab_FuncionariosHt set cod_ps =?,cod_set =?,cod_rm =? where cod_fc=?");
            pstFunc.setInt(1, codPs);
            pstFunc.setInt(2, codSet);
            pstFunc.setInt(3, codRm);
            pstFunc.setInt(4, mod.getCodFc());
            pstFunc.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o funcionário!!\n Erro: " + ex);
        }
        conFc.desconecta();
    }
}

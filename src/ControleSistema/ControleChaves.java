package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloChaves;

public class ControleChaves {

    ConectaBanco conChv = new ConectaBanco();
    ConectaBanco conSet = new ConectaBanco();
    ModeloChaves modChv = new ModeloChaves();
    int codSet, Saiu = 0;

    public void InserirChaves(ModeloChaves mod) {

        achaSetorFuncinario(mod.getDescSet());
        conChv.conexao();
        try {
            PreparedStatement pstPs = (PreparedStatement) conChv.conn.prepareStatement("insert into tab_chaves(desc_chv,cod_set,saiu) values (?,?,?)");
            pstPs.setString(1, mod.getDescChv());
            pstPs.setInt(2, codSet);
            pstPs.setInt(3, Saiu);
            pstPs.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a chave!!\n Erro: " + ex);
        }
        conChv.desconecta();
    }

    public void achaSetorFuncinario(String descSet) {

        conSet.conexao();
        try {
            conSet.executaSQL("select * from tab_setores where desc_set ='" + descSet + "' ");
            conSet.rs.first();
            codSet = conSet.rs.getInt("cod_set");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do setor do funcionário!!\n Erro: " + ex);
        }
        conSet.desconecta();
    }

    public void ExcluirChaves(ModeloChaves mod) {

        conChv.conexao();
        try {
            String nome = "Você deseja deletar a chave : " + mod.getDescChv() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstPs = (PreparedStatement) conChv.conn.prepareStatement("delete from tab_chaves where cod_chv = ?");
                pstPs.setInt(1, mod.getCodChv());
                pstPs.execute();
                JOptionPane.showMessageDialog(null, "A chave " + mod.getDescChv()+ " foi excluída com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
        }
        conChv.desconecta();
    }

    public void AlterarChaves(ModeloChaves mod) {

        achaSetorFuncinario(mod.getDescSet());
        conChv.conexao();
        try {
            PreparedStatement pstPs = (PreparedStatement) conChv.conn.prepareStatement("update tab_chaves set desc_chv = ?,cod_set = ? where cod_chv = ?");
            pstPs.setString(1, mod.getDescChv());
            pstPs.setInt(2, codSet);
            pstPs.setInt(3, mod.getCodChv());
            pstPs.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o registro!!\n Erro: " + ex);
        }
        conChv.desconecta();
    }
}

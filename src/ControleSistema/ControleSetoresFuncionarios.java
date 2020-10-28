package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloSetoresFuncionarios;

public class ControleSetoresFuncionarios {

    ConectaBanco conSt = new ConectaBanco();
    ConectaBanco conRm = new ConectaBanco();
    ModeloSetoresFuncionarios modSets = new ModeloSetoresFuncionarios();
    int codRm;

    public void InserirSetor(ModeloSetoresFuncionarios mod) {
        
        conSt.conexao();
        try {
            PreparedStatement pstSt = (PreparedStatement) conSt.conn.prepareStatement("insert into tab_setores (desc_set) values (?)");
            pstSt.setString(1, mod.getDesc_set());
            pstSt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o setor!!\n Erro: " + ex);
        }
        conSt.desconecta();
    }
    
    public void ExcluirSetor(ModeloSetoresFuncionarios mod) {

        conSt.conexao();
        try {
            String nome = "Você deseja deletar o setor : " + mod.getDesc_set() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstSt = (PreparedStatement) conSt.conn.prepareStatement("delete from tab_setores where cod_set=?");
                pstSt.setInt(1, mod.getCod_set());
                pstSt.execute();
            } else {
                if (opcao_escolhida == JOptionPane.NO_OPTION) {
                    return;
                }                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o setor!!\n Erro: " + ex);
        }
        conSt.desconecta();
    }

    public void AlterarSetor(ModeloSetoresFuncionarios mod) {

        conSt.conexao();
        try {
            PreparedStatement pstSt = (PreparedStatement) conSt.conn.prepareStatement("update tab_setores set desc_set =? where cod_set=?");
            pstSt.setString(1, mod.getDesc_set());
            pstSt.setInt(2, mod.getCod_set());
            pstSt.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o registro!!\n Erro: " + ex);
        }
        conSt.desconecta();
    }
}

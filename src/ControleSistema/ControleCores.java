package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloCores;

public class ControleCores {

    ConectaBanco conCor = new ConectaBanco();
    ModeloCores mod = new ModeloCores();

    public void InserirCor(ModeloCores mod) {

        conCor.conexao();
        try {
            PreparedStatement pstCores = (PreparedStatement) conCor.conn.prepareStatement("insert into tab_cores (desc_cor) values (?)");
            pstCores.setString(1, mod.getDescCor());
            pstCores.execute();
            JOptionPane.showMessageDialog(null, "A cor " + mod.getDescCor() + " foi registrada com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a cor!!\n Erro: " + ex);
        }
        conCor.desconecta();
    }

    public void ExcluirCor(ModeloCores mod) {

        conCor.conexao();
        try {
            String nome = "Você deseja deletar a cor : " + mod.getDescCor() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstCores = (PreparedStatement) conCor.conn.prepareStatement("delete from tab_cores where cod_cor =?");
                pstCores.setInt(1, mod.getCodCor());
                pstCores.execute();
                JOptionPane.showMessageDialog(null, "A cor " + mod.getDescCor() + " foi excluído com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a cor!!\n Erro: " + ex);
        }
        conCor.desconecta();
    }

    public void AlterarCor(ModeloCores mod) {

        conCor.conexao();
        try {
            PreparedStatement pstFabbricante = (PreparedStatement) conCor.conn.prepareStatement("update tab_cores set desc_cor =? where cod_cor=?");
            pstFabbricante.setString(1, mod.getDescCor());
            pstFabbricante.setInt(2, mod.getCodCor());
            pstFabbricante.execute();
            JOptionPane.showMessageDialog(null, "A cor : " + mod.getDescCor() + " foi alterado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a cor!!\n Erro: " + ex);
        }
        conCor.desconecta();
    }
}

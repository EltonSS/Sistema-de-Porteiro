package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloLembrete;

public class ControleLembrete {

    ConectaBanco conLembrete = new ConectaBanco();
    ModeloLembrete mod = new ModeloLembrete();

    public void InserirLembrete(ModeloLembrete mod) {

        conLembrete.conexao();
        try {
            PreparedStatement pstLembrete = (PreparedStatement) conLembrete.conn.prepareStatement("insert into tab_lembrete (Data_Lembrete,Titulo_Assunto_Lembrete,Descricao_Lembrete) values (?,?,?)");
            pstLembrete.setString(1, mod.getDataLembrete());
            pstLembrete.setString(2, mod.getAssuntoLembrete());
            pstLembrete.setString(3, mod.getObservacaoLembrete());
            pstLembrete.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o lembrete!!\n Erro: " + ex);
        }
        conLembrete.desconecta();
    }

    public void ExcluirLembrete(ModeloLembrete mod) {

        conLembrete.conexao();
        try {
            String assunto = "Você deseja deletar o lembrete: " + mod.getAssuntoLembrete() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, assunto, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstLembrete = (PreparedStatement) conLembrete.conn.prepareStatement("delete from tab_lembrete where Titulo_Assunto_Lembrete=?");
                pstLembrete.setString(1, mod.getAssuntoLembrete());
                pstLembrete.execute();
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o lembrete!!\n Erro: " + ex);
        }
        conLembrete.desconecta();
    }

    public void AlterarLembrete(ModeloLembrete mod) {

        conLembrete.conexao();
        try {
            PreparedStatement pstLembrete = (PreparedStatement) conLembrete.conn.prepareStatement("update tab_lembrete set Data_Lembrete =?,Descricao_Lembrete=? where Titulo_Assunto_Lembrete=?");           
            pstLembrete.setString(1, mod.getDataLembrete());
            pstLembrete.setString(2, mod.getObservacaoLembrete());
            pstLembrete.setString(3, mod.getAssuntoLembrete());
            pstLembrete.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o lembrete!!\n Erro: " + ex);
        }
        conLembrete.desconecta();
    }
}
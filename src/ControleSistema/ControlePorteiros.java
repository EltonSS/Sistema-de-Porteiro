package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloPorteiros;

public class ControlePorteiros {

    ConectaBanco conPort = new ConectaBanco();

    public void InserirPorteiro(ModeloPorteiros mod) {

        conPort.conexao();
        try {
            PreparedStatement pstPorteiro = (PreparedStatement) conPort.conn.prepareStatement("insert into tab_porteiros (nome_port,login_port,senha_port) values (?,?,?)");
            pstPorteiro.setString(1, mod.getNomePort());
            pstPorteiro.setString(2, mod.getLoginPort());
            pstPorteiro.setString(3, mod.getSenhaPort());
            pstPorteiro.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o porteiro!!\n Erro: " + ex);
        }
        conPort.desconecta();
    }

    public void ExcluirPorteiro(ModeloPorteiros mod) {
        conPort.conexao();
        try {
            String nome = "Você deseja deletar o porteiro : " + mod.getNomePort() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstPorteiro = (PreparedStatement) conPort.conn.prepareStatement("delete from tab_porteiros where cod_port=?");
                pstPorteiro.setInt(1, mod.getCodPort());
                pstPorteiro.execute();
                JOptionPane.showMessageDialog(null, "O porteiro : " + mod.getNomePort() + " foi excluído com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o porteiro!!\n Erro: " + ex);
        }
        conPort.desconecta();
    }

    public void AlterarPorteiro(ModeloPorteiros mod) {

        conPort.conexao();
        try {
            PreparedStatement pstPorteiro = (PreparedStatement) conPort.conn.prepareStatement("update tab_porteiros set nome_port =?,login_port =?,senha_port =? where cod_port=?");
            pstPorteiro.setString(1, mod.getNomePort());
            pstPorteiro.setString(2, mod.getLoginPort());
            pstPorteiro.setString(3, mod.getSenhaPort());
            pstPorteiro.setInt(4, mod.getCodPort());
            pstPorteiro.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o registro!!\n Erro: " + ex);
        }
        conPort.desconecta();
    }

    public void AlterarLoginSenhaPorteiro(ModeloPorteiros mod) {

        conPort.conexao();
        try {
            PreparedStatement pstPorteiro = (PreparedStatement) conPort.conn.prepareStatement("update tab_porteiros set senha_port =? where cod_port=?");
            pstPorteiro.setString(1, mod.getSenhaPort());
            pstPorteiro.setInt(2, mod.getCodPort());
            pstPorteiro.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a senha do técnico!!\n Erro: " + ex);
        }
        conPort.desconecta();
    }
}

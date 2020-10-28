package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloTipoFornecedores;

public class ControleTipoEmpresas {

    ConectaBanco conTpForn = new ConectaBanco();
    ModeloTipoFornecedores mod = new ModeloTipoFornecedores();

    public void InserirTipoFornecedor(ModeloTipoFornecedores mod) {

        conTpForn.conexao();
        try {
            PreparedStatement pstTipoFornecedor = (PreparedStatement) conTpForn.conn.prepareStatement("insert into tab_fornecedores (Desc_Tp_Forn) values (?)");
            pstTipoFornecedor.setString(1, mod.getDescTpForn());
            pstTipoFornecedor.execute();
            JOptionPane.showMessageDialog(null, "O tipo do fornecedor " + mod.getDescTpForn() + " foi registrado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o tipo do fornecedor!!\n Erro: " + ex);
        }
        conTpForn.desconecta();
    }

    public void ExcluirTipoFornecedor(ModeloTipoFornecedores mod) {

        conTpForn.conexao();
        try {
            String nome = "Você deseja deletar o tipo do fornecedor " + mod.getDescTpForn() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstTipoFornecedor = (PreparedStatement) conTpForn.conn.prepareStatement("delete from tab_tipofornecedores where cod_tp_forn =?");
                pstTipoFornecedor.setInt(1, mod.getCodTpForn());
                pstTipoFornecedor.execute();
                JOptionPane.showMessageDialog(null, "O tipo do fornecedor: " + mod.getDescTpForn() + " foi excluído com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o tipo do fornecedor!!\n Erro: " + ex);
        }
        conTpForn.desconecta();
    }

    public void AlterarTipoForncedor(ModeloTipoFornecedores mod) {

        conTpForn.conexao();
        try {
            PreparedStatement pstTipoFornecedor = (PreparedStatement) conTpForn.conn.prepareStatement("update tab_tipofornecedores set Desc_Tp_Forn=? where Cod_Tp_Forn=?");
            pstTipoFornecedor.setString(1, mod.getDescTpForn());
            pstTipoFornecedor.setInt(2, mod.getCodTpForn());
            pstTipoFornecedor.execute();
            JOptionPane.showMessageDialog(null, "O tipo do fornecedor : " + mod.getDescTpForn() + " foi alterado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o tipo do fornecedor!!\n Erro: " + ex);
        }
        conTpForn.desconecta();
    }
}

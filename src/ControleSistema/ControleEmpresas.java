package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloEmpresas;

public class ControleEmpresas {

    ConectaBanco conForn = new ConectaBanco();
    ConectaBanco conTpForn = new ConectaBanco();
    ModeloEmpresas mod = new ModeloEmpresas();
    String cepEnd, nomeRua, bairroEnd, cidadeEnd, estadoEnd, siglaUf;
    int codEndereco, codTpForn;

    public void InserirFornecedor(ModeloEmpresas mod) {

        achaTipoFornecedor(mod.getDescTpForn());
        conForn.conexao();
        try {
            PreparedStatement pstFornecedor = (PreparedStatement) conForn.conn.prepareStatement("insert into tab_fornecedores (Cod_Forn,Desc_Forn,Fone_Fixo_Forn,Fone_Cel_Forn,Email_Forn,Cep_Forn,Rua_Forn,Num_Forn,Complemento_Forn,Bairro_Forn,cidade_Forn,Uf_Forn,cod_tp_forn) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstFornecedor.setInt(1, mod.getCodForn());
            pstFornecedor.setString(2, mod.getDescForn());
            pstFornecedor.setString(3, mod.getFoneFixoForn());
            pstFornecedor.setString(4, mod.getFoneCelularForn());
            pstFornecedor.setString(5, mod.getEmailForn());
            pstFornecedor.setString(6, mod.getCepEnd());
            pstFornecedor.setString(7, mod.getRuaEnd());
            pstFornecedor.setString(8, mod.getNumeroForn());
            pstFornecedor.setString(9, mod.getComplementoForn());
            pstFornecedor.setString(10, mod.getBairroEnd());
            pstFornecedor.setString(11, mod.getCidadeEnd());
            pstFornecedor.setString(12, mod.getUfEnd());
            pstFornecedor.setInt(13, codTpForn);
            pstFornecedor.execute();
            JOptionPane.showMessageDialog(null, "O fornecedor " + mod.getDescForn() + " foi registrado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o fornecedor!!\n Erro: " + ex);
        }
        conForn.desconecta();
    }

    public void achaTipoFornecedor(String descTpForn) {

        conTpForn.conexao();
        conTpForn.executaSQL("select * from tab_tipofornecedores where desc_tp_forn ='" + descTpForn + "'");
        try {
            conTpForn.rs.first();
            codTpForn = conTpForn.rs.getInt("cod_tp_forn");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEmpresas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conTpForn.desconecta();
    }

    public void ExcluirFornecedor(ModeloEmpresas mod) {

        conForn.conexao();
        try {
            String nome = "Você deseja deletar o fornecedor " + mod.getDescForn() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstFornecedor = (PreparedStatement) conForn.conn.prepareStatement("delete from tab_fornecedores where cod_forn =?");
                pstFornecedor.setInt(1, mod.getCodForn());
                pstFornecedor.execute();
                JOptionPane.showMessageDialog(null, "O fornecedor : " + mod.getDescForn() + " foi excluído com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o fornecedor!!\n Erro: " + ex);
        }
        conForn.desconecta();
    }

    public void AlterarForncedor(ModeloEmpresas mod) {

        achaTipoFornecedor(mod.getDescTpForn());
        conForn.conexao();
        try {
            PreparedStatement pstFornecedor = (PreparedStatement) conForn.conn.prepareStatement("update tab_fornecedores set Desc_Forn =?,Fone_Fixo_Forn =?,Fone_Cel_Forn =?,Email_Forn=?,Cep_Forn =?,Rua_Forn =?,Num_Forn =?,Complemento_Forn=?,Bairro_Forn =?,Cidade_Forn=?,Uf_Forn=?,cod_tp_forn=? where Cod_Forn=?");
            pstFornecedor.setString(1, mod.getDescForn());
            pstFornecedor.setString(2, mod.getFoneFixoForn());
            pstFornecedor.setString(3, mod.getFoneCelularForn());
            pstFornecedor.setString(4, mod.getEmailForn());
            pstFornecedor.setString(5, mod.getCepEnd());
            pstFornecedor.setString(6, mod.getRuaEnd());
            pstFornecedor.setString(7, mod.getNumeroForn());
            pstFornecedor.setString(8, mod.getComplementoForn());
            pstFornecedor.setString(9, mod.getBairroEnd());
            pstFornecedor.setString(10, mod.getCidadeEnd());
            pstFornecedor.setString(11, mod.getUfEnd());
            pstFornecedor.setInt(12, codTpForn);
            pstFornecedor.setInt(13, mod.getCodForn());
            pstFornecedor.execute();
            JOptionPane.showMessageDialog(null, "O fornecedor : " + mod.getDescForn() + " foi alterado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o fornecedor!!\n Erro: " + ex);
        }
        conForn.desconecta();
    }
}

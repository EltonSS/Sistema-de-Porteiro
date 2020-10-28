package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloPrestadorServico;

public class ControlePrestadorServico {

    ConectaBanco conPts = new ConectaBanco();
    ConectaBanco conForn = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    int codPs, codForn, codTrr;

    public void InserirPrestadorServico(ModeloPrestadorServico mod) {

        achaPessoa(mod.getNomePts());
        achaFornecedor(mod.getDescForn());
        conPts.conexao();
        try {
            PreparedStatement pstPts = (PreparedStatement) conPts.conn.prepareStatement("insert into tab_prestadoresservicos (cod_ps,cod_forn) values (?,?)");
            pstPts.setInt(1, codPs);
            pstPts.setInt(2, codForn);
            pstPts.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o funcionário prestador de serviço!!\n Erro: " + ex);
        }
        conPts.desconecta();
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

    public void achaFornecedor(String descForn) {

        conForn.conexao();
        try {
            conForn.executaSQL("select * from tab_fornecedores where desc_forn ='" + descForn + "'");
            conForn.rs.first();
            codForn = conForn.rs.getInt("cod_forn");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do fornecedor!!\n Erro: " + ex);
        }
        conForn.desconecta();
    }

    public void ExcluirPrestadorServico(ModeloPrestadorServico mod) {

        conPts.conexao();
        try {
            PreparedStatement pstPts = (PreparedStatement) conPts.conn.prepareStatement("delete from tab_prestadoresservicos where cod_Prsv=?");
            pstPts.setInt(1, mod.getCodPts());
            pstPts.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o funcionário prestador de serviço!!\n Erro: " + ex);
        }
        conPts.desconecta();
    }

    public void AlterarPrestadorServico(ModeloPrestadorServico mod) {

        achaFornecedor(mod.getDescForn());
        conPts.conexao();
        try {
            PreparedStatement pstPts = (PreparedStatement) conPts.conn.prepareStatement("update tab_prestadoresservicos set cod_forn =? where cod_Prsv=?");
            pstPts.setInt(1, codForn);
            pstPts.setInt(2, mod.getCodPts());
            pstPts.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o funcionário prestador de serviço!!\n Erro: " + ex);
        }
        conPts.desconecta();
    }
}

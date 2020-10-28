package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloPessoas;

public class ControlePessoas {

    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conTpPs = new ConectaBanco();
    ModeloPessoas modPs = new ModeloPessoas();
    int codTpPs, codPs;

    public void InserirPessoa(ModeloPessoas mod) {

        achaTipoPessoa(mod.getDescTpPs());
        conPs.conexao();
        try {
            PreparedStatement pstPs = (PreparedStatement) conPs.conn.prepareStatement("insert into tab_pessoas (nome_ps,rg_ps,celular_ps,fone_fixo,email_ps,cod_tp_ps) values (?,?,?,?,?,?)");
            pstPs.setString(1, mod.getNomePs());
            pstPs.setString(2, mod.getRgPs());
            pstPs.setString(3, mod.getCelularPs());
            pstPs.setString(4, mod.getFoneFixoPs());
            pstPs.setString(5, mod.getEmailPs());
            pstPs.setInt(6, codTpPs);
            pstPs.execute();
            //JOptionPane.showMessageDialog(null,"Registro Inseridos com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a pessoa!!\n Erro: " + ex);
        }
        conPs.desconecta();
    }

    public void achaTipoPessoa(String TpPs) {

        conTpPs.conexao();
        try {
            conTpPs.executaSQL("select * from tab_tipos_pessoas where desc_tp_ps ='" + TpPs + "' ");
            conTpPs.rs.first();
            codTpPs = conTpPs.rs.getInt("cod_tp_ps");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do tipo de pessoa!!\n Erro: " + ex);
        }
        conTpPs.desconecta();
    }

    public void ExcluirPessoa(ModeloPessoas mod) {

        conPs.conexao();
        try {
            PreparedStatement pstPs = (PreparedStatement) conPs.conn.prepareStatement("delete from tab_pessoas where cod_ps=?");
            pstPs.setInt(1, mod.getCodPs());
            pstPs.execute();
        } catch (SQLException ex) {
        }
        conPs.desconecta();
    }

    public void AlterarPessoa(ModeloPessoas mod) {

        conPs.conexao();
        try {
            PreparedStatement pstPs = (PreparedStatement) conPs.conn.prepareStatement("update tab_pessoas set nome_ps =?,rg_ps =?,celular_ps =?,fone_fixo =?,email_ps =?where cod_ps =?");
            pstPs.setString(1, mod.getNomePs());
            pstPs.setString(2, mod.getRgPs());
            pstPs.setString(3, mod.getCelularPs());
            pstPs.setString(4, mod.getFoneFixoPs());
            pstPs.setString(5, mod.getEmailPs());
            pstPs.setInt(6, mod.getCodPs());
            pstPs.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o registro!!\n Erro: " + ex);
        }
        conPs.desconecta();
    }
//    
//        public void Cadastrada(ModeloPessoas mod) {
//
//        conPs.conexao();
//        try {
//            PreparedStatement pstPs = (PreparedStatement) conPs.conn.prepareStatement("update tab_pessoas set cadastrado =? where cod_ps =?");           
//            pstPs.setString(1, mod.getCadastrado());
//            pstPs.setInt(2, mod.getCodPs());
//            pstPs.execute();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o registro da pessoa se cadastrada!!\n Erro: " + ex);
//        }
//        conPs.desconecta();
//    }
}

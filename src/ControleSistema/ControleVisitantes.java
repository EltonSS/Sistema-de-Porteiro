package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloVisitantes;

public class ControleVisitantes {

    ConectaBanco conVst = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    int codPs;

    public void InserirVisitante(ModeloVisitantes mod) {

        achaPessoa(mod.getNomeVst());
        conVst.conexao();
        try {
            PreparedStatement pstVst = (PreparedStatement) conVst.conn.prepareStatement("insert into tab_visitantes (cod_ps,obs_vis) values (?,?)");
            pstVst.setInt(1, codPs);
            pstVst.setString(2, mod.getObs());
            pstVst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o visitante!!\n Erro: " + ex);
        }
        conVst.desconecta();
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

    public void ExcluirVisitante(ModeloVisitantes mod) {

        conVst.conexao();
        try {
            PreparedStatement pstVst = (PreparedStatement) conVst.conn.prepareStatement("delete from tab_visitantes where cod_vis=?");
            pstVst.setInt(1, mod.getCodVst());
            pstVst.execute();
            JOptionPane.showMessageDialog(null, "O visitante : " + mod.getNomeVst() + " foi excluído com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o visitante!!\n Erro: " + ex);
        }
        conVst.desconecta();
    }

    public void AlterarVisitante(ModeloVisitantes mod) {

        achaPessoa(mod.getNomeVst());
        conVst.conexao();
        try {
            PreparedStatement pstVst = (PreparedStatement) conVst.conn.prepareStatement("update tab_visitantes set cod_ps =?,obs_vis =? where cod_vis=?");
            pstVst.setInt(1, codPs);
            pstVst.setString(2, mod.getObs());
            pstVst.setInt(3, mod.getCodVst());
            pstVst.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o visitante!!\n Erro: " + ex);
        }
        conVst.desconecta();
    }
}

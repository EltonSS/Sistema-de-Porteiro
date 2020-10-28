package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloUsuario;

public class ControleUsuario {

    ConectaBanco conUsuario = new ConectaBanco();
    ModeloUsuario mod = new ModeloUsuario();
    int codTipoUsuario;

    public void InserirUsuario(ModeloUsuario mod) {

        achaTipoUsuario(mod.getNomeTipoUsu());
        conUsuario.conexao();
        try {
            PreparedStatement pstUsuario = (PreparedStatement) conUsuario.conn.prepareStatement("insert into tab_usuarios (login_usu,senha_usu,cod_tipo_usu,Perm_MenuCad_Mor,"
                    + "Perm_MenuCad_Hosp,Perm_MenuCad_Vis,Perm_MenuCad_PrestServ,Perm_MenuCad_Func,Perm_MenuCad_Port,Perm_MenuCad_Veic,Perm_MenuCad_Chav,"
                    + "Perm_MenuCons_Port,Perm_MenuCtrl_AcessoVeic,Perm_MenuCtrl_AcessoPs,Perm_MenuCtrl_Chav,Perm_MenuCad_Lembrete,Perm_MenuCad_Agenda,"
                    + "Perm_MenuAlt_SenhaSist,Perm_MenuAlt_SenhaPort,Perm_MenuCtrl_Chav,Perm_MenuCad_Emp) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pstUsuario.setString(1, mod.getLoginUsu());
            pstUsuario.setString(2, mod.getSenhaUsu());
            pstUsuario.setInt(3, codTipoUsuario);
            pstUsuario.setString(4, mod.getPermMenuMr());
            pstUsuario.setString(5, mod.getPermMenuHsp());
            pstUsuario.setString(6, mod.getPermMenuVis());
            pstUsuario.setString(7, mod.getPermMenuPrestServ());
            pstUsuario.setString(8, mod.getPermMenuFunc());
            pstUsuario.setString(9, mod.getPermMenuPort());
            pstUsuario.setString(10, mod.getPermMenuVc());
            pstUsuario.setString(11, mod.getPermMenuChv());
            pstUsuario.setString(12, mod.getPermMenuConsPort());
            pstUsuario.setString(13, mod.getPermMenuCtrlAcesVc());
            pstUsuario.setString(14, mod.getPermMenuCtrlAcesPs());
            pstUsuario.setString(15, mod.getPermMenuCtrlChv());
            pstUsuario.setString(16, mod.getPermMenuLbt());
            pstUsuario.setString(17, mod.getPermMenuAgd());
            pstUsuario.setString(18, mod.getPermMenuAltSnhaSist());
            pstUsuario.setString(19, mod.getPermMenuAltSnhaPort());
            pstUsuario.setString(20, mod.getPermMenuEmp());
            pstUsuario.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o usuário!!\n Erro: " + ex);
        }
        conUsuario.desconecta();
    }

    public void achaTipoUsuario(String NomeTipoUsu) {

        conUsuario.conexao();
        try {
            conUsuario.executaSQL("select * from tab_tipo_usuarios where descricao_tipo_usu ='" + NomeTipoUsu + "' ");
            conUsuario.rs.first();
            codTipoUsuario = conUsuario.rs.getInt("cod_tipo_usu");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar buscar o código do tipo do usuário!!\n Erro: " + ex);
        }
        conUsuario.desconecta();
    }

    public void ExcluirUsuario(ModeloUsuario mod) {

        conUsuario.conexao();
        try {
            String nome = "Você deseja deletar o usuário : " + mod.getLoginUsu() + " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstUsuario = (PreparedStatement) conUsuario.conn.prepareStatement("delete from tab_usuarios where login_usu=?");
                pstUsuario.setString(1, mod.getLoginUsu());
                pstUsuario.execute();
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a cidade!!\n Erro: " + ex);
        }
        conUsuario.desconecta();
    }

    public void AlterarUsuario(ModeloUsuario mod) {

        achaTipoUsuario(mod.getNomeTipoUsu());
        conUsuario.conexao();
        try {
            PreparedStatement pstUsuario = (PreparedStatement) conUsuario.conn.prepareStatement("update tab_usuarios set senha_usu = ?,cod_tipo_usu = ?,Perm_MenuCad_Mor = ?,Perm_MenuCad_Hosp = ?,Perm_MenuCad_Vis = ?,Perm_MenuCad_PrestServ = ?,"
                    + "Perm_MenuCad_Func = ?,Perm_MenuCad_Port = ?,Perm_MenuCad_Veic = ?,Perm_MenuCad_Chav = ?,Perm_MenuCons_Port = ?,Perm_MenuCtrl_AcessoVeic = ?,Perm_MenuCtrl_AcessoPs = ?,Perm_MenuCtrl_Chav = ?,Perm_MenuCad_Lembrete = ?,"
                    + "Perm_MenuCad_Agenda = ?,Perm_MenuAlt_SenhaSist = ?,Perm_MenuAlt_SenhaPort = ?,Perm_MenuCad_Emp = ? where login_usu = ?");
            pstUsuario.setString(1, mod.getSenhaUsu());
            pstUsuario.setInt(2, codTipoUsuario);
            pstUsuario.setString(3, mod.getPermMenuMr());
            pstUsuario.setString(4, mod.getPermMenuHsp());
            pstUsuario.setString(5, mod.getPermMenuVis());
            pstUsuario.setString(6, mod.getPermMenuPrestServ());
            pstUsuario.setString(7, mod.getPermMenuFunc());
            pstUsuario.setString(8, mod.getPermMenuPort());
            pstUsuario.setString(9, mod.getPermMenuVc());
            pstUsuario.setString(10, mod.getPermMenuChv());
            pstUsuario.setString(11, mod.getPermMenuConsPort());
            pstUsuario.setString(12, mod.getPermMenuCtrlAcesVc());
            pstUsuario.setString(13, mod.getPermMenuCtrlAcesPs());
            pstUsuario.setString(14, mod.getPermMenuCtrlChv());
            pstUsuario.setString(15, mod.getPermMenuLbt());
            pstUsuario.setString(16, mod.getPermMenuAgd());
            pstUsuario.setString(17, mod.getPermMenuAltSnhaSist());
            pstUsuario.setString(18, mod.getPermMenuAltSnhaPort());
            pstUsuario.setString(19, mod.getPermMenuEmp());
            pstUsuario.setString(20, mod.getLoginUsu());
            pstUsuario.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o registro!!\n Erro: " + ex);
        }
        conUsuario.desconecta();
    }
    
    public void AlterarLoginSenhaUsuario(ModeloUsuario mod) {

        conUsuario.conexao();
        try {
            PreparedStatement pstUsuario = (PreparedStatement) conUsuario.conn.prepareStatement("update tab_usuarios set senha_usu =? where login_usu=?");
            pstUsuario.setString(1, mod.getSenhaUsuNova());
            pstUsuario.setString(2, mod.getLoginUsu());
            pstUsuario.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a senha do usuário!!\n Erro: " + ex);
        }
        conUsuario.desconecta();
    }
}

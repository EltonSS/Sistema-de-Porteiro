
package ControleSistema;


import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloTipoUsuario;

public class ControleTipoUsuario {
       
    ConectaBanco conTipoUsuario = new ConectaBanco();
    ModeloTipoUsuario mod = new ModeloTipoUsuario();
    
    public void InserirTipoUsuario(ModeloTipoUsuario mod){
            
            conTipoUsuario.conexao();
         try {
            PreparedStatement pstTipoUsuario = (PreparedStatement)conTipoUsuario.conn.prepareStatement("insert into tab_tipo_usuarios (descricao_tipo_usu) values (?)");
            pstTipoUsuario.setString(1,mod.getDescricaoTipoUsuario());
            pstTipoUsuario.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar inserir o tipo de usuário!!\n Erro: "+ex);
         }  conTipoUsuario.desconecta();
            
    }  
         
    public void ExcluirTipoUsuario(ModeloTipoUsuario mod){
            conTipoUsuario.conexao();
         try {
             String nome = "Você deseja deletar o tipo usuário : "+mod.getDescricaoTipoUsuario()+" ?";
             int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
             if (opcao_escolhida == JOptionPane.YES_OPTION){         
             PreparedStatement pstTipoUsuario = (PreparedStatement)conTipoUsuario.conn.prepareStatement("delete from tab_tipo_usuarios where cod_tipo_usu=?");
             pstTipoUsuario.setInt(1,mod.getCodTipoUsuario());
             pstTipoUsuario.execute();   
            }else               
             return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar excluir o tipo de usuario!!\n Erro: "+ex);
         }
            conTipoUsuario.desconecta();
    }
    public void AlterarTipoUsuario(ModeloTipoUsuario mod){
            
            conTipoUsuario.conexao();
         try {
            PreparedStatement pstTipoUsuario = (PreparedStatement)conTipoUsuario.conn.prepareStatement("update tab_tipo_usuarios set descricao_tipo_usu =? where cod_tipo_usu=?");
            pstTipoUsuario.setString(1,mod.getDescricaoTipoUsuario());
            pstTipoUsuario.setInt(2,mod.getCodTipoUsuario());
            pstTipoUsuario.execute();            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao tentar alterar o registro!!\n Erro: "+ex);
         } 
           conTipoUsuario.desconecta();
    }
    public ModeloTipoUsuario pesquisaTipoUsuario(ModeloTipoUsuario modelo){
            conTipoUsuario.conexao();
            conTipoUsuario.executaSQL("select * from tab_tipo_usuarios where descricao_tipo_usu like '%"+modelo.getPesquisaTipoUsuario()+"%'");
          try {
            conTipoUsuario.rs.first();
            mod.setCodTipoUsuario(conTipoUsuario.rs.getInt("cod_tipo_usu"));
            mod.setDescricaoTipoUsuario(conTipoUsuario.rs.getString("descricao_tipo_usu"));
            
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Tipo de usuário não encontrado!!");
         }
            conTipoUsuario.desconecta(); 
            return mod;
    } 
}
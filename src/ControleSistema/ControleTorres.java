package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloTorre;

public class ControleTorres {

    ConectaBanco conTrr = new ConectaBanco();
    ModeloTorre modTrr = new ModeloTorre();
    
    public void InserirTorre(ModeloTorre mod){
            
            conTrr.conexao();
         try {
            PreparedStatement pstTrr = (PreparedStatement)conTrr.conn.prepareStatement("insert into tab_torres (desc_trr) values (?)");
            pstTrr.setString(1,mod.getDescTrr());
            pstTrr.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar inserir a torre!!\n Erro: "+ex);
         }  conTrr.desconecta();            
    }  
         
    public void ExcluirTorre(ModeloTorre mod){
            
            conTrr.conexao();
         try {
             String nome = "Você deseja deletar a torre : "+mod.getDescTrr()+" ?";
             int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
             if (opcao_escolhida == JOptionPane.YES_OPTION){         
             PreparedStatement pstTrr = (PreparedStatement)conTrr.conn.prepareStatement("delete from tab_torres where cod_trr=?");
             pstTrr.setInt(1,mod.getCodTrr());
             pstTrr.execute();   
            }else               
             return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar excluir a torre!!\n Erro: "+ex);
         }
            conTrr.desconecta();
    }
    public void AlterarTorre(ModeloTorre mod){
            
            conTrr.conexao();
         try {
            PreparedStatement pstTrr = (PreparedStatement)conTrr.conn.prepareStatement("update tab_torres set desc_trr =? where cod_trr=?");
            pstTrr.setString(1,mod.getDescTrr());
            pstTrr.setInt(2,mod.getCodTrr());
            pstTrr.execute();            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao tentar alterar o registro!!\n Erro: "+ex);
         } 
           conTrr.desconecta();
    }   
}
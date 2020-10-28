package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloTipoPessoa;

public class ControleTipoPessoas {

    ConectaBanco conTpPs = new ConectaBanco();
    ModeloTipoPessoa modTpPs = new ModeloTipoPessoa();
    
    public void InserirTipoPessoa(ModeloTipoPessoa mod){
            
            conTpPs.conexao();
         try {
            PreparedStatement pstTpPs = (PreparedStatement)conTpPs.conn.prepareStatement("insert into tab_tipos_pessoas (desc_tp_ps) values (?)");
            pstTpPs.setString(1,mod.getDescTpPs());
            pstTpPs.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar inserir o tipo de pessoa!!\n Erro: "+ex);
         }  conTpPs.desconecta();            
    }  
         
    public void ExcluirTipoPessoa(ModeloTipoPessoa mod){
            
            conTpPs.conexao();
         try {
             String nome = "Você deseja deletar o tipo de pessoa : "+mod.getDescTpPs()+" ?";
             int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
             if (opcao_escolhida == JOptionPane.YES_OPTION){         
             PreparedStatement pstTpPs = (PreparedStatement)conTpPs.conn.prepareStatement("delete from tab_tipos_pessoas where cod_tp_ps=?");
             pstTpPs.setInt(1,mod.getCodTpPs());
             pstTpPs.execute();   
            }else               
             return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar excluir o tipo de pessoa!!\n Erro: "+ex);
         }
            conTpPs.desconecta();
    }
    public void AlterarTipoPessoa(ModeloTipoPessoa mod){
            
            conTpPs.conexao();
         try {
            PreparedStatement pstTpPs = (PreparedStatement)conTpPs.conn.prepareStatement("update tab_tipos_pessoas set desc_tp_ps =? where cod_tp_ps=?");
            pstTpPs.setString(1,mod.getDescTpPs());
            pstTpPs.setInt(2,mod.getCodTpPs());
            pstTpPs.execute();            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao tentar alterar o registro!!\n Erro: "+ex);
         } 
           conTpPs.desconecta();
    }   
}
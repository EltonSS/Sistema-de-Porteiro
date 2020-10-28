package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloApartamento;

public class ControleApartamentos {
       
    ConectaBanco conApt = new ConectaBanco();
    ConectaBanco conTrr = new ConectaBanco();
    ModeloApartamento modApt = new ModeloApartamento();
    int codTrr; 
    
    public void InserirApartamentos(ModeloApartamento mod){
            
            achaTorre(mod.getDescTrr());
            conApt.conexao();
         try {
            PreparedStatement pstApt = (PreparedStatement)conApt.conn.prepareStatement("insert into tab_apartamentos (num_apt,ramal_apt,cod_trr) values (?,?,?)");
            pstApt.setString(1,mod.getNumApt());
            pstApt.setString(2,mod.getRamalApt());
            pstApt.setInt(3,codTrr);
            pstApt.execute();
            //JOptionPane.showMessageDialog(null,"Registro Inseridos com Sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar inserir o apartamento!!\n Erro: "+ex);
         }  conApt.desconecta();
            
    }  public void achaTorre(String descTrr){
            
            conTrr.conexao();            
         try {
            conTrr.executaSQL("select * from tab_torres where desc_trr ='"+descTrr+"' ");
            conTrr.rs.first();
            codTrr = conTrr.rs.getInt("cod_trr");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao tentar buscar o código da torre!!\n Erro: "+ex);
        }   conTrr.desconecta();
    }       
    
    public void ExcluirApartamentos(ModeloApartamento mod){
            
            conApt.conexao();
         try {
             String nome = "Você deseja deletar o apartamento : "+mod.getNumApt()+" ?";
             int opcao_escolhida = JOptionPane.showConfirmDialog(null,nome,"",JOptionPane.YES_NO_OPTION);
             if (opcao_escolhida == JOptionPane.YES_OPTION){         
             PreparedStatement pstApt = (PreparedStatement)conApt.conn.prepareStatement("delete from tab_apartamentos where cod_apt=?");
             pstApt.setInt(1,mod.getCodApt());
             pstApt.execute();   
            }else               
             return;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar excluir o apartamento!!\n Erro: "+ex);
         }
            conApt.desconecta();
    }
    
    public void AlterarApartamentos(ModeloApartamento mod){
           
            achaTorre(mod.getDescTrr());
            conApt.conexao();
         try {
            PreparedStatement pstApt = (PreparedStatement)conApt.conn.prepareStatement("update tab_apartamentos set num_apt =?,ramal_apt =?,cod_trr =? where cod_apt=?");
            pstApt.setString(1,mod.getNumApt());
            pstApt.setString(2,mod.getRamalApt()); 
            pstApt.setInt(3,codTrr);
            pstApt.setInt(4,mod.getCodApt());
            pstApt.execute();            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,"Erro ao tentar alterar o registro!!\n Erro: "+ex);
         } 
           conApt.desconecta();
    }
    
}
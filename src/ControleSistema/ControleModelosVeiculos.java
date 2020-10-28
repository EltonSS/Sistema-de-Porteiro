package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloModelosVeiculos;

public class ControleModelosVeiculos {

    ConectaBanco conMd = new ConectaBanco();
    ConectaBanco conMc = new ConectaBanco();
    ModeloModelosVeiculos mod = new ModeloModelosVeiculos();
    int codMc;

    public void InserirModeloVeiculo(ModeloModelosVeiculos mod) {

        achaMarcaVeiculo(mod.getDescMc());
        conMd.conexao();
        try {
            PreparedStatement pstMod = (PreparedStatement) conMd.conn.prepareStatement("insert into Tab_Modelo_Veiculos (desc_md,cod_mc) values(?,?)");
            pstMod.setString(1, mod.getDescMod());
            pstMod.setInt(2, codMc);
            pstMod.execute();
            JOptionPane.showMessageDialog(null, "O modelo deo veículo : " + mod.getDescMod()+ " foi registrado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o modelo do veículo!!\n Erro: " + ex);
        }
        conMd.desconecta();
    }

    public void achaMarcaVeiculo(String descMcVc) {

        conMc.conexao();
        conMc.executaSQL("select * from tab_marca_veiculos where desc_mc ='" + descMcVc + "'");
        try {
            conMc.rs.first();
            codMc = conMc.rs.getInt("cod_mc");
        } catch (SQLException ex) {
            Logger.getLogger(ControleModelosVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMc.desconecta();
    }

    public void ExcluirModelosVeiculos(ModeloModelosVeiculos mod) {

        conMd.conexao();
        try {
            String nome = "Você deseja deletar o modelo do veículo " + mod.getDescMod()+ " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstMod = (PreparedStatement) conMd.conn.prepareStatement("delete from Tab_Modelo_Veiculos where cod_md =?");
                pstMod.setInt(1, mod.getCodMod());
                pstMod.execute();
                JOptionPane.showMessageDialog(null, "O modelo do veículo : " + mod.getDescMod()+ " foi excluído com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o modelo do veículo!!\n Erro: " + ex);
        }
        conMd.desconecta();
    }

    public void AlterarModelosVeiculos(ModeloModelosVeiculos mod) {

        achaMarcaVeiculo(mod.getDescMc());
        conMd.conexao();
        try {
            PreparedStatement pstMod = (PreparedStatement) conMd.conn.prepareStatement("update Tab_Modelo_Veiculos set desc_md=?,cod_mc=? where cod_md=?");
            pstMod.setString(1, mod.getDescMod());
            pstMod.setInt(2, codMc);
            pstMod.setInt(3, mod.getCodMod());
            pstMod.execute();
            JOptionPane.showMessageDialog(null, "O modelo do veículo : " + mod.getDescMod()+ " foi alterado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o modelo do veículo!!\n Erro: " + ex);
        }
        conMd.desconecta();
    }
}

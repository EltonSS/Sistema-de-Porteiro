package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloMarcaVeiculo;

public class ControleMarcaVeiculo {

    ConectaBanco conMc  = new ConectaBanco();
    ModeloMarcaVeiculo mod = new ModeloMarcaVeiculo();

    public void InserirMarcaVeiculo(ModeloMarcaVeiculo mod) {

        conMc.conexao();
        try {
            PreparedStatement pstMc = (PreparedStatement) conMc.conn.prepareStatement("insert into tab_marca_veiculos (desc_mc) values (?)");
            pstMc.setString(1, mod.getDescMc());
            pstMc.execute();
            JOptionPane.showMessageDialog(null, "A marca do veículo " + mod.getDescMc()+ " foi registrado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir a marca do veículo!!\n Erro: " + ex);
        }
        conMc.desconecta();
    }

    public void ExcluirMarcaVeiculo(ModeloMarcaVeiculo mod) {

        conMc.conexao();
        try {
            String nome = "Você deseja deletar a marca do veículo : " + mod.getDescMc()+ " ?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstMc = (PreparedStatement) conMc.conn.prepareStatement("delete from tab_marca_veiculos where cod_mc =?");
                pstMc.setInt(1, mod.getCodMc());
                pstMc.execute();
                JOptionPane.showMessageDialog(null, "A marca do veículo " + mod.getDescMc()+ " foi excluído com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a marca do veículo!!\n Erro: " + ex);
        }
        conMc.desconecta();
    }

    public void AlterarMarcaVeiculo(ModeloMarcaVeiculo mod) {

        conMc.conexao();
        try {
            PreparedStatement pstMc = (PreparedStatement) conMc.conn.prepareStatement("update tab_marca_veiculos set desc_mc =? where cod_mc=?");
            pstMc.setString(1, mod.getDescMc());
            pstMc.setInt(2, mod.getCodMc());
            pstMc.execute();
            JOptionPane.showMessageDialog(null, "A marca do veículo : " + mod.getDescMc()+ " foi alterado com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar a marca do veículo!!\n Erro: " + ex);
        }
        conMc.desconecta();
    }
}

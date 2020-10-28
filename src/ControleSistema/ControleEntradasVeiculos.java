package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloEntradasVeiculos;

public class ControleEntradasVeiculos {

    ConectaBanco conEntVc = new ConectaBanco();
    ConectaBanco conVc = new ConectaBanco();
    ConectaBanco conMc = new ConectaBanco();
    ConectaBanco conMd = new ConectaBanco();
    ConectaBanco conTpVc = new ConectaBanco();
    ConectaBanco conVs = new ConectaBanco();
    ConectaBanco conCor = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conPort = new ConectaBanco();
    int codVc, codMc, codMd, codTpVc, codVs, codPs, codCor, codPort;

    public void InserirEntradaVeiculo(ModeloEntradasVeiculos mod) {

        achaVeiculo(mod.getPlacaVc());        
        achaPorteiro(mod.getNomePort());
        conEntVc.conexao();
        try {
            PreparedStatement pstEntVeiculo = (PreparedStatement) conEntVc.conn.prepareStatement("insert into Tab_Entradas_Veiculos (Data_Ent_Vc,Hora_Ent_Vc,Obs_Ent_Vc,Cod_Port,Cod_Vc,Cod_Mc,Cod_Md,Cod_Cor,Cod_Ps,Entrou) values (?,?,?,?,?,?,?,?,?,?)");
            pstEntVeiculo.setString(1, mod.getDataEnt());
            pstEntVeiculo.setString(2, mod.getHoraEnt());
            pstEntVeiculo.setString(3, mod.getObsEnt());
            pstEntVeiculo.setInt(4, codPort);
            pstEntVeiculo.setInt(5, codVc);
            pstEntVeiculo.setInt(6, codMc);
            pstEntVeiculo.setInt(7, codMd);
            pstEntVeiculo.setInt(8, codCor);
            pstEntVeiculo.setInt(9, codPs);
            pstEntVeiculo.setInt(10, mod.getEntrou());
            pstEntVeiculo.execute();
        } catch (SQLException ex) {            
        }
        conEntVc.desconecta();
    }

    public void achaVeiculo(String numPlaca) {

        conVc.conexao();
        conVc.executaSQL("select * from vw_veiculo where placa_vc ='" + numPlaca + "'");
        try {
            conVc.rs.first();
            codVc = conVc.rs.getInt("cod_vc");
            codMc = conVc.rs.getInt("cod_mc");
            codMd = conVc.rs.getInt("cod_md");
            codCor = conVc.rs.getInt("cod_cor");
            codPs = conVc.rs.getInt("cod_ps");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradasVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conVc.desconecta();
    }

    public void achaPorteiro(String nomePort) {

        conPort.conexao();
        conPort.executaSQL("select * from tab_porteiros where nome_port ='" + nomePort + "'");
        try {
            conPort.rs.first();
            codPort = conPort.rs.getInt("cod_port");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradasVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPort.desconecta();
    }

    public void ExcluirEntradaVeiculo(ModeloEntradasVeiculos mod) {

        conEntVc.conexao();
        try {
            String nome = "Você deseja deletar o veículo " + mod.getDescMd() + " do condomínio?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstEntVeiculo = (PreparedStatement) conEntVc.conn.prepareStatement("delete from Tab_Entradas_Veiculos where cod_ent_vc =?");
                pstEntVeiculo.setInt(1, mod.getCodEnt());
                pstEntVeiculo.execute();
                JOptionPane.showMessageDialog(null, "Foi excluída a entrada do veículo da placa : " + mod.getPlacaVc() + " com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a entrada do veículo do condomínio!!\n Erro: " + ex);
        }
        conEntVc.desconecta();
    }
    
    public void AlterarEntradaVeiculo(ModeloEntradasVeiculos mod) {

        conEntVc.conexao();
        try {
            PreparedStatement pstEstoque = (PreparedStatement) conEntVc.conn.prepareStatement("update tab_entradas_veiculos set Entrou=? where cod_ent_vc=?");
            pstEstoque.setInt(1, mod.getEntrou());
            pstEstoque.setInt(2, mod.getCodEnt());
            pstEstoque.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de entradas de veículos!!\n Erro: " + ex);
        }
        conEntVc.desconecta();
    }
}

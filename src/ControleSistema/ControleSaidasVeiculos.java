package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloSaidasVeiculos;

public class ControleSaidasVeiculos {

    ConectaBanco conSaidVc = new ConectaBanco();
    ConectaBanco conVc = new ConectaBanco();
    ConectaBanco conMc = new ConectaBanco();
    ConectaBanco conMd = new ConectaBanco();
    ConectaBanco conTpVc = new ConectaBanco();
    ConectaBanco conVs = new ConectaBanco();
    ConectaBanco conCor = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conPort = new ConectaBanco();
    int codVc, codMc, codMd, codTpVc, codVs, codPs, codCor, codPort;

    public void InserirSaidaVeiculo(ModeloSaidasVeiculos mod) {

        achaVeiculo(mod.getPlacaVc());        
        achaPorteiro(mod.getNomePort());
        conSaidVc.conexao();
        try {
            PreparedStatement pstSaidVeiculo = (PreparedStatement) conSaidVc.conn.prepareStatement("insert into Tab_Saidas_Veiculos (Data_Said_Vc,Hora_Said_Vc,Obs_Said_Vc,Cod_Port,Cod_Vc,Cod_Mc,Cod_Md,Cod_Cor,Cod_Ps) values (?,?,?,?,?,?,?,?,?)");
            pstSaidVeiculo.setString(1, mod.getDataSaid());
            pstSaidVeiculo.setString(2, mod.getHoraSaid());
            pstSaidVeiculo.setString(3, mod.getObsSaid());
            pstSaidVeiculo.setInt(4, codPort);
            pstSaidVeiculo.setInt(5, codVc);
            pstSaidVeiculo.setInt(6, codMc);
            pstSaidVeiculo.setInt(7, codMd);
            pstSaidVeiculo.setInt(8, codCor);
            pstSaidVeiculo.setInt(9, codPs);
            pstSaidVeiculo.execute();            
        } catch (SQLException ex) {  
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a saída do veículo do condomínio!!");
        }
        conSaidVc.desconecta();
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
            Logger.getLogger(ControleSaidasVeiculos.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ControleSaidasVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPort.desconecta();
    }

    public void ExcluirSaidaVeiculo(ModeloSaidasVeiculos mod) {

        conSaidVc.conexao();
        try {
            String nome = "Você deseja deletar o veículo " + mod.getDescMd() + " do condomínio?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstSaidVeiculo = (PreparedStatement) conSaidVc.conn.prepareStatement("delete from Tab_Entradas_Veiculos where cod_ent_vc =?");
                pstSaidVeiculo.setInt(1, mod.getCodEnt());
                pstSaidVeiculo.execute();
                JOptionPane.showMessageDialog(null, "Foi excluída a entrada do veículo da placa : " + mod.getPlacaVc() + " com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir a entrada do veículo do condomínio!!\n Erro: " + ex);
        }
        conSaidVc.desconecta();
    }    
}

package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloVeiculos;

public class ControleVeiculos {

    ConectaBanco conVc = new ConectaBanco();
    ConectaBanco conMc = new ConectaBanco();
    ConectaBanco conMd = new ConectaBanco();
    ConectaBanco conTpVc = new ConectaBanco();
    ConectaBanco conVs = new ConectaBanco();
    ConectaBanco conCor = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    int codVc, codMc, codMd, codTpVc, codVs, codPs, codCor;

    public void InserirVeiculo(ModeloVeiculos mod) {

        achaMarcaVeiculo(mod.getDescMc());
        achaModeloVeiculo(mod.getDescMd());
        achaPessoa(mod.getNomePs());
        achaCores(mod.getDescCor());
        conVc.conexao();
        try {
            PreparedStatement pstVeiculo = (PreparedStatement) conVc.conn.prepareStatement("insert into tab_veiculos (cod_mc,cod_md,cod_cor,cod_ps,detalhes_prop,placa_vc) values (?,?,?,?,?,?)");
            pstVeiculo.setInt(1, codMc);
            pstVeiculo.setInt(2, codMd);
            pstVeiculo.setInt(3, codCor);
            pstVeiculo.setInt(4, codPs);
            pstVeiculo.setString(5, mod.getDetalhesProp());
            pstVeiculo.setString(6, mod.getPlacaVc());
            pstVeiculo.execute();
            JOptionPane.showMessageDialog(null, "O veículo : " + mod.getDescMd() + " foi registrado estoque com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o veículo no condomínio!!\n Erro: " + ex);
        }
        conVc.desconecta();
    }
    
    public void achaMarcaVeiculo(String descMarcaVc) {

        conMc.conexao();
        conMc.executaSQL("select * from tab_marca_veiculos where desc_mc ='" + descMarcaVc + "'");
        try {
            conMc.rs.first();
            codMc = conMc.rs.getInt("cod_mc");
        } catch (SQLException ex) {
            Logger.getLogger(ControleEntradasVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMc.desconecta();
    }

    public void achaModeloVeiculo(String descModeloVc) {

        conMd.conexao();
        conMd.executaSQL("select * from tab_modelo_veiculos where desc_md ='" + descModeloVc + "'");
        try {
            conMd.rs.first();
            codMd = conMd.rs.getInt("cod_md");
        } catch (SQLException ex) {
            Logger.getLogger(ControleVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conMd.desconecta();
    }

    public void achaPessoa(String nomePs) {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + nomePs + "'");
        try {
            conPs.rs.first();
            codPs = conPs.rs.getInt("cod_ps");
        } catch (SQLException ex) {
            Logger.getLogger(ControleVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPs.desconecta();
    }

    public void achaCores(String descCor) {

        conCor.conexao();
        conCor.executaSQL("select * from tab_cores where desc_cor ='" + descCor + "'");
        try {
            conCor.rs.first();
            codCor = conCor.rs.getInt("cod_cor");
        } catch (SQLException ex) {
            Logger.getLogger(ControleVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        conCor.desconecta();
    }

    public void ExcluirVeiculo(ModeloVeiculos mod) {

        conVc.conexao();
        try {
            String nome = "Você deseja deletar o veículo " + mod.getDescMd() + " do condomínio?";
            int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
            if (opcao_escolhida == JOptionPane.YES_OPTION) {
                PreparedStatement pstVeiculo = (PreparedStatement) conVc.conn.prepareStatement("delete from tab_veiculos where cod_vc =?");
                pstVeiculo.setInt(1, mod.getCodVc());
                pstVeiculo.execute();
                JOptionPane.showMessageDialog(null, "O veículo : " + mod.getDescMd() + " foi excluído do condomínio com sucesso!!");
            } else {
                return;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o veículo do condomínio!!\n Erro: " + ex);
        }
        conVc.desconecta();
    }

    public void AlterarVeiculo(ModeloVeiculos mod) {

        achaMarcaVeiculo(mod.getDescMc());
        achaModeloVeiculo(mod.getDescMd());
        achaPessoa(mod.getNomePs());
        achaCores(mod.getDescCor());
        conVc.conexao();
        try {
            PreparedStatement pstVeiculo = (PreparedStatement) conVc.conn.prepareStatement("update tab_veiculos set cod_mc=?,cod_md=?,cod_cor=?,cod_ps=?,detalhes_prop=?,placa_vc=? where cod_vc=?");
            pstVeiculo.setInt(1, codMc);
            pstVeiculo.setInt(2, codMd);
            pstVeiculo.setInt(3, codCor);
            pstVeiculo.setInt(4, codPs);
            pstVeiculo.setString(5, mod.getDetalhesProp());
            pstVeiculo.setString(6, mod.getPlacaVc());
            pstVeiculo.setInt(7, mod.getCodVc());
            pstVeiculo.execute();
            JOptionPane.showMessageDialog(null, "O veículo : " + mod.getDescMd() + " foi alterado no condomínio com sucesso!!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o veículo do condomínio!!\n Erro: " + ex);
        }
        conVc.desconecta();
    }
}

package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloSaidasPessoas;

public class ControleSaidasPessoas {

    ConectaBanco conSaidPs = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conPort = new ConectaBanco();
    int codTpPs, codPs, codPort;
    String rgPs;

    public void InserirSaidaPessoa(ModeloSaidasPessoas mod) {

        achaPessoa(mod.getNomePs());
        achaPorteiro(mod.getNomePort());
        conSaidPs.conexao();
        try {
            PreparedStatement pstSaidPessoa = (PreparedStatement) conSaidPs.conn.prepareStatement("insert into Tab_Saidas_Pessoas (Data_Said_Ps,Hora_Said_Ps,Obs_Said_Ps,Cod_Port,Rg_Ps,Cod_Ps,Detalhes_Ps,Cod_Tp_Ps) values (?,?,?,?,?,?,?,?)");
            pstSaidPessoa.setString(1, mod.getDataSaid());
            pstSaidPessoa.setString(2, mod.getHoraSaid());
            pstSaidPessoa.setString(3, mod.getObsSaid());
            pstSaidPessoa.setInt(4, codPort);
            pstSaidPessoa.setString(5, rgPs);
            pstSaidPessoa.setInt(6, codPs);
            pstSaidPessoa.setString(7, mod.getDetalhesPs());
            pstSaidPessoa.setInt(8, codTpPs);
            pstSaidPessoa.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar a saída da pessoa do condomínio!!");
        }
        conSaidPs.desconecta();
    }

    public void achaPessoa(String nomePs) {

        conPs.conexao();
        conPs.executaSQL("select * from vw_pessoa where nome_ps ='" + nomePs + "'");
        try {
            conPs.rs.first();
            codPs = conPs.rs.getInt("cod_ps");
            codTpPs = conPs.rs.getInt("cod_tp_ps");
            rgPs = conPs.rs.getString("rg_ps");
        } catch (SQLException ex) {
            Logger.getLogger(ControleSaidasPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPs.desconecta();
    }

    public void achaPorteiro(String nomePort) {

        conPort.conexao();
        conPort.executaSQL("select * from tab_porteiros where nome_port ='" + nomePort + "'");
        try {
            conPort.rs.first();
            codPort = conPort.rs.getInt("cod_port");
        } catch (SQLException ex) {
            Logger.getLogger(ControleSaidasPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        conPort.desconecta();
    }
}

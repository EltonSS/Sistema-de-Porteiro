package ControleSistema;

import ModeloSistema.ModeloEntregaChaves;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControleEntregaChaves {

    ConectaBanco conSaidPs = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conPort = new ConectaBanco();
    ConectaBanco conChv = new ConectaBanco();
    String RgPs;

    public void InserirEntregaChaves(ModeloEntregaChaves mod) {

        conSaidPs.conexao();
        try {
            PreparedStatement pstEntChv = (PreparedStatement) conSaidPs.conn.prepareStatement("insert into Tab_Entrega_Chaves (Data_Ent_Chv,Hora_Ent_Chv,Obs_Ent_Chv,Cod_Port,Cod_Ps,Detalhes_Ps,Cod_Chv,Cod_Set) values (?,?,?,?,?,?,?,?)");
            pstEntChv.setString(1, mod.getDataEntChv());
            pstEntChv.setString(2, mod.getHoraEntChv());
            pstEntChv.setString(3, mod.getObsEntregaChave());
            pstEntChv.setInt(4, mod.getCodPort());
            pstEntChv.setInt(5, mod.getCodPs());
            pstEntChv.setString(6, mod.getDetalhesPs());
            pstEntChv.setInt(7, mod.getCodChv());
            pstEntChv.setInt(8, mod.getCodSetor());
            pstEntChv.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar salvar a entrega da chave!!\n Erro: " + ex);
        }
        conSaidPs.desconecta();
    }
}

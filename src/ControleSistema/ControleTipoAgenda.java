package ControleSistema;

import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloTipoAgenda;

public class ControleTipoAgenda {

    ConectaBanco conTpAgdComp = new ConectaBanco();
    ConectaBanco conTpAgdCont = new ConectaBanco();
    ConectaBanco conTrr = new ConectaBanco();
    ConectaBanco conApt = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();

    public void InserirTipoAgendaCompromisso(ModeloTipoAgenda mod) {

        conTpAgdComp.conexao();
        try {
            PreparedStatement pstTpAgdComp = (PreparedStatement) conTpAgdComp.conn.prepareStatement("insert into Tab_Tipo_Agenda_Compromisso (Desc_Tp_Agd_Comp) values (?)");
            pstTpAgdComp.setString(1, mod.getDescTpAgdComp());
            pstTpAgdComp.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir o tipo da agenda de compromisso!!\n Erro: " + ex);
        }
        conTpAgdComp.desconecta();
    }

    public void InserirTipoAgendaContato(ModeloTipoAgenda mod) {

        conTpAgdCont.conexao();
        try {
            PreparedStatement pstTpAgdCont = (PreparedStatement) conTpAgdCont.conn.prepareStatement("insert into Tab_Tipo_Agenda_Contato (Desc_Tp_Agd_Cont) values (?)");
            pstTpAgdCont.setString(1, mod.getDescTpAgdCont());
            pstTpAgdCont.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar inserir  o tipo da agenda de contato!!\n Erro: " + ex);
        }
        conTpAgdCont.desconecta();
    }

    public void ExcluirTipoAgendaCompromisso(ModeloTipoAgenda mod) {

        conTpAgdComp.conexao();
        try {
            PreparedStatement pstTpAgdComp = (PreparedStatement) conTpAgdComp.conn.prepareStatement("delete from Tab_Tipo_Agenda_Compromisso where Cod_Tp_Agd_Comp = ?");
            pstTpAgdComp.setInt(1, mod.getCodTpAgdComp());
            pstTpAgdComp.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o tipo de agenda de compromisso!!\n Erro: " + ex);
        }
        conTpAgdComp.desconecta();
    }

    public void ExcluirTipoAgendaContato(ModeloTipoAgenda mod) {

        conTpAgdComp.conexao();
        try {
            PreparedStatement pstTpAgdCont = (PreparedStatement) conTpAgdComp.conn.prepareStatement("delete from Tab_Tipo_Agenda_Contato where Cod_Tp_Agd_Cont = ?");
            pstTpAgdCont.setInt(1, mod.getCodTpAgdCont());
            pstTpAgdCont.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar excluir o tipo de agenda de contato!!\n Erro: " + ex);
        }
        conTpAgdComp.desconecta();
    }

    public void AlterarTipoAgendaCompromisso(ModeloTipoAgenda mod) {

        conTpAgdComp.conexao();
        try {
            PreparedStatement pstTpAgdComp = (PreparedStatement) conTpAgdComp.conn.prepareStatement("update Tab_Tipo_Agenda_Compromisso set Desc_Tp_Agd_Comp =? where Cod_Tp_Agd_Comp =?");
            pstTpAgdComp.setString(1, mod.getDescTpAgdComp());
            pstTpAgdComp.setInt(2, mod.getCodTpAgdComp());
            pstTpAgdComp.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o tipo de agenda de compromisso!!\n Erro: " + ex);
        }
        conTpAgdComp.desconecta();
    }
    
    public void AlterarTipoAgendaContato(ModeloTipoAgenda mod) {

        conTpAgdComp.conexao();
        try {
            PreparedStatement pstAgd = (PreparedStatement) conTpAgdComp.conn.prepareStatement("update Tab_Tipo_Agenda_Contato set Desc_Tp_Agd_Cont =? where Cod_Tp_Agd_Cont =?");
            pstAgd.setString(1, mod.getDescTpAgdCont());
            pstAgd.setInt(2, mod.getCodTpAgdCont());
            pstAgd.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o tipo de agenda de contato!!\n Erro: " + ex);
        }
        conTpAgdComp.desconecta();
    }
}

package ControleSistema;

import VisaoTelaPrincipal.TelaPrincipal;
import static VisaoTelaPrincipal.TelaPrincipal.areaTrabalhoCadastros;
import static VisaoTelaPrincipal.TelaPrincipal.areaTrabalhoConsultas;
import static VisaoTelaPrincipal.TelaPrincipal.areaTrabalhoParametroSistema;
import static VisaoTelaPrincipal.TelaPrincipal.areaTrabalhoPorteiro;
import static VisaoTelaPrincipal.TelaPrincipal.areaTrabalhoSistema;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Funcoes {

    private String consulta;
    ConectaBanco conRel = new ConectaBanco();
    String op = "";

    public void centralizarFormularioPorteiro(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoPorteiro.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoPorteiro.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoPorteiro.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioParametroSistema(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoParametroSistema.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoParametroSistema.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoParametroSistema.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioSistema(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoSistema.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoSistema.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoSistema.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioCadastros(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoCadastros.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoCadastros.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoCadastros.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioConsultas(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoConsultas.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoConsultas.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoConsultas.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public String getConsulta() {

        return consulta;
    }

    public void setConsulta(String consulta) {

        this.consulta = consulta;
    }

    public void imprimirRelatorio(String SQL, String localRelatorio) throws JRException {

        try {
            conRel.conexao();
            conRel.executaSQL(SQL);
            JRResultSetDataSource relResult = new JRResultSetDataSource(conRel.rs);
            JasperPrint jpPrint = JasperFillManager.fillReport(localRelatorio, new HashMap(), relResult);
            JasperViewer jv = new JasperViewer(jpPrint, false);
            jv.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar exibir o relatório\n" + ex);
        }
    }
}

package VisaoPortaria;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import ControleSistema.Funcoes;

public class FrmConsultaDataSaida extends javax.swing.JInternalFrame {

    private final JInternalFrame parente;
    String dataIni, dataFin, consulta = "";
    Funcoes consultar = new Funcoes();
    Date dtIni, dtFin;

    public FrmConsultaDataSaida(JInternalFrame p) throws SQLException {

        initComponents();
        this.parente = p;
        consulta = consultar.getConsulta();
    }

    public void formataDataVariavel() throws ParseException {

        dtIni = TfDataInicial.getDate();
        dtFin = TfDataFinal.getDate();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        dataIni = formatador.format(dtIni);
        dataFin = formatador.format(dtFin);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RdGroupTiposConsultas = new javax.swing.ButtonGroup();
        TfDataInicial = new com.toedter.calendar.JDateChooser();
        TfDataFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BtConsultar = new javax.swing.JButton();

        setClosable(true);
        setTitle("Digite a data");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Data Inicial");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Data Final");

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Data");
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TfDataInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 316, 108);
    }// </editor-fold>//GEN-END:initComponents

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        if (consulta == "saidaVeiculo") {
            FrmConsultasEntradaSaidaVeiculos frmConsultasEntradaSaidaVeiculos = (FrmConsultasEntradaSaidaVeiculos) parente;
            try {
                formataDataVariavel();
            } catch (ParseException ex) {
                Logger.getLogger(FrmConsultasEntradaSaidaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
            frmConsultasEntradaSaidaVeiculos.setData_ini(dataIni);
            frmConsultasEntradaSaidaVeiculos.setData_fin(dataFin);
            frmConsultasEntradaSaidaVeiculos.atualizarTabelaSaidaVeiculoData();
            dispose();
        } else {
            if (consulta == "saidaPessoa") {
                FrmConsultasEntradaSaidaPessoas frmConsultasEntradaSaidaPessoas = (FrmConsultasEntradaSaidaPessoas) parente;
                try {
                    formataDataVariavel();
                } catch (ParseException ex) {
                    Logger.getLogger(FrmConsultasEntradaSaidaPessoas.class.getName()).log(Level.SEVERE, null, ex);
                }
                frmConsultasEntradaSaidaPessoas.setData_ini(dataIni);
                frmConsultasEntradaSaidaPessoas.setData_fin(dataFin);
                frmConsultasEntradaSaidaPessoas.atualizarTabelaSaidaPessoaData();
                dispose();
            }
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtConsultar;
    private javax.swing.ButtonGroup RdGroupTiposConsultas;
    private com.toedter.calendar.JDateChooser TfDataFinal;
    private com.toedter.calendar.JDateChooser TfDataInicial;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

package VisaoTelaPrincipal;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmSplash extends javax.swing.JFrame {

    public FrmSplash() {
        
        initComponents();
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 101; i++) {
                    try {
                        sleep(60);
                        ProgressBarSplash.setValue(i);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FrmSplash.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                dispose();
                try {
                    chamaLogin();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmSplash.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.start();
    }

    public void chamaLogin() throws SQLException {

        FrmLogin frm = new FrmLogin();
        frm.setUndecorated(true);
        frm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ProgressBarSplash = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        ProgressBarSplash.setStringPainted(true);
        getContentPane().add(ProgressBarSplash);
        ProgressBarSplash.setBounds(0, 330, 590, 17);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Portaria - Versão 2.0 - Full");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 270, 140, 13);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 102));
        jLabel5.setText("Aguarde o sistema ser carregado!!");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(210, 310, 180, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("SISTEMA DE GESTÃO OPERACIONAL HOTELEIRA");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(313, 250, 270, 14);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LogoNot.PNG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(340, 30, 220, 220);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Splash.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -20, 590, 360);

        setSize(new java.awt.Dimension(587, 344));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar ProgressBarSplash;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}

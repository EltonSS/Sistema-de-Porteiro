package VisaoTelaPrincipal;

import ControleSistema.ConectaBanco;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FrmLogin extends javax.swing.JFrame {

    ConectaBanco conUsuario = new ConectaBanco();

    public FrmLogin() throws SQLException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        conUsuario.conexao();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TfLoginUsuario = new javax.swing.JTextField();
        BtLogar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PwdTfSenhaUsuario = new javax.swing.JPasswordField();
        BtCancelar = new javax.swing.JButton();
        LabelLogoNotConsultoria = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TelaBranca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 51, 51));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanelLogin.setBackground(new java.awt.Color(18, 58, 100));
        jPanelLogin.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Login *");

        TfLoginUsuario.setToolTipText("Digite o seu usuário");
        TfLoginUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfLoginUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfLoginUsuarioActionPerformed(evt);
            }
        });
        TfLoginUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfLoginUsuarioKeyTyped(evt);
            }
        });

        BtLogar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BtLogar.setText("Entrar");
        BtLogar.setToolTipText("Autenticar");
        BtLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLogarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Senha *");

        PwdTfSenhaUsuario.setToolTipText("Digite a sua senha");
        PwdTfSenhaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdTfSenhaUsuarioActionPerformed(evt);
            }
        });

        BtCancelar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BtCancelar.setText("Cancelar");
        BtCancelar.setToolTipText("Autenticar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TfLoginUsuario))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelLoginLayout.createSequentialGroup()
                                .addComponent(BtLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtCancelar))
                            .addComponent(PwdTfSenhaUsuario))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TfLoginUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PwdTfSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelLogin);
        jPanelLogin.setBounds(0, 130, 270, 110);

        LabelLogoNotConsultoria.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        LabelLogoNotConsultoria.setForeground(new java.awt.Color(51, 51, 255));
        LabelLogoNotConsultoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/LoginNotConsultoria.png"))); // NOI18N
        getContentPane().add(LabelLogoNotConsultoria);
        LabelLogoNotConsultoria.setBounds(50, 0, 150, 100);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Seja Bem Vido!!");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 110, 90, 14);

        TelaBranca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaBranca.png"))); // NOI18N
        getContentPane().add(TelaBranca);
        TelaBranca.setBounds(0, 0, 270, 110);

        setSize(new java.awt.Dimension(262, 272));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void logar() {

        if (TfLoginUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor digite o login!!");
            TfLoginUsuario.requestFocus();
        } else {
            if (PwdTfSenhaUsuario.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Favor digite a senha!!");
                PwdTfSenhaUsuario.requestFocus();
            } else {
                conUsuario.executaSQL("select * from tab_usuarios where login_usu = '" + TfLoginUsuario.getText() + "'");
                try {
                    conUsuario.rs.first();
                } catch (SQLException ex) {
                    Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (conUsuario.rs.getString("senha_usu").equals(PwdTfSenhaUsuario.getText())) {
                        try {
                            new TelaPrincipal(TfLoginUsuario.getText()).show();
                        } catch (SQLException ex) {
                            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ParseException ex) {
                            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto!!");
                        PwdTfSenhaUsuario.setText("");
                        TfLoginUsuario.setText("");
                        TfLoginUsuario.requestDefaultFocus();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void BtLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLogarActionPerformed

        logar();
    }//GEN-LAST:event_BtLogarActionPerformed

    private void PwdTfSenhaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdTfSenhaUsuarioActionPerformed

        logar();
    }//GEN-LAST:event_PwdTfSenhaUsuarioActionPerformed

    private void TfLoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfLoginUsuarioActionPerformed

        logar();
    }//GEN-LAST:event_TfLoginUsuarioActionPerformed

    private void TfLoginUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfLoginUsuarioKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfLoginUsuarioKeyTyped

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        System.exit(0);
    }//GEN-LAST:event_BtCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtLogar;
    private javax.swing.JLabel LabelLogoNotConsultoria;
    private javax.swing.JPasswordField PwdTfSenhaUsuario;
    private javax.swing.JLabel TelaBranca;
    private javax.swing.JTextField TfLoginUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelLogin;
    // End of variables declaration//GEN-END:variables
}

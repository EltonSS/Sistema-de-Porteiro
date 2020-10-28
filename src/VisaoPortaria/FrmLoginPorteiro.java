package VisaoPortaria;

import ControleSistema.ConectaBanco;
import VisaoTelaPrincipal.TelaPrincipal;
import static VisaoTelaPrincipal.TelaPrincipal.areaTrabalhoPorteiro;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class FrmLoginPorteiro extends javax.swing.JInternalFrame {

    ConectaBanco conUsuario = new ConectaBanco();
    String tela;

    public FrmLoginPorteiro(String nomeTela) throws SQLException {

        initComponents();
        conUsuario.conexao();
        tela = nomeTela;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TfLoginUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PwdTfSenhaUsuario = new javax.swing.JPasswordField();
        BtLogar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 153, 255));
        setTitle(" Login Porteiro");
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(153, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Login *");

        TfLoginUsuario.setToolTipText("Digite o login");
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Senha *");

        PwdTfSenhaUsuario.setToolTipText("Digite a senha");
        PwdTfSenhaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdTfSenhaUsuarioActionPerformed(evt);
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

        BtCancelar.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        BtCancelar.setText("Cancelar");
        BtCancelar.setToolTipText("Autenticar");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Acesso");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtCancelar))
                            .addComponent(PwdTfSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(TfLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TfLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(PwdTfSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 230, 130);

        setBounds(0, 0, 246, 159);
    }// </editor-fold>//GEN-END:initComponents
    public void centralizarFormulario(JInternalFrame Formulario) {

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

    public String logar() throws ParseException {

        String nomePort = null;
        if (TfLoginUsuario.getText().equals("") || PwdTfSenhaUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Necessita preencher os campos para realizar o login...\nFavor verifique os campos obrigatórios!!");
        } else {
            try {
                conUsuario.executaSQL("select * from tab_porteiros where login_port = '" + TfLoginUsuario.getText() + "'");
                conUsuario.rs.first();
                nomePort = conUsuario.rs.getString("nome_port");
                if (conUsuario.rs.getString("senha_port").equals(PwdTfSenhaUsuario.getText())) {
                    try {
                        if (tela == "Acesso veiculo") {
                            FrmControleAcessoVeiculo frmAcssVeiculo = new FrmControleAcessoVeiculo(nomePort);
                            centralizarFormulario(frmAcssVeiculo);
                        } else {
                            if (tela == "Acesso pessoa") {
                                FrmControleAcessoPessoa frmAcssPessoa = new FrmControleAcessoPessoa(nomePort);
                                centralizarFormulario(frmAcssPessoa);
                            } else {
                                if (tela == "Acesso chave") {
                                    FrmControleSaidaChaves frmAcssChave = new FrmControleSaidaChaves(nomePort);
                                    centralizarFormulario(frmAcssChave);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmLoginPorteiro.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto!!");
                    PwdTfSenhaUsuario.setText("");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Usuário ou Senha incorreto!!");
            }
        }
        return null;
    }
    private void PwdTfSenhaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdTfSenhaUsuarioActionPerformed

        try {
            logar();
        } catch (ParseException ex) {
            Logger.getLogger(FrmLoginPorteiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_PwdTfSenhaUsuarioActionPerformed

    private void TfLoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfLoginUsuarioActionPerformed

        try {
            logar();
        } catch (ParseException ex) {
            Logger.getLogger(FrmLoginPorteiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TfLoginUsuarioActionPerformed

    private void TfLoginUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfLoginUsuarioKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfLoginUsuarioKeyTyped

    private void BtLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLogarActionPerformed

        try {
            logar();
        } catch (ParseException ex) {
            Logger.getLogger(FrmLoginPorteiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtLogarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtLogar;
    private javax.swing.JPasswordField PwdTfSenhaUsuario;
    private javax.swing.JTextField TfLoginUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

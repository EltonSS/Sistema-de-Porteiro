package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControlePorteiros;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloPorteiros;

public class FrmAlterarSenhaPorteiros extends javax.swing.JInternalFrame {

    static void setEnable(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    ConectaBanco conPort = new ConectaBanco();
    ConectaBanco conConsuPort = new ConectaBanco();
    ModeloPorteiros modPort = new ModeloPorteiros();
    ControlePorteiros control = new ControlePorteiros();
    String nomePort, senha;
    int codPort;

    public FrmAlterarSenhaPorteiros() throws SQLException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
    }

    public void atualizarCampos() {

        TfLoginPorteiro.setText("");
        PwdTfSenhaPorteiroAtual.setText("");
        PwdTfSenhaPorteiroNova.setText("");
    }

    public void consultaPorteiro() {

        conConsuPort.conexao();
        conConsuPort.executaSQL("select * from tab_porteiros where login_port = '" + TfLoginPorteiro.getText() + "'");
        try {
            conConsuPort.rs.first();
            codPort = conConsuPort.rs.getInt("cod_port");
            nomePort = conConsuPort.rs.getString("nome_port");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "");
        }
    }

    public void alterarSenha() {

        if (TfLoginPorteiro.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor digite o seu login atual!!");
            TfLoginPorteiro.requestFocus();
        } else {
            if (PwdTfSenhaPorteiroAtual.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Favor digite a senha atual!!");
                PwdTfSenhaPorteiroAtual.requestFocus();
            } else {
                if (PwdTfSenhaPorteiroNova.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Favor digite a nova senha!!");
                    PwdTfSenhaPorteiroNova.requestFocus();
                } else {
                    try {
                        consultaPorteiro();
                        if (conConsuPort.rs.getString("senha_port").equals(PwdTfSenhaPorteiroAtual.getText())) {
                            int pergunta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja alterar a sua senha?",
                                    "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                            if (pergunta == JOptionPane.YES_OPTION) {
                                modPort.setCodPort(codPort);
                                modPort.setSenhaPort(PwdTfSenhaPorteiroNova.getText());
                                control.AlterarLoginSenhaPorteiro(modPort);
                                atualizarCampos();
                                JOptionPane.showMessageDialog(rootPane, nomePort + " a sua senha foi alterada com sucesso!!");
                            } else {
                                dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Senha incorreta!! ");
                            PwdTfSenhaPorteiroNova.setText("");
                            PwdTfSenhaPorteiroAtual.setText("");                            
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmAlterarSenhaPorteiros.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TfLoginPorteiro = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PwdTfSenhaPorteiroAtual = new javax.swing.JPasswordField();
        PwdTfSenhaPorteiroNova = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtAlterar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Alterar Senha Porteiros");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Login *");

        TfLoginPorteiro.setToolTipText("Digite o login do usuário");
        TfLoginPorteiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfLoginPorteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfLoginPorteiroActionPerformed(evt);
            }
        });
        TfLoginPorteiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfLoginPorteiroKeyTyped(evt);
            }
        });

        jLabel5.setText("Senha Atual *");

        PwdTfSenhaPorteiroAtual.setToolTipText("Digite a senha do usuário");
        PwdTfSenhaPorteiroAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdTfSenhaPorteiroAtualActionPerformed(evt);
            }
        });

        PwdTfSenhaPorteiroNova.setToolTipText("Digite a senha do usuário");
        PwdTfSenhaPorteiroNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdTfSenhaPorteiroNovaActionPerformed(evt);
            }
        });

        jLabel7.setText("Nova Senha *");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(PwdTfSenhaPorteiroNova, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(PwdTfSenhaPorteiroAtual)
                            .addComponent(TfLoginPorteiro, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(TfLoginPorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(PwdTfSenhaPorteiroAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addComponent(PwdTfSenhaPorteiroNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Alterar Senha Porteiros");

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Alterar Registro");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setBounds(0, 0, 219, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        alterarSenha();
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void TfLoginPorteiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfLoginPorteiroKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfLoginPorteiroKeyTyped

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void TfLoginPorteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfLoginPorteiroActionPerformed

        alterarSenha();
    }//GEN-LAST:event_TfLoginPorteiroActionPerformed

    private void PwdTfSenhaPorteiroAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdTfSenhaPorteiroAtualActionPerformed

        alterarSenha();
    }//GEN-LAST:event_PwdTfSenhaPorteiroAtualActionPerformed

    private void PwdTfSenhaPorteiroNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdTfSenhaPorteiroNovaActionPerformed

        alterarSenha();
    }//GEN-LAST:event_PwdTfSenhaPorteiroNovaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JPasswordField PwdTfSenhaPorteiroAtual;
    private javax.swing.JPasswordField PwdTfSenhaPorteiroNova;
    private javax.swing.JTextField TfLoginPorteiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

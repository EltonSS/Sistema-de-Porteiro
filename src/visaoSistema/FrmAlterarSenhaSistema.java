package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleUsuario;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloUsuario;

public class FrmAlterarSenhaSistema extends javax.swing.JInternalFrame {

    static void setEnable(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    ConectaBanco conSist = new ConectaBanco();
    ConectaBanco conUsu = new ConectaBanco();
    ModeloUsuario modUsu = new ModeloUsuario();
    ControleUsuario control = new ControleUsuario();
    String loginUsu, senhaUsu;   

    public FrmAlterarSenhaSistema() throws SQLException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
    }

    public void atualizarCampos() {

        TfLoginUsuario.setText("");
        PwdTfSenhaUsuarioAtual.setText("");
        PwdTfSenhaUsuarioNova.setText("");
    }

    public void consultaUsuario() {

        conUsu.conexao();
        conUsu.executaSQL("select * from tab_usuarios where login_usu = '" + TfLoginUsuario.getText() + "'");
        try {
            conUsu.rs.first();
            loginUsu = conUsu.rs.getString("login_usu");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "");
        }
    }

    public void alterarSenha() {

        if (TfLoginUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Favor digite o seu login atual!!");
            TfLoginUsuario.requestFocus();
        } else {
            if (PwdTfSenhaUsuarioAtual.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Favor digite a senha atual!!");
                PwdTfSenhaUsuarioAtual.requestFocus();
            } else {
                if (PwdTfSenhaUsuarioNova.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Favor digite a nova senha!!");
                    PwdTfSenhaUsuarioNova.requestFocus();
                } else {
                    try {
                        consultaUsuario();
                        if (conUsu.rs.getString("senha_usu").equals(PwdTfSenhaUsuarioAtual.getText())) {
                            int pergunta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja alterar a sua senha de sistema?",
                                    "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                            if (pergunta == JOptionPane.YES_OPTION) {
                                modUsu.setLoginUsu(loginUsu);
                                modUsu.setSenhaUsuNova(PwdTfSenhaUsuarioNova.getText());
                                control.AlterarLoginSenhaUsuario(modUsu);                               
                                atualizarCampos();
                                JOptionPane.showMessageDialog(rootPane, " A senha do usuário " + loginUsu + " foi alterada com sucesso!!");
                            } else {
                                dispose();
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Senha incorreta!! ");
                            PwdTfSenhaUsuarioNova.setText("");
                            PwdTfSenhaUsuarioAtual.setText("");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(FrmAlterarSenhaSistema.class.getName()).log(Level.SEVERE, null, ex);
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
        TfLoginUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        PwdTfSenhaUsuarioAtual = new javax.swing.JPasswordField();
        PwdTfSenhaUsuarioNova = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtAlterar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Alterar Senha Usuários Sistema");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Login *");

        TfLoginUsuario.setToolTipText("Digite o login do usuário");
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

        jLabel5.setText("Senha Atual *");

        PwdTfSenhaUsuarioAtual.setToolTipText("Digite a senha do usuário");
        PwdTfSenhaUsuarioAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdTfSenhaUsuarioAtualActionPerformed(evt);
            }
        });

        PwdTfSenhaUsuarioNova.setToolTipText("Digite a senha do usuário");
        PwdTfSenhaUsuarioNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PwdTfSenhaUsuarioNovaActionPerformed(evt);
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
                    .addComponent(PwdTfSenhaUsuarioAtual)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(TfLoginUsuario)
                    .addComponent(PwdTfSenhaUsuarioNova))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(TfLoginUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(5, 5, 5)
                .addComponent(PwdTfSenhaUsuarioAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(5, 5, 5)
                .addComponent(PwdTfSenhaUsuarioNova, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Alterar Senha Usuários do Sistema");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        setBounds(0, 0, 273, 286);
    }// </editor-fold>//GEN-END:initComponents

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        alterarSenha();
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void TfLoginUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfLoginUsuarioKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfLoginUsuarioKeyTyped

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void TfLoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfLoginUsuarioActionPerformed

        alterarSenha();
    }//GEN-LAST:event_TfLoginUsuarioActionPerformed

    private void PwdTfSenhaUsuarioAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdTfSenhaUsuarioAtualActionPerformed

        alterarSenha();
    }//GEN-LAST:event_PwdTfSenhaUsuarioAtualActionPerformed

    private void PwdTfSenhaUsuarioNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PwdTfSenhaUsuarioNovaActionPerformed

        alterarSenha();
    }//GEN-LAST:event_PwdTfSenhaUsuarioNovaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JPasswordField PwdTfSenhaUsuarioAtual;
    private javax.swing.JPasswordField PwdTfSenhaUsuarioNova;
    private javax.swing.JTextField TfLoginUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

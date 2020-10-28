package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleTipoUsuario;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTipoUsuario;
import ModeloSistema.ModeloTabela;

public class FrmTipoUsuario extends javax.swing.JInternalFrame {

    ConectaBanco conTipoUsuario = new ConectaBanco();
    ConectaBanco conPesquisa = new ConectaBanco();
    ModeloTipoUsuario mod = new ModeloTipoUsuario();
    ControleTipoUsuario control = new ControleTipoUsuario();

    public FrmTipoUsuario() throws SQLException {

        initComponents();
        conTipoUsuario.conexao();
        conTipoUsuario.executaSQL("select * from tab_tipo_usuarios");
    }

    public void atualizarCampos() {

        TfPesquisarTipoUsuario.setText("");
        TfCodTipoUsuario.setText("");
        TfDescricaoTipoUsuario.setText("");
    }

    public void atualizarTabela() {

        preencherTabela("select * from tab_tipo_usuarios where descricao_tipo_usu like '%" + TfPesquisarTipoUsuario.getText() + "%'");
    }

    public void limparTabelaTipoUsuario() {

        limparTabelaTipoUsuario("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfCodTipoUsuario = new javax.swing.JTextField();
        TfDescricaoTipoUsuario = new javax.swing.JTextField();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        TfPesquisarTipoUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbTipoUsuario = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Tipos de Usuários");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Tipo Usuário *");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descrição do Tipo de Usuário *");

        TfCodTipoUsuario.setToolTipText("Código do tipo de usuário");
        TfCodTipoUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfCodTipoUsuario.setEnabled(false);

        TfDescricaoTipoUsuario.setToolTipText("Digite a descrição do tipo de usuário");
        TfDescricaoTipoUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoTipoUsuario.setEnabled(false);
        TfDescricaoTipoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfDescricaoTipoUsuarioKeyTyped(evt);
            }
        });

        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        BtAdicionar.setToolTipText("Adicionar Registro");
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionarActionPerformed(evt);
            }
        });

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.setEnabled(false);
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.setEnabled(false);
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfCodTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(TfDescricaoTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfCodTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(TfDescricaoTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Tipos de Usuários");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TfPesquisarTipoUsuario.setToolTipText("Digite a descrição do tipo de usuário que deseja pesquisar");
        TfPesquisarTipoUsuario.setEnabled(false);
        TfPesquisarTipoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPesquisarTipoUsuarioActionPerformed(evt);
            }
        });
        TfPesquisarTipoUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfPesquisarTipoUsuarioKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Pesquisar Tipo de Usuário");

        TbTipoUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbTipoUsuario.setToolTipText("Lista dos tipos de usuários cadastrados");
        TbTipoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbTipoUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbTipoUsuario);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(TfPesquisarTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfPesquisarTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 407, 458);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfDescricaoTipoUsuario.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta algum campo obrigatório a ser preenchido...\nFavor verifique os campos obrigatórios!!");
        } else {
            mod.setDescricaoTipoUsuario(TfDescricaoTipoUsuario.getText());
            control.InserirTipoUsuario(mod);
            atualizarCampos();
            limparTabelaTipoUsuario();
            JOptionPane.showMessageDialog(rootPane, "O tipo de usuário : " + mod.getDescricaoTipoUsuario() + " foi registrado com sucesso!!");
            TfDescricaoTipoUsuario.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtEditar.setEnabled(true);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        mod.setDescricaoTipoUsuario(TfDescricaoTipoUsuario.getText());
        mod.setCodTipoUsuario(Integer.parseInt(TfCodTipoUsuario.getText()));
        control.ExcluirTipoUsuario(mod);
        atualizarCampos();
        limparTabelaTipoUsuario();
        JOptionPane.showMessageDialog(rootPane, "O tipo de usuário : " + mod.getPesquisaTipoUsuario() + " foi excluído com sucesso!!");
        TfDescricaoTipoUsuario.setEnabled(false);
        TbTipoUsuario.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaTipoUsuario();
        TfDescricaoTipoUsuario.setEnabled(true);
        TfDescricaoTipoUsuario.requestFocus();
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        mod.setCodTipoUsuario(Integer.parseInt(TfCodTipoUsuario.getText()));
        mod.setDescricaoTipoUsuario(TfDescricaoTipoUsuario.getText());
        control.AlterarTipoUsuario(mod);
        atualizarCampos();
        limparTabelaTipoUsuario();
        JOptionPane.showMessageDialog(rootPane, "O tipo de usuário : " + mod.getDescricaoTipoUsuario() + " foi alterado com sucesso!!");
        TfPesquisarTipoUsuario.setEnabled(false);
        TfDescricaoTipoUsuario.setEnabled(false);
        TbTipoUsuario.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        limparTabelaTipoUsuario();
        TbTipoUsuario.setEnabled(false);
        TfPesquisarTipoUsuario.setEnabled(false);
        TfDescricaoTipoUsuario.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaTipoUsuario();
        TbTipoUsuario.setEnabled(true);
        TfPesquisarTipoUsuario.setEnabled(true);
        TfDescricaoTipoUsuario.setEnabled(true);
        TfPesquisarTipoUsuario.requestFocus();
        BtExcluir.setEnabled(true);
        BtAlterar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TfPesquisarTipoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPesquisarTipoUsuarioActionPerformed

        mod.setPesquisaTipoUsuario(TfPesquisarTipoUsuario.getText());
        ModeloTipoUsuario model = control.pesquisaTipoUsuario(mod);
        TfCodTipoUsuario.setText(String.valueOf(model.getCodTipoUsuario()));
        TfDescricaoTipoUsuario.setText(model.getDescricaoTipoUsuario());
        atualizarTabela();
    }//GEN-LAST:event_TfPesquisarTipoUsuarioActionPerformed

    private void TbTipoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbTipoUsuarioMouseClicked

        String nome_tipo_usu = "" + TbTipoUsuario.getValueAt(TbTipoUsuario.getSelectedRow(), 0);
        conTipoUsuario.conexao();
        conPesquisa.conexao();
        conTipoUsuario.executaSQL("select * from tab_tipo_usuarios where descricao_tipo_usu = '" + nome_tipo_usu + "'");
        try {
            conTipoUsuario.rs.first();
            TfCodTipoUsuario.setText(String.valueOf(conTipoUsuario.rs.getInt("cod_tipo_usu")));
            TfDescricaoTipoUsuario.setText(conTipoUsuario.rs.getString("descricao_tipo_usu"));
            conTipoUsuario.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbTipoUsuarioMouseClicked

    private void TfDescricaoTipoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfDescricaoTipoUsuarioKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
                && c != 'á' //Minúsculas             
                && c != 'é'
                && c != 'í'
                && c != 'ó'
                && c != 'ú'
                && c != 'Á' //Mayúsculas             
                && c != 'É'
                && c != 'Í'
                && c != 'Ó'
                && c != 'Ú'
                && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfDescricaoTipoUsuarioKeyTyped

    private void TfPesquisarTipoUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfPesquisarTipoUsuarioKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
                && c != 'á' //Minúsculas             
                && c != 'é'
                && c != 'í'
                && c != 'ó'
                && c != 'ú'
                && c != 'Á' //Mayúsculas             
                && c != 'É'
                && c != 'Í'
                && c != 'Ó'
                && c != 'Ú'
                && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfPesquisarTipoUsuarioKeyTyped
    public void preencherTabela(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Tipo de Usuários Cadastrados"};
        conTipoUsuario.conexao();
        conTipoUsuario.executaSQL(SQL);
        try {
            conTipoUsuario.rs.first();
            do {
                dados.add(new Object[]{conTipoUsuario.rs.getString("Descricao_tipo_usu")});
            } while (conTipoUsuario.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane,"Erro ao preencher a tabela!!\n Erro: "+ex);  
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbTipoUsuario.setModel(modTabela);
        TbTipoUsuario.getColumnModel().getColumn(0).setPreferredWidth(484);
        TbTipoUsuario.getColumnModel().getColumn(0).setResizable(false);
        TbTipoUsuario.getTableHeader().setReorderingAllowed(false);
        TbTipoUsuario.setAutoResizeMode(TbTipoUsuario.AUTO_RESIZE_OFF);
        TbTipoUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conTipoUsuario.desconecta();
    }
    
    public void limparTabelaTipoUsuario(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Descricao_tipo_usu"};
        dados.add(new Object[]{""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbTipoUsuario.setModel(modTabela);
        TbTipoUsuario.getColumnModel().getColumn(0).setPreferredWidth(200);
        TbTipoUsuario.getColumnModel().getColumn(0).setResizable(false);
        TbTipoUsuario.getTableHeader().setReorderingAllowed(false);
        TbTipoUsuario.setAutoResizeMode(TbTipoUsuario.AUTO_RESIZE_OFF);
        TbTipoUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JTable TbTipoUsuario;
    private javax.swing.JTextField TfCodTipoUsuario;
    private javax.swing.JTextField TfDescricaoTipoUsuario;
    private javax.swing.JTextField TfPesquisarTipoUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
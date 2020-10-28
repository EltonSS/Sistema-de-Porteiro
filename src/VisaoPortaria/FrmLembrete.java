package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleLembrete;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloLembrete;
import ModeloSistema.ModeloTabela;

public class FrmLembrete extends javax.swing.JInternalFrame {

    ConectaBanco conLembrete = new ConectaBanco();
    ConectaBanco conPesquisaLembrete = new ConectaBanco();
    ModeloLembrete mod = new ModeloLembrete();
    ControleLembrete control = new ControleLembrete();

    public FrmLembrete() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        atualizarCampos();
        try {
            MaskFormatter dataLembrete = new MaskFormatter("##/##/####");
            TfmtDataLembrete.setFormatterFactory(new DefaultFormatterFactory(dataLembrete));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a data!! \n ERRO :" + ex);
        }
    }

    public void atualizarCampos() {

        TfmtDataLembrete.setText("");
        TfTituloAssunto.setText("");
        TxtObservacaoAssunto.setText("");
        TfPesquisarLembrete.setText("");
    }

    public void atualizarTabela() {

        preencherTabelaLembrete("select * from tab_lembrete where Titulo_Assunto_Lembrete like '%" + TfPesquisarLembrete.getText() + "%'");
    }

    public void limparTabelaLembrete() {

        limparTabelaLembrete("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        TfPesquisarLembrete = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TxtObservacaoAssunto = new javax.swing.JTextArea();
        TfTituloAssunto = new javax.swing.JTextField();
        TfmtDataLembrete = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbLembrete = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastros de Lembretes");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        TfPesquisarLembrete.setToolTipText("Digite o lembrete que deseja pesquisar");
        TfPesquisarLembrete.setEnabled(false);
        TfPesquisarLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPesquisarLembreteActionPerformed(evt);
            }
        });

        jLabel6.setText("Pesquisar Lembrete");

        TxtObservacaoAssunto.setColumns(20);
        TxtObservacaoAssunto.setRows(5);
        TxtObservacaoAssunto.setToolTipText("Digite as observações do lembrete");
        TxtObservacaoAssunto.setEnabled(false);
        jScrollPane2.setViewportView(TxtObservacaoAssunto);

        TfTituloAssunto.setToolTipText("Digite o título do assunto do lembrete");
        TfTituloAssunto.setEnabled(false);

        TfmtDataLembrete.setToolTipText("Digite a data do lembrete");
        TfmtDataLembrete.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TfmtDataLembrete.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfmtDataLembrete.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Data do Lembrete");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Título do Assunto");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Observações");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(151, 151, 151)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfPesquisarLembrete, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                            .addComponent(jLabel6)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(TfmtDataLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfTituloAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfmtDataLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfTituloAssunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfPesquisarLembrete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Lembretes");

        TbLembrete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbLembrete.setToolTipText("Lista dos lembretes cadastrados");
        TbLembrete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbLembreteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbLembrete);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(5, 5, 5)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        setBounds(0, 0, 720, 544);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfmtDataLembrete.getText().equals("") || TfTituloAssunto.getText().equals("") || TxtObservacaoAssunto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Para finalizar o cadastro do lembrete, precisa preencher todos os campos necessários!!");
        } else {
            mod.setDataLembrete(TfmtDataLembrete.getText());
            mod.setAssuntoLembrete(TfTituloAssunto.getText());
            mod.setObservacaoLembrete(TxtObservacaoAssunto.getText());
            control.InserirLembrete(mod);
            atualizarCampos();
            limparTabelaLembrete();
            JOptionPane.showMessageDialog(rootPane, "O lembrete : " + mod.getAssuntoLembrete() + " foi registrado com sucesso!!");
            TfmtDataLembrete.setEnabled(false);
            TfTituloAssunto.setEnabled(false);
            TxtObservacaoAssunto.setEnabled(false);
            TfPesquisarLembrete.setEnabled(false);
            TbLembrete.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtEditar.setEnabled(true);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        mod.setAssuntoLembrete(TfTituloAssunto.getText());
        control.ExcluirLembrete(mod);
        atualizarCampos();
        limparTabelaLembrete();
        JOptionPane.showMessageDialog(rootPane, "O Lembrete : " + mod.getAssuntoLembrete() + " foi excluído com sucesso!!");
        TfmtDataLembrete.setEnabled(false);
        TfTituloAssunto.setEnabled(false);
        TxtObservacaoAssunto.setEnabled(false);
        TfPesquisarLembrete.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaLembrete();
        TfmtDataLembrete.setEnabled(true);
        TfmtDataLembrete.requestFocus();
        TfTituloAssunto.setEnabled(true);
        TxtObservacaoAssunto.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        mod.setDataLembrete(TfmtDataLembrete.getText());
        mod.setAssuntoLembrete(TfTituloAssunto.getText());
        mod.setObservacaoLembrete(TxtObservacaoAssunto.getText());
        control.AlterarLembrete(mod);
        atualizarCampos();
        limparTabelaLembrete();
        JOptionPane.showMessageDialog(rootPane, "O Lembrete : " + mod.getAssuntoLembrete() + " foi alterado com sucesso!!");
        TfmtDataLembrete.setEnabled(false);
        TfTituloAssunto.setEnabled(false);
        TxtObservacaoAssunto.setEnabled(false);
        TfPesquisarLembrete.setEnabled(false);
        TbLembrete.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        limparTabelaLembrete();
        TbLembrete.setEnabled(false);
        TfPesquisarLembrete.setEnabled(false);
        TbLembrete.setEnabled(false);
        TfmtDataLembrete.setEnabled(false);
        TfTituloAssunto.setEnabled(false);
        TxtObservacaoAssunto.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaLembrete();
        TfPesquisarLembrete.setEnabled(true);
        TfmtDataLembrete.setEnabled(true);
        TfTituloAssunto.setEnabled(true);
        TxtObservacaoAssunto.setEnabled(true);
        TfPesquisarLembrete.requestFocus();
        TbLembrete.setEnabled(true);
        BtExcluir.setEnabled(true);
        BtAlterar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TfPesquisarLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPesquisarLembreteActionPerformed

        atualizarTabela();
    }//GEN-LAST:event_TfPesquisarLembreteActionPerformed

    private void TbLembreteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbLembreteMouseClicked

        String assunto = "" + TbLembrete.getValueAt(TbLembrete.getSelectedRow(), 1);
        conPesquisaLembrete.conexao();
        conPesquisaLembrete.executaSQL("select * from tab_lembrete where Titulo_Assunto_Lembrete = '" + assunto + "'order by data_lembrete asc");
        try {
            conPesquisaLembrete.rs.first();
            TfmtDataLembrete.setText(conPesquisaLembrete.rs.getString("data_lembrete"));
            TfTituloAssunto.setText(conPesquisaLembrete.rs.getString("titulo_assunto_lembrete"));
            TxtObservacaoAssunto.setText(conPesquisaLembrete.rs.getString("descricao_lembrete"));
            conPesquisaLembrete.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbLembreteMouseClicked

    public void preencherTabelaLembrete(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Lembretes", "Títulos Assuntos"};
        conPesquisaLembrete.conexao();
        conPesquisaLembrete.executaSQL(SQL);
        try {
            conPesquisaLembrete.rs.first();
            do {
                dados.add(new Object[]{conPesquisaLembrete.rs.getString("Data_Lembrete"), conPesquisaLembrete.rs.getString("Titulo_Assunto_Lembrete")});
            } while (conPesquisaLembrete.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbLembrete.setModel(modTabela);
        TbLembrete.getColumnModel().getColumn(0).setPreferredWidth(130);
        TbLembrete.getColumnModel().getColumn(0).setResizable(false);
        TbLembrete.getColumnModel().getColumn(1).setPreferredWidth(546);
        TbLembrete.getColumnModel().getColumn(1).setResizable(false);
        TbLembrete.setAutoResizeMode(TbLembrete.AUTO_RESIZE_OFF);
        TbLembrete.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conPesquisaLembrete.desconecta();
    }

    public void limparTabelaLembrete(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Lembretes", "Títulos Assuntos"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbLembrete.setModel(modTabela);
        TbLembrete.getColumnModel().getColumn(0).setPreferredWidth(130);
        TbLembrete.getColumnModel().getColumn(0).setResizable(false);
        TbLembrete.getColumnModel().getColumn(1).setPreferredWidth(546);
        TbLembrete.getColumnModel().getColumn(1).setResizable(false);
        TbLembrete.setAutoResizeMode(TbLembrete.AUTO_RESIZE_OFF);
        TbLembrete.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JTable TbLembrete;
    private javax.swing.JTextField TfPesquisarLembrete;
    private javax.swing.JTextField TfTituloAssunto;
    private javax.swing.JFormattedTextField TfmtDataLembrete;
    private javax.swing.JTextArea TxtObservacaoAssunto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}

package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleApartamentos;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloApartamento;

public class FrmApartamentos extends javax.swing.JInternalFrame {

    ConectaBanco conApt = new ConectaBanco();
    ConectaBanco conTrr = new ConectaBanco();
    ModeloApartamento modApt = new ModeloApartamento();
    ControleApartamentos control = new ControleApartamentos();

    public FrmApartamentos() throws SQLException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        preencherCbTorres();
    }

    public void preencherCbTorres() {

        conTrr.conexao();
        conTrr.executaSQL("select * from tab_torres order by cod_trr");
        try {
            conTrr.rs.first();
            do {
                CbTorres.addItem("" + conTrr.rs.getString("desc_trr"));
            } while (conTrr.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a torre \n ERRO :" + ex);
        }
        conTrr.desconecta();
    }

    public void atualizarCampos() {

        TfPesquisarApartamentos.setText("");
        TfCodApartamento.setText("");
        TfNumeroApartamento.setText("");
        TfRamalApartamento.setText("");
    }

    public void atualizarTabelaApartamento() {

        preencherTabelaApartamentos("select * from vw_apartamento where num_apt like '%" + TfPesquisarApartamentos.getText() + "%'");
    }

     public void limparTabelaApartamento() {

        limparTabelaApartamento("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfCodApartamento = new javax.swing.JTextField();
        TfNumeroApartamento = new javax.swing.JTextField();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        CbTorres = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        TfRamalApartamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbApartamentos = new javax.swing.JTable();
        TfPesquisarApartamentos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastros de Apartamentos");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Apartamento *");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nº Apartamento*");

        TfCodApartamento.setToolTipText("Código do funcionário");
        TfCodApartamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfCodApartamento.setEnabled(false);

        TfNumeroApartamento.setToolTipText("Digite o nome do funcionário");
        TfNumeroApartamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNumeroApartamento.setEnabled(false);
        TfNumeroApartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNumeroApartamentoKeyTyped(evt);
            }
        });

        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        BtAdicionar.setToolTipText("Adicionar Registro");
        BtAdicionar.setPreferredSize(null);
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionarActionPerformed(evt);
            }
        });

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.setEnabled(false);
        BtCancelar.setPreferredSize(null);
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.setPreferredSize(null);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.setEnabled(false);
        BtAlterar.setPreferredSize(null);
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.setPreferredSize(null);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.setPreferredSize(null);
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });

        CbTorres.setToolTipText("Escolha o tipo de funcionário");
        CbTorres.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Torre*");

        TfRamalApartamento.setToolTipText("Digite o nome do funcionário");
        TfRamalApartamento.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfRamalApartamento.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Ramal*");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfCodApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TfNumeroApartamento))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TfRamalApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(CbTorres, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfCodApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(5, 5, 5)
                            .addComponent(TfNumeroApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(5, 5, 5)
                            .addComponent(TfRamalApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(5, 5, 5)
                        .addComponent(CbTorres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastrar Apartamentos");

        TbApartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbApartamentos.setToolTipText("Lista dos funcionários cadastrados");
        TbApartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbApartamentosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbApartamentos);

        TfPesquisarApartamentos.setToolTipText("Digite o nome do funcionário que deseja pesquisar ");
        TfPesquisarApartamentos.setEnabled(false);
        TfPesquisarApartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPesquisarApartamentosActionPerformed(evt);
            }
        });
        TfPesquisarApartamentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfPesquisarApartamentosKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Pesquisar Num. Apart.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TfPesquisarApartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfPesquisarApartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        setBounds(0, 0, 488, 457);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfNumeroApartamento.getText().equals("") || TfRamalApartamento.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta algum campo obrigatório a ser preenchido...\nFavor verifique os campos obrigatórios!!");
        } else {
            modApt.setNumApt(TfNumeroApartamento.getText());
            modApt.setRamalApt((TfRamalApartamento.getText()));
            modApt.setDescTrr((String) CbTorres.getSelectedItem());
            control.InserirApartamentos(modApt);
            atualizarCampos();
            limparTabelaApartamento();
            JOptionPane.showMessageDialog(rootPane, "O apartamento : " + modApt.getNumApt()+ " foi registrado com sucesso!!");
            TfNumeroApartamento.setEnabled(false);
            TfRamalApartamento.setEnabled(false);
            CbTorres.setEnabled(false);
            TfPesquisarApartamentos.setEnabled(false);
            TbApartamentos.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtEditar.setEnabled(true);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modApt.setCodApt(Integer.parseInt(TfCodApartamento.getText()));
        modApt.setNumApt(TfNumeroApartamento.getText());
        TbApartamentos.setEnabled(false);
        control.ExcluirApartamentos(modApt);
        atualizarCampos();
        limparTabelaApartamento();
        JOptionPane.showMessageDialog(rootPane, "O apartamento : " + modApt.getNumApt()+ " foi excluído com sucesso!!");
        TfNumeroApartamento.setEnabled(false);
        TfRamalApartamento.setEnabled(false);
        CbTorres.setEnabled(false);
        TfPesquisarApartamentos.setEnabled(false);
        TbApartamentos.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaApartamento();
        TfNumeroApartamento.setEnabled(true);
        TfNumeroApartamento.requestFocus();
        TfRamalApartamento.setEnabled(true);
        CbTorres.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modApt.setCodApt(Integer.parseInt(TfCodApartamento.getText()));
        modApt.setNumApt(TfNumeroApartamento.getText());
        modApt.setRamalApt(TfRamalApartamento.getText());
        modApt.setDescTrr((String) CbTorres.getSelectedItem());
        control.AlterarApartamentos(modApt);
        atualizarCampos();
        limparTabelaApartamento();
        JOptionPane.showMessageDialog(rootPane, "O apartamento : " + modApt.getNumApt()+ " foi alterado com sucesso!!");
        TfNumeroApartamento.setEnabled(false);
        TfRamalApartamento.setEnabled(false);
        TfPesquisarApartamentos.setEnabled(false);
        CbTorres.setEnabled(false);
        TbApartamentos.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        limparTabelaApartamento();
        TfPesquisarApartamentos.setEnabled(false);
        TfNumeroApartamento.setEnabled(false);
        TfRamalApartamento.setEnabled(false);
        CbTorres.setEnabled(false);
        TbApartamentos.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        TfPesquisarApartamentos.setEnabled(true);
        TfNumeroApartamento.setEnabled(true);
        TfPesquisarApartamentos.requestFocus();
        TfRamalApartamento.setEnabled(true);
        CbTorres.setEnabled(true);
        TbApartamentos.setEnabled(true);
        BtExcluir.setEnabled(true);
        BtAlterar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TfPesquisarApartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPesquisarApartamentosActionPerformed

        atualizarTabelaApartamento();
    }//GEN-LAST:event_TfPesquisarApartamentosActionPerformed

    private void TbApartamentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbApartamentosMouseClicked

        String num_apt = "" + TbApartamentos.getValueAt(TbApartamentos.getSelectedRow(), 0);
        conApt.conexao();
        conApt.executaSQL("select * from vw_apartamento where num_apt = '" + num_apt + "'");
        try {
            conApt.rs.first();
            TfCodApartamento.setText(String.valueOf(conApt.rs.getInt("cod_apt")));
            TfNumeroApartamento.setText(conApt.rs.getString("num_apt"));
            TfRamalApartamento.setText(conApt.rs.getString("ramal_apt"));
            CbTorres.setSelectedItem(conApt.rs.getString("desc_trr"));
            conApt.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos !!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbApartamentosMouseClicked

    private void TfNumeroApartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNumeroApartamentoKeyTyped

        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') 
                && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfNumeroApartamentoKeyTyped

    private void TfPesquisarApartamentosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfPesquisarApartamentosKeyTyped

       char c = evt.getKeyChar();
        if ((c < '0' || c > '9') 
                && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfPesquisarApartamentosKeyTyped
    
    public void preencherTabelaApartamentos(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Apartamento","Torre","Ramal"};
        conApt.conexao();
        conApt.executaSQL(SQL);
        try {
            conApt.rs.first();
            do {
                dados.add(new Object[]{conApt.rs.getString("num_apt"), conApt.rs.getString("desc_trr"), conApt.rs.getString("ramal_apt")});
            } while (conApt.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbApartamentos.setModel(modTabela);
        TbApartamentos.getColumnModel().getColumn(0).setPreferredWidth(150);
        TbApartamentos.getColumnModel().getColumn(0).setResizable(false);
        TbApartamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        TbApartamentos.getColumnModel().getColumn(1).setResizable(false);
        TbApartamentos.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbApartamentos.getColumnModel().getColumn(2).setResizable(false);
        TbApartamentos.getTableHeader().setReorderingAllowed(false);
        TbApartamentos.setAutoResizeMode(TbApartamentos.AUTO_RESIZE_OFF);
        TbApartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conApt.desconecta();
    }
    
    public void limparTabelaApartamento(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Apartamento","Torre","Ramal"};
        dados.add(new Object[]{"", "", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbApartamentos.setModel(modTabela);
        TbApartamentos.getColumnModel().getColumn(0).setPreferredWidth(150);
        TbApartamentos.getColumnModel().getColumn(0).setResizable(false);
        TbApartamentos.getColumnModel().getColumn(1).setPreferredWidth(200);
        TbApartamentos.getColumnModel().getColumn(1).setResizable(false);
        TbApartamentos.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbApartamentos.getColumnModel().getColumn(2).setResizable(false);
        TbApartamentos.getTableHeader().setReorderingAllowed(false);
        TbApartamentos.setAutoResizeMode(TbApartamentos.AUTO_RESIZE_OFF);
        TbApartamentos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbTorres;
    private javax.swing.JTable TbApartamentos;
    private javax.swing.JTextField TfCodApartamento;
    private javax.swing.JTextField TfNumeroApartamento;
    private javax.swing.JTextField TfPesquisarApartamentos;
    private javax.swing.JTextField TfRamalApartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

  
}
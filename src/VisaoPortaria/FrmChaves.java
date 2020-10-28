package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleChaves;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloChaves;
import ModeloSistema.TratamentoCampos;

public class FrmChaves extends javax.swing.JInternalFrame {

    ConectaBanco conChv = new ConectaBanco();
    ConectaBanco conSets = new ConectaBanco();
    ConectaBanco conPesquisa = new ConectaBanco();
    ModeloChaves modChv = new ModeloChaves();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleChaves control = new ControleChaves();
    String nomeChv = "", cadastrado;

    public FrmChaves() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        preencherCbSetoresFuncionarios();
    }

    public void preencherCbSetoresFuncionarios() {

        conSets.conexao();
        conSets.executaSQL("select * from tab_setores");
        try {
            conSets.rs.first();
            do {
                CbSetores.addItem(conSets.rs.getString("desc_set"));
            } while (conSets.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o setor do funcionário \n ERRO :" + ex);
        }
        conSets.desconecta();
    }

    public void atualizarCampos() {

        TfCodChaves.setText("");
        TfDescChaves.setText("");
    }

    public void habiltaCampos() {

        TfDescChaves.setEnabled(true);
        CbSetores.setEnabled(true);
    }

    public void pesquisaTabelaChaves() {

        preencherTabelaChaves(" select * from vw_chaves where desc_chv like '%" + nomeChv + "%'");
    }

    public void limparTabelaChaves() {

        limparTabelaChaves("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TfDescChaves = new javax.swing.JTextField();
        TfCodChaves = new javax.swing.JFormattedTextField();
        CbSetores = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        BtConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbChaves = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Chaves");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Chaves");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        BtAdicionar.setToolTipText("Adicionar Registro");
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 48, 48));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.setEnabled(false);
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 48, 48));

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 48, 48));

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.setEnabled(false);
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 48, 48));

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 48, 48));

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 48, 48));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descrição Chave");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, -1, -1));

        TfDescChaves.setToolTipText("Digite a descrição da chave");
        TfDescChaves.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescChaves.setEnabled(false);
        jPanel1.add(TfDescChaves, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 79, 326, -1));

        TfCodChaves.setToolTipText("Código da chave");
        TfCodChaves.setEnabled(false);
        TfCodChaves.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodChavesKeyTyped(evt);
            }
        });
        jPanel1.add(TfCodChaves, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 33, 114, -1));

        CbSetores.setToolTipText("Escolha o setor da chave");
        CbSetores.setEnabled(false);
        jPanel1.add(CbSetores, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 142, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Setores ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Fornecedor");
        BtConsultar.setEnabled(false);
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(BtConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, 48, 48));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Chaves");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Chaves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbChaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbChaves.setToolTipText("Lista de chaves");
        TbChaves.setEnabled(false);
        TbChaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbChavesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbChaves);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        setBounds(0, 0, 450, 494);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfDescChaves.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite a descrição da chave!!");
            TfDescChaves.requestFocus();
        } else {
            modChv.setDescChv(TfDescChaves.getText());
            modChv.setDescSet((String) CbSetores.getSelectedItem());
            control.InserirChaves(modChv);
            atualizarCampos();
            limparTabelaChaves();
            JOptionPane.showMessageDialog(rootPane, "A Chave : " + modChv.getDescChv() + " foi registrada com sucesso!!");
            CbSetores.setEnabled(false);
            TfDescChaves.setEnabled(false);
            TbChaves.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtEditar.setEnabled(true);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modChv.setCodChv(Integer.valueOf(TfCodChaves.getText()));
        modChv.setDescChv(TfDescChaves.getText());
        control.ExcluirChaves(modChv);
        atualizarCampos();
        limparTabelaChaves();
        TfCodChaves.setEnabled(false);
        CbSetores.setEnabled(false);
        TfDescChaves.setEnabled(false);
        TbChaves.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtEditar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaChaves();
        CbSetores.setEnabled(true);
        TfDescChaves.setEnabled(true);
        TfDescChaves.requestFocus();
        TbChaves.setEnabled(false);
        TbChaves.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modChv.setCodChv(Integer.valueOf(TfCodChaves.getText()));
        modChv.setDescChv(TfDescChaves.getText());
        modChv.setDescSet((String) CbSetores.getSelectedItem());
        control.AlterarChaves(modChv);
        JOptionPane.showMessageDialog(rootPane, "A Chave : " + modChv.getDescChv() + " foi alterada com sucesso!!");
        atualizarCampos();
        limparTabelaChaves();
        TfCodChaves.setEnabled(false);
        CbSetores.setEnabled(false);
        TfDescChaves.setEnabled(false);
        TbChaves.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultar.setEnabled(false);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        limparTabelaChaves();
        TfCodChaves.setEnabled(false);
        CbSetores.setEnabled(false);
        TfDescChaves.setEnabled(false);
        TbChaves.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaChaves();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbChavesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbChavesMouseClicked

        String desc_chv = "" + TbChaves.getValueAt(TbChaves.getSelectedRow(), 0);
        conChv.conexao();
        conChv.executaSQL("select * from vw_chaves where desc_chv = '" + desc_chv + "'");
        try {
            conChv.rs.first();
            TfCodChaves.setText(conChv.rs.getString("cod_chv"));
            CbSetores.setSelectedItem(conChv.rs.getString("desc_set"));
            TfDescChaves.setText(conChv.rs.getString("desc_chv"));
            habiltaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conChv.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbChavesMouseClicked

    private void TfCodChavesKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodChavesKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodChavesKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        nomeChv = JOptionPane.showInputDialog(null, "Digite a descrição da chave ");
        if (nomeChv.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição da chave desejada.");
        } else {
            pesquisaTabelaChaves();
            TbChaves.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    public void preencherTabelaChaves(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Descrição Chave", "Setor"};
        conChv.conexao();
        conChv.executaSQL(SQL);
        try {
            conChv.rs.first();
            do {
                dados.add(new Object[]{conChv.rs.getString("desc_chv"), conChv.rs.getString("desc_set")});
            } while (conChv.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma chave cadastrada com essa descrição!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbChaves.setModel(modTabela);
        TbChaves.getColumnModel().getColumn(0).setPreferredWidth(200);
        TbChaves.getColumnModel().getColumn(0).setResizable(false);
        TbChaves.getColumnModel().getColumn(1).setPreferredWidth(179);
        TbChaves.getColumnModel().getColumn(1).setResizable(false);
        TbChaves.getTableHeader().setReorderingAllowed(false);
        TbChaves.setAutoResizeMode(TbChaves.AUTO_RESIZE_OFF);
        TbChaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conChv.desconecta();
    }

    public void limparTabelaChaves(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Descrição Chave", "Setor"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbChaves.setModel(modTabela);
        TbChaves.getColumnModel().getColumn(0).setPreferredWidth(200);
        TbChaves.getColumnModel().getColumn(0).setResizable(false);
        TbChaves.getColumnModel().getColumn(1).setPreferredWidth(179);
        TbChaves.getColumnModel().getColumn(1).setResizable(false);
        TbChaves.getTableHeader().setReorderingAllowed(false);
        TbChaves.setAutoResizeMode(TbChaves.AUTO_RESIZE_OFF);
        TbChaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbSetores;
    private javax.swing.JTable TbChaves;
    private javax.swing.JFormattedTextField TfCodChaves;
    private javax.swing.JTextField TfDescChaves;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

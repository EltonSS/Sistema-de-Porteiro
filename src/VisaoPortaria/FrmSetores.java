package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleSetoresFuncionarios;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloSetoresFuncionarios;
import ModeloSistema.ModeloTabela;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmSetores extends javax.swing.JInternalFrame {

    ConectaBanco conSet = new ConectaBanco();
    ConectaBanco conSet2 = new ConectaBanco();
    ConectaBanco conRm = new ConectaBanco();
    ModeloSetoresFuncionarios modSet = new ModeloSetoresFuncionarios();
    ControleSetoresFuncionarios controlSet = new ControleSetoresFuncionarios();
    String descSetor, setor = "";
    boolean cbRamal = false;

    public FrmSetores() throws SQLException {

        initComponents();
    }
//
//    public void preencherCbRamais() {
//
//        CbRamal.addItem("Escolha o Ramal");
//        try {
//            conRm.conexao();
//            conRm.executaSQL("select * from tab_ramais_administrativo");
//            conRm.rs.first();
//            do {
//                CbRamal.addItem(conRm.rs.getString("Num_Rm"));
//            } while (conRm.rs.next());
//        } catch (SQLException ex) {
//            //            JOptionPane.showMessageDialog(null, "Não foi possível localizar as descrições das torres \n ERRO :" );
//        }
//        conSet.desconecta();
//    }

    public void habilitaCampos() {

        TbSetores.setEnabled(true);
        TfDescricaoSetor.setEnabled(true);
    }

    public void atualizarCampos() {

        TfCodSetor.setText("");
        TfDescricaoSetor.setText("");
    }

    public void atualizarTabelaSetores() {

        preencherTabelaSetores("select * from tab_setores where desc_set like '%" + descSetor + "%'");
    }

    public void limparTabelaSetores() {

        limparTabelaSetores("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfCodSetor = new javax.swing.JTextField();
        TfDescricaoSetor = new javax.swing.JTextField();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        BtConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbSetores = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Setores Funcionários");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Setor *");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Descrição do Setor *");

        TfCodSetor.setToolTipText("Código do tipo de funcionário");
        TfCodSetor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfCodSetor.setEnabled(false);

        TfDescricaoSetor.setToolTipText("Digite a descrição do tipo de funcionário");
        TfDescricaoSetor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoSetor.setEnabled(false);
        TfDescricaoSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfDescricaoSetorActionPerformed(evt);
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

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Fornecedor");
        BtConsultar.setEnabled(false);
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfCodSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(TfDescricaoSetor, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfCodSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(TfDescricaoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BtSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastrar Setores dos Funcionários");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Ramais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbSetores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbSetores.setToolTipText(" Lista dos tipos de funcionários cadastrados");
        TbSetores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbSetoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbSetores);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );

        setBounds(0, 0, 473, 461);
    }// </editor-fold>//GEN-END:initComponents

    public void verificaSetor() {

        conSet2.conexao();
        try {
            conSet2.executaSQL("select * from tab_setores where desc_set = '" + TfDescricaoSetor.getText() + "'");
            conSet2.rs.first();
            setor = conSet2.rs.getString("desc_set");           
        } catch (SQLException ex) {
            Logger.getLogger(FrmSetores.class.getName()).log(Level.SEVERE, null, ex);
        }
        conSet2.desconecta();
    }

    public void salvarRegistro() {

        if (TfDescricaoSetor.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Falta a descrição do setor!!");
        } else {
            verificaSetor();
            if (TfDescricaoSetor.getText().equals(setor)) {
                JOptionPane.showMessageDialog(null, "Já existe setor cadastrado com esse nome!!");
            } else {
                modSet.setDesc_set(TfDescricaoSetor.getText());
                controlSet.InserirSetor(modSet);
                atualizarCampos();
                limparTabelaSetores();
                JOptionPane.showMessageDialog(rootPane, "O setor : " + modSet.getDesc_set() + " foi registrado com sucesso!!");
                TfDescricaoSetor.setEnabled(false);
                BtExcluir.setEnabled(false);
                BtAlterar.setEnabled(false);
                BtEditar.setEnabled(true);
                BtCancelar.setEnabled(false);
                BtSalvar.setEnabled(false);
                BtAdicionar.setEnabled(true);
            }
        }
    }

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        salvarRegistro();
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modSet.setDesc_set(TfDescricaoSetor.getText());
        modSet.setCod_set(Integer.parseInt(TfCodSetor.getText()));
        controlSet.ExcluirSetor(modSet);
        atualizarCampos();
        limparTabelaSetores();
        JOptionPane.showMessageDialog(rootPane, "O setor : " + modSet.getDesc_set() + " foi excluído com sucesso!!");
        TfDescricaoSetor.setEnabled(false);
        TbSetores.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtAdicionar.setEnabled(true);
        BtConsultar.setEnabled(false);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaSetores();
        habilitaCampos();
        TfDescricaoSetor.requestFocus();
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
        BtEditar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modSet.setCod_set(Integer.parseInt(TfCodSetor.getText()));
        modSet.setDesc_set(TfDescricaoSetor.getText());
        controlSet.AlterarSetor(modSet);
        atualizarCampos();
        limparTabelaSetores();
        JOptionPane.showMessageDialog(rootPane, "O setor : " + modSet.getDesc_set() + " foi alterado com sucesso!!");
        TfDescricaoSetor.setEnabled(false);
        TbSetores.setEnabled(false);
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
        limparTabelaSetores();
        TbSetores.setEnabled(false);
        TfDescricaoSetor.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultar.setEnabled(false);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaSetores();
        BtExcluir.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
        BtConsultar.setEnabled(true);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbSetoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbSetoresMouseClicked

        String descSt = "" + TbSetores.getValueAt(TbSetores.getSelectedRow(), 0);
        conSet.conexao();
        conSet.executaSQL("select * from tab_setores where desc_set = '" + descSt + "'");
        try {
            conSet.rs.first();
            TfCodSetor.setText(String.valueOf(conSet.rs.getInt("cod_set")));
            TfDescricaoSetor.setText(conSet.rs.getString("desc_set"));
            habilitaCampos();
            BtAlterar.setEnabled(true);
            BtExcluir.setEnabled(true);
            BtConsultar.setEnabled(false);
            conSet.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbSetoresMouseClicked

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        descSetor = JOptionPane.showInputDialog(null, "Digite a descrição do setor :");
        if (descSetor.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição do setor desejado.");
        } else {
            atualizarTabelaSetores();
            TbSetores.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void TfDescricaoSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfDescricaoSetorActionPerformed

        salvarRegistro();
    }//GEN-LAST:event_TfDescricaoSetorActionPerformed

    public void preencherTabelaSetores(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Setores"};
        conSet.conexao();
        conSet.executaSQL(SQL);
        try {
            conSet.rs.first();
            do {
                dados.add(new Object[]{conSet.rs.getString("Desc_set")});
            } while (conSet.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane,"Erro ao preencher a tabela!!\n Erro: "+ex);  
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbSetores.setModel(modTabela);
        TbSetores.getColumnModel().getColumn(0).setPreferredWidth(402);
        TbSetores.getColumnModel().getColumn(0).setResizable(false);
        TbSetores.getTableHeader().setReorderingAllowed(false);
        TbSetores.setAutoResizeMode(TbSetores.AUTO_RESIZE_OFF);
        TbSetores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conSet.desconecta();
    }

    public void limparTabelaSetores(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Setores"};
        dados.add(new Object[]{""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbSetores.setModel(modTabela);
        TbSetores.getColumnModel().getColumn(0).setPreferredWidth(402);
        TbSetores.getColumnModel().getColumn(0).setResizable(false);
        TbSetores.getTableHeader().setReorderingAllowed(false);
        TbSetores.setAutoResizeMode(TbSetores.AUTO_RESIZE_OFF);
        TbSetores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JTable TbSetores;
    private javax.swing.JTextField TfCodSetor;
    private javax.swing.JTextField TfDescricaoSetor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleCores;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloCores;
import ModeloSistema.TratamentoCampos;

public class FrmCores extends javax.swing.JInternalFrame {

    ConectaBanco conCor = new ConectaBanco();
    ModeloCores modCor = new ModeloCores();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleCores control = new ControleCores();
    String descCores = "";

    public FrmCores() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
    }

    public void atualizarCampos() {

        TfCodCor.setText("");
        TfDescricaoCor.setText("");
    }

    public void habiltaCampos() {

        TfDescricaoCor.setEnabled(true);
    }

    public void pesquisaTabelaFabricantes() {

        preencherTabelaCores(" select * from tab_cores where desc_cor like '%" + descCores + "%'");
    }

    public void limparTabelaCores() {

        limparTabelaCores("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TfDescricaoCor = new javax.swing.JTextField();
        TfCodCor = new javax.swing.JFormattedTextField();
        BtConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbCores = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Cores");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Cor");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descrição Cor");

        TfDescricaoCor.setToolTipText("Digite a Descrição da Cor");
        TfDescricaoCor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoCor.setEnabled(false);
        TfDescricaoCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfDescricaoCorKeyTyped(evt);
            }
        });

        TfCodCor.setToolTipText("Código da Cor");
        TfCodCor.setEnabled(false);
        TfCodCor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodCorKeyTyped(evt);
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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(TfDescricaoCor, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(TfCodCor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
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
                                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfCodCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26))
                    .addComponent(TfDescricaoCor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Cores");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TbCores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbCores.setToolTipText("Lista de cores");
        TbCores.setEnabled(false);
        TbCores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbCoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbCores);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Lista de Fabricantes");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 432, 425);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfDescricaoCor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite a descrição da cor!!");
            TfDescricaoCor.requestFocus();
        } else {
            modCor.setDescCor(TfDescricaoCor.getText());
            control.InserirCor(modCor);
            atualizarCampos();
            limparTabelaCores();
            TfCodCor.setEnabled(false);
            TfDescricaoCor.setEnabled(false);
            TbCores.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtEditar.setEnabled(true);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modCor.setCodCor(Integer.valueOf(TfCodCor.getText()));
        modCor.setDescCor(TfDescricaoCor.getText());
        control.ExcluirCor(modCor);
        atualizarCampos();
        limparTabelaCores();
        TfCodCor.setEnabled(false);
        TfDescricaoCor.setEnabled(false);
        TbCores.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtEditar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaCores();
        TfDescricaoCor.setEnabled(true);
        TbCores.setEnabled(false);
        TfDescricaoCor.requestFocus();
        TbCores.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modCor.setCodCor(Integer.valueOf(TfCodCor.getText()));
        modCor.setDescCor(TfDescricaoCor.getText());
        control.AlterarCor(modCor);
        atualizarCampos();
        limparTabelaCores();
        TfCodCor.setEnabled(false);
        TfDescricaoCor.setEnabled(false);
        TbCores.setEnabled(false);
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
        limparTabelaCores();
        TfCodCor.setEnabled(false);
        TfDescricaoCor.setEnabled(false);
        TbCores.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaCores();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbCoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbCoresMouseClicked

        String desc_cor = "" + TbCores.getValueAt(TbCores.getSelectedRow(), 0);
        conCor.conexao();
        conCor.executaSQL("select * from tab_cores where desc_cor = '" + desc_cor + "'");
        try {
            conCor.rs.first();
            TfCodCor.setText(conCor.rs.getString("cod_cor"));
            TfDescricaoCor.setText(conCor.rs.getString("desc_cor"));
            habiltaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conCor.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbCoresMouseClicked

    private void TfCodCorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodCorKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodCorKeyTyped

    private void TfDescricaoCorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfDescricaoCorKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfDescricaoCorKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        descCores = JOptionPane.showInputDialog(null, "Digite a descrição da cor");
        if (descCores.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                                              + "Para realizar a consulta digite a descrição da cor desejado.");
        } else {
            pesquisaTabelaFabricantes();
            TbCores.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    public void preencherTabelaCores(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Desc.Cores"};
        conCor.conexao();
        conCor.executaSQL(SQL);
        try {
            conCor.rs.first();
            do {
                dados.add(new Object[]{conCor.rs.getString("desc_cor")});
            } while (conCor.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Cor não cadastrada!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbCores.setModel(modTabela);
        TbCores.getColumnModel().getColumn(0).setPreferredWidth(369);
        TbCores.getColumnModel().getColumn(0).setResizable(false);
        TbCores.getTableHeader().setReorderingAllowed(false);
        TbCores.setAutoResizeMode(TbCores.AUTO_RESIZE_OFF);
        TbCores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conCor.desconecta();
    }

    public void limparTabelaCores(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Desc.Cores"};
        dados.add(new Object[]{""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbCores.setModel(modTabela);
        TbCores.getColumnModel().getColumn(0).setPreferredWidth(369);
        TbCores.getColumnModel().getColumn(0).setResizable(false);
        TbCores.getTableHeader().setReorderingAllowed(false);
        TbCores.setAutoResizeMode(TbCores.AUTO_RESIZE_OFF);
        TbCores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JTable TbCores;
    private javax.swing.JFormattedTextField TfCodCor;
    private javax.swing.JTextField TfDescricaoCor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

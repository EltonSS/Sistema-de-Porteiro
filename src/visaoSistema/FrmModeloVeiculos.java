package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleModelosVeiculos;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloModelosVeiculos;
import ModeloSistema.TratamentoCampos;

public class FrmModeloVeiculos extends javax.swing.JInternalFrame {

    ConectaBanco conMd = new ConectaBanco();
    ConectaBanco conMc = new ConectaBanco();
    ModeloModelosVeiculos modMd = new ModeloModelosVeiculos();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleModelosVeiculos control = new ControleModelosVeiculos();
    String descMd = "";

    public FrmModeloVeiculos() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        preencherCbModeloVeiculo();
    }

    public void preencherCbModeloVeiculo() {

        conMc.conexao();
        conMc.executaSQL("select * from tab_marca_veiculos");
        try {
            conMc.rs.first();
            do {
                CbMarcaVeiculo.addItem(conMc.rs.getString("desc_mc"));
            } while (conMc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar a modelos veículos \n ERRO :" + ex);
        }
        conMc.desconecta();
    }

    public void atualizarCampos() {

        TfCodModeloVeiculo.setText("");
        TfDescricaoModeloVeiculo.setText("");
    }

    public void habiltaCampos() {

        TfDescricaoModeloVeiculo.setEnabled(true);
        CbMarcaVeiculo.setEnabled(true);
    }

    public void pesquisaTabelaModeloVeiculo() {

        preencherTabelaModeloVeiculo(" select * from vw_modeloVeiculo where desc_md like '%" + descMd + "%'");
    }

    public void limparTabelaModeloVeiculo() {

        limparTabelaModeloVeiculo("");
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
        TfDescricaoModeloVeiculo = new javax.swing.JTextField();
        TfCodModeloVeiculo = new javax.swing.JFormattedTextField();
        CbMarcaVeiculo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        BtConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbModelosVeiculos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Modelos de Veículos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Modelo Veículo");

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
        jLabel4.setText("Descrição Modelo Veículo");

        TfDescricaoModeloVeiculo.setToolTipText("Digite o Nome do Cliente");
        TfDescricaoModeloVeiculo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoModeloVeiculo.setEnabled(false);

        TfCodModeloVeiculo.setToolTipText("Digite o CPF");
        TfCodModeloVeiculo.setEnabled(false);
        TfCodModeloVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodModeloVeiculoKeyTyped(evt);
            }
        });

        CbMarcaVeiculo.setToolTipText("Escolha o tipo de funcionário");
        CbMarcaVeiculo.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Marcas de Veículos");

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TfDescricaoModeloVeiculo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(CbMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfCodModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfCodModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(26, 26, 26))
                        .addComponent(TfDescricaoModeloVeiculo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CbMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
        jLabel1.setText("Cadastros de Modelos de Veículos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Modelos de Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbModelosVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbModelosVeiculos.setToolTipText("Lista de Materiais");
        TbModelosVeiculos.setEnabled(false);
        TbModelosVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbModelosVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbModelosVeiculos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
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
                        .addComponent(jLabel1)
                        .addGap(0, 116, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 554, 480);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfDescricaoModeloVeiculo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite a descrição do modelo de veículo!!");
            TfDescricaoModeloVeiculo.requestFocus();
        } else {
            modMd.setDescMod(TfDescricaoModeloVeiculo.getText());
            modMd.setDescMc((String) CbMarcaVeiculo.getSelectedItem());
            control.InserirModeloVeiculo(modMd);
            atualizarCampos();
            limparTabelaModeloVeiculo();
            TfCodModeloVeiculo.setEnabled(false);
            TfDescricaoModeloVeiculo.setEnabled(false);
            CbMarcaVeiculo.setEnabled(false);
            TbModelosVeiculos.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtEditar.setEnabled(true);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modMd.setCodMod(Integer.valueOf(TfCodModeloVeiculo.getText()));
        modMd.setDescMc(TfDescricaoModeloVeiculo.getText());
        control.ExcluirModelosVeiculos(modMd);
        atualizarCampos();
        limparTabelaModeloVeiculo();
        TfCodModeloVeiculo.setEnabled(false);
        TfDescricaoModeloVeiculo.setEnabled(false);
        CbMarcaVeiculo.setEnabled(false);
        TbModelosVeiculos.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtEditar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaModeloVeiculo();
        TfDescricaoModeloVeiculo.setEnabled(true);
        TfDescricaoModeloVeiculo.requestFocus();
        CbMarcaVeiculo.setEnabled(true);
        TbModelosVeiculos.setEnabled(false);
        TbModelosVeiculos.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modMd.setCodMod(Integer.valueOf(TfCodModeloVeiculo.getText()));
        modMd.setDescMod(TfDescricaoModeloVeiculo.getText());
        modMd.setDescMc((String) CbMarcaVeiculo.getSelectedItem());
        control.AlterarModelosVeiculos(modMd);
        atualizarCampos();
        limparTabelaModeloVeiculo();
        TfCodModeloVeiculo.setEnabled(false);
        TfDescricaoModeloVeiculo.setEnabled(false);
        CbMarcaVeiculo.setEnabled(false);
        TbModelosVeiculos.setEnabled(false);
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
        limparTabelaModeloVeiculo();
        TfCodModeloVeiculo.setEnabled(false);
        TfDescricaoModeloVeiculo.setEnabled(false);
        CbMarcaVeiculo.setEnabled(false);
        TbModelosVeiculos.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaModeloVeiculo();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbModelosVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbModelosVeiculosMouseClicked

        String desc_md = "" + TbModelosVeiculos.getValueAt(TbModelosVeiculos.getSelectedRow(), 0);
        conMd.conexao();
        conMd.executaSQL("select * from vw_modeloveiculo where desc_md = '" + desc_md + "'");
        try {
            conMd.rs.first();
            TfCodModeloVeiculo.setText(conMd.rs.getString("cod_md"));
            TfDescricaoModeloVeiculo.setText(conMd.rs.getString("desc_md"));
            CbMarcaVeiculo.setSelectedItem(conMd.rs.getString("desc_mc"));
            habiltaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conMd.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbModelosVeiculosMouseClicked

    private void TfCodModeloVeiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodModeloVeiculoKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodModeloVeiculoKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        descMd = JOptionPane.showInputDialog(null, "Digite a descrição do modelo de veículo");
        if (descMd.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição do modelo de veículo desejado.");
        } else {
            pesquisaTabelaModeloVeiculo();
            TbModelosVeiculos.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    public void preencherTabelaModeloVeiculo(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Desc. Modelos Veículos", "Marcas"};
        conMd.conexao();
        conMd.executaSQL(SQL);
        try {
            conMd.rs.first();
            do {
                dados.add(new Object[]{conMd.rs.getString("desc_md"), conMd.rs.getString("desc_mc")});
            } while (conMd.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Modelo de veículo não cadastrado!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbModelosVeiculos.setModel(modTabela);
        TbModelosVeiculos.getColumnModel().getColumn(0).setPreferredWidth(246);
        TbModelosVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbModelosVeiculos.getColumnModel().getColumn(1).setPreferredWidth(246);
        TbModelosVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbModelosVeiculos.getTableHeader().setReorderingAllowed(false);
        TbModelosVeiculos.setAutoResizeMode(TbModelosVeiculos.AUTO_RESIZE_OFF);
        TbModelosVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conMd.desconecta();
    }

    public void limparTabelaModeloVeiculo(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Desc. Modelos Veículos", "Marcas"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbModelosVeiculos.setModel(modTabela);
        TbModelosVeiculos.getColumnModel().getColumn(0).setPreferredWidth(246);
        TbModelosVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbModelosVeiculos.getColumnModel().getColumn(1).setPreferredWidth(246);
        TbModelosVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbModelosVeiculos.getTableHeader().setReorderingAllowed(false);
        TbModelosVeiculos.setAutoResizeMode(TbModelosVeiculos.AUTO_RESIZE_OFF);
        TbModelosVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbMarcaVeiculo;
    private javax.swing.JTable TbModelosVeiculos;
    private javax.swing.JFormattedTextField TfCodModeloVeiculo;
    private javax.swing.JTextField TfDescricaoModeloVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

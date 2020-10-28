package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControlePorteiros;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloPorteiros;
import ModeloSistema.TratamentoCampos;

public class FrmPorteiros extends javax.swing.JInternalFrame {

    ConectaBanco conPort = new ConectaBanco();
    ConectaBanco conPort2 = new ConectaBanco();
    ModeloPorteiros modPort = new ModeloPorteiros();
    ControlePorteiros control = new ControlePorteiros();
    TratamentoCampos tCampos = new TratamentoCampos();
    String nomePort;

    public FrmPorteiros() throws SQLException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
    }

    public void atualizarCampos() {

        TfCodPorteiro.setText("");
        TfNomePorteiro.setText("");
        TfLoginPorteiro.setText("");
        PwdTfPorteiro.setText("");
    }

    public void atualizarTabelaPorteiro() {

        preencherTabelaPorteiro("select * from tab_porteiros where nome_port like '%" + nomePort + "%'");
    }

    public void limparTabelaPorteiro() {

        limparTabelaPorteiro("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioGrupoPermissaoEstoque = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TfCodPorteiro = new javax.swing.JTextField();
        TfNomePorteiro = new javax.swing.JTextField();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BtEditar = new javax.swing.JButton();
        PwdTfPorteiro = new javax.swing.JPasswordField();
        BtConsultar = new javax.swing.JButton();
        TfLoginPorteiro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPorteiro = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastros de Porteiros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Porteiro");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nome Porteiro");

        TfCodPorteiro.setToolTipText("Código do porteiro");
        TfCodPorteiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfCodPorteiro.setEnabled(false);

        TfNomePorteiro.setToolTipText("Digite o nome do porteiro");
        TfNomePorteiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomePorteiro.setEnabled(false);
        TfNomePorteiro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNomePorteiroKeyTyped(evt);
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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Senha Porteiro");

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });

        PwdTfPorteiro.setToolTipText("Digite a senha do porteiro");
        PwdTfPorteiro.setEnabled(false);

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Fornecedor");
        BtConsultar.setEnabled(false);
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });

        TfLoginPorteiro.setToolTipText("Digite o nome do porteiro");
        TfLoginPorteiro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfLoginPorteiro.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Login Porteiro");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
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
                        .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TfCodPorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(TfLoginPorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(PwdTfPorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(TfNomePorteiro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TfCodPorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(TfNomePorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(TfLoginPorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(5, 5, 5)
                        .addComponent(PwdTfPorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(BtSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtConsultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Porteiros");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Porteiros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbPorteiro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbPorteiro.setToolTipText("Lista dos funcionários cadastrados");
        TbPorteiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPorteiroMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbPorteiro);

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 454, 515);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfNomePorteiro.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do porteiro");
        } else {
            if (TfLoginPorteiro.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite o login do porteiro");
            } else {
                if (PwdTfPorteiro.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Digite a senha do porteiro!!");
                } else {
                    modPort.setNomePort(TfNomePorteiro.getText());
                    modPort.setLoginPort(TfLoginPorteiro.getText());
                    modPort.setSenhaPort((PwdTfPorteiro.getText()));
                    control.InserirPorteiro(modPort);
                    atualizarCampos();
                    limparTabelaPorteiro();
                    JOptionPane.showMessageDialog(rootPane, "O porteiro : " + modPort.getNomePort() + " foi registrado com sucesso!!");
                    TfNomePorteiro.setEnabled(false);
                    TfLoginPorteiro.setEnabled(false);
                    PwdTfPorteiro.setEnabled(false);
                    TbPorteiro.setEnabled(false);
                    BtExcluir.setEnabled(false);
                    BtAlterar.setEnabled(false);
                    BtEditar.setEnabled(true);
                    BtCancelar.setEnabled(false);
                    BtSalvar.setEnabled(false);
                    BtAdicionar.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modPort.setCodPort(Integer.parseInt(TfCodPorteiro.getText()));
        modPort.setNomePort(TfNomePorteiro.getText());
        TbPorteiro.setEnabled(false);
        control.ExcluirPorteiro(modPort);
        atualizarCampos();
        limparTabelaPorteiro();        
        TfNomePorteiro.setEnabled(false);
        TfLoginPorteiro.setEnabled(false);
        PwdTfPorteiro.setEnabled(false);
        TbPorteiro.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtEditar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaPorteiro();
        TfNomePorteiro.setEnabled(true);
        TfNomePorteiro.requestFocus();
        TfLoginPorteiro.setEnabled(true);
        PwdTfPorteiro.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modPort.setCodPort(Integer.parseInt(TfCodPorteiro.getText()));
        modPort.setNomePort(TfNomePorteiro.getText());
        modPort.setLoginPort(TfLoginPorteiro.getText());
        modPort.setSenhaPort(PwdTfPorteiro.getText());
        control.AlterarPorteiro(modPort);
        atualizarCampos();
        limparTabelaPorteiro();
        JOptionPane.showMessageDialog(rootPane, "O porteiro : " + modPort.getNomePort() + " foi alterado com sucesso!!");
        TfNomePorteiro.setEnabled(false);
        TfLoginPorteiro.setEnabled(false);
        PwdTfPorteiro.setEnabled(false);
        TbPorteiro.setEnabled(false);
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
        limparTabelaPorteiro();
        TfNomePorteiro.setEnabled(false);
        TfLoginPorteiro.setEnabled(false);
        PwdTfPorteiro.setEnabled(false);
        TbPorteiro.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaPorteiro();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbPorteiroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPorteiroMouseClicked

        String nome_port = "" + TbPorteiro.getValueAt(TbPorteiro.getSelectedRow(), 1);
        conPort.conexao();
        conPort.executaSQL("select * from tab_porteiros where nome_port = '" + nome_port + "'");
        try {
            conPort.rs.first();
            TfCodPorteiro.setText(String.valueOf(conPort.rs.getInt("cod_port")));
            TfNomePorteiro.setText(conPort.rs.getString("nome_port"));
            TfLoginPorteiro.setText(conPort.rs.getString("login_port"));
            PwdTfPorteiro.setText(conPort.rs.getString("senha_port"));
            TfNomePorteiro.setEnabled(true);
            TfNomePorteiro.requestFocus();
            TfLoginPorteiro.setEnabled(true);
            PwdTfPorteiro.setEnabled(true);
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos !!\n Erro: " + ex);
        }
        conPort.desconecta();
    }//GEN-LAST:event_TbPorteiroMouseClicked

    private void TfNomePorteiroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNomePorteiroKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfNomePorteiroKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        nomePort = JOptionPane.showInputDialog(null, "Digite o nome do porteiro");
        if (nomePort.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição do porteiro desejado.");
        } else {
            atualizarTabelaPorteiro();
            TbPorteiro.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    public void preencherTabelaPorteiro(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Cód. Porteiro", "Nome Porteiro"};
        conPort.conexao();
        conPort.executaSQL(SQL);
        try {
            conPort.rs.first();
            do {
                dados.add(new Object[]{conPort.rs.getString("cod_port"), conPort.rs.getString("nome_port")});
            } while (conPort.rs.next());
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(rootPane, "Não existe nenhum porteiro cadastrado com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPorteiro.setModel(modTabela);
        TbPorteiro.getColumnModel().getColumn(0).setPreferredWidth(100);
        TbPorteiro.getColumnModel().getColumn(0).setResizable(false);
        TbPorteiro.getColumnModel().getColumn(1).setPreferredWidth(291);
        TbPorteiro.getColumnModel().getColumn(1).setResizable(false);
        TbPorteiro.getTableHeader().setReorderingAllowed(false);
        TbPorteiro.setAutoResizeMode(TbPorteiro.AUTO_RESIZE_OFF);
        TbPorteiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conPort.desconecta();
    }

    public void limparTabelaPorteiro(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Cód. Porteiro", "Nome Porteiro"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPorteiro.setModel(modTabela);
        TbPorteiro.getColumnModel().getColumn(0).setPreferredWidth(100);
        TbPorteiro.getColumnModel().getColumn(0).setResizable(false);
        TbPorteiro.getColumnModel().getColumn(1).setPreferredWidth(291);
        TbPorteiro.getColumnModel().getColumn(1).setResizable(false);
        TbPorteiro.getTableHeader().setReorderingAllowed(false);
        TbPorteiro.setAutoResizeMode(TbPorteiro.AUTO_RESIZE_OFF);
        TbPorteiro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JPasswordField PwdTfPorteiro;
    private javax.swing.ButtonGroup RadioGrupoPermissaoEstoque;
    private javax.swing.JTable TbPorteiro;
    private javax.swing.JTextField TfCodPorteiro;
    private javax.swing.JTextField TfLoginPorteiro;
    private javax.swing.JTextField TfNomePorteiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

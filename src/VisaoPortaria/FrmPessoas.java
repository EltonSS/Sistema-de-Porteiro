package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControlePessoas;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloPessoas;
import ModeloSistema.TratamentoCampos;

public class FrmPessoas extends javax.swing.JInternalFrame {

    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conTpPs = new ConectaBanco();
    ConectaBanco conPesquisa = new ConectaBanco();
    ModeloPessoas modPs = new ModeloPessoas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControlePessoas control = new ControlePessoas();
    String nomePs = "", cadastrado;

    public FrmPessoas() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        camposTelefones();
        campoRg();
        preencherCbTipoPessoas();
    }

    public void preencherCbTipoPessoas() {

        conTpPs.conexao();
        conTpPs.executaSQL("select * from tab_tipos_pessoas");
        try {
            conTpPs.rs.first();
            do {
                CbTipoPessoa.addItem(conTpPs.rs.getString("desc_tp_ps"));
            } while (conTpPs.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o tipo de pessoa \n ERRO :" + ex);
        }
        conTpPs.desconecta();
    }

    public void campoRg() {

        try {
            MaskFormatter Rg = new MaskFormatter("#######");
            TfRgPessoa.setFormatterFactory(new DefaultFormatterFactory(Rg));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a data!! \n ERRO :" + ex);
        }
    }

    public void camposTelefones() {

        try {
            MaskFormatter foneComecForm = new MaskFormatter("(##)####-####");
            TfFoneFixo.setFormatterFactory(new DefaultFormatterFactory(foneComecForm));
            MaskFormatter foneCelForm = new MaskFormatter("(##)#####-####");
            TfFoneCelular.setFormatterFactory(new DefaultFormatterFactory(foneCelForm));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a data!! \n ERRO :" + ex);
        }
    }

    public void atualizarCampos() {

        TfCodPessoa.setText("");
        TfNomePessoa.setText("");
        TfFoneCelular.setText("");
        TfFoneFixo.setText("");
        TfRgPessoa.setText("");
        TfEmail.setText("");
    }

    public void habiltaCampos() {

        TfNomePessoa.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfRgPessoa.setEnabled(true);
        TfEmail.setEnabled(true);
        CbTipoPessoa.setEnabled(true);
    }

    public void pesquisaTabelaPessoas() {

        preencherTabelaPessoas(" select * from vw_pessoa where nome_ps like '%" + nomePs + "%'");
    }

    public void limparTabelaPessoas() {

        limparTabelaPessoas("");
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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TfNomePessoa = new javax.swing.JTextField();
        TfEmail = new javax.swing.JTextField();
        TfCodPessoa = new javax.swing.JFormattedTextField();
        TfFoneFixo = new javax.swing.JFormattedTextField();
        TfRgPessoa = new javax.swing.JFormattedTextField();
        CbTipoPessoa = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        BtConsultar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        TfFoneCelular = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPessoa = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Pessoas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Pessoa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        BtAdicionar.setToolTipText("Adicionar Registro");
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 156, 48, 48));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.setEnabled(false);
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 156, 48, 48));

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 156, 48, 48));

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.setEnabled(false);
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 156, 48, 48));

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 156, 48, 48));

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 156, 48, 48));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome Pessoa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 59, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Fone Fixo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 105, 56, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fone Celular");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 105, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("E-mail");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 105, -1, -1));

        TfNomePessoa.setToolTipText("Digite o Nome do Cliente");
        TfNomePessoa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomePessoa.setEnabled(false);
        TfNomePessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNomePessoaKeyTyped(evt);
            }
        });
        jPanel1.add(TfNomePessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 79, 326, -1));

        TfEmail.setToolTipText("Digite o E-mail");
        TfEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfEmail.setEnabled(false);
        jPanel1.add(TfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 125, 317, -1));

        TfCodPessoa.setToolTipText("Digite o CPF");
        TfCodPessoa.setEnabled(false);
        TfCodPessoa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodPessoaKeyTyped(evt);
            }
        });
        jPanel1.add(TfCodPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 33, 114, -1));

        TfFoneFixo.setToolTipText("Digite o Fone Comercial");
        TfFoneFixo.setEnabled(false);
        jPanel1.add(TfFoneFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 125, 142, -1));

        TfRgPessoa.setToolTipText("Digite o Fone Celular");
        TfRgPessoa.setEnabled(false);
        jPanel1.add(TfRgPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 79, 126, -1));

        CbTipoPessoa.setToolTipText("Escolha o tipo de funcionário");
        CbTipoPessoa.setEnabled(false);
        jPanel1.add(CbTipoPessoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 79, 142, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Tipo Pessoa");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(476, 59, -1, -1));

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Fornecedor");
        BtConsultar.setEnabled(false);
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(BtConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 156, 48, 48));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Rg");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 59, -1, -1));

        TfFoneCelular.setToolTipText("Digite o Fone Celular");
        TfFoneCelular.setEnabled(false);
        jPanel1.add(TfFoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 125, 142, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Pessoas");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista de Pessoas"));

        TbPessoa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbPessoa.setToolTipText("Lista de Fornecedores");
        TbPessoa.setEnabled(false);
        TbPessoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPessoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbPessoa);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 824, 527);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfNomePessoa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite a descrição do fornecedor!!");
            TfNomePessoa.requestFocus();
        } else {
            modPs.setNomePs(TfNomePessoa.getText());
            modPs.setRgPs(TfRgPessoa.getText());
            modPs.setFoneFixoPs(TfFoneFixo.getText());
            modPs.setCelularPs(TfRgPessoa.getText());
            modPs.setEmailPs(TfEmail.getText());
            modPs.setDescTpPs((String) CbTipoPessoa.getSelectedItem());
            modPs.setCadastrado("Não");
            control.InserirPessoa(modPs);
            atualizarCampos();
            limparTabelaPessoas();
            JOptionPane.showMessageDialog(rootPane, "A Pessoa : " + modPs.getNomePs() + " foi registrada com sucesso!!");
            CbTipoPessoa.setEnabled(false);
            TfNomePessoa.setEnabled(false);
            TfFoneCelular.setEnabled(false);
            TfFoneFixo.setEnabled(false);
            TfRgPessoa.setEnabled(false);
            TfEmail.setEnabled(false);
            TbPessoa.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtEditar.setEnabled(true);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modPs.setCodPs(Integer.valueOf(TfCodPessoa.getText()));
        modPs.setNomePs(TfNomePessoa.getText());
        control.ExcluirPessoa(modPs);
        JOptionPane.showMessageDialog(rootPane, "A Pessoa : " + modPs.getNomePs() + " foi deletada com sucesso!!");
        atualizarCampos();
        limparTabelaPessoas();
        TfCodPessoa.setEnabled(false);
        CbTipoPessoa.setEnabled(false);
        TfNomePessoa.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfRgPessoa.setEnabled(false);
        TfEmail.setEnabled(false);
        TbPessoa.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtEditar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaPessoas();
        CbTipoPessoa.setEnabled(true);
        TfNomePessoa.setEnabled(true);
        TfNomePessoa.requestFocus();
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfRgPessoa.setEnabled(true);
        TfEmail.setEnabled(true);
        TbPessoa.setEnabled(false);
        TbPessoa.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modPs.setCodPs(Integer.valueOf(TfCodPessoa.getText()));
        modPs.setNomePs(TfNomePessoa.getText());
        modPs.setRgPs(TfRgPessoa.getText());
        modPs.setFoneFixoPs(TfFoneFixo.getText());
        modPs.setCelularPs(TfRgPessoa.getText());
        modPs.setEmailPs(TfEmail.getText());
        modPs.setDescTpPs((String) CbTipoPessoa.getSelectedItem());
        modPs.setCadastrado(cadastrado);
        control.AlterarPessoa(modPs);
        JOptionPane.showMessageDialog(rootPane, "A Pessoa : " + modPs.getNomePs() + " foi alterada com sucesso!!");
        atualizarCampos();
        limparTabelaPessoas();
        TfCodPessoa.setEnabled(false);
        CbTipoPessoa.setEnabled(false);
        TfNomePessoa.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfRgPessoa.setEnabled(false);
        TfEmail.setEnabled(false);
        TbPessoa.setEnabled(false);
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
        limparTabelaPessoas();
        TfCodPessoa.setEnabled(false);
        CbTipoPessoa.setEnabled(false);
        TfNomePessoa.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfRgPessoa.setEnabled(false);
        TfEmail.setEnabled(false);
        TbPessoa.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaPessoas();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbPessoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPessoaMouseClicked

        String nome_Ps = "" + TbPessoa.getValueAt(TbPessoa.getSelectedRow(), 0);
        conPs.conexao();
        conPs.executaSQL("select * from vw_pessoa where nome_ps = '" + nome_Ps + "'");
        try {
            conPs.rs.first();
            TfCodPessoa.setText(conPs.rs.getString("cod_ps"));
            CbTipoPessoa.setSelectedItem(conPs.rs.getString("desc_tp_ps"));
            TfNomePessoa.setText(conPs.rs.getString("nome_ps"));
            TfRgPessoa.setText(conPs.rs.getString("rg_ps"));
            TfFoneFixo.setText(conPs.rs.getString("fone_fixo"));
            TfFoneCelular.setText(conPs.rs.getString("celular_ps"));
            TfEmail.setText(conPs.rs.getString("email_ps"));
            cadastrado = conPs.rs.getString("cadastrado");
            habiltaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conPs.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbPessoaMouseClicked

    private void TfCodPessoaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodPessoaKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodPessoaKeyTyped

    private void TfNomePessoaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNomePessoaKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfNomePessoaKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite o nome da pessoa :");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o nome da pessoa desejada.");
        } else {
            pesquisaTabelaPessoas();
            TbPessoa.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    public void preencherTabelaPessoas(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Pessoa", "Rg Pessoa", "Tipo Pessoa", "Fone Fixo", "Fone Celular", "E-mail"};
        conPs.conexao();
        conPs.executaSQL(SQL);
        try {
            conPs.rs.first();
            do {
                dados.add(new Object[]{conPs.rs.getString("nome_ps"), conPs.rs.getString("rg_ps"), conPs.rs.getString("desc_tp_ps"),
                    conPs.rs.getString("Fone_fixo"), conPs.rs.getString("celular_ps"), conPs.rs.getString("Email_ps")});
            } while (conPs.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma pessoa cadastrada com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPessoa.setModel(modTabela);
        TbPessoa.getColumnModel().getColumn(0).setPreferredWidth(150);
        TbPessoa.getColumnModel().getColumn(0).setResizable(false);
        TbPessoa.getColumnModel().getColumn(1).setPreferredWidth(80);
        TbPessoa.getColumnModel().getColumn(1).setResizable(false);
        TbPessoa.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbPessoa.getColumnModel().getColumn(2).setResizable(false);
        TbPessoa.getColumnModel().getColumn(3).setPreferredWidth(90);
        TbPessoa.getColumnModel().getColumn(3).setResizable(false);
        TbPessoa.getColumnModel().getColumn(4).setPreferredWidth(100);
        TbPessoa.getColumnModel().getColumn(4).setResizable(false);
        TbPessoa.getColumnModel().getColumn(5).setPreferredWidth(241);
        TbPessoa.getColumnModel().getColumn(5).setResizable(false);
        TbPessoa.getTableHeader().setReorderingAllowed(false);
        TbPessoa.setAutoResizeMode(TbPessoa.AUTO_RESIZE_OFF);
        TbPessoa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conPs.desconecta();
    }

    public void limparTabelaPessoas(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Pessoa", "Rg Pessoa", "Tipo Pessoa", "Fone Fixo", "Fone Celular", "E-mail"};
        dados.add(new Object[]{"", "", "", "", "", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPessoa.setModel(modTabela);
        TbPessoa.getColumnModel().getColumn(0).setPreferredWidth(150);
        TbPessoa.getColumnModel().getColumn(0).setResizable(false);
        TbPessoa.getColumnModel().getColumn(1).setPreferredWidth(80);
        TbPessoa.getColumnModel().getColumn(1).setResizable(false);
        TbPessoa.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbPessoa.getColumnModel().getColumn(2).setResizable(false);
        TbPessoa.getColumnModel().getColumn(3).setPreferredWidth(90);
        TbPessoa.getColumnModel().getColumn(3).setResizable(false);
        TbPessoa.getColumnModel().getColumn(4).setPreferredWidth(100);
        TbPessoa.getColumnModel().getColumn(4).setResizable(false);
        TbPessoa.getColumnModel().getColumn(5).setPreferredWidth(241);
        TbPessoa.getColumnModel().getColumn(5).setResizable(false);
        TbPessoa.getTableHeader().setReorderingAllowed(false);
        TbPessoa.setAutoResizeMode(TbPessoa.AUTO_RESIZE_OFF);
        TbPessoa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbTipoPessoa;
    private javax.swing.JTable TbPessoa;
    private javax.swing.JFormattedTextField TfCodPessoa;
    private javax.swing.JTextField TfEmail;
    private javax.swing.JFormattedTextField TfFoneCelular;
    private javax.swing.JFormattedTextField TfFoneFixo;
    private javax.swing.JTextField TfNomePessoa;
    private javax.swing.JFormattedTextField TfRgPessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

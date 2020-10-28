package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleEmpresas;
import ControleSistema.WebServiceCep;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloEmpresas;
import ModeloSistema.TratamentoCampos;

public class FrmEmpresas extends javax.swing.JInternalFrame {

    ConectaBanco conForn = new ConectaBanco();
    ConectaBanco conTpForn = new ConectaBanco();
    ConectaBanco conPesquisa = new ConectaBanco();
    ModeloEmpresas modForn = new ModeloEmpresas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleEmpresas control = new ControleEmpresas();
    String descFornec = "";

    public FrmEmpresas() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        camposTelefones();
        preencherCbTipoFornecedores();
    }

    public void preencherCbTipoFornecedores() {

        conTpForn.conexao();
        conTpForn.executaSQL("select * from tab_tipofornecedores");
        try {
            conTpForn.rs.first();
            do {
                CbTipoFornecedores.addItem(conTpForn.rs.getString("desc_tp_forn"));
            } while (conTpForn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o tipo de fornecedor \n ERRO :" + ex);
        }
        conTpForn.desconecta();
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

        TfCodForn.setText("");
        TfDescricaoFornecedor.setText("");
        TfFoneFixo.setText("");
        TfFoneCelular.setText("");
        TfEmail.setText("");
        TfCep.setText("");
        TfNomeRua.setText("");
        TfNumeroEndereco.setText("");
        TfComplementoEndereco.setText("");
        TfNomeBairro.setText("");
        TfNomeCidade.setText("");
        TfUf.setText("");
    }

    public void habiltaCampos() {
        
        TfDescricaoFornecedor.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfEmail.setEnabled(true);
        TfCep.setEnabled(true);
        TfNumeroEndereco.setEnabled(true);
        TfComplementoEndereco.setEnabled(true);
        CbTipoFornecedores.setEnabled(true);
    }

    public void pesquisaTabelaFornecedores() {

        preencherTabelaFornecedores(" select * from vw_fornecedor where desc_forn like '%" + descFornec + "%'");
    }

    public void limparTabelaFornecedores() {

        limparTabelaFornecedores("");
    }

    public void buscaCep() {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(TfCep.getText());
        if (webServiceCep.wasSuccessful()) {
            TfNomeRua.setText(webServiceCep.getLogradouroFull());
            TfNomeCidade.setText(webServiceCep.getCidade());
            TfNomeBairro.setText(webServiceCep.getBairro());
            TfUf.setText(webServiceCep.getUf());
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao tentar achar o endereço!!\n"
                    + "Erro:" + webServiceCep.getResulCode());
        }
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
        jLabel10 = new javax.swing.JLabel();
        TfNomeRua = new javax.swing.JTextField();
        TfNomeBairro = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TfNomeCidade = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        TfUf = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        TfDescricaoFornecedor = new javax.swing.JTextField();
        TfEmail = new javax.swing.JTextField();
        TfCep = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        TfNumeroEndereco = new javax.swing.JTextField();
        TfComplementoEndereco = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        TfCodForn = new javax.swing.JFormattedTextField();
        TfFoneFixo = new javax.swing.JFormattedTextField();
        TfFoneCelular = new javax.swing.JFormattedTextField();
        jLabel20 = new javax.swing.JLabel();
        CbTipoFornecedores = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        BtConsultar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbFornecedores = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Fornecedores");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Empresa");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        BtAdicionar.setToolTipText("Adicionar Registro");
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 201, 48, 48));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.setEnabled(false);
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 201, 48, 48));

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 201, 48, 48));

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.setEnabled(false);
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 201, 48, 48));

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 201, 48, 48));

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 201, 48, 48));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descrição Empresa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 13, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Fone Fixo");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 13, 56, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fone Celular");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 13, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("E-mail");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 57, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Cep *");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 102, -1, -1));

        TfNomeRua.setForeground(new java.awt.Color(255, 255, 255));
        TfNomeRua.setToolTipText("Rua");
        TfNomeRua.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeRua.setEnabled(false);
        jPanel1.add(TfNomeRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 122, 303, -1));

        TfNomeBairro.setForeground(new java.awt.Color(255, 255, 255));
        TfNomeBairro.setToolTipText("Bairro");
        TfNomeBairro.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeBairro.setEnabled(false);
        jPanel1.add(TfNomeBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 168, 258, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel11.setText("Bairro *");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, -1, -1));

        TfNomeCidade.setForeground(new java.awt.Color(255, 255, 255));
        TfNomeCidade.setToolTipText("Cidade");
        TfNomeCidade.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeCidade.setEnabled(false);
        jPanel1.add(TfNomeCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(276, 168, 251, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Cidade *");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 148, -1, -1));

        TfUf.setForeground(new java.awt.Color(255, 255, 255));
        TfUf.setToolTipText("Unidade Federativa");
        TfUf.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfUf.setEnabled(false);
        jPanel1.add(TfUf, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 168, 38, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("UF *");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 148, -1, -1));

        TfDescricaoFornecedor.setToolTipText("Digite o Nome do Cliente");
        TfDescricaoFornecedor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoFornecedor.setEnabled(false);
        TfDescricaoFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfDescricaoFornecedorKeyTyped(evt);
            }
        });
        jPanel1.add(TfDescricaoFornecedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 33, 259, -1));

        TfEmail.setToolTipText("Digite o E-mail");
        TfEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfEmail.setEnabled(false);
        jPanel1.add(TfEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 77, 453, -1));

        TfCep.setToolTipText("Digite o Cep");
        TfCep.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfCep.setEnabled(false);
        TfCep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfCepActionPerformed(evt);
            }
        });
        TfCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCepKeyTyped(evt);
            }
        });
        jPanel1.add(TfCep, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 122, 142, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Rua *");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 102, -1, -1));

        TfNumeroEndereco.setToolTipText("Digite o Número da Residência");
        TfNumeroEndereco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNumeroEndereco.setEnabled(false);
        TfNumeroEndereco.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNumeroEnderecoKeyTyped(evt);
            }
        });
        jPanel1.add(TfNumeroEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 122, 58, -1));

        TfComplementoEndereco.setToolTipText("Digite o Complemento");
        TfComplementoEndereco.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfComplementoEndereco.setEnabled(false);
        jPanel1.add(TfComplementoEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 122, 150, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Complemento");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(533, 102, -1, -1));

        TfCodForn.setToolTipText("Digite o CPF");
        TfCodForn.setEnabled(false);
        TfCodForn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodFornKeyTyped(evt);
            }
        });
        jPanel1.add(TfCodForn, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 33, 114, -1));

        TfFoneFixo.setToolTipText("Digite o Fone Comercial");
        TfFoneFixo.setEnabled(false);
        jPanel1.add(TfFoneFixo, new org.netbeans.lib.awtextra.AbsoluteConstraints(397, 33, 142, -1));

        TfFoneCelular.setToolTipText("Digite o Fone Celular");
        TfFoneCelular.setEnabled(false);
        jPanel1.add(TfFoneCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(545, 33, 135, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Número *");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 102, -1, -1));

        CbTipoFornecedores.setToolTipText("Escolha o tipo de funcionário");
        CbTipoFornecedores.setEnabled(false);
        jPanel1.add(CbTipoFornecedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 77, 210, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Tipo Empresa");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(471, 57, -1, -1));

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Fornecedor");
        BtConsultar.setEnabled(false);
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(BtConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 201, 48, 48));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 700, 260));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Empresas Prestadoras de Serviços");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TbFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbFornecedores.setToolTipText("Lista de Fornecedores");
        TbFornecedores.setEnabled(false);
        TbFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbFornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbFornecedores);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 28, 676, 160));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Lista de Fornecedores");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 8, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 328, 700, 200));

        setBounds(0, 0, 733, 575);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfDescricaoFornecedor.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite a descrição do fornecedor!!");
            TfDescricaoFornecedor.requestFocus();
        } else {
            if (TfCep.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o cep!!");
                TfCep.requestFocus();
            } else {
                modForn.setCepEnd(TfCep.getText());
                modForn.setDescForn(TfDescricaoFornecedor.getText());
                modForn.setFoneFixoForn(TfFoneFixo.getText());
                modForn.setFoneCelularForn(TfFoneCelular.getText());
                modForn.setEmailForn(TfEmail.getText());
                modForn.setDescTpForn((String) CbTipoFornecedores.getSelectedItem());
                modForn.setCepEnd(TfCep.getText());
                modForn.setRuaEnd(TfNomeRua.getText());
                modForn.setNumeroForn(TfNumeroEndereco.getText());
                modForn.setComplementoForn(TfComplementoEndereco.getText());
                modForn.setBairroEnd(TfNomeBairro.getText());
                modForn.setCidadeEnd(TfNomeCidade.getText());
                modForn.setUfEnd(TfUf.getText());
                control.InserirFornecedor(modForn);
                atualizarCampos();
                limparTabelaFornecedores();
                JOptionPane.showMessageDialog(rootPane, "O fornecedor : " + modForn.getDescForn() + " foi registrado com sucesso!!");
                TfCodForn.setEnabled(false);
                CbTipoFornecedores.setEnabled(false);
                TfDescricaoFornecedor.setEnabled(false);
                TfFoneFixo.setEnabled(false);
                TfFoneCelular.setEnabled(false);
                TfEmail.setEnabled(false);
                TfCep.setEnabled(false);
                TfNumeroEndereco.setEnabled(false);
                TfComplementoEndereco.setEnabled(false);
                TbFornecedores.setEnabled(false);
                BtExcluir.setEnabled(false);
                BtAlterar.setEnabled(false);
                BtEditar.setEnabled(true);
                BtCancelar.setEnabled(false);
                BtSalvar.setEnabled(false);
                BtAdicionar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modForn.setCodForn(Integer.valueOf(TfCodForn.getText()));
        modForn.setDescForn(TfDescricaoFornecedor.getText());
        control.ExcluirFornecedor(modForn);
        JOptionPane.showMessageDialog(rootPane, "O fornecedor : " + modForn.getDescForn() + " foi deletado com sucesso!!");
        atualizarCampos();
        limparTabelaFornecedores();
        TfCodForn.setEnabled(false);
        CbTipoFornecedores.setEnabled(false);
        TfDescricaoFornecedor.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfEmail.setEnabled(false);
        TfCep.setEnabled(false);
        TfNumeroEndereco.setEnabled(false);
        TfComplementoEndereco.setEnabled(false);
        TbFornecedores.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtEditar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaFornecedores();
        CbTipoFornecedores.setEnabled(true);
        TfDescricaoFornecedor.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfEmail.setEnabled(true);
        TfCep.setEnabled(true);
        TfNumeroEndereco.setEnabled(true);
        TfComplementoEndereco.setEnabled(true);
        TbFornecedores.setEnabled(false);
        TfDescricaoFornecedor.requestFocus();
        TbFornecedores.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modForn.setCodForn(Integer.valueOf(TfCodForn.getText()));
        modForn.setDescForn(TfDescricaoFornecedor.getText());
        modForn.setFoneFixoForn(TfFoneFixo.getText());
        modForn.setFoneCelularForn(TfFoneCelular.getText());
        modForn.setEmailForn(TfEmail.getText());
        modForn.setDescTpForn((String) CbTipoFornecedores.getSelectedItem());
        modForn.setCepEnd(TfCep.getText());
        modForn.setRuaEnd(TfNomeRua.getText());
        modForn.setNumeroForn(TfNumeroEndereco.getText());
        modForn.setComplementoForn(TfComplementoEndereco.getText());
        modForn.setBairroEnd(TfNomeBairro.getText());
        modForn.setCidadeEnd(TfNomeCidade.getText());
        modForn.setUfEnd(TfUf.getText());
        control.AlterarForncedor(modForn);
        JOptionPane.showMessageDialog(rootPane, "O fornecedor : " + modForn.getDescForn() + " foi alterado com sucesso!!");
        atualizarCampos();
        limparTabelaFornecedores();
        TfCodForn.setEnabled(false);
        CbTipoFornecedores.setEnabled(false);
        TfDescricaoFornecedor.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfEmail.setEnabled(false);
        TfCep.setEnabled(false);
        TfNumeroEndereco.setEnabled(false);
        TfComplementoEndereco.setEnabled(false);
        TbFornecedores.setEnabled(false);
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
        limparTabelaFornecedores();
        TfCodForn.setEnabled(false);
        CbTipoFornecedores.setEnabled(false);
        TfDescricaoFornecedor.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfEmail.setEnabled(false);
        TfCep.setEnabled(false);
        TfNumeroEndereco.setEnabled(false);
        TfComplementoEndereco.setEnabled(false);
        TbFornecedores.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaFornecedores();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbFornecedoresMouseClicked

        String desc_forn = "" + TbFornecedores.getValueAt(TbFornecedores.getSelectedRow(), 0);
        conForn.conexao();
        conForn.executaSQL("select * from vw_fornecedor where desc_forn = '" + desc_forn + "'");
        try {
            conForn.rs.first();
            TfCodForn.setText(conForn.rs.getString("cod_forn"));
            CbTipoFornecedores.addItem(conForn.rs.getString("desc_tp_forn"));
            TfDescricaoFornecedor.setText(conForn.rs.getString("desc_forn"));
            TfFoneFixo.setText(conForn.rs.getString("fone_fixo_forn"));
            TfFoneCelular.setText(conForn.rs.getString("fone_cel_forn"));
            TfEmail.setText(conForn.rs.getString("email_forn"));
            TfCep.setText(conForn.rs.getString("cep_forn"));
            TfNomeRua.setText(conForn.rs.getString("rua_forn"));
            TfComplementoEndereco.setText(conForn.rs.getString("complemento_forn"));
            TfNumeroEndereco.setText(conForn.rs.getString("num_forn"));
            TfNomeBairro.setText(conForn.rs.getString("bairro_forn"));
            TfNomeCidade.setText(conForn.rs.getString("cidade_forn"));
            TfUf.setText(conForn.rs.getString("uf_forn"));
            habiltaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conForn.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbFornecedoresMouseClicked

    private void TfNumeroEnderecoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNumeroEnderecoKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfNumeroEnderecoKeyTyped

    private void TfCodFornKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodFornKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodFornKeyTyped

    private void TfCepKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCepKeyTyped

        tCampos.soNumeros(evt);
}//GEN-LAST:event_TfCepKeyTyped

    private void TfCepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfCepActionPerformed

        buscaCep();
}//GEN-LAST:event_TfCepActionPerformed

    private void TfDescricaoFornecedorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfDescricaoFornecedorKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfDescricaoFornecedorKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        descFornec = JOptionPane.showInputDialog(null, "Digite a descrição do fornecedor");
        if (descFornec.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição do fornecedor desejado.");
        } else {
            pesquisaTabelaFornecedores();
            TbFornecedores.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    public void preencherTabelaFornecedores(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Desc.Fornecedores", "Tipo Fornecedor", "Fone Fixo", "Fone Celular", "E-mail"};
        conForn.conexao();
        conForn.executaSQL(SQL);
        try {
            conForn.rs.first();
            do {
                dados.add(new Object[]{conForn.rs.getString("desc_forn"), conForn.rs.getString("desc_tp_forn"), conForn.rs.getString("Fone_fixo_forn"), conForn.rs.getString("Fone_cel_forn"), conForn.rs.getString("Email_forn")});
            } while (conForn.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Fornecedor não cadastrado!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbFornecedores.setModel(modTabela);
        TbFornecedores.getColumnModel().getColumn(0).setPreferredWidth(150);
        TbFornecedores.getColumnModel().getColumn(0).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(1).setPreferredWidth(100);
        TbFornecedores.getColumnModel().getColumn(1).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(2).setPreferredWidth(90);
        TbFornecedores.getColumnModel().getColumn(2).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(3).setPreferredWidth(100);
        TbFornecedores.getColumnModel().getColumn(3).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(4).setPreferredWidth(241);
        TbFornecedores.getColumnModel().getColumn(4).setResizable(false);
        TbFornecedores.getTableHeader().setReorderingAllowed(false);
        TbFornecedores.setAutoResizeMode(TbFornecedores.AUTO_RESIZE_OFF);
        TbFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conForn.desconecta();
    }

    public void limparTabelaFornecedores(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Desc.Fornecedores", "Tipo Fornecedor", "Fone Fixo", "Fone Celular", "E-mail"};
        dados.add(new Object[]{"", "", "", "", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbFornecedores.setModel(modTabela);
        TbFornecedores.getColumnModel().getColumn(0).setPreferredWidth(150);
        TbFornecedores.getColumnModel().getColumn(0).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(1).setPreferredWidth(100);
        TbFornecedores.getColumnModel().getColumn(1).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(2).setPreferredWidth(90);
        TbFornecedores.getColumnModel().getColumn(2).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(3).setPreferredWidth(100);
        TbFornecedores.getColumnModel().getColumn(3).setResizable(false);
        TbFornecedores.getColumnModel().getColumn(4).setPreferredWidth(241);
        TbFornecedores.getColumnModel().getColumn(4).setResizable(false);
        TbFornecedores.getTableHeader().setReorderingAllowed(false);
        TbFornecedores.setAutoResizeMode(TbFornecedores.AUTO_RESIZE_OFF);
        TbFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbTipoFornecedores;
    private javax.swing.JTable TbFornecedores;
    private javax.swing.JTextField TfCep;
    private javax.swing.JFormattedTextField TfCodForn;
    private javax.swing.JTextField TfComplementoEndereco;
    private javax.swing.JTextField TfDescricaoFornecedor;
    private javax.swing.JTextField TfEmail;
    private javax.swing.JFormattedTextField TfFoneCelular;
    private javax.swing.JFormattedTextField TfFoneFixo;
    private javax.swing.JTextField TfNomeBairro;
    private javax.swing.JTextField TfNomeCidade;
    private javax.swing.JTextField TfNomeRua;
    private javax.swing.JTextField TfNumeroEndereco;
    private javax.swing.JTextField TfUf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

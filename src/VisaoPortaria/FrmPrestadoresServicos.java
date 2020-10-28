package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControlePrestadorServico;
import ControleSistema.ControlePessoas;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloPrestadorServico;
import ModeloSistema.ModeloPessoas;
import ModeloSistema.TratamentoCampos;
import java.util.logging.Level;
import java.util.logging.Logger;
import ControleSistema.Funcoes;

public class FrmPrestadoresServicos extends javax.swing.JInternalFrame {

    ConectaBanco conPts = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    Funcoes abrirTela = new Funcoes();
    ModeloPrestadorServico modPts = new ModeloPrestadorServico();
    ModeloPessoas modPs = new ModeloPessoas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControlePrestadorServico control = new ControlePrestadorServico();
    ControlePessoas controlPs = new ControlePessoas();
    String nomePts = "", nmPts = "", rgPts = "", nomeEmpForn = "";
    int codPs;

    public FrmPrestadoresServicos() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        camposTelefones();
        campoRg();
    }

    public void setNomeEmpresaFornecedora(String nomeEmpForn) {

        this.nomeEmpForn = nomeEmpForn;
        TfEmpresaPrestadorServico.setText(nomeEmpForn);
    }

    public void verificarNomePrestadorServico() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + TfNomePrestadorServico.getText() + "'");
        try {
            conPs.rs.first();
            nmPts = conPs.rs.getString("nome_ps");
        } catch (SQLException ex) {

        }
        conPs.desconecta();
    }

    public void verificarRgPrestadorServico() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where rg_ps ='" + TfRgPrestadorServico.getText() + "'");
        try {
            conPs.rs.first();
            rgPts = conPs.rs.getString("rg_ps");
        } catch (SQLException ex) {

        }
        conPs.desconecta();
    }

    public void campoRg() {

        try {
            MaskFormatter Rg = new MaskFormatter("#######");
            TfRgPrestadorServico.setFormatterFactory(new DefaultFormatterFactory(Rg));
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

        nomePts = "";
        TfCodPrestadorServico.setText("");
        TfNomePrestadorServico.setText("");
        TfRgPrestadorServico.setText("");
        TfFoneFixo.setText("");
        TfFoneCelular.setText("");
        TfEmail.setText("");
        TfEmpresaPrestadorServico.setText("");
    }

    public void habilitaCampos() {

        TfNomePrestadorServico.setEnabled(true);
        TfRgPrestadorServico.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
        TfEmpresaPrestadorServico.setEnabled(true);
    }

    public void pesquisaTabelaPrestadoresServicos() {

        preencherTabelaPrestadoresServicos(" select * from vw_prestadorservico where nome_ps like '%" + nomePts + "%'");
    }

    public void limparTabelaPrestadoresServicos() {

        limparTabelaPrestadoresServicos("");
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
        TfCodPrestadorServico = new javax.swing.JFormattedTextField();
        BtConsultar = new javax.swing.JButton();
        TfNomePrestadorServico = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TfFoneFixo = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        TfFoneCelular = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        TfEmail = new javax.swing.JTextField();
        TfRgPrestadorServico = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        TfEmpresaPrestadorServico = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        BtConsultarEmpresa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbPrestadorServico = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Moradores");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Prest. Serviço");

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

        TfCodPrestadorServico.setToolTipText("Código do prestador serviço");
        TfCodPrestadorServico.setEnabled(false);
        TfCodPrestadorServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodPrestadorServicoKeyTyped(evt);
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

        TfNomePrestadorServico.setToolTipText("Digite o nome do prestador serviço");
        TfNomePrestadorServico.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomePrestadorServico.setEnabled(false);
        TfNomePrestadorServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNomePrestadorServicoKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome Prestador Serviço");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fone Fixo");

        TfFoneFixo.setToolTipText("Digite o fone fixo do prestador serviço");
        TfFoneFixo.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fone Celular");

        TfFoneCelular.setToolTipText("Digite o celular do prestador serviço");
        TfFoneCelular.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("E-mail");

        TfEmail.setToolTipText("Digite o e-mail do prestador serviço");
        TfEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfEmail.setEnabled(false);

        TfRgPrestadorServico.setToolTipText("Digite o rg do prestador serviço");
        TfRgPrestadorServico.setEnabled(false);
        TfRgPrestadorServico.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfRgPrestadorServicoKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Rg");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TfEmpresaPrestadorServico.setToolTipText("Nome da empresa do prestador serviço");
        TfEmpresaPrestadorServico.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfEmpresaPrestadorServico.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Nome Empresa do Prestador Servico");

        BtConsultarEmpresa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultarEmpresa.setToolTipText("Consultar Fornecedor");
        BtConsultarEmpresa.setEnabled(false);
        BtConsultarEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarEmpresaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfEmpresaPrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtConsultarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(202, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtConsultarEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TfEmpresaPrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel10)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TfFoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(TfFoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(TfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfNomePrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(TfRgPrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(TfCodPrestadorServico, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(TfCodPrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfNomePrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfRgPrestadorServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfFoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfFoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 640, 310));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Prestadores de Serviços");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Prestadores de Serviços", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbPrestadorServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbPrestadorServico.setToolTipText("Lista de moradores cadastrados");
        TbPrestadorServico.setEnabled(false);
        TbPrestadorServico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPrestadorServicoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbPrestadorServico);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 640, 180));

        setBounds(0, 0, 676, 589);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfNomePrestadorServico.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o nome do prestador de serviço!!");
            TfNomePrestadorServico.requestFocus();
        } else {
            if (TfRgPrestadorServico.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o rg do prestador de serviço!!");
                TfRgPrestadorServico.requestFocus();
            } else {
                if (TfEmpresaPrestadorServico.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Digite o nome da empresa do prestador de serviço!!");
                    TfEmpresaPrestadorServico.requestFocus();
                } else {
                    verificarNomePrestadorServico();
                    if (TfNomePrestadorServico.getText().equals((String) nmPts)) {
                        JOptionPane.showMessageDialog(null, "Já existe prestador de serviço cadastrado com esse nome!!");
                        TfNomePrestadorServico.setText("");
                        TfNomePrestadorServico.requestFocus();
                    } else {
                        verificarRgPrestadorServico();
                        if (TfRgPrestadorServico.getText().equals((String) rgPts)) {
                            JOptionPane.showMessageDialog(null, "Já existe prestador de serviço cadastrado com esse número de rg!!");
                            TfRgPrestadorServico.setText("");
                            TfRgPrestadorServico.requestFocus();
                        } else {
                            modPs.setCodPs(codPs);
                            modPs.setNomePs(TfNomePrestadorServico.getText());
                            modPs.setRgPs(TfRgPrestadorServico.getText());
                            modPs.setFoneFixoPs(TfFoneFixo.getText());
                            modPs.setCelularPs(TfFoneCelular.getText());
                            modPs.setEmailPs(TfEmail.getText());
                            modPs.setDescTpPs("Fornecedor");
                            controlPs.InserirPessoa(modPs);
                            modPts.setNomePts(TfNomePrestadorServico.getText());
                            modPts.setDescForn(TfEmpresaPrestadorServico.getText());
                            control.InserirPrestadorServico(modPts);
                            atualizarCampos();
                            limparTabelaPrestadoresServicos();
                            JOptionPane.showMessageDialog(rootPane, "O prestador de serviço : " + modPts.getNomePts() + " foi registrado com sucesso!!");
                            TfEmpresaPrestadorServico.setEnabled(false);
                            TfNomePrestadorServico.setEnabled(false);
                            TfRgPrestadorServico.setEnabled(false);
                            TfFoneCelular.setEnabled(false);
                            TfFoneFixo.setEnabled(false);
                            TfEmail.setEnabled(false);
                            TbPrestadorServico.setEnabled(false);
                            BtExcluir.setEnabled(false);
                            BtAlterar.setEnabled(false);
                            BtEditar.setEnabled(true);
                            BtCancelar.setEnabled(false);
                            BtSalvar.setEnabled(false);
                            BtAdicionar.setEnabled(true);
                            BtConsultarEmpresa.setEnabled(false);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        String nmPs = "";
        nmPs = TfNomePrestadorServico.getText();
        String nome = "Você deseja deletar o prestador de serviço : " + nmPs + " ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            modPts.setCodPts(Integer.valueOf(TfCodPrestadorServico.getText()));
            control.ExcluirPrestadorServico(modPts);//Exclui o prestador
            modPs.setCodPs(codPs);
            modPs.setNomePs(TfNomePrestadorServico.getText());
            controlPs.ExcluirPessoa(modPs);//Exclui a pessoa
            JOptionPane.showMessageDialog(rootPane, "O prestador de serviço : " + modPs.getNomePs() + " foi deletado com sucesso!!");
            atualizarCampos();
            limparTabelaPrestadoresServicos();
            TfEmpresaPrestadorServico.setEnabled(false);
            TfCodPrestadorServico.setEnabled(false);
            TfNomePrestadorServico.setEnabled(false);
            TfRgPrestadorServico.setEnabled(false);
            TfFoneCelular.setEnabled(false);
            TfFoneFixo.setEnabled(false);
            TfEmail.setEnabled(false);
            TbPrestadorServico.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
            BtEditar.setEnabled(true);
            BtConsultarEmpresa.setEnabled(false);
        } else {
        }
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaPrestadoresServicos();
        TfEmpresaPrestadorServico.setEnabled(true);
        TfNomePrestadorServico.setEnabled(true);
        TfNomePrestadorServico.requestFocus();
        TfRgPrestadorServico.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
        TbPrestadorServico.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
        BtConsultarEmpresa.setEnabled(true);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modPs.setCodPs(codPs);
        modPs.setNomePs(TfNomePrestadorServico.getText());
        modPs.setRgPs(TfRgPrestadorServico.getText());
        modPs.setFoneFixoPs(TfFoneFixo.getText());
        modPs.setCelularPs(TfFoneCelular.getText());
        modPs.setEmailPs(TfEmail.getText());
        controlPs.AlterarPessoa(modPs);
        modPts.setCodPts(Integer.valueOf(TfCodPrestadorServico.getText()));
        modPts.setDescForn(TfEmpresaPrestadorServico.getText());
        control.AlterarPrestadorServico(modPts);
        JOptionPane.showMessageDialog(rootPane, "O prestador de serviço: " + modPs.getNomePs() + " foi alterado com sucesso!!");
        atualizarCampos();
        limparTabelaPrestadoresServicos();
        TfEmpresaPrestadorServico.setEnabled(false);
        TfCodPrestadorServico.setEnabled(false);
        TfNomePrestadorServico.setEnabled(false);
        TfRgPrestadorServico.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        TbPrestadorServico.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultar.setEnabled(false);
        BtConsultarEmpresa.setEnabled(false);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        limparTabelaPrestadoresServicos();
        TfEmpresaPrestadorServico.setEnabled(false);
        TfCodPrestadorServico.setEnabled(false);
        TfNomePrestadorServico.setEnabled(false);
        TfRgPrestadorServico.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        TbPrestadorServico.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultarEmpresa.setEnabled(false);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaPrestadoresServicos();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbPrestadorServicoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPrestadorServicoMouseClicked

        String nome_pts = "" + TbPrestadorServico.getValueAt(TbPrestadorServico.getSelectedRow(), 0);
        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps = '" + nome_pts + "'");
        try {
            conPs.rs.first();
            codPs = (conPs.rs.getInt("cod_ps"));
            TfNomePrestadorServico.setText(conPs.rs.getString("nome_ps"));
            TfRgPrestadorServico.setText(conPs.rs.getString("rg_ps"));
            TfFoneFixo.setText(conPs.rs.getString("fone_fixo"));
            TfFoneCelular.setText(conPs.rs.getString("celular_ps"));
            TfEmail.setText(conPs.rs.getString("email_ps"));
            conPs.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
        conPts.conexao();
        conPts.executaSQL("select * from vw_prestadorservico where nome_ps = '" + nome_pts + "'");
        try {
            conPts.rs.first();
            TfCodPrestadorServico.setText(conPts.rs.getString("cod_prsv"));
            TfEmpresaPrestadorServico.setText(conPts.rs.getString("desc_forn"));
            habilitaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            BtConsultarEmpresa.setEnabled(true);
            conPts.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbPrestadorServicoMouseClicked

    private void TfCodPrestadorServicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodPrestadorServicoKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodPrestadorServicoKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        nomePts = JOptionPane.showInputDialog(null, "Digite o nome do prestador de serviço :");
        if (nomePts.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o nome do prestador de serviço desejado.");
        } else {
            pesquisaTabelaPrestadoresServicos();
            TbPrestadorServico.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void TfNomePrestadorServicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNomePrestadorServicoKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfNomePrestadorServicoKeyTyped

    private void TfRgPrestadorServicoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfRgPrestadorServicoKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfRgPrestadorServicoKeyTyped
    
    private void BtConsultarEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarEmpresaActionPerformed

        try {
            FrmPesquisaEmpresaFornecedora frmPesquisaEmpresaFornecedora = null;
            frmPesquisaEmpresaFornecedora = new FrmPesquisaEmpresaFornecedora(this);
            abrirTela.centralizarFormularioCadastros(frmPesquisaEmpresaFornecedora);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(FrmPrestadoresServicos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtConsultarEmpresaActionPerformed

    public void preencherTabelaPrestadoresServicos(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Prestador Serviço", "Empresa Prestodora"};
        conPts.conexao();
        conPts.executaSQL(SQL);
        try {
            conPts.rs.first();
            do {
                dados.add(new Object[]{conPts.rs.getString("nome_ps"), conPts.rs.getString("desc_forn")});
            } while (conPts.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe prestador de serviço cadastrado com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPrestadorServico.setModel(modTabela);
        TbPrestadorServico.getColumnModel().getColumn(0).setPreferredWidth(359);
        TbPrestadorServico.getColumnModel().getColumn(0).setResizable(false);
        TbPrestadorServico.getColumnModel().getColumn(1).setPreferredWidth(250);
        TbPrestadorServico.getColumnModel().getColumn(1).setResizable(false);
        TbPrestadorServico.getTableHeader().setReorderingAllowed(false);
        TbPrestadorServico.setAutoResizeMode(TbPrestadorServico.AUTO_RESIZE_OFF);
        TbPrestadorServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conPts.desconecta();
    }

    public void limparTabelaPrestadoresServicos(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Prestador Serviço", "Empresa Prestodora"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPrestadorServico.setModel(modTabela);
        TbPrestadorServico.getColumnModel().getColumn(0).setPreferredWidth(359);
        TbPrestadorServico.getColumnModel().getColumn(0).setResizable(false);
        TbPrestadorServico.getColumnModel().getColumn(1).setPreferredWidth(250);
        TbPrestadorServico.getColumnModel().getColumn(1).setResizable(false);
        TbPrestadorServico.getTableHeader().setReorderingAllowed(false);
        TbPrestadorServico.setAutoResizeMode(TbPrestadorServico.AUTO_RESIZE_OFF);
        TbPrestadorServico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtConsultarEmpresa;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JTable TbPrestadorServico;
    private javax.swing.JFormattedTextField TfCodPrestadorServico;
    private javax.swing.JTextField TfEmail;
    private javax.swing.JFormattedTextField TfEmpresaPrestadorServico;
    private javax.swing.JFormattedTextField TfFoneCelular;
    private javax.swing.JFormattedTextField TfFoneFixo;
    private javax.swing.JTextField TfNomePrestadorServico;
    private javax.swing.JFormattedTextField TfRgPrestadorServico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

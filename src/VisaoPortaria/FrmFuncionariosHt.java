package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleFuncionariosHt;
import ControleSistema.ControlePessoas;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloFuncionariosHt;
import ModeloSistema.ModeloPessoas;
import ModeloSistema.TratamentoCampos;

public class FrmFuncionariosHt extends javax.swing.JInternalFrame {

    ConectaBanco conFunc = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conSets = new ConectaBanco();
    ConectaBanco conRamalApt = new ConectaBanco();
    ConectaBanco conRm = new ConectaBanco();
    ModeloFuncionariosHt modFunc = new ModeloFuncionariosHt();
    ModeloPessoas modPs = new ModeloPessoas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleFuncionariosHt control = new ControleFuncionariosHt();
    ControlePessoas controlPs = new ControlePessoas();
    String nomeFunc = "", nmFc = "", rgFunc = "", ramal = "";
    int codPs;
    boolean descSet = false;

    public FrmFuncionariosHt() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        preencherCbSetores();
        camposTelefones();
        campoRg();
    }

    public void verificarNomeFuncionario() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + TfNomeFuncionario.getText() + "'");
        try {
            conPs.rs.first();
            nmFc = conPs.rs.getString("nome_ps");
        } catch (SQLException ex) {

        }
        conPs.desconecta();
    }

    public void verificarRgFuncionario() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where rg_ps ='" + TfRgFuncionario.getText() + "'");
        try {
            conPs.rs.first();
            rgFunc = conPs.rs.getString("rg_ps");
        } catch (SQLException ex) {

        }
        conPs.desconecta();
    }

    public void campoRg() {

        try {
            MaskFormatter Rg = new MaskFormatter("#######");
            TfRgFuncionario.setFormatterFactory(new DefaultFormatterFactory(Rg));
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

    public void preencherCbSetores() {

        CbSetores.addItem("Escolha o setor");
        conSets.conexao();
        try {
            conSets.executaSQL("select * from tab_setores");
            conSets.rs.first();
            do {
                CbSetores.addItem(conSets.rs.getString("desc_set"));
            } while (conSets.rs.next());
        } catch (SQLException ex) {
        }
        conSets.desconecta();
    }

    public void preencherCbRamais(String listaDescSet) {

        CbRamais.removeAllItems();
        CbRamais.addItem("Escolha o ramal");
        conRm.conexao();
        try {
            conRm.executaSQL("select * from vw_ramais_administrativo where desc_set ='" + listaDescSet + "'");
            conRm.rs.first();
            do {
                CbRamais.addItem(conRm.rs.getString("num_rm"));
            } while (conRm.rs.next());
        } catch (SQLException ex) {
        }
        conRm.desconecta();
    }

    public void ramal(String setor) {

        conRm.conexao();
        try {
            conRm.executaSQL("select * from  vw_ramais_administrativo where desc_set = '" + setor + "'");
            conRm.rs.first();
            ramal = conRm.rs.getString("num_rm");
        } catch (SQLException ex) {
        }
        conRm.desconecta();
    }

    public void atualizarCampos() {

        nomeFunc = "";
        TfCodFuncionario.setText("");
        TfNomeFuncionario.setText("");
        TfRgFuncionario.setText("");
        TfFoneFixo.setText("");
        TfFoneCelular.setText("");
        TfEmail.setText("");
    }

    public void habilitaCampos() {

        CbSetores.setEnabled(true);
        CbRamais.setEnabled(true);
        TfNomeFuncionario.setEnabled(true);
        TfRgFuncionario.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
    }

    public void pesquisaTabelaFuncionarios() {

        preencherTabelaFuncionarios(" select * from vw_funcionarioht where nome_ps like '%" + nomeFunc + "%'");
    }

    public void limparTabelaFuncionarios() {

        limparTabelaFuncionarios("");
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
        TfCodFuncionario = new javax.swing.JFormattedTextField();
        BtConsultar = new javax.swing.JButton();
        TfNomeFuncionario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TfFoneFixo = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        TfFoneCelular = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        TfEmail = new javax.swing.JTextField();
        TfRgFuncionario = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        CbSetores = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        CbRamais = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbFuncionarios = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Funcionários");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Funcionário");

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

        TfCodFuncionario.setToolTipText("Código do funcionário");
        TfCodFuncionario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfCodFuncionario.setEnabled(false);
        TfCodFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodFuncionarioKeyTyped(evt);
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

        TfNomeFuncionario.setToolTipText("Digite o nome do funcionário");
        TfNomeFuncionario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeFuncionario.setEnabled(false);
        TfNomeFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNomeFuncionarioKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome Funcionário");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fone Fixo");

        TfFoneFixo.setToolTipText("Digite o fone fixo do funcionário");
        TfFoneFixo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfFoneFixo.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fone Celular");

        TfFoneCelular.setToolTipText("Digite o celular do funcionário");
        TfFoneCelular.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfFoneCelular.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("E-mail");

        TfEmail.setToolTipText("Digite o e-mail do funcionário");
        TfEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfEmail.setEnabled(false);

        TfRgFuncionario.setToolTipText("Digite o rg do funcionário");
        TfRgFuncionario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfRgFuncionario.setEnabled(false);
        TfRgFuncionario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfRgFuncionarioKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Rg");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        CbSetores.setToolTipText("Escolha o setor do funcionário");
        CbSetores.setEnabled(false);
        CbSetores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbSetoresActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Nº Ramal");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Setor ");

        CbRamais.setToolTipText("Escolha o setor do funcionário");
        CbRamais.setEnabled(false);
        CbRamais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbRamaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbSetores, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(CbRamais, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(266, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel16))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CbSetores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbRamais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TfCodFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(TfNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(TfRgFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfFoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(TfFoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 297, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfEmail)
                                .addContainerGap())))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(TfCodFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfRgFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel5)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 640, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Funcionários ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbFuncionarios.setToolTipText("Lista de funcionários cadastrados");
        TbFuncionarios.setEnabled(false);
        TbFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbFuncionarios);

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 640, 190));

        setBounds(0, 0, 676, 601);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfNomeFuncionario.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o nome do funcionário!!");
            TfNomeFuncionario.requestFocus();
        } else {
            if (TfRgFuncionario.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o rg do funcionário!!");
                TfRgFuncionario.requestFocus();
            } else {
                if (descSet == false) {
                    JOptionPane.showMessageDialog(rootPane, "Escolha o ramal do funcionário!!");
                } else {
                    if (CbSetores.getSelectedItem().equals("Escolha um ramal")) {
                        JOptionPane.showMessageDialog(rootPane, "Escolha o ramal do funcionário!!");
                    } else {
                        verificarNomeFuncionario();
                        if (TfNomeFuncionario.getText().equals((String) nmFc)) {
                            JOptionPane.showMessageDialog(null, "Já existe funcionário cadastrado com esse nome!!");
                            TfNomeFuncionario.setText("");
                            TfNomeFuncionario.requestFocus();
                        } else {
                            verificarRgFuncionario();
                            if (TfRgFuncionario.getText().equals((String) rgFunc)) {
                                JOptionPane.showMessageDialog(null, "Já existe funcionário cadastrado com esse número de rg!!");
                                TfRgFuncionario.setText("");
                                TfRgFuncionario.requestFocus();
                            } else {
                                modPs.setCodPs(codPs);
                                modPs.setNomePs(TfNomeFuncionario.getText());
                                modPs.setRgPs(TfRgFuncionario.getText());
                                modPs.setFoneFixoPs(TfFoneFixo.getText());
                                modPs.setCelularPs(TfFoneCelular.getText());
                                modPs.setEmailPs(TfEmail.getText());
                                modPs.setDescTpPs("Funcionário");
                                controlPs.InserirPessoa(modPs);
                                modFunc.setNomeFc(TfNomeFuncionario.getText());
                                modFunc.setNumRm((String) CbRamais.getSelectedItem());
                                control.InserirFuncionariosHt(modFunc);
                                atualizarCampos();
                                limparTabelaFuncionarios();
                                JOptionPane.showMessageDialog(rootPane, "O funcionário : " + modFunc.getNomeFc() + " foi registrado com sucesso!!");
                                descSet = false;
                                TfNomeFuncionario.setEnabled(false);
                                TfRgFuncionario.setEnabled(false);
                                TfFoneCelular.setEnabled(false);
                                TfFoneFixo.setEnabled(false);
                                TfEmail.setEnabled(false);
                                CbSetores.setEnabled(false);
                                CbRamais.setEnabled(false);
                                TbFuncionarios.setEnabled(false);
                                BtExcluir.setEnabled(false);
                                BtAlterar.setEnabled(false);
                                BtEditar.setEnabled(true);
                                BtCancelar.setEnabled(false);
                                BtSalvar.setEnabled(false);
                                BtAdicionar.setEnabled(true);
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        String nmPs = "";
        nmPs = TfNomeFuncionario.getText();
        String nome = "Você deseja deletar o funcionário : " + nmPs + " ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            modFunc.setCodFc(Integer.valueOf(TfCodFuncionario.getText()));
            control.ExcluirFuncionariosHt(modFunc);//Exclui o morador
            modPs.setCodPs(codPs);
            modPs.setNomePs(TfNomeFuncionario.getText());
            controlPs.ExcluirPessoa(modPs);//Exclui a pessoa
            JOptionPane.showMessageDialog(rootPane, "O funcionário : " + modPs.getNomePs() + " foi deletado com sucesso!!");
            atualizarCampos();
            limparTabelaFuncionarios();
            descSet = false;
            TfCodFuncionario.setEnabled(false);
            CbSetores.setEnabled(false);
            CbRamais.setEnabled(false);
            TfNomeFuncionario.setEnabled(false);
            TfRgFuncionario.setEnabled(false);
            TfFoneCelular.setEnabled(false);
            TfFoneFixo.setEnabled(false);
            TfEmail.setEnabled(false);
            TbFuncionarios.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
            BtEditar.setEnabled(true);
        } else {
        }
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaFuncionarios();
        descSet = false;
        TfNomeFuncionario.setEnabled(true);
        TfNomeFuncionario.requestFocus();
        TfRgFuncionario.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
        CbSetores.setEnabled(true);
        CbRamais.setEnabled(true);
        TbFuncionarios.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modPs.setCodPs(codPs);
        modPs.setNomePs(TfNomeFuncionario.getText());
        modPs.setRgPs(TfRgFuncionario.getText());
        modPs.setFoneFixoPs(TfFoneFixo.getText());
        modPs.setCelularPs(TfFoneCelular.getText());
        modPs.setEmailPs(TfEmail.getText());
        controlPs.AlterarPessoa(modPs);
        modFunc.setCodFc(Integer.valueOf(TfCodFuncionario.getText()));
        modFunc.setNomeFc(TfNomeFuncionario.getText());
        modFunc.setNumRm((String) CbRamais.getSelectedItem());
        control.AlterarFuncionariosHt(modFunc);
        JOptionPane.showMessageDialog(rootPane, "O funcionário : " + modPs.getNomePs() + " foi alterado com sucesso!!");
        atualizarCampos();
        limparTabelaFuncionarios();
        TfCodFuncionario.setEnabled(false);
        TfNomeFuncionario.setEnabled(false);
        TfRgFuncionario.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        CbSetores.setEnabled(false);
        CbRamais.setEnabled(false);
        TbFuncionarios.setEnabled(false);
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
        limparTabelaFuncionarios();
        descSet = false;
        TfCodFuncionario.setEnabled(false);
        CbSetores.setEnabled(false);
        CbRamais.setEnabled(false);
        TfNomeFuncionario.setEnabled(false);
        TfRgFuncionario.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        TbFuncionarios.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaFuncionarios();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbFuncionariosMouseClicked

        String nome_Func = "" + TbFuncionarios.getValueAt(TbFuncionarios.getSelectedRow(), 0);
        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps = '" + nome_Func + "'");
        try {
            conPs.rs.first();
            codPs = (conPs.rs.getInt("cod_ps"));
            TfNomeFuncionario.setText(conPs.rs.getString("nome_ps"));
            TfRgFuncionario.setText(conPs.rs.getString("rg_ps"));
            TfFoneFixo.setText(conPs.rs.getString("fone_fixo"));
            TfFoneCelular.setText(conPs.rs.getString("celular_ps"));
            TfEmail.setText(conPs.rs.getString("email_ps"));
            conPs.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
        conFunc.conexao();
        conFunc.executaSQL("select * from vw_funcionarioht where nome_ps = '" + nome_Func + "'");
        try {
            conFunc.rs.first();
            TfCodFuncionario.setText(conFunc.rs.getString("cod_fc"));
            CbSetores.setSelectedItem(conFunc.rs.getString("desc_set"));            
            CbRamais.setSelectedItem(conFunc.rs.getString("num_rm"));
            habilitaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conFunc.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbFuncionariosMouseClicked

    private void TfCodFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodFuncionarioKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodFuncionarioKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        nomeFunc = JOptionPane.showInputDialog(null, "Digite o nome do funcionário :");
        if (nomeFunc.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o nome do funcionário desejado.");
        } else {
            pesquisaTabelaFuncionarios();
            TbFuncionarios.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void CbSetoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbSetoresActionPerformed

        descSet = true;
        ramal((String) CbSetores.getSelectedItem());
        preencherCbRamais((String) CbSetores.getSelectedItem());
    }//GEN-LAST:event_CbSetoresActionPerformed

    private void TfNomeFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNomeFuncionarioKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfNomeFuncionarioKeyTyped

    private void TfRgFuncionarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfRgFuncionarioKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfRgFuncionarioKeyTyped

    private void CbRamaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbRamaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbRamaisActionPerformed

    public void preencherTabelaFuncionarios(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Funcionário", "Setor", "Ramal"};
        conFunc.conexao();
        conFunc.executaSQL(SQL);
        try {
            conFunc.rs.first();
            do {
                dados.add(new Object[]{conFunc.rs.getString("nome_ps"), conFunc.rs.getString("desc_set"), conFunc.rs.getString("num_rm")});
            } while (conFunc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe funcionário cadastrado com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbFuncionarios.setModel(modTabela);
        TbFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(353);
        TbFuncionarios.getColumnModel().getColumn(0).setResizable(false);
        TbFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        TbFuncionarios.getColumnModel().getColumn(1).setResizable(false);
        TbFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbFuncionarios.getColumnModel().getColumn(2).setResizable(false);
        TbFuncionarios.getTableHeader().setReorderingAllowed(false);
        TbFuncionarios.setAutoResizeMode(TbFuncionarios.AUTO_RESIZE_OFF);
        TbFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conFunc.desconecta();
    }

    public void limparTabelaFuncionarios(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Funcionário", "Setor", "Ramal"};
        dados.add(new Object[]{"", "", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbFuncionarios.setModel(modTabela);
        TbFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(353);
        TbFuncionarios.getColumnModel().getColumn(0).setResizable(false);
        TbFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(150);
        TbFuncionarios.getColumnModel().getColumn(1).setResizable(false);
        TbFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbFuncionarios.getColumnModel().getColumn(2).setResizable(false);
        TbFuncionarios.getTableHeader().setReorderingAllowed(false);
        TbFuncionarios.setAutoResizeMode(TbFuncionarios.AUTO_RESIZE_OFF);
        TbFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbRamais;
    private javax.swing.JComboBox CbSetores;
    private javax.swing.JTable TbFuncionarios;
    private javax.swing.JFormattedTextField TfCodFuncionario;
    private javax.swing.JTextField TfEmail;
    private javax.swing.JFormattedTextField TfFoneCelular;
    private javax.swing.JFormattedTextField TfFoneFixo;
    private javax.swing.JTextField TfNomeFuncionario;
    private javax.swing.JFormattedTextField TfRgFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
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

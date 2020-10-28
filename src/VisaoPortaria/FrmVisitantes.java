package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleVisitantes;
import ControleSistema.ControlePessoas;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloVisitantes;
import ModeloSistema.ModeloPessoas;
import ModeloSistema.TratamentoCampos;

public class FrmVisitantes extends javax.swing.JInternalFrame {

    ConectaBanco conVst = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ModeloVisitantes modVst = new ModeloVisitantes();
    ModeloPessoas modPs = new ModeloPessoas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleVisitantes control = new ControleVisitantes();
    ControlePessoas controlPs = new ControlePessoas();
    String nomeVst = "", nmVst = "", rgVst = "";
    int codPs;

    public FrmVisitantes() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        camposTelefones();
        campoRg();
    }

    public void verificarVisitante() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + TfNomeVisitante.getText() + "'");
        try {
            conPs.rs.first();
            nmVst = conPs.rs.getString("nome_ps");
            rgVst = conPs.rs.getString("rg_ps");
        } catch (SQLException ex) {
        }
        conPs.desconecta();
    }

    public void verificarRgVisitanteAtualiza() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + TfNomeVisitante.getText() + "' and <> '" + TfRgVisitante + "'");
        try {
            conPs.rs.first();
            rgVst = conPs.rs.getString("rg_ps");
        } catch (SQLException ex) {
        }
        conPs.desconecta();
    }

    public void verificarNomeVisitanteAtualiza() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + TfNomeVisitante.getText() + "' and <> '" + TfNomeVisitante + "'");
        try {
            conPs.rs.first();
            nmVst = conPs.rs.getString("nome_ps");
        } catch (SQLException ex) {
        }
        conPs.desconecta();
    }

    public void campoRg() {

        try {
            MaskFormatter Rg = new MaskFormatter("#######");
            TfRgVisitante.setFormatterFactory(new DefaultFormatterFactory(Rg));
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

        nomeVst = "";
        TfCodVisitante.setText("");
        TfNomeVisitante.setText("");
        TfRgVisitante.setText("");
        TfFoneFixo.setText("");
        TfFoneCelular.setText("");
        TfEmail.setText("");
        TfObsVisitante.setText("");
    }

    public void habilitaCampos() {

        TfNomeVisitante.setEnabled(true);
        TfRgVisitante.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
        TfObsVisitante.setEnabled(true);
    }

    public void pesquisaTabelaVisitantes() {

        preencherTabelaVisitantes(" select * from vw_visitante where nome_ps like '%" + nomeVst + "%'");
    }

    public void limparTabelaVisitantes() {

        limparTabelaVisitantes("");
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
        TfCodVisitante = new javax.swing.JFormattedTextField();
        BtConsultar = new javax.swing.JButton();
        TfNomeVisitante = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TfFoneFixo = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        TfFoneCelular = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        TfEmail = new javax.swing.JTextField();
        TfRgVisitante = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TfObsVisitante = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbVisitante = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Visitantes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Visitantes");

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

        TfCodVisitante.setToolTipText("Código do visitante");
        TfCodVisitante.setEnabled(false);
        TfCodVisitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodVisitanteKeyTyped(evt);
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

        TfNomeVisitante.setToolTipText("Digite o nome do visitante");
        TfNomeVisitante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeVisitante.setEnabled(false);
        TfNomeVisitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNomeVisitanteKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome Visitantes");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fone Fixo");

        TfFoneFixo.setToolTipText("Digite o fone fixo do visitante");
        TfFoneFixo.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fone Celular");

        TfFoneCelular.setToolTipText("Digite o celular do visitante");
        TfFoneCelular.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("E-mail");

        TfEmail.setToolTipText("Digite o e-mail do visitante");
        TfEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfEmail.setEnabled(false);

        TfRgVisitante.setToolTipText("Digite o rg do visitante");
        TfRgVisitante.setEnabled(false);
        TfRgVisitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfRgVisitanteKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Rg");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Observções Visitantes");

        TfObsVisitante.setColumns(20);
        TfObsVisitante.setRows(5);
        TfObsVisitante.setToolTipText("Observações do visitante");
        TfObsVisitante.setEnabled(false);
        jScrollPane2.setViewportView(TfObsVisitante);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 308, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                            .addComponent(TfNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(TfRgVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfFoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TfFoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(94, 94, 94)
                                .addComponent(jLabel10)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(TfEmail)))
                    .addComponent(TfCodVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(TfCodVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfNomeVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfRgVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 640, 340));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Visitantes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Visitantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbVisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbVisitante.setToolTipText("Lista de moradores cadastrados");
        TbVisitante.setEnabled(false);
        TbVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbVisitanteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbVisitante);

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 640, 180));

        setBounds(0, 0, 676, 622);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfNomeVisitante.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o nome do visitante!!");
            TfNomeVisitante.requestFocus();
        } else {
            if (TfRgVisitante.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o rg do visitante!!");
                TfRgVisitante.requestFocus();
            } else {
                if (TfObsVisitante.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Digite as observações do visitante!!");
                    TfObsVisitante.requestFocus();
                } else {
                    verificarVisitante();
                    if (TfNomeVisitante.getText().equals((String) nmVst)) {
                        JOptionPane.showMessageDialog(null, "Já existe visitante cadastrado com esse nome!!");
                        TfNomeVisitante.setText("");
                        TfNomeVisitante.requestFocus();
                    } else {
                        verificarVisitante();
                        if (TfRgVisitante.getText().equals((String) rgVst)) {
                            JOptionPane.showMessageDialog(null, "Já existe visitante cadastrado com esse número de rg!!");
                            TfRgVisitante.setText("");
                            TfRgVisitante.requestFocus();
                        } else {
                            modPs.setCodPs(codPs);
                            modPs.setNomePs(TfNomeVisitante.getText());
                            modPs.setRgPs(TfRgVisitante.getText());
                            modPs.setFoneFixoPs(TfFoneFixo.getText());
                            modPs.setCelularPs(TfFoneCelular.getText());
                            modPs.setEmailPs(TfEmail.getText());
                            modPs.setDescTpPs("Visitante");
                            controlPs.InserirPessoa(modPs);
                            modVst.setNomeVst(TfNomeVisitante.getText());
                            modVst.setObs(TfObsVisitante.getText());
                            control.InserirVisitante(modVst);
                            atualizarCampos();
                            limparTabelaVisitantes();
                            JOptionPane.showMessageDialog(rootPane, "O visitante : " + modVst.getNomeVst() + " foi registrado com sucesso!!");
                            TfObsVisitante.setEnabled(false);
                            TfNomeVisitante.setEnabled(false);
                            TfRgVisitante.setEnabled(false);
                            TfFoneCelular.setEnabled(false);
                            TfFoneFixo.setEnabled(false);
                            TfEmail.setEnabled(false);
                            TbVisitante.setEnabled(false);
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
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        String nmPs = "";
        nmPs = TfNomeVisitante.getText();
        String nome = "Você deseja deletar o visitante : " + nmPs + " ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            modVst.setCodVst(Integer.valueOf(TfCodVisitante.getText()));
            control.ExcluirVisitante(modVst);//Exclui o prestador
            modPs.setCodPs(codPs);
            modPs.setNomePs(TfNomeVisitante.getText());
            controlPs.ExcluirPessoa(modPs);//Exclui a pessoa
            JOptionPane.showMessageDialog(rootPane, "O visitante : " + modPs.getNomePs() + " foi deletado com sucesso!!");
            atualizarCampos();
            limparTabelaVisitantes();
            TfObsVisitante.setEnabled(false);
            TfCodVisitante.setEnabled(false);
            TfNomeVisitante.setEnabled(false);
            TfRgVisitante.setEnabled(false);
            TfFoneCelular.setEnabled(false);
            TfFoneFixo.setEnabled(false);
            TfEmail.setEnabled(false);
            TbVisitante.setEnabled(false);
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
        limparTabelaVisitantes();
        TfObsVisitante.setEnabled(true);
        TfNomeVisitante.setEnabled(true);
        TfNomeVisitante.requestFocus();
        TfRgVisitante.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
        TbVisitante.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modPs.setCodPs(codPs);
        modPs.setNomePs(TfNomeVisitante.getText());
        modPs.setRgPs(TfRgVisitante.getText());
        modPs.setFoneFixoPs(TfFoneFixo.getText());
        modPs.setCelularPs(TfFoneCelular.getText());
        modPs.setEmailPs(TfEmail.getText());
        controlPs.AlterarPessoa(modPs);
        modVst.setCodVst(Integer.valueOf(TfCodVisitante.getText()));
        modVst.setNomeVst(TfNomeVisitante.getText());
        modVst.setObs(TfObsVisitante.getText());
        control.AlterarVisitante(modVst);
        JOptionPane.showMessageDialog(rootPane, "O visitante : " + modPs.getNomePs() + " foi alterado com sucesso!!");
        atualizarCampos();
        limparTabelaVisitantes();
        TfObsVisitante.setEnabled(false);
        TfCodVisitante.setEnabled(false);
        TfNomeVisitante.setEnabled(false);
        TfRgVisitante.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        TbVisitante.setEnabled(false);
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
        limparTabelaVisitantes();
        TfObsVisitante.setEnabled(false);
        TfCodVisitante.setEnabled(false);
        TfNomeVisitante.setEnabled(false);
        TfRgVisitante.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        TbVisitante.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaVisitantes();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbVisitanteMouseClicked

        String nome_pts = "" + TbVisitante.getValueAt(TbVisitante.getSelectedRow(), 0);
        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps = '" + nome_pts + "'");
        try {
            conPs.rs.first();
            codPs = (conPs.rs.getInt("cod_ps"));
            TfNomeVisitante.setText(conPs.rs.getString("nome_ps"));
            TfRgVisitante.setText(conPs.rs.getString("rg_ps"));
            TfFoneFixo.setText(conPs.rs.getString("fone_fixo"));
            TfFoneCelular.setText(conPs.rs.getString("celular_ps"));
            TfEmail.setText(conPs.rs.getString("email_ps"));
            conPs.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
        conVst.conexao();
        conVst.executaSQL("select * from vw_visitante where nome_ps = '" + nome_pts + "'");
        try {
            conVst.rs.first();
            TfCodVisitante.setText(conVst.rs.getString("cod_vis"));
            TfObsVisitante.setText(conVst.rs.getString("obs_vis"));
            habilitaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conVst.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbVisitanteMouseClicked

    private void TfCodVisitanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodVisitanteKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodVisitanteKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        nomeVst = JOptionPane.showInputDialog(null, "Digite o nome do visitante :");
        if (nomeVst.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o nome do visitante desejado.");
        } else {
            pesquisaTabelaVisitantes();
            TbVisitante.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void TfNomeVisitanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNomeVisitanteKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfNomeVisitanteKeyTyped

    private void TfRgVisitanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfRgVisitanteKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfRgVisitanteKeyTyped

    public void preencherTabelaVisitantes(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Visitante", "Observações visitante"};
        conVst.conexao();
        conVst.executaSQL(SQL);
        try {
            conVst.rs.first();
            do {
                dados.add(new Object[]{conVst.rs.getString("nome_ps"), conVst.rs.getString("obs_vis")});
            } while (conVst.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe visitante cadastrado com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbVisitante.setModel(modTabela);
        TbVisitante.getColumnModel().getColumn(0).setPreferredWidth(200);
        TbVisitante.getColumnModel().getColumn(0).setResizable(false);
        TbVisitante.getColumnModel().getColumn(1).setPreferredWidth(409);
        TbVisitante.getColumnModel().getColumn(1).setResizable(false);
        TbVisitante.getTableHeader().setReorderingAllowed(false);
        TbVisitante.setAutoResizeMode(TbVisitante.AUTO_RESIZE_OFF);
        TbVisitante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conVst.desconecta();
    }

    public void limparTabelaVisitantes(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Visitante", "Observações visitante"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbVisitante.setModel(modTabela);
        TbVisitante.getColumnModel().getColumn(0).setPreferredWidth(200);
        TbVisitante.getColumnModel().getColumn(0).setResizable(false);
        TbVisitante.getColumnModel().getColumn(1).setPreferredWidth(409);
        TbVisitante.getColumnModel().getColumn(1).setResizable(false);
        TbVisitante.getTableHeader().setReorderingAllowed(false);
        TbVisitante.setAutoResizeMode(TbVisitante.AUTO_RESIZE_OFF);
        TbVisitante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JTable TbVisitante;
    private javax.swing.JFormattedTextField TfCodVisitante;
    private javax.swing.JTextField TfEmail;
    private javax.swing.JFormattedTextField TfFoneCelular;
    private javax.swing.JFormattedTextField TfFoneFixo;
    private javax.swing.JTextField TfNomeVisitante;
    private javax.swing.JTextArea TfObsVisitante;
    private javax.swing.JFormattedTextField TfRgVisitante;
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
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

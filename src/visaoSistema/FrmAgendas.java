package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleTipoAgenda;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloTipoAgenda;
import ModeloSistema.TratamentoCampos;

public class FrmAgendas extends javax.swing.JInternalFrame {

    ConectaBanco conTpAgdComp = new ConectaBanco();
    ConectaBanco conTpAgdCont = new ConectaBanco();
    ConectaBanco conPesquisa = new ConectaBanco();
    ModeloTipoAgenda modTpAgd = new ModeloTipoAgenda();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleTipoAgenda control = new ControleTipoAgenda();
    String descTpAgdComp = "", dTpAgdComp, descTpAgdCont = "", descTipoAgdCont = "", descTipoAgdComp = "";
    int clicouTpCont = 0, clicouTpComp = 0;

    public FrmAgendas() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
    }

    public void verificarTipoAgendaCompromisso() {

        conTpAgdComp.conexao();
        conTpAgdComp.executaSQL("select * from tab_tipo_agenda_compromisso where Desc_Tp_Agd_Comp ='" + TfCodTipoAgendaCompromisso.getText() + "'");
        try {
            conTpAgdComp.rs.first();
            descTipoAgdComp = conTpAgdComp.rs.getString("Desc_Tp_Agd_Comp");
        } catch (SQLException ex) {
        }
        conTpAgdComp.desconecta();
    }

    public void verificarTipoAgendaContato() {

        conTpAgdCont.conexao();
        conTpAgdCont.executaSQL("select * from tab_tipo_agenda_contato where Desc_Tp_Agd_Cont ='" + TfDescricaoTipoAgendaContato.getText() + "'");
        try {
            conTpAgdCont.rs.first();
            descTipoAgdCont = conTpAgdCont.rs.getString("Desc_Tp_Agd_Cont");
        } catch (SQLException ex) {
        }
        conTpAgdCont.desconecta();
    }

    public void atualizarCamposContato() {

        TfCodTipoAgendaContato.setText("");
        TfDescricaoTipoAgendaContato.setText("");
    }

    public void atualizarCamposCompromisso() {

        TfCodTipoAgendaCompromisso.setText("");
        TfDescricaoTipoAgendaCompromisso.setText("");
    }

    public void habilitaCamposContato() {

        TfDescricaoTipoAgendaContato.setEnabled(true);
    }

    public void habilitaCamposCompromisso() {

        TfDescricaoTipoAgendaCompromisso.setEnabled(true);
    }

    public void pesquisaTabelaTipoAgendaContato() {

        preencherTabelaTipoAgendaContato(" select * from Tab_Tipo_Agenda_Contato where Desc_Tp_Agd_Cont like '%" + descTpAgdCont + "%'");
    }

    public void limparTabelaTipoAgendaContato() {

        limparTabelaTipoAgendaContato("");
    }

    public void pesquisaTabelaTipoAgendaCompromisso() {

        preencherTabelaTipoAgendaCompromisso(" select * from Tab_Tipo_Agenda_Compromisso where Desc_Tp_Agd_Comp like '%" + descTpAgdComp + "%'");
    }

    public void limparTabelaTipoAgendaCompromisso() {

        limparTabelaTipoAgendaCompromisso("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AbasConsultas = new javax.swing.JTabbedPane();
        AbaEntradaPessoas = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        BtAdicionar1 = new javax.swing.JButton();
        BtCancelar1 = new javax.swing.JButton();
        BtExcluir1 = new javax.swing.JButton();
        BtAlterar1 = new javax.swing.JButton();
        BtSalvar1 = new javax.swing.JButton();
        BtEditar1 = new javax.swing.JButton();
        TfCodTipoAgendaCompromisso = new javax.swing.JFormattedTextField();
        BtConsultar1 = new javax.swing.JButton();
        TfDescricaoTipoAgendaCompromisso = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbTipoAgendaCompromisso = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        AbaSaidasPessoas = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        TfCodTipoAgendaContato = new javax.swing.JFormattedTextField();
        BtConsultar = new javax.swing.JButton();
        TfDescricaoTipoAgendaContato = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbTipoAgendaContato = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Tipos de Agendas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Tipos de Agendas");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Cod. Tipo Agd Compromisso");

        BtAdicionar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        BtAdicionar1.setToolTipText("Adicionar Registro");
        BtAdicionar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionar1ActionPerformed(evt);
            }
        });

        BtCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar1.setToolTipText("Cancelar Registro");
        BtCancelar1.setEnabled(false);
        BtCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelar1ActionPerformed(evt);
            }
        });

        BtExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir1.setToolTipText("Deletar Registro");
        BtExcluir1.setEnabled(false);
        BtExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluir1ActionPerformed(evt);
            }
        });

        BtAlterar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar1.setToolTipText("Alterar Registro");
        BtAlterar1.setEnabled(false);
        BtAlterar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterar1ActionPerformed(evt);
            }
        });

        BtSalvar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar1.setToolTipText("Salvar Registro");
        BtSalvar1.setEnabled(false);
        BtSalvar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvar1ActionPerformed(evt);
            }
        });

        BtEditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar1.setToolTipText("Editar Registro");
        BtEditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditar1ActionPerformed(evt);
            }
        });

        TfCodTipoAgendaCompromisso.setToolTipText("Código do tipo de agenda de compromisso");
        TfCodTipoAgendaCompromisso.setEnabled(false);

        BtConsultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar1.setToolTipText("Consultar Fornecedor");
        BtConsultar1.setEnabled(false);
        BtConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultar1ActionPerformed(evt);
            }
        });

        TfDescricaoTipoAgendaCompromisso.setToolTipText("Digite o tipo de agenda de compromisso");
        TfDescricaoTipoAgendaCompromisso.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoTipoAgendaCompromisso.setEnabled(false);
        TfDescricaoTipoAgendaCompromisso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TfDescricaoTipoAgendaCompromissoMouseClicked(evt);
            }
        });
        TfDescricaoTipoAgendaCompromisso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfDescricaoTipoAgendaCompromissoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Descrição Tipo Agd Compromisso");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6)
                            .addComponent(TfCodTipoAgendaCompromisso, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtAdicionar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(BtExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(BtCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(BtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtAlterar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TfDescricaoTipoAgendaCompromisso)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel3)
                .addGap(6, 6, 6)
                .addComponent(TfCodTipoAgendaCompromisso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(TfDescricaoTipoAgendaCompromisso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtAdicionar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEditar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAlterar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TbTipoAgendaCompromisso.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbTipoAgendaCompromisso.setToolTipText("Lista dos tipos de agendas de compromisso");
        TbTipoAgendaCompromisso.setEnabled(false);
        TbTipoAgendaCompromisso.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbTipoAgendaCompromissoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbTipoAgendaCompromisso);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Lista de Tipo de Agenda de Compromisso");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AbaEntradaPessoasLayout = new javax.swing.GroupLayout(AbaEntradaPessoas);
        AbaEntradaPessoas.setLayout(AbaEntradaPessoasLayout);
        AbaEntradaPessoasLayout.setHorizontalGroup(
            AbaEntradaPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaEntradaPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbaEntradaPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AbaEntradaPessoasLayout.setVerticalGroup(
            AbaEntradaPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaEntradaPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        AbasConsultas.addTab("Tipo Agenda Compromisso", AbaEntradaPessoas);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Tipo Agenda Contato");

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

        TfCodTipoAgendaContato.setToolTipText("Código do tipo de agenda de contato");
        TfCodTipoAgendaContato.setEnabled(false);
        TfCodTipoAgendaContato.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodTipoAgendaContatoKeyTyped(evt);
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

        TfDescricaoTipoAgendaContato.setToolTipText("Digite o tipo de agenda de contato");
        TfDescricaoTipoAgendaContato.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoTipoAgendaContato.setEnabled(false);
        TfDescricaoTipoAgendaContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TfDescricaoTipoAgendaContatoMouseClicked(evt);
            }
        });
        TfDescricaoTipoAgendaContato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfDescricaoTipoAgendaContatoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Descrição Tipo Agenda Contato");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(TfCodTipoAgendaContato, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
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
                        .addContainerGap()
                        .addComponent(TfDescricaoTipoAgendaContato)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(TfCodTipoAgendaContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(TfDescricaoTipoAgendaContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TbTipoAgendaContato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbTipoAgendaContato.setToolTipText("Lista dos tipos de agendas de contato");
        TbTipoAgendaContato.setEnabled(false);
        TbTipoAgendaContato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbTipoAgendaContatoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbTipoAgendaContato);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Lista de Tipo de Agenda de Contato");

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AbaSaidasPessoasLayout = new javax.swing.GroupLayout(AbaSaidasPessoas);
        AbaSaidasPessoas.setLayout(AbaSaidasPessoasLayout);
        AbaSaidasPessoasLayout.setHorizontalGroup(
            AbaSaidasPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaSaidasPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbaSaidasPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        AbaSaidasPessoasLayout.setVerticalGroup(
            AbaSaidasPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaSaidasPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        AbasConsultas.addTab("Tipo Agenda Contato", AbaSaidasPessoas);

        getContentPane().add(AbasConsultas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 420, 450));

        setBounds(0, 0, 453, 540);
    }// </editor-fold>//GEN-END:initComponents

    public void salvarTipoAgendaContato() {

        if (TfDescricaoTipoAgendaContato.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o tipo de agenda de contato!!");
            TfDescricaoTipoAgendaContato.requestFocus();
        } else {
            verificarTipoAgendaContato();
            if (TfDescricaoTipoAgendaContato.getText().equals(descTipoAgdCont)) {
                JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de contato já existe!!");
            } else {
                modTpAgd.setDescTpAgdCont(TfDescricaoTipoAgendaContato.getText());
                control.InserirTipoAgendaContato(modTpAgd);
                atualizarCamposContato();
                limparTabelaTipoAgendaContato();
                JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de contato : " + modTpAgd.getDescTpAgdCont() + " foi registrado com sucesso!!");
                TfDescricaoTipoAgendaContato.setEnabled(false);
                TbTipoAgendaContato.setEnabled(false);
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

        salvarTipoAgendaContato();
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        descTpAgdCont = TfDescricaoTipoAgendaContato.getText();
        String nome = "Você deseja deletar o tipo de agenda de contato : " + descTpAgdCont + " ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            modTpAgd.setCodTpAgdCont(Integer.valueOf(TfCodTipoAgendaContato.getText()));
            control.ExcluirTipoAgendaContato(modTpAgd);//Exclui o tipo de agenda do contato
            JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de contato : " + descTpAgdCont + " foi deletado com sucesso!!");
            TfCodTipoAgendaContato.setEnabled(false);
            TfDescricaoTipoAgendaContato.setEnabled(false);
            TbTipoAgendaContato.setEnabled(false);
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

        atualizarCamposContato();
        limparTabelaTipoAgendaContato();
        TfDescricaoTipoAgendaContato.setEnabled(true);
        TfDescricaoTipoAgendaContato.requestFocus();
        TbTipoAgendaContato.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    public void alterarTipoAgdContato() {

        modTpAgd.setCodTpAgdCont(Integer.parseInt(TfCodTipoAgendaContato.getText()));
        modTpAgd.setDescTpAgdCont(TfDescricaoTipoAgendaContato.getText());
        control.AlterarTipoAgendaContato(modTpAgd);
        JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de contato: " + modTpAgd.getDescTpAgdCont() + " foi alterado com sucesso!!");
        atualizarCamposContato();
        limparTabelaTipoAgendaContato();
        TfCodTipoAgendaContato.setEnabled(false);
        TfDescricaoTipoAgendaContato.setEnabled(false);
        TbTipoAgendaContato.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultar.setEnabled(false);
        clicouTpCont = 0;
    }

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        alterarTipoAgdContato();
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCamposContato();
        limparTabelaTipoAgendaContato();
        TfCodTipoAgendaContato.setEnabled(false);
        TfDescricaoTipoAgendaContato.setEnabled(false);
        TbTipoAgendaContato.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaTipoAgendaContato();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbTipoAgendaContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbTipoAgendaContatoMouseClicked

        String DescTpAgdCont = "" + TbTipoAgendaContato.getValueAt(TbTipoAgendaContato.getSelectedRow(), 0);
        conTpAgdCont.conexao();
        conTpAgdCont.executaSQL("select * from tab_tipo_agenda_contato where Desc_Tp_Agd_Cont = '" + DescTpAgdCont + "'");
        try {
            conTpAgdCont.rs.first();
            TfCodTipoAgendaContato.setText(conTpAgdCont.rs.getString("Cod_Tp_Agd_Cont"));
            TfDescricaoTipoAgendaContato.setText(conTpAgdCont.rs.getString("Desc_Tp_Agd_Cont"));
            habilitaCamposContato();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            clicouTpCont = 1;
            conTpAgdCont.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbTipoAgendaContatoMouseClicked

    private void TfCodTipoAgendaContatoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodTipoAgendaContatoKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodTipoAgendaContatoKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        descTpAgdCont = JOptionPane.showInputDialog(null, "Digite a descrição do tipo de agenda de contato :");
        if (descTpAgdCont.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição do tipo de agenda de contato desejado.");
        } else {
            pesquisaTabelaTipoAgendaContato();
            TbTipoAgendaContato.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void BtAdicionar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionar1ActionPerformed

        atualizarCamposCompromisso();
        limparTabelaTipoAgendaCompromisso();
        TfDescricaoTipoAgendaCompromisso.setEnabled(true);
        TfDescricaoTipoAgendaCompromisso.requestFocus();
        TbTipoAgendaContato.setEnabled(false);
        BtExcluir1.setEnabled(false);
        BtAlterar1.setEnabled(false);
        BtEditar1.setEnabled(false);
        BtCancelar1.setEnabled(true);
        BtSalvar1.setEnabled(true);
        BtAdicionar1.setEnabled(false);
    }//GEN-LAST:event_BtAdicionar1ActionPerformed

    private void BtCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelar1ActionPerformed

        atualizarCamposCompromisso();
        limparTabelaTipoAgendaCompromisso();
        TfCodTipoAgendaCompromisso.setEnabled(false);
        TfDescricaoTipoAgendaCompromisso.setEnabled(false);
        TbTipoAgendaCompromisso.setEnabled(false);
        BtConsultar1.setEnabled(false);
        BtExcluir1.setEnabled(false);
        BtAlterar1.setEnabled(false);
        BtEditar1.setEnabled(true);
        BtCancelar1.setEnabled(false);
        BtSalvar1.setEnabled(false);
        BtAdicionar1.setEnabled(true);
    }//GEN-LAST:event_BtCancelar1ActionPerformed

    private void BtExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluir1ActionPerformed

        descTpAgdComp = TfDescricaoTipoAgendaCompromisso.getText();
        String nome = "Você deseja deletar o tipo de agenda de compromisso : " + descTpAgdComp + " ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            modTpAgd.setCodTpAgdComp(Integer.valueOf(TfCodTipoAgendaCompromisso.getText()));
            control.ExcluirTipoAgendaCompromisso(modTpAgd);//Exclui o tipo de agenda de compromisso
            JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de compromisso : " + descTpAgdComp + " foi deletado com sucesso!!");
            atualizarCamposCompromisso();
            limparTabelaTipoAgendaCompromisso();
            TfCodTipoAgendaCompromisso.setEnabled(false);
            TfDescricaoTipoAgendaCompromisso.setEnabled(false);
            TbTipoAgendaCompromisso.setEnabled(false);
            BtExcluir1.setEnabled(false);
            BtAlterar1.setEnabled(false);
            BtCancelar1.setEnabled(false);
            BtSalvar1.setEnabled(false);
            BtAdicionar1.setEnabled(true);
            BtEditar1.setEnabled(true);
            descTpAgdComp = "";
        } else {
        }
    }//GEN-LAST:event_BtExcluir1ActionPerformed

    public void alterarTipoAgdCompromisso() {

        modTpAgd.setCodTpAgdComp(Integer.valueOf(TfCodTipoAgendaCompromisso.getText()));
        modTpAgd.setDescTpAgdComp(TfDescricaoTipoAgendaCompromisso.getText());
        control.AlterarTipoAgendaCompromisso(modTpAgd);
        JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de compromisso: " + modTpAgd.getDescTpAgdComp() + " foi alterado com sucesso!!");
        atualizarCamposCompromisso();
        limparTabelaTipoAgendaCompromisso();
        TfCodTipoAgendaCompromisso.setEnabled(false);
        TfDescricaoTipoAgendaCompromisso.setEnabled(false);
        TbTipoAgendaCompromisso.setEnabled(false);
        BtExcluir1.setEnabled(false);
        BtAlterar1.setEnabled(false);
        BtEditar1.setEnabled(true);
        BtCancelar1.setEnabled(false);
        BtSalvar1.setEnabled(false);
        BtAdicionar1.setEnabled(true);
        BtConsultar1.setEnabled(false);
        clicouTpComp = 0;
    }

    private void BtAlterar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterar1ActionPerformed

        alterarTipoAgdCompromisso();
    }//GEN-LAST:event_BtAlterar1ActionPerformed

    public void salvarTipoAgendaCompromisso() {

        if (TfDescricaoTipoAgendaCompromisso.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o tipo de agenda de compromisso!!");
            TfDescricaoTipoAgendaContato.requestFocus();
        } else {
            verificarTipoAgendaCompromisso();
            if (TfDescricaoTipoAgendaCompromisso.getText().equals(descTipoAgdComp)) {
                JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de compromisso já existe!!");
            } else {
                modTpAgd.setDescTpAgdComp(TfDescricaoTipoAgendaCompromisso.getText());
                control.InserirTipoAgendaCompromisso(modTpAgd);
                atualizarCamposCompromisso();
                limparTabelaTipoAgendaCompromisso();
                JOptionPane.showMessageDialog(rootPane, "O tipo de agenda de compromisso : " + modTpAgd.getDescTpAgdComp() + " foi registrado com sucesso!!");
                TfDescricaoTipoAgendaCompromisso.setEnabled(false);
                TbTipoAgendaCompromisso.setEnabled(false);
                BtExcluir1.setEnabled(false);
                BtAlterar1.setEnabled(false);
                BtEditar1.setEnabled(true);
                BtCancelar1.setEnabled(false);
                BtSalvar1.setEnabled(false);
                BtAdicionar1.setEnabled(true);
            }
        }
    }

    private void BtSalvar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvar1ActionPerformed

        salvarTipoAgendaCompromisso();
    }//GEN-LAST:event_BtSalvar1ActionPerformed

    private void BtEditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditar1ActionPerformed

        limparTabelaTipoAgendaCompromisso();
        BtConsultar1.setEnabled(true);
        BtEditar1.setEnabled(false);
        BtCancelar1.setEnabled(true);
        BtSalvar1.setEnabled(false);
        BtAdicionar1.setEnabled(false);
    }//GEN-LAST:event_BtEditar1ActionPerformed

    private void BtConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultar1ActionPerformed

        descTpAgdComp = JOptionPane.showInputDialog(null, "Digite a descrição do tipo de agenda de compromisso :");
        if (descTpAgdComp.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição do tipo de agenda de compromisso desejado.");
        } else {
            pesquisaTabelaTipoAgendaCompromisso();
            TbTipoAgendaCompromisso.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultar1ActionPerformed

    private void TbTipoAgendaCompromissoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbTipoAgendaCompromissoMouseClicked

        String DescTpAgdComp = "" + TbTipoAgendaCompromisso.getValueAt(TbTipoAgendaCompromisso.getSelectedRow(), 0);
        conTpAgdComp.conexao();
        conTpAgdComp.executaSQL("select * from tab_tipo_agenda_compromisso where Desc_Tp_Agd_Comp = '" + DescTpAgdComp + "'");
        try {
            conTpAgdComp.rs.first();
            TfCodTipoAgendaCompromisso.setText(conTpAgdComp.rs.getString("Cod_Tp_Agd_Comp"));
            TfDescricaoTipoAgendaCompromisso.setText(conTpAgdComp.rs.getString("Desc_Tp_Agd_Comp"));
            habilitaCamposCompromisso();
            BtExcluir1.setEnabled(true);
            BtAlterar1.setEnabled(true);
            clicouTpComp = 1;
            conTpAgdComp.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbTipoAgendaCompromissoMouseClicked

    private void TfDescricaoTipoAgendaCompromissoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TfDescricaoTipoAgendaCompromissoMouseClicked

        BtAlterar1.setEnabled(true);
        BtExcluir1.setEnabled(false);
    }//GEN-LAST:event_TfDescricaoTipoAgendaCompromissoMouseClicked

    private void TfDescricaoTipoAgendaContatoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TfDescricaoTipoAgendaContatoMouseClicked

        BtAlterar.setEnabled(true);
        BtExcluir.setEnabled(false);
    }//GEN-LAST:event_TfDescricaoTipoAgendaContatoMouseClicked

    private void TfDescricaoTipoAgendaContatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfDescricaoTipoAgendaContatoActionPerformed

        if (clicouTpCont == 1) {
            alterarTipoAgdContato();
        } else {
            salvarTipoAgendaContato();
        }        
    }//GEN-LAST:event_TfDescricaoTipoAgendaContatoActionPerformed

    private void TfDescricaoTipoAgendaCompromissoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfDescricaoTipoAgendaCompromissoActionPerformed

        if (clicouTpComp == 1) {
            alterarTipoAgdCompromisso();
        } else {
            salvarTipoAgendaCompromisso();
        }
    }//GEN-LAST:event_TfDescricaoTipoAgendaCompromissoActionPerformed

    public void preencherTabelaTipoAgendaContato(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Descrição Tipo Agenda Contato"};
        conTpAgdCont.conexao();
        conTpAgdCont.executaSQL(SQL);
        try {
            conTpAgdCont.rs.first();
            do {
                dados.add(new Object[]{conTpAgdCont.rs.getString("Desc_Tp_Agd_Cont")});
            } while (conTpAgdCont.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe tipo de agenda de contato cadastrado com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbTipoAgendaContato.setModel(modTabela);
        TbTipoAgendaContato.getColumnModel().getColumn(0).setPreferredWidth(361);
        TbTipoAgendaContato.getColumnModel().getColumn(0).setResizable(false);
        TbTipoAgendaContato.getTableHeader().setReorderingAllowed(false);
        TbTipoAgendaContato.setAutoResizeMode(TbTipoAgendaContato.AUTO_RESIZE_OFF);
        TbTipoAgendaContato.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conTpAgdCont.desconecta();
    }

    public void limparTabelaTipoAgendaContato(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Descrição Tipo Agenda Contato"};
        dados.add(new Object[]{""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbTipoAgendaContato.setModel(modTabela);
        TbTipoAgendaContato.getColumnModel().getColumn(0).setPreferredWidth(361);
        TbTipoAgendaContato.getColumnModel().getColumn(0).setResizable(false);
        TbTipoAgendaContato.getTableHeader().setReorderingAllowed(false);
        TbTipoAgendaContato.setAutoResizeMode(TbTipoAgendaContato.AUTO_RESIZE_OFF);
        TbTipoAgendaContato.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void preencherTabelaTipoAgendaCompromisso(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Descrição Tipo Agenda Compromisso"};
        conTpAgdComp.conexao();
        conTpAgdComp.executaSQL(SQL);
        try {
            conTpAgdComp.rs.first();
            do {
                dados.add(new Object[]{conTpAgdComp.rs.getString("Desc_Tp_Agd_Comp")});
            } while (conTpAgdComp.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe tipo de agenda de compromisso cadastrado com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbTipoAgendaCompromisso.setModel(modTabela);
        TbTipoAgendaCompromisso.getColumnModel().getColumn(0).setPreferredWidth(361);
        TbTipoAgendaCompromisso.getColumnModel().getColumn(0).setResizable(false);
        TbTipoAgendaCompromisso.getTableHeader().setReorderingAllowed(false);
        TbTipoAgendaCompromisso.setAutoResizeMode(TbTipoAgendaCompromisso.AUTO_RESIZE_OFF);
        TbTipoAgendaCompromisso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conTpAgdComp.desconecta();
    }

    public void limparTabelaTipoAgendaCompromisso(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Descrição Tipo Agenda Compromisso"};
        dados.add(new Object[]{""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbTipoAgendaCompromisso.setModel(modTabela);
        TbTipoAgendaCompromisso.getColumnModel().getColumn(0).setPreferredWidth(361);
        TbTipoAgendaCompromisso.getColumnModel().getColumn(0).setResizable(false);
        TbTipoAgendaCompromisso.getTableHeader().setReorderingAllowed(false);
        TbTipoAgendaCompromisso.setAutoResizeMode(TbTipoAgendaCompromisso.AUTO_RESIZE_OFF);
        TbTipoAgendaCompromisso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbaEntradaPessoas;
    private javax.swing.JPanel AbaSaidasPessoas;
    private javax.swing.JTabbedPane AbasConsultas;
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAdicionar1;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtAlterar1;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtCancelar1;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtConsultar1;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtEditar1;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtExcluir1;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JButton BtSalvar1;
    private javax.swing.JTable TbTipoAgendaCompromisso;
    private javax.swing.JTable TbTipoAgendaContato;
    private javax.swing.JFormattedTextField TfCodTipoAgendaCompromisso;
    private javax.swing.JFormattedTextField TfCodTipoAgendaContato;
    private javax.swing.JTextField TfDescricaoTipoAgendaCompromisso;
    private javax.swing.JTextField TfDescricaoTipoAgendaContato;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

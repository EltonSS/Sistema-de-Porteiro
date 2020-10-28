package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleHospedes;
import ControleSistema.ControlePessoas;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloHospedes;
import ModeloSistema.ModeloPessoas;
import ModeloSistema.TratamentoCampos;

public class FrmHospedes extends javax.swing.JInternalFrame {

    ConectaBanco conHosp = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conApt = new ConectaBanco();
    ConectaBanco conRamalApt = new ConectaBanco();
    ConectaBanco conTrr = new ConectaBanco();
    ModeloHospedes modHosp = new ModeloHospedes();
    ModeloPessoas modPs = new ModeloPessoas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleHospedes control = new ControleHospedes();
    ControlePessoas controlPs = new ControlePessoas();
    String nomeHosp = "", nmHosp = "", nmPs = "", rgHosp = "", numApt = "";
    int codPs;
    boolean cbMorador = false;

    public FrmHospedes() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        preencherCbTorres();
        camposTelefones();
        campoRg();
    }

    public void verificarNomeHospede() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps ='" + TfNomeHospede.getText() + "'");
        try {
            conPs.rs.first();
            nmHosp = conPs.rs.getString("nome_ps");
        } catch (SQLException ex) {

        }
        conPs.desconecta();
    }

    public void verificarRgHospede() {

        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where rg_ps ='" + TfRgHospede.getText() + "'");
        try {
            conPs.rs.first();
            rgHosp = conPs.rs.getString("rg_ps");
        } catch (SQLException ex) {

        }
        conPs.desconecta();
    }

    public void campoRg() {

        try {
            MaskFormatter Rg = new MaskFormatter("#######");
            TfRgHospede.setFormatterFactory(new DefaultFormatterFactory(Rg));
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

    public void preencherCbTorres() {

        CbTorre.addItem("Escolha a Torre");
        try {
            conTrr.conexao();
            conTrr.executaSQL("select * from tab_torres");
            conTrr.rs.first();
            do {
                CbTorre.addItem(conTrr.rs.getString("desc_trr"));
            } while (conTrr.rs.next());
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar as descrições das torres \n ERRO :" );
        }
        conTrr.desconecta();
    }

    public void preencherCbNumeroApartamento() {

        CbNumeroApt.removeAllItems();
        conApt.conexao();
        conApt.executaSQL("select * from vw_apartamento where desc_trr = '" + CbTorre.getSelectedItem() + "'order by num_apt");
        try {
            conApt.rs.first();
            do {
                CbNumeroApt.addItem(conApt.rs.getString("num_apt"));
            } while (conApt.rs.next());
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não existe apartamento cadastrado para essa torre!!");
        }
        conApt.desconecta();
    }

    public void preencherCampoRamal() {

        conRamalApt.conexao();
        conRamalApt.executaSQL("select * from vw_apartamento where desc_trr = '" + CbTorre.getSelectedItem() + "' and num_apt = '" + CbNumeroApt.getSelectedItem() + "'");
        try {
            conRamalApt.rs.first();
            do {
                TfRamalApt.setText(conRamalApt.rs.getString("ramal_apt"));
            } while (conRamalApt.rs.next());
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Ramal não cadastrado para esse apartamento!!");
        }
        conRamalApt.desconecta();
    }

    public void atualizarCampos() {

        nomeHosp = "";
        numApt = "";
        TfCodHospede.setText("");
        TfNomeHospede.setText("");
        TfRgHospede.setText("");
        TfFoneFixo.setText("");
        TfFoneCelular.setText("");
        TfEmail.setText("");
        TfRamalApt.setText("");
    }

    public void habilitaCampos() {

        CbNumeroApt.setEnabled(true);
        CbTorre.setEnabled(true);
        CbNumeroApt.setEnabled(true);
        TfNomeHospede.setEnabled(true);
        TfRgHospede.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
    }

    public void pesquisaTabelaHospedes() {

        preencherTabelaHospedes(" select * from vw_hospede where nome_ps like '%" + nomeHosp + "%'");
    }

    public void limparTabelaHospedes() {

        limparTabelaHospedes("");
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
        TfCodHospede = new javax.swing.JFormattedTextField();
        BtConsultar = new javax.swing.JButton();
        TfNomeHospede = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TfFoneFixo = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        TfFoneCelular = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        TfEmail = new javax.swing.JTextField();
        TfRgHospede = new javax.swing.JFormattedTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        CbTorre = new javax.swing.JComboBox();
        CbNumeroApt = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        TfRamalApt = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbHospedes = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Hóspedes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Hóspede");

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

        TfCodHospede.setToolTipText("Código do hóspede");
        TfCodHospede.setEnabled(false);
        TfCodHospede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodHospedeKeyTyped(evt);
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

        TfNomeHospede.setToolTipText("Digite o nome do hóspede");
        TfNomeHospede.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeHospede.setEnabled(false);
        TfNomeHospede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNomeHospedeKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Nome Hóspede");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Fone Fixo");

        TfFoneFixo.setToolTipText("Digite o fone fixo do hóspede");
        TfFoneFixo.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Fone Celular");

        TfFoneCelular.setToolTipText("Digite o celular do hóspede");
        TfFoneCelular.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("E-mail");

        TfEmail.setToolTipText("Digite o e-mail do hóspede");
        TfEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfEmail.setEnabled(false);

        TfRgHospede.setToolTipText("Digite o rg do hóspede");
        TfRgHospede.setEnabled(false);
        TfRgHospede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfRgHospedeKeyTyped(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Rg");

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Torre");

        CbTorre.setToolTipText("Escolha a torre do hóspede");
        CbTorre.setEnabled(false);
        CbTorre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbTorreActionPerformed(evt);
            }
        });

        CbNumeroApt.setToolTipText("Escolha o apartamento do hóspede");
        CbNumeroApt.setEnabled(false);
        CbNumeroApt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbNumeroAptActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Nº Apartamento");

        TfRamalApt.setToolTipText("Ramal do hóspede");
        TfRamalApt.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfRamalApt.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Ramal");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbTorre, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(CbNumeroApt, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(TfRamalApt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(311, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel16)))
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CbTorre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbNumeroApt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfRamalApt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(TfCodHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(TfEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 318, Short.MAX_VALUE)
                        .addContainerGap())
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
                            .addComponent(TfNomeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(TfRgHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(TfCodHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel14))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfNomeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfRgHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 640, 300));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Hóspedes");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Hóspedes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbHospedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbHospedes.setToolTipText("Lista de moradores cadastrados");
        TbHospedes.setEnabled(false);
        TbHospedes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbHospedesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbHospedes);

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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 640, 180));

        setBounds(0, 0, 676, 581);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfNomeHospede.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o nome do hóspede!!");
            TfNomeHospede.requestFocus();
        } else {
            if (TfRgHospede.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite o rg do hóspede!!");
                TfRgHospede.requestFocus();
            } else {
                if (cbMorador == false) {
                    JOptionPane.showMessageDialog(rootPane, "Escolha uma torre!!");
                } else {
                    if (CbTorre.getSelectedItem().equals("Escolha a Torre")) {
                        JOptionPane.showMessageDialog(rootPane, "Escolha uma torre!!");
                    } else {
                        verificarNomeHospede();
                        if (TfNomeHospede.getText().equals((String) nmHosp)) {
                            JOptionPane.showMessageDialog(null, "Já existe hóspede cadastrado com esse nome!!");
                            TfNomeHospede.setText("");
                            TfNomeHospede.requestFocus();
                        } else {
                            verificarRgHospede();
                            if (TfRgHospede.getText().equals((String) rgHosp)) {
                                JOptionPane.showMessageDialog(null, "Já existe hóspede cadastrado com esse número de rg!!");
                                TfRgHospede.setText("");
                                TfRgHospede.requestFocus();
                            } else {
                                modPs.setCodPs(codPs);
                                modPs.setNomePs(TfNomeHospede.getText());
                                modPs.setRgPs(TfRgHospede.getText());
                                modPs.setFoneFixoPs(TfFoneFixo.getText());
                                modPs.setCelularPs(TfFoneCelular.getText());
                                modPs.setEmailPs(TfEmail.getText());
                                modPs.setDescTpPs("Hóspede");
                                controlPs.InserirPessoa(modPs);
                                modHosp.setNomeHosp(TfNomeHospede.getText());
                                modHosp.setTorreApt((String) CbTorre.getSelectedItem());
                                modHosp.setNumApt(numApt);
                                control.InserirHospede(modHosp);
                                atualizarCampos();
                                limparTabelaHospedes();
                                JOptionPane.showMessageDialog(rootPane, "O hóspede : " + modHosp.getNomeHosp() + " foi registrado com sucesso!!");
                                cbMorador = false;
                                TfNomeHospede.setEnabled(false);
                                TfRgHospede.setEnabled(false);
                                TfFoneCelular.setEnabled(false);
                                TfFoneFixo.setEnabled(false);
                                TfEmail.setEnabled(false);
                                CbTorre.setEnabled(false);
                                CbNumeroApt.setEnabled(false);
                                TbHospedes.setEnabled(false);
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

        nmPs = TfNomeHospede.getText();
        String nome = "Você deseja deletar o hóspede : " + nmPs + " ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            modHosp.setCodHosp(Integer.valueOf(TfCodHospede.getText()));
            control.ExcluirHospede(modHosp);//Exclui o morador
            modPs.setCodPs(codPs);
            modPs.setNomePs(TfNomeHospede.getText());
            controlPs.ExcluirPessoa(modPs);//Exclui a pessoa
            JOptionPane.showMessageDialog(rootPane, "O hóspede : " + modPs.getNomePs() + " foi deletado com sucesso!!");
            atualizarCampos();
            limparTabelaHospedes();
            cbMorador = false;
            TfCodHospede.setEnabled(false);
            CbTorre.setEnabled(false);
            CbNumeroApt.setEnabled(false);
            TfNomeHospede.setEnabled(false);
            TfRgHospede.setEnabled(false);
            TfFoneCelular.setEnabled(false);
            TfFoneFixo.setEnabled(false);
            TfEmail.setEnabled(false);
            TbHospedes.setEnabled(false);
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
        limparTabelaHospedes();
        cbMorador = false;
        TfNomeHospede.setEnabled(true);
        TfNomeHospede.requestFocus();
        TfRgHospede.setEnabled(true);
        TfFoneCelular.setEnabled(true);
        TfFoneFixo.setEnabled(true);
        TfEmail.setEnabled(true);
        CbTorre.setEnabled(true);
        CbNumeroApt.setEnabled(true);
        TbHospedes.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modPs.setCodPs(codPs);
        modPs.setNomePs(TfNomeHospede.getText());
        modPs.setRgPs(TfRgHospede.getText());
        modPs.setFoneFixoPs(TfFoneFixo.getText());
        modPs.setCelularPs(TfFoneCelular.getText());
        modPs.setEmailPs(TfEmail.getText());
        controlPs.AlterarPessoa(modPs);
        modHosp.setCodHosp(Integer.valueOf(TfCodHospede.getText()));
        modHosp.setNomeHosp(TfNomeHospede.getText());
        modHosp.setTorreApt((String) CbTorre.getSelectedItem());
        modHosp.setNumApt((String) CbNumeroApt.getSelectedItem());
        control.AlterarHospede(modHosp);
        JOptionPane.showMessageDialog(rootPane, "O hóspede: " + modPs.getNomePs() + " foi alterado com sucesso!!");
        atualizarCampos();
        limparTabelaHospedes();
        TfCodHospede.setEnabled(false);
        TfNomeHospede.setEnabled(false);
        TfRgHospede.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        CbTorre.setEnabled(false);
        CbNumeroApt.setEnabled(false);
        TbHospedes.setEnabled(false);
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
        limparTabelaHospedes();
        cbMorador = false;
        TfCodHospede.setEnabled(false);
        CbTorre.setEnabled(false);
        CbNumeroApt.setEnabled(false);
        TfNomeHospede.setEnabled(false);
        TfRgHospede.setEnabled(false);
        TfFoneCelular.setEnabled(false);
        TfFoneFixo.setEnabled(false);
        TfEmail.setEnabled(false);
        TbHospedes.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaHospedes();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbHospedesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbHospedesMouseClicked

        String nome_Hosp = "" + TbHospedes.getValueAt(TbHospedes.getSelectedRow(), 0);
        conPs.conexao();
        conPs.executaSQL("select * from tab_pessoas where nome_ps = '" + nome_Hosp + "'");
        try {
            conPs.rs.first();
            codPs = (conPs.rs.getInt("cod_ps"));
            TfNomeHospede.setText(conPs.rs.getString("nome_ps"));
            TfRgHospede.setText(conPs.rs.getString("rg_ps"));
            TfFoneFixo.setText(conPs.rs.getString("fone_fixo"));
            TfFoneCelular.setText(conPs.rs.getString("celular_ps"));
            TfEmail.setText(conPs.rs.getString("email_ps"));
            conPs.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
        conHosp.conexao();
        conHosp.executaSQL("select * from vw_hospede where nome_ps = '" + nome_Hosp + "'");
        try {
            conHosp.rs.first();
            TfCodHospede.setText(conHosp.rs.getString("cod_hsp"));
            CbTorre.setSelectedItem(conHosp.rs.getString("desc_trr"));
            CbNumeroApt.setSelectedItem(conHosp.rs.getString("num_apt"));
            TfRamalApt.setText(conHosp.rs.getString("ramal_apt"));
            habilitaCampos();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            conHosp.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbHospedesMouseClicked

    private void TfCodHospedeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodHospedeKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodHospedeKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        nomeHosp = JOptionPane.showInputDialog(null, "Digite o nome do hóspede :");
        if (nomeHosp.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o nome do hóspede desejado.");
        } else {
            pesquisaTabelaHospedes();
            TbHospedes.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void CbTorreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbTorreActionPerformed

        cbMorador = true;
        preencherCbNumeroApartamento();
    }//GEN-LAST:event_CbTorreActionPerformed

    private void CbNumeroAptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbNumeroAptActionPerformed

        numApt = (String) CbNumeroApt.getSelectedItem();
        preencherCampoRamal();
    }//GEN-LAST:event_CbNumeroAptActionPerformed

    private void TfNomeHospedeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNomeHospedeKeyTyped

        tCampos.soLetras(evt);
    }//GEN-LAST:event_TfNomeHospedeKeyTyped

    private void TfRgHospedeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfRgHospedeKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfRgHospedeKeyTyped

    public void preencherTabelaHospedes(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Hóspede", "Número Apt", "Torre", "Ramal"};
        conHosp.conexao();
        conHosp.executaSQL(SQL);
        try {
            conHosp.rs.first();
            do {
                dados.add(new Object[]{conHosp.rs.getString("nome_ps"), conHosp.rs.getString("num_apt"), conHosp.rs.getString("desc_trr"), conHosp.rs.getString("ramal_apt")});
            } while (conHosp.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe hóspede cadastrado com esse nome!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbHospedes.setModel(modTabela);
        TbHospedes.getColumnModel().getColumn(0).setPreferredWidth(309);
        TbHospedes.getColumnModel().getColumn(0).setResizable(false);
        TbHospedes.getColumnModel().getColumn(1).setPreferredWidth(100);
        TbHospedes.getColumnModel().getColumn(1).setResizable(false);
        TbHospedes.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbHospedes.getColumnModel().getColumn(2).setResizable(false);
        TbHospedes.getColumnModel().getColumn(3).setPreferredWidth(100);
        TbHospedes.getColumnModel().getColumn(3).setResizable(false);
        TbHospedes.getTableHeader().setReorderingAllowed(false);
        TbHospedes.setAutoResizeMode(TbHospedes.AUTO_RESIZE_OFF);
        TbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conHosp.desconecta();
    }

    public void limparTabelaHospedes(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Hóspede", "Número Apt", "Torre", "Ramal"};
        dados.add(new Object[]{"", "", "", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbHospedes.setModel(modTabela);
        TbHospedes.getColumnModel().getColumn(0).setPreferredWidth(309);
        TbHospedes.getColumnModel().getColumn(0).setResizable(false);
        TbHospedes.getColumnModel().getColumn(1).setPreferredWidth(100);
        TbHospedes.getColumnModel().getColumn(1).setResizable(false);
        TbHospedes.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbHospedes.getColumnModel().getColumn(2).setResizable(false);
        TbHospedes.getColumnModel().getColumn(3).setPreferredWidth(100);
        TbHospedes.getColumnModel().getColumn(3).setResizable(false);
        TbHospedes.getTableHeader().setReorderingAllowed(false);
        TbHospedes.setAutoResizeMode(TbHospedes.AUTO_RESIZE_OFF);
        TbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbNumeroApt;
    private javax.swing.JComboBox CbTorre;
    private javax.swing.JTable TbHospedes;
    private javax.swing.JFormattedTextField TfCodHospede;
    private javax.swing.JTextField TfEmail;
    private javax.swing.JFormattedTextField TfFoneCelular;
    private javax.swing.JFormattedTextField TfFoneFixo;
    private javax.swing.JTextField TfNomeHospede;
    private javax.swing.JFormattedTextField TfRamalApt;
    private javax.swing.JFormattedTextField TfRgHospede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
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

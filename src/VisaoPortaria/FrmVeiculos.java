package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleVeiculos;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloVeiculos;
import ModeloSistema.TratamentoCampos;

public class FrmVeiculos extends javax.swing.JInternalFrame {

    ConectaBanco conVc = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conHsp = new ConectaBanco();
    ConectaBanco conVis = new ConectaBanco();
    ConectaBanco conMr = new ConectaBanco();
    ConectaBanco conFunc = new ConectaBanco();
    ConectaBanco conForn = new ConectaBanco();
    ConectaBanco conMc = new ConectaBanco();
    ConectaBanco conMd = new ConectaBanco();
    ConectaBanco conTpVc = new ConectaBanco();
    ConectaBanco conCor = new ConectaBanco();
    ConectaBanco conVs = new ConectaBanco();
    ConectaBanco conUnid = new ConectaBanco();
    ConectaBanco conConsult = new ConectaBanco();
    ModeloVeiculos modVc = new ModeloVeiculos();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleVeiculos control = new ControleVeiculos();
    String placaVc = "", placa, desctpPs, Rg;
    int codVc;

    public FrmVeiculos() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        preencherCbMarcasVeiculos();
        preencherCbCores();
    }

    public void formatarCampoPlacaVeiculo() {

        try {
            MaskFormatter Numplaca = new MaskFormatter("LLL####");
            TfPlacaVeiculo.setFormatterFactory(new DefaultFormatterFactory(Numplaca));
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher a data!! \n ERRO :" + ex);
        }
    }

    public void preencherCbMarcasVeiculos() {

        conMc.conexao();
        conMc.executaSQL("select * from tab_marca_veiculos");
        try {
            conMc.rs.first();
            do {
                CbMarcaVeiculo.addItem(conMc.rs.getString("desc_mc"));
            } while (conMc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar as marcas dos veículos \n ERRO :" + ex);
        }
        conMc.desconecta();
    }

    public void preencherCbModelosVeiculos() {

        CbModeloVeiculo.removeAllItems();
        conMd.conexao();
        conMd.executaSQL("select * from vw_modeloveiculo where desc_mc = '" + CbMarcaVeiculo.getSelectedItem() + "' ");
        try {
            conMd.rs.first();
            do {
                CbModeloVeiculo.addItem(conMd.rs.getString("desc_md"));
            } while (conMd.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar os modelos dos veículos \n ERRO :" + ex);
        }
        conMd.desconecta();
    }

    public void preencherCbCores() {

        conCor.conexao();
        conCor.executaSQL("select * from tab_cores");
        try {
            conCor.rs.first();
            do {
                CbCorVeiculo.addItem(conCor.rs.getString("desc_cor"));
            } while (conCor.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar as cores \n ERRO :" + ex);
        }
        conCor.desconecta();
    }

    public void atualizarCampos() {

        TfCodVeiculo.setText("");
        TfPlacaVeiculo.setText("");
        TfNomeProprietario.setText("");
        TfDetalhesProprietario.setText("");
    }

    public void habiltaCampos() {

        CbMarcaVeiculo.setEnabled(true);
        CbModeloVeiculo.setEnabled(true);
        CbCorVeiculo.setEnabled(true);
        TfPlacaVeiculo.setEnabled(true);
    }

    public void desabiltaCampos() {

        CbMarcaVeiculo.setEnabled(false);
        CbModeloVeiculo.setEnabled(false);
        CbCorVeiculo.setEnabled(false);
        TfPlacaVeiculo.setEnabled(false);
    }

    public void pesquisaTabelaVeiculo() {

        preencherTabelaVeiculos(" select * from vw_veiculo where placa_vc ='" + placaVc + "'");
    }

    public void limparTabelaVeiculo() {

        limparTabelaVeiculos("");
    }

    public void pesquisaPessoa() {

        conPs.conexao();
        conPs.executaSQL("select * from vw_pessoa where rg_ps ='" + Rg + "'");
        try {
            conPs.rs.first();
            desctpPs = conPs.rs.getString("desc_tp_ps");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o proprietário com esse número de rg!!");
        }
        conPs.desconecta();
    }

    public void verificarPlacaVeiculo() {

        conVc.conexao();
        conVc.executaSQL("select * from vw_veiculo where placa_vc ='" + TfPlacaVeiculo.getText() + "'");
        try {
            conVc.rs.first();
            placa = conVc.rs.getString("Placa_Vc");
        } catch (SQLException ex) {
        }
        conVc.desconecta();
    }

    public void setaMorador() {

        conMr.conexao();
        conMr.executaSQL("select * from vw_morador where rg_ps ='" + Rg + "'");
        try {
            conMr.rs.first();
            TfNomeProprietario.setText(conMr.rs.getString("nome_ps"));
            TfDetalhesProprietario.setText("Morador do Apt:" + conMr.rs.getString("num_Apt") + "-" + conMr.rs.getString("desc_trr") + " - Ramal:" + conMr.rs.getString("ramal_apt"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o morador \n ERRO :" + ex);
        }
        conMr.desconecta();
    }

    public void setaHospede() {

        conHsp.conexao();
        conHsp.executaSQL("select * from vw_hospede where rg_ps ='" + Rg + "'");
        try {
            conHsp.rs.first();
            TfNomeProprietario.setText(conHsp.rs.getString("nome_Ps"));
            TfDetalhesProprietario.setText("Hóspede do Apt:" + conHsp.rs.getString("num_Apt") + "-" + conHsp.rs.getString("desc_trr") + " - Ramal:" + conHsp.rs.getString("ramal_apt"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o hóspede \n ERRO :" + ex);
        }
        conHsp.desconecta();
    }

    public void setaVisitante() {

        conVis.conexao();
        conVis.executaSQL("select * from vw_visitante where rg_ps ='" + Rg + "'");
        try {
            conVis.rs.first();
            TfNomeProprietario.setText(conVis.rs.getString("nome_Ps"));
            TfDetalhesProprietario.setText(conVis.rs.getString("obs_vis"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o visitante \n ERRO :" + ex);
        }
        conVis.desconecta();
    }

    public void setaFuncionario() {

        conFunc.conexao();
        conFunc.executaSQL("select * from vw_funcionarioht where rg_ps ='" + Rg + "'");
        try {
            conFunc.rs.first();
            TfNomeProprietario.setText(conFunc.rs.getString("nome_Ps"));
            TfDetalhesProprietario.setText("Funcionário do Setor: " + conFunc.rs.getString("desc_sets") + " - Ramal:" + conFunc.rs.getString("num_rm"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o funcionário \n ERRO :" + ex);
        }
        conFunc.desconecta();
    }

    public void setaFornecedor() {

        conForn.conexao();
        conForn.executaSQL("select * from vw_prestadorservico where rg_ps ='" + Rg + "'");
        try {
            conForn.rs.first();
            TfNomeProprietario.setText(conForn.rs.getString("nome_Ps"));
            TfDetalhesProprietario.setText("Prestador de Sserviço da Empresa: " + conForn.rs.getString("desc_forn"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o fornecedor \n ERRO :" + ex);
        }
        conForn.desconecta();
    }

    public void setaDetalhesNomeProprietario() {

        pesquisaPessoa();
        if (desctpPs.equals((String) "Morador")) {
            setaMorador();
        } else {
            if (desctpPs.equals((String) "Hospede")) {
                setaHospede();
            } else {
                if (desctpPs.equals((String) "Visitante")) {
                    setaVisitante();
                } else {
                    if (desctpPs.equals((String) "Funcionário")) {
                        setaFuncionario();
                    } else {
                        if (desctpPs.equals((String) "Fornecedor")) {
                            setaFornecedor();
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Não existe nenuhuma pessoa proprietária cadastrada com esse rg!!");
                        }
                    }
                }
            }
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
        TfCodVeiculo = new javax.swing.JFormattedTextField();
        CbMarcaVeiculo = new javax.swing.JComboBox();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        TfDetalhesProprietario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        CbModeloVeiculo = new javax.swing.JComboBox();
        TfNomeProprietario = new javax.swing.JTextField();
        BtConsultarProprietario = new javax.swing.JButton();
        BtConsultar = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        CbCorVeiculo = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        TfPlacaVeiculo = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbVeiculos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar de Veículos");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Veículo");

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
        jLabel4.setText("Nome do Proprietário");

        TfCodVeiculo.setToolTipText("Código do veículo");
        TfCodVeiculo.setEnabled(false);
        TfCodVeiculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodVeiculoKeyTyped(evt);
            }
        });

        CbMarcaVeiculo.setToolTipText("Escolha a marca do veículo");
        CbMarcaVeiculo.setEnabled(false);
        CbMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbMarcaVeiculoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Marca Veículo");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Modelo Veículo");

        TfDetalhesProprietario.setToolTipText("Detalhes do proprietário");
        TfDetalhesProprietario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDetalhesProprietario.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Detalhes Proprietário");

        CbModeloVeiculo.setToolTipText("Escolha o modelo do veículo");
        CbModeloVeiculo.setEnabled(false);

        TfNomeProprietario.setToolTipText("Nome do proprietário");
        TfNomeProprietario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeProprietario.setEnabled(false);

        BtConsultarProprietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultarProprietario.setToolTipText("Consultar Fornecedor");
        BtConsultarProprietario.setEnabled(false);
        BtConsultarProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarProprietarioActionPerformed(evt);
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

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setText("Placa Veículo");

        CbCorVeiculo.setToolTipText("Escolha a cor do veiculo");
        CbCorVeiculo.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Cor Veículo");

        TfPlacaVeiculo.setToolTipText("Digite a placa do veículo");
        TfPlacaVeiculo.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(TfCodVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtConsultarProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(TfNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(TfDetalhesProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(CbMarcaVeiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(CbModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(CbCorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(TfPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(TfCodVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel22))
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CbMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TfPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(6, 6, 6)
                                .addComponent(CbCorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtConsultarProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(6, 6, 6)
                                        .addComponent(TfNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(6, 6, 6)
                                        .addComponent(TfDetalhesProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(CbModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 46, 760, 230));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Veículos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Veículos Cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setToolTipText("");

        TbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbVeiculos.setToolTipText("Lista dos veículos cadastrados");
        TbVeiculos.setEnabled(false);
        TbVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbVeiculos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 279, 760, 260));

        setBounds(0, 0, 797, 587);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfPlacaVeiculo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a placa do veículo!!");
            TfPlacaVeiculo.requestFocus();
        } else {
            if (TfNomeProprietario.getText().equals("") && TfNomeProprietario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Falta inserir o nome e os detalhes do proprietário!!");
            } else {
                verificarPlacaVeiculo();
                if (TfPlacaVeiculo.getText().equals(placa)) {
                    JOptionPane.showMessageDialog(null, "Já existe veículo cadastrado com esse número de placa!!");
                    TfPlacaVeiculo.setText("");
                    TfPlacaVeiculo.requestFocus();
                } else {
                    modVc.setDescMc((String) CbMarcaVeiculo.getSelectedItem());
                    modVc.setDescMd((String) CbModeloVeiculo.getSelectedItem());
                    modVc.setDescCor((String) CbCorVeiculo.getSelectedItem());
                    modVc.setPlacaVc(TfPlacaVeiculo.getText());
                    modVc.setNomePs(TfNomeProprietario.getText());
                    modVc.setDetalhesProp(TfDetalhesProprietario.getText());
                    control.InserirVeiculo(modVc);
                    limparTabelaVeiculo();
                    desabiltaCampos();
                    atualizarCampos();
                    BtExcluir.setEnabled(false);
                    BtAlterar.setEnabled(false);
                    BtEditar.setEnabled(true);
                    BtCancelar.setEnabled(false);
                    BtSalvar.setEnabled(false);
                    BtAdicionar.setEnabled(true);
                    BtConsultarProprietario.setEnabled(false);
                }
            }
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modVc.setCodVc(Integer.valueOf(TfCodVeiculo.getText()));
        modVc.setDescMd((String) CbModeloVeiculo.getSelectedItem());
        control.ExcluirVeiculo(modVc);
        atualizarCampos();
        limparTabelaVeiculo();
        desabiltaCampos();
        TbVeiculos.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtEditar.setEnabled(true);
        BtConsultarProprietario.setEnabled(false);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        limparTabelaVeiculo();
        habiltaCampos();
        TfPlacaVeiculo.setText("");
        formatarCampoPlacaVeiculo();
        atualizarCampos();
        TbVeiculos.setEnabled(false);
        TfPlacaVeiculo.requestFocus();
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
        BtConsultarProprietario.setEnabled(true);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modVc.setCodVc(Integer.valueOf(TfCodVeiculo.getText()));
        modVc.setDescMc((String) CbMarcaVeiculo.getSelectedItem());
        modVc.setDescMd((String) CbModeloVeiculo.getSelectedItem());
        modVc.setDescCor((String) CbCorVeiculo.getSelectedItem());
        modVc.setPlacaVc(TfPlacaVeiculo.getText());
        modVc.setNomePs(TfNomeProprietario.getText());
        modVc.setDetalhesProp(TfDetalhesProprietario.getText());
        control.AlterarVeiculo(modVc);
        atualizarCampos();
        limparTabelaVeiculo();
        desabiltaCampos();
        TbVeiculos.setEnabled(false);
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
        limparTabelaVeiculo();
        desabiltaCampos();
        TbVeiculos.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultarProprietario.setEnabled(false);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaVeiculo();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbVeiculosMouseClicked

        int NumColuna = 0, NumColuna2 = 1;
        Object nomePs = "" + TbVeiculos.getValueAt(TbVeiculos.getSelectedRow(), NumColuna);
        Object numPlaca = "" + TbVeiculos.getValueAt(TbVeiculos.getSelectedRow(), NumColuna2);
        conVc.conexao();
        conVc.executaSQL("select * from vw_veiculo where nome_ps = '" + nomePs + "' and placa_vc ='" + numPlaca + "'");
        try {
            conVc.rs.first();
            TfCodVeiculo.setText(conVc.rs.getString("cod_vc"));
            CbMarcaVeiculo.setSelectedItem(conVc.rs.getString("desc_mc"));
            CbModeloVeiculo.setSelectedItem(conVc.rs.getString("desc_md"));
            CbCorVeiculo.setSelectedItem(conVc.rs.getString("desc_cor"));
            TfPlacaVeiculo.setText(conVc.rs.getString("placa_vc"));
            TfNomeProprietario.setText(conVc.rs.getString("nome_ps"));
            TfDetalhesProprietario.setText(conVc.rs.getString("detalhes_prop"));
            conVc.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
        habiltaCampos();
        BtExcluir.setEnabled(true);
        BtAlterar.setEnabled(true);
        BtConsultarProprietario.setEnabled(true);
    }//GEN-LAST:event_TbVeiculosMouseClicked

    private void TfCodVeiculoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodVeiculoKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodVeiculoKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        placaVc = JOptionPane.showInputDialog(null, "Digite a placa do veículo");
        if (placaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a placa do veículo desejado.");
        } else {
            pesquisaTabelaVeiculo();
            TbVeiculos.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void CbMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbMarcaVeiculoActionPerformed

        preencherCbModelosVeiculos();
    }//GEN-LAST:event_CbMarcaVeiculoActionPerformed

    private void BtConsultarProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarProprietarioActionPerformed

        Rg = JOptionPane.showInputDialog(null, "Digite o número do Rg do Proprietário");
        if (Rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o número do rg do proprietário desejado.");
        } else {
            setaDetalhesNomeProprietario();
            TfPlacaVeiculo.requestFocus();
        }
    }//GEN-LAST:event_BtConsultarProprietarioActionPerformed

    public void preencherTabelaVeiculos(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Proprietário", "Placa Veículo", "Modelo", "Marca", "Cor"};
        conVc.conexao();
        conVc.executaSQL(SQL);
        try {
            conVc.rs.first();
            do {
                dados.add(new Object[]{conVc.rs.getString("nome_ps"), conVc.rs.getString("placa_vc"), conVc.rs.getString("desc_md"), conVc.rs.getString("desc_mc"), conVc.rs.getString("desc_cor")});
            } while (conVc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veículo não cadastrado!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbVeiculos.setModel(modTabela);
        TbVeiculos.getColumnModel().getColumn(0).setPreferredWidth(213);
        TbVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(1).setPreferredWidth(90);
        TbVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(2).setPreferredWidth(140);
        TbVeiculos.getColumnModel().getColumn(2).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(3).setPreferredWidth(140);
        TbVeiculos.getColumnModel().getColumn(3).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(4).setPreferredWidth(140);
        TbVeiculos.getColumnModel().getColumn(4).setResizable(false);
        TbVeiculos.getTableHeader().setReorderingAllowed(false);
        TbVeiculos.setAutoResizeMode(TbVeiculos.AUTO_RESIZE_OFF);
        TbVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conVc.desconecta();
    }

    public void limparTabelaVeiculos(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Proprietário", "Placa Veículo", "Modelo", "Marca", "Cor"};
        dados.add(new Object[]{"", "", "", "", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbVeiculos.setModel(modTabela);
        TbVeiculos.getColumnModel().getColumn(0).setPreferredWidth(213);
        TbVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(1).setPreferredWidth(90);
        TbVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(2).setPreferredWidth(140);
        TbVeiculos.getColumnModel().getColumn(2).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(3).setPreferredWidth(140);
        TbVeiculos.getColumnModel().getColumn(3).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(4).setPreferredWidth(140);
        TbVeiculos.getColumnModel().getColumn(4).setResizable(false);
        TbVeiculos.getTableHeader().setReorderingAllowed(false);
        TbVeiculos.setAutoResizeMode(TbVeiculos.AUTO_RESIZE_OFF);
        TbVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtConsultarProprietario;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbCorVeiculo;
    private javax.swing.JComboBox CbMarcaVeiculo;
    private javax.swing.JComboBox CbModeloVeiculo;
    private javax.swing.JTable TbVeiculos;
    private javax.swing.JFormattedTextField TfCodVeiculo;
    private javax.swing.JTextField TfDetalhesProprietario;
    private javax.swing.JTextField TfNomeProprietario;
    private javax.swing.JFormattedTextField TfPlacaVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
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

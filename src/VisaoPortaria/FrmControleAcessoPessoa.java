package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleEntradasPessoas;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloEntradasPessoas;
import ModeloSistema.ModeloTabela;
import ModeloSistema.TratamentoCampos;
import ControleSistema.Funcoes;

public class FrmControleAcessoPessoa extends javax.swing.JInternalFrame {

    ConectaBanco conEntPs = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conMr = new ConectaBanco();
    ConectaBanco conHsp = new ConectaBanco();
    ConectaBanco conVis = new ConectaBanco();
    ConectaBanco conFunc = new ConectaBanco();
    ConectaBanco conForn = new ConectaBanco();
    ModeloEntradasPessoas modEntPs = new ModeloEntradasPessoas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleEntradasPessoas control = new ControleEntradasPessoas();
    Funcoes abrirTela = new Funcoes();
        String rgPs, nomPort, desctpPs;
    int EntrouSim = 1, Entrou, codEnt;

    public FrmControleAcessoPessoa(String nomePort) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        LbNomeUsuario.setText(nomePort);
        nomPort = nomePort;
        TempoDataHoraEntrada.start();
        atualizarTabelaEntradaTodasPessoas();
    }

    public void preencherTabelaEntradaPessoa() {

        preencherTabelaEntradasPessoas(" select * from vw_entrada_Pessoa where rg_ps ='" + rgPs + "' and entrou = '1'");
    }

    public void atualizarTabelaEntradaTodasPessoas() {

        preencherTabelaEntradasPessoas(" select * from vw_entrada_Pessoa where entrou = 1 order by data_ent_ps and hora_ent_ps desc ");
    }

    public void dataEntradaPessoa() throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        LbDataEntradaPessoa.setText(df.format(hoje));
    }

    public void horaEntradaPessoa() throws ParseException {

        int h = LocalTime.now().getHour();
        int m = LocalTime.now().getMinute();
        int s = LocalTime.now().getSecond();
        SimpleDateFormat df = new SimpleDateFormat(h + ":" + m + ":" + s);
        Date hora = new Date();
        LbHoraEntradaPessoa.setText(df.format(hora));

    }

    public void atualizarCampos() {

        TfNomePessoa.setText("");
        TfDetalhesPessoa.setText("");
        TfObservacaoEntradaPessoa.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TempoDataHoraEntrada = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LbDataEntradaPessoa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LbHoraEntradaPessoa = new javax.swing.JLabel();
        LbNomeUsuario = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TfNomePessoa = new javax.swing.JTextField();
        TfDetalhesPessoa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BtSalvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TfObservacaoEntradaPessoa = new javax.swing.JTextArea();
        BtConsultar = new javax.swing.JButton();
        BtConsultar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbEntradasPessoas = new javax.swing.JTable();

        TempoDataHoraEntrada.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                TempoDataHoraEntradaOnTime(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setTitle("Controle de Acesso das Pessoas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

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

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nome Pessoa");

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Data Entrada");

        LbDataEntradaPessoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbDataEntradaPessoa.setForeground(new java.awt.Color(51, 51, 255));
        LbDataEntradaPessoa.setText("Data");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora Entrada");

        LbHoraEntradaPessoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbHoraEntradaPessoa.setForeground(new java.awt.Color(51, 51, 255));
        LbHoraEntradaPessoa.setText("Hora");

        LbNomeUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbNomeUsuario.setForeground(new java.awt.Color(255, 0, 0));
        LbNomeUsuario.setText("nomeUsuário");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Porteiro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(LbDataEntradaPessoa))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(LbHoraEntradaPessoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbNomeUsuario)
                    .addComponent(jLabel25))
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(LbNomeUsuario))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(20, 20, 20)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbDataEntradaPessoa)
                            .addComponent(LbHoraEntradaPessoa))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        TfNomePessoa.setToolTipText("Nome do proprietário do veículo");
        TfNomePessoa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomePessoa.setEnabled(false);

        TfDetalhesPessoa.setToolTipText("Detalhes do proprietário do veículo");
        TfDetalhesPessoa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDetalhesPessoa.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Detalhes Pessoa");

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/BotaoAcessoPessoa.png"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Observação Entrada Veículo");

        TfObservacaoEntradaPessoa.setColumns(20);
        TfObservacaoEntradaPessoa.setRows(5);
        TfObservacaoEntradaPessoa.setToolTipText("Observações do visitante");
        TfObservacaoEntradaPessoa.setEnabled(false);
        jScrollPane2.setViewportView(TfObservacaoEntradaPessoa);

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Veículo");
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });

        BtConsultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultar1.setToolTipText("Consultar Veículo");
        BtConsultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TfNomePessoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(147, 147, 147))
                            .addComponent(TfDetalhesPessoa))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfDetalhesPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Controle de Acesso das Pessoas");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entradas dos Pessoas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbEntradasPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbEntradasPessoas.setToolTipText("Lista de veículos que entraram no hotel");
        TbEntradasPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbEntradasPessoasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TbEntradasPessoas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 413, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 826, 568);
    }// </editor-fold>//GEN-END:initComponents

    public void verificaEntradaPessoa() {

        conEntPs.conexao();
        try {
            conEntPs.executaSQL("select * from vw_entrada_Pessoa where rg_ps = '" + rgPs + "' and entrou ='1'");
            conEntPs.rs.first();
            Entrou = conEntPs.rs.getInt("entrou");
        } catch (SQLException ex) {
        }
        conEntPs.desconecta();
    }

    public void setaMorador() {

        conMr.conexao();
        conMr.executaSQL("select * from vw_morador where rg_ps ='" + rgPs + "'");
        try {
            conMr.rs.first();
            TfNomePessoa.setText(conMr.rs.getString("nome_ps"));
            TfDetalhesPessoa.setText("Morador do Apt:" + conMr.rs.getString("num_Apt") + "-" + conMr.rs.getString("desc_trr") + " - Ramal:" + conMr.rs.getString("ramal_apt"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o morador \n ERRO :" + ex);
        }
        conMr.desconecta();
    }

    public void setaHospede() {

        conHsp.conexao();
        conHsp.executaSQL("select * from vw_hospede where rg_ps ='" + rgPs + "'");
        try {
            conHsp.rs.first();
            TfNomePessoa.setText(conHsp.rs.getString("nome_Ps"));
            TfDetalhesPessoa.setText("Hóspede do Apt:" + conHsp.rs.getString("num_Apt") + "-" + conHsp.rs.getString("desc_trr") + " - Ramal:" + conHsp.rs.getString("ramal_apt"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o hóspede \n ERRO :" + ex);
        }
        conHsp.desconecta();
    }

    public void setaVisitante() {

        conVis.conexao();
        conVis.executaSQL("select * from vw_visitante where rg_ps ='" + rgPs + "'");
        try {
            conVis.rs.first();
            TfNomePessoa.setText(conVis.rs.getString("nome_Ps"));
            TfDetalhesPessoa.setText(conVis.rs.getString("obs_vis"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o visitante \n ERRO :" + ex);
        }
        conVis.desconecta();
    }

    public void setaFuncionario() {

        conFunc.conexao();
        conFunc.executaSQL("select * from vw_funcionarioht where rg_ps ='" + rgPs + "'");
        try {
            conFunc.rs.first();
            TfNomePessoa.setText(conFunc.rs.getString("nome_Ps"));
            TfDetalhesPessoa.setText("Funcionário do Setor: " + conFunc.rs.getString("desc_sets") + " - Ramal:" + conFunc.rs.getString("num_rm"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o funcionário \n ERRO :" + ex);
        }
        conFunc.desconecta();
    }

    public void setaFornecedor() {

        conForn.conexao();
        conForn.executaSQL("select * from vw_prestadorservico where rg_ps ='" + rgPs + "'");
        try {
            conForn.rs.first();
            TfNomePessoa.setText(conForn.rs.getString("nome_Ps"));
            TfDetalhesPessoa.setText("Prestador de Sserviço da Empresa: " + conForn.rs.getString("desc_forn"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o fornecedor \n ERRO :" + ex);
        }
        conForn.desconecta();
    }

    public void pesquisaTipoPessoa() {

        conPs.conexao();
        try {
            conPs.executaSQL("select * from vw_pessoa where rg_ps = '" + rgPs + "'");
            conPs.rs.first();
            desctpPs = conPs.rs.getString("desc_tp_ps");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum tipo de pessoa cadastrado!!");
        }
        conPs.desconecta();
    }

    public void setaDetalhesNomeProprietario() {

        pesquisaTipoPessoa();
        if (desctpPs.equals((String) "Morador")) {
            setaMorador();
        } else {
            if (desctpPs.equals((String) "Hóspede")) {
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
                            JOptionPane.showMessageDialog(rootPane, "Não existe nenuhuma pessoa proprietária cadastrada com esse rgPessoa!!");
                        }
                    }
                }
            }
        }
    }

    public void pesquisaPessoa() {

        conPs.conexao();
        try {
            conPs.executaSQL("select * from vw_pessoa where rg_ps = '" + rgPs + "'");
            conPs.rs.first();
            TfNomePessoa.setText(conPs.rs.getString("nome_ps"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma pessoa cadastrada com esse número de rg da pessoa!!");
        }
        conPs.desconecta();
    }

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        rgPs = JOptionPane.showInputDialog(null, "Digite o Rg da pessoa :");
        if (rgPs.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para dá a entrada da pessoa no condomínio, é necessário digitar o número do rgPessoa da mesma");
        } else {
            verificaEntradaPessoa();
            if (Entrou == 1) {
                JOptionPane.showMessageDialog(null, "Esse veículo já estrou no condomínio!!");
            } else {
                pesquisaPessoa();
                setaDetalhesNomeProprietario();
                TfObservacaoEntradaPessoa.setEnabled(true);
                BtCancelar.setEnabled(true);
                BtSalvar.setEnabled(true);
                BtAdicionar.setEnabled(false);
                BtConsultar.setEnabled(false);
                BtConsultar1.setEnabled(false);
            }
        }
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        TfObservacaoEntradaPessoa.setEnabled(false);
        BtConsultar.setEnabled(true);
        BtConsultar1.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfObservacaoEntradaPessoa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite alguma observação!!");
            TfObservacaoEntradaPessoa.requestFocus();
        } else {
            modEntPs.setDataEnt(LbDataEntradaPessoa.getText());
            modEntPs.setHoraEnt(LbHoraEntradaPessoa.getText());
            modEntPs.setObsEnt(TfObservacaoEntradaPessoa.getText());
            modEntPs.setNomePort(LbNomeUsuario.getText());//Nome do porteiro
            modEntPs.setDetalhesPs(TfDetalhesPessoa.getText());
            modEntPs.setRgPs(rgPs);
            modEntPs.setEntrou(EntrouSim);
            control.InserirEntradaPessoa(modEntPs);
            atualizarCampos();
            atualizarTabelaEntradaTodasPessoas();
            JOptionPane.showMessageDialog(rootPane, "A pessoa : " + TfNomePessoa.getText() + " foi liberada a entrar no condomínio com sucesso!!");
            TfObservacaoEntradaPessoa.setEnabled(false);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
            BtConsultar.setEnabled(true);
            BtConsultar1.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void TbEntradasPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbEntradasPessoasMouseClicked

        try {
            int NumColuna = 0;
            Object nomePs = "" + TbEntradasPessoas.getValueAt(TbEntradasPessoas.getSelectedRow(), NumColuna);
            FrmSaidaPessoa frmSdPs = new FrmSaidaPessoa(nomPort, (String) nomePs, this);
            abrirTela.centralizarFormularioPorteiro(frmSdPs);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(FrmControleAcessoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TbEntradasPessoasMouseClicked

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        rgPs = JOptionPane.showInputDialog(null, "Digite o número do Rg da Pessoa");
        if (rgPs.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta da pessoa no condomínio, é necessário digitar o número do rgPessoa da mesma");
        } else {
            preencherTabelaEntradaPessoa();
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void BtConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultar1ActionPerformed

        atualizarTabelaEntradaTodasPessoas();
    }//GEN-LAST:event_BtConsultar1ActionPerformed

    private void TempoDataHoraEntradaOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempoDataHoraEntradaOnTime

        try {
            dataEntradaPessoa();
            horaEntradaPessoa();
        } catch (ParseException ex) {
            Logger.getLogger(FrmControleAcessoPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TempoDataHoraEntradaOnTime

    public void preencherTabelaEntradasPessoas(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Pessoa", "Rg", "Descrição Pessoa", "Data Entrada", "Hora Entrada"};
        conEntPs.conexao();
        conEntPs.executaSQL(SQL);
        try {
            conEntPs.rs.first();
            do {
                dados.add(new Object[]{conEntPs.rs.getString("nome_ps"), conEntPs.rs.getString("rg_ps"), conEntPs.rs.getString("Detalhes_Ps"), conEntPs.rs.getString("data_ent_ps"), conEntPs.rs.getString("hora_ent_ps"),});
            } while (conEntPs.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Essa pessoa não se encontra no condomínio!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbEntradasPessoas.setModel(modTabela);
        TbEntradasPessoas.getColumnModel().getColumn(0).setPreferredWidth(163);
        TbEntradasPessoas.getColumnModel().getColumn(0).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(1).setPreferredWidth(94);
        TbEntradasPessoas.getColumnModel().getColumn(1).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(2).setPreferredWidth(320);
        TbEntradasPessoas.getColumnModel().getColumn(2).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(3).setPreferredWidth(90);
        TbEntradasPessoas.getColumnModel().getColumn(3).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(4).setPreferredWidth(90);
        TbEntradasPessoas.getColumnModel().getColumn(4).setResizable(false);
        TbEntradasPessoas.getTableHeader().setReorderingAllowed(false);
        TbEntradasPessoas.setAutoResizeMode(TbEntradasPessoas.AUTO_RESIZE_OFF);
        TbEntradasPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conEntPs.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtConsultar1;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JLabel LbDataEntradaPessoa;
    private javax.swing.JLabel LbHoraEntradaPessoa;
    private javax.swing.JLabel LbNomeUsuario;
    private javax.swing.JTable TbEntradasPessoas;
    private org.netbeans.examples.lib.timerbean.Timer TempoDataHoraEntrada;
    private javax.swing.JTextField TfDetalhesPessoa;
    private javax.swing.JTextField TfNomePessoa;
    private javax.swing.JTextArea TfObservacaoEntradaPessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleSaidaChaves;
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
import ModeloSistema.ModeloSaidaChaves;
import ModeloSistema.ModeloTabela;
import ModeloSistema.TratamentoCampos;
import ControleSistema.Funcoes;
import com.mysql.jdbc.PreparedStatement;

public class FrmControleSaidaChaves extends javax.swing.JInternalFrame {

    ConectaBanco conSaidChv = new ConectaBanco();
    ConectaBanco conPs = new ConectaBanco();
    ConectaBanco conMr = new ConectaBanco();
    ConectaBanco conHsp = new ConectaBanco();
    ConectaBanco conVis = new ConectaBanco();
    ConectaBanco conFunc = new ConectaBanco();
    ConectaBanco conForn = new ConectaBanco();
    ConectaBanco conChv = new ConectaBanco();
    ModeloSaidaChaves modSaidChv = new ModeloSaidaChaves();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleSaidaChaves control = new ControleSaidaChaves();
    Funcoes abrirTela = new Funcoes();
    String rg, nomPort, desctpPs, descChave, codChv2;
    int SaiuSim = 1, Saiu = 0, SaiuChv = 1, codEnt, codChv;

    public FrmControleSaidaChaves(String nomePort) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        LbNomePorteiro.setText(nomePort);
        nomPort = nomePort;
        TempoDataHoraEntrada.start();
        atualizarTabelaSaidaChave();
    }

    public void preencherTabelaSaidaChave() {

        preencherTabelaSaidaChave(" select * from vw_saida_chave where cod_chv = '" + codChv + "' and saiu = '1'");
    }

    public void atualizarTabelaSaidaChave() {

        preencherTabelaSaidaChave(" select * from vw_saida_Chave where saiu = '1' order by data_said_chv and hora_said_chv desc ");
    }

    public void dataSaidaChave() throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        LbDataSaidaChaves.setText(df.format(hoje));
    }

    public void horaEntradaPessoa() throws ParseException {

        int h = LocalTime.now().getHour();
        int m = LocalTime.now().getMinute();
        int s = LocalTime.now().getSecond();
        SimpleDateFormat df = new SimpleDateFormat(h + ":" + m + ":" + s);
        Date hora = new Date();
        LbHoraSaidaChaves.setText(df.format(hora));
    }

    public void AtualizaTabSaidaChaves() {

        conSaidChv.conexao();
        try {
            PreparedStatement pstSaidChave = (PreparedStatement) conSaidChv.conn.prepareStatement("update tab_saida_chaves set saiu=? where cod_said_chv=?");
            pstSaidChave.setInt(1, Saiu);
            pstSaidChave.setString(2, codChv2); //Pega o código do formulário de entrega chaves e seta aqui para atualizar a tabela de saida e chaves
            pstSaidChave.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de saida de chaves!!\n Erro: " + ex);
        }
        conSaidChv.desconecta();
    }

    public void AlterarTabelaChaves() {

        conChv.conexao();
        try {
            PreparedStatement pstChaves = (PreparedStatement) conChv.conn.prepareStatement("update Tab_Chaves set Saiu=? where cod_chv = ?");
            pstChaves.setInt(1, SaiuChv);
            pstChaves.setInt(2, codChv);
            pstChaves.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de chaves!!\n Erro: " + ex);
        }
        conChv.desconecta();
    }

    public void atualizarCampos() {

        TfNomeSolicitante.setText("");
        TfDetalhesSolicitante.setText("");
        TfDescricaoChaves.setText("");
        TfDescricaoSetor.setText("");
        TfObservacaoSaidaChaves.setText("");
    }

    public void setaCamposChaveSetor(String Chave, String Setor) {

        TfDescricaoChaves.setText(Chave);
        TfDescricaoSetor.setText(Setor);
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
        LbDataSaidaChaves = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LbHoraSaidaChaves = new javax.swing.JLabel();
        LbNomePorteiro = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TfNomeSolicitante = new javax.swing.JTextField();
        TfDetalhesSolicitante = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BtSalvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TfObservacaoSaidaChaves = new javax.swing.JTextArea();
        BtConsultar = new javax.swing.JButton();
        BtAtualizarTabelaSaidaChaves = new javax.swing.JButton();
        BtConsultarChave = new javax.swing.JButton();
        TfDescricaoChaves = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TfDescricaoSetor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbSaidaChaves = new javax.swing.JTable();

        TempoDataHoraEntrada.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                TempoDataHoraEntradaOnTime(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setTitle("Controle de Saída de Chaves");

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
        jLabel15.setText("Nome Solicitante");

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Data Saída");

        LbDataSaidaChaves.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbDataSaidaChaves.setForeground(new java.awt.Color(51, 51, 255));
        LbDataSaidaChaves.setText("Data");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora Saída");

        LbHoraSaidaChaves.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbHoraSaidaChaves.setForeground(new java.awt.Color(51, 51, 255));
        LbHoraSaidaChaves.setText("Hora");

        LbNomePorteiro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbNomePorteiro.setForeground(new java.awt.Color(255, 0, 0));
        LbNomePorteiro.setText("nomeUsuário");

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
                    .addComponent(LbDataSaidaChaves))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(LbHoraSaidaChaves))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbNomePorteiro)
                    .addComponent(jLabel25))
                .addGap(39, 39, 39))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(LbNomePorteiro))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel25)
                            .addGap(20, 20, 20)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbDataSaidaChaves)
                            .addComponent(LbHoraSaidaChaves))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        TfNomeSolicitante.setToolTipText("Nome do solicitante");
        TfNomeSolicitante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeSolicitante.setEnabled(false);

        TfDetalhesSolicitante.setToolTipText("Detalhes do solicitante");
        TfDetalhesSolicitante.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDetalhesSolicitante.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Detalhes Solicitante");

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/BotaoChaves.png"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Observação Saída Chave");

        TfObservacaoSaidaChaves.setColumns(20);
        TfObservacaoSaidaChaves.setRows(5);
        TfObservacaoSaidaChaves.setToolTipText("Observações da saída da chave");
        TfObservacaoSaidaChaves.setEnabled(false);
        jScrollPane2.setViewportView(TfObservacaoSaidaChaves);

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Veículo");
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });

        BtAtualizarTabelaSaidaChaves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtAtualizarTabelaSaidaChaves.setToolTipText("Consultar Veículo");
        BtAtualizarTabelaSaidaChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAtualizarTabelaSaidaChavesActionPerformed(evt);
            }
        });

        BtConsultarChave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultarChave.setToolTipText("Consultar Veículo");
        BtConsultarChave.setEnabled(false);
        BtConsultarChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarChaveActionPerformed(evt);
            }
        });

        TfDescricaoChaves.setToolTipText("Descrição da chave");
        TfDescricaoChaves.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoChaves.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Descrição Chave");

        TfDescricaoSetor.setToolTipText("Descrição do setor da chave");
        TfDescricaoSetor.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDescricaoSetor.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Setor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addComponent(BtAtualizarTabelaSaidaChaves, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(346, 630, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(TfNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(TfDetalhesSolicitante)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtConsultarChave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(TfDescricaoChaves, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(TfDescricaoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TfDetalhesSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TfNomeSolicitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtConsultarChave, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(6, 6, 6)
                        .addComponent(TfDescricaoChaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(TfDescricaoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAtualizarTabelaSaidaChaves, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Controle de Saída das Chaves");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Saídas das Chaves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbSaidaChaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TbSaidaChaves.setToolTipText("Lista de chaves solicitadas");
        TbSaidaChaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbSaidaChavesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TbSaidaChaves);

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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 944, 586);
    }// </editor-fold>//GEN-END:initComponents

    public void setaMorador() {

        conMr.conexao();
        conMr.executaSQL("select * from vw_morador where rg_ps ='" + rg + "'");
        try {
            conMr.rs.first();
            TfNomeSolicitante.setText(conMr.rs.getString("nome_ps"));
            TfDetalhesSolicitante.setText("Morador do Apt:" + conMr.rs.getString("num_Apt") + "-" + conMr.rs.getString("desc_trr") + " - Ramal:" + conMr.rs.getString("ramal_apt"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o morador \n ERRO :" + ex);
        }
        conMr.desconecta();
    }

    public void setaHospede() {

        conHsp.conexao();
        conHsp.executaSQL("select * from vw_hospede where rg_ps ='" + rg + "'");
        try {
            conHsp.rs.first();
            TfNomeSolicitante.setText(conHsp.rs.getString("nome_Ps"));
            TfDetalhesSolicitante.setText("Hóspede do Apt:" + conHsp.rs.getString("num_Apt") + "-" + conHsp.rs.getString("desc_trr") + " - Ramal:" + conHsp.rs.getString("ramal_apt"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o hóspede \n ERRO :" + ex);
        }
        conHsp.desconecta();
    }

    public void setaVisitante() {

        conVis.conexao();
        conVis.executaSQL("select * from vw_visitante where rg_ps ='" + rg + "'");
        try {
            conVis.rs.first();
            TfNomeSolicitante.setText(conVis.rs.getString("nome_Ps"));
            TfDetalhesSolicitante.setText(conVis.rs.getString("obs_vis"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o visitante \n ERRO :" + ex);
        }
        conVis.desconecta();
    }

    public void setaFuncionario() {

        conFunc.conexao();
        conFunc.executaSQL("select * from vw_funcionarioht where rg_ps ='" + rg + "'");
        try {
            conFunc.rs.first();
            TfNomeSolicitante.setText(conFunc.rs.getString("nome_Ps"));
            TfDetalhesSolicitante.setText("Funcionário do Setor: " + conFunc.rs.getString("desc_set") + " - Ramal:" + conFunc.rs.getString("num_rm"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o funcionário \n ERRO :" + ex);
        }
        conFunc.desconecta();
    }

    public void setaFornecedor() {

        conForn.conexao();
        conForn.executaSQL("select * from vw_prestadorservico where rg_ps ='" + rg + "'");
        try {
            conForn.rs.first();
            TfNomeSolicitante.setText(conForn.rs.getString("nome_Ps"));
            TfDetalhesSolicitante.setText("Prestador de Sserviço da Empresa: " + conForn.rs.getString("desc_forn"));
        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Não foi possível localizar o fornecedor \n ERRO :" + ex);
        }
        conForn.desconecta();
    }

    public void pesquisaTipoPessoa() {

        conPs.conexao();
        try {
            conPs.executaSQL("select * from vw_pessoa where rg_ps = '" + rg + "'");
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
                            JOptionPane.showMessageDialog(rootPane, "Não existe nenuhuma pessoa proprietária cadastrada com esse rg!!");
                        }
                    }
                }
            }
        }
    }

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        rg = JOptionPane.showInputDialog(null, "Digite o rg da pessoa :");
        if (rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para o solicitante retirar a chave, é necessário digitar o número do rg do mesmo");
        } else {
            pesquisaTipoPessoa();
            setaDetalhesNomeProprietario();
            TfObservacaoSaidaChaves.setEnabled(true);
            BtCancelar.setEnabled(true);
            BtSalvar.setEnabled(true);
            BtAdicionar.setEnabled(false);
            BtConsultar.setEnabled(false);
            BtAtualizarTabelaSaidaChaves.setEnabled(false);
            BtConsultarChave.setEnabled(true);
        }
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        TfObservacaoSaidaChaves.setEnabled(false);
        BtConsultar.setEnabled(true);
        BtAtualizarTabelaSaidaChaves.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultarChave.setEnabled(false);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfDescricaoChaves.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Insira a chave que está sendo solicitada!!");
        } else {
            if (TfObservacaoSaidaChaves.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Digite alguma observação!!");
                TfObservacaoSaidaChaves.requestFocus();
            } else {
                modSaidChv.setDataSaid(LbDataSaidaChaves.getText());
                modSaidChv.setHoraSaid(LbHoraSaidaChaves.getText());
                modSaidChv.setNomePort(LbNomePorteiro.getText());
                modSaidChv.setRgPs(rg);//será consultado o nome do solicitante com RG em controle chaves
                modSaidChv.setDetalhesPs(TfDetalhesSolicitante.getText());
                modSaidChv.setCodChv(codChv);// será consultado o código da chave e o código do setor em controle chaves
                modSaidChv.setObsSaid(TfObservacaoSaidaChaves.getText());
                modSaidChv.setSaiu(SaiuSim);
                control.InserirSaidaChaves(modSaidChv);
                AlterarTabelaChaves();
                atualizarCampos();
                atualizarTabelaSaidaChave();
                JOptionPane.showMessageDialog(rootPane, "A chave : " + descChave + " foi liberada para o solicitante " + TfNomeSolicitante.getText() + " com sucesso!!");
                TfObservacaoSaidaChaves.setEnabled(false);
                BtCancelar.setEnabled(false);
                BtSalvar.setEnabled(false);
                BtAdicionar.setEnabled(true);
                BtConsultar.setEnabled(true);
                BtAtualizarTabelaSaidaChaves.setEnabled(true);
                BtConsultarChave.setEnabled(false);
            }
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void TbSaidaChavesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbSaidaChavesMouseClicked

        int NumColuna = 0;
        Object codSaidChv = "" + TbSaidaChaves.getValueAt(TbSaidaChaves.getSelectedRow(), NumColuna);
        codChv2 = (String) codSaidChv;
        FrmEntregaChaves frmEntChv = null;
        try {
            frmEntChv = new FrmEntregaChaves(nomPort, (String) codSaidChv, this);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(FrmControleSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        abrirTela.centralizarFormularioPorteiro(frmEntChv);
    }//GEN-LAST:event_TbSaidaChavesMouseClicked

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        descChave = JOptionPane.showInputDialog(null, "Digite a descrição da chave que será entregue");
        if (rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta da chave, é necessário digitar a descrição da mesma");
        } else {
            preencherTabelaSaidaChave();
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void BtAtualizarTabelaSaidaChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAtualizarTabelaSaidaChavesActionPerformed

        atualizarTabelaSaidaChave();
    }//GEN-LAST:event_BtAtualizarTabelaSaidaChavesActionPerformed

    private void TempoDataHoraEntradaOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempoDataHoraEntradaOnTime

        try {
            dataSaidaChave();
            horaEntradaPessoa();

        } catch (ParseException ex) {
            Logger.getLogger(FrmControleSaidaChaves.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TempoDataHoraEntradaOnTime

    private void BtConsultarChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarChaveActionPerformed

        FrmPesquisaChaves pesqChaves;
        try {
            pesqChaves = new FrmPesquisaChaves(this);
            abrirTela.centralizarFormularioPorteiro(pesqChaves);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(FrmControleSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtConsultarChaveActionPerformed

    public void preencherTabelaSaidaChave(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"", "Nome Solicitante", "Descrição Solicitante", "Chave Solicitada", "Setor", "Data Saída", "Hora Saída"};
        conSaidChv.conexao();
        conSaidChv.executaSQL(SQL);
        try {
            conSaidChv.rs.first();
            do {
                dados.add(new Object[]{conSaidChv.rs.getInt("cod_said_chv"), conSaidChv.rs.getString("nome_ps"), conSaidChv.rs.getString("Detalhes_Ps"), conSaidChv.rs.getString("desc_chv"), conSaidChv.rs.getString("desc_set"), conSaidChv.rs.getString("data_said_chv"), conSaidChv.rs.getString("hora_said_chv")});
            } while (conSaidChv.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Essa chave não está disponível no momento!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbSaidaChaves.setModel(modTabela);
        TbSaidaChaves.getColumnModel().getColumn(0).setPreferredWidth(1);
        TbSaidaChaves.getColumnModel().getColumn(0).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(1).setPreferredWidth(151);
        TbSaidaChaves.getColumnModel().getColumn(1).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(2).setPreferredWidth(320);
        TbSaidaChaves.getColumnModel().getColumn(2).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(3).setPreferredWidth(101);
        TbSaidaChaves.getColumnModel().getColumn(3).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(4).setPreferredWidth(116);
        TbSaidaChaves.getColumnModel().getColumn(4).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(5).setPreferredWidth(86);
        TbSaidaChaves.getColumnModel().getColumn(5).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(6).setPreferredWidth(86);
        TbSaidaChaves.getColumnModel().getColumn(6).setResizable(false);
        TbSaidaChaves.getTableHeader().setReorderingAllowed(false);
        TbSaidaChaves.setAutoResizeMode(TbSaidaChaves.AUTO_RESIZE_OFF);
        TbSaidaChaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conSaidChv.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAtualizarTabelaSaidaChaves;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtConsultarChave;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JLabel LbDataSaidaChaves;
    private javax.swing.JLabel LbHoraSaidaChaves;
    private javax.swing.JLabel LbNomePorteiro;
    private javax.swing.JTable TbSaidaChaves;
    private org.netbeans.examples.lib.timerbean.Timer TempoDataHoraEntrada;
    private javax.swing.JTextField TfDescricaoChaves;
    private javax.swing.JTextField TfDescricaoSetor;
    private javax.swing.JTextField TfDetalhesSolicitante;
    private javax.swing.JTextField TfNomeSolicitante;
    private javax.swing.JTextArea TfObservacaoSaidaChaves;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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

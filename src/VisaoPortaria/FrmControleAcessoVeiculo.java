package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleEntradasVeiculos;
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
import ModeloSistema.ModeloEntradasVeiculos;
import ModeloSistema.ModeloTabela;
import ModeloSistema.TratamentoCampos;
import VisaoTelaPrincipal.TelaPrincipal;
import javax.swing.JInternalFrame;

public class FrmControleAcessoVeiculo extends javax.swing.JInternalFrame {

    ConectaBanco conEntVc = new ConectaBanco();
    ConectaBanco conVc = new ConectaBanco();
    ModeloEntradasVeiculos modEntVc = new ModeloEntradasVeiculos();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleEntradasVeiculos control = new ControleEntradasVeiculos();
    String placaVc, numplaca, nomPort;
    int EntrouSim = 1, Entrou, codEnt;

    public FrmControleAcessoVeiculo(String nomePort) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        LbNomeUsuario.setText(nomePort);
        nomPort = nomePort;
        TempoDataHoraEntrada.start();
        atualizarTabelaEntradaVeiculoTodos();
    }

    public void preencherTabelaEntradaVeiculo() {

        preencherTabelaEntradasVeiculos(" select * from vw_entrada_veiculo where placa_vc ='" + numplaca + "' and entrou = '1'");
    }

    public void atualizarTabelaEntradaVeiculoTodos() {

        preencherTabelaEntradasVeiculos(" select * from vw_entrada_veiculo where entrou = 1 order by data_ent_vc and hora_ent_vc desc ");
    }

    public void dataEntradaVeiculo() throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        LbDataEntradaVeiculo.setText(df.format(hoje));
    }

    public void horaEntradaVeiculo() throws ParseException {

        int h = LocalTime.now().getHour();
        int m = LocalTime.now().getMinute();
        int s = LocalTime.now().getSecond();
        SimpleDateFormat df = new SimpleDateFormat(h + ":" + m + ":" + s);
        Date hora = new Date();
        LbHoraEntradaVeiculo.setText(df.format(hora));
    }

    public void centralizarFormularioPorteiro(JInternalFrame Formulario) {

        int x, y;
        x = (TelaPrincipal.areaTrabalhoPorteiro.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (TelaPrincipal.areaTrabalhoPorteiro.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoPorteiro.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void atualizarCampos() {

        TfPlacaVeiculo.setText("");
        TfModeloVeiculo.setText("");
        TfMarcaVeiculo.setText("");
        TfCorVeiculo.setText("");
        TfNomeProprietario.setText("");
        TfDetalhesProprietario.setText("");
        TfObservacaoEntradaVeiculo.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TempoDataHoraEntrada = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        TfPlacaVeiculo = new javax.swing.JTextField();
        TfModeloVeiculo = new javax.swing.JTextField();
        TfCorVeiculo = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LbDataEntradaVeiculo = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LbHoraEntradaVeiculo = new javax.swing.JLabel();
        LbNomeUsuario = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TfMarcaVeiculo = new javax.swing.JTextField();
        TfNomeProprietario = new javax.swing.JTextField();
        TfDetalhesProprietario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BtSalvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TfObservacaoEntradaVeiculo = new javax.swing.JTextArea();
        BtExcluir = new javax.swing.JButton();
        BtConsultar = new javax.swing.JButton();
        BtConsultar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbEntradasVeiculos = new javax.swing.JTable();

        TempoDataHoraEntrada.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                TempoDataHoraEntradaOnTime(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setTitle("Controle de Acesso dos Veículos");

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Marca Veículo");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setText("Placa Veículo");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setText("Modelo Veículo");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Cor Veículo");

        TfPlacaVeiculo.setToolTipText("Placa do veículo");
        TfPlacaVeiculo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfPlacaVeiculo.setEnabled(false);

        TfModeloVeiculo.setToolTipText("Modelo do veículo");
        TfModeloVeiculo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfModeloVeiculo.setEnabled(false);

        TfCorVeiculo.setToolTipText("Cor do veículo");
        TfCorVeiculo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfCorVeiculo.setEnabled(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nome Proprietário");

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Data Entrada");

        LbDataEntradaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbDataEntradaVeiculo.setForeground(new java.awt.Color(51, 51, 255));
        LbDataEntradaVeiculo.setText("Data");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora Entrada");

        LbHoraEntradaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbHoraEntradaVeiculo.setForeground(new java.awt.Color(51, 51, 255));
        LbHoraEntradaVeiculo.setText("Hora");

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
                    .addComponent(LbDataEntradaVeiculo))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(LbHoraEntradaVeiculo))
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
                            .addComponent(LbDataEntradaVeiculo)
                            .addComponent(LbHoraEntradaVeiculo))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        TfMarcaVeiculo.setToolTipText("Marca do veículo");
        TfMarcaVeiculo.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfMarcaVeiculo.setEnabled(false);

        TfNomeProprietario.setToolTipText("Nome do proprietário do veículo");
        TfNomeProprietario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomeProprietario.setEnabled(false);

        TfDetalhesProprietario.setToolTipText("Detalhes do proprietário do veículo");
        TfDetalhesProprietario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDetalhesProprietario.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Detalhes Proprietário");

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Carro.png"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Observação Entrada Veículo");

        TfObservacaoEntradaVeiculo.setColumns(20);
        TfObservacaoEntradaVeiculo.setRows(5);
        TfObservacaoEntradaVeiculo.setToolTipText("Observações do visitante");
        TfObservacaoEntradaVeiculo.setEnabled(false);
        jScrollPane2.setViewportView(TfObservacaoEntradaVeiculo);

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

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
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(173, 173, 173)
                                .addComponent(jLabel16))
                            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TfPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(TfModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(TfMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addGap(0, 127, Short.MAX_VALUE))
                                    .addComponent(TfCorVeiculo)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TfDetalhesProprietario)))
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel18)
                    .addComponent(jLabel4)
                    .addComponent(jLabel21))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfCorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfDetalhesProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Controle de Acesso dos Veículos");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Entradas dos Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbEntradasVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbEntradasVeiculos.setToolTipText("Lista de veículos que entraram no hotel");
        TbEntradasVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbEntradasVeiculosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TbEntradasVeiculos);

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
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 777, 610);
    }// </editor-fold>//GEN-END:initComponents

    public void verificaEntradaVeiculo() {

        conEntVc.conexao();
        try {
            conEntVc.executaSQL("select * from vw_entrada_veiculo where placa_vc = '" + placaVc + "' and entrou ='1'");
            conEntVc.rs.first();
            Entrou = conEntVc.rs.getInt("entrou");
        } catch (SQLException ex) {
        }
        conEntVc.desconecta();
    }

    public void pesquisaVeiculo() {

        conVc.conexao();
        try {
            conVc.executaSQL("select * from vw_veiculo where placa_vc = '" + placaVc + "'");
            conVc.rs.first();
            TfPlacaVeiculo.setText(conVc.rs.getString("Placa_Vc"));
            TfModeloVeiculo.setText(conVc.rs.getString("desc_md"));
            TfMarcaVeiculo.setText(conVc.rs.getString("desc_mc"));
            TfCorVeiculo.setText(conVc.rs.getString("desc_cor"));
            TfNomeProprietario.setText(conVc.rs.getString("nome_ps"));
            TfDetalhesProprietario.setText(conVc.rs.getString("detalhes_Prop"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum veículo cadastrado com esse número de placa!!");
        }
        conVc.desconecta();
    }

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

//        Entrou = 0;
        placaVc = JOptionPane.showInputDialog(null, "Digite a placa do veículo :");
        if (placaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para dá a entrada do veículo no hotel, é necessário digitar o número placa do veículo");
        } else {
            verificaEntradaVeiculo();
            if (Entrou == 1) {
                JOptionPane.showMessageDialog(null, "Esse veículo já estrou no condomínio!!");
            } else {
                pesquisaVeiculo();
                TfObservacaoEntradaVeiculo.setEnabled(true);
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
        TfObservacaoEntradaVeiculo.setEnabled(false);
        BtConsultar.setEnabled(true);
        BtConsultar1.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfObservacaoEntradaVeiculo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite alguma observação!!");
            TfObservacaoEntradaVeiculo.requestFocus();
        } else {
            modEntVc.setDataEnt(LbDataEntradaVeiculo.getText());
            modEntVc.setHoraEnt(LbHoraEntradaVeiculo.getText());
            modEntVc.setObsEnt(TfObservacaoEntradaVeiculo.getText());
            modEntVc.setNomePort(LbNomeUsuario.getText());//Nome do porteiro
            modEntVc.setPlacaVc(TfPlacaVeiculo.getText());
            modEntVc.setEntrou(EntrouSim);
            control.InserirEntradaVeiculo(modEntVc);
            atualizarCampos();
            atualizarTabelaEntradaVeiculoTodos();
            JOptionPane.showMessageDialog(rootPane, "O veículo de placa número : " + modEntVc.getPlacaVc() + " foi liberado a estacionar no condomínio com sucesso!!");
            TfObservacaoEntradaVeiculo.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
            BtConsultar.setEnabled(true);
            BtConsultar1.setEnabled(true);
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void TbEntradasVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbEntradasVeiculosMouseClicked

        try {
            int NumColuna = 1;
            Object numPlaca = "" + TbEntradasVeiculos.getValueAt(TbEntradasVeiculos.getSelectedRow(), NumColuna);
            FrmSaidaVeiculo frmSdVc = new FrmSaidaVeiculo(nomPort, (String) numPlaca, this);
            centralizarFormularioPorteiro(frmSdVc);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(FrmControleAcessoVeiculo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TbEntradasVeiculosMouseClicked

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        modEntVc.setCodEnt(codEnt);
        modEntVc.setPlacaVc(TfPlacaVeiculo.getText());
        control.ExcluirEntradaVeiculo(modEntVc);
        atualizarCampos();
        BtExcluir.setEnabled(false);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        numplaca = JOptionPane.showInputDialog(null, "Digite o número da placa");
        if (numplaca.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite a descrição do fornecedor desejado.");
        } else {
            preencherTabelaEntradaVeiculo();
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void BtConsultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultar1ActionPerformed

        atualizarTabelaEntradaVeiculoTodos();
    }//GEN-LAST:event_BtConsultar1ActionPerformed

    private void TempoDataHoraEntradaOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TempoDataHoraEntradaOnTime

        try {
            dataEntradaVeiculo();
            horaEntradaVeiculo();

        } catch (ParseException ex) {
            Logger.getLogger(FrmControleAcessoVeiculo.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TempoDataHoraEntradaOnTime

    public void preencherTabelaEntradasVeiculos(String SQL) {

//        String placa;
//        int NumColuna = 1, codUnid;
//        Object numPlaca = "" + TbEntradasVeiculos.getValueAt(TbEntradasVeiculos.getSelectedRow(), NumColuna);
//        placa = numplaca;
//        if (placa.equals("")) {
//            JOptionPane.showMessageDialog(null, "Nenhum veículo entrou no condomínio!!");
//        } else {
        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Proprietário", "Placa Veículo", "Modelo", "Marca", "Cor", "Data Entrada", "Hora Entrada"};
        conEntVc.conexao();
        conEntVc.executaSQL(SQL);
        try {
            conEntVc.rs.first();
            do {
                dados.add(new Object[]{conEntVc.rs.getString("nome_ps"), conEntVc.rs.getString("placa_vc"), conEntVc.rs.getString("desc_md"), conEntVc.rs.getString("desc_mc"), conEntVc.rs.getString("desc_cor"), conEntVc.rs.getString("Data_Ent_Vc"), conEntVc.rs.getString("Hora_Ent_Vc"),});
            } while (conEntVc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Esse veículo não se encontra no condomínio!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbEntradasVeiculos.setModel(modTabela);
        TbEntradasVeiculos.getColumnModel().getColumn(0).setPreferredWidth(169);
        TbEntradasVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(1).setPreferredWidth(90);
        TbEntradasVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(2).setPreferredWidth(100);
        TbEntradasVeiculos.getColumnModel().getColumn(2).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(3).setPreferredWidth(100);
        TbEntradasVeiculos.getColumnModel().getColumn(3).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(4).setPreferredWidth(80);
        TbEntradasVeiculos.getColumnModel().getColumn(4).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(5).setPreferredWidth(90);
        TbEntradasVeiculos.getColumnModel().getColumn(5).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(6).setPreferredWidth(90);
        TbEntradasVeiculos.getColumnModel().getColumn(6).setResizable(false);
        TbEntradasVeiculos.getTableHeader().setReorderingAllowed(false);
        TbEntradasVeiculos.setAutoResizeMode(TbEntradasVeiculos.AUTO_RESIZE_OFF);
        TbEntradasVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conEntVc.desconecta();
//        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtConsultar1;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JLabel LbDataEntradaVeiculo;
    private javax.swing.JLabel LbHoraEntradaVeiculo;
    private javax.swing.JLabel LbNomeUsuario;
    private javax.swing.JTable TbEntradasVeiculos;
    private org.netbeans.examples.lib.timerbean.Timer TempoDataHoraEntrada;
    private javax.swing.JTextField TfCorVeiculo;
    private javax.swing.JTextField TfDetalhesProprietario;
    private javax.swing.JTextField TfMarcaVeiculo;
    private javax.swing.JTextField TfModeloVeiculo;
    private javax.swing.JTextField TfNomeProprietario;
    private javax.swing.JTextArea TfObservacaoEntradaVeiculo;
    private javax.swing.JTextField TfPlacaVeiculo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel4;
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

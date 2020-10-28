package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleSaidasVeiculos;
import ControleSistema.ControleEntradasVeiculos;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloSaidasVeiculos;
import ModeloSistema.ModeloEntradasVeiculos;
import ModeloSistema.TratamentoCampos;
import javax.swing.JInternalFrame;

public class FrmSaidaVeiculo extends javax.swing.JInternalFrame {

    ConectaBanco conSaidVc = new ConectaBanco();
    ConectaBanco conEntVc = new ConectaBanco();
    ConectaBanco conVc = new ConectaBanco();
    ModeloSaidasVeiculos modSaidVc = new ModeloSaidasVeiculos();
    ModeloEntradasVeiculos modEntVc = new ModeloEntradasVeiculos();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleSaidasVeiculos control = new ControleSaidasVeiculos();
    ControleEntradasVeiculos controlEnt = new ControleEntradasVeiculos();
    String placaVc, numplaca;
    int codEnt, SaiuSim = 0;
    private final JInternalFrame parente;

    public FrmSaidaVeiculo(String nomePort, String numPlaca, JInternalFrame p) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        this.parente = p;
        numplaca = numPlaca;
        LbNomeUsuario.setText(nomePort);
        tempoDataHoraSaida.start();
        ConsultaEntradaVeiculo();
    }

    public void ConsultaEntradaVeiculo() {

        conEntVc.conexao();
        try {
            conEntVc.executaSQL(" select * from vw_entrada_veiculo where placa_vc ='" + numplaca + "'and entrou = 1");
            conEntVc.rs.first();
            codEnt = conEntVc.rs.getInt("cod_ent_vc");
            TfPlacaVeiculo.setText(conEntVc.rs.getString("Placa_Vc"));
            TfModeloVeiculo.setText(conEntVc.rs.getString("desc_md"));
            TfMarcaVeiculo.setText(conEntVc.rs.getString("desc_mc"));
            TfCorVeiculo.setText(conEntVc.rs.getString("desc_cor"));
            TfNomeProprietario.setText(conEntVc.rs.getString("nome_ps"));
            TfDetalhesProprietario.setText(conEntVc.rs.getString("detalhes_Prop"));
        } catch (SQLException ex) {
            Logger.getLogger(FrmSaidaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
        conEntVc.desconecta();
    }

    public void dataSaidaVeiculo() throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        LbDataSaidaVeiculo.setText(df.format(hoje));
    }

    public void horaSaidaVeiculo() throws ParseException {

        int h = LocalTime.now().getHour();
        int m = LocalTime.now().getMinute();
        int s = LocalTime.now().getSecond();
        SimpleDateFormat df = new SimpleDateFormat(h + ":" + m + ":" + s);
        Date hoje = new Date();
        LbHoraSaidaVeiculo.setText(df.format(hoje));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tempoDataHoraSaida = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
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
        LbDataSaidaVeiculo = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LbHoraSaidaVeiculo = new javax.swing.JLabel();
        LbNomeUsuario = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TfMarcaVeiculo = new javax.swing.JTextField();
        TfNomeProprietario = new javax.swing.JTextField();
        TfDetalhesProprietario = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BtSalvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TfObservacaoSaidaVeiculo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        tempoDataHoraSaida.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                tempoDataHoraSaidaOnTime(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastros de Saídas de Veículos");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
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

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Data Saída");

        LbDataSaidaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbDataSaidaVeiculo.setForeground(new java.awt.Color(51, 51, 255));
        LbDataSaidaVeiculo.setText("Data");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora Saída");

        LbHoraSaidaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbHoraSaidaVeiculo.setForeground(new java.awt.Color(51, 51, 255));
        LbHoraSaidaVeiculo.setText("Hora");

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
                    .addComponent(LbDataSaidaVeiculo))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(LbHoraSaidaVeiculo))
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
                            .addComponent(LbDataSaidaVeiculo)
                            .addComponent(LbHoraSaidaVeiculo))))
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

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Observação Entrada Veículo");

        TfObservacaoSaidaVeiculo.setColumns(20);
        TfObservacaoSaidaVeiculo.setRows(5);
        TfObservacaoSaidaVeiculo.setToolTipText("Observações do visitante");
        jScrollPane2.setViewportView(TfObservacaoSaidaVeiculo);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(173, 173, 173)
                                .addComponent(jLabel16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TfNomeProprietario, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TfDetalhesProprietario))
                            .addComponent(jLabel17)
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                    .addComponent(TfCorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel18)
                            .addComponent(jLabel21))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TfPlacaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TfModeloVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TfCorVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(TfMarcaVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Saída dos Veículos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 780, 412);
    }// </editor-fold>//GEN-END:initComponents

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    public void AlterarEntradaVeiculo() {

        conEntVc.conexao();
        try {
            PreparedStatement pstEstoque = (PreparedStatement) conEntVc.conn.prepareStatement("update tab_entradas_veiculos set Entrou=? where cod_ent_vc=?");
            pstEstoque.setInt(1, SaiuSim);
            pstEstoque.setInt(2, codEnt);
            pstEstoque.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de entradas de veículos!!\n Erro: " + ex);
        }
        conEntVc.desconecta();
    }

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfObservacaoSaidaVeiculo.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite alguma observação!!");
            TfObservacaoSaidaVeiculo.requestFocus();
        } else {
            modSaidVc.setDataSaid(LbDataSaidaVeiculo.getText());
            modSaidVc.setHoraSaid(LbHoraSaidaVeiculo.getText());
            modSaidVc.setObsSaid(TfObservacaoSaidaVeiculo.getText());
            modSaidVc.setNomePort(LbNomeUsuario.getText());//Nome do porteiro
            modSaidVc.setPlacaVc(TfPlacaVeiculo.getText());
            control.InserirSaidaVeiculo(modSaidVc);
            AlterarEntradaVeiculo();
            JOptionPane.showMessageDialog(rootPane, "O veículo de placa com número : " + modSaidVc.getPlacaVc() + " foi liberado a sair do condomínio com sucesso!!");
            FrmControleAcessoVeiculo frmEntradaVeiculo = (FrmControleAcessoVeiculo) parente;
            frmEntradaVeiculo.atualizarTabelaEntradaVeiculoTodos();
        }
        dispose();
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void tempoDataHoraSaidaOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempoDataHoraSaidaOnTime

        try {
            dataSaidaVeiculo();
            horaSaidaVeiculo();
        } catch (ParseException ex) {
            Logger.getLogger(FrmSaidaVeiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tempoDataHoraSaidaOnTime

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JLabel LbDataSaidaVeiculo;
    private javax.swing.JLabel LbHoraSaidaVeiculo;
    private javax.swing.JLabel LbNomeUsuario;
    private javax.swing.JTextField TfCorVeiculo;
    private javax.swing.JTextField TfDetalhesProprietario;
    private javax.swing.JTextField TfMarcaVeiculo;
    private javax.swing.JTextField TfModeloVeiculo;
    private javax.swing.JTextField TfNomeProprietario;
    private javax.swing.JTextArea TfObservacaoSaidaVeiculo;
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
    private javax.swing.JScrollPane jScrollPane2;
    private org.netbeans.examples.lib.timerbean.Timer tempoDataHoraSaida;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

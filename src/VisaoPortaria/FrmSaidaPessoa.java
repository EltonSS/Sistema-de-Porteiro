package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleSaidasPessoas;
import ControleSistema.ControleEntradasPessoas;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloSaidasPessoas;
import ModeloSistema.ModeloEntradasPessoas;
import ModeloSistema.TratamentoCampos;
import javax.swing.JInternalFrame;

public class FrmSaidaPessoa extends javax.swing.JInternalFrame {

    ConectaBanco conSaidVc = new ConectaBanco();
    ConectaBanco conEntPs = new ConectaBanco();
    ConectaBanco conVc = new ConectaBanco();
    ModeloSaidasPessoas modSaidPs = new ModeloSaidasPessoas();
    ModeloEntradasPessoas modEntVc = new ModeloEntradasPessoas();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleSaidasPessoas control = new ControleSaidasPessoas();
    ControleEntradasPessoas controlEnt = new ControleEntradasPessoas();
    String placaVc, nomePs;
    int codEnt, SaiuSim = 0;
    private final JInternalFrame parente;

    public FrmSaidaPessoa(String nomePort, String nomePessoa, JInternalFrame p) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        this.parente = p;
        nomePs = nomePessoa;
        LbNomeUsuario.setText(nomePort);
        tempoDataHoraSaida.start();
        ConsultaEntradaPessoa();
    }

    FrmSaidaPessoa(String nomPort, int codSaidChv, FrmControleSaidaChaves aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ConsultaEntradaPessoa() {

        conEntPs.conexao();
        try {
            conEntPs.executaSQL(" select * from vw_entrada_pessoa where nome_ps ='" + nomePs + "'and entrou = 1");
            conEntPs.rs.first();
            codEnt = conEntPs.rs.getInt("cod_ent_ps");
            TfNomePessoa.setText(conEntPs.rs.getString("nome_ps"));
            TfDetalhesPessoa.setText(conEntPs.rs.getString("desc_tp_ps"));
        } catch (SQLException ex) {
            Logger.getLogger(FrmSaidaPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
        conEntPs.desconecta();
    }

    public void dataSaidaPessoa() throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        LbDataSaidaPessoa.setText(df.format(hoje));
    }

    public void horaSaidaPessoa() throws ParseException {

        int h = LocalTime.now().getHour();
        int m = LocalTime.now().getMinute();
        int s = LocalTime.now().getSecond();
        SimpleDateFormat df = new SimpleDateFormat(h + ":" + m + ":" + s);
        Date hoje = new Date();
        LbHoraSaidaPessoa.setText(df.format(hoje));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tempoDataHoraSaida = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        BtCancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LbDataSaidaPessoa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LbHoraSaidaPessoa = new javax.swing.JLabel();
        LbNomeUsuario = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TfNomePessoa = new javax.swing.JTextField();
        TfDetalhesPessoa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BtSalvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TfObservacaoSaidaPessoa = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        tempoDataHoraSaida.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                tempoDataHoraSaidaOnTime(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastros de Saídas de Pessoas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nome Pessoa");

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Data Saída");

        LbDataSaidaPessoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbDataSaidaPessoa.setForeground(new java.awt.Color(51, 51, 255));
        LbDataSaidaPessoa.setText("Data");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora Saída");

        LbHoraSaidaPessoa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbHoraSaidaPessoa.setForeground(new java.awt.Color(51, 51, 255));
        LbHoraSaidaPessoa.setText("Hora");

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
                    .addComponent(LbDataSaidaPessoa))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(LbHoraSaidaPessoa))
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
                            .addComponent(LbDataSaidaPessoa)
                            .addComponent(LbHoraSaidaPessoa))))
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

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Observação Entrada Pessoa");

        TfObservacaoSaidaPessoa.setColumns(20);
        TfObservacaoSaidaPessoa.setRows(5);
        TfObservacaoSaidaPessoa.setToolTipText("Observações do visitante");
        jScrollPane2.setViewportView(TfObservacaoSaidaPessoa);

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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(TfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(TfDetalhesPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TfDetalhesPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Saída dos Pessoas");

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

        setBounds(0, 0, 780, 356);
    }// </editor-fold>//GEN-END:initComponents

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    public void AlterarEntradaPessoa() {

        conEntPs.conexao();
        try {
            PreparedStatement pstPessoa = (PreparedStatement) conEntPs.conn.prepareStatement("update tab_entradas_Pessoas set Entrou=? where cod_ent_ps=?");
            pstPessoa.setInt(1, SaiuSim);
            pstPessoa.setInt(2, codEnt);
            pstPessoa.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de entradas de veículos!!\n Erro: " + ex);
        }
        conEntPs.desconecta();
    }

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfObservacaoSaidaPessoa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite alguma observação!!");
            TfObservacaoSaidaPessoa.requestFocus();
        } else {
            modSaidPs.setDataSaid(LbDataSaidaPessoa.getText());
            modSaidPs.setHoraSaid(LbHoraSaidaPessoa.getText());
            modSaidPs.setObsSaid(TfObservacaoSaidaPessoa.getText());
            modSaidPs.setNomePort(LbNomeUsuario.getText());//Nome do porteiro
            modSaidPs.setNomePs(TfNomePessoa.getText());
            modSaidPs.setDetalhesPs(TfDetalhesPessoa.getText());
            control.InserirSaidaPessoa(modSaidPs);
            AlterarEntradaPessoa();
            JOptionPane.showMessageDialog(rootPane, "A pessoa : " + modSaidPs.getNomePs()+ " foi liberada a sair do condomínio com sucesso!!");
            FrmControleAcessoPessoa frmSaidPessoa = (FrmControleAcessoPessoa) parente;
            frmSaidPessoa.atualizarTabelaEntradaTodasPessoas();
        }
        dispose();
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void tempoDataHoraSaidaOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempoDataHoraSaidaOnTime

        try {
            dataSaidaPessoa();
            horaSaidaPessoa();
        } catch (ParseException ex) {
            Logger.getLogger(FrmSaidaPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tempoDataHoraSaidaOnTime

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JLabel LbDataSaidaPessoa;
    private javax.swing.JLabel LbHoraSaidaPessoa;
    private javax.swing.JLabel LbNomeUsuario;
    private javax.swing.JTextField TfDetalhesPessoa;
    private javax.swing.JTextField TfNomePessoa;
    private javax.swing.JTextArea TfObservacaoSaidaPessoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private org.netbeans.examples.lib.timerbean.Timer tempoDataHoraSaida;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

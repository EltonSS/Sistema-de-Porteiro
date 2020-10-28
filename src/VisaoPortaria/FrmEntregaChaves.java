package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleEntregaChaves;
import com.mysql.jdbc.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ModeloSistema.ModeloEntregaChaves;
import ModeloSistema.TratamentoCampos;
import javax.swing.JInternalFrame;

public class FrmEntregaChaves extends javax.swing.JInternalFrame {

    ConectaBanco conEntChv = new ConectaBanco();
    ConectaBanco conSaidChv = new ConectaBanco();
    ConectaBanco conChv = new ConectaBanco();
    ModeloEntregaChaves modEntChv = new ModeloEntregaChaves();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleEntregaChaves control = new ControleEntregaChaves();
    String codSaidChave, descChave;
    int codEnt, Saiu = 0,codPs, codPort, codChv, codSet;
    private final JInternalFrame parente;

    public FrmEntregaChaves(String nomePort, String codSaidChv, JInternalFrame p) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        this.parente = p;
        codSaidChave = codSaidChv;
        LbNomeUsuario.setText(nomePort);
        tempoDataHoraEntregaChave.start();
        ConsultaSaidaChave();
    }

    public void ConsultaSaidaChave() {

        conSaidChv.conexao();
        try {
            conSaidChv.executaSQL(" select * from vw_saida_chave where cod_said_chv ='" + codSaidChave + "'and saiu = 1");
            conSaidChv.rs.first();
            TfNomePessoa.setText(conSaidChv.rs.getString("nome_ps"));
            TfDetalhesPessoa.setText(conSaidChv.rs.getString("detalhes_Ps"));
            TfDescricaoChaves.setText(conSaidChv.rs.getString("desc_chv"));
            TfDescricaoSetor.setText(conSaidChv.rs.getString("desc_set"));
            codPs = conSaidChv.rs.getInt("cod_ps");
            codPort = conSaidChv.rs.getInt("cod_port");
            codChv = conSaidChv.rs.getInt("cod_chv");
            codSet = conSaidChv.rs.getInt("cod_set");
            descChave = conSaidChv.rs.getString("desc_chv");
        } catch (SQLException ex) {
            Logger.getLogger(FrmEntregaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
        conSaidChv.desconecta();
    }

    public void dataEntregaChaves() throws ParseException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        LbDataEntregaChave.setText(df.format(hoje));
    }

    public void horaEntregaChave() throws ParseException {

        int h = LocalTime.now().getHour();
        int m = LocalTime.now().getMinute();
        int s = LocalTime.now().getSecond();
        SimpleDateFormat df = new SimpleDateFormat(h + ":" + m + ":" + s);
        Date hoje = new Date();
        LbHoraEntregaChave.setText(df.format(hoje));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tempoDataHoraEntregaChave = new org.netbeans.examples.lib.timerbean.Timer();
        jPanel1 = new javax.swing.JPanel();
        BtCancelar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        LbDataEntregaChave = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        LbHoraEntregaChave = new javax.swing.JLabel();
        LbNomeUsuario = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        TfNomePessoa = new javax.swing.JTextField();
        TfDetalhesPessoa = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        BtSalvar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TfObservacaoSaidaPessoa = new javax.swing.JTextArea();
        TfDescricaoChaves = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        TfDescricaoSetor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        tempoDataHoraEntregaChave.addTimerListener(new org.netbeans.examples.lib.timerbean.TimerListener() {
            public void onTime(java.awt.event.ActionEvent evt) {
                tempoDataHoraEntregaChaveOnTime(evt);
            }
        });

        setClosable(true);
        setIconifiable(true);
        setTitle("Entrega da Chave");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Nome Solicitante Responsável");

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Data Entrega");

        LbDataEntregaChave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbDataEntregaChave.setForeground(new java.awt.Color(51, 51, 255));
        LbDataEntregaChave.setText("Data");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora Entrega");

        LbHoraEntregaChave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LbHoraEntregaChave.setForeground(new java.awt.Color(51, 51, 255));
        LbHoraEntregaChave.setText("Hora");

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
                    .addComponent(LbDataEntregaChave))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(LbHoraEntregaChave))
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
                            .addComponent(LbDataEntregaChave)
                            .addComponent(LbHoraEntregaChave))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        TfNomePessoa.setToolTipText("Nome do solicitante responsável");
        TfNomePessoa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNomePessoa.setEnabled(false);

        TfDetalhesPessoa.setToolTipText("Detalhes do solicitante responsável");
        TfDetalhesPessoa.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfDetalhesPessoa.setEnabled(false);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Detalhes Solicitante Responsável");

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
        TfObservacaoSaidaPessoa.setToolTipText("Observações da entrega da chave");
        jScrollPane2.setViewportView(TfObservacaoSaidaPessoa);

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
                            .addComponent(TfNomePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel16)
                            .addComponent(TfDetalhesPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(367, 367, 367))
                    .addComponent(jScrollPane2))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(TfDescricaoChaves, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(TfDescricaoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(6, 6, 6)
                        .addComponent(TfDescricaoChaves, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(TfDescricaoSetor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Entrega Chave");

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 780, 402);
    }// </editor-fold>//GEN-END:initComponents

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    public void AtualizaTabChaves() {

        conChv.conexao();
        try {
            PreparedStatement pstChave = (PreparedStatement) conChv.conn.prepareStatement("update tab_chaves set saiu=? where cod_chv=?");
            pstChave.setInt(1, Saiu);
            pstChave.setInt(2, codChv);
            pstChave.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de chaves!!\n Erro: " + ex);
        }
        conChv.desconecta();
    }

    public void AtualizaTabSaidaChaves() {

        conSaidChv.conexao();
        try {
            PreparedStatement pstSaidChave = (PreparedStatement) conSaidChv.conn.prepareStatement("update tab_saida_chaves set saiu=? where cod_said_chv=?");
            pstSaidChave.setInt(1, Saiu);
            pstSaidChave.setInt(2, codChv);
            pstSaidChave.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar alterar o status entrou na tabela de saida de chaves!!\n Erro: " + ex);
        }
        conSaidChv.desconecta();
    }

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if (TfObservacaoSaidaPessoa.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite alguma observação!!");
            TfObservacaoSaidaPessoa.requestFocus();
        } else {
            modEntChv.setDataEntChv(LbDataEntregaChave.getText());
            modEntChv.setHoraEntChv(LbHoraEntregaChave.getText());
            modEntChv.setObsEntregaChave(TfObservacaoSaidaPessoa.getText());
            modEntChv.setDetalhesPs(TfDetalhesPessoa.getText());
            modEntChv.setCodPort(codPort);
            modEntChv.setCodPs(codPs);
            modEntChv.setCodSetor(codSet);
            modEntChv.setCodChv(codChv);
            control.InserirEntregaChaves(modEntChv);
            AtualizaTabChaves();
            //AtualizaTabSaidaChaves();
            JOptionPane.showMessageDialog(rootPane, "A chave : " + descChave + " foi entregue ao condomínio com sucesso!!");
            FrmControleSaidaChaves frmSaidChv = (FrmControleSaidaChaves) parente;
            frmSaidChv.AtualizaTabSaidaChaves();
            frmSaidChv.atualizarTabelaSaidaChave();
        }
        dispose();
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void tempoDataHoraEntregaChaveOnTime(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tempoDataHoraEntregaChaveOnTime

        try {
            dataEntregaChaves();
            horaEntregaChave();
        } catch (ParseException ex) {
            Logger.getLogger(FrmEntregaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tempoDataHoraEntregaChaveOnTime

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JLabel LbDataEntregaChave;
    private javax.swing.JLabel LbHoraEntregaChave;
    private javax.swing.JLabel LbNomeUsuario;
    private javax.swing.JTextField TfDescricaoChaves;
    private javax.swing.JTextField TfDescricaoSetor;
    private javax.swing.JTextField TfDetalhesPessoa;
    private javax.swing.JTextField TfNomePessoa;
    private javax.swing.JTextArea TfObservacaoSaidaPessoa;
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
    private javax.swing.JScrollPane jScrollPane2;
    private org.netbeans.examples.lib.timerbean.Timer tempoDataHoraEntregaChave;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

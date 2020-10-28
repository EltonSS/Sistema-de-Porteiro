package VisaoPortaria;

import ControleSistema.ConectaBanco;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import VisaoTelaPrincipal.TelaPrincipal;
import ControleSistema.Funcoes;

public class FrmConsultasEntradaSaidaChaves extends javax.swing.JInternalFrame {

    ConectaBanco conSaidChv = new ConectaBanco();
    ConectaBanco conEntChv = new ConectaBanco();
    Funcoes abrirTela = new Funcoes();
    String descChv, descSetor, descTpPs, Rg;
    private String data_ini, data_fin;

    public FrmConsultasEntradaSaidaChaves() throws SQLException {

        initComponents();
    }

    public void atualizarTabelaTodasSaidasChaves() {

        preencherTabelaSaidaChaves("select * from vw_saida_chave order by data_said_chv desc");
    }

    public void atualizarTabelaSaidaDescricaoChave() {

        preencherTabelaSaidaChaves("select * from vw_saida_chave where desc_chv like '%" + descChv + "%'order by data_said_chv desc");
    }

    public void atualizarTabelaSaidaSetorChave() {

        preencherTabelaSaidaChaves("select * from vw_saida_chave where desc_set like '%" + descSetor + "%'order by data_said_chv desc");
    }

    public void atualizarTabelaSaidaDataChave() {

        preencherTabelaSaidaChaves("select * from vw_saida_chave where data_ent_chv between '" + data_ini + "' and '" + data_fin + "' order by data_said_chv desc");
    }

    public void atualizarTabelaEntregaTodasChaves() {

        preencherTabelaEntregaChave("select * from vw_entrega_chave order by data_ent_chv desc");
    }

    public void atualizarTabelaEntregaDescricaoChave() {
    
        preencherTabelaEntregaChave("select * from vw_entrega_chave where desc_chv like '%" + descChv + "%'order by data_ent_chv desc");
    }

    public void atualizarTabelaEntregaSetorChave() {

        preencherTabelaEntregaChave("select * from vw_entrega_chave where desc_set like '%" + descSetor + "%'order by data_ent_chv desc");
    }

    public void atualizarTabelaEntregaChaveData() {

        preencherTabelaEntregaChave("select * from vw_entrega_chave where data_ent_chv between '" + data_ini + "' and '" + data_fin + "' order by data_ent_chv desc");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RdGroupTiposConsultas = new javax.swing.ButtonGroup();
        RdGroupTiposConsultas2 = new javax.swing.ButtonGroup();
        RdGroupTiposConsultasMoradores = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        AbasConsultas = new javax.swing.JTabbedPane();
        AbaEntradaPessoas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jRdDescricaoChave = new javax.swing.JRadioButton();
        jRdTodasEntradas = new javax.swing.JRadioButton();
        jRdSetorChave = new javax.swing.JRadioButton();
        jRdDataSaida = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbSaidaChaves = new javax.swing.JTable();
        AbaSaidasPessoas = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jRdDescricaoChave2 = new javax.swing.JRadioButton();
        jRdTodasEntregas = new javax.swing.JRadioButton();
        jRdSetorChave2 = new javax.swing.JRadioButton();
        jRdDataEntrega = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbEntregaChaves = new javax.swing.JTable();
        BtCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Entradas e Saídas de Chaves");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Consultar Entradas e Saídas de Chaves");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultas.add(jRdDescricaoChave);
        jRdDescricaoChave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDescricaoChave.setText("Saída p/ Descrição Chave");
        jRdDescricaoChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDescricaoChaveActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdTodasEntradas);
        jRdTodasEntradas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdTodasEntradas.setText("Todas Entradas");
        jRdTodasEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdTodasEntradasActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdSetorChave);
        jRdSetorChave.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdSetorChave.setText("Saída p/ Setor Chave");
        jRdSetorChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdSetorChaveActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdDataSaida);
        jRdDataSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDataSaida.setText("Saída Chave p/ Data");
        jRdDataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDataSaidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRdDescricaoChave)
                    .addComponent(jRdSetorChave)
                    .addComponent(jRdDataSaida)
                    .addComponent(jRdTodasEntradas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRdTodasEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDescricaoChave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdSetorChave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDataSaida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Entradas das Chaves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbSaidaChaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbSaidaChaves.setToolTipText(" Lista das entradas dos veículos");
        TbSaidaChaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbSaidaChavesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbSaidaChaves);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AbaEntradaPessoasLayout = new javax.swing.GroupLayout(AbaEntradaPessoas);
        AbaEntradaPessoas.setLayout(AbaEntradaPessoasLayout);
        AbaEntradaPessoasLayout.setHorizontalGroup(
            AbaEntradaPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaEntradaPessoasLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AbaEntradaPessoasLayout.setVerticalGroup(
            AbaEntradaPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaEntradaPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbaEntradaPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        AbasConsultas.addTab("Saídas de Chaves", AbaEntradaPessoas);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultas.add(jRdDescricaoChave2);
        jRdDescricaoChave2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDescricaoChave2.setText("Entrega p/ Descrição Chave");
        jRdDescricaoChave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDescricaoChave2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdTodasEntregas);
        jRdTodasEntregas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdTodasEntregas.setText("Todas Entregas");
        jRdTodasEntregas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdTodasEntregasActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdSetorChave2);
        jRdSetorChave2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdSetorChave2.setText("Entrega p/Setor Chave");
        jRdSetorChave2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdSetorChave2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdDataEntrega);
        jRdDataEntrega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDataEntrega.setText("Entrega Chave p/ Data");
        jRdDataEntrega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDataEntregaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRdDescricaoChave2)
                    .addComponent(jRdSetorChave2)
                    .addComponent(jRdTodasEntregas)
                    .addComponent(jRdDataEntrega))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRdTodasEntregas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDescricaoChave2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdSetorChave2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDataEntrega)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Saídas das Chaves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbEntregaChaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbEntregaChaves.setToolTipText(" Lista das saídas dos veículos");
        TbEntregaChaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbEntregaChavesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbEntregaChaves);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 914, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AbaSaidasPessoasLayout = new javax.swing.GroupLayout(AbaSaidasPessoas);
        AbaSaidasPessoas.setLayout(AbaSaidasPessoasLayout);
        AbaSaidasPessoasLayout.setHorizontalGroup(
            AbaSaidasPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaSaidasPessoasLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AbaSaidasPessoasLayout.setVerticalGroup(
            AbaSaidasPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AbaSaidasPessoasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbaSaidasPessoasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AbasConsultas.addTab("Entrega de Chaves", AbaSaidasPessoas);

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AbasConsultas)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AbasConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        setBounds(0, 0, 1196, 591);
    }// </editor-fold>//GEN-END:initComponents

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void TbSaidaChavesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbSaidaChavesMouseClicked

        String descChave = "" + TbSaidaChaves.getValueAt(TbSaidaChaves.getSelectedRow(), 2);
        String setor = "" + TbSaidaChaves.getValueAt(TbSaidaChaves.getSelectedRow(), 3);
        try {
            try {
                FrmDetalhesChave frmChv = new FrmDetalhesChave(descChave, setor);
                abrirTela.centralizarFormularioConsultas(frmChv);
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultasEntradaSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TbSaidaChavesMouseClicked

    private void jRdDataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDataSaidaActionPerformed

        try {
            FrmConsultaDataEntrada frmConsultaData = new FrmConsultaDataEntrada(this);
            TelaPrincipal.areaTrabalhoCadastros.add(frmConsultaData);
            frmConsultaData.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRdDataSaidaActionPerformed

    private void jRdSetorChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdSetorChaveActionPerformed

        descSetor = JOptionPane.showInputDialog(null, "Digite o setor da chave :");
        if (descSetor.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a descrição do setor para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaSetorChave();
        }
    }//GEN-LAST:event_jRdSetorChaveActionPerformed

    private void jRdTodasEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTodasEntradasActionPerformed

        atualizarTabelaTodasSaidasChaves();
    }//GEN-LAST:event_jRdTodasEntradasActionPerformed

    private void jRdDescricaoChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDescricaoChaveActionPerformed

        descChv = JOptionPane.showInputDialog(null, "Digite a descrição da chave :");
        if (descChv.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a descrição da chave para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaDescricaoChave();
        }
    }//GEN-LAST:event_jRdDescricaoChaveActionPerformed

    private void jRdDescricaoChave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDescricaoChave2ActionPerformed

        descChv = JOptionPane.showInputDialog(null, "Digite a descrição da chave :");
        if (descChv.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o rg da pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaEntregaDescricaoChave();
        }
    }//GEN-LAST:event_jRdDescricaoChave2ActionPerformed

    private void jRdTodasEntregasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTodasEntregasActionPerformed

        atualizarTabelaEntregaTodasChaves();
    }//GEN-LAST:event_jRdTodasEntregasActionPerformed

    private void jRdSetorChave2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdSetorChave2ActionPerformed

        descSetor = JOptionPane.showInputDialog(null, "Digite a descrição do setor :");
        if (descSetor.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite nome da pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaEntregaSetorChave();
        }
    }//GEN-LAST:event_jRdSetorChave2ActionPerformed

    private void jRdDataEntregaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDataEntregaActionPerformed

        try {
            FrmConsultaDataSaida frmConsultaData = new FrmConsultaDataSaida(this);
            TelaPrincipal.areaTrabalhoCadastros.add(frmConsultaData);
            frmConsultaData.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRdDataEntregaActionPerformed

    private void TbEntregaChavesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbEntregaChavesMouseClicked

        String descChave = "" + TbEntregaChaves.getValueAt(TbEntregaChaves.getSelectedRow(), 2);
        String setor = "" + TbEntregaChaves.getValueAt(TbEntregaChaves.getSelectedRow(), 3);
        try {
            try {
                FrmDetalhesChave frmChv = new FrmDetalhesChave(descChave, setor);
                abrirTela.centralizarFormularioConsultas(frmChv);
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultasEntradaSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaChaves.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TbEntregaChavesMouseClicked

    public void preencherTabelaSaidaChaves(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Saída", "Hora Saída", "Descrição Chave", "Setor", "Solicitante", "Detalhes Solicitante"};
        conSaidChv.conexao();
        conSaidChv.executaSQL(SQL);
        try {
            conSaidChv.rs.first();
            do {
                dados.add(new Object[]{conSaidChv.rs.getString("Data_Said_Chv"), conSaidChv.rs.getString("Hora_Said_Chv"), conSaidChv.rs.getString("Desc_Chv"), conSaidChv.rs.getString("Desc_Set"),
                    conSaidChv.rs.getString("Nome_Ps"), conSaidChv.rs.getString("Detalhes_Ps")});
            } while (conSaidChv.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma saida com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbSaidaChaves.setModel(modTabela);
        TbSaidaChaves.getColumnModel().getColumn(0).setPreferredWidth(91);
        TbSaidaChaves.getColumnModel().getColumn(0).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(1).setPreferredWidth(91);
        TbSaidaChaves.getColumnModel().getColumn(1).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(2).setPreferredWidth(160);
        TbSaidaChaves.getColumnModel().getColumn(2).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(3).setPreferredWidth(120);
        TbSaidaChaves.getColumnModel().getColumn(3).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(4).setPreferredWidth(150);
        TbSaidaChaves.getColumnModel().getColumn(4).setResizable(false);
        TbSaidaChaves.getColumnModel().getColumn(5).setPreferredWidth(304);
        TbSaidaChaves.getColumnModel().getColumn(5).setResizable(false);
        TbSaidaChaves.getTableHeader().setReorderingAllowed(false);
        TbSaidaChaves.setAutoResizeMode(TbSaidaChaves.AUTO_RESIZE_OFF);
        TbSaidaChaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conSaidChv.desconecta();
    }

    public void preencherTabelaEntregaChave(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Entrega", "Hora Entrega", "Descrição Chave", "Setor", "Solicitante", "Detalhes Solicitante"};
        conEntChv.conexao();
        conEntChv.executaSQL(SQL);
        try {
            conEntChv.rs.first();
            do {
                dados.add(new Object[]{conEntChv.rs.getString("Data_Ent_Chv"), conEntChv.rs.getString("Hora_Ent_Ps"), conEntChv.rs.getString("Desc_Chv"), conEntChv.rs.getString("Desc_Set"),
                    conEntChv.rs.getString("Nome_Ps"), conEntChv.rs.getString("Detalhes_Ps")});
            } while (conEntChv.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma entrega com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbEntregaChaves.setModel(modTabela);
        TbEntregaChaves.getColumnModel().getColumn(0).setPreferredWidth(91);
        TbEntregaChaves.getColumnModel().getColumn(0).setResizable(false);
        TbEntregaChaves.getColumnModel().getColumn(1).setPreferredWidth(91);
        TbEntregaChaves.getColumnModel().getColumn(1).setResizable(false);
        TbEntregaChaves.getColumnModel().getColumn(2).setPreferredWidth(160);
        TbEntregaChaves.getColumnModel().getColumn(2).setResizable(false);
        TbEntregaChaves.getColumnModel().getColumn(3).setPreferredWidth(120);
        TbEntregaChaves.getColumnModel().getColumn(3).setResizable(false);
        TbEntregaChaves.getColumnModel().getColumn(4).setPreferredWidth(150);
        TbEntregaChaves.getColumnModel().getColumn(4).setResizable(false);
        TbEntregaChaves.getColumnModel().getColumn(5).setPreferredWidth(299);
        TbEntregaChaves.getColumnModel().getColumn(5).setResizable(false);
        TbEntregaChaves.getTableHeader().setReorderingAllowed(false);
        TbEntregaChaves.setAutoResizeMode(TbEntregaChaves.AUTO_RESIZE_OFF);
        TbEntregaChaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conEntChv.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbaEntradaPessoas;
    private javax.swing.JPanel AbaSaidasPessoas;
    private javax.swing.JTabbedPane AbasConsultas;
    private javax.swing.JButton BtCancelar;
    private javax.swing.ButtonGroup RdGroupTiposConsultas;
    private javax.swing.ButtonGroup RdGroupTiposConsultas2;
    private javax.swing.ButtonGroup RdGroupTiposConsultasMoradores;
    private javax.swing.JTable TbEntregaChaves;
    private javax.swing.JTable TbSaidaChaves;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRdDataEntrega;
    private javax.swing.JRadioButton jRdDataSaida;
    private javax.swing.JRadioButton jRdDescricaoChave;
    private javax.swing.JRadioButton jRdDescricaoChave2;
    private javax.swing.JRadioButton jRdSetorChave;
    private javax.swing.JRadioButton jRdSetorChave2;
    private javax.swing.JRadioButton jRdTodasEntradas;
    private javax.swing.JRadioButton jRdTodasEntregas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    public void setData_fin(String data_fin) {
        this.data_fin = data_fin;
    }

    public void setNomePs(String descSetor) {
        this.descSetor = descSetor;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

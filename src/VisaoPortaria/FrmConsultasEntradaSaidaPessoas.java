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
import ControleSistema.Funcoes;

public class FrmConsultasEntradaSaidaPessoas extends javax.swing.JInternalFrame {

    ConectaBanco conEntPs = new ConectaBanco();
    ConectaBanco conSaidPs = new ConectaBanco();
    Funcoes abrirTela = new Funcoes();
    Funcoes consultar = new Funcoes();
    String RgPs, nomePs, descTpPs, Rg;
    private String data_ini, data_fin;

    public FrmConsultasEntradaSaidaPessoas() throws SQLException {

        initComponents();
    }

    public void atualizarTabelaEntradaTodasEntradas() {

        preencherTabelaEntradaPessoa("select * from vw_entrada_pessoa order by data_ent_ps desc");
    }

    public void atualizarTabelaEntradaRgPessoa() {

        preencherTabelaEntradaPessoa("select * from vw_entrada_pessoa where rg_ps like '%" + RgPs + "%'order by data_ent_ps desc");
    }

    public void atualizarTabelaEntradaNomePessoa() {

        preencherTabelaEntradaPessoa("select * from vw_entrada_pessoa where nome_ps like '%" + nomePs + "%'order by data_ent_ps desc");
    }

    public void atualizarTabelaEntradaTipoPessoa() {

        preencherTabelaEntradaPessoa("select * from vw_entrada_pessoa where desc_tp_ps like '%" + descTpPs + "%'order by data_ent_ps desc");
    }

    public void atualizarTabelaEntradaPessoaData() {

        preencherTabelaEntradaPessoa("select * from vw_entrada_pessoa where data_ent_ps between '" + data_ini + "' and '" + data_fin + "' order by data_ent_ps desc");
    }

    public void atualizarTabelaTodasSaidas() {

        preencherTabelaSaidaPessoa("select * from vw_saida_pessoa order by data_said_ps desc");
    }

    public void atualizarTabelaSaidaRgPessoa() {

        preencherTabelaSaidaPessoa("select * from vw_saida_pessoa where rg_ps like '%" + RgPs + "%'order by data_said_ps desc");
    }

    public void atualizarTabelaSaidaNomePessoa() {

        preencherTabelaSaidaPessoa("select * from vw_saida_pessoa where nome_ps like '%" + nomePs + "%'order by data_said_ps desc");
    }

    public void atualizarTabelaSaidaTipoPessoa() {

        preencherTabelaSaidaPessoa("select * from vw_saida_pessoa where desc_tp_ps like '%" + descTpPs + "%'order by data_said_ps desc");
    }

    public void atualizarTabelaSaidaPessoaData() {

        preencherTabelaSaidaPessoa("select * from vw_saida_pessoa where data_said_ps between '" + data_ini + "' and '" + data_fin + "' order by data_said_ps desc");
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
        jRdRgPessoa = new javax.swing.JRadioButton();
        jRdTodasEntradas = new javax.swing.JRadioButton();
        jRdNomePessoa = new javax.swing.JRadioButton();
        jRdTipoPessoa = new javax.swing.JRadioButton();
        jRdDataEntrada = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbEntradasPessoas = new javax.swing.JTable();
        AbaSaidasPessoas = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jRdRgPessoa2 = new javax.swing.JRadioButton();
        jRdTodasSaidas = new javax.swing.JRadioButton();
        jRdNomePessoa2 = new javax.swing.JRadioButton();
        jRdTipoPessoa2 = new javax.swing.JRadioButton();
        jRdDataSaida = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbSaidasPessoas = new javax.swing.JTable();
        BtCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Entradas e Saídas de Pessoas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Consultar Entradas e Saídas de Pessoas");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultas.add(jRdRgPessoa);
        jRdRgPessoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdRgPessoa.setText("Entrada p/ Rg Pessoa");
        jRdRgPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdRgPessoaActionPerformed(evt);
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

        RdGroupTiposConsultas.add(jRdNomePessoa);
        jRdNomePessoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomePessoa.setText("Entrada p/ Nome Pessoa");
        jRdNomePessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomePessoaActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdTipoPessoa);
        jRdTipoPessoa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdTipoPessoa.setText("Entrada p/ Tipo Pessoa");
        jRdTipoPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdTipoPessoaActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdDataEntrada);
        jRdDataEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDataEntrada.setText("Entrada Pessoa p/ Data");
        jRdDataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDataEntradaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRdRgPessoa)
                    .addComponent(jRdNomePessoa)
                    .addComponent(jRdTipoPessoa)
                    .addComponent(jRdDataEntrada)
                    .addComponent(jRdTodasEntradas))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRdTodasEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdRgPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomePessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdTipoPessoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDataEntrada)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Entradas das Pessoas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

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
        TbEntradasPessoas.setToolTipText(" Lista das entradas dos veículos");
        TbEntradasPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbEntradasPessoasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbEntradasPessoas);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
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

        AbasConsultas.addTab("Entradas dos Pessoas", AbaEntradaPessoas);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultas.add(jRdRgPessoa2);
        jRdRgPessoa2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdRgPessoa2.setText("Saída p/ Rg Pessoa");
        jRdRgPessoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdRgPessoa2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdTodasSaidas);
        jRdTodasSaidas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdTodasSaidas.setText("Todas Saídas");
        jRdTodasSaidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdTodasSaidasActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdNomePessoa2);
        jRdNomePessoa2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomePessoa2.setText("Saída p/ Nome Pessoa");
        jRdNomePessoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomePessoa2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdTipoPessoa2);
        jRdTipoPessoa2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdTipoPessoa2.setText("Saída p/ Tipo Pessoa");
        jRdTipoPessoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdTipoPessoa2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdDataSaida);
        jRdDataSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDataSaida.setText("Saída Pessoa p/ Data");
        jRdDataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDataSaidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRdRgPessoa2)
                    .addComponent(jRdNomePessoa2)
                    .addComponent(jRdTipoPessoa2)
                    .addComponent(jRdTodasSaidas)
                    .addComponent(jRdDataSaida))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRdTodasSaidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdRgPessoa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomePessoa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdTipoPessoa2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDataSaida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Saídas das Pessoas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbSaidasPessoas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbSaidasPessoas.setToolTipText(" Lista das saídas dos veículos");
        TbSaidasPessoas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbSaidasPessoasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbSaidasPessoas);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 926, Short.MAX_VALUE)
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

        AbasConsultas.addTab("Saídas de Pessoas", AbaSaidasPessoas);

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

    private void TbEntradasPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbEntradasPessoasMouseClicked

        String nomPs = "" + TbEntradasPessoas.getValueAt(TbEntradasPessoas.getSelectedRow(), 2);
        try {
            try {
                FrmDetalhesPessoa frmprop = new FrmDetalhesPessoa(nomPs);
                abrirTela.centralizarFormularioConsultas(frmprop);
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultasEntradaSaidaPessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TbEntradasPessoasMouseClicked

    private void jRdDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDataEntradaActionPerformed

        try {
            FrmConsultaDataEntrada frmConsultaData = new FrmConsultaDataEntrada(this);
            abrirTela.centralizarFormularioConsultas(frmConsultaData);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar.setConsulta("entradaPessoa");
    }//GEN-LAST:event_jRdDataEntradaActionPerformed

    private void jRdTipoPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTipoPessoaActionPerformed

        descTpPs = JOptionPane.showInputDialog(null, "Digite o tipo da pessoa :");
        if (descTpPs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o tipo pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaTipoPessoa();
        }
    }//GEN-LAST:event_jRdTipoPessoaActionPerformed

    private void jRdNomePessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomePessoaActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite o nome da pessoa :");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome da pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaNomePessoa();
        }
    }//GEN-LAST:event_jRdNomePessoaActionPerformed

    private void jRdTodasEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTodasEntradasActionPerformed

        atualizarTabelaEntradaTodasEntradas();
    }//GEN-LAST:event_jRdTodasEntradasActionPerformed

    private void jRdRgPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdRgPessoaActionPerformed

        RgPs = JOptionPane.showInputDialog(null, "Digite o rg da pessoa :");
        if (RgPs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o rg da pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaRgPessoa();
        }
    }//GEN-LAST:event_jRdRgPessoaActionPerformed

    private void jRdRgPessoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdRgPessoa2ActionPerformed

        RgPs = JOptionPane.showInputDialog(null, "Digite o rg da pessoa :");
        if (RgPs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o rg da pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaRgPessoa();
        }
    }//GEN-LAST:event_jRdRgPessoa2ActionPerformed

    private void jRdTodasSaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTodasSaidasActionPerformed

        atualizarTabelaTodasSaidas();
    }//GEN-LAST:event_jRdTodasSaidasActionPerformed

    private void jRdNomePessoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomePessoa2ActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite nome da pessoa :");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite nome da pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaNomePessoa();
        }
    }//GEN-LAST:event_jRdNomePessoa2ActionPerformed

    private void jRdTipoPessoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTipoPessoa2ActionPerformed

        descTpPs = JOptionPane.showInputDialog(null, "Digite o tipo da pessoa :");
        if (descTpPs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o tipo da pessoa para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaTipoPessoa();
        }
    }//GEN-LAST:event_jRdTipoPessoa2ActionPerformed

    private void jRdDataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDataSaidaActionPerformed

        try {
            FrmConsultaDataSaida frmConsultaData = new FrmConsultaDataSaida(this);
            abrirTela.centralizarFormularioConsultas(frmConsultaData);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar.setConsulta("saidaPessoa");
    }//GEN-LAST:event_jRdDataSaidaActionPerformed

    private void TbSaidasPessoasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbSaidasPessoasMouseClicked

        String nomPs = "" + TbEntradasPessoas.getValueAt(TbEntradasPessoas.getSelectedRow(), 2);
        try {
            try {
                FrmDetalhesPessoa frmprop = new FrmDetalhesPessoa(nomPs);
                abrirTela.centralizarFormularioConsultas(frmprop);
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultasEntradaSaidaPessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaPessoas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TbSaidasPessoasMouseClicked

    public void preencherTabelaEntradaPessoa(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Entrada", "Hora Entrada", "Nome Pessoa", "Detalhes Pessoa", "Observações Entrada"};
        conEntPs.conexao();
        conEntPs.executaSQL(SQL);
        try {
            conEntPs.rs.first();
            do {
                dados.add(new Object[]{conEntPs.rs.getString("Data_Ent_Ps"), conEntPs.rs.getString("Hora_Ent_Ps"), conEntPs.rs.getString("nome_Ps"), conEntPs.rs.getString("detalhes_Ps"), conEntPs.rs.getString("Obs_Ent_Ps")});
            } while (conEntPs.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma entrada com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbEntradasPessoas.setModel(modTabela);
        TbEntradasPessoas.getColumnModel().getColumn(0).setPreferredWidth(91);
        TbEntradasPessoas.getColumnModel().getColumn(0).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(1).setPreferredWidth(91);
        TbEntradasPessoas.getColumnModel().getColumn(1).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(2).setPreferredWidth(161);
        TbEntradasPessoas.getColumnModel().getColumn(2).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(3).setPreferredWidth(280);
        TbEntradasPessoas.getColumnModel().getColumn(3).setResizable(false);
        TbEntradasPessoas.getColumnModel().getColumn(4).setPreferredWidth(298);
        TbEntradasPessoas.getColumnModel().getColumn(4).setResizable(false);
        TbEntradasPessoas.getTableHeader().setReorderingAllowed(false);
        TbEntradasPessoas.setAutoResizeMode(TbEntradasPessoas.AUTO_RESIZE_OFF);
        TbEntradasPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conEntPs.desconecta();
    }

    public void preencherTabelaSaidaPessoa(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Saída", "Hora Saída", "Nome Pessoa", "Detalhes Pessoa", "Observações Entrada"};
        conSaidPs.conexao();
        conSaidPs.executaSQL(SQL);
        try {
            conSaidPs.rs.first();
            do {
                dados.add(new Object[]{conSaidPs.rs.getString("Data_Said_Ps"), conSaidPs.rs.getString("Hora_Said_Ps"), conSaidPs.rs.getString("nome_Ps"), conSaidPs.rs.getString("detalhes_Ps"), conSaidPs.rs.getString("Obs_Said_Ps")});
            } while (conSaidPs.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma saída com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbSaidasPessoas.setModel(modTabela);
        TbSaidasPessoas.getColumnModel().getColumn(0).setPreferredWidth(91);
        TbSaidasPessoas.getColumnModel().getColumn(0).setResizable(false);
        TbSaidasPessoas.getColumnModel().getColumn(1).setPreferredWidth(91);
        TbSaidasPessoas.getColumnModel().getColumn(1).setResizable(false);
        TbSaidasPessoas.getColumnModel().getColumn(2).setPreferredWidth(161);
        TbSaidasPessoas.getColumnModel().getColumn(2).setResizable(false);
        TbSaidasPessoas.getColumnModel().getColumn(3).setPreferredWidth(280);
        TbSaidasPessoas.getColumnModel().getColumn(3).setResizable(false);
        TbSaidasPessoas.getColumnModel().getColumn(4).setPreferredWidth(301);
        TbSaidasPessoas.getColumnModel().getColumn(4).setResizable(false);
        TbSaidasPessoas.getTableHeader().setReorderingAllowed(false);
        TbSaidasPessoas.setAutoResizeMode(TbSaidasPessoas.AUTO_RESIZE_OFF);
        TbSaidasPessoas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conSaidPs.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbaEntradaPessoas;
    private javax.swing.JPanel AbaSaidasPessoas;
    private javax.swing.JTabbedPane AbasConsultas;
    private javax.swing.JButton BtCancelar;
    private javax.swing.ButtonGroup RdGroupTiposConsultas;
    private javax.swing.ButtonGroup RdGroupTiposConsultas2;
    private javax.swing.ButtonGroup RdGroupTiposConsultasMoradores;
    private javax.swing.JTable TbEntradasPessoas;
    private javax.swing.JTable TbSaidasPessoas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRdDataEntrada;
    private javax.swing.JRadioButton jRdDataSaida;
    private javax.swing.JRadioButton jRdNomePessoa;
    private javax.swing.JRadioButton jRdNomePessoa2;
    private javax.swing.JRadioButton jRdRgPessoa;
    private javax.swing.JRadioButton jRdRgPessoa2;
    private javax.swing.JRadioButton jRdTipoPessoa;
    private javax.swing.JRadioButton jRdTipoPessoa2;
    private javax.swing.JRadioButton jRdTodasEntradas;
    private javax.swing.JRadioButton jRdTodasSaidas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    public void setData_ini(String data_ini) {
        this.data_ini = data_ini;
    }

    public void setData_fin(String data_fin) {
        this.data_fin = data_fin;
    }

    public void setNomePs(String nomePs) {
        this.nomePs = nomePs;
    }

    public void setRg(String Rg) {
        this.Rg = Rg;
    }

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

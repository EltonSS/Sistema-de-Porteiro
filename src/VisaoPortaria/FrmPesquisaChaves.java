package VisaoPortaria;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleSaidaChaves;
import ControleSistema.ControleChaves;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloSaidaChaves;
import ModeloSistema.ModeloChaves;
import javax.swing.JInternalFrame;

public class FrmPesquisaChaves extends javax.swing.JInternalFrame {

    ConectaBanco conChv = new ConectaBanco();
    ConectaBanco conSaidChv = new ConectaBanco();
    ModeloSaidaChaves modSaidChv = new ModeloSaidaChaves();
    ControleSaidaChaves controlSaidChv = new ControleSaidaChaves();
    ModeloChaves modChv = new ModeloChaves();
    ControleChaves controlChv = new ControleChaves();
    String codEstq, desc_Settec, descSets;
    int radioSelecionado = 0, id = 0, codEstoque = 0, Saiu;
    private final JInternalFrame parente;

    public FrmPesquisaChaves(JInternalFrame p) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        this.parente = p;
    }

    public void pesquisaChavesDescricao() {

        preencherTabelaChaves(" select * from vw_chaves where desc_chv like '%" + TfPesquisaChave.getText() + "%' and saiu ='0'");
    }

    public void pesquisaChavesSetor() {

        preencherTabelaChaves(" select * from vw_chaves where desc_set like '%" + TfPesquisaChave.getText() + "%' and saiu ='0'");
    }

    public void pesquisaTodasChaves() {

        preencherTabelaChaves(" select * from vw_chaves where saiu ='0'");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbChaves = new javax.swing.JTable();
        BtConsultar = new javax.swing.JButton();
        TfPesquisaChave = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jRdSetor = new javax.swing.JRadioButton();
        jRdDescChV = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta Chaves");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Consulta Chaves");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Chaves", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setToolTipText("");

        TbChaves.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbChaves.setToolTipText("Lista de chaves");
        TbChaves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbChavesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbChaves);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 390, 220));

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar chaves");
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(BtConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 48, 48));

        TfPesquisaChave.setToolTipText("Digite o a descrição ou setor da chave ");
        TfPesquisaChave.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfPesquisaChave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPesquisaChaveActionPerformed(evt);
            }
        });
        getContentPane().add(TfPesquisaChave, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 110, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Descrição");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RadioGroup.add(jRdSetor);
        jRdSetor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdSetor.setText("Setor");
        jRdSetor.setToolTipText("");
        jRdSetor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdSetorActionPerformed(evt);
            }
        });

        RadioGroup.add(jRdDescChV);
        jRdDescChV.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDescChV.setText("Descrição Chaves");
        jRdDescChV.setToolTipText("");
        jRdDescChV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDescChVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jRdDescChV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdSetor)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdDescChV)
                    .addComponent(jRdSetor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 50));

        setBounds(0, 0, 423, 370);
    }// </editor-fold>//GEN-END:initComponents

    private void TbChavesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbChavesMouseClicked

        int NumColuna = 0;
        Object codChv = "" + TbChaves.getValueAt(TbChaves.getSelectedRow(), NumColuna);
        conChv.conexao();
        conChv.executaSQL("select * from vw_chaves where cod_chv = '" + codChv + "'");
        try {
            conChv.rs.first();
            FrmControleSaidaChaves frmCtrlSaidaChaves = (FrmControleSaidaChaves) parente;
            frmCtrlSaidaChaves.setaCamposChaveSetor(conChv.rs.getString("desc_chv"), conChv.rs.getString("desc_set"));
            frmCtrlSaidaChaves.codChv = conChv.rs.getInt("cod_chv");
            frmCtrlSaidaChaves.descChave = conChv.rs.getString("desc_chv");//serve para mostrar a descrição da chave quando salvar
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
        conChv.desconecta();
        dispose();
    }//GEN-LAST:event_TbChavesMouseClicked

    private void jRdSetorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdSetorActionPerformed

        id = 2;
        radioSelecionado = 1;
        TfPesquisaChave.requestFocus();
    }//GEN-LAST:event_jRdSetorActionPerformed

    private void jRdDescChVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDescChVActionPerformed

        id = 1;
        radioSelecionado = 1;
        TfPesquisaChave.requestFocus();
    }//GEN-LAST:event_jRdDescChVActionPerformed

    public void pesquisar() {

        if (TfPesquisaChave.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta da chave desejada, digite a descrição da chave ou do setor a que a mesma pertence.");
        } else {
            if (radioSelecionado == 0) {
                JOptionPane.showMessageDialog(null, "Selecione qual tipo de consulta você deseja fazer");
            } else {
                if (radioSelecionado == 1) {
                    if (id == 1) {
                        pesquisaChavesDescricao();
                    } else {
                        if (id == 2) {
                            pesquisaChavesSetor();
                        }
                    }
                }
            }
        }
    }

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        pesquisar();
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void TfPesquisaChaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPesquisaChaveActionPerformed

        pesquisar();
    }//GEN-LAST:event_TfPesquisaChaveActionPerformed

    public void preencherTabelaChaves(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"","Descrição Chave", "Setor"};
        conChv.conexao();
        conChv.executaSQL(SQL);
        try {
            conChv.rs.first();
            do {
                dados.add(new Object[]{conChv.rs.getString("cod_chv"),conChv.rs.getString("desc_chv"), conChv.rs.getString("desc_set")});
            } while (conChv.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "A chave " + TfPesquisaChave.getText() + " não existe ou não está disponível no momento!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbChaves.setModel(modTabela);
        TbChaves.getColumnModel().getColumn(0).setPreferredWidth(1);
        TbChaves.getColumnModel().getColumn(0).setResizable(false);
        TbChaves.getColumnModel().getColumn(1).setPreferredWidth(200);
        TbChaves.getColumnModel().getColumn(1).setResizable(false);
        TbChaves.getColumnModel().getColumn(2).setPreferredWidth(149);
        TbChaves.getColumnModel().getColumn(2).setResizable(false);
        TbChaves.getTableHeader().setReorderingAllowed(false);
        TbChaves.setAutoResizeMode(TbChaves.AUTO_RESIZE_OFF);
        TbChaves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conChv.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtConsultar;
    private javax.swing.ButtonGroup RadioGroup;
    private javax.swing.JTable TbChaves;
    private javax.swing.JTextField TfPesquisaChave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRdDescChV;
    private javax.swing.JRadioButton jRdSetor;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

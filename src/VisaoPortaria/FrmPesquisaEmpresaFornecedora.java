package VisaoPortaria;

import ControleSistema.ConectaBanco;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import javax.swing.JInternalFrame;

public class FrmPesquisaEmpresaFornecedora extends javax.swing.JInternalFrame {

    ConectaBanco conPs = new ConectaBanco();
    private final JInternalFrame parente;

    public FrmPesquisaEmpresaFornecedora(JInternalFrame p) throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        this.parente = p;
    }

    public void pesquisaTabelaEmpresaForncedora() {

        preencherTabelaPessoa(" select * from tab_fornecedores where desc_forn like'%" + TfPesquisaEmpresaForncedora.getText() + "%'");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RadioGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbEmpresaForncedora = new javax.swing.JTable();
        BtConsultar = new javax.swing.JButton();
        TfPesquisaEmpresaForncedora = new javax.swing.JTextField();
        LbTipoPesquisa = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta Hóspede");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Consulta Funcionário Prest. Serv.");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Prestadores de Serviços Cadastrados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel2.setToolTipText("");

        TbEmpresaForncedora.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbEmpresaForncedora.setToolTipText("Lista de Materiais Cadastrados");
        TbEmpresaForncedora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbEmpresaForncedoraMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbEmpresaForncedora);

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
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 390, 270));

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Fornecedor");
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });
        getContentPane().add(BtConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 48, 48));

        TfPesquisaEmpresaForncedora.setToolTipText("Digite o Nome do Cliente");
        TfPesquisaEmpresaForncedora.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfPesquisaEmpresaForncedora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfPesquisaEmpresaForncedoraActionPerformed(evt);
            }
        });
        getContentPane().add(TfPesquisaEmpresaForncedora, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 220, -1));

        LbTipoPesquisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LbTipoPesquisa.setText("Digite Nome da Empresa ");
        getContentPane().add(LbTipoPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        setBounds(0, 0, 425, 435);
    }// </editor-fold>//GEN-END:initComponents

    private void TbEmpresaForncedoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbEmpresaForncedoraMouseClicked

        int NumColuna = 0;
        Object descForn = "" + TbEmpresaForncedora.getValueAt(TbEmpresaForncedora.getSelectedRow(), NumColuna);
        conPs.conexao();
        conPs.executaSQL("select * from tab_fornecedores where desc_forn = '" + descForn + "'");
        try {
            conPs.rs.first();
            FrmPrestadoresServicos frmPrestadoresServicos = (FrmPrestadoresServicos) parente;
            frmPrestadoresServicos.setNomeEmpresaFornecedora(conPs.rs.getString("desc_forn"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
        conPs.desconecta();
        dispose();
    }//GEN-LAST:event_TbEmpresaForncedoraMouseClicked

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        pesquisaTabelaEmpresaForncedora();
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void TfPesquisaEmpresaForncedoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfPesquisaEmpresaForncedoraActionPerformed

        pesquisaTabelaEmpresaForncedora();
    }//GEN-LAST:event_TfPesquisaEmpresaForncedoraActionPerformed

    public void preencherTabelaPessoa(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Empresa Forncedora"};
        conPs.conexao();
        conPs.executaSQL(SQL);
        try {
            conPs.rs.first();
            do {
                dados.add(new Object[]{conPs.rs.getString("desc_forn")});
            } while (conPs.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Esta pessoa não está cadastrada como forncedor!! \n"
                    + "Verifique no formulário de cadastros de pessoas qual é tipo de pessoa a que ela pertence.");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbEmpresaForncedora.setModel(modTabela);
        TbEmpresaForncedora.getColumnModel().getColumn(0).setPreferredWidth(353);
        TbEmpresaForncedora.getColumnModel().getColumn(0).setResizable(false);
        TbEmpresaForncedora.getTableHeader().setReorderingAllowed(false);
        TbEmpresaForncedora.setAutoResizeMode(TbEmpresaForncedora.AUTO_RESIZE_OFF);
        TbEmpresaForncedora.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conPs.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtConsultar;
    private javax.swing.JLabel LbTipoPesquisa;
    private javax.swing.ButtonGroup RadioGroup;
    private javax.swing.JTable TbEmpresaForncedora;
    private javax.swing.JTextField TfPesquisaEmpresaForncedora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

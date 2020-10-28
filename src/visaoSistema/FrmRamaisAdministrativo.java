package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleRamaisAdministrativo;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloRamaisAdministrativo;
import ModeloSistema.TratamentoCampos;

public class FrmRamaisAdministrativo extends javax.swing.JInternalFrame {

    ConectaBanco conRm = new ConectaBanco();
    ConectaBanco conSet = new ConectaBanco();
    ModeloRamaisAdministrativo modRm = new ModeloRamaisAdministrativo();
    TratamentoCampos tCampos = new TratamentoCampos();
    ControleRamaisAdministrativo control = new ControleRamaisAdministrativo();
    String numRm = "", numRamal;

    public FrmRamaisAdministrativo() throws SQLException, ParseException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        preencherCbSetores();
    }

    public void preencherCbSetores() {

        CbSetores.addItem("Escolha o setor");
        conSet.conexao();
        try {
            conSet.executaSQL("select * from tab_setores");
            conSet.rs.first();
            do {
                CbSetores.addItem(conSet.rs.getString("desc_set"));
            } while (conSet.rs.next());
        } catch (SQLException ex) {
        }
        conSet.desconecta();
    }

    public void atualizarCampos() {

        numRm = "";
        TfCodRamal.setText("");
        TfNumeroRamal.setText("");
//        CbSetores.removeAllItems();
//        CbSetores.getSelectedItem();
    }

    public void habilitaCampos() {

        TfNumeroRamal.setEnabled(true);
        CbSetores.setEnabled(true);
    }

    public void verificaNumeroRamal() {

        conRm.conexao();
        try {
            conRm.executaSQL("select * from tab_ramais_administrativo where num_rm ='" + TfNumeroRamal.getText() + "' ");
            conRm.rs.first();
            numRamal = conRm.rs.getString("num_rm");
        } catch (SQLException ex) {
            Logger.getLogger(FrmRamaisAdministrativo.class.getName()).log(Level.SEVERE, null, ex);
        }
        conRm.desconecta();
    }

    public void pesquisaTabelaRamaisAdministrativo() {

        preencherTabelaRamaisAdministrativo(" select * from vw_ramais_administrativo where num_rm like '%" + numRm + "%'");
    }

    public void limparTabelaRamaisAdministrativo() {

        limparTabelaRamaisAdministrativo("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TfNumeroRamal = new javax.swing.JTextField();
        TfCodRamal = new javax.swing.JFormattedTextField();
        BtConsultar = new javax.swing.JButton();
        CbSetores = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbRamais = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastrar Ramais Administrativo");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cod. Ramal Adm");

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

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.setEnabled(false);
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Número Ramal");

        TfNumeroRamal.setToolTipText("Digite o Nome do Cliente");
        TfNumeroRamal.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfNumeroRamal.setEnabled(false);
        TfNumeroRamal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TfNumeroRamalActionPerformed(evt);
            }
        });
        TfNumeroRamal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfNumeroRamalKeyTyped(evt);
            }
        });

        TfCodRamal.setToolTipText("Digite o CPF");
        TfCodRamal.setEnabled(false);
        TfCodRamal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfCodRamalKeyTyped(evt);
            }
        });

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Ramal");
        BtConsultar.setEnabled(false);
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });

        CbSetores.setToolTipText("Escolha a cor do veiculo");
        CbSetores.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setText("Setores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(TfCodRamal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(TfNumeroRamal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(CbSetores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addGap(6, 6, 6)
                .addComponent(TfCodRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(TfNumeroRamal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(6, 6, 6)
                        .addComponent(CbSetores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 390, 180));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros dos Ramais Adm");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Ramais", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbRamais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbRamais.setToolTipText("Lista de Fornecedores");
        TbRamais.setEnabled(false);
        TbRamais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbRamaisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbRamais);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 390, 190));

        setBounds(0, 0, 422, 469);
    }// </editor-fold>//GEN-END:initComponents

    public void salvarRegistro() {

        if (TfNumeroRamal.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Digite o nome do hóspede!!");
        } else {
            verificaNumeroRamal();
            if (TfNumeroRamal.getText().equals(numRamal)) {
                JOptionPane.showMessageDialog(rootPane, "Esse ramal já está cadastrado!!");
            } else {
                modRm.setNumRm(TfNumeroRamal.getText());
                modRm.setDescSet((String) CbSetores.getSelectedItem());
                control.InserirRamal(modRm);
                atualizarCampos();
                limparTabelaRamaisAdministrativo();
                JOptionPane.showMessageDialog(rootPane, "O ramal : " + modRm.getNumRm() + " foi registrado com sucesso!!");
                TfNumeroRamal.setEnabled(false);
                CbSetores.setEnabled(false);
                TbRamais.setEnabled(false);
                BtExcluir.setEnabled(false);
                BtAlterar.setEnabled(false);
                BtEditar.setEnabled(true);
                BtCancelar.setEnabled(false);
                BtSalvar.setEnabled(false);
                BtAdicionar.setEnabled(true);
            }
        }
    }

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        salvarRegistro();
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        String nome = "Você deseja deletar o ramal : " + TfNumeroRamal.getText() + " ?";
        int opcao_escolhida = JOptionPane.showConfirmDialog(null, nome, "", JOptionPane.YES_NO_OPTION);
        if (opcao_escolhida == JOptionPane.YES_OPTION) {
            modRm.setCodRm(Integer.valueOf(TfCodRamal.getText()));
            modRm.setNumRm(TfNumeroRamal.getText());
            control.ExcluirRamal(modRm);
            JOptionPane.showMessageDialog(null, "O ramal : " + TfNumeroRamal.getText() + " foi excluído com sucesso!!");
            atualizarCampos();
            limparTabelaRamaisAdministrativo();
            TfCodRamal.setEnabled(false);
            TfNumeroRamal.setEnabled(false);
            CbSetores.setEnabled(false);
            TbRamais.setEnabled(false);
            BtExcluir.setEnabled(false);
            BtAlterar.setEnabled(false);
            BtCancelar.setEnabled(false);
            BtSalvar.setEnabled(false);
            BtAdicionar.setEnabled(true);
            BtEditar.setEnabled(true);
        } else {
        }
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaRamaisAdministrativo();
        TfNumeroRamal.setEnabled(true);
        TfNumeroRamal.requestFocus();
        CbSetores.setEnabled(true);
        TbRamais.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        modRm.setCodRm(Integer.valueOf(TfCodRamal.getText()));
        modRm.setNumRm(TfNumeroRamal.getText());
        modRm.setDescSet((String) CbSetores.getSelectedItem());
        control.AlterarRamal(modRm);
        JOptionPane.showMessageDialog(rootPane, "O ramal: " + modRm.getNumRm() + " foi alterado com sucesso!!");
        atualizarCampos();
        limparTabelaRamaisAdministrativo();
        TfCodRamal.setEnabled(false);
        TfNumeroRamal.setEnabled(false);
        CbSetores.setEnabled(false);
        TbRamais.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
        BtConsultar.setEnabled(false);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        limparTabelaRamaisAdministrativo();
        TfCodRamal.setEnabled(false);
        TfNumeroRamal.setEnabled(false);
        CbSetores.setEnabled(false);
        TbRamais.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaRamaisAdministrativo();
        BtConsultar.setEnabled(true);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbRamaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbRamaisMouseClicked

        String num_Rm = "" + TbRamais.getValueAt(TbRamais.getSelectedRow(), 0);
        conRm.conexao();
        conRm.executaSQL("select * from vw_ramais_administrativo where num_rm = '" + num_Rm + "'");
        try {
            conRm.rs.first();
            TfCodRamal.setText(conRm.rs.getString("cod_rm"));
            TfNumeroRamal.setText(conRm.rs.getString("num_rm"));
            CbSetores.setSelectedItem(conRm.rs.getString("desc_set"));
            habilitaCampos();
            TfNumeroRamal.requestFocus();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
            BtConsultar.setEnabled(false);            
            conRm.desconecta();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao preencher os campos!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbRamaisMouseClicked

    private void TfCodRamalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfCodRamalKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfCodRamalKeyTyped

    private void TfNumeroRamalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfNumeroRamalKeyTyped

        tCampos.soNumeros(evt);
    }//GEN-LAST:event_TfNumeroRamalKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        numRm = JOptionPane.showInputDialog(null, "Digite o número do ramal :");
        if (numRm.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o número do ramal desejado.");
        } else {
            pesquisaTabelaRamaisAdministrativo();
            TbRamais.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void TfNumeroRamalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TfNumeroRamalActionPerformed
        
        salvarRegistro();
    }//GEN-LAST:event_TfNumeroRamalActionPerformed

    public void preencherTabelaRamaisAdministrativo(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Número Ramal", "Setor"};
        conRm.conexao();
        conRm.executaSQL(SQL);
        try {
            conRm.rs.first();
            do {
                dados.add(new Object[]{conRm.rs.getString("num_rm"), conRm.rs.getString("desc_set")});
            } while (conRm.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Este ramal não está cadastrado!!");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbRamais.setModel(modTabela);
        TbRamais.getColumnModel().getColumn(0).setPreferredWidth(153);
        TbRamais.getColumnModel().getColumn(0).setResizable(false);
        TbRamais.getColumnModel().getColumn(1).setPreferredWidth(200);
        TbRamais.getColumnModel().getColumn(1).setResizable(false);
        TbRamais.getTableHeader().setReorderingAllowed(false);
        TbRamais.setAutoResizeMode(TbRamais.AUTO_RESIZE_OFF);
        TbRamais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conRm.desconecta();
    }

    public void limparTabelaRamaisAdministrativo(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Número Ramal", "Setor"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbRamais.setModel(modTabela);
        TbRamais.getColumnModel().getColumn(0).setPreferredWidth(153);
        TbRamais.getColumnModel().getColumn(0).setResizable(false);
        TbRamais.getColumnModel().getColumn(1).setPreferredWidth(200);
        TbRamais.getColumnModel().getColumn(1).setResizable(false);
        TbRamais.getTableHeader().setReorderingAllowed(false);
        TbRamais.setAutoResizeMode(TbRamais.AUTO_RESIZE_OFF);
        TbRamais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbSetores;
    private javax.swing.JTable TbRamais;
    private javax.swing.JFormattedTextField TfCodRamal;
    private javax.swing.JTextField TfNumeroRamal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    private void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

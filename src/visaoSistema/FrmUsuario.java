package visaoSistema;

import ControleSistema.ConectaBanco;
import ControleSistema.ControleUsuario;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import ModeloSistema.ModeloTabela;
import ModeloSistema.ModeloUsuario;

public class FrmUsuario extends javax.swing.JInternalFrame {

    static void setEnable(boolean b) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    ConectaBanco conUsuario = new ConectaBanco();
    ModeloUsuario mod = new ModeloUsuario();
    ControleUsuario control = new ControleUsuario();
    String logUsu, loginUsuario;
    String Perm_Menu_Moradores = "Não",
            Perm_Menu_Visitantes = "Não",
            Perm_Menu_Hospedes = "Não",
            Perm_Menu_PrestServicos = "Não",
            Perm_Menu_Funcionarios = "Não",
            Perm_Menu_Porteiros = "Não",
            Perm_Menu_Veiculos = "Não",
            Perm_Menu_Chaves = "Não",
            Perm_Menu_Empresas = "Não",
            Perm_Menu_ConsPortaria = "Não",
            Perm_Menu_CtrlAcessoVeiculos = "Não",
            Perm_Menu_CtrlAcessoPessoas = "Não",
            Perm_Menu_CtrlChaves = "Não",
            Perm_Menu_Agenda = "Não",
            Perm_Menu_Lembretes = "Não",
            Perm_Menu_AltSenhaSistema = "Não",
            Perm_Menu_AltSenhaPorteiro = "Não";

    public FrmUsuario() throws SQLException { //Buscando todas as sigals do banco tab_uf para o combo box de uf

        initComponents();
        atualizarCampos();
        preencherCbTipoUsuario();
    }

    public void resertarPermissoes() {

        Perm_Menu_Moradores = "Não";
        Perm_Menu_Visitantes = "Não";
        Perm_Menu_Hospedes = "Não";
        Perm_Menu_PrestServicos = "Não";
        Perm_Menu_Funcionarios = "Não";
        Perm_Menu_Porteiros = "Não";
        Perm_Menu_Veiculos = "Não";
        Perm_Menu_Chaves = "Não";
        Perm_Menu_Empresas = "Não";
        Perm_Menu_ConsPortaria = "Não";
        Perm_Menu_CtrlAcessoVeiculos = "Não";
        Perm_Menu_CtrlAcessoPessoas = "Não";
        Perm_Menu_CtrlChaves = "Não";
        Perm_Menu_Agenda = "Não";
        Perm_Menu_Lembretes = "Não";
        Perm_Menu_AltSenhaSistema = "Não";
        Perm_Menu_AltSenhaPorteiro = "Não";
    }

    public void verificaLoginUsuario() {

        conUsuario.conexao();
        try {
            conUsuario.executaSQL("select * from tab_usuarios where login_usu = '" + TfLoginUsuario.getText() + "'");
            conUsuario.rs.first();
            loginUsuario = conUsuario.rs.getString("login_usu");
        } catch (Exception e) {
        }
        conUsuario.desconecta();
    }

    public void atualizarCampos() {

        TfLoginUsuario.setText("");
        PwdTfSenhaUsuario.setText("");
        jCheckCadastrarMoradores.setSelected(false);
        jCheckCadastrarHospedes.setSelected(false);
        jCheckCadastrarVisitantes.setSelected(false);
        jCheckCadastrarPrestadoresServiços.setSelected(false);
        jCheckCadastrarFuncionarios.setSelected(false);
        jCheckCadastarPorteiros.setSelected(false);
        jCheckCadastrarChaves.setSelected(false);
        jCheckCadastrarEmpresas.setSelected(false);
        jCheckCadastrarVeiculos.setSelected(false);
        jCheckConsultas.setSelected(false);
        jCheckControleAcessoVeiculos.setSelected(false);
        jCheckControleAcessoPessoas.setSelected(false);
        jCheckControleChaves.setSelected(false);
        jCheckAgenda.setSelected(false);
        jCheckLembretes.setSelected(false);
        jCheckAlterarSenhaSistema.setSelected(false);
        jCheckAlterarSenhaPorteiro.setSelected(false);
    }

    public void habilitaCampos() {

        TfLoginUsuario.setEnabled(true);
        PwdTfSenhaUsuario.setEnabled(true);
        CbTipoUsuario.setEnabled(true);
        jCheckCadastrarMoradores.setEnabled(true);
        jCheckCadastrarHospedes.setEnabled(true);
        jCheckCadastrarVisitantes.setEnabled(true);
        jCheckCadastrarPrestadoresServiços.setEnabled(true);
        jCheckCadastrarFuncionarios.setEnabled(true);
        jCheckCadastarPorteiros.setEnabled(true);
        jCheckCadastrarChaves.setEnabled(true);
        jCheckCadastrarEmpresas.setEnabled(true);
        jCheckCadastrarVeiculos.setEnabled(true);
        jCheckConsultas.setEnabled(true);
        jCheckControleAcessoVeiculos.setEnabled(true);
        jCheckControleAcessoPessoas.setEnabled(true);
        jCheckControleChaves.setEnabled(true);
        jCheckAgenda.setEnabled(true);
        jCheckLembretes.setEnabled(true);
        jCheckAlterarSenhaSistema.setEnabled(true);
        jCheckAlterarSenhaPorteiro.setEnabled(true);
    }

    public void desabilitaCampos() {

        TfLoginUsuario.setEnabled(false);
        PwdTfSenhaUsuario.setEnabled(false);
        CbTipoUsuario.setEnabled(false);
        jCheckCadastrarMoradores.setEnabled(false);
        jCheckCadastrarHospedes.setEnabled(false);
        jCheckCadastrarVisitantes.setEnabled(false);
        jCheckCadastrarPrestadoresServiços.setEnabled(false);
        jCheckCadastrarFuncionarios.setEnabled(false);
        jCheckCadastarPorteiros.setEnabled(false);
        jCheckCadastrarChaves.setEnabled(false);
        jCheckCadastrarEmpresas.setEnabled(false);
        jCheckCadastrarVeiculos.setEnabled(false);
        jCheckConsultas.setEnabled(false);
        jCheckControleAcessoVeiculos.setEnabled(false);
        jCheckControleAcessoPessoas.setEnabled(false);
        jCheckControleChaves.setEnabled(false);
        jCheckAgenda.setEnabled(false);
        jCheckLembretes.setEnabled(false);
        jCheckAlterarSenhaSistema.setEnabled(false);
        jCheckAlterarSenhaPorteiro.setEnabled(false);
    }

    public void preencherCbTipoUsuario() {

        conUsuario.conexao();
        conUsuario.executaSQL("select * from tab_tipo_usuarios order by cod_tipo_usu");
        try {
            conUsuario.rs.first();
            do {
                CbTipoUsuario.addItem("" + conUsuario.rs.getString("Descricao_tipo_usu"));
            } while (conUsuario.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível localizar o estado \n ERRO :" + ex);
        }
        conUsuario.desconecta();
    }

    public void atualizarTabela() {

        preencherTabelaUsu("select * from vw_usuario where login_usu like '%" + logUsu + "%'");
    }

    public void limparTabelaUsuario() {

        limparTabelaUsuario("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel1 = new java.awt.Panel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TfLoginUsuario = new javax.swing.JTextField();
        BtAdicionar = new javax.swing.JButton();
        BtCancelar = new javax.swing.JButton();
        BtExcluir = new javax.swing.JButton();
        BtAlterar = new javax.swing.JButton();
        BtSalvar = new javax.swing.JButton();
        CbTipoUsuario = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        BtEditar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        PwdTfSenhaUsuario = new javax.swing.JPasswordField();
        BtConsultar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jCheckCadastrarMoradores = new javax.swing.JCheckBox();
        jCheckCadastrarHospedes = new javax.swing.JCheckBox();
        jCheckCadastrarVisitantes = new javax.swing.JCheckBox();
        jCheckCadastrarPrestadoresServiços = new javax.swing.JCheckBox();
        jCheckCadastrarFuncionarios = new javax.swing.JCheckBox();
        jCheckCadastrarChaves = new javax.swing.JCheckBox();
        jCheckControleAcessoPessoas = new javax.swing.JCheckBox();
        jCheckConsultas = new javax.swing.JCheckBox();
        jCheckControleAcessoVeiculos = new javax.swing.JCheckBox();
        jCheckControleChaves = new javax.swing.JCheckBox();
        jCheckAgenda = new javax.swing.JCheckBox();
        jCheckLembretes = new javax.swing.JCheckBox();
        jCheckAlterarSenhaSistema = new javax.swing.JCheckBox();
        jCheckAlterarSenhaPorteiro = new javax.swing.JCheckBox();
        jCheckCadastarPorteiros = new javax.swing.JCheckBox();
        jCheckCadastrarVeiculos = new javax.swing.JCheckBox();
        jCheckCadastrarEmpresas = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbUsuario = new javax.swing.JTable();

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastros de Usuários");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Login *");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        TfLoginUsuario.setToolTipText("Digite o login do usuário");
        TfLoginUsuario.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        TfLoginUsuario.setEnabled(false);
        TfLoginUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TfLoginUsuarioKeyTyped(evt);
            }
        });
        jPanel1.add(TfLoginUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 32, 162, -1));

        BtAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        BtAdicionar.setToolTipText("Adicionar Registro");
        BtAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAdicionarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 48, 48));

        BtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar.gif"))); // NOI18N
        BtCancelar.setToolTipText("Cancelar Registro");
        BtCancelar.setEnabled(false);
        BtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(BtCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 48, 48));

        BtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Botoes_Site_5751_Knob_Remove_Red.png"))); // NOI18N
        BtExcluir.setToolTipText("Deletar Registro");
        BtExcluir.setEnabled(false);
        BtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtExcluirActionPerformed(evt);
            }
        });
        jPanel1.add(BtExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 48, 48));

        BtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar edição.png"))); // NOI18N
        BtAlterar.setToolTipText("Alterar Registro");
        BtAlterar.setEnabled(false);
        BtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarActionPerformed(evt);
            }
        });
        jPanel1.add(BtAlterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 340, 48, 48));

        BtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Save.gif"))); // NOI18N
        BtSalvar.setToolTipText("Salvar Registro");
        BtSalvar.setEnabled(false);
        BtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSalvarActionPerformed(evt);
            }
        });
        jPanel1.add(BtSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 48, 48));

        CbTipoUsuario.setToolTipText("Escolha o tipo de usuário");
        CbTipoUsuario.setEnabled(false);
        jPanel1.add(CbTipoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 164, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Tipo de Usuário");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        BtEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/editar registros.png"))); // NOI18N
        BtEditar.setToolTipText("Editar Registro");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });
        jPanel1.add(BtEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 48, 48));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Senha *");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 13, -1, -1));

        PwdTfSenhaUsuario.setToolTipText("Digite a senha do usuário");
        PwdTfSenhaUsuario.setEnabled(false);
        jPanel1.add(PwdTfSenhaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 32, 147, -1));

        BtConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/lupa.png"))); // NOI18N
        BtConsultar.setToolTipText("Consultar Fornecedor");
        BtConsultar.setEnabled(false);
        BtConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarActionPerformed(evt);
            }
        });
        jPanel1.add(BtConsultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, 48, 48));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Permições do Usuário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jCheckCadastrarMoradores.setText("Cad Moradores");
        jCheckCadastrarMoradores.setEnabled(false);
        jCheckCadastrarMoradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarMoradoresActionPerformed(evt);
            }
        });

        jCheckCadastrarHospedes.setText("Cad Hóspedes");
        jCheckCadastrarHospedes.setEnabled(false);
        jCheckCadastrarHospedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarHospedesActionPerformed(evt);
            }
        });

        jCheckCadastrarVisitantes.setText("Cad Visitantes");
        jCheckCadastrarVisitantes.setEnabled(false);
        jCheckCadastrarVisitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarVisitantesActionPerformed(evt);
            }
        });

        jCheckCadastrarPrestadoresServiços.setText("Cad Prestadores Serviços");
        jCheckCadastrarPrestadoresServiços.setEnabled(false);
        jCheckCadastrarPrestadoresServiços.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarPrestadoresServiçosActionPerformed(evt);
            }
        });

        jCheckCadastrarFuncionarios.setText("Cad Funcionários");
        jCheckCadastrarFuncionarios.setEnabled(false);
        jCheckCadastrarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarFuncionariosActionPerformed(evt);
            }
        });

        jCheckCadastrarChaves.setText("Cad Chaves");
        jCheckCadastrarChaves.setEnabled(false);
        jCheckCadastrarChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarChavesActionPerformed(evt);
            }
        });

        jCheckControleAcessoPessoas.setText("Ctrl Acesso Pessoas");
        jCheckControleAcessoPessoas.setEnabled(false);
        jCheckControleAcessoPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckControleAcessoPessoasActionPerformed(evt);
            }
        });

        jCheckConsultas.setText("Consultas ");
        jCheckConsultas.setEnabled(false);
        jCheckConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckConsultasActionPerformed(evt);
            }
        });

        jCheckControleAcessoVeiculos.setText("Ctrl Acesso Veículos");
        jCheckControleAcessoVeiculos.setEnabled(false);
        jCheckControleAcessoVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckControleAcessoVeiculosActionPerformed(evt);
            }
        });

        jCheckControleChaves.setText("Controle Chaves");
        jCheckControleChaves.setEnabled(false);
        jCheckControleChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckControleChavesActionPerformed(evt);
            }
        });

        jCheckAgenda.setText("Agenda");
        jCheckAgenda.setEnabled(false);
        jCheckAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAgendaActionPerformed(evt);
            }
        });

        jCheckLembretes.setText("Lembretes");
        jCheckLembretes.setEnabled(false);
        jCheckLembretes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckLembretesActionPerformed(evt);
            }
        });

        jCheckAlterarSenhaSistema.setText("Alt Senha Sistema");
        jCheckAlterarSenhaSistema.setEnabled(false);
        jCheckAlterarSenhaSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAlterarSenhaSistemaActionPerformed(evt);
            }
        });

        jCheckAlterarSenhaPorteiro.setText("Alt Senha Porteiro");
        jCheckAlterarSenhaPorteiro.setEnabled(false);
        jCheckAlterarSenhaPorteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckAlterarSenhaPorteiroActionPerformed(evt);
            }
        });

        jCheckCadastarPorteiros.setText("Cad Porteiros");
        jCheckCadastarPorteiros.setEnabled(false);
        jCheckCadastarPorteiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastarPorteirosActionPerformed(evt);
            }
        });

        jCheckCadastrarVeiculos.setText("Cad Veículos");
        jCheckCadastrarVeiculos.setEnabled(false);
        jCheckCadastrarVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarVeiculosActionPerformed(evt);
            }
        });

        jCheckCadastrarEmpresas.setText("Cad Empresas");
        jCheckCadastrarEmpresas.setEnabled(false);
        jCheckCadastrarEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckCadastrarEmpresasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckCadastrarHospedes)
                    .addComponent(jCheckCadastrarVisitantes)
                    .addComponent(jCheckCadastrarPrestadoresServiços)
                    .addComponent(jCheckCadastrarChaves)
                    .addComponent(jCheckCadastrarFuncionarios)
                    .addComponent(jCheckCadastarPorteiros)
                    .addComponent(jCheckCadastrarMoradores)
                    .addComponent(jCheckCadastrarEmpresas))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckConsultas)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckCadastrarVeiculos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(jCheckLembretes))
                    .addComponent(jCheckControleAcessoPessoas)
                    .addComponent(jCheckControleAcessoVeiculos)
                    .addComponent(jCheckControleChaves)
                    .addComponent(jCheckAlterarSenhaPorteiro)
                    .addComponent(jCheckAlterarSenhaSistema)
                    .addComponent(jCheckAgenda))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jCheckCadastrarMoradores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckCadastrarHospedes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckCadastrarVisitantes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckCadastrarPrestadoresServiços)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckCadastrarFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckCadastarPorteiros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckCadastrarChaves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckCadastrarEmpresas)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckCadastrarVeiculos)
                    .addComponent(jCheckLembretes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckConsultas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckControleAcessoVeiculos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckControleAcessoPessoas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckControleChaves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckAlterarSenhaPorteiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckAlterarSenhaSistema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckAgenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 400, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Cadastros de Usuários");

        TbUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbUsuario.setToolTipText("Lista dos usuários cadastrados");
        TbUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbUsuario);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 454, 613);
    }// </editor-fold>//GEN-END:initComponents

    private void BtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSalvarActionPerformed

        if ((TfLoginUsuario.getText().equals(""))) {
            JOptionPane.showMessageDialog(null, "Digite um login!!");
            TfLoginUsuario.requestFocus();
        } else {
            if ((PwdTfSenhaUsuario.getText().equals(""))) {
                JOptionPane.showMessageDialog(null, "Digite uma senha!!");
                PwdTfSenhaUsuario.requestFocus();
            } else {
                verificaLoginUsuario();
                if (loginUsuario == TfLoginUsuario.getText()) {
                    JOptionPane.showMessageDialog(null, "Esse login de já existe, por favor digite outro!!");
                    TfLoginUsuario.setText("");
                    TfLoginUsuario.requestFocus();
                } else {
                    mod.setLoginUsu(TfLoginUsuario.getText());
                    mod.setSenhaUsu(PwdTfSenhaUsuario.getText());
                    mod.setNomeTipoUsu((String) CbTipoUsuario.getSelectedItem());
                    mod.setPermMenuMr(Perm_Menu_Moradores);
                    mod.setPermMenuHsp(Perm_Menu_Hospedes);
                    mod.setPermMenuVis(Perm_Menu_Visitantes);
                    mod.setPermMenuPrestServ(Perm_Menu_PrestServicos);
                    mod.setPermMenuFunc(Perm_Menu_Funcionarios);
                    mod.setPermMenuPort(Perm_Menu_Porteiros);
                    mod.setPermMenuVc(Perm_Menu_Veiculos);
                    mod.setPermMenuChv(Perm_Menu_Chaves);
                    mod.setPermMenuConsPort(Perm_Menu_ConsPortaria);
                    mod.setPermMenuCtrlAcesVc(Perm_Menu_CtrlAcessoVeiculos);
                    mod.setPermMenuCtrlAcesPs(Perm_Menu_CtrlAcessoPessoas);
                    mod.setPermMenuCtrlChv(Perm_Menu_CtrlChaves);
                    mod.setPermMenuEmp(Perm_Menu_Empresas);
                    mod.setPermMenuLbt(Perm_Menu_Lembretes);
                    mod.setPermMenuAgd(Perm_Menu_Agenda);
                    mod.setPermMenuAltSnhaSist(Perm_Menu_AltSenhaSistema);
                    mod.setPermMenuAltSnhaPort(Perm_Menu_AltSenhaPorteiro);
                    control.InserirUsuario(mod);
                    atualizarCampos();
                    limparTabelaUsuario();
                    JOptionPane.showMessageDialog(rootPane, "O usuário : " + mod.getLoginUsu() + " foi registrado com sucesso!!");
                    desabilitaCampos();
                    resertarPermissoes();
                    BtExcluir.setEnabled(false);
                    BtAlterar.setEnabled(false);
                    BtEditar.setEnabled(true);
                    BtCancelar.setEnabled(false);
                    BtSalvar.setEnabled(false);
                    BtAdicionar.setEnabled(true);
                }
            }
        }
    }//GEN-LAST:event_BtSalvarActionPerformed

    private void BtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtExcluirActionPerformed

        mod.setLoginUsu(TfLoginUsuario.getText());
        control.ExcluirUsuario(mod);
        atualizarCampos();
        limparTabelaUsuario();
        JOptionPane.showMessageDialog(rootPane, "O usuário : " + mod.getLoginUsu() + " foi excluído com sucesso!!");
        desabilitaCampos();
        resertarPermissoes();
        TbUsuario.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtExcluirActionPerformed

    private void BtAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAdicionarActionPerformed

        atualizarCampos();
        limparTabelaUsuario();
        habilitaCampos();
        TfLoginUsuario.requestFocus();
        BtExcluir.setEnabled(false);
        BtEditar.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(true);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtAdicionarActionPerformed

    private void BtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarActionPerformed

        mod.setLoginUsu(TfLoginUsuario.getText());
        mod.setSenhaUsu(PwdTfSenhaUsuario.getText());
        mod.setNomeTipoUsu((String) CbTipoUsuario.getSelectedItem());
        mod.setPermMenuMr(Perm_Menu_Moradores);
        mod.setPermMenuHsp(Perm_Menu_Hospedes);
        mod.setPermMenuVis(Perm_Menu_Visitantes);
        mod.setPermMenuPrestServ(Perm_Menu_PrestServicos);
        mod.setPermMenuFunc(Perm_Menu_Funcionarios);
        mod.setPermMenuPort(Perm_Menu_Porteiros);
        mod.setPermMenuVc(Perm_Menu_Veiculos);
        mod.setPermMenuChv(Perm_Menu_Chaves);
        mod.setPermMenuConsPort(Perm_Menu_ConsPortaria);
        mod.setPermMenuCtrlAcesVc(Perm_Menu_CtrlAcessoVeiculos);
        mod.setPermMenuCtrlAcesPs(Perm_Menu_CtrlAcessoPessoas);
        mod.setPermMenuCtrlChv(Perm_Menu_CtrlChaves);
        mod.setPermMenuEmp(Perm_Menu_Empresas);
        mod.setPermMenuLbt(Perm_Menu_Lembretes);
        mod.setPermMenuAgd(Perm_Menu_Agenda);
        mod.setPermMenuAltSnhaSist(Perm_Menu_AltSenhaSistema);
        mod.setPermMenuAltSnhaPort(Perm_Menu_AltSenhaPorteiro);
        control.AlterarUsuario(mod);
        atualizarCampos();
        limparTabelaUsuario();
        JOptionPane.showMessageDialog(rootPane, "O usuário : " + mod.getLoginUsu() + " foi alterado com sucesso!!");
        desabilitaCampos();
        resertarPermissoes();
        TbUsuario.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtAlterarActionPerformed

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        atualizarCampos();
        limparTabelaUsuario();
        desabilitaCampos();
        resertarPermissoes();
        TbUsuario.setEnabled(false);
        BtConsultar.setEnabled(false);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(true);
        BtCancelar.setEnabled(false);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(true);
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed

        limparTabelaUsuario();
        TfLoginUsuario.setEnabled(false);
        CbTipoUsuario.setEnabled(false);
        PwdTfSenhaUsuario.setEnabled(false);
        BtConsultar.setEnabled(true);
        BtExcluir.setEnabled(false);
        BtAlterar.setEnabled(false);
        BtEditar.setEnabled(false);
        BtCancelar.setEnabled(true);
        BtSalvar.setEnabled(false);
        BtAdicionar.setEnabled(false);
    }//GEN-LAST:event_BtEditarActionPerformed

    private void TbUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbUsuarioMouseClicked

        String login_usuario = "" + TbUsuario.getValueAt(TbUsuario.getSelectedRow(), 0);
        conUsuario.conexao();
        conUsuario.executaSQL("select * from vw_usuario where login_usu = '" + login_usuario + "'");
        try {
            conUsuario.rs.first();
            TfLoginUsuario.setText(conUsuario.rs.getString("login_usu"));
            PwdTfSenhaUsuario.setText(conUsuario.rs.getString("senha_usu"));
            CbTipoUsuario.setSelectedItem(conUsuario.rs.getString("descricao_tipo_usu"));
            if (conUsuario.rs.getString("Perm_MenuCad_Mor").equals("Sim")) {
                jCheckCadastrarMoradores.setSelected(true);
                Perm_Menu_Moradores = conUsuario.rs.getString("Perm_MenuCad_Mor");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Vis").equals("Sim")) {
                jCheckCadastrarVisitantes.setSelected(true);
                Perm_Menu_Visitantes = conUsuario.rs.getString("Perm_MenuCad_Vis");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Hosp").equals("Sim")) {
                jCheckCadastrarHospedes.setSelected(true);
                Perm_Menu_Hospedes = conUsuario.rs.getString("Perm_MenuCad_Hosp");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_PrestServ").equals("Sim")) {
                jCheckCadastrarPrestadoresServiços.setSelected(true);
                Perm_Menu_PrestServicos = conUsuario.rs.getString("Perm_MenuCad_PrestServ");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Func").equals("Sim")) {
                jCheckCadastrarFuncionarios.setSelected(true);
                Perm_Menu_Funcionarios = conUsuario.rs.getString("Perm_MenuCad_Func");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Port").equals("Sim")) {
                jCheckCadastarPorteiros.setSelected(true);
                Perm_Menu_Porteiros = conUsuario.rs.getString("Perm_MenuCad_Port");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Veic").equals("Sim")) {
                jCheckCadastrarVeiculos.setSelected(true);
                Perm_Menu_Veiculos = conUsuario.rs.getString("Perm_MenuCad_Veic");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Chav").equals("Sim")) {
                jCheckCadastrarChaves.setSelected(true);
                Perm_Menu_Chaves = conUsuario.rs.getString("Perm_MenuCad_Chav");
            }
            if (conUsuario.rs.getString("Perm_MenuCons_Port").equals("Sim")) {
                jCheckConsultas.setSelected(true);
                Perm_Menu_ConsPortaria = conUsuario.rs.getString("Perm_MenuCons_Port");
            }
            if (conUsuario.rs.getString("Perm_MenuCtrl_AcessoVeic").equals("Sim")) {
                jCheckControleAcessoVeiculos.setSelected(true);
                Perm_Menu_CtrlAcessoVeiculos = conUsuario.rs.getString("Perm_MenuCtrl_AcessoVeic");
            }
            if (conUsuario.rs.getString("Perm_MenuCtrl_AcessoPs").equals("Sim")) {
                jCheckControleAcessoPessoas.setSelected(true);
                Perm_Menu_CtrlAcessoPessoas = conUsuario.rs.getString("Perm_MenuCtrl_AcessoPs");
            }
            if (conUsuario.rs.getString("Perm_MenuCtrl_Chav").equals("Sim")) {
                jCheckControleChaves.setSelected(true);
                Perm_Menu_CtrlChaves = conUsuario.rs.getString("Perm_MenuCtrl_Chav");
            }            
            if (conUsuario.rs.getString("Perm_MenuCad_Emp").equals("Sim")) {
                jCheckCadastrarEmpresas.setSelected(true);
                Perm_Menu_Empresas = conUsuario.rs.getString("Perm_MenuCad_Emp");
            }            
            if (conUsuario.rs.getString("Perm_MenuCad_Lembrete").equals("Sim")) {
                jCheckLembretes.setSelected(true);
                Perm_Menu_Lembretes = conUsuario.rs.getString("Perm_MenuCad_Lembrete");
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Agenda").equals("Sim")) {
                jCheckAgenda.setSelected(true);
                Perm_Menu_Agenda = conUsuario.rs.getString("Perm_MenuCad_Agenda");
            }
            if (conUsuario.rs.getString("Perm_MenuAlt_SenhaSist").equals("Sim")) {
                jCheckAlterarSenhaSistema.setSelected(true);
                Perm_Menu_AltSenhaSistema = conUsuario.rs.getString("Perm_MenuAlt_SenhaSist");
            }
            if (conUsuario.rs.getString("Perm_MenuAlt_SenhaPort").equals("Sim")) {
                jCheckAlterarSenhaPorteiro.setSelected(true);
                Perm_Menu_AltSenhaPorteiro = conUsuario.rs.getString("Perm_MenuAlt_SenhaPort");
            }
            habilitaCampos();
            conUsuario.desconecta();
            BtExcluir.setEnabled(true);
            BtAlterar.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Erro ao exibir a Sigla!!\n Erro: " + ex);
        }
    }//GEN-LAST:event_TbUsuarioMouseClicked

    private void TfLoginUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TfLoginUsuarioKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }//GEN-LAST:event_TfLoginUsuarioKeyTyped

    private void BtConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarActionPerformed

        logUsu = JOptionPane.showInputDialog(null, "Digite o login do sistema");
        if (logUsu.equals("")) {
            JOptionPane.showMessageDialog(null, "Campo de pesquisa vazio. Não foi possível realizar a consulta.\n"
                    + "Para realizar a consulta digite o login do sistema desejado.");
        } else {
            atualizarTabela();
            TbUsuario.setEnabled(true);
        }
    }//GEN-LAST:event_BtConsultarActionPerformed

    private void jCheckCadastrarMoradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarMoradoresActionPerformed

        if (jCheckCadastrarMoradores.isSelected()) {
            Perm_Menu_Moradores = "Sim";
        } else {
            Perm_Menu_Moradores = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarMoradoresActionPerformed

    private void jCheckCadastrarHospedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarHospedesActionPerformed

        if (jCheckCadastrarHospedes.isSelected()) {
            Perm_Menu_Hospedes = "Sim";
        } else {
            Perm_Menu_Hospedes = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarHospedesActionPerformed

    private void jCheckCadastrarVisitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarVisitantesActionPerformed

        if (jCheckCadastrarVisitantes.isSelected()) {
            Perm_Menu_Visitantes = "Sim";
        } else {
            Perm_Menu_Visitantes = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarVisitantesActionPerformed

    private void jCheckCadastrarPrestadoresServiçosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarPrestadoresServiçosActionPerformed

        if (jCheckCadastrarPrestadoresServiços.isSelected()) {
            Perm_Menu_PrestServicos = "Sim";
        } else {
            Perm_Menu_PrestServicos = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarPrestadoresServiçosActionPerformed

    private void jCheckCadastrarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarFuncionariosActionPerformed

        if (jCheckCadastrarFuncionarios.isSelected()) {
            Perm_Menu_Funcionarios = "Sim";
        } else {
            Perm_Menu_Funcionarios = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarFuncionariosActionPerformed

    private void jCheckCadastrarChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarChavesActionPerformed

        if (jCheckCadastrarChaves.isSelected()) {
            Perm_Menu_Chaves = "Sim";
        } else {
            Perm_Menu_Chaves = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarChavesActionPerformed

    private void jCheckControleAcessoVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckControleAcessoVeiculosActionPerformed

        if (jCheckControleAcessoVeiculos.isSelected()) {
            Perm_Menu_CtrlAcessoVeiculos = "Sim";
        } else {
            Perm_Menu_CtrlAcessoVeiculos = "Não";
        }
    }//GEN-LAST:event_jCheckControleAcessoVeiculosActionPerformed

    private void jCheckConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckConsultasActionPerformed

        if (jCheckConsultas.isSelected()) {
            Perm_Menu_ConsPortaria = "Sim";
        } else {
            Perm_Menu_ConsPortaria = "Não";
        }
    }//GEN-LAST:event_jCheckConsultasActionPerformed

    private void jCheckControleAcessoPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckControleAcessoPessoasActionPerformed

        if (jCheckControleAcessoPessoas.isSelected()) {
            Perm_Menu_CtrlAcessoPessoas = "Sim";
        } else {
            Perm_Menu_CtrlAcessoPessoas = "Não";
        }
    }//GEN-LAST:event_jCheckControleAcessoPessoasActionPerformed

    private void jCheckControleChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckControleChavesActionPerformed

        if (jCheckControleChaves.isSelected()) {
            Perm_Menu_CtrlChaves = "Sim";
        } else {
            Perm_Menu_CtrlChaves = "Não";
        }
    }//GEN-LAST:event_jCheckControleChavesActionPerformed

    private void jCheckAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAgendaActionPerformed

        if (jCheckAgenda.isSelected()) {
            Perm_Menu_Agenda = "Sim";
        } else {
            Perm_Menu_Agenda = "Não";
        }
    }//GEN-LAST:event_jCheckAgendaActionPerformed

    private void jCheckLembretesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckLembretesActionPerformed

        if (jCheckLembretes.isSelected()) {
            Perm_Menu_Lembretes = "Sim";
        } else {
            Perm_Menu_Lembretes = "Não";
        }
    }//GEN-LAST:event_jCheckLembretesActionPerformed

    private void jCheckAlterarSenhaSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAlterarSenhaSistemaActionPerformed

        if (jCheckAlterarSenhaSistema.isSelected()) {
            Perm_Menu_AltSenhaSistema = "Sim";
        } else {
            Perm_Menu_AltSenhaSistema = "Não";
        }
    }//GEN-LAST:event_jCheckAlterarSenhaSistemaActionPerformed

    private void jCheckAlterarSenhaPorteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckAlterarSenhaPorteiroActionPerformed

        if (jCheckAlterarSenhaPorteiro.isSelected()) {
            Perm_Menu_AltSenhaPorteiro = "Sim";
        } else {
            Perm_Menu_AltSenhaPorteiro = "Não";
        }
    }//GEN-LAST:event_jCheckAlterarSenhaPorteiroActionPerformed

    private void jCheckCadastarPorteirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastarPorteirosActionPerformed

        if (jCheckCadastarPorteiros.isSelected()) {
            Perm_Menu_Porteiros = "Sim";
        } else {
            Perm_Menu_Porteiros = "Não";
        }
    }//GEN-LAST:event_jCheckCadastarPorteirosActionPerformed

    private void jCheckCadastrarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarVeiculosActionPerformed

        if (jCheckCadastrarVeiculos.isSelected()) {
            Perm_Menu_Veiculos = "Sim";
        } else {
            Perm_Menu_Veiculos = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarVeiculosActionPerformed

    private void jCheckCadastrarEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckCadastrarEmpresasActionPerformed

        if (jCheckCadastrarEmpresas.isSelected()) {
            Perm_Menu_Empresas = "Sim";
        } else {
            Perm_Menu_Veiculos = "Não";
        }
    }//GEN-LAST:event_jCheckCadastrarEmpresasActionPerformed

    public void preencherTabelaUsu(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Login Usuário", "Tipo Usuário"};
        conUsuario.conexao();
        conUsuario.executaSQL(SQL);
        try {
            conUsuario.rs.first();
            do {
                dados.add(new Object[]{conUsuario.rs.getString("login_usu"), conUsuario.rs.getString("descricao_tipo_usu")});
            } while (conUsuario.rs.next());
        } catch (SQLException ex) {
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbUsuario.setModel(modTabela);
        TbUsuario.getColumnModel().getColumn(0).setPreferredWidth(208);
        TbUsuario.getColumnModel().getColumn(0).setResizable(false);
        TbUsuario.getColumnModel().getColumn(1).setPreferredWidth(208);
        TbUsuario.getColumnModel().getColumn(1).setResizable(false);
        TbUsuario.getTableHeader().setReorderingAllowed(false);
        TbUsuario.setAutoResizeMode(TbUsuario.AUTO_RESIZE_OFF);
        TbUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conUsuario.desconecta();
    }

    public void limparTabelaUsuario(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Login Usuário", "Tipo Usuário"};
        dados.add(new Object[]{"", ""});

        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbUsuario.setModel(modTabela);
        TbUsuario.getColumnModel().getColumn(0).setPreferredWidth(208);
        TbUsuario.getColumnModel().getColumn(0).setResizable(false);
        TbUsuario.getColumnModel().getColumn(1).setPreferredWidth(208);
        TbUsuario.getColumnModel().getColumn(1).setResizable(false);
        TbUsuario.getTableHeader().setReorderingAllowed(false);
        TbUsuario.setAutoResizeMode(TbUsuario.AUTO_RESIZE_OFF);
        TbUsuario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtAdicionar;
    private javax.swing.JButton BtAlterar;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtExcluir;
    private javax.swing.JButton BtSalvar;
    private javax.swing.JComboBox CbTipoUsuario;
    private javax.swing.JPasswordField PwdTfSenhaUsuario;
    private javax.swing.JTable TbUsuario;
    private javax.swing.JTextField TfLoginUsuario;
    private javax.swing.JCheckBox jCheckAgenda;
    private javax.swing.JCheckBox jCheckAlterarSenhaPorteiro;
    private javax.swing.JCheckBox jCheckAlterarSenhaSistema;
    private javax.swing.JCheckBox jCheckCadastarPorteiros;
    private javax.swing.JCheckBox jCheckCadastrarChaves;
    private javax.swing.JCheckBox jCheckCadastrarEmpresas;
    private javax.swing.JCheckBox jCheckCadastrarFuncionarios;
    private javax.swing.JCheckBox jCheckCadastrarHospedes;
    private javax.swing.JCheckBox jCheckCadastrarMoradores;
    private javax.swing.JCheckBox jCheckCadastrarPrestadoresServiços;
    private javax.swing.JCheckBox jCheckCadastrarVeiculos;
    private javax.swing.JCheckBox jCheckCadastrarVisitantes;
    private javax.swing.JCheckBox jCheckConsultas;
    private javax.swing.JCheckBox jCheckControleAcessoPessoas;
    private javax.swing.JCheckBox jCheckControleAcessoVeiculos;
    private javax.swing.JCheckBox jCheckControleChaves;
    private javax.swing.JCheckBox jCheckLembretes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Panel panel1;
    // End of variables declaration//GEN-END:variables
}

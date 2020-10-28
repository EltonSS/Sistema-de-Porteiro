package VisaoTelaPrincipal;

import visaoSistema.FrmTiposAgendas;
import ControleSistema.ConectaBanco;
import visaoSistema.*;
import VisaoPortaria.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {

    ConectaBanco conUsuario = new ConectaBanco();
    ConectaBanco conTpUsuario = new ConectaBanco();
    ConectaBanco conLembrete = new ConectaBanco();
    String datahoje, horahoje, descTpUsuario;
    int permitido = 1;

    public TelaPrincipal(String Usuario) throws SQLException, ParseException {

        initComponents();
        dataSistema();
        horaSistema();
        LbNomeUsuario.setText(Usuario);
        tipoUsuario();
        PermissoesSistema(Usuario);
        Lembrete();
    }

    public void dataSistema() throws SQLException {

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        Date hoje = new Date();
        datahoje = df.format(hoje);
        LbDataAcesso.setText(String.valueOf(datahoje));
    }

    public void horaSistema() throws SQLException {

        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date hora = new Date();
        horahoje = df.format(hora);
        LbHoraAcesso.setText(horahoje);
    }

    public void Lembrete() throws SQLException {

        conLembrete.conexao();
        conLembrete.executaSQL("select * from tab_lembrete");
        conLembrete.rs.first();
        do {
            if (datahoje.equals(conLembrete.rs.getString("Data_Lembrete"))) {
                JOptionPane.showMessageDialog(rootPane, "Lembrete : " + conLembrete.rs.getString("Titulo_Assunto_Lembrete")
                        + "\n" + conLembrete.rs.getString("Descricao_Lembrete"));
            }
        } while (conLembrete.rs.next());
    }

    public void tipoUsuario() {

        conTpUsuario.conexao();
        try {
            conTpUsuario.executaSQL("select * from vw_usuario where login_usu ='" + LbNomeUsuario.getText() + "'");
            conTpUsuario.rs.first();
            if (conTpUsuario.rs.getString("descricao_tipo_usu").equals("super")) {
                LbDescTpUsuario.setText("Super Usuário");
            } else {
                if (conTpUsuario.rs.getString("descricao_tipo_usu").equals("gerente")) {
                    LbDescTpUsuario.setText("Gerente");
                } else {
                    if (conTpUsuario.rs.getString("descricao_tipo_usu").equals("porteiro")) {
                        LbDescTpUsuario.setText("Porteiro");
                    }
                }
            }
        } catch (SQLException ex) {
            //Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void PermissoesSistema(String Usu) {

        conUsuario.conexao();
        conUsuario.executaSQL("select * from vw_usuario where login_usu ='" + Usu + "'");
        try {
            conUsuario.rs.first();
            if (conUsuario.rs.getString("descricao_tipo_usu").equals("super")) {
                arvoreSistema.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Mor").equals("Sim")) {
                BtMoradores.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Hosp").equals("Sim")) {
                BtHospedes.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Vis").equals("Sim")) {
                BtVisitantes.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_PrestServ").equals("Sim")) {
                BtPrestadoresServicos.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Func").equals("Sim")) {
                BtFuncionariosHt.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Port").equals("Sim")) {
                BtPorteiro.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Veic").equals("Sim")) {
                BtVeiculo.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Chav").equals("Sim")) {
                BtChaves.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Emp").equals("Sim")) {
                BtEmpresas.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCons_Port").equals("Sim")) {
                BtConsultasPortaria.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCtrl_AcessoVeic").equals("Sim")) {
                BtControleAcessoVeiculo.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCtrl_AcessoPs").equals("Sim")) {
                BtControleAcessoPessoa.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCtrl_Chav").equals("Sim")) {
                BtControleChaves.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Lembrete").equals("Sim")) {
                BtLembrete.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuCad_Agenda").equals("Sim")) {
                BtAgenda.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuAlt_SenhaSist").equals("Sim")) {
                BtAlterarSenhaSistema.setEnabled(true);
            }
            if (conUsuario.rs.getString("Perm_MenuAlt_SenhaPort").equals("Sim")) {
                BtAlterarSenhaPorteiro.setEnabled(true);
            }
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Você não tem acesso ao sistema, entre em contato com administrador!!");
        }
        conUsuario.desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GpbtAberturaChamados = new javax.swing.ButtonGroup();
        GpbtAlmoxarifado = new javax.swing.ButtonGroup();
        GpbtPortaria = new javax.swing.ButtonGroup();
        jTabbedPanelSistemaPortaria = new javax.swing.JTabbedPane();
        Ajuda1 = new javax.swing.JPanel();
        TbCadastros1 = new javax.swing.JToolBar();
        BtAlterarSenhaSistema = new javax.swing.JButton();
        BtAlterarSenhaPorteiro = new javax.swing.JButton();
        BtAgenda = new javax.swing.JButton();
        BtLembrete = new javax.swing.JButton();
        areaTrabalhoSistema = new javax.swing.JDesktopPane();
        jLabel9 = new javax.swing.JLabel();
        Cadastros = new javax.swing.JPanel();
        areaTrabalhoCadastros = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();
        TbCadastros = new javax.swing.JToolBar();
        BtMoradores = new javax.swing.JButton();
        BtHospedes = new javax.swing.JButton();
        BtVisitantes = new javax.swing.JButton();
        BtPrestadoresServicos = new javax.swing.JButton();
        BtFuncionariosHt = new javax.swing.JButton();
        BtPorteiro = new javax.swing.JButton();
        BtVeiculo = new javax.swing.JButton();
        BtChaves = new javax.swing.JButton();
        BtEmpresas = new javax.swing.JButton();
        Portaria = new javax.swing.JPanel();
        areaTrabalhoPorteiro = new javax.swing.JDesktopPane();
        jLabel6 = new javax.swing.JLabel();
        TbControles1 = new javax.swing.JToolBar();
        BtControleAcessoVeiculo = new javax.swing.JButton();
        BtControleAcessoPessoa = new javax.swing.JButton();
        BtControleChaves = new javax.swing.JButton();
        Consultas = new javax.swing.JPanel();
        TbCadastros2 = new javax.swing.JToolBar();
        BtConsultasPortaria = new javax.swing.JButton();
        BtConsultasEntradaSaidaVeiculos = new javax.swing.JButton();
        BtConsultasEntradaSaidaPessoas = new javax.swing.JButton();
        BtConsultasEntradaSaidaChaves = new javax.swing.JButton();
        areaTrabalhoConsultas = new javax.swing.JDesktopPane();
        jLabel11 = new javax.swing.JLabel();
        ParametrosSistema = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        arvoreSistema = new javax.swing.JTree();
        areaTrabalhoParametroSistema = new javax.swing.JDesktopPane();
        jLabel10 = new javax.swing.JLabel();
        ParametrosSistema2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        arvoreAjuda = new javax.swing.JTree();
        areaTrabalhoAjuda = new javax.swing.JDesktopPane();
        jLabel17 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jToolBar4 = new javax.swing.JToolBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        BtSairSistema = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jPanel1 = new javax.swing.JPanel();
        LbUsuario = new javax.swing.JLabel();
        LbNomeUsuario = new javax.swing.JLabel();
        LbTpUsuario = new javax.swing.JLabel();
        LbDescTpUsuario = new javax.swing.JLabel();
        LbData = new javax.swing.JLabel();
        LbDataAcesso = new javax.swing.JLabel();
        LbHora = new javax.swing.JLabel();
        LbHoraAcesso = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        Ajuda2 = new javax.swing.JPanel();
        TbCadastros3 = new javax.swing.JToolBar();
        BtAlterarSenhaSistema1 = new javax.swing.JButton();
        BtAlterarSenhaPorteiro1 = new javax.swing.JButton();
        BtAgenda1 = new javax.swing.JButton();
        BtLembrete1 = new javax.swing.JButton();
        areaTrabalhoSistema1 = new javax.swing.JDesktopPane();
        jLabel12 = new javax.swing.JLabel();
        Cadastros1 = new javax.swing.JPanel();
        areaTrabalhoCadastros1 = new javax.swing.JDesktopPane();
        jLabel5 = new javax.swing.JLabel();
        TbCadastros4 = new javax.swing.JToolBar();
        BtMoradores1 = new javax.swing.JButton();
        BtHospedes1 = new javax.swing.JButton();
        BtVisitantes1 = new javax.swing.JButton();
        BtPrestadoresServicos1 = new javax.swing.JButton();
        BtFuncionariosHt1 = new javax.swing.JButton();
        BtPorteiro1 = new javax.swing.JButton();
        BtVeiculo1 = new javax.swing.JButton();
        BtChaves1 = new javax.swing.JButton();
        BtEmpresas1 = new javax.swing.JButton();
        Consultas1 = new javax.swing.JPanel();
        TbCadastros5 = new javax.swing.JToolBar();
        BtConsultasPortaria1 = new javax.swing.JButton();
        areaTrabalhoConsultas1 = new javax.swing.JDesktopPane();
        jLabel13 = new javax.swing.JLabel();
        Portaria1 = new javax.swing.JPanel();
        areaTrabalhoPorteiro1 = new javax.swing.JDesktopPane();
        jLabel14 = new javax.swing.JLabel();
        TbControles2 = new javax.swing.JToolBar();
        BtControleAcessoVeiculo1 = new javax.swing.JButton();
        BtControleAcessoPessoa1 = new javax.swing.JButton();
        BtControleChaves1 = new javax.swing.JButton();
        ParametrosSistema1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        arvoreSistema1 = new javax.swing.JTree();
        areaTrabalhoParametroSistema1 = new javax.swing.JDesktopPane();
        jLabel15 = new javax.swing.JLabel();
        Ajuda3 = new javax.swing.JPanel();
        areaTrabalhoPortaria4 = new javax.swing.JDesktopPane();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Abertura de Chamados");
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1080, 640));
        setUndecorated(true);
        setResizable(false);

        jTabbedPanelSistemaPortaria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        Ajuda1.setEnabled(false);

        TbCadastros1.setBackground(new java.awt.Color(255, 255, 255));
        TbCadastros1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbCadastros1.setForeground(new java.awt.Color(255, 255, 255));
        TbCadastros1.setRollover(true);

        BtAlterarSenhaSistema.setBackground(new java.awt.Color(255, 255, 255));
        BtAlterarSenhaSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAlteraSenhaSistema.png"))); // NOI18N
        BtAlterarSenhaSistema.setToolTipText("Aterar Senha do Sistema");
        BtAlterarSenhaSistema.setBorderPainted(false);
        GpbtPortaria.add(BtAlterarSenhaSistema);
        BtAlterarSenhaSistema.setEnabled(false);
        BtAlterarSenhaSistema.setFocusable(false);
        BtAlterarSenhaSistema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtAlterarSenhaSistema.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtAlterarSenhaSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarSenhaSistemaActionPerformed(evt);
            }
        });
        TbCadastros1.add(BtAlterarSenhaSistema);

        BtAlterarSenhaPorteiro.setBackground(new java.awt.Color(255, 255, 255));
        BtAlterarSenhaPorteiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAlteraSenhaPorteiro.png"))); // NOI18N
        BtAlterarSenhaPorteiro.setToolTipText("Alterar Senha do Porteiro");
        BtAlterarSenhaPorteiro.setBorderPainted(false);
        GpbtPortaria.add(BtAlterarSenhaPorteiro);
        BtAlterarSenhaPorteiro.setEnabled(false);
        BtAlterarSenhaPorteiro.setFocusable(false);
        BtAlterarSenhaPorteiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtAlterarSenhaPorteiro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtAlterarSenhaPorteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarSenhaPorteiroActionPerformed(evt);
            }
        });
        TbCadastros1.add(BtAlterarSenhaPorteiro);

        BtAgenda.setBackground(new java.awt.Color(255, 255, 255));
        BtAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAgenda.png"))); // NOI18N
        BtAgenda.setToolTipText("Agenda");
        BtAgenda.setBorderPainted(false);
        GpbtPortaria.add(BtAgenda);
        BtAgenda.setEnabled(false);
        BtAgenda.setFocusable(false);
        BtAgenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtAgenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAgendaActionPerformed(evt);
            }
        });
        TbCadastros1.add(BtAgenda);

        BtLembrete.setBackground(new java.awt.Color(255, 255, 255));
        BtLembrete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuLembrete.png"))); // NOI18N
        BtLembrete.setToolTipText("Lembrete");
        BtLembrete.setBorderPainted(false);
        GpbtPortaria.add(BtLembrete);
        BtLembrete.setEnabled(false);
        BtLembrete.setFocusable(false);
        BtLembrete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtLembrete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtLembrete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLembreteActionPerformed(evt);
            }
        });
        TbCadastros1.add(BtLembrete);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoSistema.add(jLabel9);
        jLabel9.setBounds(0, 0, 1370, 560);

        javax.swing.GroupLayout Ajuda1Layout = new javax.swing.GroupLayout(Ajuda1);
        Ajuda1.setLayout(Ajuda1Layout);
        Ajuda1Layout.setHorizontalGroup(
            Ajuda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(Ajuda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Ajuda1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TbCadastros1, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(Ajuda1Layout.createSequentialGroup()
                    .addComponent(areaTrabalhoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE)))
        );
        Ajuda1Layout.setVerticalGroup(
            Ajuda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(Ajuda1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Ajuda1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TbCadastros1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(areaTrabalhoSistema, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPanelSistemaPortaria.addTab("Sistema", Ajuda1);

        Cadastros.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoCadastros.add(jLabel3);
        jLabel3.setBounds(0, 0, 1370, 560);

        Cadastros.add(areaTrabalhoCadastros);
        areaTrabalhoCadastros.setBounds(0, 45, 1370, 590);

        TbCadastros.setBackground(new java.awt.Color(255, 255, 255));
        TbCadastros.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbCadastros.setForeground(new java.awt.Color(255, 255, 255));
        TbCadastros.setRollover(true);

        BtMoradores.setBackground(new java.awt.Color(255, 255, 255));
        BtMoradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuMorador.png"))); // NOI18N
        BtMoradores.setToolTipText("Cadastrar Moradores");
        BtMoradores.setBorder(null);
        BtMoradores.setBorderPainted(false);
        GpbtPortaria.add(BtMoradores);
        BtMoradores.setEnabled(false);
        BtMoradores.setFocusable(false);
        BtMoradores.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtMoradores.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtMoradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtMoradoresActionPerformed(evt);
            }
        });
        TbCadastros.add(BtMoradores);

        BtHospedes.setBackground(new java.awt.Color(255, 255, 255));
        BtHospedes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuHospede.png"))); // NOI18N
        BtHospedes.setToolTipText("Cadastrar Hóspedes");
        BtHospedes.setBorder(null);
        BtHospedes.setBorderPainted(false);
        GpbtPortaria.add(BtHospedes);
        BtHospedes.setEnabled(false);
        BtHospedes.setFocusable(false);
        BtHospedes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtHospedes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtHospedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtHospedesActionPerformed(evt);
            }
        });
        TbCadastros.add(BtHospedes);

        BtVisitantes.setBackground(new java.awt.Color(255, 255, 255));
        BtVisitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuVisitante.png"))); // NOI18N
        BtVisitantes.setToolTipText("Cadastrar Visitantes");
        BtVisitantes.setBorder(null);
        BtVisitantes.setBorderPainted(false);
        GpbtPortaria.add(BtVisitantes);
        BtVisitantes.setEnabled(false);
        BtVisitantes.setFocusable(false);
        BtVisitantes.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtVisitantes.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtVisitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVisitantesActionPerformed(evt);
            }
        });
        TbCadastros.add(BtVisitantes);

        BtPrestadoresServicos.setBackground(new java.awt.Color(255, 255, 255));
        BtPrestadoresServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuPrestadorServico.png"))); // NOI18N
        BtPrestadoresServicos.setToolTipText("Cadastrar Prestadores de Serviços");
        BtPrestadoresServicos.setBorder(null);
        BtPrestadoresServicos.setBorderPainted(false);
        GpbtPortaria.add(BtPrestadoresServicos);
        BtPrestadoresServicos.setEnabled(false);
        BtPrestadoresServicos.setFocusable(false);
        BtPrestadoresServicos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtPrestadoresServicos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtPrestadoresServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPrestadoresServicosActionPerformed(evt);
            }
        });
        TbCadastros.add(BtPrestadoresServicos);

        BtFuncionariosHt.setBackground(new java.awt.Color(255, 255, 255));
        BtFuncionariosHt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuFuncionario.png"))); // NOI18N
        BtFuncionariosHt.setToolTipText("Cadastrar Funcionários");
        BtFuncionariosHt.setBorder(null);
        BtFuncionariosHt.setBorderPainted(false);
        GpbtPortaria.add(BtFuncionariosHt);
        BtFuncionariosHt.setEnabled(false);
        BtFuncionariosHt.setFocusable(false);
        BtFuncionariosHt.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtFuncionariosHt.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtFuncionariosHt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtFuncionariosHtActionPerformed(evt);
            }
        });
        TbCadastros.add(BtFuncionariosHt);

        BtPorteiro.setBackground(new java.awt.Color(255, 255, 255));
        BtPorteiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuPorteiro.png"))); // NOI18N
        BtPorteiro.setToolTipText("Cadastrar Porteiros");
        BtPorteiro.setBorder(null);
        BtPorteiro.setBorderPainted(false);
        GpbtPortaria.add(BtPorteiro);
        BtPorteiro.setEnabled(false);
        BtPorteiro.setFocusable(false);
        BtPorteiro.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtPorteiro.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtPorteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPorteiroActionPerformed(evt);
            }
        });
        TbCadastros.add(BtPorteiro);

        BtVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        BtVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAdicionarVeiculo.png"))); // NOI18N
        BtVeiculo.setToolTipText("Cadastrar Veículos");
        BtVeiculo.setBorder(null);
        BtVeiculo.setBorderPainted(false);
        GpbtPortaria.add(BtVeiculo);
        BtVeiculo.setEnabled(false);
        BtVeiculo.setFocusable(false);
        BtVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVeiculoActionPerformed(evt);
            }
        });
        TbCadastros.add(BtVeiculo);

        BtChaves.setBackground(new java.awt.Color(255, 255, 255));
        BtChaves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuChaves.png"))); // NOI18N
        BtChaves.setToolTipText("Cadastrar Chaves");
        BtChaves.setBorder(null);
        BtChaves.setBorderPainted(false);
        GpbtPortaria.add(BtChaves);
        BtChaves.setEnabled(false);
        BtChaves.setFocusable(false);
        BtChaves.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtChaves.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtChavesActionPerformed(evt);
            }
        });
        TbCadastros.add(BtChaves);

        BtEmpresas.setBackground(new java.awt.Color(255, 255, 255));
        BtEmpresas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuEmpresa.png"))); // NOI18N
        BtEmpresas.setToolTipText("Cadastrar Empresas");
        BtEmpresas.setBorder(null);
        BtEmpresas.setBorderPainted(false);
        GpbtPortaria.add(BtEmpresas);
        BtEmpresas.setEnabled(false);
        BtEmpresas.setFocusable(false);
        BtEmpresas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtEmpresas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtEmpresas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEmpresasActionPerformed(evt);
            }
        });
        TbCadastros.add(BtEmpresas);

        Cadastros.add(TbCadastros);
        TbCadastros.setBounds(0, 0, 1360, 40);

        jTabbedPanelSistemaPortaria.addTab("Cadastros", Cadastros);

        Portaria.setLayout(null);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoPorteiro.add(jLabel6);
        jLabel6.setBounds(0, 0, 1370, 560);

        Portaria.add(areaTrabalhoPorteiro);
        areaTrabalhoPorteiro.setBounds(0, 45, 1360, 590);

        TbControles1.setBackground(new java.awt.Color(255, 255, 255));
        TbControles1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbControles1.setForeground(new java.awt.Color(255, 255, 255));
        TbControles1.setRollover(true);

        BtControleAcessoVeiculo.setBackground(new java.awt.Color(255, 255, 255));
        BtControleAcessoVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuControleAcessoVeiculos.png"))); // NOI18N
        BtControleAcessoVeiculo.setToolTipText("Controle de Acesso dos Veículos");
        BtControleAcessoVeiculo.setBorderPainted(false);
        GpbtPortaria.add(BtControleAcessoVeiculo);
        BtControleAcessoVeiculo.setEnabled(false);
        BtControleAcessoVeiculo.setFocusable(false);
        BtControleAcessoVeiculo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtControleAcessoVeiculo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtControleAcessoVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtControleAcessoVeiculoActionPerformed(evt);
            }
        });
        TbControles1.add(BtControleAcessoVeiculo);

        BtControleAcessoPessoa.setBackground(new java.awt.Color(255, 255, 255));
        BtControleAcessoPessoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuControleAcessoPessoas.png"))); // NOI18N
        BtControleAcessoPessoa.setToolTipText("Controle de Acesso de Pessoas");
        BtControleAcessoPessoa.setBorderPainted(false);
        GpbtPortaria.add(BtControleAcessoPessoa);
        BtControleAcessoPessoa.setEnabled(false);
        BtControleAcessoPessoa.setFocusable(false);
        BtControleAcessoPessoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtControleAcessoPessoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtControleAcessoPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtControleAcessoPessoaActionPerformed(evt);
            }
        });
        TbControles1.add(BtControleAcessoPessoa);

        BtControleChaves.setBackground(new java.awt.Color(255, 255, 255));
        BtControleChaves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuControleChaves.png"))); // NOI18N
        BtControleChaves.setToolTipText("Controle de Saída de Chaves");
        BtControleChaves.setBorderPainted(false);
        GpbtPortaria.add(BtControleChaves);
        BtControleChaves.setEnabled(false);
        BtControleChaves.setFocusable(false);
        BtControleChaves.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtControleChaves.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtControleChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtControleChavesActionPerformed(evt);
            }
        });
        TbControles1.add(BtControleChaves);

        Portaria.add(TbControles1);
        TbControles1.setBounds(0, 0, 1360, 40);

        jTabbedPanelSistemaPortaria.addTab("Porteiro", Portaria);

        Consultas.setEnabled(false);

        TbCadastros2.setBackground(new java.awt.Color(255, 255, 255));
        TbCadastros2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbCadastros2.setForeground(new java.awt.Color(255, 255, 255));
        TbCadastros2.setRollover(true);

        BtConsultasPortaria.setBackground(new java.awt.Color(255, 255, 255));
        BtConsultasPortaria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuConsultaTodosCadastros.png"))); // NOI18N
        BtConsultasPortaria.setToolTipText("Consultar Todos os Cadastros");
        BtConsultasPortaria.setAutoscrolls(true);
        BtConsultasPortaria.setBorderPainted(false);
        GpbtPortaria.add(BtConsultasPortaria);
        BtConsultasPortaria.setEnabled(false);
        BtConsultasPortaria.setFocusable(false);
        BtConsultasPortaria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtConsultasPortaria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtConsultasPortaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultasPortariaActionPerformed(evt);
            }
        });
        TbCadastros2.add(BtConsultasPortaria);

        BtConsultasEntradaSaidaVeiculos.setBackground(new java.awt.Color(255, 255, 255));
        BtConsultasEntradaSaidaVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuConsultaEntradaVeiculos.png"))); // NOI18N
        BtConsultasEntradaSaidaVeiculos.setToolTipText("Consultar Entrada e Saida de Veículos");
        BtConsultasEntradaSaidaVeiculos.setBorderPainted(false);
        GpbtPortaria.add(BtConsultasEntradaSaidaVeiculos);
        BtConsultasEntradaSaidaVeiculos.setFocusable(false);
        BtConsultasEntradaSaidaVeiculos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtConsultasEntradaSaidaVeiculos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtConsultasEntradaSaidaVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultasEntradaSaidaVeiculosActionPerformed(evt);
            }
        });
        TbCadastros2.add(BtConsultasEntradaSaidaVeiculos);

        BtConsultasEntradaSaidaPessoas.setBackground(new java.awt.Color(255, 255, 255));
        BtConsultasEntradaSaidaPessoas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuConsultaPessoas.png"))); // NOI18N
        BtConsultasEntradaSaidaPessoas.setToolTipText("Consultar Entrada e Saida de Pessoas");
        BtConsultasEntradaSaidaPessoas.setBorderPainted(false);
        GpbtPortaria.add(BtConsultasEntradaSaidaPessoas);
        BtConsultasEntradaSaidaPessoas.setFocusable(false);
        BtConsultasEntradaSaidaPessoas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtConsultasEntradaSaidaPessoas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtConsultasEntradaSaidaPessoas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultasEntradaSaidaPessoasActionPerformed(evt);
            }
        });
        TbCadastros2.add(BtConsultasEntradaSaidaPessoas);

        BtConsultasEntradaSaidaChaves.setBackground(new java.awt.Color(255, 255, 255));
        BtConsultasEntradaSaidaChaves.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuConsultaChaves.png"))); // NOI18N
        BtConsultasEntradaSaidaChaves.setToolTipText("Consultar Entrada e Saida de Chaves");
        BtConsultasEntradaSaidaChaves.setBorderPainted(false);
        GpbtPortaria.add(BtConsultasEntradaSaidaChaves);
        BtConsultasEntradaSaidaChaves.setFocusable(false);
        BtConsultasEntradaSaidaChaves.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtConsultasEntradaSaidaChaves.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtConsultasEntradaSaidaChaves.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultasEntradaSaidaChavesActionPerformed(evt);
            }
        });
        TbCadastros2.add(BtConsultasEntradaSaidaChaves);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoConsultas.add(jLabel11);
        jLabel11.setBounds(0, 0, 1370, 560);

        javax.swing.GroupLayout ConsultasLayout = new javax.swing.GroupLayout(Consultas);
        Consultas.setLayout(ConsultasLayout);
        ConsultasLayout.setHorizontalGroup(
            ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ConsultasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TbCadastros2, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(areaTrabalhoConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        ConsultasLayout.setVerticalGroup(
            ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(ConsultasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ConsultasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TbCadastros2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(areaTrabalhoConsultas, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPanelSistemaPortaria.addTab("Consultas/Relatórios", Consultas);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cadastros");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Apartamentos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Cores");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Torres");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Marcas de Veículos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Modelos de Veículos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Usuários do Sistema");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Ramais Administrativo");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Setores");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Parâmetros");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipos de Empresas");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipos de Pessoas");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipos de Usuários do Sistema");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipos de Agendas");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        arvoreSistema.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arvoreSistema.setEnabled(false);
        arvoreSistema.setRootVisible(false);
        arvoreSistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arvoreSistemaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(arvoreSistema);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoParametroSistema.add(jLabel10);
        jLabel10.setBounds(180, 0, 1190, 590);

        javax.swing.GroupLayout ParametrosSistemaLayout = new javax.swing.GroupLayout(ParametrosSistema);
        ParametrosSistema.setLayout(ParametrosSistemaLayout);
        ParametrosSistemaLayout.setHorizontalGroup(
            ParametrosSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParametrosSistemaLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1180, Short.MAX_VALUE))
            .addGroup(ParametrosSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(areaTrabalhoParametroSistema, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE))
        );
        ParametrosSistemaLayout.setVerticalGroup(
            ParametrosSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParametrosSistemaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(ParametrosSistemaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParametrosSistemaLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(areaTrabalhoParametroSistema, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
        );

        jTabbedPanelSistemaPortaria.addTab("Parâmetros do Sitema", ParametrosSistema);

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Sobre o Sistema");
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Manual");
        treeNode1.add(treeNode2);
        arvoreAjuda.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arvoreAjuda.setEnabled(false);
        arvoreAjuda.setRootVisible(false);
        jScrollPane5.setViewportView(arvoreAjuda);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoAjuda.add(jLabel17);
        jLabel17.setBounds(0, 0, 1370, 590);

        javax.swing.GroupLayout ParametrosSistema2Layout = new javax.swing.GroupLayout(ParametrosSistema2);
        ParametrosSistema2.setLayout(ParametrosSistema2Layout);
        ParametrosSistema2Layout.setHorizontalGroup(
            ParametrosSistema2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParametrosSistema2Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1180, Short.MAX_VALUE))
            .addGroup(ParametrosSistema2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParametrosSistema2Layout.createSequentialGroup()
                    .addGap(0, 183, Short.MAX_VALUE)
                    .addComponent(areaTrabalhoAjuda, javax.swing.GroupLayout.PREFERRED_SIZE, 1181, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        ParametrosSistema2Layout.setVerticalGroup(
            ParametrosSistema2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParametrosSistema2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
            .addGroup(ParametrosSistema2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ParametrosSistema2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(areaTrabalhoAjuda, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
        );

        jTabbedPanelSistemaPortaria.addTab("Ajuda", ParametrosSistema2);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel2.setForeground(new java.awt.Color(0, 153, 255));
        jPanel2.setLayout(null);

        jToolBar4.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar4.setBorder(null);
        jToolBar4.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar4.setRollover(true);
        jPanel2.add(jToolBar4);
        jToolBar4.setBounds(1257, 2, 0, 40);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Porteiro Versão -2.0 Full");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(830, 10, 130, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sistema de Gestão Operacional Hoteleira");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(450, 10, 720, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 51));
        jLabel4.setText("SGOH - ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(380, 10, 70, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/TopoSistema.png"))); // NOI18N
        jPanel2.add(jLabel1);
        jLabel1.setBounds(-10, 0, 1340, 40);

        BtSairSistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/SairSistema.png"))); // NOI18N
        BtSairSistema.setToolTipText("Sair do Sistema");
        BtSairSistema.setBorder(null);
        BtSairSistema.setBorderPainted(false);
        BtSairSistema.setFocusable(false);
        BtSairSistema.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtSairSistema.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtSairSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtSairSistemaActionPerformed(evt);
            }
        });
        jPanel2.add(BtSairSistema);
        BtSairSistema.setBounds(1330, 0, 39, 39);

        jToolBar3.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar3.setBorder(null);
        jToolBar3.setForeground(new java.awt.Color(255, 255, 255));
        jToolBar3.setRollover(true);

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );

        LbUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LbUsuario.setText("Usuário:");

        LbNomeUsuario.setForeground(new java.awt.Color(0, 0, 255));
        LbNomeUsuario.setText("jLabel12");

        LbTpUsuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LbTpUsuario.setText("Tipo usuário:");

        LbDescTpUsuario.setForeground(new java.awt.Color(0, 0, 255));
        LbDescTpUsuario.setText("jLabel14");

        LbData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LbData.setText("Data:");

        LbDataAcesso.setForeground(new java.awt.Color(0, 0, 255));
        LbDataAcesso.setText("jLabel12");

        LbHora.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        LbHora.setText("Hora");

        LbHoraAcesso.setForeground(new java.awt.Color(0, 0, 255));
        LbHoraAcesso.setText("jLabel14");

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        Ajuda2.setEnabled(false);

        TbCadastros3.setBackground(new java.awt.Color(255, 255, 255));
        TbCadastros3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbCadastros3.setForeground(new java.awt.Color(255, 255, 255));
        TbCadastros3.setRollover(true);

        BtAlterarSenhaSistema1.setBackground(new java.awt.Color(255, 255, 255));
        BtAlterarSenhaSistema1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAlteraSenhaSistema.png"))); // NOI18N
        BtAlterarSenhaSistema1.setToolTipText("Aterar Senha do Sistema");
        BtAlterarSenhaSistema1.setBorderPainted(false);
        GpbtPortaria.add(BtAlterarSenhaSistema1);
        BtAlterarSenhaSistema1.setEnabled(false);
        BtAlterarSenhaSistema1.setFocusable(false);
        BtAlterarSenhaSistema1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtAlterarSenhaSistema1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtAlterarSenhaSistema1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarSenhaSistema1ActionPerformed(evt);
            }
        });
        TbCadastros3.add(BtAlterarSenhaSistema1);

        BtAlterarSenhaPorteiro1.setBackground(new java.awt.Color(255, 255, 255));
        BtAlterarSenhaPorteiro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAlteraSenhaPorteiro.png"))); // NOI18N
        BtAlterarSenhaPorteiro1.setToolTipText("Alterar Senha do Porteiro");
        BtAlterarSenhaPorteiro1.setBorderPainted(false);
        GpbtPortaria.add(BtAlterarSenhaPorteiro1);
        BtAlterarSenhaPorteiro1.setEnabled(false);
        BtAlterarSenhaPorteiro1.setFocusable(false);
        BtAlterarSenhaPorteiro1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtAlterarSenhaPorteiro1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtAlterarSenhaPorteiro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAlterarSenhaPorteiro1ActionPerformed(evt);
            }
        });
        TbCadastros3.add(BtAlterarSenhaPorteiro1);

        BtAgenda1.setBackground(new java.awt.Color(255, 255, 255));
        BtAgenda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAgenda.png"))); // NOI18N
        BtAgenda1.setToolTipText("Agenda");
        BtAgenda1.setBorderPainted(false);
        GpbtPortaria.add(BtAgenda1);
        BtAgenda1.setEnabled(false);
        BtAgenda1.setFocusable(false);
        BtAgenda1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtAgenda1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtAgenda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtAgenda1ActionPerformed(evt);
            }
        });
        TbCadastros3.add(BtAgenda1);

        BtLembrete1.setBackground(new java.awt.Color(255, 255, 255));
        BtLembrete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuLembrete.png"))); // NOI18N
        BtLembrete1.setToolTipText("Lembrete");
        BtLembrete1.setBorderPainted(false);
        GpbtPortaria.add(BtLembrete1);
        BtLembrete1.setEnabled(false);
        BtLembrete1.setFocusable(false);
        BtLembrete1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtLembrete1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtLembrete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtLembrete1ActionPerformed(evt);
            }
        });
        TbCadastros3.add(BtLembrete1);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoSistema1.add(jLabel12);
        jLabel12.setBounds(0, 0, 1370, 560);

        javax.swing.GroupLayout Ajuda2Layout = new javax.swing.GroupLayout(Ajuda2);
        Ajuda2.setLayout(Ajuda2Layout);
        Ajuda2Layout.setHorizontalGroup(
            Ajuda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1364, Short.MAX_VALUE)
            .addGroup(Ajuda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Ajuda2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TbCadastros3, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
                .addGroup(Ajuda2Layout.createSequentialGroup()
                    .addComponent(areaTrabalhoSistema1, javax.swing.GroupLayout.PREFERRED_SIZE, 1362, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 2, Short.MAX_VALUE)))
        );
        Ajuda2Layout.setVerticalGroup(
            Ajuda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(Ajuda2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Ajuda2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TbCadastros3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(areaTrabalhoSistema1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Sistema", Ajuda2);

        Cadastros1.setLayout(null);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoCadastros1.add(jLabel5);
        jLabel5.setBounds(0, 0, 1370, 560);

        Cadastros1.add(areaTrabalhoCadastros1);
        areaTrabalhoCadastros1.setBounds(0, 45, 1370, 590);

        TbCadastros4.setBackground(new java.awt.Color(255, 255, 255));
        TbCadastros4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbCadastros4.setForeground(new java.awt.Color(255, 255, 255));
        TbCadastros4.setRollover(true);

        BtMoradores1.setBackground(new java.awt.Color(255, 255, 255));
        BtMoradores1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuMorador.png"))); // NOI18N
        BtMoradores1.setToolTipText("Cadastrar Moradores");
        BtMoradores1.setBorderPainted(false);
        GpbtPortaria.add(BtMoradores1);
        BtMoradores1.setEnabled(false);
        BtMoradores1.setFocusable(false);
        BtMoradores1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtMoradores1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtMoradores1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtMoradores1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtMoradores1);

        BtHospedes1.setBackground(new java.awt.Color(255, 255, 255));
        BtHospedes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuHospede.png"))); // NOI18N
        BtHospedes1.setToolTipText("Cadastrar Hóspedes");
        BtHospedes1.setBorderPainted(false);
        GpbtPortaria.add(BtHospedes1);
        BtHospedes1.setEnabled(false);
        BtHospedes1.setFocusable(false);
        BtHospedes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtHospedes1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtHospedes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtHospedes1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtHospedes1);

        BtVisitantes1.setBackground(new java.awt.Color(255, 255, 255));
        BtVisitantes1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuVisitante.png"))); // NOI18N
        BtVisitantes1.setToolTipText("Cadastrar Veículos");
        BtVisitantes1.setBorderPainted(false);
        GpbtPortaria.add(BtVisitantes1);
        BtVisitantes1.setEnabled(false);
        BtVisitantes1.setFocusable(false);
        BtVisitantes1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtVisitantes1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtVisitantes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVisitantes1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtVisitantes1);

        BtPrestadoresServicos1.setBackground(new java.awt.Color(255, 255, 255));
        BtPrestadoresServicos1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuPrestadorServico.png"))); // NOI18N
        BtPrestadoresServicos1.setToolTipText("Cadastrar Prestadores de Serviços");
        BtPrestadoresServicos1.setBorderPainted(false);
        GpbtPortaria.add(BtPrestadoresServicos1);
        BtPrestadoresServicos1.setEnabled(false);
        BtPrestadoresServicos1.setFocusable(false);
        BtPrestadoresServicos1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtPrestadoresServicos1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtPrestadoresServicos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPrestadoresServicos1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtPrestadoresServicos1);

        BtFuncionariosHt1.setBackground(new java.awt.Color(255, 255, 255));
        BtFuncionariosHt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuFuncionario.png"))); // NOI18N
        BtFuncionariosHt1.setToolTipText("Cadastrar Funcionários");
        BtFuncionariosHt1.setBorderPainted(false);
        GpbtPortaria.add(BtFuncionariosHt1);
        BtFuncionariosHt1.setEnabled(false);
        BtFuncionariosHt1.setFocusable(false);
        BtFuncionariosHt1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtFuncionariosHt1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtFuncionariosHt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtFuncionariosHt1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtFuncionariosHt1);

        BtPorteiro1.setBackground(new java.awt.Color(255, 255, 255));
        BtPorteiro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuPorteiro.png"))); // NOI18N
        BtPorteiro1.setToolTipText("Cadastrar Porteiros");
        BtPorteiro1.setBorderPainted(false);
        GpbtPortaria.add(BtPorteiro1);
        BtPorteiro1.setEnabled(false);
        BtPorteiro1.setFocusable(false);
        BtPorteiro1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtPorteiro1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtPorteiro1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtPorteiro1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtPorteiro1);

        BtVeiculo1.setBackground(new java.awt.Color(255, 255, 255));
        BtVeiculo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuAdicionarVeiculo.png"))); // NOI18N
        BtVeiculo1.setToolTipText("Cadastrar Veículos");
        BtVeiculo1.setBorderPainted(false);
        GpbtPortaria.add(BtVeiculo1);
        BtVeiculo1.setEnabled(false);
        BtVeiculo1.setFocusable(false);
        BtVeiculo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtVeiculo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtVeiculo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtVeiculo1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtVeiculo1);

        BtChaves1.setBackground(new java.awt.Color(255, 255, 255));
        BtChaves1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuChaves.png"))); // NOI18N
        BtChaves1.setToolTipText("Cadastrar Chaves");
        BtChaves1.setBorderPainted(false);
        GpbtPortaria.add(BtChaves1);
        BtChaves1.setEnabled(false);
        BtChaves1.setFocusable(false);
        BtChaves1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtChaves1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtChaves1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtChaves1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtChaves1);

        BtEmpresas1.setBackground(new java.awt.Color(255, 255, 255));
        BtEmpresas1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuEmpresa.png"))); // NOI18N
        BtEmpresas1.setToolTipText("Cadastrar Empresas");
        BtEmpresas1.setBorderPainted(false);
        GpbtPortaria.add(BtEmpresas1);
        BtEmpresas1.setEnabled(false);
        BtEmpresas1.setFocusable(false);
        BtEmpresas1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtEmpresas1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtEmpresas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEmpresas1ActionPerformed(evt);
            }
        });
        TbCadastros4.add(BtEmpresas1);

        Cadastros1.add(TbCadastros4);
        TbCadastros4.setBounds(0, 0, 1360, 40);

        jTabbedPane2.addTab("Cadastros", Cadastros1);

        Consultas1.setEnabled(false);

        TbCadastros5.setBackground(new java.awt.Color(255, 255, 255));
        TbCadastros5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbCadastros5.setForeground(new java.awt.Color(255, 255, 255));
        TbCadastros5.setRollover(true);

        BtConsultasPortaria1.setBackground(new java.awt.Color(255, 255, 255));
        BtConsultasPortaria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuConsultas.png"))); // NOI18N
        BtConsultasPortaria1.setToolTipText("Consultar");
        BtConsultasPortaria1.setBorderPainted(false);
        GpbtPortaria.add(BtConsultasPortaria1);
        BtConsultasPortaria1.setEnabled(false);
        BtConsultasPortaria1.setFocusable(false);
        BtConsultasPortaria1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtConsultasPortaria1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtConsultasPortaria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultasPortaria1ActionPerformed(evt);
            }
        });
        TbCadastros5.add(BtConsultasPortaria1);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoConsultas1.add(jLabel13);
        jLabel13.setBounds(0, 0, 1370, 560);

        javax.swing.GroupLayout Consultas1Layout = new javax.swing.GroupLayout(Consultas1);
        Consultas1.setLayout(Consultas1Layout);
        Consultas1Layout.setHorizontalGroup(
            Consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1370, Short.MAX_VALUE)
            .addGroup(Consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Consultas1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(Consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(TbCadastros5, javax.swing.GroupLayout.PREFERRED_SIZE, 1360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(areaTrabalhoConsultas1, javax.swing.GroupLayout.PREFERRED_SIZE, 1370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Consultas1Layout.setVerticalGroup(
            Consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
            .addGroup(Consultas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Consultas1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(TbCadastros5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(5, 5, 5)
                    .addComponent(areaTrabalhoConsultas1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Consultas", Consultas1);

        Portaria1.setLayout(null);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoPorteiro1.add(jLabel14);
        jLabel14.setBounds(0, 0, 1370, 560);

        Portaria1.add(areaTrabalhoPorteiro1);
        areaTrabalhoPorteiro1.setBounds(0, 45, 1360, 590);

        TbControles2.setBackground(new java.awt.Color(255, 255, 255));
        TbControles2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        TbControles2.setForeground(new java.awt.Color(255, 255, 255));
        TbControles2.setRollover(true);

        BtControleAcessoVeiculo1.setBackground(new java.awt.Color(255, 255, 255));
        BtControleAcessoVeiculo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuControleAcessoVeiculos.png"))); // NOI18N
        BtControleAcessoVeiculo1.setToolTipText("Controle de Acesso dos Veículos");
        BtControleAcessoVeiculo1.setBorderPainted(false);
        GpbtPortaria.add(BtControleAcessoVeiculo1);
        BtControleAcessoVeiculo1.setEnabled(false);
        BtControleAcessoVeiculo1.setFocusable(false);
        BtControleAcessoVeiculo1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtControleAcessoVeiculo1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtControleAcessoVeiculo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtControleAcessoVeiculo1ActionPerformed(evt);
            }
        });
        TbControles2.add(BtControleAcessoVeiculo1);

        BtControleAcessoPessoa1.setBackground(new java.awt.Color(255, 255, 255));
        BtControleAcessoPessoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuControleAcessoPessoas.png"))); // NOI18N
        BtControleAcessoPessoa1.setToolTipText("Controle de Acesso de Pessoas");
        BtControleAcessoPessoa1.setBorderPainted(false);
        GpbtPortaria.add(BtControleAcessoPessoa1);
        BtControleAcessoPessoa1.setEnabled(false);
        BtControleAcessoPessoa1.setFocusable(false);
        BtControleAcessoPessoa1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtControleAcessoPessoa1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtControleAcessoPessoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtControleAcessoPessoa1ActionPerformed(evt);
            }
        });
        TbControles2.add(BtControleAcessoPessoa1);

        BtControleChaves1.setBackground(new java.awt.Color(255, 255, 255));
        BtControleChaves1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgPortaria/MenuControleChaves.png"))); // NOI18N
        BtControleChaves1.setToolTipText("Controle de Saída de Chaves");
        BtControleChaves1.setBorderPainted(false);
        GpbtPortaria.add(BtControleChaves1);
        BtControleChaves1.setEnabled(false);
        BtControleChaves1.setFocusable(false);
        BtControleChaves1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtControleChaves1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtControleChaves1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtControleChaves1ActionPerformed(evt);
            }
        });
        TbControles2.add(BtControleChaves1);

        Portaria1.add(TbControles2);
        TbControles2.setBounds(0, 0, 1360, 40);

        jTabbedPane2.addTab("Porteiro", Portaria1);

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Cadastros");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Apartamentos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Cores");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Torres");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Marcas de Veículos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Modelos de Veículos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Usuários do Sistema");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Setores");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Parâmetros");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipos de Empresas");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipos de Pessoas");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Tipos de Usuários do Sistema");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        arvoreSistema1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arvoreSistema1.setEnabled(false);
        arvoreSistema1.setRootVisible(false);
        arvoreSistema1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arvoreSistema1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(arvoreSistema1);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoParametroSistema1.add(jLabel15);
        jLabel15.setBounds(0, 0, 1370, 590);

        javax.swing.GroupLayout ParametrosSistema1Layout = new javax.swing.GroupLayout(ParametrosSistema1);
        ParametrosSistema1.setLayout(ParametrosSistema1Layout);
        ParametrosSistema1Layout.setHorizontalGroup(
            ParametrosSistema1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParametrosSistema1Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1180, Short.MAX_VALUE))
            .addGroup(ParametrosSistema1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ParametrosSistema1Layout.createSequentialGroup()
                    .addGap(0, 183, Short.MAX_VALUE)
                    .addComponent(areaTrabalhoParametroSistema1, javax.swing.GroupLayout.PREFERRED_SIZE, 1181, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        ParametrosSistema1Layout.setVerticalGroup(
            ParametrosSistema1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ParametrosSistema1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
            .addGroup(ParametrosSistema1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(ParametrosSistema1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(areaTrabalhoParametroSistema1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Parâmetros do Sitema", ParametrosSistema1);

        Ajuda3.setEnabled(false);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImgSistema/FundoSistema.png"))); // NOI18N
        areaTrabalhoPortaria4.add(jLabel16);
        jLabel16.setBounds(0, 0, 1370, 630);

        javax.swing.GroupLayout Ajuda3Layout = new javax.swing.GroupLayout(Ajuda3);
        Ajuda3.setLayout(Ajuda3Layout);
        Ajuda3Layout.setHorizontalGroup(
            Ajuda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrabalhoPortaria4, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
        );
        Ajuda3Layout.setVerticalGroup(
            Ajuda3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(areaTrabalhoPortaria4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Ajuda", Ajuda3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPanelSistemaPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, 1369, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LbUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbNomeUsuario)
                        .addGap(46, 46, 46)
                        .addComponent(LbTpUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbDescTpUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbDataAcesso)
                        .addGap(18, 18, 18)
                        .addComponent(LbHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbHoraAcesso)
                        .addGap(9, 9, 9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPanelSistemaPortaria, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbUsuario)
                            .addComponent(LbNomeUsuario)
                            .addComponent(LbTpUsuario)
                            .addComponent(LbDescTpUsuario)
                            .addComponent(LbData)
                            .addComponent(LbDataAcesso)
                            .addComponent(LbHora)
                            .addComponent(LbHoraAcesso))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        setSize(new java.awt.Dimension(1372, 732));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void centralizarFormularioPorteiro(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoPorteiro.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoPorteiro.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoPorteiro.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioParametroSistema(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoParametroSistema.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoParametroSistema.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoParametroSistema.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioSistema(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoSistema.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoSistema.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoSistema.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioCadastros(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoCadastros.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoCadastros.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoCadastros.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }

    public void centralizarFormularioConsultas(JInternalFrame Formulario) {

        int x, y;
        x = (areaTrabalhoConsultas.getWidth() / 2) - Formulario.getWidth() / 2;
        y = (areaTrabalhoConsultas.getHeight() / 2) - Formulario.getHeight() / 2;
        if (Formulario.isShowing()) {
            Formulario.setLocation(x, y);
        } else {
            TelaPrincipal.areaTrabalhoConsultas.add(Formulario);
            Formulario.setLocation(x, y);
            Formulario.setVisible(true);
        }
    }


    private void BtSairSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtSairSistemaActionPerformed

        int pergunta = JOptionPane.showOptionDialog(null, "Tem certeza que deseja sair do sistema?",
                "Atenção!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
        if (pergunta == JOptionPane.YES_OPTION) {
            // con.desconecta();
            dispose();
            System.exit(0);
        } else {
            return;
        }
    }//GEN-LAST:event_BtSairSistemaActionPerformed

    private void BtChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtChavesActionPerformed

        try {
            FrmChaves frmChaves = new FrmChaves();
            centralizarFormularioCadastros(frmChaves);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtChavesActionPerformed

    private void BtVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVeiculoActionPerformed

        try {
            FrmVeiculos frmVeiculo = new FrmVeiculos();
            centralizarFormularioCadastros(frmVeiculo);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtVeiculoActionPerformed

    private void BtPorteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPorteiroActionPerformed

        try {
            FrmPorteiros frmPorteiro = new FrmPorteiros();
            centralizarFormularioCadastros(frmPorteiro);

        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtPorteiroActionPerformed

    private void BtFuncionariosHtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtFuncionariosHtActionPerformed

        try {
            FrmFuncionariosHt frmFuncHt = new FrmFuncionariosHt();
            centralizarFormularioCadastros(frmFuncHt);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtFuncionariosHtActionPerformed

    private void BtPrestadoresServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPrestadoresServicosActionPerformed

        try {
            FrmPrestadoresServicos frmPrestServico = new FrmPrestadoresServicos();
            centralizarFormularioCadastros(frmPrestServico);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtPrestadoresServicosActionPerformed

    private void BtVisitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVisitantesActionPerformed

        try {
            FrmVisitantes frmVisitante = new FrmVisitantes();
            centralizarFormularioCadastros(frmVisitante);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtVisitantesActionPerformed

    private void BtHospedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtHospedesActionPerformed

        try {
            FrmHospedes frmHospede = new FrmHospedes();
            centralizarFormularioCadastros(frmHospede);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtHospedesActionPerformed

    private void BtMoradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtMoradoresActionPerformed

        try {
            FrmMoradores frmMorador = new FrmMoradores();
            centralizarFormularioCadastros(frmMorador);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtMoradoresActionPerformed

    private void BtControleAcessoVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtControleAcessoVeiculoActionPerformed

        try {
            FrmLoginPorteiro frmLoginPort = new FrmLoginPorteiro("Acesso veiculo");
            centralizarFormularioPorteiro(frmLoginPort);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtControleAcessoVeiculoActionPerformed

    private void BtControleAcessoPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtControleAcessoPessoaActionPerformed

        try {
            FrmLoginPorteiro frmLoginPort = new FrmLoginPorteiro("Acesso pessoa");
            centralizarFormularioPorteiro(frmLoginPort);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtControleAcessoPessoaActionPerformed

    private void BtControleChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtControleChavesActionPerformed

        try {
            FrmLoginPorteiro frmLoginPort = new FrmLoginPorteiro("Acesso chave");
            centralizarFormularioPorteiro(frmLoginPort);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtControleChavesActionPerformed

    private void BtAlterarSenhaSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarSenhaSistemaActionPerformed

        try {
            FrmAlterarSenhaSistema frmAltSenhaSistema = new FrmAlterarSenhaSistema();
            centralizarFormularioSistema(frmAltSenhaSistema);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtAlterarSenhaSistemaActionPerformed

    private void BtAlterarSenhaPorteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarSenhaPorteiroActionPerformed

        try {
            FrmAlterarSenhaPorteiros frmAltSenhaPorteiro = new FrmAlterarSenhaPorteiros();
            centralizarFormularioSistema(frmAltSenhaPorteiro);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtAlterarSenhaPorteiroActionPerformed

    private void BtAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAgendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtAgendaActionPerformed

    private void BtLembreteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLembreteActionPerformed

        try {
            FrmLembrete frmLembrete = new FrmLembrete();
            centralizarFormularioSistema(frmLembrete);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtLembreteActionPerformed

    private void BtEmpresasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEmpresasActionPerformed

        try {
            FrmEmpresas frmEmprea = new FrmEmpresas();
            centralizarFormularioCadastros(frmEmprea);
        } catch (SQLException | ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtEmpresasActionPerformed

    private void BtConsultasPortariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultasPortariaActionPerformed

        try {
            FrmConsultasTodosCadastros frmConsultTodosCad = new FrmConsultasTodosCadastros();
            centralizarFormularioConsultas(frmConsultTodosCad);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtConsultasPortariaActionPerformed

    private void BtAlterarSenhaSistema1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarSenhaSistema1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtAlterarSenhaSistema1ActionPerformed

    private void BtAlterarSenhaPorteiro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAlterarSenhaPorteiro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtAlterarSenhaPorteiro1ActionPerformed

    private void BtAgenda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtAgenda1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtAgenda1ActionPerformed

    private void BtLembrete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtLembrete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtLembrete1ActionPerformed

    private void BtMoradores1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtMoradores1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtMoradores1ActionPerformed

    private void BtHospedes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtHospedes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtHospedes1ActionPerformed

    private void BtVisitantes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVisitantes1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtVisitantes1ActionPerformed

    private void BtPrestadoresServicos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPrestadoresServicos1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtPrestadoresServicos1ActionPerformed

    private void BtFuncionariosHt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtFuncionariosHt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtFuncionariosHt1ActionPerformed

    private void BtPorteiro1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtPorteiro1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtPorteiro1ActionPerformed

    private void BtVeiculo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtVeiculo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtVeiculo1ActionPerformed

    private void BtChaves1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtChaves1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtChaves1ActionPerformed

    private void BtEmpresas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEmpresas1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtEmpresas1ActionPerformed

    private void BtConsultasPortaria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultasPortaria1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtConsultasPortaria1ActionPerformed

    private void BtControleAcessoVeiculo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtControleAcessoVeiculo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtControleAcessoVeiculo1ActionPerformed

    private void BtControleAcessoPessoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtControleAcessoPessoa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtControleAcessoPessoa1ActionPerformed

    private void BtControleChaves1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtControleChaves1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtControleChaves1ActionPerformed

    private void arvoreSistema1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arvoreSistema1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_arvoreSistema1MouseClicked

    private void BtConsultasEntradaSaidaVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultasEntradaSaidaVeiculosActionPerformed

        try {
            FrmConsultasEntradaSaidaVeiculos frmConsultEntSaidVeic = new FrmConsultasEntradaSaidaVeiculos();
            centralizarFormularioConsultas(frmConsultEntSaidVeic);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtConsultasEntradaSaidaVeiculosActionPerformed

    private void BtConsultasEntradaSaidaPessoasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultasEntradaSaidaPessoasActionPerformed

        try {
            FrmConsultasEntradaSaidaPessoas frmConsultEntSaidPs = new FrmConsultasEntradaSaidaPessoas();
            centralizarFormularioConsultas(frmConsultEntSaidPs);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtConsultasEntradaSaidaPessoasActionPerformed

    private void BtConsultasEntradaSaidaChavesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultasEntradaSaidaChavesActionPerformed

        try {
            FrmConsultasEntradaSaidaChaves frmConsultEntSaidChv = new FrmConsultasEntradaSaidaChaves();
            centralizarFormularioConsultas(frmConsultEntSaidChv);
        } catch (SQLException ex) {
            Logger.getLogger(TelaPrincipal.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BtConsultasEntradaSaidaChavesActionPerformed

    private void arvoreSistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arvoreSistemaMouseClicked

        String menu = arvoreSistema.getLastSelectedPathComponent().toString();
        if (menu.equals("Apartamentos")) {
            try {
                FrmApartamentos frmApt = new FrmApartamentos();
                centralizarFormularioParametroSistema(frmApt);
            } catch (SQLException ex) {
                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (menu.equals("Marcas de Veículos")) {
                try {
                    FrmMarcaVeiculo frmMcVc = new FrmMarcaVeiculo();
                    centralizarFormularioParametroSistema(frmMcVc);
                } catch (SQLException | ParseException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (menu.equals("Modelos de Veículos")) {
                    try {
                        FrmModeloVeiculos frmMdVc = new FrmModeloVeiculos();
                        centralizarFormularioParametroSistema(frmMdVc);
                    } catch (SQLException | ParseException ex) {
                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    if (menu.equals("Tipos de Empresas")) {
                        try {
                            FrmTipoEmpresas frmTpEmp = new FrmTipoEmpresas();
                            centralizarFormularioParametroSistema(frmTpEmp);
                        } catch (SQLException | ParseException ex) {
                            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        if (menu.equals("Tipos de Pessoas")) {
                            try {
                                FrmTipoPessoas frmTpPs = new FrmTipoPessoas();
                                centralizarFormularioParametroSistema(frmTpPs);
                            } catch (SQLException | ParseException ex) {
                                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else {
                            if (menu.equals("Torres")) {
                                try {
                                    FrmTorres frmTrr = new FrmTorres();
                                    centralizarFormularioParametroSistema(frmTrr);
                                } catch (SQLException ex) {
                                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            } else {
                                if (menu.equals("Cores")) {
                                    try {
                                        FrmCores frmCor = new FrmCores();
                                        centralizarFormularioParametroSistema(frmCor);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (ParseException ex) {
                                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                } else {
                                    if (menu.equals("Usuários do Sistema")) {
                                        try {
                                            FrmUsuario frmUsu = new FrmUsuario();
                                            centralizarFormularioParametroSistema(frmUsu);
                                        } catch (SQLException ex) {
                                            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    } else {
                                        if (menu.equals("Tipos de Usuários do Sistema")) {
                                            try {
                                                FrmTipoUsuario frmTpUsu = new FrmTipoUsuario();
                                                centralizarFormularioParametroSistema(frmTpUsu);
                                            } catch (SQLException ex) {
                                                Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                        } else {
                                            if (menu.equals("Setores")) {
                                                try {
                                                    FrmSetores frmSet = new FrmSetores();
                                                    centralizarFormularioParametroSistema(frmSet);
                                                } catch (SQLException ex) {
                                                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                                }
                                            } else {
                                                if (menu.equals("Tipos de Agendas")) {
                                                    try {
                                                        FrmTiposAgendas frmTpAgd = new FrmTiposAgendas();
                                                        centralizarFormularioParametroSistema(frmTpAgd);
                                                    } catch (SQLException | ParseException ex) {
                                                        Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                                    }
                                                } else {
                                                    if (menu.equals("Ramais Administrativo")) {
                                                        try {
                                                            FrmRamaisAdministrativo frmRmAdm = new FrmRamaisAdministrativo();
                                                            centralizarFormularioParametroSistema(frmRmAdm);
                                                        } catch (SQLException | ParseException ex) {
                                                            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_arvoreSistemaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Ajuda1;
    private javax.swing.JPanel Ajuda2;
    private javax.swing.JPanel Ajuda3;
    private javax.swing.JButton BtAgenda;
    private javax.swing.JButton BtAgenda1;
    private javax.swing.JButton BtAlterarSenhaPorteiro;
    private javax.swing.JButton BtAlterarSenhaPorteiro1;
    private javax.swing.JButton BtAlterarSenhaSistema;
    private javax.swing.JButton BtAlterarSenhaSistema1;
    private javax.swing.JButton BtChaves;
    private javax.swing.JButton BtChaves1;
    private javax.swing.JButton BtConsultasEntradaSaidaChaves;
    private javax.swing.JButton BtConsultasEntradaSaidaPessoas;
    private javax.swing.JButton BtConsultasEntradaSaidaVeiculos;
    private javax.swing.JButton BtConsultasPortaria;
    private javax.swing.JButton BtConsultasPortaria1;
    private javax.swing.JButton BtControleAcessoPessoa;
    private javax.swing.JButton BtControleAcessoPessoa1;
    private javax.swing.JButton BtControleAcessoVeiculo;
    private javax.swing.JButton BtControleAcessoVeiculo1;
    private javax.swing.JButton BtControleChaves;
    private javax.swing.JButton BtControleChaves1;
    private javax.swing.JButton BtEmpresas;
    private javax.swing.JButton BtEmpresas1;
    private javax.swing.JButton BtFuncionariosHt;
    private javax.swing.JButton BtFuncionariosHt1;
    private javax.swing.JButton BtHospedes;
    private javax.swing.JButton BtHospedes1;
    private javax.swing.JButton BtLembrete;
    private javax.swing.JButton BtLembrete1;
    private javax.swing.JButton BtMoradores;
    private javax.swing.JButton BtMoradores1;
    private javax.swing.JButton BtPorteiro;
    private javax.swing.JButton BtPorteiro1;
    private javax.swing.JButton BtPrestadoresServicos;
    private javax.swing.JButton BtPrestadoresServicos1;
    private javax.swing.JButton BtSairSistema;
    private javax.swing.JButton BtVeiculo;
    private javax.swing.JButton BtVeiculo1;
    private javax.swing.JButton BtVisitantes;
    private javax.swing.JButton BtVisitantes1;
    private javax.swing.JPanel Cadastros;
    private javax.swing.JPanel Cadastros1;
    private javax.swing.JPanel Consultas;
    private javax.swing.JPanel Consultas1;
    private javax.swing.ButtonGroup GpbtAberturaChamados;
    private javax.swing.ButtonGroup GpbtAlmoxarifado;
    private javax.swing.ButtonGroup GpbtPortaria;
    private javax.swing.JLabel LbData;
    private javax.swing.JLabel LbDataAcesso;
    private javax.swing.JLabel LbDescTpUsuario;
    private javax.swing.JLabel LbHora;
    private javax.swing.JLabel LbHoraAcesso;
    private javax.swing.JLabel LbNomeUsuario;
    private javax.swing.JLabel LbTpUsuario;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JPanel ParametrosSistema;
    private javax.swing.JPanel ParametrosSistema1;
    private javax.swing.JPanel ParametrosSistema2;
    private javax.swing.JPanel Portaria;
    private javax.swing.JPanel Portaria1;
    private javax.swing.JToolBar TbCadastros;
    private javax.swing.JToolBar TbCadastros1;
    private javax.swing.JToolBar TbCadastros2;
    private javax.swing.JToolBar TbCadastros3;
    private javax.swing.JToolBar TbCadastros4;
    private javax.swing.JToolBar TbCadastros5;
    private javax.swing.JToolBar TbControles1;
    private javax.swing.JToolBar TbControles2;
    public static javax.swing.JDesktopPane areaTrabalhoAjuda;
    public static javax.swing.JDesktopPane areaTrabalhoCadastros;
    public static javax.swing.JDesktopPane areaTrabalhoCadastros1;
    public static javax.swing.JDesktopPane areaTrabalhoConsultas;
    public static javax.swing.JDesktopPane areaTrabalhoConsultas1;
    public static javax.swing.JDesktopPane areaTrabalhoParametroSistema;
    public static javax.swing.JDesktopPane areaTrabalhoParametroSistema1;
    public static javax.swing.JDesktopPane areaTrabalhoPortaria4;
    public static javax.swing.JDesktopPane areaTrabalhoPorteiro;
    public static javax.swing.JDesktopPane areaTrabalhoPorteiro1;
    public static javax.swing.JDesktopPane areaTrabalhoSistema;
    public static javax.swing.JDesktopPane areaTrabalhoSistema1;
    private javax.swing.JTree arvoreAjuda;
    private javax.swing.JTree arvoreSistema;
    private javax.swing.JTree arvoreSistema1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPanelSistemaPortaria;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    // End of variables declaration//GEN-END:variables
}

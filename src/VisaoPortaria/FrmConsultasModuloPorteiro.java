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

public class FrmConsultasModuloPorteiro extends javax.swing.JInternalFrame {

    ConectaBanco conEntVc = new ConectaBanco();
    ConectaBanco conSaidVc = new ConectaBanco();
    ConectaBanco conMr = new ConectaBanco();
    ConectaBanco conHsp = new ConectaBanco();
    ConectaBanco conVis = new ConectaBanco();
    ConectaBanco conPrst = new ConectaBanco();
    ConectaBanco conFuncHt = new ConectaBanco();
    ConectaBanco conPort = new ConectaBanco();
    ConectaBanco conVc = new ConectaBanco();
    String nomeProp, nomePort, placaVc, marcaVc, modeloVc, corVc, nomePs, Rg, nomeEmp, nomeSets;
    private String data_ini, data_fin;

    public FrmConsultasModuloPorteiro() throws SQLException {

        initComponents();
    }

    public void atualizarTabelaTodosMoradores() {

        preencherTabelaMorador("select * from vw_morador order by nome_ps");
    }

    public void atualizarTabelaRgMorador() {

        preencherTabelaMorador("select * from vw_morador where rg_ps = '" + Rg + "'order by nome_ps");
    }

    public void atualizarTabelaNomeMorador() {

        preencherTabelaMorador("select * from vw_morador where nome_ps like '%" + nomePs + "%'order by nome_ps");
    }

    public void atualizarTabelaTodosHospedes() {

        preencherTabelaHospede("select * from vw_hospede order by nome_ps");
    }

    public void atualizarTabelaRgHospede() {

        preencherTabelaHospede("select * from vw_hospede where rg_ps = '" + Rg + "'order by nome_ps");
    }

    public void atualizarTabelaNomeHospede() {

        preencherTabelaHospede("select * from vw_hospede where nome_ps like '%" + nomePs + "%'order by nome_ps");
    }

    public void atualizarTabelaTodosVisitantes() {

        preencherTabelaVisitante("select * from vw_visitante order by nome_ps");
    }

    public void atualizarTabelaRgVisitante() {

        preencherTabelaVisitante("select * from vw_visitante where rg_ps = '" + Rg + "'order by nome_ps");
    }

    public void atualizarTabelaNomeVisitante() {

        preencherTabelaVisitante("select * from vw_visitante where nome_ps like '%" + nomePs + "%'order by nome_ps");
    }

    public void atualizarTabelaTodosPrestadoresServicos() {

        preencherTabelaPrestadoresServicos("select * from  vw_prestadorservico order by nome_ps");
    }

    public void atualizarTabelaRgPrestadorServico() {

        preencherTabelaPrestadoresServicos("select * from  vw_prestadorservico where rg_ps = '" + Rg + "'order by nome_ps");
    }

    public void atualizarTabelaNomeFuncionarioPrestadorServico() {

        preencherTabelaPrestadoresServicos("select * from  vw_prestadorservico where nome_ps like '%" + nomePs + "%'order by nome_ps");
    }

    public void atualizarTabelaNomeEmpresaPrestadoraServico() {

        preencherTabelaPrestadoresServicos("select * from  vw_prestadorservico where desc_forn like '%" + nomeEmp + "%'order by nome_ps");
    }

    public void atualizarTabelaTodosFuncionariosHotel() {

        preencherTabelaFuncionariosHotel("select * from vw_funcionarioht order by nome_ps");
    }

    public void atualizarTabelaRgFuncionariosHotel() {

        preencherTabelaFuncionariosHotel("select * from vw_funcionarioht where rg_ps = '" + Rg + "'order by nome_ps");
    }

    public void atualizarTabelaNomeFuncionarioHotel() {

        preencherTabelaFuncionariosHotel("select * from vw_funcionarioht where nome_ps like '%" + nomePs + "%'order by nome_ps");
    }

    public void atualizarTabelaTodosPorteiros() {

        preencherTabelaPorteiros("select * from tab_porteiros order by nome_port");
    }

    public void atualizarTabelaNomePorteiro() {

        preencherTabelaPorteiros("select * from tab_porteiros where nome_port like '%" + nomePort + "%'order by nome_port");
    }

    public void atualizarTabelaTodosVeiculos() {

        preencherTabelaVeiculo("select * from vw_veiculo order by desc_mc");
    }

    public void atualizarTabelaPlacaVeiculo() {

        preencherTabelaVeiculo("select * from vw_veiculo where placa_vc like '%" + placaVc + "%'order by desc_mc");
    }

    public void atualizarTabelaMarcaVeiculo() {

        preencherTabelaVeiculo("select * from vw_veiculo where desc_mc like '%" + marcaVc + "%'order by desc_mc");
    }

    public void atualizarTabelaModeloVeiculo() {

        preencherTabelaVeiculo("select * from vw_veiculo where desc_md like '%" + modeloVc + "%'order by desc_mc");
    }

    public void atualizarTabelaNomeProprietario() {

        preencherTabelaVeiculo("select * from vw_veiculo where nome_ps like'%" + nomeProp + "%' order by desc_mc");
    }

    public void atualizarTabelaSetorFuncionarioHotel() {

        preencherTabelaFuncionariosHotel("select * from vw_funcionarioht where desc_sets like '%" + nomeSets + "%'order by nome_ps");
    }

    public void atualizarTabelaEntradaTodasEntradas() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo order by data_ent_vc desc");
    }

    public void atualizarTabelaEntradaPlacaVeiculo() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo where placa_vc like '%" + placaVc + "%'order by data_ent_vc desc");
    }

    public void atualizarTabelaEntradaMarcaVeiculo() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo where desc_mc like '%" + marcaVc + "%'order by data_ent_vc desc");
    }

    public void atualizarTabelaEntradaModeloVeiculo() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo where desc_md like '%" + modeloVc + "%'order by data_ent_vc desc");
    }

    public void atualizarTabelaEntradaCorVeiculo() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo where desc_cor like'%" + corVc + "%' order by data_ent_vc desc");
    }

    public void atualizarTabelaEntradaNomeProprietario() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo where nome_ps like'%" + nomeProp + "%' order by data_ent_vc desc");
    }

    public void atualizarTabelaEntradaNomePorteiro() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo where nome_port like'%" + nomePort + "%' order by data_ent_vc desc");
    }

    public void atualizarTabelaEntradaVeiculoData() {

        preencherTabelaEntradaVeiculo("select * from vw_entrada_veiculo where data_ent_vc between '" + data_ini + "' and '" + data_fin + "' order by data_ent_vc desc");
    }

    public void atualizarTabelaTodasSaidas() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo order by data_said_vc desc");
    }

    public void atualizarTabelaSaidaPlacaVeiculo() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo where placa_vc like '%" + placaVc + "%'order by data_said_vc desc");
    }

    public void atualizarTabelaSaidaMarcaVeiculo() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo where desc_mc like '%" + marcaVc + "%'order by data_said_vc desc");
    }

    public void atualizarTabelaSaidaModeloVeiculo() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo where desc_md like '%" + modeloVc + "%'order by data_said_vc desc");
    }

    public void atualizarTabelaSaidaCorVeiculo() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo where desc_cor like'%" + corVc + "%' order by data_said_vc desc");
    }

    public void atualizarTabelaSaidaNomeProprietario() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo where nome_ps like'%" + nomeProp + "%' order by data_said_vc desc");
    }

    public void atualizarTabelaSaidaNomePorteiro() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo where nome_port like'%" + nomePort + "%' order by data_said_vc desc");
    }

    public void atualizarTabelaSaidaVeiculoData() {

        preencherTabelaSaidaVeiculo("select * from vw_saida_veiculo where data_said_vc between '" + data_ini + "' and '" + data_fin + "' order by data_said_vc desc");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        RdGroupTiposConsultas = new javax.swing.ButtonGroup();
        RdGroupTiposConsultas2 = new javax.swing.ButtonGroup();
        RdGroupTiposConsultasMoradores = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        AbasConsultas = new javax.swing.JTabbedPane();
        AbaEntradaVeiculos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jRdPlacaVeiculo = new javax.swing.JRadioButton();
        jRdTodasEntradas = new javax.swing.JRadioButton();
        jRdMarcaVeiculo = new javax.swing.JRadioButton();
        jRdModeloVeiculo = new javax.swing.JRadioButton();
        jRdDataEntrada = new javax.swing.JRadioButton();
        jRdNomeProprietario = new javax.swing.JRadioButton();
        jRdCorVeiculo = new javax.swing.JRadioButton();
        jRdNomePorteiro = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbEntradasVeiculos = new javax.swing.JTable();
        AbaSaidasVeiculos = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jRdPlacaVeiculo2 = new javax.swing.JRadioButton();
        jRdTodasSaidas = new javax.swing.JRadioButton();
        jRdMarcaVeiculo2 = new javax.swing.JRadioButton();
        jRdModeloVeiculo2 = new javax.swing.JRadioButton();
        jRdDataSaida = new javax.swing.JRadioButton();
        jRdNomeProprietario2 = new javax.swing.JRadioButton();
        jRdCorVeiculo2 = new javax.swing.JRadioButton();
        jRdNomePorteiro2 = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbSaidasVeiculos = new javax.swing.JTable();
        AbaTodosCadastros = new javax.swing.JPanel();
        Abas = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TbMoradores = new javax.swing.JTable();
        BtConsultarTodosMoradores = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        jRdRgPort = new javax.swing.JRadioButton();
        jRdNomePort = new javax.swing.JRadioButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jRdRgHospede = new javax.swing.JRadioButton();
        jRdNomeHospede = new javax.swing.JRadioButton();
        BtConsultarTodosHospedes = new javax.swing.JButton();
        jPanel29 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TbHospedes = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jRdRgVisitante = new javax.swing.JRadioButton();
        jRdNomeVisitante = new javax.swing.JRadioButton();
        BtConsultarTodosVisitantes = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TbVisitantes = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jPanel34 = new javax.swing.JPanel();
        jRdRgFuncPrestadorServico = new javax.swing.JRadioButton();
        jRdNomeFuncPrestadorServico = new javax.swing.JRadioButton();
        jRdNomeEmpresaPrestadoraServico = new javax.swing.JRadioButton();
        BtConsultarTodosFuncionariosPrestadoresServicos = new javax.swing.JButton();
        jPanel35 = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TbPrestadoresServicos = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jRdRgFuncionario = new javax.swing.JRadioButton();
        jRdNomeFuncionario = new javax.swing.JRadioButton();
        jRdSetorFuncionario = new javax.swing.JRadioButton();
        BtConsultarTodosFuncionariosHotel = new javax.swing.JButton();
        jPanel37 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        TbFuncionariosHotel = new javax.swing.JTable();
        jPanel13 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jRdNomePorteiro3 = new javax.swing.JRadioButton();
        BtConsultarTodosPorteiros = new javax.swing.JButton();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        TbPorteiros = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jRdPlacaVeiculo3 = new javax.swing.JRadioButton();
        jRdNomeProprietario3 = new javax.swing.JRadioButton();
        jRdMarcaVaeiculo = new javax.swing.JRadioButton();
        jRdMarcaVaeiculo1 = new javax.swing.JRadioButton();
        BtConsultarTodosVeiculos = new javax.swing.JButton();
        jPanel39 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        TbVeiculos = new javax.swing.JTable();
        BtCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Consultas");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultas.add(jRdPlacaVeiculo);
        jRdPlacaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdPlacaVeiculo.setText("Entrada p/ Placa Veículo");
        jRdPlacaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdPlacaVeiculoActionPerformed(evt);
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

        RdGroupTiposConsultas.add(jRdMarcaVeiculo);
        jRdMarcaVeiculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdMarcaVeiculo.setText("Entrada p/ Marca Veículo");
        jRdMarcaVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdMarcaVeiculoActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdModeloVeiculo);
        jRdModeloVeiculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdModeloVeiculo.setText("Entrada p/ Modelo Veículo");
        jRdModeloVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdModeloVeiculoActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdDataEntrada);
        jRdDataEntrada.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDataEntrada.setText("Entrada Veículo p/ Data");
        jRdDataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDataEntradaActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdNomeProprietario);
        jRdNomeProprietario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeProprietario.setText("Entrada p/ Nome Proprietário");
        jRdNomeProprietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeProprietarioActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdCorVeiculo);
        jRdCorVeiculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdCorVeiculo.setText("Entrada p/ Cor Veículo");
        jRdCorVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdCorVeiculoActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdNomePorteiro);
        jRdNomePorteiro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomePorteiro.setText("Entrada p/ Nome Porteiro");
        jRdNomePorteiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomePorteiroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRdPlacaVeiculo)
                    .addComponent(jRdMarcaVeiculo)
                    .addComponent(jRdModeloVeiculo)
                    .addComponent(jRdCorVeiculo)
                    .addComponent(jRdDataEntrada)
                    .addComponent(jRdTodasEntradas)
                    .addComponent(jRdNomeProprietario)
                    .addComponent(jRdNomePorteiro, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRdTodasEntradas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdPlacaVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdMarcaVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdModeloVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdCorVeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomeProprietario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomePorteiro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDataEntrada)
                .addContainerGap(175, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Entradas dos Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbEntradasVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbEntradasVeiculos.setToolTipText(" Lista das entradas dos veículos");
        TbEntradasVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbEntradasVeiculosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbEntradasVeiculos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AbaEntradaVeiculosLayout = new javax.swing.GroupLayout(AbaEntradaVeiculos);
        AbaEntradaVeiculos.setLayout(AbaEntradaVeiculosLayout);
        AbaEntradaVeiculosLayout.setHorizontalGroup(
            AbaEntradaVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaEntradaVeiculosLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AbaEntradaVeiculosLayout.setVerticalGroup(
            AbaEntradaVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaEntradaVeiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbaEntradaVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        AbasConsultas.addTab("Entradas dos Véculos", AbaEntradaVeiculos);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultas.add(jRdPlacaVeiculo2);
        jRdPlacaVeiculo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdPlacaVeiculo2.setText("Saída p/ Placa Veículo");
        jRdPlacaVeiculo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdPlacaVeiculo2ActionPerformed(evt);
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

        RdGroupTiposConsultas.add(jRdMarcaVeiculo2);
        jRdMarcaVeiculo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdMarcaVeiculo2.setText("Saída p/ Marca Veículo");
        jRdMarcaVeiculo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdMarcaVeiculo2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdModeloVeiculo2);
        jRdModeloVeiculo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdModeloVeiculo2.setText("Saída p/ Modelo Veículo");
        jRdModeloVeiculo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdModeloVeiculo2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdDataSaida);
        jRdDataSaida.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdDataSaida.setText("Saída Veículo p/ Data");
        jRdDataSaida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdDataSaidaActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdNomeProprietario2);
        jRdNomeProprietario2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeProprietario2.setText("Saída p/ Nome Proprietário");
        jRdNomeProprietario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeProprietario2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdCorVeiculo2);
        jRdCorVeiculo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdCorVeiculo2.setText("Saída p/ Cor Veículo");
        jRdCorVeiculo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdCorVeiculo2ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultas.add(jRdNomePorteiro2);
        jRdNomePorteiro2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomePorteiro2.setText("Saída p/ Nome Porteiro");
        jRdNomePorteiro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomePorteiro2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRdPlacaVeiculo2)
                    .addComponent(jRdMarcaVeiculo2)
                    .addComponent(jRdModeloVeiculo2)
                    .addComponent(jRdCorVeiculo2)
                    .addComponent(jRdTodasSaidas)
                    .addComponent(jRdDataSaida)
                    .addComponent(jRdNomePorteiro2)
                    .addComponent(jRdNomeProprietario2))
                .addGap(0, 12, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jRdTodasSaidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdPlacaVeiculo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdMarcaVeiculo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdModeloVeiculo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdCorVeiculo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomeProprietario2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomePorteiro2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdDataSaida)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Saídas dos Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbSaidasVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbSaidasVeiculos.setToolTipText(" Lista das saídas dos veículos");
        TbSaidasVeiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbSaidasVeiculosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbSaidasVeiculos);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 673, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout AbaSaidasVeiculosLayout = new javax.swing.GroupLayout(AbaSaidasVeiculos);
        AbaSaidasVeiculos.setLayout(AbaSaidasVeiculosLayout);
        AbaSaidasVeiculosLayout.setHorizontalGroup(
            AbaSaidasVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaSaidasVeiculosLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        AbaSaidasVeiculosLayout.setVerticalGroup(
            AbaSaidasVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AbaSaidasVeiculosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AbaSaidasVeiculosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        AbasConsultas.addTab("Saídas de Veículos", AbaSaidasVeiculos);

        Abas.setToolTipText("");

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Moradores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbMoradores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbMoradores.setToolTipText(" Lista de moradores cadastrados");
        TbMoradores.setEnabled(false);
        TbMoradores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbMoradoresMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TbMoradores);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        BtConsultarTodosMoradores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultarTodosMoradores.setToolTipText("Exibir todos moradores cadastrados");
        BtConsultarTodosMoradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarTodosMoradoresActionPerformed(evt);
            }
        });

        jPanel30.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultasMoradores.add(jRdRgPort);
        jRdRgPort.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdRgPort.setText("Rg");
        jRdRgPort.setToolTipText("Consultar pelo rg do morador");
        jRdRgPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdRgPortActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdNomePort);
        jRdNomePort.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomePort.setText("Nome Morador");
        jRdNomePort.setToolTipText("Consultar pelo nome do morador");
        jRdNomePort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomePortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRdRgPort)
                .addGap(10, 10, 10)
                .addComponent(jRdNomePort))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdRgPort)
                    .addComponent(jRdNomePort))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultarTodosMoradores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultarTodosMoradores, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Abas.addTab("Moradores", jPanel8);

        jPanel31.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultasMoradores.add(jRdRgHospede);
        jRdRgHospede.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdRgHospede.setText("Rg");
        jRdRgHospede.setToolTipText("Consultar pelo rg do hóspede");
        jRdRgHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdRgHospedeActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdNomeHospede);
        jRdNomeHospede.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeHospede.setText("Nome Hóspede");
        jRdNomeHospede.setToolTipText("Consultar pelo nome do hóspede");
        jRdNomeHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeHospedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRdRgHospede)
                .addGap(10, 10, 10)
                .addComponent(jRdNomeHospede))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdRgHospede)
                    .addComponent(jRdNomeHospede))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        BtConsultarTodosHospedes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultarTodosHospedes.setToolTipText("Exibir todos hóspedes cadastrados");
        BtConsultarTodosHospedes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarTodosHospedesActionPerformed(evt);
            }
        });

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Hóspedes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbHospedes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbHospedes.setToolTipText(" Lista dos hóspedes cadastrados");
        TbHospedes.setEnabled(false);
        TbHospedes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbHospedesMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(TbHospedes);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultarTodosHospedes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultarTodosHospedes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Abas.addTab("Hóspedes", jPanel9);

        jPanel32.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultasMoradores.add(jRdRgVisitante);
        jRdRgVisitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdRgVisitante.setText("Rg");
        jRdRgVisitante.setToolTipText("Consultar pelo rg do visitante");
        jRdRgVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdRgVisitanteActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdNomeVisitante);
        jRdNomeVisitante.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeVisitante.setText("Nome Visitante");
        jRdNomeVisitante.setToolTipText("Consultar pelo nome do visitante");
        jRdNomeVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeVisitanteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRdRgVisitante)
                .addGap(10, 10, 10)
                .addComponent(jRdNomeVisitante))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdRgVisitante)
                    .addComponent(jRdNomeVisitante))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        BtConsultarTodosVisitantes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultarTodosVisitantes.setToolTipText("Exibir todos moradores cadastrados");
        BtConsultarTodosVisitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarTodosVisitantesActionPerformed(evt);
            }
        });

        jPanel33.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Visitantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbVisitantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbVisitantes.setToolTipText(" Lista dos visitantes cadastrados");
        TbVisitantes.setEnabled(false);
        TbVisitantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbVisitantesMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(TbVisitantes);

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultarTodosVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultarTodosVisitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Abas.addTab("Vsitantes", jPanel10);

        jPanel34.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultasMoradores.add(jRdRgFuncPrestadorServico);
        jRdRgFuncPrestadorServico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdRgFuncPrestadorServico.setText("Rg");
        jRdRgFuncPrestadorServico.setToolTipText("Consultar pelo rg do funcionário prestador de serviço");
        jRdRgFuncPrestadorServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdRgFuncPrestadorServicoActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdNomeFuncPrestadorServico);
        jRdNomeFuncPrestadorServico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeFuncPrestadorServico.setText("Nome Funcionário Prestador Serviço");
        jRdNomeFuncPrestadorServico.setToolTipText("Consultar pelo nome do funcionário prestador de serviço");
        jRdNomeFuncPrestadorServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeFuncPrestadorServicoActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdNomeEmpresaPrestadoraServico);
        jRdNomeEmpresaPrestadoraServico.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeEmpresaPrestadoraServico.setText("Nome Empresa");
        jRdNomeEmpresaPrestadoraServico.setToolTipText("Consultar pelo nome da empresa prestadora de serviço");
        jRdNomeEmpresaPrestadoraServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeEmpresaPrestadoraServicoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRdRgFuncPrestadorServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomeFuncPrestadorServico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomeEmpresaPrestadoraServico)
                .addGap(12, 12, 12))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdRgFuncPrestadorServico)
                    .addComponent(jRdNomeFuncPrestadorServico)
                    .addComponent(jRdNomeEmpresaPrestadoraServico))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtConsultarTodosFuncionariosPrestadoresServicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultarTodosFuncionariosPrestadoresServicos.setToolTipText("Exibir todos os prestadores cadastrados");
        BtConsultarTodosFuncionariosPrestadoresServicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarTodosFuncionariosPrestadoresServicosActionPerformed(evt);
            }
        });

        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Prestadores de Serviços", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbPrestadoresServicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbPrestadoresServicos.setToolTipText(" Lista dos prestadores de serviços dos cadastrados");
        TbPrestadoresServicos.setEnabled(false);
        TbPrestadoresServicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPrestadoresServicosMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(TbPrestadoresServicos);

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel35Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultarTodosFuncionariosPrestadoresServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultarTodosFuncionariosPrestadoresServicos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Abas.addTab("Prestadores de Serviços", jPanel11);

        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultasMoradores.add(jRdRgFuncionario);
        jRdRgFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdRgFuncionario.setText("Rg");
        jRdRgFuncionario.setToolTipText("Consultar pelo rg do funcionário");
        jRdRgFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdRgFuncionarioActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdNomeFuncionario);
        jRdNomeFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeFuncionario.setText("Nome Funcionário");
        jRdNomeFuncionario.setToolTipText("Consultar pelo nome do funcionário");
        jRdNomeFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeFuncionarioActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdSetorFuncionario);
        jRdSetorFuncionario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdSetorFuncionario.setText("Setor Funcionário");
        jRdSetorFuncionario.setToolTipText("Consultar pelo setor do funcionário");
        jRdSetorFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdSetorFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRdRgFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRdNomeFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdSetorFuncionario))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdRgFuncionario)
                    .addComponent(jRdNomeFuncionario)
                    .addComponent(jRdSetorFuncionario))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        BtConsultarTodosFuncionariosHotel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultarTodosFuncionariosHotel.setToolTipText("Exibir todos funcionários cadastrados");
        BtConsultarTodosFuncionariosHotel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarTodosFuncionariosHotelActionPerformed(evt);
            }
        });

        jPanel37.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Funcionários", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbFuncionariosHotel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbFuncionariosHotel.setToolTipText(" Lista dos funcionários dos cadastrados");
        TbFuncionariosHotel.setEnabled(false);
        TbFuncionariosHotel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbFuncionariosHotelMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(TbFuncionariosHotel);

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultarTodosFuncionariosHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtConsultarTodosFuncionariosHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Abas.addTab("Funcionários", jPanel12);

        jPanel40.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultasMoradores.add(jRdNomePorteiro3);
        jRdNomePorteiro3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomePorteiro3.setText("Nome Porteiro");
        jRdNomePorteiro3.setToolTipText("Consultar pelo nome do porteiro");
        jRdNomePorteiro3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomePorteiro3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jRdNomePorteiro3))
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addComponent(jRdNomePorteiro3)
                .addGap(0, 7, Short.MAX_VALUE))
        );

        BtConsultarTodosPorteiros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultarTodosPorteiros.setToolTipText("Exibir todos porteiros cadastrados");
        BtConsultarTodosPorteiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarTodosPorteirosActionPerformed(evt);
            }
        });

        jPanel41.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Porteiros", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbPorteiros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbPorteiros.setToolTipText(" Lista dos porteiros cadastrados");
        TbPorteiros.setEnabled(false);
        TbPorteiros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbPorteirosMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(TbPorteiros);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultarTodosPorteiros, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtConsultarTodosPorteiros, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Abas.addTab("Porteiros", jPanel13);

        jPanel38.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tipos de Consultas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        RdGroupTiposConsultasMoradores.add(jRdPlacaVeiculo3);
        jRdPlacaVeiculo3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdPlacaVeiculo3.setText("Placa");
        jRdPlacaVeiculo3.setToolTipText("Consultar pela placa do veículo");
        jRdPlacaVeiculo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdPlacaVeiculo3ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdNomeProprietario3);
        jRdNomeProprietario3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdNomeProprietario3.setText("Nome Proprietário");
        jRdNomeProprietario3.setToolTipText("Consultar pelo nome do proprietário");
        jRdNomeProprietario3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdNomeProprietario3ActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdMarcaVaeiculo);
        jRdMarcaVaeiculo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdMarcaVaeiculo.setText("Marca");
        jRdMarcaVaeiculo.setToolTipText("Consultar pela marca do veículo");
        jRdMarcaVaeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdMarcaVaeiculoActionPerformed(evt);
            }
        });

        RdGroupTiposConsultasMoradores.add(jRdMarcaVaeiculo1);
        jRdMarcaVaeiculo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRdMarcaVaeiculo1.setText("Modelo");
        jRdMarcaVaeiculo1.setToolTipText("Consultar pelo modelo do veículo");
        jRdMarcaVaeiculo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRdMarcaVaeiculo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addComponent(jRdPlacaVeiculo3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdNomeProprietario3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdMarcaVaeiculo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRdMarcaVaeiculo1)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRdPlacaVeiculo3)
                    .addComponent(jRdNomeProprietario3)
                    .addComponent(jRdMarcaVaeiculo)
                    .addComponent(jRdMarcaVaeiculo1))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        BtConsultarTodosVeiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TodosVeiculos.png"))); // NOI18N
        BtConsultarTodosVeiculos.setToolTipText("Exibir todos moradores cadastrados");
        BtConsultarTodosVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtConsultarTodosVeiculosActionPerformed(evt);
            }
        });

        jPanel39.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Veículos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        TbVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbVeiculos.setToolTipText(" Lista de veículos cadastrados");
        TbVeiculos.setEnabled(false);
        jScrollPane14.setViewportView(TbVeiculos);

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane14, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtConsultarTodosVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtConsultarTodosVeiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        Abas.addTab("Veículos", jPanel14);

        javax.swing.GroupLayout AbaTodosCadastrosLayout = new javax.swing.GroupLayout(AbaTodosCadastros);
        AbaTodosCadastros.setLayout(AbaTodosCadastrosLayout);
        AbaTodosCadastrosLayout.setHorizontalGroup(
            AbaTodosCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AbaTodosCadastrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Abas)
                .addContainerGap())
        );
        AbaTodosCadastrosLayout.setVerticalGroup(
            AbaTodosCadastrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AbaTodosCadastrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Abas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        AbasConsultas.addTab("Todos os Cadastros", AbaTodosCadastros);

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

        setBounds(0, 0, 965, 591);
    }// </editor-fold>//GEN-END:initComponents

    private void BtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCancelarActionPerformed

        dispose();
    }//GEN-LAST:event_BtCancelarActionPerformed

    private void TbEntradasVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbEntradasVeiculosMouseClicked

        String numPlaca = "" + TbEntradasVeiculos.getValueAt(TbEntradasVeiculos.getSelectedRow(), 2);
        try {
            try {
                FrmDetalhesProprietario frmprop = new FrmDetalhesProprietario(numPlaca);
                TelaPrincipal.areaTrabalhoConsultas.add(frmprop);
                frmprop.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultasModuloPorteiro.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrmConsultasModuloPorteiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TbEntradasVeiculosMouseClicked

    private void jRdCorVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdCorVeiculoActionPerformed

        corVc = JOptionPane.showInputDialog(null, "Digite a cor do veículo :");
        if (corVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a cor do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaCorVeiculo();
        }
    }//GEN-LAST:event_jRdCorVeiculoActionPerformed

    private void jRdNomeProprietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeProprietarioActionPerformed

        nomeProp = JOptionPane.showInputDialog(null, "Digite o nome do proprietário :");
        if (nomeProp.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do proprietário para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaNomeProprietario();
        }
    }//GEN-LAST:event_jRdNomeProprietarioActionPerformed

    private void jRdDataEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDataEntradaActionPerformed

        try {
            FrmConsultaDataEntrada frmConsultaData = new FrmConsultaDataEntrada(this);
            TelaPrincipal.areaTrabalhoCadastros.add(frmConsultaData);
            frmConsultaData.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasModuloPorteiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRdDataEntradaActionPerformed

    private void jRdModeloVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdModeloVeiculoActionPerformed

        modeloVc = JOptionPane.showInputDialog(null, "Digite o modelo do veículo :");
        if (modeloVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o modelo do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaModeloVeiculo();
        }
    }//GEN-LAST:event_jRdModeloVeiculoActionPerformed

    private void jRdMarcaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdMarcaVeiculoActionPerformed

        marcaVc = JOptionPane.showInputDialog(null, "Digite a marca do veículo :");
        if (marcaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a marca do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaMarcaVeiculo();
        }
    }//GEN-LAST:event_jRdMarcaVeiculoActionPerformed

    private void jRdTodasEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTodasEntradasActionPerformed

        atualizarTabelaEntradaTodasEntradas();
    }//GEN-LAST:event_jRdTodasEntradasActionPerformed

    private void jRdPlacaVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdPlacaVeiculoActionPerformed

        placaVc = JOptionPane.showInputDialog(null, "Digite a placa do veículo :");
        if (placaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a placa do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaPlacaVeiculo();
        }
    }//GEN-LAST:event_jRdPlacaVeiculoActionPerformed

    private void jRdPlacaVeiculo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdPlacaVeiculo2ActionPerformed

        placaVc = JOptionPane.showInputDialog(null, "Digite a placa do veículo :");
        if (placaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a placa do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaPlacaVeiculo();
        }
    }//GEN-LAST:event_jRdPlacaVeiculo2ActionPerformed

    private void jRdTodasSaidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdTodasSaidasActionPerformed

        atualizarTabelaTodasSaidas();
    }//GEN-LAST:event_jRdTodasSaidasActionPerformed

    private void jRdMarcaVeiculo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdMarcaVeiculo2ActionPerformed

        marcaVc = JOptionPane.showInputDialog(null, "Digite a marca do veículo :");
        if (marcaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a marca do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaMarcaVeiculo();
        }
    }//GEN-LAST:event_jRdMarcaVeiculo2ActionPerformed

    private void jRdModeloVeiculo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdModeloVeiculo2ActionPerformed

        modeloVc = JOptionPane.showInputDialog(null, "Digite o modelo do veículo :");
        if (modeloVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o modelo do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaModeloVeiculo();
        }
    }//GEN-LAST:event_jRdModeloVeiculo2ActionPerformed

    private void jRdDataSaidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdDataSaidaActionPerformed

        try {
            FrmConsultaDataSaida frmConsultaData = new FrmConsultaDataSaida(this);
            TelaPrincipal.areaTrabalhoCadastros.add(frmConsultaData);
            frmConsultaData.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasModuloPorteiro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRdDataSaidaActionPerformed

    private void jRdNomeProprietario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeProprietario2ActionPerformed

        nomeProp = JOptionPane.showInputDialog(null, "Digite o nome do proprietário :");
        if (nomeProp.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do proprietário para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaNomeProprietario();
        }
    }//GEN-LAST:event_jRdNomeProprietario2ActionPerformed

    private void jRdCorVeiculo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdCorVeiculo2ActionPerformed

        corVc = JOptionPane.showInputDialog(null, "Digite a cor do veículo :");
        if (corVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a cor do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaCorVeiculo();
        }
    }//GEN-LAST:event_jRdCorVeiculo2ActionPerformed

    private void TbSaidasVeiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbSaidasVeiculosMouseClicked

        String numPlaca = "" + TbSaidasVeiculos.getValueAt(TbSaidasVeiculos.getSelectedRow(), 2);
        try {
            try {
                FrmDetalhesProprietario frmprop = new FrmDetalhesProprietario(numPlaca);
                TelaPrincipal.areaTrabalhoConsultas.add(frmprop);
                frmprop.setVisible(true);
            } catch (SQLException ex) {
            }
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_TbSaidasVeiculosMouseClicked

    private void TbMoradoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbMoradoresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TbMoradoresMouseClicked

    private void jRdNomePorteiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomePorteiroActionPerformed

        nomePort = JOptionPane.showInputDialog(null, "Digite o nome do porteiro :");
        if (nomePort.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do porteiro para realizar a consulta!!");
        } else {
            atualizarTabelaEntradaNomePorteiro();
        }
    }//GEN-LAST:event_jRdNomePorteiroActionPerformed

    private void jRdNomePorteiro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomePorteiro2ActionPerformed

        nomePort = JOptionPane.showInputDialog(null, "Digite o nome do porteiro :");
        if (nomePort.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do porteiro para realizar a consulta!!");
        } else {
            atualizarTabelaSaidaNomePorteiro();
        }
    }//GEN-LAST:event_jRdNomePorteiro2ActionPerformed

    private void BtConsultarTodosMoradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarTodosMoradoresActionPerformed

        atualizarTabelaTodosMoradores();
    }//GEN-LAST:event_BtConsultarTodosMoradoresActionPerformed

    private void jRdRgPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdRgPortActionPerformed

        Rg = JOptionPane.showInputDialog(null, "Digite a rg do morador");
        if (Rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a rg do morador que deseja consultar!!");
        } else {
            atualizarTabelaRgMorador();
        }
    }//GEN-LAST:event_jRdRgPortActionPerformed

    private void jRdNomePortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomePortActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite o nome do morador");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do morador que deseja consultar!!");
        } else {
            atualizarTabelaNomeMorador();
        }
    }//GEN-LAST:event_jRdNomePortActionPerformed

    private void jRdRgHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdRgHospedeActionPerformed

        Rg = JOptionPane.showInputDialog(null, "Digite a rg do hóspede");
        if (Rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a rg do hóspede que deseja consultar!!");
        } else {
            atualizarTabelaRgHospede();
        }
    }//GEN-LAST:event_jRdRgHospedeActionPerformed

    private void jRdNomeHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeHospedeActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite o nome do hóspede");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do hóspede que deseja consultar!!");
        } else {
            atualizarTabelaNomeHospede();
        }
    }//GEN-LAST:event_jRdNomeHospedeActionPerformed

    private void BtConsultarTodosHospedesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarTodosHospedesActionPerformed

        atualizarTabelaTodosHospedes();
    }//GEN-LAST:event_BtConsultarTodosHospedesActionPerformed

    private void TbHospedesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbHospedesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TbHospedesMouseClicked

    private void jRdRgVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdRgVisitanteActionPerformed

        Rg = JOptionPane.showInputDialog(null, "Digite a rg do visitante");
        if (Rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a rg do visitante que deseja consultar!!");
        } else {
            atualizarTabelaRgVisitante();
        }
    }//GEN-LAST:event_jRdRgVisitanteActionPerformed

    private void jRdNomeVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeVisitanteActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite o nome do visitante");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do visitante que deseja consultar!!");
        } else {
            atualizarTabelaNomeVisitante();
        }
    }//GEN-LAST:event_jRdNomeVisitanteActionPerformed

    private void BtConsultarTodosVisitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarTodosVisitantesActionPerformed

        atualizarTabelaTodosVisitantes();
    }//GEN-LAST:event_BtConsultarTodosVisitantesActionPerformed

    private void TbVisitantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbVisitantesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TbVisitantesMouseClicked

    private void jRdRgFuncPrestadorServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdRgFuncPrestadorServicoActionPerformed

        Rg = JOptionPane.showInputDialog(null, "Digite a rg do funcionário prestador de serviço");
        if (Rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a rg do funcionário prestador de serviço que deseja consultar!!");
        } else {
            atualizarTabelaRgPrestadorServico();
        }
    }//GEN-LAST:event_jRdRgFuncPrestadorServicoActionPerformed

    private void jRdNomeFuncPrestadorServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeFuncPrestadorServicoActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite o nome do funcionário prestador de serviço");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do funcionário prestador de serviço que deseja consultar!!");
        } else {
            atualizarTabelaNomeFuncionarioPrestadorServico();
        }
    }//GEN-LAST:event_jRdNomeFuncPrestadorServicoActionPerformed

    private void BtConsultarTodosFuncionariosPrestadoresServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarTodosFuncionariosPrestadoresServicosActionPerformed

        atualizarTabelaTodosPrestadoresServicos();
    }//GEN-LAST:event_BtConsultarTodosFuncionariosPrestadoresServicosActionPerformed

    private void TbPrestadoresServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPrestadoresServicosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TbPrestadoresServicosMouseClicked

    private void jRdNomeEmpresaPrestadoraServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeEmpresaPrestadoraServicoActionPerformed

        nomeEmp = JOptionPane.showInputDialog(null, "Digite o nome da empresa prestadora de serviço");
        if (nomeEmp.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome da empresa prestadora de serviço que deseja consultar!!");
        } else {
            atualizarTabelaNomeEmpresaPrestadoraServico();
        }
    }//GEN-LAST:event_jRdNomeEmpresaPrestadoraServicoActionPerformed

    private void jRdRgFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdRgFuncionarioActionPerformed

        Rg = JOptionPane.showInputDialog(null, "Digite a rg do funcionário do hotel");
        if (Rg.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a rg do funcionário do hotel que deseja consultar!!");
        } else {
            atualizarTabelaRgFuncionariosHotel();
        }
    }//GEN-LAST:event_jRdRgFuncionarioActionPerformed

    private void jRdNomeFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeFuncionarioActionPerformed

        nomePs = JOptionPane.showInputDialog(null, "Digite o nome do funcionário do hotel");
        if (nomePs.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do funcionário do hotel que deseja consultar!!");
        } else {
            atualizarTabelaNomeFuncionarioHotel();
        }
    }//GEN-LAST:event_jRdNomeFuncionarioActionPerformed

    private void BtConsultarTodosFuncionariosHotelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarTodosFuncionariosHotelActionPerformed

        atualizarTabelaTodosFuncionariosHotel();
    }//GEN-LAST:event_BtConsultarTodosFuncionariosHotelActionPerformed

    private void TbFuncionariosHotelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbFuncionariosHotelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TbFuncionariosHotelMouseClicked

    private void jRdSetorFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdSetorFuncionarioActionPerformed

        nomeSets = JOptionPane.showInputDialog(null, "Digite o setor do funcionário do hotel");
        if (nomeSets.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o setor do funcionário do hotel que deseja consultar!!");
        } else {
            atualizarTabelaSetorFuncionarioHotel();
        }
    }//GEN-LAST:event_jRdSetorFuncionarioActionPerformed

    private void jRdNomePorteiro3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomePorteiro3ActionPerformed

        nomePort = JOptionPane.showInputDialog(null, "Digite o nome do porteiro :");
        if (nomePort.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do porteiro para realizar a consulta!!");
        } else {
            atualizarTabelaNomePorteiro();
        }
    }//GEN-LAST:event_jRdNomePorteiro3ActionPerformed

    private void BtConsultarTodosPorteirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarTodosPorteirosActionPerformed

        atualizarTabelaTodosPorteiros();
    }//GEN-LAST:event_BtConsultarTodosPorteirosActionPerformed

    private void TbPorteirosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbPorteirosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TbPorteirosMouseClicked

    private void jRdPlacaVeiculo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdPlacaVeiculo3ActionPerformed

        placaVc = JOptionPane.showInputDialog(null, "Digite a placa do veículo :");
        if (placaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a placa do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaPlacaVeiculo();
        }
    }//GEN-LAST:event_jRdPlacaVeiculo3ActionPerformed

    private void jRdNomeProprietario3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdNomeProprietario3ActionPerformed

        nomeProp = JOptionPane.showInputDialog(null, "Digite o nome do proprietário :");
        if (nomeProp.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o nome do proprietário para realizar a consulta!!");
        } else {
            atualizarTabelaNomeProprietario();
        }
    }//GEN-LAST:event_jRdNomeProprietario3ActionPerformed

    private void jRdMarcaVaeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdMarcaVaeiculoActionPerformed

        marcaVc = JOptionPane.showInputDialog(null, "Digite a marca do veículo :");
        if (marcaVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite a marca do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaMarcaVeiculo();
        }
    }//GEN-LAST:event_jRdMarcaVaeiculoActionPerformed

    private void BtConsultarTodosVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtConsultarTodosVeiculosActionPerformed

        atualizarTabelaTodosVeiculos();
    }//GEN-LAST:event_BtConsultarTodosVeiculosActionPerformed

    private void jRdMarcaVaeiculo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRdMarcaVaeiculo1ActionPerformed

        modeloVc = JOptionPane.showInputDialog(null, "Digite o modelo do veículo :");
        if (modeloVc.equals("")) {
            JOptionPane.showMessageDialog(null, "Digite o modelo do veículo para realizar a consulta!!");
        } else {
            atualizarTabelaModeloVeiculo();
        }
    }//GEN-LAST:event_jRdMarcaVaeiculo1ActionPerformed

    public void preencherTabelaEntradaVeiculo(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Entrada", "Hora Entrada", "Placa Veículo", "Modelo Veículo", "Marca Veículo", "Cor Veículo"};
        conEntVc.conexao();
        conEntVc.executaSQL(SQL);
        try {
            conEntVc.rs.first();
            do {
                dados.add(new Object[]{conEntVc.rs.getString("Data_Ent_Vc"), conEntVc.rs.getString("Hora_Ent_Vc"), conEntVc.rs.getString("Placa_Vc"), conEntVc.rs.getString("desc_md"), conEntVc.rs.getString("desc_mc"), conEntVc.rs.getString("desc_cor")});
            } while (conEntVc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma entrada com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbEntradasVeiculos.setModel(modTabela);
        TbEntradasVeiculos.getColumnModel().getColumn(0).setPreferredWidth(91);
        TbEntradasVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(1).setPreferredWidth(91);
        TbEntradasVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(2).setPreferredWidth(120);
        TbEntradasVeiculos.getColumnModel().getColumn(2).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(3).setPreferredWidth(126);
        TbEntradasVeiculos.getColumnModel().getColumn(3).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(4).setPreferredWidth(126);
        TbEntradasVeiculos.getColumnModel().getColumn(4).setResizable(false);
        TbEntradasVeiculos.getColumnModel().getColumn(5).setPreferredWidth(120);
        TbEntradasVeiculos.getColumnModel().getColumn(5).setResizable(false);
        TbEntradasVeiculos.getTableHeader().setReorderingAllowed(false);
        TbEntradasVeiculos.setAutoResizeMode(TbEntradasVeiculos.AUTO_RESIZE_OFF);
        TbEntradasVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conEntVc.desconecta();
    }

    public void preencherTabelaSaidaVeiculo(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Data Saída", "Hora Saída", "Placa Veículo", "Modelo Veículo", "Marca Veículo", "Cor Veículo"};
        conSaidVc.conexao();
        conSaidVc.executaSQL(SQL);
        try {
            conSaidVc.rs.first();
            do {
                dados.add(new Object[]{conSaidVc.rs.getString("Data_Said_Vc"), conSaidVc.rs.getString("Hora_Said_Vc"), conSaidVc.rs.getString("Placa_Vc"), conSaidVc.rs.getString("desc_md"), conSaidVc.rs.getString("desc_mc"), conSaidVc.rs.getString("desc_cor")});
            } while (conSaidVc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma saída com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbSaidasVeiculos.setModel(modTabela);
        TbSaidasVeiculos.getColumnModel().getColumn(0).setPreferredWidth(91);
        TbSaidasVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbSaidasVeiculos.getColumnModel().getColumn(1).setPreferredWidth(91);
        TbSaidasVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbSaidasVeiculos.getColumnModel().getColumn(2).setPreferredWidth(120);
        TbSaidasVeiculos.getColumnModel().getColumn(2).setResizable(false);
        TbSaidasVeiculos.getColumnModel().getColumn(3).setPreferredWidth(126);
        TbSaidasVeiculos.getColumnModel().getColumn(3).setResizable(false);
        TbSaidasVeiculos.getColumnModel().getColumn(4).setPreferredWidth(126);
        TbSaidasVeiculos.getColumnModel().getColumn(4).setResizable(false);
        TbSaidasVeiculos.getColumnModel().getColumn(5).setPreferredWidth(120);
        TbSaidasVeiculos.getColumnModel().getColumn(5).setResizable(false);
        TbSaidasVeiculos.getTableHeader().setReorderingAllowed(false);
        TbSaidasVeiculos.setAutoResizeMode(TbSaidasVeiculos.AUTO_RESIZE_OFF);
        TbSaidasVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conSaidVc.desconecta();
    }

    public void preencherTabelaMorador(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Rg", "Nome Morador", "Fone Fixo", "Fone Celular", "E-mail", "Apt", "Ramal", "Torre"};
        conMr.conexao();
        conMr.executaSQL(SQL);
        try {
            conMr.rs.first();
            do {
                dados.add(new Object[]{conMr.rs.getString("rg_ps"), conMr.rs.getString("nome_ps"), conMr.rs.getString("fone_fixo"), conMr.rs.getString("celular_ps"), conMr.rs.getString("email_ps"), conMr.rs.getString("num_apt"), conMr.rs.getString("ramal_apt"), conMr.rs.getString("desc_trr")});
            } while (conMr.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum morador com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbMoradores.setModel(modTabela);
        TbMoradores.getColumnModel().getColumn(0).setPreferredWidth(80);
        TbMoradores.getColumnModel().getColumn(0).setResizable(false);
        TbMoradores.getColumnModel().getColumn(1).setPreferredWidth(150);
        TbMoradores.getColumnModel().getColumn(1).setResizable(false);
        TbMoradores.getColumnModel().getColumn(2).setPreferredWidth(80);
        TbMoradores.getColumnModel().getColumn(2).setResizable(false);
        TbMoradores.getColumnModel().getColumn(3).setPreferredWidth(80);
        TbMoradores.getColumnModel().getColumn(3).setResizable(false);
        TbMoradores.getColumnModel().getColumn(4).setPreferredWidth(200);
        TbMoradores.getColumnModel().getColumn(4).setResizable(false);
        TbMoradores.getColumnModel().getColumn(5).setPreferredWidth(40);
        TbMoradores.getColumnModel().getColumn(5).setResizable(false);
        TbMoradores.getColumnModel().getColumn(6).setPreferredWidth(40);
        TbMoradores.getColumnModel().getColumn(6).setResizable(false);
        TbMoradores.getColumnModel().getColumn(7).setPreferredWidth(60);
        TbMoradores.getColumnModel().getColumn(7).setResizable(false);
        TbMoradores.getColumnModel().getColumn(8).setPreferredWidth(80);
        TbMoradores.getColumnModel().getColumn(8).setResizable(false);
        TbMoradores.getTableHeader().setReorderingAllowed(false);
        TbMoradores.setAutoResizeMode(TbMoradores.AUTO_RESIZE_OFF);
        TbMoradores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conMr.desconecta();
    }

    public void preencherTabelaHospede(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Rg", "Nome Hóspede", "Fone Fixo", "Fone Celular", "E-mail", "Apt", "Ramal", "Torre"};
        conHsp.conexao();
        conHsp.executaSQL(SQL);
        try {
            conHsp.rs.first();
            do {
                dados.add(new Object[]{conHsp.rs.getString("rg_ps"), conHsp.rs.getString("nome_ps"), conHsp.rs.getString("fone_fixo"), conHsp.rs.getString("celular_ps"), conHsp.rs.getString("email_ps"), conHsp.rs.getString("num_apt"), conHsp.rs.getString("ramal_apt"), conHsp.rs.getString("desc_trr")});
            } while (conHsp.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum hóspede com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbHospedes.setModel(modTabela);
        TbHospedes.getColumnModel().getColumn(0).setPreferredWidth(80);
        TbHospedes.getColumnModel().getColumn(0).setResizable(false);
        TbHospedes.getColumnModel().getColumn(1).setPreferredWidth(150);
        TbHospedes.getColumnModel().getColumn(1).setResizable(false);
        TbHospedes.getColumnModel().getColumn(2).setPreferredWidth(80);
        TbHospedes.getColumnModel().getColumn(2).setResizable(false);
        TbHospedes.getColumnModel().getColumn(3).setPreferredWidth(80);
        TbHospedes.getColumnModel().getColumn(3).setResizable(false);
        TbHospedes.getColumnModel().getColumn(4).setPreferredWidth(200);
        TbHospedes.getColumnModel().getColumn(4).setResizable(false);
        TbHospedes.getColumnModel().getColumn(5).setPreferredWidth(38);
        TbHospedes.getColumnModel().getColumn(5).setResizable(false);
        TbHospedes.getColumnModel().getColumn(6).setPreferredWidth(38);
        TbHospedes.getColumnModel().getColumn(6).setResizable(false);
        TbHospedes.getColumnModel().getColumn(7).setPreferredWidth(59);
        TbHospedes.getColumnModel().getColumn(7).setResizable(false);
        TbHospedes.getColumnModel().getColumn(8).setPreferredWidth(80);
        TbHospedes.getColumnModel().getColumn(8).setResizable(false);
        TbHospedes.getTableHeader().setReorderingAllowed(false);
        TbHospedes.setAutoResizeMode(TbHospedes.AUTO_RESIZE_OFF);
        TbHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conHsp.desconecta();
    }

    public void preencherTabelaVisitante(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Rg", "Nome Visitante", "Observações Visitante"};
        conVis.conexao();
        conVis.executaSQL(SQL);
        try {
            conVis.rs.first();
            do {
                dados.add(new Object[]{conVis.rs.getString("rg_ps"), conVis.rs.getString("nome_ps"), conVis.rs.getString("obs_vis")});
            } while (conVis.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum visitante com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbVisitantes.setModel(modTabela);
        TbVisitantes.getColumnModel().getColumn(0).setPreferredWidth(80);
        TbVisitantes.getColumnModel().getColumn(0).setResizable(false);
        TbVisitantes.getColumnModel().getColumn(1).setPreferredWidth(250);
        TbVisitantes.getColumnModel().getColumn(1).setResizable(false);
        TbVisitantes.getColumnModel().getColumn(2).setPreferredWidth(510);
        TbVisitantes.getColumnModel().getColumn(2).setResizable(false);
        TbVisitantes.getTableHeader().setReorderingAllowed(false);
        TbVisitantes.setAutoResizeMode(TbVisitantes.AUTO_RESIZE_OFF);
        TbVisitantes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conVis.desconecta();
    }

    public void preencherTabelaPrestadoresServicos(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Rg", "Nome Funcionário Prestador", "Empresa Prestadora"};
        conPrst.conexao();
        conPrst.executaSQL(SQL);
        try {
            conPrst.rs.first();
            do {
                dados.add(new Object[]{conPrst.rs.getString("rg_ps"), conPrst.rs.getString("nome_ps"), conPrst.rs.getString("desc_forn")});
            } while (conPrst.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum funcionário prestador de serviço com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPrestadoresServicos.setModel(modTabela);
        TbPrestadoresServicos.getColumnModel().getColumn(0).setPreferredWidth(80);
        TbPrestadoresServicos.getColumnModel().getColumn(0).setResizable(false);
        TbPrestadoresServicos.getColumnModel().getColumn(1).setPreferredWidth(250);
        TbPrestadoresServicos.getColumnModel().getColumn(1).setResizable(false);
        TbPrestadoresServicos.getColumnModel().getColumn(2).setPreferredWidth(510);
        TbPrestadoresServicos.getColumnModel().getColumn(2).setResizable(false);
        TbPrestadoresServicos.getTableHeader().setReorderingAllowed(false);
        TbPrestadoresServicos.setAutoResizeMode(TbPrestadoresServicos.AUTO_RESIZE_OFF);
        TbPrestadoresServicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conPrst.desconecta();
    }

    public void preencherTabelaFuncionariosHotel(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Rg", "Nome Funcionário Hotel", "Setor"};
        conFuncHt.conexao();
        conFuncHt.executaSQL(SQL);
        try {
            conFuncHt.rs.first();
            do {
                dados.add(new Object[]{conFuncHt.rs.getString("rg_ps"), conFuncHt.rs.getString("nome_ps"), conFuncHt.rs.getString("desc_sets")});
            } while (conFuncHt.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum funcionário do hotel com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbFuncionariosHotel.setModel(modTabela);
        TbFuncionariosHotel.getColumnModel().getColumn(0).setPreferredWidth(80);
        TbFuncionariosHotel.getColumnModel().getColumn(0).setResizable(false);
        TbFuncionariosHotel.getColumnModel().getColumn(1).setPreferredWidth(250);
        TbFuncionariosHotel.getColumnModel().getColumn(1).setResizable(false);
        TbFuncionariosHotel.getColumnModel().getColumn(2).setPreferredWidth(510);
        TbFuncionariosHotel.getColumnModel().getColumn(2).setResizable(false);
        TbFuncionariosHotel.getTableHeader().setReorderingAllowed(false);
        TbFuncionariosHotel.setAutoResizeMode(TbFuncionariosHotel.AUTO_RESIZE_OFF);
        TbPrestadoresServicos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conFuncHt.desconecta();
    }

    public void preencherTabelaPorteiros(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Nome Funcionário Hotel"};
        conPort.conexao();
        conPort.executaSQL(SQL);
        try {
            conPort.rs.first();
            do {
                dados.add(new Object[]{conPort.rs.getString("nome_port")});
            } while (conPort.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhum porteiro com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbPorteiros.setModel(modTabela);
        TbPorteiros.getColumnModel().getColumn(0).setPreferredWidth(840);
        TbPorteiros.getColumnModel().getColumn(0).setResizable(false);
        TbPorteiros.setAutoResizeMode(TbPorteiros.AUTO_RESIZE_OFF);
        TbPorteiros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conPort.desconecta();
    }

    public void preencherTabelaVeiculo(String SQL) {

        ArrayList dados = new ArrayList();
        String[] Colunas = new String[]{"Placa Veículo", "Marca Veículo", "Modelo Veículo", "Cor Veículo", "Proprietário", "Detalhes Proprietário",};
        conVc.conexao();
        conVc.executaSQL(SQL);
        try {
            conVc.rs.first();
            do {
                dados.add(new Object[]{conVc.rs.getString("Placa_Vc"), conVc.rs.getString("desc_mc"), conVc.rs.getString("desc_md"), conVc.rs.getString("desc_cor"), conVc.rs.getString("nome_ps"), conVc.rs.getString("detalhes_prop")});
            } while (conVc.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não existe nenhuma entrada com essas credenciais");
        }
        ModeloTabela modTabela = new ModeloTabela(dados, Colunas);
        TbVeiculos.setModel(modTabela);
        TbVeiculos.getColumnModel().getColumn(0).setPreferredWidth(90);
        TbVeiculos.getColumnModel().getColumn(0).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(1).setPreferredWidth(100);
        TbVeiculos.getColumnModel().getColumn(1).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(2).setPreferredWidth(96);
        TbVeiculos.getColumnModel().getColumn(2).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(3).setPreferredWidth(88);
        TbVeiculos.getColumnModel().getColumn(3).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(4).setPreferredWidth(180);
        TbVeiculos.getColumnModel().getColumn(4).setResizable(false);
        TbVeiculos.getColumnModel().getColumn(5).setPreferredWidth(286);
        TbVeiculos.getColumnModel().getColumn(5).setResizable(false);
        TbVeiculos.getTableHeader().setReorderingAllowed(false);
        TbVeiculos.setAutoResizeMode(TbVeiculos.AUTO_RESIZE_OFF);
        TbVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conVc.desconecta();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbaEntradaVeiculos;
    private javax.swing.JPanel AbaSaidasVeiculos;
    private javax.swing.JPanel AbaTodosCadastros;
    private javax.swing.JTabbedPane Abas;
    private javax.swing.JTabbedPane AbasConsultas;
    private javax.swing.JButton BtCancelar;
    private javax.swing.JButton BtConsultarTodosFuncionariosHotel;
    private javax.swing.JButton BtConsultarTodosFuncionariosPrestadoresServicos;
    private javax.swing.JButton BtConsultarTodosHospedes;
    private javax.swing.JButton BtConsultarTodosMoradores;
    private javax.swing.JButton BtConsultarTodosPorteiros;
    private javax.swing.JButton BtConsultarTodosVeiculos;
    private javax.swing.JButton BtConsultarTodosVisitantes;
    private javax.swing.ButtonGroup RdGroupTiposConsultas;
    private javax.swing.ButtonGroup RdGroupTiposConsultas2;
    private javax.swing.ButtonGroup RdGroupTiposConsultasMoradores;
    private javax.swing.JTable TbEntradasVeiculos;
    private javax.swing.JTable TbFuncionariosHotel;
    private javax.swing.JTable TbHospedes;
    private javax.swing.JTable TbMoradores;
    private javax.swing.JTable TbPorteiros;
    private javax.swing.JTable TbPrestadoresServicos;
    private javax.swing.JTable TbSaidasVeiculos;
    private javax.swing.JTable TbVeiculos;
    private javax.swing.JTable TbVisitantes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRdCorVeiculo;
    private javax.swing.JRadioButton jRdCorVeiculo2;
    private javax.swing.JRadioButton jRdDataEntrada;
    private javax.swing.JRadioButton jRdDataSaida;
    private javax.swing.JRadioButton jRdMarcaVaeiculo;
    private javax.swing.JRadioButton jRdMarcaVaeiculo1;
    private javax.swing.JRadioButton jRdMarcaVeiculo;
    private javax.swing.JRadioButton jRdMarcaVeiculo2;
    private javax.swing.JRadioButton jRdModeloVeiculo;
    private javax.swing.JRadioButton jRdModeloVeiculo2;
    private javax.swing.JRadioButton jRdNomeEmpresaPrestadoraServico;
    private javax.swing.JRadioButton jRdNomeFuncPrestadorServico;
    private javax.swing.JRadioButton jRdNomeFuncionario;
    private javax.swing.JRadioButton jRdNomeHospede;
    private javax.swing.JRadioButton jRdNomePort;
    private javax.swing.JRadioButton jRdNomePorteiro;
    private javax.swing.JRadioButton jRdNomePorteiro2;
    private javax.swing.JRadioButton jRdNomePorteiro3;
    private javax.swing.JRadioButton jRdNomeProprietario;
    private javax.swing.JRadioButton jRdNomeProprietario2;
    private javax.swing.JRadioButton jRdNomeProprietario3;
    private javax.swing.JRadioButton jRdNomeVisitante;
    private javax.swing.JRadioButton jRdPlacaVeiculo;
    private javax.swing.JRadioButton jRdPlacaVeiculo2;
    private javax.swing.JRadioButton jRdPlacaVeiculo3;
    private javax.swing.JRadioButton jRdRgFuncPrestadorServico;
    private javax.swing.JRadioButton jRdRgFuncionario;
    private javax.swing.JRadioButton jRdRgHospede;
    private javax.swing.JRadioButton jRdRgPort;
    private javax.swing.JRadioButton jRdRgVisitante;
    private javax.swing.JRadioButton jRdSetorFuncionario;
    private javax.swing.JRadioButton jRdTodasEntradas;
    private javax.swing.JRadioButton jRdTodasSaidas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
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

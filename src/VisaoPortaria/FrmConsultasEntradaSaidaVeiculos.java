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

public class FrmConsultasEntradaSaidaVeiculos extends javax.swing.JInternalFrame {

    ConectaBanco conEntVc = new ConectaBanco();
    ConectaBanco conSaidVc = new ConectaBanco();
    Funcoes abrirTela = new Funcoes();
    Funcoes consultar = new Funcoes();
    String nomeProp, nomePort, placaVc, marcaVc, modeloVc, corVc, nomePs, Rg, nomeEmp, nomeSets;
    private String data_ini, data_fin;

    public FrmConsultasEntradaSaidaVeiculos() throws SQLException {

        initComponents();
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
        BtCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consultar Entradas e Saídas de Veículos ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("Consultar Entrada e Saída de Veículos");

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
                abrirTela.centralizarFormularioConsultas(frmprop);
            } catch (SQLException ex) {
                Logger.getLogger(FrmConsultasEntradaSaidaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
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
            abrirTela.centralizarFormularioConsultas(frmConsultaData);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar.setConsulta("entradaVeiculo");
        
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
            abrirTela.centralizarFormularioConsultas(frmConsultaData);
        } catch (SQLException ex) {
            Logger.getLogger(FrmConsultasEntradaSaidaVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        consultar.setConsulta("saidaVeiculo");
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
                abrirTela.centralizarFormularioConsultas(frmprop);
            } catch (SQLException ex) {
            }
        } catch (ParseException ex) {
        }
    }//GEN-LAST:event_TbSaidasVeiculosMouseClicked

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AbaEntradaVeiculos;
    private javax.swing.JPanel AbaSaidasVeiculos;
    private javax.swing.JTabbedPane AbasConsultas;
    private javax.swing.JButton BtCancelar;
    private javax.swing.ButtonGroup RdGroupTiposConsultas;
    private javax.swing.ButtonGroup RdGroupTiposConsultas2;
    private javax.swing.ButtonGroup RdGroupTiposConsultasMoradores;
    private javax.swing.JTable TbEntradasVeiculos;
    private javax.swing.JTable TbSaidasVeiculos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JRadioButton jRdCorVeiculo;
    private javax.swing.JRadioButton jRdCorVeiculo2;
    private javax.swing.JRadioButton jRdDataEntrada;
    private javax.swing.JRadioButton jRdDataSaida;
    private javax.swing.JRadioButton jRdMarcaVeiculo;
    private javax.swing.JRadioButton jRdMarcaVeiculo2;
    private javax.swing.JRadioButton jRdModeloVeiculo;
    private javax.swing.JRadioButton jRdModeloVeiculo2;
    private javax.swing.JRadioButton jRdNomePorteiro;
    private javax.swing.JRadioButton jRdNomePorteiro2;
    private javax.swing.JRadioButton jRdNomeProprietario;
    private javax.swing.JRadioButton jRdNomeProprietario2;
    private javax.swing.JRadioButton jRdPlacaVeiculo;
    private javax.swing.JRadioButton jRdPlacaVeiculo2;
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

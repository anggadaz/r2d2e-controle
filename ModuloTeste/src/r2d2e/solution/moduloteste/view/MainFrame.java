/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * mainFrame.java
 *
 * Created on 01/03/2010, 22:11:01
 */

package r2d2e.solution.moduloteste.view;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import r2d2e.solution.moduloteste.domain.BarChart;
import r2d2e.solution.moduloteste.domain.HistoChart;
import r2d2e.solution.moduloteste.domain.controlerInterface;
import r2d2e.solution.moduloteste.handler.MainFrameHandler;


/**
 *
 * @author Demétrios
 */
public class MainFrame extends javax.swing.JFrame {

    private MainFrameHandler mainFrameHandler = new MainFrameHandler(this);

    /** Creates new form mainFrame */
    public MainFrame() {
        initComponents();
        init();
        initChart();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        controlerInterface.tanquePanel = tanquePanel;
        controlerInterface.mainFrameHandler = mainFrameHandler;
        buttonPararTeste.setEnabled(false);
        buttonNovoCiclo.setEnabled(false);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroup = new javax.swing.ButtonGroup();
        menuPanel = new javax.swing.JPanel();
        buttonIniciarTeste = new javax.swing.JButton();
        buttonPararTeste = new javax.swing.JButton();
        buttonNovoCiclo = new javax.swing.JButton();
        separador = new javax.swing.JSeparator();
        spGeral = new javax.swing.JSplitPane();
        confPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spinnerTI = new javax.swing.JSpinner();
        spinnerTMax = new javax.swing.JSpinner();
        spinnerNA = new javax.swing.JSpinner();
        spinnerTMin = new javax.swing.JSpinner();
        contentPanel = new javax.swing.JPanel();
        spTabela = new javax.swing.JSplitPane();
        spTanque = new javax.swing.JSplitPane();
        tanquePanel = new r2d2e.solution.moduloteste.view.TanquePanel();
        panelGrafico = new javax.swing.JTabbedPane();
        graficoTensao = new javax.swing.JPanel();
        graficoNivel = new javax.swing.JPanel();
        tabelaPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        mediaField = new javax.swing.JTextField();
        Exportar = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        arquivoMenu = new javax.swing.JMenu();
        SalvarConfig = new javax.swing.JMenuItem();
        CarregarConfig = new javax.swing.JMenuItem();
        separadorMenu = new javax.swing.JSeparator();
        SairMenu = new javax.swing.JMenuItem();
        Ajuda = new javax.swing.JMenu();
        sobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Módulo de Teste");
        setName("mainFrame"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        buttonIniciarTeste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/play.png"))); // NOI18N
        buttonIniciarTeste.setToolTipText("Iniciar Teste");
        buttonIniciarTeste.setBorder(null);
        buttonIniciarTeste.setBorderPainted(false);
        buttonIniciarTeste.setContentAreaFilled(false);
        buttonIniciarTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIniciarTesteActionPerformed(evt);
            }
        });

        buttonPararTeste.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/play_stop.png"))); // NOI18N
        buttonPararTeste.setToolTipText("Parar Teste");
        buttonPararTeste.setBorderPainted(false);
        buttonPararTeste.setContentAreaFilled(false);
        buttonPararTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPararTesteActionPerformed(evt);
            }
        });

        buttonNovoCiclo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/cycle.png"))); // NOI18N
        buttonNovoCiclo.setToolTipText("Efetuar novo Ciclo");
        buttonNovoCiclo.setBorderPainted(false);
        buttonNovoCiclo.setContentAreaFilled(false);
        buttonNovoCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoCicloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonIniciarTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonPararTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonNovoCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(837, Short.MAX_VALUE))
            .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonIniciarTeste, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonPararTeste, 0, 0, Short.MAX_VALUE)
                    .addComponent(buttonNovoCiclo, 0, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        spGeral.setDividerLocation(310);
        spGeral.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        spGeral.setOneTouchExpandable(true);

        confPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Configurações"));

        jLabel1.setText("Tensão Mínima :");

        jLabel2.setText("Tensão Máxima :");

        jLabel3.setText("Tensão de Incremento :");

        jLabel4.setText("Nível da Água :");

        jLabel5.setText("cm");

        jLabel6.setText("Volts");

        jLabel7.setText("Volts");

        jLabel8.setText("Volts");

        spinnerTI.setModel(new javax.swing.SpinnerNumberModel(0.0, 0.0, 3.0, 0.1));
        spinnerTI.setToolTipText("Quanto a tensão irá variar");
        spinnerTI.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerTI, "#,##0.0#"));

        spinnerTMax.setModel(new javax.swing.SpinnerNumberModel(1.0, 0.0, 3.0, 0.1));
        spinnerTMax.setToolTipText("Tensão Máxima do motor");
        spinnerTMax.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerTMax, "#,##0.0#"));

        spinnerNA.setModel(new javax.swing.SpinnerNumberModel(0.0, 0.0, 30.0, 0.1));
        spinnerNA.setToolTipText("Quanto a tensão irá variar");
        spinnerNA.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerNA, "#,##0.0#"));

        spinnerTMin.setModel(new javax.swing.SpinnerNumberModel(1.0, 0.0, 3.0, 0.1));
        spinnerTMin.setToolTipText("Tensão Máxima do motor");
        spinnerTMin.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerTMin, "#,##0.0#"));

        javax.swing.GroupLayout confPanelLayout = new javax.swing.GroupLayout(confPanel);
        confPanel.setLayout(confPanelLayout);
        confPanelLayout.setHorizontalGroup(
            confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spinnerNA, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spinnerTI, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(spinnerTMax, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(spinnerTMin, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        confPanelLayout.setVerticalGroup(
            confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confPanelLayout.createSequentialGroup()
                .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(confPanelLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(spinnerNA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(confPanelLayout.createSequentialGroup()
                        .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(spinnerTMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(spinnerTMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(confPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(spinnerTI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        spGeral.setBottomComponent(confPanel);

        spTabela.setDividerLocation(600);
        spTabela.setOneTouchExpandable(true);

        spTanque.setBackground(new java.awt.Color(255, 255, 255));
        spTanque.setDividerLocation(270);
        spTanque.setOneTouchExpandable(true);

        tanquePanel.setBackground(new java.awt.Color(153, 153, 153));
        tanquePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        tanquePanel.setOpaque(false);

        javax.swing.GroupLayout tanquePanelLayout = new javax.swing.GroupLayout(tanquePanel);
        tanquePanel.setLayout(tanquePanelLayout);
        tanquePanelLayout.setHorizontalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        tanquePanelLayout.setVerticalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );

        spTanque.setLeftComponent(tanquePanel);

        panelGrafico.setOpaque(true);
        panelGrafico.addTab("Tensão x Tempo", graficoTensao);
        panelGrafico.addTab("Nível x Tempo", graficoNivel);

        spTanque.setRightComponent(panelGrafico);

        spTabela.setLeftComponent(spTanque);

        tabelaPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tensão", "Tempo", "Km"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(table);

        jLabel9.setText("Km Médio :");

        mediaField.setEditable(false);
        mediaField.setToolTipText("Valor Médio de Km");

        Exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/export.png"))); // NOI18N
        Exportar.setToolTipText("Exportar as informações da tabela e do km médio");
        Exportar.setBorderPainted(false);
        Exportar.setContentAreaFilled(false);

        javax.swing.GroupLayout tabelaPanelLayout = new javax.swing.GroupLayout(tabelaPanel);
        tabelaPanel.setLayout(tabelaPanelLayout);
        tabelaPanelLayout.setHorizontalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelaPanelLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mediaField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
        );
        tabelaPanelLayout.setVerticalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelaPanelLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mediaField)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );

        spTabela.setRightComponent(tabelaPanel);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 966, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
        );

        spGeral.setLeftComponent(contentPanel);

        arquivoMenu.setText("Arquivo");

        SalvarConfig.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SalvarConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/save.png"))); // NOI18N
        SalvarConfig.setText("Salvar Configuração");
        arquivoMenu.add(SalvarConfig);

        CarregarConfig.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CarregarConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/load.jpg"))); // NOI18N
        CarregarConfig.setText("Carregar Configuração");
        arquivoMenu.add(CarregarConfig);
        arquivoMenu.add(separadorMenu);

        SairMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        SairMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/exit.png"))); // NOI18N
        SairMenu.setText("Sair");
        SairMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairMenuActionPerformed(evt);
            }
        });
        arquivoMenu.add(SairMenu);

        menuBar.add(arquivoMenu);

        Ajuda.setText("Ajuda");

        sobre.setText("Sobre");
        Ajuda.add(sobre);

        menuBar.add(Ajuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(spGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonIniciarTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonIniciarTesteActionPerformed
        // TODO add your handling code here:
        mainFrameHandler.initTest();
    }//GEN-LAST:event_buttonIniciarTesteActionPerformed

    private void buttonPararTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPararTesteActionPerformed
        // TODO add your handling code here:
        mainFrameHandler.stopTest();
    }//GEN-LAST:event_buttonPararTesteActionPerformed

    private void buttonNovoCicloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoCicloActionPerformed
        // TODO add your handling code here:
        mainFrameHandler.cycle();
    }//GEN-LAST:event_buttonNovoCicloActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        mainFrameHandler.closeConnection();
    }//GEN-LAST:event_formWindowClosing

    private void SairMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairMenuActionPerformed
        // TODO add your handling code here:
        mainFrameHandler.closeConnection();
        dispose();
    }//GEN-LAST:event_SairMenuActionPerformed

    public TanquePanel getTanquePanel() {
        return tanquePanel;
    }

    public JSpinner getSpinnerNA() {
        return spinnerNA;
    }

    public JSpinner getSpinnerTI() {
        return spinnerTI;
    }

    public JSpinner getSpinnerTMin() {
        return spinnerTMin;
    }

    public JSpinner getSpinnerTMax() {
        return spinnerTMax;
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getMediaField() {
        return mediaField;
    }

    public JButton getButtonIniciarTeste() {
        return buttonIniciarTeste;
    }

    public JButton getButtonNovoCiclo() {
        return buttonNovoCiclo;
    }

    public JButton getButtonPararTeste() {
        return buttonPararTeste;
    }

    private void init() {
        spTabela.setDividerLocation(1.0);
        spTanque.setDividerLocation(1.0);
        spGeral.setDividerLocation(1.0);
    }

    private void initChart() {
        controlerInterface.barChart = new BarChart();
        controlerInterface.histoChart = new HistoChart(30000);

        //controlerInterface.barChart.sample();

        graficoTensao.add(controlerInterface.barChart.getChart());
        graficoNivel.add(controlerInterface.histoChart.getChart());
    }

    public JPanel getBarChartPanel() {
        return graficoTensao;
    }

    private static void SkinInitialize() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        try { /*SubstanceBusinessLookAndFeel()*/
            UIManager.setLookAndFeel(new SubstanceBusinessBlackSteelLookAndFeel());
        } catch (Exception e) {
            System.out.println("Substance Raven Graphite failed to initialize");
        }
    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SkinInitialize();
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Ajuda;
    private javax.swing.JMenuItem CarregarConfig;
    private javax.swing.JButton Exportar;
    private javax.swing.JMenuItem SairMenu;
    private javax.swing.JMenuItem SalvarConfig;
    private javax.swing.JMenu arquivoMenu;
    private javax.swing.JButton buttonIniciarTeste;
    private javax.swing.JButton buttonNovoCiclo;
    private javax.swing.JButton buttonPararTeste;
    private javax.swing.JPanel confPanel;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel graficoNivel;
    private javax.swing.JPanel graficoTensao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField mediaField;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JTabbedPane panelGrafico;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSeparator separador;
    private javax.swing.JSeparator separadorMenu;
    private javax.swing.JMenuItem sobre;
    private javax.swing.JSplitPane spGeral;
    private javax.swing.JSplitPane spTabela;
    private javax.swing.JSplitPane spTanque;
    private javax.swing.JSpinner spinnerNA;
    private javax.swing.JSpinner spinnerTI;
    private javax.swing.JSpinner spinnerTMax;
    private javax.swing.JSpinner spinnerTMin;
    private javax.swing.JPanel tabelaPanel;
    private javax.swing.JTable table;
    private r2d2e.solution.moduloteste.view.TanquePanel tanquePanel;
    // End of variables declaration//GEN-END:variables

}

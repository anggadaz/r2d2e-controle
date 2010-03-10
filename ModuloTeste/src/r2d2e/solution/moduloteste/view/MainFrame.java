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

import javax.swing.JFrame;
import javax.swing.JSpinner;
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
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        controlerInterface.tanquePanel = tanquePanel;
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
        splitPane = new javax.swing.JSplitPane();
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
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        gráficoPanel = new javax.swing.JPanel();
        tanquePanel = new r2d2e.solution.moduloteste.view.TanquePanel();
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

        buttonIniciarTeste.setText("Iniciar Teste");
        buttonIniciarTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonIniciarTesteActionPerformed(evt);
            }
        });

        buttonPararTeste.setText("Parar Teste");
        buttonPararTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPararTesteActionPerformed(evt);
            }
        });

        buttonNovoCiclo.setText("Ciclo");
        buttonNovoCiclo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoCicloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(separador, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonIniciarTeste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonPararTeste)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNovoCiclo)
                .addContainerGap(688, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonIniciarTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonPararTeste, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNovoCiclo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        splitPane.setDividerLocation(250);
        splitPane.setDividerSize(7);
        splitPane.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        splitPane.setOneTouchExpandable(true);

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

        spinnerTMax.setModel(new javax.swing.SpinnerNumberModel(1.0, -3.0, 3.0, 0.1));
        spinnerTMax.setToolTipText("Tensão Máxima do motor");
        spinnerTMax.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerTMax, "#,##0.0#"));

        spinnerNA.setModel(new javax.swing.SpinnerNumberModel(0.0, 0.0, 30.0, 0.1));
        spinnerNA.setToolTipText("Quanto a tensão irá variar");
        spinnerNA.setEditor(new javax.swing.JSpinner.NumberEditor(spinnerNA, "#,##0.0#"));

        spinnerTMin.setModel(new javax.swing.SpinnerNumberModel(1.0, -3.0, 3.0, 0.1));
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
                    .addComponent(spinnerTI, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addComponent(spinnerTMax, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
                    .addComponent(spinnerTMin, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
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
                .addContainerGap(67, Short.MAX_VALUE))
        );

        splitPane.setBottomComponent(confPanel);

        jSplitPane2.setDividerSize(7);
        jSplitPane2.setOneTouchExpandable(true);

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setDividerLocation(270);
        jSplitPane1.setDividerSize(7);
        jSplitPane1.setOneTouchExpandable(true);

        gráficoPanel.setBackground(new java.awt.Color(255, 255, 255));
        gráficoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout gráficoPanelLayout = new javax.swing.GroupLayout(gráficoPanel);
        gráficoPanel.setLayout(gráficoPanelLayout);
        gráficoPanelLayout.setHorizontalGroup(
            gráficoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 169, Short.MAX_VALUE)
        );
        gráficoPanelLayout.setVerticalGroup(
            gráficoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 243, Short.MAX_VALUE)
        );

        jSplitPane1.setRightComponent(gráficoPanel);

        tanquePanel.setBackground(new java.awt.Color(255, 255, 255));
        tanquePanel.setOpaque(false);

        javax.swing.GroupLayout tanquePanelLayout = new javax.swing.GroupLayout(tanquePanel);
        tanquePanel.setLayout(tanquePanelLayout);
        tanquePanelLayout.setHorizontalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );
        tanquePanelLayout.setVerticalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );

        jSplitPane1.setLeftComponent(tanquePanel);

        jSplitPane2.setLeftComponent(jSplitPane1);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
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

        Exportar.setText("Ex");

        javax.swing.GroupLayout tabelaPanelLayout = new javax.swing.GroupLayout(tabelaPanel);
        tabelaPanel.setLayout(tabelaPanelLayout);
        tabelaPanelLayout.setHorizontalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
            .addGroup(tabelaPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mediaField, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exportar))
        );
        tabelaPanelLayout.setVerticalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelaPanelLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mediaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exportar)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        jSplitPane2.setRightComponent(tabelaPanel);

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 943, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
        );

        splitPane.setLeftComponent(contentPanel);

        arquivoMenu.setText("Arquivo");

        SalvarConfig.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        SalvarConfig.setText("Salvar Configuração");
        arquivoMenu.add(SalvarConfig);

        CarregarConfig.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        CarregarConfig.setText("Carregar Configurção");
        arquivoMenu.add(CarregarConfig);
        arquivoMenu.add(separadorMenu);

        SairMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        SairMenu.setText("Sair");
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
            .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
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

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
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
    private javax.swing.JPanel gráficoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JTextField mediaField;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel menuPanel;
    private javax.swing.ButtonGroup radioGroup;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JSeparator separador;
    private javax.swing.JSeparator separadorMenu;
    private javax.swing.JMenuItem sobre;
    private javax.swing.JSpinner spinnerNA;
    private javax.swing.JSpinner spinnerTI;
    private javax.swing.JSpinner spinnerTMax;
    private javax.swing.JSpinner spinnerTMin;
    private javax.swing.JSplitPane splitPane;
    private javax.swing.JPanel tabelaPanel;
    private javax.swing.JTable table;
    private r2d2e.solution.moduloteste.view.TanquePanel tanquePanel;
    // End of variables declaration//GEN-END:variables

}

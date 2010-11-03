/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainView.java
 *
 * Created on 21/10/2010, 23:48:25
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.FuzzyController;
import br.ufrn.controle.fuzzycontroller.domain.SelectionsGraph;
import br.ufrn.controle.fuzzycontroller.view.retractable.EmptyPanel;
import br.ufrn.controle.fuzzycontroller.view.retractable.FuzzyRetractable;
import br.ufrn.controle.fuzzycontroller.view.retractable.TankOptionsPanel;
import br.ufrn.controle.fuzzycontroller.view.retractable.ToolsPanel;
import br.ufrn.siga.component.retractable.RetractablePanel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author demetrios
 */
public class MainView extends javax.swing.JFrame {

    private FuzzyRetractable retractable;
    private RetractablePanel panelEmpty;
    private float crossSizeLock = 0.69f;
    private ArrayList<FuzzyController> controllers;
    private FuzzyController controllerSelected;

    /** Creates new form MainView */
    public MainView() {
        initComponents();

        controllers = new ArrayList<FuzzyController>();

        retractable = new FuzzyRetractable(getLayeredPane());

        SelectionsGraph selectionsGraph = new SelectionsGraph();

        RetractablePanel toolRetractable = new RetractablePanel(retractable, new ToolsPanel(this), "Configuração", true);

        panelEmpty = new RetractablePanel(retractable, new EmptyPanel(), "", false);
        panelEmpty.setCrossSizeLock(Math.round(getWidth() * crossSizeLock));

        retractable.add(toolRetractable);
        retractable.add(panelEmpty);
        retractable.add(new RetractablePanel(retractable, new TankOptionsPanel(selectionsGraph, graphLevel.getGraphHandler()), "Opções De Gráficos", true));

        setPreferredSize(new Dimension(996, 550));
        setMinimumSize(new Dimension(996, 550));

    }

    @Override
    public void paint(Graphics g) {
        panelEmpty.setCrossSizeLock(Math.round(getWidth() * crossSizeLock));
        super.paint(g);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelBackGround = new javax.swing.JPanel();
        panelGraphs = new javax.swing.JPanel();
        graphLevel = new br.ufrn.controle.fuzzycontroller.view.Graph();
        graphContol = new br.ufrn.controle.fuzzycontroller.view.Graph();
        tanquePanel = new br.ufrn.controle.fuzzycontroller.view.TanquePanel();
        pnlPadding = new javax.swing.JPanel();
        panelSetPoint = new javax.swing.JPanel();
        lblSetPoint = new javax.swing.JLabel();
        txtSetPoint = new javax.swing.JFormattedTextField();
        buttonSetPoint = new javax.swing.JButton();
        DataPanel = new javax.swing.JPanel();
        lblOverShoot = new javax.swing.JLabel();
        txtOverShoot = new javax.swing.JTextField();
        lblSubida = new javax.swing.JLabel();
        txtSubida = new javax.swing.JTextField();
        lblPico = new javax.swing.JLabel();
        txtPico = new javax.swing.JTextField();
        lblAcomodation = new javax.swing.JLabel();
        txtAcomodation = new javax.swing.JTextField();
        lblFactorAcomo = new javax.swing.JLabel();
        comboFactorAcomo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBackGround.setBackground(new java.awt.Color(255, 255, 255));
        panelBackGround.setLayout(new java.awt.BorderLayout());

        panelGraphs.setBackground(new java.awt.Color(255, 255, 255));
        panelGraphs.setLayout(new javax.swing.BoxLayout(panelGraphs, javax.swing.BoxLayout.PAGE_AXIS));

        graphLevel.setEIXO_X("Tempo ( Seg.)");
        graphLevel.setEIXO_Y("Nível");
        graphLevel.setTITLE("Nível X Tempo");

        javax.swing.GroupLayout graphLevelLayout = new javax.swing.GroupLayout(graphLevel);
        graphLevel.setLayout(graphLevelLayout);
        graphLevelLayout.setHorizontalGroup(
            graphLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        graphLevelLayout.setVerticalGroup(
            graphLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        panelGraphs.add(graphLevel);

        graphContol.setEIXO_X("Tempo (Seg.)");
        graphContol.setEIXO_Y("Tensão");
        graphContol.setTITLE("Ação de Controle");

        javax.swing.GroupLayout graphContolLayout = new javax.swing.GroupLayout(graphContol);
        graphContol.setLayout(graphContolLayout);
        graphContolLayout.setHorizontalGroup(
            graphContolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        graphContolLayout.setVerticalGroup(
            graphContolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        panelGraphs.add(graphContol);

        panelBackGround.add(panelGraphs, java.awt.BorderLayout.CENTER);

        tanquePanel.setOpaque(false);

        javax.swing.GroupLayout tanquePanelLayout = new javax.swing.GroupLayout(tanquePanel);
        tanquePanel.setLayout(tanquePanelLayout);
        tanquePanelLayout.setHorizontalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        tanquePanelLayout.setVerticalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        panelBackGround.add(tanquePanel, java.awt.BorderLayout.WEST);

        pnlPadding.setBackground(new java.awt.Color(255, 255, 255));
        pnlPadding.setMinimumSize(new java.awt.Dimension(928, 50));
        pnlPadding.setOpaque(false);
        pnlPadding.setPreferredSize(new java.awt.Dimension(50, 50));

        panelSetPoint.setOpaque(false);
        panelSetPoint.setLayout(new java.awt.BorderLayout(10, 0));

        lblSetPoint.setText("SetPoint :");
        panelSetPoint.add(lblSetPoint, java.awt.BorderLayout.WEST);

        txtSetPoint.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtSetPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSetPoint.setText("15.00");
        panelSetPoint.add(txtSetPoint, java.awt.BorderLayout.CENTER);

        buttonSetPoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/reload.png"))); // NOI18N
        buttonSetPoint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonSetPoint.setContentAreaFilled(false);
        buttonSetPoint.setFocusPainted(false);
        panelSetPoint.add(buttonSetPoint, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout pnlPaddingLayout = new javax.swing.GroupLayout(pnlPadding);
        pnlPadding.setLayout(pnlPaddingLayout);
        pnlPaddingLayout.setHorizontalGroup(
            pnlPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPaddingLayout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(panelSetPoint, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(246, 246, 246))
        );
        pnlPaddingLayout.setVerticalGroup(
            pnlPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaddingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSetPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelBackGround.add(pnlPadding, java.awt.BorderLayout.SOUTH);

        DataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Controle"));
        DataPanel.setOpaque(false);

        lblOverShoot.setText("OverShoot (%) :");

        txtOverShoot.setEditable(false);
        txtOverShoot.setOpaque(false);

        lblSubida.setText("Tempo de Subida :");

        txtSubida.setEditable(false);
        txtSubida.setOpaque(false);

        lblPico.setText("Tempo de Pico :");

        txtPico.setEditable(false);
        txtPico.setOpaque(false);

        lblAcomodation.setText("Tempo de Acomodação :");

        txtAcomodation.setEditable(false);
        txtAcomodation.setOpaque(false);

        lblFactorAcomo.setText("Fator de Acomodação :");

        comboFactorAcomo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2 %", "5 %", "7 %", "10 %" }));

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOverShoot, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lblOverShoot, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtSubida, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtPico, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtAcomodation, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(comboFactorAcomo, 0, 118, Short.MAX_VALUE)
                    .addComponent(lblFactorAcomo, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lblAcomodation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPico, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lblSubida, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        DataPanelLayout.setVerticalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOverShoot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOverShoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSubida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAcomodation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAcomodation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFactorAcomo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboFactorAcomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        panelBackGround.add(DataPanel, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<FuzzyController> getControllers() {
        return controllers;
    }

    public void setControllers(ArrayList<FuzzyController> controllers) {
        this.controllers = controllers;
    }

    public FuzzyController getControllerSelected() {
        return controllerSelected;
    }

    public void setControllerSelected(FuzzyController controllerSelected) {
        this.controllerSelected = controllerSelected;
    }

    public void startController() {
        if (controllerSelected == null) {
            return;
        }

        controllerSelected.start();
    }

    public void stopController() {
        controllerSelected.setAtive(false);
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                SkinInitialize();
                new MainView().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton buttonSetPoint;
    private javax.swing.JComboBox comboFactorAcomo;
    private br.ufrn.controle.fuzzycontroller.view.Graph graphContol;
    private br.ufrn.controle.fuzzycontroller.view.Graph graphLevel;
    private javax.swing.JLabel lblAcomodation;
    private javax.swing.JLabel lblFactorAcomo;
    private javax.swing.JLabel lblOverShoot;
    private javax.swing.JLabel lblPico;
    private javax.swing.JLabel lblSetPoint;
    private javax.swing.JLabel lblSubida;
    private javax.swing.JPanel panelBackGround;
    private javax.swing.JPanel panelGraphs;
    private javax.swing.JPanel panelSetPoint;
    private javax.swing.JPanel pnlPadding;
    private br.ufrn.controle.fuzzycontroller.view.TanquePanel tanquePanel;
    private javax.swing.JTextField txtAcomodation;
    private javax.swing.JTextField txtOverShoot;
    private javax.swing.JTextField txtPico;
    private javax.swing.JFormattedTextField txtSetPoint;
    private javax.swing.JTextField txtSubida;
    // End of variables declaration//GEN-END:variables

    private static void SkinInitialize() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        try { /*SubstanceBusinessLookAndFeel()*/
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (Exception e) {
            System.out.println("Substance Raven Graphite failed to initialize");
        }
    }
}

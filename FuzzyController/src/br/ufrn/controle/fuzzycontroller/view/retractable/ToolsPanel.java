/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ToolsPanel.java
 *
 * Created on 24/10/2010, 22:22:58
 */
package br.ufrn.controle.fuzzycontroller.view.retractable;

import br.ufrn.controle.fuzzycontroller.view.InitialDialog;
import br.ufrn.controle.fuzzycontroller.view.MainView;
import br.ufrn.controle.fuzzycontroller.view.OpcoesGerais;
import br.ufrn.siga.component.retractable.RetractablePanelContent;
import java.awt.CardLayout;

/**
 *
 * @author demetrios
 */
public class ToolsPanel extends javax.swing.JPanel implements RetractablePanelContent {

    private static final String CARD_COMPACT = "cardCompact";
    private static final String CARD_OPTIONS = "cardOptions";
    private boolean compact;
    private MainView parent;

    /** Creates new form ToolsPanel */
    public ToolsPanel(MainView parent) {
        initComponents();
        this.parent = parent;
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

        panelOptions = new br.ufrn.siga.component.gradient.GradientPanel();
        transluStart = new br.ufrn.siga.component.translucent.TranslucentPanel();
        buttonStart = new br.ufrn.siga.component.translucent.TranslucentButton();
        transluStop = new br.ufrn.siga.component.translucent.TranslucentPanel();
        buttonStop = new br.ufrn.siga.component.translucent.TranslucentButton();
        transluOptFuzzy = new br.ufrn.siga.component.translucent.TranslucentPanel();
        buttonOptFuzzy = new br.ufrn.siga.component.translucent.TranslucentButton();
        transluOptGeral = new br.ufrn.siga.component.translucent.TranslucentPanel();
        buttonGeral = new br.ufrn.siga.component.translucent.TranslucentButton();
        panelCompact = new br.ufrn.siga.component.gradient.GradientPanel();
        lblCompact = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(0, 0));
        setLayout(new java.awt.CardLayout());

        panelOptions.setColor1(new java.awt.Color(255, 255, 255));
        panelOptions.setColor2(new java.awt.Color(119, 166, 110));
        panelOptions.setOpaque(false);
        panelOptions.setLayout(new java.awt.GridBagLayout());

        buttonStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/play.png"))); // NOI18N
        buttonStart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonStartMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout buttonStartLayout = new javax.swing.GroupLayout(buttonStart);
        buttonStart.setLayout(buttonStartLayout);
        buttonStartLayout.setHorizontalGroup(
            buttonStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );
        buttonStartLayout.setVerticalGroup(
            buttonStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout transluStartLayout = new javax.swing.GroupLayout(transluStart);
        transluStart.setLayout(transluStartLayout);
        transluStartLayout.setHorizontalGroup(
            transluStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonStart, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        transluStartLayout.setVerticalGroup(
            transluStartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonStart, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 36;
        panelOptions.add(transluStart, gridBagConstraints);

        buttonStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/play_stop.png"))); // NOI18N
        buttonStop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonStopMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout buttonStopLayout = new javax.swing.GroupLayout(buttonStop);
        buttonStop.setLayout(buttonStopLayout);
        buttonStopLayout.setHorizontalGroup(
            buttonStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );
        buttonStopLayout.setVerticalGroup(
            buttonStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout transluStopLayout = new javax.swing.GroupLayout(transluStop);
        transluStop.setLayout(transluStopLayout);
        transluStopLayout.setHorizontalGroup(
            transluStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonStop, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        transluStopLayout.setVerticalGroup(
            transluStopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonStop, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 36;
        panelOptions.add(transluStop, gridBagConstraints);

        buttonOptFuzzy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/tools.png"))); // NOI18N

        javax.swing.GroupLayout buttonOptFuzzyLayout = new javax.swing.GroupLayout(buttonOptFuzzy);
        buttonOptFuzzy.setLayout(buttonOptFuzzyLayout);
        buttonOptFuzzyLayout.setHorizontalGroup(
            buttonOptFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );
        buttonOptFuzzyLayout.setVerticalGroup(
            buttonOptFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout transluOptFuzzyLayout = new javax.swing.GroupLayout(transluOptFuzzy);
        transluOptFuzzy.setLayout(transluOptFuzzyLayout);
        transluOptFuzzyLayout.setHorizontalGroup(
            transluOptFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonOptFuzzy, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        transluOptFuzzyLayout.setVerticalGroup(
            transluOptFuzzyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonOptFuzzy, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 36;
        panelOptions.add(transluOptFuzzy, gridBagConstraints);

        buttonGeral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/tools.png"))); // NOI18N
        buttonGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                buttonGeralMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout buttonGeralLayout = new javax.swing.GroupLayout(buttonGeral);
        buttonGeral.setLayout(buttonGeralLayout);
        buttonGeralLayout.setHorizontalGroup(
            buttonGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );
        buttonGeralLayout.setVerticalGroup(
            buttonGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout transluOptGeralLayout = new javax.swing.GroupLayout(transluOptGeral);
        transluOptGeral.setLayout(transluOptGeralLayout);
        transluOptGeralLayout.setHorizontalGroup(
            transluOptGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        transluOptGeralLayout.setVerticalGroup(
            transluOptGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.ipady = 36;
        panelOptions.add(transluOptGeral, gridBagConstraints);

        add(panelOptions, "cardOptions");

        panelCompact.setColor1(new java.awt.Color(255, 255, 255));
        panelCompact.setColor2(new java.awt.Color(119, 166, 110));
        panelCompact.setOpaque(false);

        lblCompact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCompact.setText("Mandami / Sugeno / Func");

        javax.swing.GroupLayout panelCompactLayout = new javax.swing.GroupLayout(panelCompact);
        panelCompact.setLayout(panelCompactLayout);
        panelCompactLayout.setHorizontalGroup(
            panelCompactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCompact, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelCompactLayout.setVerticalGroup(
            panelCompactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCompactLayout.createSequentialGroup()
                .addComponent(lblCompact)
                .addContainerGap(236, Short.MAX_VALUE))
        );

        add(panelCompact, "cardCompact");
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStartMouseReleased
        // TODO add your handling code here:
        InitialDialog dialog = new InitialDialog(parent, true);
        dialog.setLocationRelativeTo(parent);
        dialog.setVisible(true);
    }//GEN-LAST:event_buttonStartMouseReleased

    private void buttonGeralMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonGeralMouseReleased
        // TODO add your handling code here:
        OpcoesGerais gerais = new OpcoesGerais(parent, true);
        gerais.setLocationRelativeTo(parent);
        gerais.setVisible(true);
    }//GEN-LAST:event_buttonGeralMouseReleased

    private void buttonStopMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonStopMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonStopMouseReleased
    private void changeCard(String card) {
        CardLayout layout = (CardLayout) getLayout();
        layout.show(this, card);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ufrn.siga.component.translucent.TranslucentButton buttonGeral;
    private br.ufrn.siga.component.translucent.TranslucentButton buttonOptFuzzy;
    private br.ufrn.siga.component.translucent.TranslucentButton buttonStart;
    private br.ufrn.siga.component.translucent.TranslucentButton buttonStop;
    private javax.swing.JLabel lblCompact;
    private br.ufrn.siga.component.gradient.GradientPanel panelCompact;
    private br.ufrn.siga.component.gradient.GradientPanel panelOptions;
    private br.ufrn.siga.component.translucent.TranslucentPanel transluOptFuzzy;
    private br.ufrn.siga.component.translucent.TranslucentPanel transluOptGeral;
    private br.ufrn.siga.component.translucent.TranslucentPanel transluStart;
    private br.ufrn.siga.component.translucent.TranslucentPanel transluStop;
    // End of variables declaration//GEN-END:variables

    public void showCompact() {
        compact = true;
        changeCard(CARD_COMPACT);
    }

    public void showFull() {
        compact = false;
        changeCard(CARD_OPTIONS);
    }

    public boolean isCompactView() {
        return compact;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ConfControle.java
 *
 * Created on 07/04/2010, 15:17:01
 */
package r2d2e.solution.moduloteste.view;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.controlers.PController;
import r2d2e.solution.moduloteste.controlers.PDController;
import r2d2e.solution.moduloteste.controlers.PIController;
import r2d2e.solution.moduloteste.controlers.PID2Controller;
import r2d2e.solution.moduloteste.controlers.PIDController;
import r2d2e.solution.moduloteste.handler.ControlModeHandler;
import r2d2e.solution.moduloteste.handler.SUtil;

/**
 *
 * @author Rivaldo Jr
 */
public class ConfParametros extends javax.swing.JPanel {

    public static double SAMPLE_RATE = 0.1;

    /** Creates new form ConfControle */
    public ConfParametros() {
        initComponents();
        popularComboBox();
        setP();

//        ControlModeHandler.setControllerSelected((Controller) comboControladores.getItemAt(0));
    }

    public ConfParametros(String title){
        this();
        TitledBorder border = (TitledBorder) getBorder();
        border.setTitle(title);
    }

    public void popularComboBox() {
        Vector<Controller> controllers = new Vector<Controller>();

        String text = textSetPoint.getText();
        text = SUtil.fixNumber(text);
        double sp = Double.parseDouble(text);

        controllers.add(new PController(SAMPLE_RATE, sp));
        controllers.add(new PDController(SAMPLE_RATE, sp));
        controllers.add(new PIController(SAMPLE_RATE, sp));
        controllers.add(new PIDController(SAMPLE_RATE, sp));
        controllers.add(new PID2Controller(SAMPLE_RATE, sp));

        DefaultComboBoxModel boxModel = new DefaultComboBoxModel(controllers);

        comboControladores.setModel(boxModel);
        comboControladores.setSelectedIndex(0);

    }

    public void setP() {

        chkKD.setVisible(false);
        chkKI.setVisible(false);
        textKD.setVisible(false);
        textKI.setVisible(false);
        chkTD.setVisible(false);
        chkTI.setVisible(false);
        textTD.setVisible(false);
        textTI.setVisible(false);

    }

    public void setPD() {

        chkKD.setVisible(true);
        chkKI.setVisible(false);
        textKD.setVisible(true);
        textKI.setVisible(false);
        chkTD.setVisible(true);
        chkTI.setVisible(false);
        textTD.setVisible(true);
        textTI.setVisible(false);
    }

    public void setPI() {

        chkKI.setVisible(true);
        chkKD.setVisible(false);
        textKI.setVisible(true);
        textKD.setVisible(false);
        chkTD.setVisible(false);
        chkTI.setVisible(true);
        textTD.setVisible(false);
        textTI.setVisible(true);
    }

    public void setPID() {

        chkKD.setVisible(true);
        chkKI.setVisible(true);
        textKD.setVisible(true);
        textKI.setVisible(true);
        chkTD.setVisible(true);
        chkTI.setVisible(true);
        textTD.setVisible(true);
        textTI.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        comboControladores = new javax.swing.JComboBox();
        labelTipoCtrl = new javax.swing.JLabel();
        labelSetPoint = new javax.swing.JLabel();
        panelGanhos = new javax.swing.JPanel();
        labelKp = new javax.swing.JLabel();
        textKP = new javax.swing.JFormattedTextField();
        textKD = new javax.swing.JFormattedTextField();
        textTI = new javax.swing.JFormattedTextField();
        textTD = new javax.swing.JFormattedTextField();
        textKI = new javax.swing.JFormattedTextField();
        chkKD = new javax.swing.JCheckBox();
        chkKI = new javax.swing.JCheckBox();
        chkTD = new javax.swing.JCheckBox();
        chkTI = new javax.swing.JCheckBox();
        SeparatorCtrl = new javax.swing.JSeparator();
        buttonReload = new javax.swing.JButton();
        chkIntCond = new javax.swing.JCheckBox();
        textSetPoint = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        setMaximumSize(null);

        comboControladores.setNextFocusableComponent(textSetPoint);
        comboControladores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboControladoresItemStateChanged(evt);
            }
        });

        labelTipoCtrl.setForeground(new java.awt.Color(255, 255, 255));
        labelTipoCtrl.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.labelTipoCtrl.text")); // NOI18N

        labelSetPoint.setForeground(new java.awt.Color(255, 255, 255));
        labelSetPoint.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.labelSetPoint.text")); // NOI18N

        panelGanhos.setBackground(new java.awt.Color(0, 0, 0));
        panelGanhos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.panelGanhos.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelGanhos.setOpaque(false);
        panelGanhos.setPreferredSize(new java.awt.Dimension(597, 132));

        labelKp.setForeground(new java.awt.Color(255, 255, 255));
        labelKp.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.labelKp.text")); // NOI18N

        textKP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0000"))));
        textKP.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textKP.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textKP.text")); // NOI18N
        textKP.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textKP.toolTipText")); // NOI18N
        textKP.setNextFocusableComponent(textKD);

        textKD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0000"))));
        textKD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textKD.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textKD.text")); // NOI18N
        textKD.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textKD.toolTipText")); // NOI18N
        textKD.setNextFocusableComponent(textKI);

        textTI.setEditable(false);
        textTI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0000"))));
        textTI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTI.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textTI.text")); // NOI18N
        textTI.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textTI.toolTipText")); // NOI18N

        textTD.setEditable(false);
        textTD.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0000"))));
        textTD.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textTD.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textTD.text")); // NOI18N
        textTD.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textTD.toolTipText")); // NOI18N
        textTD.setNextFocusableComponent(textTI);

        textKI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.0000"))));
        textKI.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textKI.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textKI.text")); // NOI18N
        textKI.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textKI.toolTipText")); // NOI18N
        textKI.setNextFocusableComponent(textTD);

        buttonGroup1.add(chkKD);
        chkKD.setForeground(new java.awt.Color(255, 255, 255));
        chkKD.setSelected(true);
        chkKD.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.chkKD.text")); // NOI18N
        chkKD.setOpaque(false);
        chkKD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkKDActionPerformed(evt);
            }
        });

        buttonGroup2.add(chkKI);
        chkKI.setForeground(new java.awt.Color(255, 255, 255));
        chkKI.setSelected(true);
        chkKI.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.chkKI.text")); // NOI18N
        chkKI.setOpaque(false);
        chkKI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkKIActionPerformed(evt);
            }
        });

        buttonGroup1.add(chkTD);
        chkTD.setForeground(new java.awt.Color(255, 255, 255));
        chkTD.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.chkTD.text")); // NOI18N
        chkTD.setOpaque(false);
        chkTD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTDActionPerformed(evt);
            }
        });

        buttonGroup2.add(chkTI);
        chkTI.setForeground(new java.awt.Color(255, 255, 255));
        chkTI.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.chkTI.text")); // NOI18N
        chkTI.setOpaque(false);
        chkTI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGanhosLayout = new javax.swing.GroupLayout(panelGanhos);
        panelGanhos.setLayout(panelGanhosLayout);
        panelGanhosLayout.setHorizontalGroup(
            panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGanhosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelGanhosLayout.createSequentialGroup()
                        .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkKD)
                            .addComponent(chkKI))
                        .addGap(6, 6, 6))
                    .addGroup(panelGanhosLayout.createSequentialGroup()
                        .addComponent(labelKp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGanhosLayout.createSequentialGroup()
                        .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textKD, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addGroup(panelGanhosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textKI, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkTD)
                            .addComponent(chkTI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(textTI, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                            .addComponent(textTD, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))
                    .addComponent(textKP, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGanhosLayout.setVerticalGroup(
            panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGanhosLayout.createSequentialGroup()
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textKP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKp))
                .addGap(5, 5, 5)
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(chkTD)
                    .addComponent(chkKD)
                    .addComponent(textKD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelGanhosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(textTI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkKI)
                        .addComponent(chkTI)
                        .addComponent(textKI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        SeparatorCtrl.setOrientation(javax.swing.SwingConstants.VERTICAL);

        buttonReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/reload.png"))); // NOI18N
        buttonReload.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.buttonReload.text")); // NOI18N
        buttonReload.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.buttonReload.toolTipText")); // NOI18N
        buttonReload.setBorder(null);
        buttonReload.setBorderPainted(false);
        buttonReload.setContentAreaFilled(false);
        buttonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReloadActionPerformed(evt);
            }
        });

        chkIntCond.setForeground(new java.awt.Color(255, 255, 255));
        chkIntCond.setSelected(true);
        chkIntCond.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.chkIntCond.text")); // NOI18N
        chkIntCond.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.chkIntCond.toolTipText")); // NOI18N
        chkIntCond.setOpaque(false);

        textSetPoint.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        textSetPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textSetPoint.setText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textSetPoint.text")); // NOI18N
        textSetPoint.setToolTipText(org.openide.util.NbBundle.getMessage(ConfParametros.class, "ConfParametros.textSetPoint.toolTipText")); // NOI18N
        textSetPoint.setNextFocusableComponent(textKP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTipoCtrl, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboControladores, 0, 135, Short.MAX_VALUE)
                    .addComponent(labelSetPoint, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(textSetPoint, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(chkIntCond, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SeparatorCtrl, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelGanhos, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonReload, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(SeparatorCtrl)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(labelTipoCtrl)
                            .addGap(4, 4, 4)
                            .addComponent(comboControladores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(labelSetPoint)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textSetPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(chkIntCond)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonReload)
                        .addComponent(panelGanhos, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboControladoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboControladoresItemStateChanged
        // TODO add your handling code here:
        Controller c = (Controller) comboControladores.getSelectedItem();
        if (c instanceof PController) {
            setP();
        }
        if (c instanceof PDController) {
            setPD();
        }
        if (c instanceof PIController) {
            setPI();
        }
        if (c instanceof PIDController || c instanceof PID2Controller) {
            setPID();
        }
//        ControlModeHandler.setControllerSelected(c);
    }//GEN-LAST:event_comboControladoresItemStateChanged

    private void buttonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReloadActionPerformed
        // TODO add your handling code here:

        ControlModeHandler.updateVariables();
        boolean chk = chkIntCond.isSelected();
        ControlModeHandler.setIntegracaoCondi(chk);
    }

    public JComboBox getComboControladores() {
        return comboControladores;
    }

    public void setComboControladores(JComboBox comboControladores) {
        this.comboControladores = comboControladores;
    }

    public JFormattedTextField getTextKD() {
        return textKD;
    }

    public void setTextKD(JFormattedTextField textKD) {
        this.textKD = textKD;
    }

    public JFormattedTextField getTextKP() {
        return textKP;
    }

    public void setTextKP(JFormattedTextField textKP) {
        this.textKP = textKP;
    }

    public JFormattedTextField getTextSetPoint() {
        return textSetPoint;
    }

    public JFormattedTextField getTextTD() {
        return textTD;
    }

    public JFormattedTextField getTextTI() {
        return textTI;
    }

    public JCheckBox getChkKD() {
        return chkKD;
    }

    public void setChkKD(JCheckBox chkKD) {
        this.chkKD = chkKD;
    }

    public JCheckBox getChkKI() {
        return chkKI;
    }

    public void setChkKI(JCheckBox chkKI) {
        this.chkKI = chkKI;
    }

    public JCheckBox getChkTD() {
        return chkTD;
    }

    public void setChkTD(JCheckBox chkTD) {
        this.chkTD = chkTD;
    }

    public JCheckBox getChkTI() {
        return chkTI;
    }

    public void setChkTI(JCheckBox chkTI) {
        this.chkTI = chkTI;
    }

    public JFormattedTextField getTextKI() {
        return textKI;
    }

    public void setTextKI(JFormattedTextField textKI) {
        this.textKI = textKI;
    }

    public JCheckBox getChkIntCond() {
        return chkIntCond;
    }

    public JLabel getLabelSetPoint() {
        return labelSetPoint;
    }

    public void setLabelSetPoint(JLabel labelSetPoint) {
        this.labelSetPoint = labelSetPoint;
    }

    public Controller getSelectedController(){
        return (Controller) comboControladores.getSelectedItem();
    }

    public void setTextSetPoint(JFormattedTextField textSetPoint) {
        this.textSetPoint = textSetPoint;
    }//GEN-LAST:event_buttonReloadActionPerformed

    private void chkKDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkKDActionPerformed
        // TODO add your handling code here:
        boolean chkd = chkKD.isSelected();
        textKD.setEditable(chkd);
        textTD.setEditable(!chkd);
    }//GEN-LAST:event_chkKDActionPerformed

    private void chkKIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkKIActionPerformed
        // TODO add your handling code here:
        boolean chki = chkKI.isSelected();
        textKI.setEditable(chki);
        textTI.setEditable(!chki);
    }//GEN-LAST:event_chkKIActionPerformed

    private void chkTDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTDActionPerformed
        // TODO add your handling code here:
        boolean chkd = chkTD.isSelected();
        textKD.setEditable(!chkd);
        textTD.setEditable(chkd);
    }//GEN-LAST:event_chkTDActionPerformed

    private void chkTIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTIActionPerformed
        // TODO add your handling code here:
        boolean chkd = chkTI.isSelected();
        textKI.setEditable(!chkd);
        textTI.setEditable(chkd);
    }//GEN-LAST:event_chkTIActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator SeparatorCtrl;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonReload;
    private javax.swing.JCheckBox chkIntCond;
    private javax.swing.JCheckBox chkKD;
    private javax.swing.JCheckBox chkKI;
    private javax.swing.JCheckBox chkTD;
    private javax.swing.JCheckBox chkTI;
    private javax.swing.JComboBox comboControladores;
    private javax.swing.JLabel labelKp;
    private javax.swing.JLabel labelSetPoint;
    private javax.swing.JLabel labelTipoCtrl;
    private javax.swing.JPanel panelGanhos;
    private javax.swing.JFormattedTextField textKD;
    private javax.swing.JFormattedTextField textKI;
    private javax.swing.JFormattedTextField textKP;
    private javax.swing.JFormattedTextField textSetPoint;
    private javax.swing.JFormattedTextField textTD;
    private javax.swing.JFormattedTextField textTI;
    // End of variables declaration//GEN-END:variables
}

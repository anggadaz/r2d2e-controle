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

import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import org.jscience.mathematics.number.Complex;
import r2d2e.solution.moduloteste.domain.MatrixOperation;
import r2d2e.solution.moduloteste.handler.ControlModeHandler;
import r2d2e.solution.moduloteste.handler.SUtil;

/**
 *
 * @author Rivaldo Jr
 */
public class ConfSeguidor extends javax.swing.JPanel {

    private MatrixOperation matrixOperation;
    private double[] ganhos;

    /** Creates new form ConfControle */
    public ConfSeguidor() {
        initComponents();
        matrixOperation = new MatrixOperation();
        ganhos = new double[3];
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
        labelSetPoint = new javax.swing.JLabel();
        buttonReload = new javax.swing.JButton();
        textSetPoint = new javax.swing.JFormattedTextField();
        jSeparator1 = new javax.swing.JSeparator();
        panelPolo = new javax.swing.JPanel();
        txtReal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        txtImaginario = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtReal1 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtImaginario1 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtImaginario2 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtReal2 = new javax.swing.JFormattedTextField();
        panelGanhos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtGanho1k2 = new javax.swing.JFormattedTextField();
        txtGanho2k2 = new javax.swing.JFormattedTextField();
        txtGanhoK1 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        setMaximumSize(null);
        setMinimumSize(new java.awt.Dimension(963, 150));
        setPreferredSize(new java.awt.Dimension(963, 150));

        labelSetPoint.setForeground(new java.awt.Color(255, 255, 255));
        labelSetPoint.setText("Set Point: Nível");

        buttonReload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/reload.png"))); // NOI18N
        buttonReload.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.buttonReload.text")); // NOI18N
        buttonReload.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.buttonReload.toolTipText")); // NOI18N
        buttonReload.setBorder(null);
        buttonReload.setBorderPainted(false);
        buttonReload.setContentAreaFilled(false);
        buttonReload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonReloadActionPerformed(evt);
            }
        });

        textSetPoint.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        textSetPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textSetPoint.setText("15.00");
        textSetPoint.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.textSetPoint.toolTipText")); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        panelPolo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.panelPolo.border.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255)))); // NOI18N
        panelPolo.setOpaque(false);

        txtReal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtReal.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtReal.text")); // NOI18N
        txtReal.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtReal.toolTipText")); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("+");

        txtImaginario.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtImaginario.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtImaginario.text")); // NOI18N
        txtImaginario.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtImaginario.toolTipText")); // NOI18N
        txtImaginario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImaginarioActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("*");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("i");

        txtReal1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtReal1.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtReal1.text")); // NOI18N
        txtReal1.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtReal1.toolTipText")); // NOI18N

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("+");

        txtImaginario1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtImaginario1.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtImaginario1.text")); // NOI18N
        txtImaginario1.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtImaginario1.toolTipText")); // NOI18N
        txtImaginario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImaginario1ActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("*");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("i");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("i");

        txtImaginario2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtImaginario2.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtImaginario2.text")); // NOI18N
        txtImaginario2.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtImaginario2.toolTipText")); // NOI18N
        txtImaginario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImaginario2ActionPerformed(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.jLabel10.text")); // NOI18N

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("+");

        txtReal2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtReal2.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtReal2.text")); // NOI18N
        txtReal2.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtReal2.toolTipText")); // NOI18N

        javax.swing.GroupLayout panelPoloLayout = new javax.swing.GroupLayout(panelPolo);
        panelPolo.setLayout(panelPoloLayout);
        panelPoloLayout.setHorizontalGroup(
            panelPoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPoloLayout.createSequentialGroup()
                .addGroup(panelPoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPoloLayout.createSequentialGroup()
                        .addComponent(txtReal, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImaginario, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addGroup(panelPoloLayout.createSequentialGroup()
                        .addComponent(txtReal1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImaginario1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8))
                    .addGroup(panelPoloLayout.createSequentialGroup()
                        .addComponent(txtReal2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtImaginario2, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)))
                .addGap(40, 40, 40))
        );
        panelPoloLayout.setVerticalGroup(
            panelPoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPoloLayout.createSequentialGroup()
                .addGroup(panelPoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtImaginario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReal1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtImaginario1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPoloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtReal2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtImaginario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGanhos.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.panelGanhos.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        panelGanhos.setOpaque(false);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("K2 =");

        txtGanho1k2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGanho1k2.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtGanho1k2.text")); // NOI18N
        txtGanho1k2.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtGanho1k2.toolTipText")); // NOI18N

        txtGanho2k2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGanho2k2.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtGanho2k2.text")); // NOI18N
        txtGanho2k2.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtGanho2k2.toolTipText")); // NOI18N

        txtGanhoK1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtGanhoK1.setText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtGanhoK1.text")); // NOI18N
        txtGanhoK1.setToolTipText(org.openide.util.NbBundle.getMessage(ConfSeguidor.class, "ConfSeguidor.txtGanhoK1.toolTipText")); // NOI18N

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("K1 =");

        javax.swing.GroupLayout panelGanhosLayout = new javax.swing.GroupLayout(panelGanhos);
        panelGanhos.setLayout(panelGanhosLayout);
        panelGanhosLayout.setHorizontalGroup(
            panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGanhosLayout.createSequentialGroup()
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGanhosLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGanhoK1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelGanhosLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGanho1k2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtGanho2k2, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
        );
        panelGanhosLayout.setVerticalGroup(
            panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGanhosLayout.createSequentialGroup()
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGanho1k2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGanho2k2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGanhosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGanhoK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textSetPoint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(labelSetPoint, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelPolo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(panelGanhos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonReload, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelPolo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelSetPoint)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textSetPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addComponent(buttonReload))
                    .addComponent(panelGanhos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buttonReloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonReloadActionPerformed
        // TODO add your handling code here:

        double[] gainsTemp = new double[3];
        gainsTemp[0] = Double.parseDouble(txtGanho1k2.getText());
        gainsTemp[1] = Double.parseDouble(txtGanho2k2.getText());
        gainsTemp[2] = Double.parseDouble(txtGanhoK1.getText());

        if (verificarMudancaGanhos(gainsTemp)) {
            ganhos = gainsTemp;
            ArrayList<Complex> polos = matrixOperation.polos(ganhos);

            System.out.println("POLOS ");
            for(int i = 0; i < polos.size();i++){
                System.out.println(polos.get(i));
            }

            txtReal.setText(Double.toString(polos.get(0).getReal()));
            txtReal1.setText(Double.toString(polos.get(1).getReal()));
            txtReal2.setText(Double.toString(polos.get(2).getReal()));

            txtImaginario.setText(Double.toString(polos.get(0).getImaginary()));
            txtImaginario1.setText(Double.toString(polos.get(1).getImaginary()));
            txtImaginario2.setText(Double.toString(polos.get(2).getImaginary()));

        } else {
            ArrayList<Complex> polos = new ArrayList<Complex>();

            polos.add(Complex.valueOf(Double.parseDouble(txtReal.getText()), Double.parseDouble(txtImaginario.getText())));
            polos.add(Complex.valueOf(Double.parseDouble(txtReal1.getText()), Double.parseDouble(txtImaginario1.getText())));
            polos.add(Complex.valueOf(Double.parseDouble(txtReal2.getText()), Double.parseDouble(txtImaginario2.getText())));

            ganhos = matrixOperation.gains(polos);
            txtGanho1k2.setText(Double.toString(ganhos[0]));
            txtGanho2k2.setText(Double.toString(ganhos[1]));
            txtGanhoK1.setText(Double.toString(ganhos[2]));
        }



//        ganhos[0] = Double.parseDouble(txtGanho1k1.getText());
//        ganhos[1] = Double.parseDouble(txtGanho2k1.getText());
//        ganhos[2] = Double.parseDouble(txtGanhoK2.getText());
        ControlModeHandler.updateVariables();
    }

    public void setTextSetPoint(JFormattedTextField textSetPoint) {
        this.textSetPoint = textSetPoint;
    }//GEN-LAST:event_buttonReloadActionPerformed

    private void txtImaginarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImaginarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImaginarioActionPerformed

    private void txtImaginario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImaginario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImaginario1ActionPerformed

    private void txtImaginario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImaginario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImaginario2ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton buttonReload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelSetPoint;
    private javax.swing.JPanel panelGanhos;
    private javax.swing.JPanel panelPolo;
    private javax.swing.JFormattedTextField textSetPoint;
    private javax.swing.JFormattedTextField txtGanho1k2;
    private javax.swing.JFormattedTextField txtGanho2k2;
    private javax.swing.JFormattedTextField txtGanhoK1;
    private javax.swing.JFormattedTextField txtImaginario;
    private javax.swing.JFormattedTextField txtImaginario1;
    private javax.swing.JFormattedTextField txtImaginario2;
    private javax.swing.JFormattedTextField txtReal;
    private javax.swing.JFormattedTextField txtReal1;
    private javax.swing.JFormattedTextField txtReal2;
    // End of variables declaration//GEN-END:variables

    public double getSetPoint() {
        return Double.parseDouble(SUtil.fixNumber(textSetPoint.getText()));
    }

    public double[] getGains() {
        return ganhos;
    }

    private boolean verificarMudancaGanhos(double[] gainsTemp) {
        for (int i = 0; i < ganhos.length; i++) {
            if (ganhos[i] != gainsTemp[i]) {
                return true;
            }
        }
        return false;
    }
}

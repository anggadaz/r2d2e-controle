/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * InitialDialog.java
 *
 * Created on 31/10/2010, 23:15:45
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.FuzzyController;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author demetrios
 */
public class InitialDialog extends javax.swing.JDialog {

    private boolean ok = false;

    /** Creates new form InitialDialog
     * @param parent
     * @param modal
     */
    public InitialDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        MainView mainView = (MainView) parent;
        ArrayList<FuzzyController> controllers = mainView.getControllers();

        fillCombo(controllers);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBackGround = new javax.swing.JPanel();
        lblFuzzy = new javax.swing.JLabel();
        comboControllers = new javax.swing.JComboBox();
        buttonStart = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelBackGround.setBackground(new java.awt.Color(255, 255, 255));

        lblFuzzy.setText(org.openide.util.NbBundle.getMessage(InitialDialog.class, "InitialDialog.lblFuzzy.text")); // NOI18N

        comboControllers.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboControllers.setOpaque(false);

        buttonStart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/play_1.png"))); // NOI18N
        buttonStart.setText(org.openide.util.NbBundle.getMessage(InitialDialog.class, "InitialDialog.buttonStart.text")); // NOI18N
        buttonStart.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonStart.setBorderPainted(false);
        buttonStart.setContentAreaFilled(false);
        buttonStart.setFocusPainted(false);
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBackGroundLayout = new javax.swing.GroupLayout(panelBackGround);
        panelBackGround.setLayout(panelBackGroundLayout);
        panelBackGroundLayout.setHorizontalGroup(
            panelBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBackGroundLayout.createSequentialGroup()
                        .addComponent(lblFuzzy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboControllers, 0, 184, Short.MAX_VALUE))
                    .addComponent(buttonStart, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelBackGroundLayout.setVerticalGroup(
            panelBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBackGroundLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelBackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuzzy)
                    .addComponent(comboControllers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonStart))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed
        // TODO add your handling code here:
        dispose();
        ok = true;
    }//GEN-LAST:event_buttonStartActionPerformed

    public boolean isOk(){
        return ok;
    }

    public FuzzyController getFuzzyControllerSelected() {
        return (FuzzyController) comboControllers.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JComboBox comboControllers;
    private javax.swing.JLabel lblFuzzy;
    private javax.swing.JPanel panelBackGround;
    // End of variables declaration//GEN-END:variables

    private void fillCombo(ArrayList<FuzzyController> controllers) {
        DefaultComboBoxModel model = new DefaultComboBoxModel(controllers.toArray());
        comboControllers.setModel(model);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FuzzyEditor.java
 *
 * Created on 02/11/2010, 17:03:46
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.domain.FuzzyController;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.util.ArrayList;

/**
 *
 * @author allan
 */
public class FuzzyEditor extends javax.swing.JDialog {

//    private FuzzyController controller;
    private MainView frame;

    /** Creates new form FuzzyEditor */
    public FuzzyEditor(MainView parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.frame = parent;

//        controller = parent.getControllerSelected();
//        ruleEditorPanel1.setController(controller);

        controlerPanel1.preencheLista(parent.getControllers());

    }

    public void init() {
        controlerPanel1.preencheLista(frame.getControllers());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        controlerPanel1 = new br.ufrn.controle.fuzzycontroller.view.ControlerPanel();
        jPanel3 = new javax.swing.JPanel();
        iOPanel1 = new br.ufrn.controle.fuzzycontroller.view.IOPanel();
        jPanel5 = new javax.swing.JPanel();
        ruleEditorPanel1 = new br.ufrn.controle.fuzzycontroller.view.RuleEditorPanel();
        gradientPanel1 = new br.ufrn.siga.component.gradient.GradientPanel();
        translucentButton1 = new br.ufrn.siga.component.translucent.TranslucentButton();
        translucentButton2 = new br.ufrn.siga.component.translucent.TranslucentButton();
        translucentButton3 = new br.ufrn.siga.component.translucent.TranslucentButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 737, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlerPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, "card4");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Editor Função de Pertinencia"));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(iOPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(iOPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel3, "funcPertinenciaCard");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)), "Editor de Regras"));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 747, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ruleEditorPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ruleEditorPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, Short.MAX_VALUE)
                    .addGap(15, 15, 15)))
        );

        jPanel1.add(jPanel5, "ruleEditorCard");

        gradientPanel1.setColor1(new java.awt.Color(255, 255, 255));
        gradientPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 20, 5));

        translucentButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/tools48x48.png"))); // NOI18N
        translucentButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                translucentButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                translucentButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                translucentButton1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout translucentButton1Layout = new javax.swing.GroupLayout(translucentButton1);
        translucentButton1.setLayout(translucentButton1Layout);
        translucentButton1Layout.setHorizontalGroup(
            translucentButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        translucentButton1Layout.setVerticalGroup(
            translucentButton1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        gradientPanel1.add(translucentButton1);

        translucentButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/area_empilhada_48x48.png"))); // NOI18N
        translucentButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                translucentButton2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                translucentButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                translucentButton2MouseExited(evt);
            }
        });

        javax.swing.GroupLayout translucentButton2Layout = new javax.swing.GroupLayout(translucentButton2);
        translucentButton2.setLayout(translucentButton2Layout);
        translucentButton2Layout.setHorizontalGroup(
            translucentButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        translucentButton2Layout.setVerticalGroup(
            translucentButton2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        gradientPanel1.add(translucentButton2);

        translucentButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/gear48x48.png"))); // NOI18N
        translucentButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                translucentButton3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                translucentButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                translucentButton3MouseExited(evt);
            }
        });

        javax.swing.GroupLayout translucentButton3Layout = new javax.swing.GroupLayout(translucentButton3);
        translucentButton3.setLayout(translucentButton3Layout);
        translucentButton3Layout.setHorizontalGroup(
            translucentButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        translucentButton3Layout.setVerticalGroup(
            translucentButton3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );

        gradientPanel1.add(translucentButton3);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(gradientPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(80, 80, 80)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void translucentButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton1MouseClicked
        CardLayout carta = ((CardLayout) jPanel1.getLayout());
        carta.show(jPanel1, "card4");
    }//GEN-LAST:event_translucentButton1MouseClicked

    private void translucentButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton3MouseClicked
        ruleEditorPanel1.setController(controlerPanel1.getSelectedFunc());

        CardLayout carta = ((CardLayout) jPanel1.getLayout());
        carta.show(jPanel1, "ruleEditorCard");
    }//GEN-LAST:event_translucentButton3MouseClicked

    private void translucentButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton2MouseClicked
        iOPanel1.clear();

        FuzzyController fc = controlerPanel1.getSelectedFunc();

        for (String type : fc.getDataInType()) {
            ArrayList<FuncPertinence> funcs = fc.getInference().getDataBase().getIn(type);
            iOPanel1.addIn(funcs, type);
        }

        ArrayList<FuncPertinence> funcs = fc.getInference().getDataBase().getOut(ConstantsFuzzy.VARIABLE_OUTPUT);
        iOPanel1.addOut(funcs, ConstantsFuzzy.VARIABLE_OUTPUT);

        fc.getInference().getDataBase().getRangeIn(null);

        CardLayout carta = ((CardLayout) jPanel1.getLayout());
        carta.show(jPanel1, "funcPertinenciaCard");
    }//GEN-LAST:event_translucentButton2MouseClicked

    private void translucentButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton1MouseEntered
        translucentButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_translucentButton1MouseEntered

    private void translucentButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton2MouseEntered
        translucentButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_translucentButton2MouseEntered

    private void translucentButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton3MouseEntered
        translucentButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_translucentButton3MouseEntered

    private void translucentButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton1MouseExited
        translucentButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_translucentButton1MouseExited

    private void translucentButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton2MouseExited
        translucentButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_translucentButton2MouseExited

    private void translucentButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_translucentButton3MouseExited
        translucentButton3.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_translucentButton3MouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FuzzyEditor dialog = new FuzzyEditor(new MainView(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ufrn.controle.fuzzycontroller.view.ControlerPanel controlerPanel1;
    private br.ufrn.siga.component.gradient.GradientPanel gradientPanel1;
    private br.ufrn.controle.fuzzycontroller.view.IOPanel iOPanel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private br.ufrn.controle.fuzzycontroller.view.RuleEditorPanel ruleEditorPanel1;
    private br.ufrn.siga.component.translucent.TranslucentButton translucentButton1;
    private br.ufrn.siga.component.translucent.TranslucentButton translucentButton2;
    private br.ufrn.siga.component.translucent.TranslucentButton translucentButton3;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * RuleEditorPanel.java
 *
 * Created on 17/11/2010, 18:43:09
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.DataBase;
import br.ufrn.controle.fuzzycontroller.domain.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.domain.FuzzyController;
import br.ufrn.controle.fuzzycontroller.domain.Rule;
import br.ufrn.controle.fuzzycontroller.domain.RuleBase;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author allan
 */
public class RuleEditorPanel extends javax.swing.JPanel {

    private RuleBase regras;
    private DataBase baseDados;
    private ArrayList<String> dataTypeIn;
    private ArrayList<JList> listas = new ArrayList<JList>();
    private ArrayList<JCheckBox> chkNot = new ArrayList<JCheckBox>();
    private final String NONE = "None";
    private FuzzyController controller;

    public RuleEditorPanel() {
        initComponents();
    }

    /** Creates new form RuleEditorPanel */
    public RuleEditorPanel(FuzzyController controller) {
        this.controller = controller;
        baseDados = controller.getInference().getDataBase();
        regras = controller.getInference().getRuleBase();
        dataTypeIn = controller.getDataInType();
        initComponents();
        init();
    }

    public void setController(FuzzyController controller) {
        this.controller = controller;
        baseDados = controller.getInference().getDataBase();
        regras = controller.getInference().getRuleBase();
        dataTypeIn = controller.getDataInType();
        init();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jCheckBox3.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText(org.openide.util.NbBundle.getMessage(RuleEditorPanel.class, "RuleEditorPanel.jCheckBox3.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(RuleEditorPanel.class, "RuleEditorPanel.jLabel2.text")); // NOI18N

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jList4.setModel(new DefaultListModel());
        jScrollPane4.setViewportView(jList4);

        jList1.setModel(new DefaultListModel());
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 3, 5));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/adicionar.png"))); // NOI18N
        jButton1.setText(org.openide.util.NbBundle.getMessage(RuleEditorPanel.class, "RuleEditorPanel.jButton1.text")); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/alterar.gif"))); // NOI18N
        jButton2.setText(org.openide.util.NbBundle.getMessage(RuleEditorPanel.class, "RuleEditorPanel.jButton2.text")); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/cancel.png"))); // NOI18N
        jButton3.setText(org.openide.util.NbBundle.getMessage(RuleEditorPanel.class, "RuleEditorPanel.jButton3.text")); // NOI18N
        jButton3.setBorderPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jCheckBox3)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(59, 59, 59))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCheckBox3))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Rule regra = new Rule();

        boolean inputValido = false;
        for (int i = 0; i < listas.size(); i++) {
            try {
                if (!listas.get(i).getSelectedValue().toString().equals(NONE)) {
                    regra.addPremise(dataTypeIn.get(i), chkNot.get(i).isSelected(), (FuncPertinence) listas.get(i).getSelectedValue());
                    inputValido = true;
                }
            } catch (NullPointerException ex) {
                continue;
            }
        }

        if (!inputValido) {
            return;
        }

        regra.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, jCheckBox3.isSelected(), (FuncPertinence) jList4.getSelectedValue());

        regras.addRule(regra);

        ((DefaultListModel) jList1.getModel()).addElement(regra);
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Rule regra = (Rule) jList1.getSelectedValue();

        boolean inputValido = false;
        for (int i = 0; i < listas.size(); i++) {
            if (!listas.get(i).getSelectedValue().toString().equals(NONE)) {
                regra.addPremise(dataTypeIn.get(i), chkNot.get(i).isSelected(), (FuncPertinence) listas.get(i).getSelectedValue());
                inputValido = true;
            }
        }

        if (!inputValido) {
            return;
        }

        regra.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, jCheckBox3.isSelected(), (FuncPertinence) jList4.getSelectedValue());

        jList1.repaint();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        Rule regra = (Rule) jList1.getSelectedValue();

        if (regra == null) {
            return;
        }

        for (int i = 0; i < listas.size(); i++) {
            FuncPertinence func = regra.getInputShape(dataTypeIn.get(i));
            listas.get(i).setSelectedValue(func, true);
        }

        jList4.setSelectedValue(regra.getOutPutShape(ConstantsFuzzy.VARIABLE_OUTPUT), true);
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Rule regra = (Rule) jList1.getSelectedValue();
        if (regra != null) {
            regras.getRules().remove(regra);
            ((DefaultListModel) jList1.getModel()).removeElement(regra);
            jList1.repaint();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        jButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        jButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        jButton3.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        jButton1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        jButton2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_jButton2MouseExited

    private void criarPanelInput(String nomeInput) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(new java.awt.Color(255, 255, 255));

        JLabel label = new JLabel("<html>If <font color=red>" + nomeInput + "</font> is:</html>");
        JList lista = new JList(new DefaultListModel());

        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(lista);

        JCheckBox chkBox = new JCheckBox("not");
        chkBox.setBackground(new java.awt.Color(255, 255, 255));

        panel.setPreferredSize(new Dimension(15, 15));

        if (baseDados.getIn(nomeInput) != null) {
            for (FuncPertinence func : baseDados.getIn(nomeInput)) {
                ((DefaultListModel) lista.getModel()).addElement(func);
            }
        }

        ((DefaultListModel) lista.getModel()).addElement(NONE);

        panel.add(label);
        panel.add(scroll);
        panel.add(chkBox);

        listas.add(lista);
        chkNot.add(chkBox);

        jPanel1.add(panel);
    }

    private void init() {
        jPanel1.removeAll();
        listas = new ArrayList<JList>();
        ((DefaultListModel) jList1.getModel()).removeAllElements();
        jList1.clearSelection();

        if (baseDados.getOut(ConstantsFuzzy.VARIABLE_OUTPUT) != null) {
            for (FuncPertinence func : baseDados.getOut(ConstantsFuzzy.VARIABLE_OUTPUT)) {
                ((DefaultListModel) jList4.getModel()).addElement(func);
            }
        }

        for (String string : dataTypeIn) {
            criarPanelInput(string);
        }

        for (Rule regra : regras.getRules()) {
            ((DefaultListModel) jList1.getModel()).addElement(regra);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                RuleEditorPanel panel = new RuleEditorPanel(new MainView().getControllerSelected());
                JDialog dialog = new JDialog();
                dialog.add(panel);
                dialog.setLocationRelativeTo(null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JList jList4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}

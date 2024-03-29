/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ControlerPanel.java
 *
 * Created on 17/11/2010, 17:33:06
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.Defuzzification;
import br.ufrn.controle.fuzzycontroller.domain.FuzzyController;
import br.ufrn.controle.fuzzycontroller.domain.Mamdani;
import br.ufrn.controle.fuzzycontroller.domain.Sugeno;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import java.awt.Cursor;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Rivaldo Jr
 */
public class ControlerPanel extends javax.swing.JPanel {

    private ArrayList<FuzzyController> controllers;
    private final int MIN = 0;
    private final int PROD = 1;
    private final int CENTROID = 0;
    private final int SOM = 1;
    private final int MOM = 2;
    private final int LOM = 3;
    private MainView parent;

    /** Creates new form ControlerPanel */
    public ControlerPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listControler = new javax.swing.JList();
        btAdd = new javax.swing.JButton();
        btR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tbNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbTipo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbAnd = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cbDef = new javax.swing.JComboBox();
        checkIncremental = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.jPanel1.border.title"))); // NOI18N

        listControler.setModel(new DefaultListModel());
        listControler.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listControlerValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listControler);

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/adicionar.png"))); // NOI18N
        btAdd.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.btAdd.text")); // NOI18N
        btAdd.setContentAreaFilled(false);
        btAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btAddMouseExited(evt);
            }
        });
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/cancel.png"))); // NOI18N
        btR.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.btR.text")); // NOI18N
        btR.setContentAreaFilled(false);
        btR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btRMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btRMouseExited(evt);
            }
        });
        btR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                        .addGap(10, 10, 10))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btAdd)
                    .addComponent(btR))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.jPanel2.border.title"))); // NOI18N

        jLabel1.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.jLabel1.text")); // NOI18N

        tbNome.setEditable(false);
        tbNome.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.tbNome.text")); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.jLabel2.text")); // NOI18N

        tbTipo.setEditable(false);
        tbTipo.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.tbTipo.text")); // NOI18N

        jLabel3.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.jLabel3.text")); // NOI18N

        cbAnd.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MIN", "PROD" }));
        cbAnd.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAndItemStateChanged(evt);
            }
        });

        jLabel4.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.jLabel4.text")); // NOI18N

        cbDef.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CENTROID", "SOM", "MOM", "LOM" }));
        cbDef.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDefItemStateChanged(evt);
            }
        });

        checkIncremental.setText(org.openide.util.NbBundle.getMessage(ControlerPanel.class, "ControlerPanel.checkIncremental.text")); // NOI18N
        checkIncremental.setOpaque(false);
        checkIncremental.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                checkIncrementalItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(cbAnd, 0, 100, Short.MAX_VALUE)
                    .addComponent(cbDef, 0, 100, Short.MAX_VALUE)
                    .addComponent(tbNome, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(checkIncremental, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cbDef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkIncremental)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setParent(MainView p) {
        parent = p;
    }

    private void btRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRActionPerformed

        DefaultListModel dlm = (DefaultListModel) listControler.getModel();
        FuzzyController fc = (FuzzyController) listControler.getSelectedValue();

        if (fc != null) {
            controllers.remove(fc);
            dlm.removeElement(fc);
        }
    }//GEN-LAST:event_btRActionPerformed

    private void listControlerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listControlerValueChanged
        preencheDados();
    }//GEN-LAST:event_listControlerValueChanged

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed

        ControlerTypeDialog ctd = new ControlerTypeDialog(null, true);
        ctd.setLocationRelativeTo(this);
        ctd.setVisible(true);

        if (ctd.isValid()) {

            FuzzyController fc = new FuzzyController(ctd.getSelectedName());



            if (ConstantsFuzzy.MAMDAMI.equals(ctd.getSelectedControler())) {
                fc.setInference(new Mamdani());
                fc.setDefuzzification(new Defuzzification(ConstantsFuzzy.DEFUZZI_CENTROID));
            } else {
                fc.setInference(new Sugeno());
                fc.setDefuzzification(new Defuzzification(ConstantsFuzzy.DEFUZZI_SUGENO));
            }

            parent.configure(fc);
            controllers.add(fc);
            preencheLista(controllers);
        }

    }//GEN-LAST:event_btAddActionPerformed

    private void btAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseEntered
        btAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btAddMouseEntered

    private void btRMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRMouseEntered
        btR.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btRMouseEntered

    private void btAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btAddMouseExited
        btAdd.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btAddMouseExited

    private void btRMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btRMouseExited
        btR.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btRMouseExited

    private void cbDefItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDefItemStateChanged
        int index = cbDef.getSelectedIndex();

        FuzzyController controller = getSelectedFunc();

        if (controller != null) {
            switch (index) {
                case CENTROID:
                    controller.getDefuzzification().setDefuzzificationType(ConstantsFuzzy.DEFUZZI_CENTROID);
                    break;
                case SOM:
                    controller.getDefuzzification().setDefuzzificationType(ConstantsFuzzy.DEFUZZI_SOM);
                    break;
                case LOM:
                    controller.getDefuzzification().setDefuzzificationType(ConstantsFuzzy.DEFUZZI_LOM);
                    break;
                case MOM:
                    controller.getDefuzzification().setDefuzzificationType(ConstantsFuzzy.DEFUZZI_MOM);
                    break;
            }
        }
    }//GEN-LAST:event_cbDefItemStateChanged

    private void cbAndItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAndItemStateChanged
        int index = cbAnd.getSelectedIndex();

        FuzzyController controller = getSelectedFunc();

        if (controller != null) {
            switch (index) {
                case MIN:
                    controller.getInference().setAndFunction(ConstantsFuzzy.MIN_FUNCTION);
                    break;
                case PROD:
                    controller.getInference().setAndFunction(ConstantsFuzzy.PROD_FUNCTION);
                    break;
            }
        }
    }//GEN-LAST:event_cbAndItemStateChanged

    private void checkIncrementalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_checkIncrementalItemStateChanged
        // TODO add your handling code here:
        FuzzyController controller = getSelectedFunc();

        if (controller == null) {
            return;
        }

        controller.setIncremental(checkIncremental.isSelected());
    }//GEN-LAST:event_checkIncrementalItemStateChanged

    public FuzzyController getSelectedFunc() {
        return (FuzzyController) listControler.getSelectedValue();
    }

    private void preencheDados() {
        FuzzyController fc = getSelectedFunc();

        if (fc != null) {
            tbNome.setText(fc.toString());
            tbTipo.setText(fc.getInference().toString());

            int tipoAnd = fc.getInference().getAndFunction();

            switch (tipoAnd) {
                case ConstantsFuzzy.MIN_FUNCTION:
                    cbAnd.setSelectedIndex(MIN);
                    break;
                case ConstantsFuzzy.PROD_FUNCTION:
                    cbAnd.setSelectedIndex(PROD);
                    break;
            }

            if (fc.getInference() instanceof Sugeno) {
                cbDef.setEnabled(false);
            } else {
                cbDef.setEnabled(true);
            }

            int defuzzy = fc.getDefuzzification().getDefuzzificationType();

            switch (defuzzy) {
                case ConstantsFuzzy.DEFUZZI_CENTROID:
                    cbDef.setSelectedIndex(CENTROID);
                    break;
                case ConstantsFuzzy.DEFUZZI_LOM:
                    cbDef.setSelectedIndex(LOM);
                    break;
                case ConstantsFuzzy.DEFUZZI_MOM:
                    cbDef.setSelectedIndex(MOM);
                    break;
                case ConstantsFuzzy.DEFUZZI_SOM:
                    cbDef.setSelectedIndex(SOM);
                    break;
            }


        }
    }

    public void clearData() {
        tbNome.setText("");
        tbTipo.setText("");
        cbAnd.setSelectedIndex(0);
        cbDef.setSelectedIndex(0);
    }

    public void preencheLista(ArrayList<FuzzyController> con) {

        DefaultListModel dlm = (DefaultListModel) listControler.getModel();
        dlm.removeAllElements();

        controllers = con;

        for (FuzzyController fuzzyController : con) {
            dlm.addElement(fuzzyController);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btR;
    private javax.swing.JComboBox cbAnd;
    private javax.swing.JComboBox cbDef;
    private javax.swing.JCheckBox checkIncremental;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList listControler;
    private javax.swing.JTextField tbNome;
    private javax.swing.JTextField tbTipo;
    // End of variables declaration//GEN-END:variables
}

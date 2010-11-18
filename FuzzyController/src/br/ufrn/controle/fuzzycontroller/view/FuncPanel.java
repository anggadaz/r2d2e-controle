/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FuncPanel.java
 *
 * Created on 17/11/2010, 22:26:23
 */

package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.domain.InputOutput;
import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncaoTrapezoidal;
import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncaoTriangular;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Rivaldo Jr
 */
public class FuncPanel extends javax.swing.JPanel {

    private FuncPertinence old;
    private boolean delete = false;

    IOPanel parent = null;

    /** Creates new form FuncPanel */
    public FuncPanel() {
        initComponents();

        DefaultComboBoxModel dlm = (DefaultComboBoxModel) cbType.getModel();
        dlm.removeAllElements();

        for (String s : ConstantsFuzzy.VARIABLES) {
            dlm.addElement(s);
        }

        funcaoPertinenciaPanel1.setRange(-3, 3);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        funcaoPertinenciaPanel1 = new br.ufrn.controle.fuzzycontroller.view.FuncaoPertinenciaPanel();
        jpInput = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbType = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        tbRange = new javax.swing.JTextField();
        btDel = new javax.swing.JButton();
        btAtua = new javax.swing.JButton();
        jpFunc = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cbFunctionType = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tbFunctionName = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        tbParam = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout funcaoPertinenciaPanel1Layout = new javax.swing.GroupLayout(funcaoPertinenciaPanel1);
        funcaoPertinenciaPanel1.setLayout(funcaoPertinenciaPanel1Layout);
        funcaoPertinenciaPanel1Layout.setHorizontalGroup(
            funcaoPertinenciaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 304, Short.MAX_VALUE)
        );
        funcaoPertinenciaPanel1Layout.setVerticalGroup(
            funcaoPertinenciaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 237, Short.MAX_VALUE)
        );

        jpInput.setBackground(new java.awt.Color(255, 255, 255));
        jpInput.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.jpInput.border.title"))); // NOI18N

        jLabel2.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.jLabel2.text")); // NOI18N

        cbType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.jLabel3.text")); // NOI18N

        btDel.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.btDel.text")); // NOI18N
        btDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDelActionPerformed(evt);
            }
        });

        btAtua.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.btAtua.text")); // NOI18N
        btAtua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtuaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpInputLayout = new javax.swing.GroupLayout(jpInput);
        jpInput.setLayout(jpInputLayout);
        jpInputLayout.setHorizontalGroup(
            jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInputLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInputLayout.createSequentialGroup()
                        .addGroup(jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbRange, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(cbType, 0, 113, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpInputLayout.createSequentialGroup()
                        .addComponent(btAtua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDel)))
                .addContainerGap())
        );
        jpInputLayout.setVerticalGroup(
            jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInputLayout.createSequentialGroup()
                .addGroup(jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tbRange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jpInputLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDel)
                    .addComponent(btAtua)))
        );

        jpFunc.setBackground(new java.awt.Color(255, 255, 255));
        jpFunc.setBorder(javax.swing.BorderFactory.createTitledBorder(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.jpFunc.border.title"))); // NOI18N

        jLabel4.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.jLabel4.text")); // NOI18N

        cbFunctionType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Triangular", "Trapezoidal" }));

        jLabel5.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.jLabel5.text")); // NOI18N

        btAdd.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.btAdd.text")); // NOI18N
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        jLabel6.setText(org.openide.util.NbBundle.getMessage(FuncPanel.class, "FuncPanel.jLabel6.text")); // NOI18N

        javax.swing.GroupLayout jpFuncLayout = new javax.swing.GroupLayout(jpFunc);
        jpFunc.setLayout(jpFuncLayout);
        jpFuncLayout.setHorizontalGroup(
            jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFuncLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpFuncLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tbParam, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                    .addComponent(btAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpFuncLayout.createSequentialGroup()
                        .addGroup(jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbFunctionType, 0, 130, Short.MAX_VALUE)
                            .addComponent(tbFunctionName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jpFuncLayout.setVerticalGroup(
            jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFuncLayout.createSequentialGroup()
                .addGroup(jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tbFunctionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbFunctionType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpFuncLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tbParam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btAdd)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(funcaoPertinenciaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpFunc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(funcaoPertinenciaPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed

        if(!delete) {
            addFunction();
        } else {
            delFunction();
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void btAtuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtuaActionPerformed
        InputOutput ioSelected = parent.getSelected();

        if(ioSelected == null) {
            return;
        }

        ioSelected.setVariable((String) cbType.getSelectedItem());
        ioSelected.setRange(tbRange.getText());
    }//GEN-LAST:event_btAtuaActionPerformed

    private void btDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDelActionPerformed
        InputOutput ioSelected = parent.getSelected();

        if(ioSelected == null) {
            return;
        }

        parent.removeIO(ioSelected);
        enableAll(false);
    }//GEN-LAST:event_btDelActionPerformed

    public void setParent(IOPanel parent) {
        this.parent = parent;
    }

    private void delFunction() {
        funcaoPertinenciaPanel1.deletTarget();
        clearFuncData();
    }

    private void addFunction() {

        String nome = tbFunctionName.getText();
        ArrayList<Double> param = getParametros();

        if (param == null || "".equals(nome)) {
            return;
        }

        FuncPertinence func = null;

        if ("Triangular".equals(cbFunctionType.getSelectedItem())) {
            func = new FuncaoTriangular(nome, param);
        } else {
            func = new FuncaoTrapezoidal(nome, param);
        }

        funcaoPertinenciaPanel1.addFunc(func);
        funcaoPertinenciaPanel1.repaint();
        clearFuncData();
    }

    public void setIoSelected() {

        InputOutput ioSelected = parent.getSelected();

        if(ioSelected == null) {
            return;
        }

        enableAll(true);

        setVariable(ioSelected.getVariable());
        setRange(ioSelected.getRange());

        setFunctions(ioSelected.getFuncs());
    }

    private ArrayList<Double> getParametros()
    {
        String param = tbParam.getText();
        String[] partes = param.split(" ");

        if (partes.length < 3 || partes.length > 4) {
            return null;
        }

        ArrayList<Double> res = new ArrayList<Double>();

        try {

            for (String string : partes) {
                res.add(Double.parseDouble(string));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;

    }

    public boolean isDelete() {
        return delete;
    }

    public void setDelete(boolean delete, FuncPertinence func) {
        if(!delete) {
            btAdd.setText("Adicionar");
        } else {
            btAdd.setText("Remover");
        }

        old = func;
        this.delete = delete;
    }

    public void enableAll(boolean bool) {

        if(!bool) {
           clearFuncData();
            clearInOutData();
        }

        cbType.setEnabled(bool);
        tbRange.setEnabled(bool);
        btAtua.setEnabled(bool);
        btDel.setEnabled(bool);

        tbFunctionName.setEnabled(bool);
        cbFunctionType.setEnabled(bool);
        tbParam.setEnabled(bool);
        btAdd.setEnabled(bool);

        setFunctions(new ArrayList<FuncPertinence>());
    }

    public void clearInOutData() {
        tbRange.setText("");
    }

    public void clearFuncData() {
        tbParam.setText("");
        tbFunctionName.setText("");
        setDelete(false, null);
    }

    public void setVariable(String text) {
        cbType.setSelectedItem(text);
    }

    public void setRange(String range) {
        tbRange.setText(range);
    }

    public void setFunctions(ArrayList<FuncPertinence> func) {
        funcaoPertinenciaPanel1.setFuncs(func);
    }

    public JButton getBtAdd() {
        return btAdd;
    }

    public FuncaoPertinenciaPanel getFuncaoPertinenciaPanel1() {
        return funcaoPertinenciaPanel1;
    }

    public JTextField getTbFunctionName() {
        return tbFunctionName;
    }

    public JTextField getTbParam() {
        return tbParam;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btAtua;
    private javax.swing.JButton btDel;
    private javax.swing.JComboBox cbFunctionType;
    private javax.swing.JComboBox cbType;
    private br.ufrn.controle.fuzzycontroller.view.FuncaoPertinenciaPanel funcaoPertinenciaPanel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jpFunc;
    private javax.swing.JPanel jpInput;
    private javax.swing.JTextField tbFunctionName;
    private javax.swing.JTextField tbParam;
    private javax.swing.JTextField tbRange;
    // End of variables declaration//GEN-END:variables

}

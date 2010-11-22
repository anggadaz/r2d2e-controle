/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FuncPanel.java
 *
 * Created on 17/11/2010, 20:13:01
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.domain.FuzzyController;
import br.ufrn.controle.fuzzycontroller.domain.InputOutput;
import java.util.ArrayList;
import javax.swing.JDialog;

/**
 *
 * @author Rivaldo Jr
 */
public class IOPanel extends javax.swing.JPanel {

    public static FuncPanel FPanel = null;
    private InputOutput selected;
    private FuzzyController controller;

    public FuzzyController getController() {
        return controller;
    }

    public void setController(FuzzyController controller) {
        this.controller = controller;
    }

    public void updateRange() {
        String range = selected.getRange();

        String[] partes = range.split(" ");

        double min = 0.0, max = 0.0;

        try {
            if (partes != null) {
                min = Double.parseDouble(partes[0]);
                max = Double.parseDouble(partes[1]);
            }
        } catch (Exception e) {
        }

        ArrayList<Double> ranges = new ArrayList<Double>();
        ranges.add(min);
        ranges.add(max);

        if (selected.getType() == InputOutput.INPUT) {
            controller.getInference().getDataBase().addRangeIn(selected.getVariable(), ranges);

        } else if (selected.getType() == InputOutput.OUTPUT) {
            controller.getInference().getDataBase().addRangeOut(selected.getVariable(), ranges);
        }
    }

    public void addFunc(FuncPertinence func) {

        if (selected.getType() == InputOutput.INPUT) {
            if (!controller.getDataInType().contains(selected.getVariable())) {
                controller.getDataInType().add(selected.getVariable());
            }
            controller.getInference().getDataBase().addIn(selected.getVariable(), func);

        } else if (selected.getType() == InputOutput.OUTPUT) {
            controller.getInference().getDataBase().addOut(selected.getVariable(), func);
        }

    }

    /** Creates new form FuncPanel */
    public IOPanel() {
        initComponents();
        funcPanel1.setParent(this);
        funcPanel1.enableAll(false);
        FPanel = funcPanel1;
    }

    public void setSelected(InputOutput selected) {

        if (this.selected != null) {
            this.selected.select(false);
        }

        this.selected = selected;
        this.selected.select(true);
        funcPanel1.setIoSelected();
    }

    public InputOutput getSelected() {
        return selected;
    }

    public void removeIO(InputOutput io) {
        tpInput.removeItem(io);
        tpOutput.removeItem(io);

        tpInput.repaint();
        tpOutput.repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        translucentPanel1 = new br.ufrn.siga.component.translucent.TranslucentPanel();
        tpInput = new br.ufrn.siga.component.scroll.ScrollPanel();
        translucentPanel2 = new br.ufrn.siga.component.translucent.TranslucentPanel();
        tpOutput = new br.ufrn.siga.component.scroll.ScrollPanel();
        btAddOut = new javax.swing.JButton();
        btAddIn = new javax.swing.JButton();
        funcPanel1 = new br.ufrn.controle.fuzzycontroller.view.FuncPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout translucentPanel1Layout = new javax.swing.GroupLayout(translucentPanel1);
        translucentPanel1.setLayout(translucentPanel1Layout);
        translucentPanel1Layout.setHorizontalGroup(
            translucentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpInput, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        translucentPanel1Layout.setVerticalGroup(
            translucentPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(translucentPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpInput, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout translucentPanel2Layout = new javax.swing.GroupLayout(translucentPanel2);
        translucentPanel2.setLayout(translucentPanel2Layout);
        translucentPanel2Layout.setHorizontalGroup(
            translucentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tpOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        translucentPanel2Layout.setVerticalGroup(
            translucentPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(translucentPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tpOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                .addContainerGap())
        );

        btAddOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/adicionar.png"))); // NOI18N
        btAddOut.setText(org.openide.util.NbBundle.getMessage(IOPanel.class, "IOPanel.btAddOut.text")); // NOI18N
        btAddOut.setBorderPainted(false);
        btAddOut.setContentAreaFilled(false);
        btAddOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddOutActionPerformed(evt);
            }
        });

        btAddIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/adicionar.png"))); // NOI18N
        btAddIn.setText(org.openide.util.NbBundle.getMessage(IOPanel.class, "IOPanel.btAddIn.text")); // NOI18N
        btAddIn.setBorderPainted(false);
        btAddIn.setContentAreaFilled(false);
        btAddIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(translucentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddIn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(translucentPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAddOut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(funcPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(translucentPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(translucentPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btAddOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btAddIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(funcPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btAddInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddInActionPerformed
        tpInput.addItem(new InputOutput(InputOutput.INPUT, this));
    }//GEN-LAST:event_btAddInActionPerformed

    private void btAddOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddOutActionPerformed
        tpOutput.addItem(new InputOutput(InputOutput.OUTPUT, this));
    }//GEN-LAST:event_btAddOutActionPerformed

    public void addIn(FuncPertinence func, String variable, String range) {
        ArrayList x = new ArrayList<FuncPertinence>();
        x.add(func);
        addIn(x, variable, range);
    }

    public void addIn(ArrayList<FuncPertinence> funcs, String variable, String range) {
        InputOutput inputOutput = new InputOutput(InputOutput.INPUT, this);
        inputOutput.setFuncs(funcs);
        inputOutput.setVariable(variable);
        inputOutput.setRange(range);
        tpInput.addItem(inputOutput);
    }

    public void addOut(ArrayList<FuncPertinence> funcs, String variable, String range) {
        InputOutput inputOutput = new InputOutput(InputOutput.OUTPUT, this);
        inputOutput.setFuncs(funcs);
        inputOutput.setVariable(variable);
        inputOutput.setRange(range);
        tpOutput.addItem(inputOutput);
    }

    public void clear() {
        tpInput.removeAllItems();
        tpOutput.removeAllItems();
        funcPanel1.clearFuncData();
        funcPanel1.clearInOutData();
        funcPanel1.enableAll(false);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddIn;
    private javax.swing.JButton btAddOut;
    private br.ufrn.controle.fuzzycontroller.view.FuncPanel funcPanel1;
    private br.ufrn.siga.component.scroll.ScrollPanel tpInput;
    private br.ufrn.siga.component.scroll.ScrollPanel tpOutput;
    private br.ufrn.siga.component.translucent.TranslucentPanel translucentPanel1;
    private br.ufrn.siga.component.translucent.TranslucentPanel translucentPanel2;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JDialog dialog = new JDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.add(new IOPanel());
                dialog.setVisible(true);
            }
        });
    }

    public FuncPanel getFuncPanel1() {
        return funcPanel1;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * OpcoesTanque.java
 *
 * Created on 22/10/2010, 16:17:00
 */

package br.ufrn.controle.fuzzycontroller.view.retractable;

import br.ufrn.siga.component.retractable.RetractablePanelContent;

/**
 *
 * @author Demetrios
 */
public class OpcoesTanque extends javax.swing.JPanel implements RetractablePanelContent {

    private boolean compact;

    /** Creates new form OpcoesTanque */
    public OpcoesTanque() {
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

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void showCompact() {
        compact = true;
    }

    public void showFull() {
        compact = false;
    }

    public boolean isCompactView() {
        return compact;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}

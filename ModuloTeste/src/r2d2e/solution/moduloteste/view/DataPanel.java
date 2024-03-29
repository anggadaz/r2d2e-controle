/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DataPanel.java
 *
 * Created on 05/05/2010, 09:49:28
 */

package r2d2e.solution.moduloteste.view;

import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Rivaldo Jr
 */
public class DataPanel extends javax.swing.JPanel {

    /** Creates new form DataPanel */
    public DataPanel() {
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

        jLabel1 = new javax.swing.JLabel();
        tfOvershoot = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfRise = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfPeak = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cbRise = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        tfAcomodation = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 0, 0));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.jLabel1.text")); // NOI18N

        tfOvershoot.setEditable(false);
        tfOvershoot.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.tfOvershoot.text")); // NOI18N

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.jLabel2.text")); // NOI18N

        tfRise.setEditable(false);
        tfRise.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.tfRise.text")); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.jLabel3.text")); // NOI18N

        tfPeak.setEditable(false);
        tfPeak.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.tfPeak.text")); // NOI18N

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.jLabel4.text")); // NOI18N

        cbRise.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2 %", "5 %", "7 %", "10 %" }));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.jLabel5.text")); // NOI18N

        tfAcomodation.setEditable(false);
        tfAcomodation.setText(org.openide.util.NbBundle.getMessage(DataPanel.class, "DataPanel.tfAcomodation.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(cbRise, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfPeak))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfRise))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfOvershoot))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(tfAcomodation))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfOvershoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfPeak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfAcomodation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbRise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbRise;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField tfAcomodation;
    private javax.swing.JTextField tfOvershoot;
    private javax.swing.JTextField tfPeak;
    private javax.swing.JTextField tfRise;
    // End of variables declaration//GEN-END:variables

    public JTextField getTfOvershoot() {
        return tfOvershoot;
    }

    public JTextField getTfRise() {
        return tfRise;
    }

    public JComboBox getCbRise() {
        return cbRise;
    }

    public JTextField getTfAcomodation() {
        return tfAcomodation;
    }

    public JTextField getTfPeak() {
        return tfPeak;
    }
    
    public int getCriterio() {
        
        String atual = (String) cbRise.getSelectedItem();
        
        if("5 %".equals(atual)) {
            return 5;
        }
        
        if("7 %".equals(atual)) {
            return 7;
        }

        if("10 %".equals(atual)) {
            return 10;
        }

        return 2;
    }

}

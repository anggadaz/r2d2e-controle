/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestePanel.java
 *
 * Created on 06/04/2010, 02:13:52
 */

package r2d2e.solution.moduloteste.view;

/**
 *
 * @author Rivaldo Jr
 */
public class TestePanel extends javax.swing.JPanel {

    /** Creates new form TestePanel */
    public TestePanel() {
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

        jSplitPane1 = new javax.swing.JSplitPane();
        tabelaPanel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        mediaField = new javax.swing.JTextField();
        Exportar = new javax.swing.JButton();
        tabelaPanel1 = new javax.swing.JPanel();
        scrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        mediaField1 = new javax.swing.JTextField();
        Exportar1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setOpaque(false);

        jSplitPane1.setDividerLocation(350);

        tabelaPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        scrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tensão", "Tempo", "Km"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(table);

        jLabel9.setText(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.jLabel9.text")); // NOI18N

        mediaField.setEditable(false);
        mediaField.setToolTipText(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.mediaField.toolTipText")); // NOI18N

        Exportar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/export.png"))); // NOI18N
        Exportar.setToolTipText(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.Exportar.toolTipText")); // NOI18N
        Exportar.setBorderPainted(false);
        Exportar.setContentAreaFilled(false);

        javax.swing.GroupLayout tabelaPanelLayout = new javax.swing.GroupLayout(tabelaPanel);
        tabelaPanel.setLayout(tabelaPanelLayout);
        tabelaPanelLayout.setHorizontalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelaPanelLayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mediaField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );
        tabelaPanelLayout.setVerticalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelaPanelLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mediaField)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(tabelaPanel);

        tabelaPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        scrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tensão", "Tempo", "Km"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.setOpaque(false);
        scrollPane1.setViewportView(table1);

        jLabel10.setText(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.jLabel10.text")); // NOI18N

        mediaField1.setEditable(false);
        mediaField1.setToolTipText(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.mediaField1.toolTipText")); // NOI18N

        Exportar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/r2d2e/solution/moduloteste/view/resources/export.png"))); // NOI18N
        Exportar1.setToolTipText(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.Exportar1.toolTipText")); // NOI18N
        Exportar1.setBorderPainted(false);
        Exportar1.setContentAreaFilled(false);

        javax.swing.GroupLayout tabelaPanel1Layout = new javax.swing.GroupLayout(tabelaPanel1);
        tabelaPanel1.setLayout(tabelaPanel1Layout);
        tabelaPanel1Layout.setHorizontalGroup(
            tabelaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabelaPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(mediaField1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exportar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
        );
        tabelaPanel1Layout.setVerticalGroup(
            tabelaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelaPanel1Layout.createSequentialGroup()
                .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(tabelaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Exportar1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabelaPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mediaField1)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(tabelaPanel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.jPanel1.TabConstraints.tabTitle"), jPanel1); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 344, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.jPanel2.TabConstraints.tabTitle"), jPanel2); // NOI18N

        jSplitPane1.setLeftComponent(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exportar;
    private javax.swing.JButton Exportar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mediaField;
    private javax.swing.JTextField mediaField1;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JScrollPane scrollPane1;
    private javax.swing.JPanel tabelaPanel;
    private javax.swing.JPanel tabelaPanel1;
    private javax.swing.JTable table;
    private javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables

}
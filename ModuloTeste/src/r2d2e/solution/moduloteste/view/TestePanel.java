package r2d2e.solution.moduloteste.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Rivaldo Jr
 */
public class TestePanel extends javax.swing.JPanel {

    /** Creates new form TestePanel */
    public TestePanel() {
        initComponents();
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getMediaField() {
        return mediaField;
    }

    public JPanel getGraficoNivel() {
        return graficoNivel;
    }

    public void addChartNivel(ChartPanel chart) {
        graficoNivel.add(chart);
    }

    public JPanel getGraficoTensao() {
        return graficoTensao;
    }

    public void addChartTensao(ChartPanel chart) {
        graficoTensao.add(chart);
    }

    public void setGraficoNivel(JPanel graficoNivel) {
        this.graficoNivel = graficoNivel;
    }

    public void setGraficoTensao(JPanel graficoTensao) {
        this.graficoTensao = graficoTensao;
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        graficoNivel = new javax.swing.JPanel();
        graficoTensao = new javax.swing.JPanel();

        setOpaque(false);

        jSplitPane1.setDividerLocation(500);
        jSplitPane1.setOpaque(false);

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
                .addComponent(mediaField, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        tabelaPanelLayout.setVerticalGroup(
            tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabelaPanelLayout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addGap(15, 15, 15)
                .addGroup(tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Exportar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabelaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(mediaField)
                        .addComponent(jLabel9)))
                .addContainerGap())
        );

        jSplitPane1.setRightComponent(tabelaPanel);

        graficoNivel.setOpaque(false);
        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.graficoNivel.TabConstraints.tabTitle"), graficoNivel); // NOI18N

        graficoTensao.setOpaque(false);
        jTabbedPane1.addTab(org.openide.util.NbBundle.getMessage(TestePanel.class, "TestePanel.graficoTensao.TabConstraints.tabTitle"), graficoTensao); // NOI18N

        jSplitPane1.setLeftComponent(jTabbedPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 792, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exportar;
    private javax.swing.JPanel graficoNivel;
    private javax.swing.JPanel graficoTensao;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mediaField;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JPanel tabelaPanel;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}

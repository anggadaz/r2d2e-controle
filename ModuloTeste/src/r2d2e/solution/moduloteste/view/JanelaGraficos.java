/*
 * JanelaGraficos.java
 *
 * Created on 05/05/2010, 11:32:50
 */

package r2d2e.solution.moduloteste.view;

import java.awt.Component;
import java.awt.Dimension;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartPanel;

/**
 *
 * @author Rivaldo Jr
 */
public class JanelaGraficos extends javax.swing.JDialog {

    ArrayList<ChartPanel> charts = new ArrayList<ChartPanel>();

    /** Creates new form JanelaGraficos */
    public JanelaGraficos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        URL imgURL = getClass().getResource("/r2d2e/solution/moduloteste/view/resources/r2d2e.jpg");

        setIconImage(new ImageIcon(imgURL).getImage());
        setLocationRelativeTo(parent);
    }

    public void clear() {
        charts = new ArrayList<ChartPanel>();
        panelGraph.removeAll();
    }

    public void addGraph(ChartPanel chart) {
        charts.add(chart);
        resizeCharts();
    }

    private void resizeCharts() {

        panelGraph.removeAll();

        if(charts.size() == 0) {
            return;
        }

        int w = panelGraph.getWidth();
        int h = panelGraph.getHeight() / charts.size();

        for (ChartPanel chart : charts) {
            chart.setPreferredSize(new Dimension(w, h));
            chart.setSize(new Dimension(w, h));
            panelGraph.add(chart);
        }

        repaint();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGraph = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        panelGraph.setName("Gráficos"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGraph, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGraph, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        resizeCharts();
    }//GEN-LAST:event_formComponentResized

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JanelaGraficos dialog = new JanelaGraficos(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel panelGraph;
    // End of variables declaration//GEN-END:variables

}

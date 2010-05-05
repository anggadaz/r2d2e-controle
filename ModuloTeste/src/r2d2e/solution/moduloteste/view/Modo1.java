package r2d2e.solution.moduloteste.view;

import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import r2d2e.solution.moduloteste.domain.graph.ModoVisualizacao;

/**
 *
 * @author Rivaldo Jr
 */
public class Modo1 extends JPanel implements ModoVisualizacao {

    /** Creates new form TestePanel */
    public Modo1() {
        initComponents();
    }

    public void addChart(int ix, ChartPanel chart) {
        if(ix == 0) {
            graph1.removeAll();
            graph1.add(chart);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graph1 = new javax.swing.JPanel();

        setOpaque(false);

        graph1.setBackground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graph1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graph1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel graph1;
    // End of variables declaration//GEN-END:variables

    public void clear() {
        graph1.removeAll();
    }

}

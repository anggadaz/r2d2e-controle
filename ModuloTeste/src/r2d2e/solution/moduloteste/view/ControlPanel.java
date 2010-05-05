/*
 * ControlPanel.java
 *
 * Created on 04/05/2010, 14:35:40
 */

package r2d2e.solution.moduloteste.view;

import java.awt.CardLayout;
import r2d2e.solution.moduloteste.domain.graph.ConfigGraph;
import r2d2e.solution.moduloteste.domain.graph.IGraphTime;
import r2d2e.solution.moduloteste.domain.graph.ModoVisualizacao;
import r2d2e.solution.moduloteste.handler.ControlModeHandler;

/**
 *
 * @author Rivaldo Jr
 */
public class ControlPanel extends javax.swing.JPanel {

    public static final String CARD_MODO1 = "cardModo1";
    public static final String CARD_MODO2 = "cardModo2";
    public static final String CARD_MODO3 = "cardModo3";

    private static ModoVisualizacao modo;

    /** Creates new form ControlPanel */
    public ControlPanel() {
        initComponents();
    }

    public void setModo() {

        if(modo != null) {
            modo.clear();
        }

        switch(ConfigGraph.MODO) {
            case 1:
                modo = modo1;
                changeCard(CARD_MODO1);
                break;
            case 2:
                modo = modo2;
                changeCard(CARD_MODO2);
                break;
            case 3:
                modo = modo3;
                changeCard(CARD_MODO3);
                break;
        }
    }

    public void initChart() {

        setModo();
        IGraphTime[] graphs = ControlModeHandler.getChart();

        int gIx = 0;

        for (int i = 0; i < ConfigGraph.MODO; i++) {
            gIx = ConfigGraph.GRAFICOS[i];
            modo.addChart(i, graphs[gIx].getChart());
        }
    }

    public void changeCard(String card) {
        CardLayout layout = (CardLayout) panelGrafico.getLayout();
        layout.show(panelGrafico, card);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDados = new javax.swing.JPanel();
        dataPanel1 = new r2d2e.solution.moduloteste.view.DataPanel();
        panelGrafico = new javax.swing.JPanel();
        modo3 = new r2d2e.solution.moduloteste.view.Modo3();
        modo2 = new r2d2e.solution.moduloteste.view.Modo2();
        modo1 = new r2d2e.solution.moduloteste.view.Modo1();

        setOpaque(false);

        panelDados.setOpaque(false);

        javax.swing.GroupLayout panelDadosLayout = new javax.swing.GroupLayout(panelDados);
        panelDados.setLayout(panelDadosLayout);
        panelDadosLayout.setHorizontalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dataPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelDadosLayout.setVerticalGroup(
            panelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDadosLayout.createSequentialGroup()
                .addComponent(dataPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        panelGrafico.setLayout(new java.awt.CardLayout());
        panelGrafico.add(modo3, "cardModo3");
        panelGrafico.add(modo2, "cardModo2");
        panelGrafico.add(modo1, "cardModo1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private r2d2e.solution.moduloteste.view.DataPanel dataPanel1;
    private r2d2e.solution.moduloteste.view.Modo1 modo1;
    private r2d2e.solution.moduloteste.view.Modo2 modo2;
    private r2d2e.solution.moduloteste.view.Modo3 modo3;
    private javax.swing.JPanel panelDados;
    private javax.swing.JPanel panelGrafico;
    // End of variables declaration//GEN-END:variables

}

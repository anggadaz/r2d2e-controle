/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GlobalErrorChart.java
 *
 * Created on 19/12/2010, 20:02:22
 */
package ufrn.br.controle.neuralnetwork.view;

import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;
import ufrn.br.controle.neuralnetwork.handler.GlobalErrorChartHandler;

/**
 *
 * @author demetrios
 */
public class GlobalErrorChart extends ChartPanel {

    public static String TITLE = "Erro Global x Iterações";
    public static String EIXO_X = "Iterações";
    public static String EIXO_Y = "Erro Global";
    private PlotOrientation ORIENTATION = PlotOrientation.VERTICAL;
    private boolean CREATE_LEGENDS = true;
    private boolean SHOW_TOOLTIPS = true;
    private boolean CREATE_URL = true;
    private Color BACKGROUND_COLOR = Color.WHITE;
    private JFreeChart chart;
    private GlobalErrorChartHandler chartHandler;

    /** Creates new form GlobalErrorChart */
    public GlobalErrorChart() {
        super(null);
        initComponents();

        chartHandler = new GlobalErrorChartHandler();

        DefaultCategoryDataset dataset = chartHandler.getDataset();

        chart = ChartFactory.createLineChart3D(TITLE, EIXO_X, EIXO_Y, dataset, ORIENTATION, CREATE_LEGENDS, SHOW_TOOLTIPS, CREATE_URL);

        setChart(chart);

        config();
    }

    private void config() {
        XYPlot plot = chart.getXYPlot();

        NumberAxis domain = (NumberAxis) plot.getDomainAxis();
        NumberAxis range = (NumberAxis) plot.getRangeAxis();

        range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        domain.setLowerMargin(0.0);
        domain.setUpperMargin(0.0);
        domain.setTickLabelsVisible(true);

        plot.setBackgroundPaint(Color.white);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));

        plot.setDomainGridlinePaint(Color.GRAY);
        plot.setRangeGridlinePaint(Color.GRAY);

        ValueAxis valueaxis = plot.getDomainAxis();
        valueaxis.setAutoRange(true);
//        valueaxis.setFixedAutoRange(100d);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        plot.setRenderer(renderer);

    }

    public void setBACKGROUND_COLOR(Color BACKGROUND_COLOR) {
        this.BACKGROUND_COLOR = BACKGROUND_COLOR;
        chart.setBackgroundPaint(BACKGROUND_COLOR);
    }

    public void setEIXO_X(String EIXO_X) {
        this.EIXO_X = EIXO_X;
        chart.getXYPlot().getDomainAxis().setLabel(EIXO_X);
    }

    public void setEIXO_Y(String EIXO_Y) {
        this.EIXO_Y = EIXO_Y;
        chart.getXYPlot().getRangeAxis().setLabel(EIXO_Y);
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
        chart.setTitle(TITLE);
    }

    public Color getBACKGROUND_COLOR() {
        return BACKGROUND_COLOR;
    }

    public String getEIXO_X() {
        return EIXO_X;
    }

    public String getEIXO_Y() {
        return EIXO_Y;
    }

    public String getTITLE() {
        return TITLE;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 290, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
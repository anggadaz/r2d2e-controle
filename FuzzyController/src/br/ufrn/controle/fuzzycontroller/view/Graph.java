/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Graph.java
 *
 * Created on 20/10/2010, 22:00:37
 */
package br.ufrn.controle.fuzzycontroller.view;

import java.awt.Color;
import java.util.HashMap;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DefaultXYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author demetrios
 */
public class Graph extends ChartPanel {

    private static String TITLE = "Título";
    private static String EIXO_X = "Eixo X";
    private static String EIXO_Y = "Eixo Y";
    private static PlotOrientation ORIENTATION = PlotOrientation.VERTICAL;
    private static boolean CREATE_LEGENDS = false;
    private static boolean SHOW_TOOLTIPS = true;
    private static boolean CREATE_URL = true;
    private static Color BACKGROUND_COLOR = Color.WHITE;
    private static XYSeriesCollection seriesCollection = new XYSeriesCollection();
    private HashMap<String, XYSeries> mapSeries;
    private static JFreeChart chart;
    private long initTime;

    /** Creates new form Graph */
    public Graph() {
        super(criarGrafico());
        initComponents();

        mapSeries = new HashMap<String, XYSeries>();

        config();
    }

    private static JFreeChart criarGrafico() {

        chart = ChartFactory.createXYStepAreaChart(TITLE, TITLE, TITLE, seriesCollection, ORIENTATION, CREATE_URL, CREATE_URL, CREATE_URL);

        return chart;
    }

    public void init() {
        initTime = System.currentTimeMillis();
    }

    public void addValue(String tipo, double value) {
        XYSeries serie = mapSeries.get(tipo);
        if (serie == null) {
            serie = new XYSeries(tipo);
            seriesCollection.addSeries(serie);

            mapSeries.put(tipo, serie);
        }

        double diffTime = System.currentTimeMillis() - initTime;

        serie.add(diffTime / 1000, value);
    }

    public void removeSerie(String tipo) {
        XYSeries serie = mapSeries.remove(tipo);
        seriesCollection.removeSeries(serie);
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
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));

        plot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));

        ValueAxis valueaxis = plot.getDomainAxis();
        valueaxis.setAutoRange(false);
        valueaxis.setFixedAutoRange(10000d);

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);
        plot.setRenderer(renderer);

        NumberAxis numberaxis = new NumberAxis("Range Axis 2");
        numberaxis.setAutoRangeIncludesZero(false);
        plot.setRenderer(1, new DefaultXYItemRenderer());
        plot.setRangeAxis(1, numberaxis);
        //plot.mapDatasetToRangeAxis(1, 1);

    }

    public static Color getBACKGROUND_COLOR() {
        return BACKGROUND_COLOR;
    }

    public static void setBACKGROUND_COLOR(Color BACKGROUND_COLOR) {
        Graph.BACKGROUND_COLOR = BACKGROUND_COLOR;
    }

    public static boolean isCREATE_LEGENDS() {
        return CREATE_LEGENDS;
    }

    public static void setCREATE_LEGENDS(boolean CREATE_LEGENDS) {
        Graph.CREATE_LEGENDS = CREATE_LEGENDS;
    }

    public static boolean isCREATE_URL() {
        return CREATE_URL;
    }

    public static void setCREATE_URL(boolean CREATE_URL) {
        Graph.CREATE_URL = CREATE_URL;
    }

    public static String getEIXO_X() {
        return EIXO_X;
    }

    public static void setEIXO_X(String EIXO_X) {
        Graph.EIXO_X = EIXO_X;
    }

    public static String getEIXO_Y() {
        return EIXO_Y;
    }

    public static void setEIXO_Y(String EIXO_Y) {
        Graph.EIXO_Y = EIXO_Y;
    }

    public static PlotOrientation getORIENTATION() {
        return ORIENTATION;
    }

    public static void setORIENTATION(PlotOrientation ORIENTATION) {
        Graph.ORIENTATION = ORIENTATION;
    }

    public static boolean isSHOW_TOOLTIPS() {
        return SHOW_TOOLTIPS;
    }

    public static void setSHOW_TOOLTIPS(boolean SHOW_TOOLTIPS) {
        Graph.SHOW_TOOLTIPS = SHOW_TOOLTIPS;
    }

    public static String getTITLE() {
        return TITLE;
    }

    public static void setTITLE(String TITLE) {
        Graph.TITLE = TITLE;
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
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package r2d2e.solution.moduloteste.domain.graph;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Rivaldo
 */

public class BarChart extends JPanel {

    private double currentTime = 0;
    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    public void addSeries(double x) {
        addSeries(x, currentTime);
    }

    public void addSeries(double x, double y) {
        String tmp = Double.toString(x);
        dataset.addValue(y, "Tensão", tmp);
    }

    public ChartPanel getChart() {

        JFreeChart chart = ChartFactory.createLineChart("Tensão x Tempo", "Volts", "Tempo", dataset, PlotOrientation.VERTICAL, true, true, false);
        
        chart.setBackgroundPaint(Color.white);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setRangeGridlinePaint(Color.white);
        
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        //rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        // customise the renderer... 
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setShapesVisible(true);
        renderer.setDrawOutlines(true);
        renderer.setUseFillPaint(true);
        renderer.setFillPaint(Color.white);


        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.black)));
        chartPanel.setPreferredSize(new Dimension(650, 400));
        return chartPanel;
    }

    public void setCurrentTime(double t) {
        currentTime = t;
    }

    public void sample() {
        addSeries(1.0,3.3);
        addSeries(2.0,4.4);
        addSeries(3.0,1.7);
        addSeries(4.0,5.6);
    }

    public void clear() {
        dataset.clear();
    }

}

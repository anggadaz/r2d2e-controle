/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package r2d2e.solution.moduloteste.domain;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Rivaldo
 */

public class BarChart extends JPanel {

    private double currentTime = 0;
    private ArrayList<XYSeries> series = new ArrayList<XYSeries>();

    public void addSeries(double x) {
        addSeries(x, currentTime);
    }

    public void addSeries(double x, double y) {
        XYSeries nova = new XYSeries("Serie " + series.size() + 1);
        nova.add(x, y);
        series.add(nova);
    }

    public ChartPanel getChart() {

        XYSeriesCollection dataset = new XYSeriesCollection();
        for (XYSeries xYSeries : series) {
            dataset.addSeries(xYSeries);
        }

        JFreeChart chart = ChartFactory.createXYBarChart("Tensão x Tempo", "Volts", false, "Tempo", dataset, PlotOrientation.HORIZONTAL, true, true, false);
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(300, 300));
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
        series.clear();
    }

}

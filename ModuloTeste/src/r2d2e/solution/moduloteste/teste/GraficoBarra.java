/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package r2d2e.solution.moduloteste.teste;

import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Rivaldo
 */
public class GraficoBarra extends ApplicationFrame {

    public GraficoBarra(String titulo) {
        super(titulo);

        XYSeries series1 = new XYSeries("Series 1");
        series1.add(1.0,3.3);
        series1.add(2.0,4.4);
        series1.add(3.0,1.7);

        XYSeries series2 = new XYSeries("Series 2");
        series2.add(1.0,7.3);
        series2.add(2.0,6.8);
        series2.add(3.0,9.6);
        series2.add(4.0,5.6);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        JFreeChart chart = ChartFactory.createXYBarChart("Bar demo", "Category", false, "Valor", dataset, PlotOrientation.VERTICAL, true, true, false);

        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartPanel);
    }

    public static void main(String[] args) {

        GraficoBarra demo = new GraficoBarra("Exemplo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}

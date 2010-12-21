package ufrn.br.controle.neuralnetwork.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Rivaldo Jr
 */
public abstract class Graficos {

    String name;
    String xAxis;
    String yAxis;

    ChartPanel panel;
    XYSeries series[];

    boolean showSeries[] = null;

    XYSeriesCollection dataset = new XYSeriesCollection();

    XYItemRenderer renderer;
    BasicStroke pontilhado = new BasicStroke(
                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
                1.0f, new float[] {10.0f, 6.0f}, 0.0f
            );

    public ChartPanel getChart() {
        return panel;
    }

    public void initPanel(JFreeChart chart) {
        panel = new ChartPanel(chart);
        
        panel.setBackground(Color.WHITE);
//        chart.setBackgroundPaint(Color.WHITE);
    }

    public void atualizaShowSeries(boolean show[]) {
        if (showSeries == null || show == null) {
            return;
        }

        for (int i = 0; i < showSeries.length; i++) {
            if (showSeries[i] != show[i]) {
                showSeries[i] = show[i];
                if(showSeries[i]) {
                    dataset.addSeries(series[i]);
                } else {
                    dataset.removeSeries(series[i]);
                }
            }
        }
    }

    JFreeChart config() {

        for (int i = 0; i < series.length; i++) {
            if(showSeries[i]) {
                dataset.addSeries(series[i]);
            }
        }

        NumberAxis domain = new NumberAxis(xAxis);
        NumberAxis range = new NumberAxis(yAxis);

        domain.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        range.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));

        domain.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));
        range.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));

        renderer = new XYLineAndShapeRenderer(true, false);

        XYPlot plot = new XYPlot(dataset, domain, range, renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

        domain.setAutoRange(true);
        domain.setLowerMargin(0.0);
        domain.setUpperMargin(0.0);
        domain.setTickLabelsVisible(true);

        range.setStandardTickUnits(NumberAxis.createStandardTickUnits());

        JFreeChart chart = new JFreeChart(name, new Font("SansSerif", Font.BOLD, 24), plot, true);
        chart.setBackgroundPaint(Color.WHITE);

        return chart;
    }

    public void clear() {
        for (XYSeries serie : series) {
            serie.clear();
        }
    }

    public void addObservation(long time, double y, int tipo) {
        series[tipo].add(time, y);
    }

}

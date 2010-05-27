package r2d2e.solution.moduloteste.domain.graph;

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
public abstract class IGraphTime {

    String name;
    String xAxis;
    String yAxis;
    
    ChartPanel panel;
    XYSeries series[];

    XYSeriesCollection dataset = new XYSeriesCollection();

    public ChartPanel getChart() {
        return panel;
    }

    JFreeChart config() {

        for (XYSeries serie : series) {
            dataset.addSeries(serie);
        }

        NumberAxis domain = new NumberAxis(xAxis);
        NumberAxis range = new NumberAxis(yAxis);

        domain.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        range.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));

        domain.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));
        range.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));

        XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.blue);
        renderer.setSeriesPaint(2, Color.green);
        renderer.setSeriesPaint(3, Color.YELLOW);
        renderer.setSeriesPaint(4, Color.MAGENTA);
        renderer.setSeriesPaint(5, Color.CYAN);
        renderer.setSeriesPaint(6, Color.DARK_GRAY);
        renderer.setSeriesPaint(7, Color.ORANGE);

        renderer.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

        XYPlot plot = new XYPlot(dataset, domain, range, renderer);
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));

        domain.setAutoRange(true);
        domain.setLowerMargin(0.0);
        domain.setUpperMargin(0.0);
        domain.setTickLabelsVisible(true);

        range.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        JFreeChart chart = new JFreeChart(name, new Font("SansSerif", Font.BOLD, 24), plot, true);
        chart.setBackgroundPaint(null);

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

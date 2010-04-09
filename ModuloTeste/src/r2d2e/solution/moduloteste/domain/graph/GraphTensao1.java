package r2d2e.solution.moduloteste.domain.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Rivaldo
 */

public class GraphTensao1 extends JPanel {

    public static final int P = 0;
    public static final int I = 1;
    public static final int D = 2;
    public static final int D2 = 3;

    private TimeSeries p;
    private TimeSeries i;
    private TimeSeries d;
    private TimeSeries d2;

    private ChartPanel panel;

    public GraphTensao1(int maxAge) {

        p = new TimeSeries("P");
        p.setMaximumItemAge(maxAge);

        i = new TimeSeries("I");
        i.setMaximumItemAge(maxAge);

        d = new TimeSeries("D");
        d.setMaximumItemAge(maxAge);

        d2 = new TimeSeries("D2");
        d2.setMaximumItemAge(maxAge);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(p);
        dataset.addSeries(i);
        dataset.addSeries(d);
        dataset.addSeries(d2);

        DateAxis domain = new DateAxis("s");
        NumberAxis range = new NumberAxis("volts");
        domain.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        range.setTickLabelFont(new Font("SansSerif", Font.PLAIN, 12));
        domain.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));
        range.setLabelFont(new Font("SansSerif", Font.PLAIN, 14));
        domain.setMinimumDate(new Date(0, 0, 0, 0, 0, 0));

        XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.blue);
        renderer.setSeriesPaint(2, Color.green);
        renderer.setSeriesPaint(3, Color.YELLOW);
        renderer.setStroke(new BasicStroke(3f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL));

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

        JFreeChart chart = new JFreeChart("Sinal de controle", new Font("SansSerif", Font.BOLD, 24), plot, true);
        chart.setBackgroundPaint(Color.white);

        panel = new ChartPanel(chart);
        //panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.black)));
        panel.setPreferredSize(new Dimension(380, 208));
    }

    public ChartPanel getChart() {
        return panel;
    }

    public void clear() {
        p.clear();
        i.clear();
        d.clear();
        d2.clear();
    }

    public void addTensao(long time, double y, int tipo) {
        if(tipo == P) {
            p.add(new Millisecond(new Date(time)), y);
        }

        if(tipo == I){
            i.add(new Millisecond(new Date(time)), y);
        }

        if(tipo == D) {
            d.add(new Millisecond(new Date(time)), y);
        }

        if(tipo == D2) {
            d2.add(new Millisecond(new Date(time)), y);
        }
    }

    public void setRange(double min, double max) {
        XYPlot plot = (XYPlot) panel.getChart().getPlot();
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(min, max);
    }

}

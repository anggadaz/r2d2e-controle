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

public class GraphTensao2 extends JPanel {

    public static final int ATUAL = 0;
    public static final int TRAVA = 1;

    private TimeSeries atual;
    private TimeSeries trava;

    private ChartPanel panel;

    public GraphTensao2(int maxAge) {

        atual = new TimeSeries("Real");
        atual.setMaximumItemAge(maxAge);

        trava = new TimeSeries("Saturação");
        trava.setMaximumItemAge(maxAge);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(atual);
        dataset.addSeries(trava);

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

        JFreeChart chart = new JFreeChart("Ação do controle", new Font("SansSerif", Font.BOLD, 24), plot, true);
        chart.setBackgroundPaint(Color.white);

        panel = new ChartPanel(chart);
        //panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.black)));
        panel.setPreferredSize(new Dimension(380, 208));
    }

    public ChartPanel getChart() {
        return panel;
    }

    public void clear() {
        atual.clear();
        trava.clear();
    }

    public void addTensao(long time, double y, int tipo) {
        if(tipo == ATUAL) {
            atual.add(new Millisecond(new Date(time)), y);
        }

        if(tipo == TRAVA){
            trava.add(new Millisecond(new Date(time)), y);
        }
    }

    public void setRange(double min, double max) {
        XYPlot plot = (XYPlot) panel.getChart().getPlot();
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(min, max);
    }

}

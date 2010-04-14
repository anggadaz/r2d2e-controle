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

public class GraphNivel extends JPanel {

    public static final int SP = 0;
    public static final int NIVEL = 1;
    public static final int ERRO = 2;

    private TimeSeries sp;
    private TimeSeries erro;
    private TimeSeries nivel;

    private ChartPanel panel;

    public GraphNivel(int maxAge) {

        nivel = new TimeSeries("Nível");
        nivel.setMaximumItemAge(maxAge);

        sp = new TimeSeries("Setpoint");
        sp.setMaximumItemAge(maxAge);

        erro = new TimeSeries("Erro");
        erro.setMaximumItemAge(maxAge);

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(nivel);
        dataset.addSeries(sp);
        dataset.addSeries(erro);

        DateAxis domain = new DateAxis("s");
        NumberAxis range = new NumberAxis("cm");
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

        JFreeChart chart = new JFreeChart("Nível x Tempo", new Font("SansSerif", Font.BOLD, 24), plot, true);
        chart.setBackgroundPaint(Color.white);

        panel = new ChartPanel(chart);
        //panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4), BorderFactory.createLineBorder(Color.black)));
        panel.setPreferredSize(new Dimension(750, 200));
    }

    public ChartPanel getChart() {
        return panel;
    }

    public void clear() {
        nivel.clear();
        erro.clear();
        sp.clear();
    }

    public void addNivel(long time, double y, int tipo) {
        if(tipo == SP) {
            sp.add(new Millisecond(new Date(time)), y);
        }

        if(tipo == ERRO){
            erro.add(new Millisecond(new Date(time)), y);
        }

        if(tipo == NIVEL) {
            nivel.add(new Millisecond(new Date(time)), y);
        }
    }

    public void setRange(double min, double max) {
        XYPlot plot = (XYPlot) panel.getChart().getPlot();
        NumberAxis range = (NumberAxis) plot.getRangeAxis();
        range.setRange(min, max);
    }

}

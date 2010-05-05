package r2d2e.solution.moduloteste.domain.graph;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author Rivaldo
 */

public class GraphControl extends IGraphTime {

    public static final int P = 0;
    public static final int I = 1;
    public static final int D = 2;
    public static final int D2 = 3;

    public GraphControl(int maxAge) {

        xAxis = "Tempo (s)";
        yAxis = "Tensão (v)";
        name = "Sinal de controle";

        series = new XYSeries[4];

        series[P] = new XYSeries("P");
        series[I] = new XYSeries("I");
        series[D] = new XYSeries("D");
        series[D2] = new XYSeries("D2");

        JFreeChart chart = config();

        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addTensao(long time, double y, int tipo) {
        addObservation(time, y, tipo);
    }

}

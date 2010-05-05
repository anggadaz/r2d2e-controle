package r2d2e.solution.moduloteste.domain.graph;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author Rivaldo
 */

public class GraphNivel extends IGraphTime {

    public static final int SP = 0;
    public static final int NIVEL = 1;
    public static final int ERRO = 2;

    public GraphNivel(int maxAge) {

        xAxis = "Tempo (s)";
        yAxis = "Nível (cm)";
        name = "Nível x Tempo";

        series = new XYSeries[3];

        series[NIVEL] = new XYSeries("Nível");
        series[SP] = new XYSeries("Setpoint");
        series[ERRO] = new XYSeries("Erro");

        JFreeChart chart = config();

        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addNivel(long time, double y, int tipo) {
        addObservation(time, y, tipo);
    }
    
}

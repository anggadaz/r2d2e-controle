package r2d2e.solution.moduloteste.domain.graph;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author Rivaldo
 */

public class GraphAction extends IGraphTime {

    public static final int ATUAL = 0;
    public static final int TRAVA = 1;

    public GraphAction(int maxAge) {

        xAxis = "Tempo (s)";
        yAxis = "Tensão (v)";
        name = "Ação do controle";

        series = new XYSeries[2];

        series[ATUAL] = new XYSeries("Calculado");
        series[TRAVA] = new XYSeries("Saturação");
        
        JFreeChart chart = config();
        
        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addTensao(long time, double y, int tipo) {
        addObservation(time, y, tipo);
    }

}

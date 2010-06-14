package r2d2e.solution.moduloteste.domain.graph;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import r2d2e.solution.moduloteste.domain.ConfigGerais;

/**
 *
 * @author Rivaldo
 */

public class GraphAction extends IGraphTime {

    public static final int S_ATUAL = 0;
    public static final int S_TRAVA = 1;
    public static final int M_ATUAL = 2;
    public static final int M_TRAVA = 3;

    public GraphAction(int maxAge, int modo) {

        xAxis = "Tempo (s)";
        yAxis = "Tensão (v)";
        name = "Sinal de controle";

        String[] names = {"Calc-Escravo","Sat-Escravo","Calc-Mestre","Sat-Mestre"};

        if(modo == ConfigGerais.C_TANQUE_CASCATA) {
            series = new XYSeries[4];

            for (int i = 0; i < 4; i++) {
                series[i] = new XYSeries(names[i]);
            }

        } else {
            series = new XYSeries[2];

            series[S_ATUAL] = new XYSeries("Calculado");
            series[S_TRAVA] = new XYSeries("Saturação");
        }
              
        JFreeChart chart = config();

        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.blue);
        
        renderer.setSeriesStroke(2, pontilhado);
        renderer.setSeriesStroke(3, pontilhado);

        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addTensao(long time, double y, int tipo) {
        addObservation(time, y, tipo);
    }

}

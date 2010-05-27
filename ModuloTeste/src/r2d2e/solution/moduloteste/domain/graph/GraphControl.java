package r2d2e.solution.moduloteste.domain.graph;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import r2d2e.solution.moduloteste.domain.ConfigGerais;

/**
 *
 * @author Rivaldo
 */

public class GraphControl extends IGraphTime {

    public static final int S_P = 0;
    public static final int S_I = 1;
    public static final int S_D = 2;
    public static final int S_D2 = 3;
    public static final int M_P = 4;
    public static final int M_I = 5;
    public static final int M_D = 6;
    public static final int M_D2 = 7;

    public static final String[] names = {"P-Slave", "I-Slave", "D-Slave","D2-Slave","P-Master", "I-Master", "D-Master", "D2-Master"};

    public GraphControl(int maxAge, int modo) {

        xAxis = "Tempo (s)";
        yAxis = "Tensão (v)";
        name = "Sinal de controle";

        if(modo == ConfigGerais.C_TANQUE_CASCATA) {
            series = new XYSeries[8];

            for (int i = 0; i < 8; i++) {
                series[i] = new XYSeries(names[i]);
            }

        } else {
            series = new XYSeries[4];

            series[S_P] = new XYSeries("P");
            series[S_I] = new XYSeries("I");
            series[S_D] = new XYSeries("D");
            series[S_D2] = new XYSeries("D2");
        }


        JFreeChart chart = config();

        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addTensao(long time, double y, int tipo) {
        addObservation(time, y, tipo);
    }

}

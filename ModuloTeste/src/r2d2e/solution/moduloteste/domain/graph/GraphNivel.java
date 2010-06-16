package r2d2e.solution.moduloteste.domain.graph;

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

public class GraphNivel extends IGraphTime {

    public static final int S_SP = 0;
    public static final int S_NIVEL = 1;
    public static final int S_ERRO = 2;
    public static final int M_SP = 3;
    public static final int M_NIVEL = 4;
    public static final int M_ERRO = 5;

    public GraphNivel(int maxAge, int modo, boolean show[]) {

        showSeries = show;

        xAxis = "Tempo (s)";
        yAxis = "Nível (cm)";
        name = "Nível x Tempo";

        String[] names = {"Setpoint-T2","Nível-T2", "Erro-T2","Setpoint-T1", "Nível-T1", "Erro-T1"};

        if(modo == ConfigGerais.C_TANQUE_CASCATA) {
            series = new XYSeries[6];

            for (int i = 0; i < 6; i++) {
                series[i] = new XYSeries(names[i]);
            }

        } else {
            series = new XYSeries[3];

            series[S_SP] = new XYSeries("Setpoint");
            series[S_NIVEL] = new XYSeries("Nível");
            series[S_ERRO] = new XYSeries("Erro");
        }

        JFreeChart chart = config();

        renderer.setSeriesPaint(0, Color.red);
        renderer.setSeriesPaint(1, Color.red);
        renderer.setSeriesPaint(2, Color.yellow);
        renderer.setSeriesPaint(3, Color.cyan);
        renderer.setSeriesPaint(4, Color.cyan);
        renderer.setSeriesPaint(5, Color.blue);

        renderer.setSeriesStroke(3, pontilhado);
        renderer.setSeriesStroke(4, pontilhado);
        renderer.setSeriesStroke(5, pontilhado);

        panel = new ChartPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addNivel(long time, double y, int tipo) {
        addObservation(time, y, tipo);
    }
    
}

package ufrn.br.controle.neuralnetwork.view;

import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author allan
 */
public class GraficoErroQuadratico extends Graficos {

    public GraficoErroQuadratico() {
        showSeries = new boolean[2];
        showSeries[0] = true;
        showSeries[1] = true;

        xAxis = "Tempo";
        yAxis = "Erro";
        name = "Erro Quadratico Medio";

        series = new XYSeries[2];


        series[0] = new XYSeries("Erro Quadratico Médio");
        series[1] = new XYSeries("Erro Quadratico");


        JFreeChart chart = config();

        renderer.setSeriesPaint(0, Color.red);
        
        initPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addObservation(long time, double y) {
        super.addObservation(time, y, 0);
    }
}

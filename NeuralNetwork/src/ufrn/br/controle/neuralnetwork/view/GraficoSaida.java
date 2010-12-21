/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.view;

import java.awt.Dimension;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;

/**
 *
 * @author allan
 */
public class GraficoSaida extends Graficos {

    public GraficoSaida(int qtSeries) {

        showSeries = new boolean[qtSeries * 2];

        xAxis = "Tempo";
        yAxis = "Saida";
        name = "Saida";

        series = new XYSeries[qtSeries * 2];
        for (int i = 0; i < qtSeries * 2 - 1; i++) {
            series[i] = new XYSeries("Saida " + i / 2 + 1);
            series[i + 1] = new XYSeries("Esperado " + i / 2 + 1);
            showSeries[i] = true;
            showSeries[i + 1] = true;
        }

        JFreeChart chart = config();

//        renderer.setSeriesPaint(0, Color.red);
//        renderer.setSeriesPaint(1, Color.blue);
//        renderer.setSeriesPaint(2, Color.green);

        initPanel(chart);
        panel.setPreferredSize(new Dimension(570, 410));
    }

    public void addObservation(long time, double y, int tipo, boolean ehEsperado) {
        if (ehEsperado) {
            super.addObservation(time, y, tipo*2+1);
        } else {
            super.addObservation(time, y, tipo*2);
        }
    }
}

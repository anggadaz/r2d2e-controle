/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.handler;

import java.util.ArrayList;
import org.jfree.data.category.DefaultCategoryDataset;
import ufrn.br.controle.neuralnetwork.view.GlobalErrorChart;

/**
 *
 * @author demetrios
 */
public class GlobalErrorChartHandler {

    private DefaultCategoryDataset dataset;

    public void addValue(double value) {
        dataset.addValue(value, GlobalErrorChart.EIXO_Y, GlobalErrorChart.EIXO_X);
    }

    public DefaultCategoryDataset getDataset() {
        return dataset;
    }

    public void setDataset(DefaultCategoryDataset dataset) {
        this.dataset = dataset;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.handler;

import java.util.HashMap;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Demetrios
 */
public class GraphHandler {

    private XYSeriesCollection seriesCollection = new XYSeriesCollection();
    private HashMap<String, XYSeries> mapSeries;
    private long initTime;

    public GraphHandler() {
        mapSeries = new HashMap<String, XYSeries>();
    }

    public XYSeriesCollection getSeriesCollection() {
        return seriesCollection;
    }

    public void init() {
        initTime = System.currentTimeMillis();
    }

    public void addValue(String tipo, double value) {
        XYSeries serie = mapSeries.get(tipo);
        if (serie == null) {
            serie = new XYSeries(tipo);
            seriesCollection.addSeries(serie);

            mapSeries.put(tipo, serie);
        }

        double diffTime = System.currentTimeMillis() - initTime;

        serie.add(diffTime / 1000, value);
    }

    public void removeSerie(String tipo) {
        XYSeries serie = mapSeries.remove(tipo);

        if (serie == null) {
            return;
        }
        
        seriesCollection.removeSeries(serie);
    }
}

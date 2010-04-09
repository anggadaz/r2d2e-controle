/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author edsonjack
 */
/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2004, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation;
 * either version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with this
 * library; if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA 02111-1307, USA.
 *
 * [Java is a trademark or registered trademark of Sun Microsystems, Inc.
 * in the United States and other countries.]
 *
 * ------------------------
 * CombinedXYPlotDemo1.java
 * ------------------------
 * (C) Copyright 2003, 2004, by Object Refinery Limited.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited).
 * Contributor(s):   -;
 *
 * $Id $
 *
 * Changes
 * -------
 * 13-Jan-2003 : Version 1 (DG);
 *
 */


package r2d2e.solution.moduloteste.teste;

import java.awt.Font;

import java.awt.event.ActionEvent;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 * A demonstration application showing how to create a vertical combined chart.
 *
 */
public class GraficoD2 extends ApplicationFrame {

    final XYSeries series1 = new XYSeries("Set-Point;");
    final XYSeries series2 = new XYSeries("Nivel T1;");
    final XYSeries series3 = new XYSeries("Erro;");
    final XYSeries series4 = new XYSeries("Ação P;");
    final XYSeries series5 = new XYSeries("Ação I;");
    final XYSeries series6 = new XYSeries("Ação D;");
    final XYSeries series7 = new XYSeries("Ação D2;");
    final XYSeries series8 = new XYSeries("Tensão Saturada");

    final XYSeriesCollection collection = new XYSeriesCollection();
    final XYSeriesCollection collection2 = new XYSeriesCollection();
    final XYSeriesCollection collection3 = new XYSeriesCollection();



    /**
     * Constructs a new demonstration application.
     *
     * @param title  the frame title.
     */
    public GraficoD2(final String title) {


        super(title);

        collection.addSeries(series1);
        collection.addSeries(series2);
        collection.addSeries(series3);

        collection2.addSeries(series4);
        collection2.addSeries(series5);
        collection2.addSeries(series6);
        collection2.addSeries(series7);

        collection3.addSeries(series8);

        final JFreeChart chart = createCombinedChart();
        final ChartPanel panel = new ChartPanel(chart, true, true, true, false, true);
        panel.setPreferredSize(new java.awt.Dimension(600, 600));
        setContentPane(panel);

    }

    /**
     * Creates a combined chart.
     *
     * @return the combined chart.
     */
    private JFreeChart createCombinedChart() {

        // create subplot 1...
        final XYDataset data1 = collection;
        final XYItemRenderer renderer1 = new StandardXYItemRenderer();
        final NumberAxis rangeAxis1 = new NumberAxis("Nível (cm)");
        final XYPlot subplot1 = new XYPlot(data1, null, rangeAxis1, renderer1);
        subplot1.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);

        /*
        final XYTextAnnotation annotation = new XYTextAnnotation("Hello!", 50.0, 10000.0);
        annotation.setFont(new Font("SansSerif", Font.PLAIN, 9));
        annotation.setRotationAngle(Math.PI / 4.0);
        subplot1.addAnnotation(annotation);
*/
        
        // create subplot 2...
        final XYDataset data2 = collection2;
        final XYItemRenderer renderer2 = new StandardXYItemRenderer();
        final NumberAxis rangeAxis2 = new NumberAxis("Tensão (volts)");
        final XYPlot subplot2 = new XYPlot(data2, null, rangeAxis2, renderer2);
        subplot2.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);

        // create subplot 3...
        final XYDataset data3 = collection3;
        final XYItemRenderer renderer3 = new StandardXYItemRenderer();
        final NumberAxis rangeAxis3 = new NumberAxis("Tensão (volts)");
        final XYPlot subplot3 = new XYPlot(data3, null, rangeAxis3, renderer3);
        subplot3.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);

        // parent plot...
        final CombinedDomainXYPlot plot = new CombinedDomainXYPlot(new NumberAxis("Tempo"));
        plot.setGap(10.0);

        // add the subplots...
        plot.add(subplot1, 1);
        plot.add(subplot2, 1);
        plot.add(subplot3, 1);
        plot.setOrientation(PlotOrientation.VERTICAL);

        // return a new chart containing the overlaid plot...
        return new JFreeChart("Gráficos",
                              JFreeChart.DEFAULT_TITLE_FONT, plot, true);

    }
      
     public void adicionarValores(double tempo, double setPoint, double nivelT1, double sinalP, double sinalI, double sinalD, double sinalD2, double erro, double pid) {
         series1.add(tempo,setPoint);
         series2.add(tempo, nivelT1);
         series3.add(tempo, erro);
         series4.add(tempo, sinalP);
         series5.add(tempo, sinalI);
         series6.add(tempo, sinalD);
         series7.add(tempo, sinalD2);
         series8.add(tempo, pid);

     }

     public void actionPerformed(final ActionEvent e) {

    }

    // ****************************************************************************
    // * JFREECHART DEVELOPER GUIDE                                               *
    // * The JFreeChart Developer Guide, written by David Gilbert, is available   *
    // * to purchase from Object Refinery Limited:                                *
    // *                                                                          *
    // * http://www.object-refinery.com/jfreechart/guide.html                     *
    // *                                                                          *
    // * Sales are used to provide funding for the JFreeChart project - please    *
    // * support us so that we can continue developing free software.             *
    // ****************************************************************************

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {

        final GraficoD2 demo = new GraficoD2("Gráficos");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

}


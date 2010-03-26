
package r2d2e.solution.moduloteste.domain;

import r2d2e.solution.moduloteste.domain.graph.HistoChart;
import r2d2e.solution.moduloteste.domain.graph.BarChart;
import r2d2e.solution.moduloteste.handler.MainFrameHandler;
import r2d2e.solution.moduloteste.view.TanquePanel;
import javax.swing.Timer;

/**
 *
 * @author demetrios
 */

public class controlerInterface {

    public static TanquePanel tanquePanel;
    public static MainFrameHandler mainFrameHandler;

    public static BarChart barChart;
    public static HistoChart histoChart;

    public static boolean isDrying = false;
    public static boolean end = false;
    public static Double NIVEL_LOW_CALIBRATION;

    public static void tanquePanelUpdate(double nivel) {
        tanquePanel.setLevelWater(nivel);
    }

    public static void tanquePanelDry(final Quanser quanser) {
        isDrying = true;
        new Thread() {

            @Override
            public void run() {
                Timer t = new Timer(100, null);
                DryTank dryTank = new DryTank(quanser, tanquePanel,t);
                t.addActionListener(dryTank);
                t.start();
            }
        }.start();
    }

    public static void clearCharts() {
        barChart.clear();
        histoChart.clear();
    }

    public static void updateTable(double tensao, double tempo, double nivel) {
        mainFrameHandler.updateTable(tensao, tempo, nivel);
    }

    static void verifyTestEnd() {
        mainFrameHandler.verifyTestEnd();
    }
    static void ciclyEnable(){
        mainFrameHandler.ciclyEnable();
    }

    static void updateBarChart() {
        mainFrameHandler.updateBarChart();
    }
}

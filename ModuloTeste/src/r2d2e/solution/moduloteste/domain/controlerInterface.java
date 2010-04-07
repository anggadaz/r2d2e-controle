
package r2d2e.solution.moduloteste.domain;

import javax.swing.Timer;
import r2d2e.solution.moduloteste.handler.TestModeHandler;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author demetrios
 */

public class controlerInterface {

    public static TanquePanel tanquePanel;
    public static TestModeHandler testModeHandler;

    public static boolean isDrying = false;
    public static boolean end = false;
    public static Double NIVEL_LOW_CALIBRATION;

    public static void tanquePanelUpdate(double nivel) {
        tanquePanel.setLevelWater2(nivel);
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

    public static void updateTable(double tensao, double tempo, double nivel) {
        testModeHandler.updateTable(tensao, tempo, nivel);
    }

    static void verifyTestEnd() {
        testModeHandler.verifyTestEnd();
    }
    static void ciclyEnable(){
        testModeHandler.ciclyEnable();
    }

}


package r2d2e.solution.moduloteste.domain;

import java.text.DecimalFormat;
import javax.swing.Timer;
import r2d2e.solution.moduloteste.handler.TestModeHandler;
import r2d2e.solution.moduloteste.view.DataPanel;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author demetrios
 */

public class controlerInterface {

    public static TanquePanel tanquePanel;
    public static TestModeHandler testModeHandler;
    public static DataPanel dataPanel;

    public static boolean isDrying = false;
    public static boolean end = false;
    public static Double NIVEL_LOW_CALIBRATION;
    public static Double SETPOINT_ANTERIOR = 0.0;
    public static Double SETPOINT = 15.0;

    public static void tanquePanelUpdate(double nivel) {
        tanquePanel.setLevelWater1(nivel);
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

    public static void setDataPanel(DataPanel dataPanel) {
        controlerInterface.dataPanel = dataPanel;
}

    public static void atualizarOverShoot(Double over) {
        if(over != null) {
            DecimalFormat decimal = new DecimalFormat("0.00");
            String valorFormatado = decimal.format(over);
            dataPanel.getTfOvershoot().setText(valorFormatado);
        }
    }

    public static void atualizarRiseTime(Double rise){
        if(rise != null) {
            DecimalFormat decimal = new DecimalFormat("0.00");
            String valorFormatado = decimal.format(rise);
            dataPanel.getTfRise().setText(valorFormatado);
        }
    }

    public static void atualizaAcomodationTime(Double acom) {
        if(acom != null) {
            DecimalFormat decimal = new DecimalFormat("0.00");
            String valorFormatado = decimal.format(acom);
            dataPanel.getTfAcomodation().setText(valorFormatado);
        }
    }

    public static void atualizarPeakTime(double peak){
            DecimalFormat decimal = new DecimalFormat("0.00");
            String valorFormatado = decimal.format(peak);
            dataPanel.getTfPeak().setText(valorFormatado);
    }
}

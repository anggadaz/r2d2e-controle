/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author demetrios
 */
public class controlerInterface {

    public static TanquePanel tanquePanel;

    public static void tanquePanelUpdate(double nivel) {
        tanquePanel.setLevelWater(nivel);
    }

    static void tanquePanelDry(final Quanser quanser) {
        new Thread() {

            public void run() {
                System.out.println("SECANDO");
                while (true) {
                    double nivel = quanser.readSensor1();
                    System.out.println("nivel " + nivel);
                    tanquePanel.setLevelWater(nivel);
                    if (nivel <= 0) {
                        System.out.println("MORREU");
                        break;
                    }
                }
            }
        }.start();
    }
}

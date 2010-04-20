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
public class UpdateWater extends Thread {

    public static double NIVEL1 = 0.0;
    public static double NIVEL2 = 0.0;
    
    private TanquePanel tanquePanel;

    public UpdateWater(TanquePanel tanquePanel) {
        this.tanquePanel = tanquePanel;
    }

    @Override
    public void run() {
        tanquePanel.setLevelWater1(NIVEL1);
        tanquePanel.setLevelWater2(NIVEL2);
    }
}

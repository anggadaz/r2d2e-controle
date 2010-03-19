/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import r2d2e.solution.moduloteste.handler.MainFrameHandler;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author demetrios
 */
public class DryTank implements ActionListener {

    private Quanser quanser;
    private TanquePanel tanquePanel;
    private Timer time;

    public DryTank(Quanser quanser, TanquePanel tanquePanel, Timer time) {
        this.quanser = quanser;
        this.tanquePanel = tanquePanel;
        this.time = time;
    }

    public void actionPerformed(ActionEvent e) {
        double nivel = quanser.readSensor1();
        tanquePanel.setLevelWater(nivel);
        if (nivel <= controlerInterface.NIVEL_LOW_CALIBRATION) {
            tanquePanel.setLevelWater(0);
            stop();
        }
    }

    public void stop() {
        controlerInterface.isDrying = false;
        time.stop();
        
        if (!controlerInterface.end) {
            controlerInterface.ciclyEnable();
        }
    }
}

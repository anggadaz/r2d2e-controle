/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author demetrios
 */
public class UpdateWater extends Timer implements ActionListener {

    private TanquePanel tanquePanel;
    private Quanser quanser;

    public UpdateWater(int delay, TanquePanel tanquePanel, Quanser quanser) {
        super(delay, null);
        addActionListener(this);

        this.tanquePanel = tanquePanel;
        this.quanser = quanser;
    }

    public void actionPerformed(ActionEvent e) {
        double nivel1 = quanser.readSensor1();
        double nivel2 = quanser.readSensor2();

        tanquePanel.setLevelWater1(nivel1);
        tanquePanel.setLevelWater2(nivel2);

    }
}

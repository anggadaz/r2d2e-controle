/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.Timer;
import r2d2e.solution.tanksimulator.view.TankPanel;
import r2d2e.solution.tanksimulator.tank.Tanks3DContainer;

/**
 *
 * @author demetrios
 */
public class Simulation3d extends Simulation {

    private Tanks3DContainer tanks;

    public Simulation3d(int delay, Tanks3DContainer tanks) {
        super(delay, null, null);
        addActionListener(this);

        this.tanks = tanks;

        plantModel = new PlantModel();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (ativo) {
            double level2 = plantModel.getNivelAtualTank2();
            double level1 = plantModel.getNivelAtualTank1();
            tanks.setColuna01(level1);
            tanks.setColuna02(level2);

            verificarTransbordamento(level1, level2);

            DecimalFormat df = new DecimalFormat("#.##");

            UpdateStatus.setInfo(UpdateStatus.SENSOR1, df.format(level1));
            UpdateStatus.setInfo(UpdateStatus.SENSOR2, df.format(level2));
        }
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import r2d2e.solution.tanksimulator.view.MainView;
import r2d2e.solution.tanksimulator.view.TankPanel;

/**
 *
 * @author demetrios
 */
public class Simulation extends Timer implements ActionListener {

    protected PlantModel plantModel;
    private TankPanel tank1;
    private TankPanel tank2;
    protected boolean ativo = true;

    public Simulation(int delay, TankPanel tank1, TankPanel tank2) {
        super(delay, null);
        addActionListener(this);

        this.tank1 = tank1;
        this.tank2 = tank2;

        plantModel = new PlantModel();
    }

    public void actionPerformed(ActionEvent e) {
        if (ativo) {
            double level2 = plantModel.getNivelAtualTank2();
            double level1 = plantModel.getNivelAtualTank1();
            tank1.setLevelWater(level1);
            tank2.setLevelWater(level2);
            verificarTransbordamento(level1, level2);
        }
    }

    protected void verificarTransbordamento(double level1, double level2) {
        if (level1 >= 30) {
            atualizarStatus(1);
            return;
        }
        if (level2 >= 30) {
            atualizarStatus(2);
            return;
        }
        if (!MainView.isStopped()) {
            UpdateStatus.updateSatus(UpdateStatus.GREEN_STATUS, "Simulação rodando");
        }

    }

    private void atualizarStatus(int tank) {
        if (tank == 1) {
            Logger.println("TANQUE 1 TRANSBORDANDO!!!");
            UpdateStatus.updateSatus(UpdateStatus.RED_STATUS, "TANQUE 1 TRANSBORDANDO!!!");
        } else {
            Logger.println("TANQUE 2 TRANSBORDANDO!!!");
            UpdateStatus.updateSatus(UpdateStatus.RED_STATUS, "TANQUE 2 TRANSBORDANDO!!!");
        }
    }

    public double getWaterLevel1() {
        return plantModel.getNivel1();
    }

    public double getWaterLevel2() {
        return plantModel.getNivel2();
    }

    public void setTensao(double tensao) {
        UpdateStatus.setInfo(UpdateStatus.TENSAO, Double.toString(tensao));
        plantModel.setTensao(tensao);
    }

    public boolean isAllowFlowOut1() {
        return plantModel.isAllowFlowOut1();
    }

    public void setAllowFlowOut1(boolean allowFlowOut1) {
        plantModel.setAllowFlowOut1(allowFlowOut1);
    }

    public boolean isAllowFlowOut2() {
        return plantModel.isAllowFlowOut2();
    }

    public void setAllowFlowOut2(boolean allowFlowOut2) {
        plantModel.setAllowFlowOut2(allowFlowOut2);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.handler;

import java.net.URL;
import javax.swing.ImageIcon;
import r2d2e.solution.tanksimulator.view.EditConf;
import r2d2e.solution.tanksimulator.view.MainView;

/**
 *
 * @author demetrios
 */
public class MainViewHandler {

    private MainView mainView;

    public MainViewHandler(MainView mainView) {
        this.mainView = mainView;
    }

    public void editConfig() {
        EditConf conf = new EditConf(mainView, true);
        conf.setVisible(true);
    }

    public void turnOff() {
        mainView.stop();
    }

    public void pause() {
        mainView.getSimulation().pause(true);
        mainView.getButtonPause().setEnabled(false);
        mainView.getButtonStart().setEnabled(true);
        mainView.getButtonStop().setEnabled(false);
    }

    public void flow1() {
        boolean vazando = mainView.getSimulation().isAllowFlowOut1();
        mainView.getSimulation().setAllowFlowOut1(!vazando);
        URL imgURL = null;
        if (!vazando) {
            imgURL = mainView.getClass().getResource("/r2d2e/solution/tanksimulator/view/resource/tank_one_open.png");
            mainView.getButtonFlow1().setToolTipText("Clique aqui para bloquear a vazão de saída do tanque 1");
        } else {
            imgURL = mainView.getClass().getResource("/r2d2e/solution/tanksimulator/view/resource/tank_one_close.png");
            mainView.getButtonFlow1().setToolTipText("Clique aqui para permitir a vazão de saída do tanque 1");
        }
        mainView.getButtonFlow1().setIcon(new ImageIcon(imgURL));
    }

    public void flow2() {
        boolean vazando = mainView.getSimulation().isAllowFlowOut2();
        mainView.getSimulation().setAllowFlowOut2(!vazando);
        URL imgURL = null;
        if (!vazando) {
            imgURL = mainView.getClass().getResource("/r2d2e/solution/tanksimulator/view/resource/tank_two_open.png");
            mainView.getButtonFlow2().setToolTipText("Clique aqui para bloquear a vazão de saída do tanque 2");
        } else {
            imgURL = mainView.getClass().getResource("/r2d2e/solution/tanksimulator/view/resource/tank_two_close.png");
            mainView.getButtonFlow2().setToolTipText("Clique aqui para permitir a vazão de saída do tanque 2");
        }
        mainView.getButtonFlow2().setIcon(new ImageIcon(imgURL));
    }
}

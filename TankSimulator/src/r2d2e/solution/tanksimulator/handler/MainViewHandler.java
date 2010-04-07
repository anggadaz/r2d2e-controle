/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.handler;

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
}

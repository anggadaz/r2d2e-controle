/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.view.ConfControle;

/**
 *
 * @author controle
 */
public class ControlModeHandler {

    private ConfControle confControle;
    private Controller controllerSelected;

    public ControlModeHandler(ConfControle confControle) {
        this.confControle = confControle;
    }

    public Controller getControllerSelected() {
        return controllerSelected;
    }

    public void setControllerSelected(Controller controllerSelected) {
        this.controllerSelected = controllerSelected;
    }
}

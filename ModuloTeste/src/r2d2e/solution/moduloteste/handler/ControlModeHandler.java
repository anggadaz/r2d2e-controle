/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.controlers.PController;
import r2d2e.solution.moduloteste.controlers.PDController;
import r2d2e.solution.moduloteste.controlers.PIController;
import r2d2e.solution.moduloteste.controlers.PID2Controller;
import r2d2e.solution.moduloteste.controlers.PIDController;
import r2d2e.solution.moduloteste.domain.AlgController;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.view.ConfControle;

/**
 *
 * @author controle
 */
public class ControlModeHandler {

    private ConfControle confControle;
    private Controller controllerSelected;
    private AlgController algController;

    public ControlModeHandler(ConfControle confControle) {
        this.confControle = confControle;
    }

    public Controller getControllerSelected() {
        return controllerSelected;
    }

    public void setControllerSelected(Controller controllerSelected) {
        this.controllerSelected = controllerSelected;
    }

    public void updateVariables() {
        if (controllerSelected instanceof PController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PController) controllerSelected).setKp(Double.parseDouble(kp));
        }
        if (controllerSelected instanceof PDController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String kd = confControle.getTextKD().getText();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            kd = fixNumber(kd);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PDController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PDController) controllerSelected).setKd(Double.parseDouble(kd));
        }
        if (controllerSelected instanceof PIController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String ki = confControle.getTextKI().getText();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PIController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PIController) controllerSelected).setKi(Double.parseDouble(ki));
        }
        if (controllerSelected instanceof PIDController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String ki = confControle.getTextKI().getText();
            String kd = confControle.getTextKD().getText();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);
            kd = fixNumber(kd);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PIDController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PIDController) controllerSelected).setKi(Double.parseDouble(ki));
            ((PIDController) controllerSelected).setKd(Double.parseDouble(kd));
        }
        if (controllerSelected instanceof PID2Controller) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String ki = confControle.getTextKI().getText();
            String kd2 = confControle.getTextKD().getText();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);
            kd2 = fixNumber(kd2);
            
            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PID2Controller) controllerSelected).setKp(Double.parseDouble(kp));
            ((PID2Controller) controllerSelected).setKi(Double.parseDouble(ki));
            ((PID2Controller) controllerSelected).setKd2(Double.parseDouble(kd2));
        }
    }

    public void init(Quanser quanser) {
        algController = new AlgController(100, controllerSelected,quanser);
        algController.start();
    }

    private String fixNumber(String numb){
        return numb.replace(",", ".");
    }

    public void stop(Quanser quanser){
        algController.stop();
        quanser.stopMotor();
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

import r2d2e.solution.moduloteste.handler.ControlModeHandler;
import r2d2e.solution.moduloteste.handler.SUtil;
import r2d2e.solution.moduloteste.view.ConfParametros;

/**
 *
 * @author demetrios
 */
public class PDController extends Controller {

    private double kp = 0.0;
    private double kd = 0.0;

    public PDController(Double sampleRate, Double setPoint) {
        super(sampleRate, setPoint);
    }

    @Override
    public double calculateOutput(double processVariable) {
        return proporcionalTerm(kp, processVariable) + derivativeTerm(kd, processVariable);
    }

    public double getKp() {
        return kp;
    }

    public void setKp(double kp) {
        this.kp = kp;
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    @Override
    public String toString() {
        return "PD";
    }

    @Override
    public void updateParametros(ConfParametros parametros) {

        Double nivelNumb = SUtil.getSetPoint(parametros);

        String kp = parametros.getTextKP().getText();
        String kd = SUtil.getKdValue(parametros);
        kp = SUtil.fixNumber(kp);
        kd = SUtil.fixNumber(kd);
        setSetPoint(nivelNumb);
        setKp(Double.parseDouble(kp));
        setKd(Double.parseDouble(kd));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

import r2d2e.solution.moduloteste.handler.SUtil;
import r2d2e.solution.moduloteste.view.ConfParametros;

/**
 *
 * @author demetrios
 */
public class PIController extends Controller {

    private double kp = 0.0;
    private double ki = 0.0;

    public PIController(Double sampleRate, Double setPoint) {
        super(sampleRate, setPoint);
    }

    @Override
    public double calculateOutput(double processVariable) {
        double k = proporcionalTerm(kp, processVariable);
        double i = integralTerm(ki, processVariable);
        double s = k + i;

        s = IntegralTest(s, k, i, 0);

        return s;
    }

    public double getKp() {
        return kp;
    }

    public void setKp(double kp) {
        this.kp = kp;
    }

    public double getKi() {
        return ki;
    }

    public void setKi(double ki) {
        this.ki = ki;
    }

    @Override
    public String toString() {
        return "PI";
    }

    @Override
    public void updateParametros(ConfParametros parametros) {

        Double nivelNumb = SUtil.getSetPoint(parametros);

        String kp = parametros.getTextKP().getText();
        String ki = SUtil.getKIValue(parametros);
        kp = SUtil.fixNumber(kp);
        ki = SUtil.fixNumber(ki);
        setSetPoint(nivelNumb);
        setKp(Double.parseDouble(kp));
        setKi(Double.parseDouble(ki));
    }
}

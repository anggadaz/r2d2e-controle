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
public class PIDController extends Controller {

    private double kp = 0.0;
    private double ki = 0.0;
    private double kd = 0.0;

    public PIDController(Double sampleRate, Double setPoint) {
        super(sampleRate, setPoint);
    }

    @Override
    public double calculateOutput(double processVariable) {
        double k = proporcionalTerm(kp, processVariable);
        double i = integralTerm(ki, processVariable);
        double d = derivativeTerm(kd, processVariable);
        
        double s = k + i + d;
        s = IntegralTest(s, k, i, d);

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

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    @Override
    public String toString() {
        return "PID";
    }

    @Override
    public void updateParametros(ConfParametros parametros) {

        Double nivelNumb = SUtil.getSetPoint(parametros);

        String kp = parametros.getTextKP().getText();
        String ki = SUtil.getKIValue(parametros);
        String kd = SUtil.getKdValue(parametros);
        kp = SUtil.fixNumber(kp);
        ki = SUtil.fixNumber(ki);
        kd = SUtil.fixNumber(kd);
        setSetPoint(nivelNumb);
        setKp(Double.parseDouble(kp));
        setKi(Double.parseDouble(ki));
        setKd(Double.parseDouble(kd));
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

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
}

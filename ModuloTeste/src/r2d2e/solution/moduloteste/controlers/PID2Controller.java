/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

/**
 *
 * @author demetrios
 */
public class PID2Controller extends Controller {

    private double kp = 0.0;
    private double ki = 0.0;
    private double kd2 = 0.0;

    public PID2Controller(Double sampleRate, Double setPoint) {
        super(sampleRate, setPoint);
    }

    @Override
    public double calculateOutput(double processVariable) {
        return proporcionalTerm(kp, processVariable) + integralTerm(ki, processVariable) + derivativeOutputTerm(kd2, processVariable);
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

    public double getKd2() {
        return kd2;
    }

    public void setKd2(double kd2) {
        this.kd2 = kd2;
    }

    @Override
    public String toString() {
        return "PID2";
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

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
}

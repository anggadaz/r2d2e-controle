/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

/**
 *
 * @author demetrios
 */
public class PController extends Controller {

    private double kp = 0.0;

    public PController(Double sampleRate, Double setPoint) {
        super(sampleRate, setPoint);
    }

    @Override
    public double calculateOutput(double processVariable) {
        return proporcionalTerm(kp, processVariable);
    }

    public double getKp() {
        return kp;
    }

    public void setKp(double kp) {
        this.kp = kp;
    }
}

package r2d2e.solution.moduloteste.controlers;

import r2d2e.solution.moduloteste.handler.ControlModeHandler;
import r2d2e.solution.moduloteste.handler.SUtil;
import r2d2e.solution.moduloteste.view.ConfParametros;

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

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public void updateParametros(ConfParametros parametros) {

        Double nivelNumb = SUtil.getSetPoint(parametros);

        String kp = parametros.getTextKP().getText();
        kp = SUtil.fixNumber(kp);
        setSetPoint(nivelNumb);
        setKp(Double.parseDouble(kp));
    }

}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

import r2d2e.solution.moduloteste.domain.MatrixOperation;
import r2d2e.solution.moduloteste.view.ConfParametros;
import r2d2e.solution.moduloteste.view.ConfSeguidor;

/**
 *
 * @author demetrios
 */
public class FollowerReference extends Controller {

    private double v;
    private double[] gains;

    public FollowerReference() {
        gains = new double[3];
    }

    public double calculateOutput(double processVariable1, double processVariable2) {
        System.out.println("erro  " + error(processVariable2));
        System.out.println("v " + v);

        double e = (-gains[0] * processVariable1 - gains[1] * processVariable2);
        double t = gains[2] * v;

        System.out.println("VARIAVEIS " + e);
        System.out.println("ERRO " + t);

        double ret = e + t;

        v += error(processVariable2);

        return ret;
    }

    @Override
    public void updateParametros(ConfParametros parametros) {
    }

    public void updateParametros(ConfSeguidor parametros) {
        setPoint = parametros.getSetPoint();
        gains = parametros.getGains();
    }

    @Override
    public double calculateOutput(double processVariable) {
        return 0;
    }
}

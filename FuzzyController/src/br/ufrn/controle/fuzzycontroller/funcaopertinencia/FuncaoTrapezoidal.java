package br.ufrn.controle.fuzzycontroller.funcaopertinencia;

import br.ufrn.controle.fuzzycontroller.domain.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.view.FuncaoPertinenciaPanel;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class FuncaoTrapezoidal extends FuncPertinence {

    public FuncaoTrapezoidal(String n, ArrayList<Point> pVertex, FuncaoPertinenciaPanel panel) {
        super(n,pVertex, panel);
    }

    @Override
    public double getRangeValue(double x) {
        int px1, px2, py1, py2;
        //Fora da funcao
        if (x < getMinX() || x > getMaxX()) {
            return 0;
        } else if (x >= xpoints[0] && x <= xpoints[1]) {
            px1 = xpoints[0];
            px2 = xpoints[1];
//            py1 = ypoints[0];
//            py2 = ypoints[1];
            py1 = 0;
            py2 = 1;

        } else if (x >= xpoints[1] && x <= xpoints[2]) {
            px1 = xpoints[1];
            px2 = xpoints[2];
//            py1 = ypoints[1];
//            py2 = ypoints[2];
            py1 = 1;
            py2 = 1;
        } else {
            px1 = xpoints[2];
            px2 = xpoints[3];
//            py1 = ypoints[1];
//            py2 = ypoints[2];
            py1 = 1;
            py2 = 0;
        }

        return ((double) (py2 - py1) / (double)(px2 - px1)) * (x - px1) + py1;
    }
}

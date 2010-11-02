package br.ufrn.controle.fuzzycontroller.funcaopertinencia;

import java.awt.Point;

/**
 *
 * @author Allan
 */
public class FuncaoTrapezoidal extends FuncaoPertinencia {

    public FuncaoTrapezoidal(Point p1, Point p2, Point p3, Point p4) {
        super(p1, p2, p3, p4);
    }

    public FuncaoTrapezoidal(int x1, int x2, int x3, int x4, int top, int bottom) {
        this(new Point(x1, bottom), new Point(x2, top),new Point(x3, top), new Point(x4, bottom));
    }

    @Override
    public double avaliate(int x) {
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

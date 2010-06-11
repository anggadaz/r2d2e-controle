/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.teste;

import java.util.ArrayList;
import org.jscience.mathematics.number.Complex;
import r2d2e.solution.moduloteste.domain.MatrixOperation;

/**
 *
 * @author demetrios
 */
public class teste1 {

    public teste1() {
        MatrixOperation m = new MatrixOperation();
        ArrayList<Complex> polos = new ArrayList<Complex>();
        polos.add(Complex.valueOf(0.9048, 0));
        polos.add(Complex.valueOf(0.9920, 0));
        polos.add(Complex.valueOf(0.9980, 0));
        double[] s = m.gains(polos);
        System.out.println("ganhos reais " + s[0] + " " + s[1] + " " + s[2]);
    }

    public static void main(String args[]) {
        teste1 d = new teste1();
    }
}

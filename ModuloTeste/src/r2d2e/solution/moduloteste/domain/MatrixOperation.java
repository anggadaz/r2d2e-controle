/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.util.ArrayList;
import org.jscience.mathematics.number.Complex;
import org.jscience.mathematics.vector.ComplexMatrix;

/**
 *
 * @author demetrios
 */
public class MatrixOperation {

    private ComplexMatrix matrixG;
    private ComplexMatrix matrixH;
    private ComplexMatrix matrixC;
    private ComplexMatrix matrixGIncreased;
    private ComplexMatrix matrixHIncreased;
    private ComplexMatrix matrixWc;
    private ComplexMatrix matrixLast;

    public MatrixOperation() {
        Complex[][] gTemp = {
            {Complex.valueOf(.9935, 0), Complex.valueOf(0, 0)},
            {Complex.valueOf(.0066, 0), Complex.valueOf(.9935, 0)}};
        Complex[][] hTemp = {
            {Complex.valueOf(.0295, 0)},
            {Complex.valueOf(.0001, 0)}};
        Complex[][] cTemp = {
            {Complex.valueOf(0, 0), Complex.valueOf(1, 0)}};
        Complex[][] gIncreasedTemp = {
            {Complex.valueOf(.9935, 0), Complex.valueOf(0, 0), Complex.valueOf(.0295, 0)},
            {Complex.valueOf(.0066, 0), Complex.valueOf(.9935, 0), Complex.valueOf(0.0001, 0)},
            {Complex.valueOf(0, 0), Complex.valueOf(0, 0), Complex.valueOf(0, 0)}};
        Complex[][] hIncreasedTemp = {
            {Complex.valueOf(0, 0)},
            {Complex.valueOf(0, 0)},
            {Complex.valueOf(1, 0)}};
        Complex[][] wcInverseTemp = {
            {Complex.valueOf(0, 0), Complex.valueOf(0, 0), Complex.valueOf(1, 0)},
            {Complex.valueOf(50.8, 0), Complex.valueOf(-5085.5, 0), Complex.valueOf(0, 0)},
            {Complex.valueOf(-17, 0), Complex.valueOf(5118.9, 0), Complex.valueOf(0, 0)}};
        Complex[][] wcTemp = {
            {Complex.valueOf(0, 0), Complex.valueOf(0.0295, 0), Complex.valueOf(0.0293, 0)},
            {Complex.valueOf(0, 0), Complex.valueOf(0.0001, 0), Complex.valueOf(0.0003, 0)},
            {Complex.valueOf(1, 0), Complex.valueOf(0, 0), Complex.valueOf(0, 0)}};
//        Complex[][] gTemp = {
//            {Complex.valueOf(1.0006559, 0), Complex.valueOf(0, 0)},
//            {Complex.valueOf(0.0065613, 0), Complex.valueOf(1.0006559, 0)}};
//        Complex[][] hTemp = {
//            {Complex.valueOf(0.029652907, 0)},
//            {Complex.valueOf(0.059315536, 0)}};
//        Complex[][] cTemp = {
//            {Complex.valueOf(0, 0), Complex.valueOf(1, 0)}};
//        Complex[][] gIncreasedTemp = {
//            {Complex.valueOf(1.0006559, 0), Complex.valueOf(0, 0), Complex.valueOf(0.029652907, 0)},
//            {Complex.valueOf(0.0065613, 0), Complex.valueOf(1.0006559, 0), Complex.valueOf(0.059315536, 0)},
//            {Complex.valueOf(0, 0), Complex.valueOf(0, 0), Complex.valueOf(0, 0)}};
//        Complex[][] hIncreasedTemp = {
//            {Complex.valueOf(0, 0)},
//            {Complex.valueOf(0, 0)},
//            {Complex.valueOf(1, 0)}};
//        Complex[][] wcInverseTemp = {
//            {Complex.valueOf(0, 0), Complex.valueOf(0, 0), Complex.valueOf(1, 0)},
//            {Complex.valueOf(50.8, 0), Complex.valueOf(-5085.5, 0), Complex.valueOf(0, 0)},
//            {Complex.valueOf(-17, 0), Complex.valueOf(5118.9, 0), Complex.valueOf(0, 0)}};
//        Complex[][] wcTemp = {
//            {Complex.valueOf(0, 0), Complex.valueOf(0.0296529, 0), Complex.valueOf(0.0296724, 0)},
//            {Complex.valueOf(0, 0), Complex.valueOf(-0.0593155, 0), Complex.valueOf(-0.0591599, 0)},
//            {Complex.valueOf(1, 0), Complex.valueOf(0, 0), Complex.valueOf(0, 0)}};

        this.matrixG = ComplexMatrix.valueOf(gTemp);
        this.matrixH = ComplexMatrix.valueOf(hTemp);
        this.matrixC = ComplexMatrix.valueOf(cTemp);
        this.matrixGIncreased = ComplexMatrix.valueOf(gIncreasedTemp);
        this.matrixHIncreased = ComplexMatrix.valueOf(hIncreasedTemp);
        this.matrixWc = ComplexMatrix.valueOf(wcTemp);
        matrixLast = generateMatrixLast();
        System.out.println("matrixLast " + matrixLast);
    }

    public double[] gains(ArrayList<Complex> polos) {
        ComplexMatrix kChapeu = calculateAckermmann(polos);

//        Complex[][] cha = {{Complex.valueOf(261.640410709, 0), Complex.valueOf(38959.4137421529, 0), Complex.valueOf(4.8819414356, 0)}};

//        ComplexMatrix kChapeu = ComplexMatrix.valueOf(cha);
        
        System.out.println("kchapeu " + kChapeu);

        ComplexMatrix zo = ComplexMatrix.valueOf(zerosOne(kChapeu.getNumberOfColumns()));


        ComplexMatrix aux = kChapeu.plus(zo).times(matrixLast.inverse());

        System.out.println("gains complex " + aux);

        double[] resu = new double[3];

        resu[0] = aux.get(0, 0).getReal();
        resu[1] = aux.get(0, 1).getReal();
        resu[2] = aux.get(0, 2).getReal();

        return resu;
    }

    private ComplexMatrix calculateAckermmann(ArrayList<Complex> polos) {
        ComplexMatrix qc = calculateMatrixQc(polos);

        System.out.println("qc " + qc);

        Complex[][] vec2 = zerosOne(matrixWc.getNumberOfColumns());

        ComplexMatrix aux = ComplexMatrix.valueOf(vec2);

        ComplexMatrix result = aux.times(Complex.valueOf(-1,0)).times(matrixWc.inverse().times(qc));

        return result;
    }

    private Complex[][] zerosOne(int col) {
        Complex[][] vec2 = zeros(1, col);
        vec2[0][col - 1] = Complex.valueOf(1, 0);
        return vec2;
    }

    private ComplexMatrix calculateMatrixQc(ArrayList<Complex> polos) {
        int row = matrixGIncreased.getNumberOfRows();

        ComplexMatrix Qc = ComplexMatrix.valueOf(identity(row));
        for (int i = 0; i < polos.size(); i++) {
            ComplexMatrix aux = matrixGIncreased.plus(identity(row).times(polos.get(i)).times(Complex.valueOf(-1, 0)));
            Qc = Qc.times(aux);
        }
        return Qc;
    }

    private ComplexMatrix identity(int order) {
        Complex[][] vec = new Complex[order][order];
        for (int lin = 0; lin < order; lin++) {
            for (int col = 0; col < order; col++) {
                if (lin == col) {
                    vec[lin][col] = Complex.ONE;
                } else {
                    vec[lin][col] = Complex.ZERO;
                }
            }
        }
        ComplexMatrix I = ComplexMatrix.valueOf(vec);
        return I;
    }

    private Complex[][] zeros(int lin, int col) {
        Complex[][] vec = new Complex[lin][col];
        for (int i = 0; i < vec.length; i++) {
            for (int j = 0; j < vec[0].length; j++) {
                vec[i][j] = Complex.ZERO;
            }
        }
        return vec;
    }

    private ComplexMatrix generateMatrixLast() {
        ComplexMatrix um = matrixG.minus(identity(matrixG.getNumberOfColumns()));
        ComplexMatrix tres = matrixC.times(matrixG);
        ComplexMatrix quatro = matrixC.times(matrixH);

        int row = matrixGIncreased.getNumberOfRows();
        int col = matrixGIncreased.getNumberOfColumns();

        Complex[][] result = new Complex[row][col];

        for (int lin = 0; lin < um.getNumberOfRows(); lin++) {
            for (int coluna = 0; coluna < um.getNumberOfColumns(); coluna++) {
                result[lin][coluna] = um.get(lin, coluna);
            }
        }

        result[0][2] = matrixH.get(0, 0);
        result[1][2] = matrixH.get(1, 0);

        for (int lin = 0; lin < tres.getNumberOfRows(); lin++) {
            for (int coluna = 0; coluna < tres.getNumberOfColumns(); coluna++) {
                result[2][coluna] = tres.get(lin, coluna);
            }
        }

        result[2][2] = quatro.get(0, 0);
        return ComplexMatrix.valueOf(result);
    }
}

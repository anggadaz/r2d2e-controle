/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import Jama.Matrix;
import java.util.ArrayList;
import org.jfree.util.ShapeUtilities;

/**
 *
 * @author Demetrios
 */
public class Inference {

    private RuleBase ruleBase;
    private int fuzzyType;

    public Inference() {
    }

    private Shape avaliateRule(Rule rule, DataIn dataIn) {

        String[] variables = dataIn.getVariables();

        double[] pertinenceValue = new double[variables.length];

        int i = 0;

        for (String var : variables) {

            Shape shape = rule.getShape(var);

            double value = dataIn.getValueOfVariable(var);

            double mi = shape.getRangeValue(value);

            pertinenceValue[i++] = mi;
        }

        double minPertiValue = min(pertinenceValue);

        Shape funcOut = rule.getFunctionOut();

        return reShapeFuncOut(funcOut, minPertiValue);
    }

    private Point computelinearSystem(Line line1, Line line2) {

        double[] coef = line2.LineEquationCoeficients();

        double[] coefic2 = line1.LineEquationCoeficients();

        Matrix d = new Matrix(2, 2);
        Matrix dx = new Matrix(2, 2);
        Matrix dy = new Matrix(2, 2);

        d.set(0, 0, coef[0]);
        d.set(0, 1, coef[1]);
        d.set(1, 0, coefic2[0]);
        d.set(1, 1, coefic2[1]);

        dx.set(0, 0, coef[2]);
        dx.set(0, 1, coef[1]);
        dx.set(1, 0, coefic2[2]);
        dx.set(1, 1, coefic2[1]);

        dy.set(0, 0, coef[0]);
        dy.set(0, 1, coef[2]);
        dy.set(1, 0, coefic2[0]);
        dy.set(1, 1, coefic2[2]);

        double determinanteD = d.det();
        double determinanteDx = dx.det();
        double determinanteDy = dy.det();

        double x = determinanteDx / determinanteD;
        double y = determinanteDy / determinanteD;

        Point initPoint = new Point(x, y);

        return initPoint;
    }

    private double min(double[] pertinenceValue) {

        double min = pertinenceValue[0];

        for (int j = 1; j < pertinenceValue.length; j += 2) {
            if (pertinenceValue[j] < min) {
                min = pertinenceValue[j];
            }
        }

        return min;
    }

    private Shape reShapeFuncOut(Shape funcOut, double minPertiValue) {

        Line line = new Line(0, minPertiValue, 30, minPertiValue);

        ArrayList<Line> lines = funcOut.getLines();

        Shape saida = new Shape();

        for (Line lineShape : lines) {

            Point initPoint = computelinearSystem(lineShape, line);

            Line newLine = new Line(initPoint, lineShape.getPoint2());

            saida.addLine(newLine);

        }

        return saida;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import Jama.Matrix;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
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

    public Shape avaliateRule(Rule rule, DataIn dataIn) {

        ArrayList<String> variables = dataIn.getVariables();

        double[] pertinenceValue = new double[variables.size()];

        int i = 0;

        for (String var : variables) {

            Shape shape = rule.getInputShape(var);

            double value = dataIn.getValueOfVariable(var);

            double mi = shape.getRangeValue(value);

            pertinenceValue[i++] = mi;
        }

        double minPertiValue = min(pertinenceValue);

        Shape funcOut = rule.getOutPutShape(ConstantsFuzzy.VARIABLE_OUTPUT);

        return reShapeFuncOut(funcOut, minPertiValue);
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

        if(minPertiValue == 0){
            return funcOut;
        }

        ArrayList<Line> lines = funcOut.getLines();

        ArrayList<Double> xs = new ArrayList<Double>();

        Shape saida = new Shape();

        for (Line lineShape : lines) {

            if (lineShape.getPoint1().getY() == 0 && lineShape.getPoint2().getY() == 0) {
                continue;
            }

            double x = lineShape.domainValue(minPertiValue);

            xs.add(x);

            Point endPoint = new Point(x, minPertiValue);

            Line newLine = new Line(endPoint, lineShape.getPoint1());

            saida.addLine(newLine);

        }

        saida.addLine(new Line(xs.get(0), minPertiValue, xs.get(1), minPertiValue));

        return saida;
    }
}

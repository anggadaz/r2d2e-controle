/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import Jama.Matrix;
import java.util.ArrayList;


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

        return reShapeFuncOut(funcOut,minPertiValue);
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

        double[] coef = line.LineEquationCoeficients();

        Matrix matrixLine = new Matrix(1, 3);

        matrixLine.set(0, 0, coef[0]);
        matrixLine.set(0, 1, coef[1]);
        matrixLine.set(0, 2, coef[2]);

        ArrayList<Line> lines = funcOut.getLines();

        for (Line lineShape : lines) {
            
        }
       
    }
}

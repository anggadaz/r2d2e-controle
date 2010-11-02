/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.utils.Util;
import java.util.ArrayList;

/**
 *
 * @author demetrios
 */
public class RulesAvaliationThread extends Thread {

    private int id;
    private int startIndex;
    private int elements;
    private ArrayList<Rule> rules;
    private DataIn dataIn;
    private FuncPertinence globalShape;
    private int andFunction;
    private static final Object lock = new Object();

    public RulesAvaliationThread(int id, int startIndex, int elements, ArrayList<Rule> rules, DataIn dataIn, FuncPertinence globalShape, int andFunction) {
        this.id = id;
        this.startIndex = startIndex;
        this.elements = elements;
        this.rules = rules;
        this.dataIn = dataIn;
        this.globalShape = globalShape;
        this.andFunction = andFunction;
    }

    @Override
    public void run() {
        FuncPertinence tempShape = null;

        for (Rule rule : rules) {

            FuncPertinence shape = avaliateRule(rule);

            if (tempShape == null) {
                tempShape = shape;
                continue;
            }

            aggregate(shape, tempShape);
        }

        synchronized (lock) {
            aggregate(tempShape, globalShape);
        }

    }

    private FuncPertinence avaliateRule(Rule rule) {

        ArrayList<String> variables = dataIn.getVariables();

        double[] pertinenceValue = new double[variables.size()];

        int i = 0;

        for (String var : variables) {

            FuncPertinence shape = rule.getInputShape(var);

            if (shape == null) {
                continue;
            }

            double value = dataIn.getValueOfVariable(var);

            double mi = shape.getRangeValue(value);

            if (rule.isOperationNot(var)) {
                value = 1 - value;
            }
            pertinenceValue[i++] = mi;
        }

        int index[] = Util.min(pertinenceValue);

        FuncPertinence funcOut = rule.getOutPutShape(ConstantsFuzzy.VARIABLE_OUTPUT);

        return reShapeFuncOut(funcOut, pertinenceValue[index[0]]);
    }





    private FuncPertinence reShapeFuncOut(FuncPertinence funcOut, double minPertiValue) {

        if (minPertiValue == 0) {
            return funcOut;
        }

        return funcOut.cut(minPertiValue);
    }

    private void aggregate(FuncPertinence shape, FuncPertinence shapeOut) {
    }
}

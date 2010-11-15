/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.utils.Util;
import java.util.ArrayList;
import java.util.Collections;
import org.openide.util.Exceptions;

/**
 *
 * @author iuri
 */
public class Sugeno extends Inference {

    private ArrayList<Double> alphas;
    private ArrayList<Double> expressionValues;

    public Sugeno(RuleBase ruleBase, DataBase dataBase) {
        super(ruleBase, dataBase);
    }

    public Double[][] alfa(ArrayList<ArrayList<Double>> lista) {
        int n = lista.size();
        ArrayList<Double> min = new ArrayList<Double>();

        int nc = 1;
        for (int it = 0; it < lista.size(); it++) {
            if (it != 0) {
                nc = nc * lista.get(it).size();
            }
        }
        Double a[][] = new Double[n][nc];

        int index[] = new int[n];
        int lin = 0;
        int col = 0;
        while (index[0] < lista.get(0).size()) {
            for (int i = 0; i < n; i++) {
                int j = index[i];
                Double x = lista.get(i).get(j);
                min.add(x);
            }
            Collections.sort(min);
            double minimo = min.get(0);
            min.clear();
            a[lin][col] = minimo;
            col++;

            index[n - 1] = index[n - 1]++ % lista.get(n - 1).size();
            for (int i = n - 1; i > 0; i--) {
                if (index[i] == 0) {
                    index[i - 1] = index[i - 1]++ % lista.get(i - 1).size();
                    if (i - 1 == 0) {
                        lin++;
                        col = 0;
                    }
                } else {
                    break;
                }
            }
        }

        return a;
    }

    @Override
    public FunctionOutPut work(final DataIn dataIn) {

        Thread thread1 = new Thread(new Runnable() {

            public void run() {
                alphas = minAlphas(dataIn);
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            public void run() {
                expressionValues = evaluateExpressions(dataIn);
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }

        double value = calculateFinalValue();

        return new FunctionOutPut(new Expression(value));
    }

    private ArrayList<Double> evaluateExpressions(DataIn dataIn) {
        ArrayList<Double> results = new ArrayList<Double>();

        ArrayList<Rule> rules = ruleBase.getRules();

        for (Rule rule : rules) {
            Expression expression = rule.getOutPutExpression(ConstantsFuzzy.VARIABLE_OUTPUT);
            results.add(expression.evaluate(dataIn));
        }

        return results;
    }

    private ArrayList<Double> minAlphas(DataIn dataIn) {
        ArrayList<Double> results = new ArrayList<Double>();

        ArrayList<Rule> rules = ruleBase.getRules();

        ArrayList<String> variables = dataIn.getVariables();

        for (Rule rule : rules) {

            double min[] = new double[variables.size()];
            int i = 0;

            for (String variable : variables) {
                FuncPertinence pertinence = rule.getInputShape(variable);
                min[i++] = pertinence.getRangeValue(dataIn.getValueOfVariable(variable));
            }

            int[] indexs = Util.min(min);

            results.add(min[indexs[0]]);
        }

        return results;
    }

    private double calculateFinalValue() {

        double num = 0;
        double den = 0;

        for (int i = 0; i < alphas.size(); i++) {
            double y = expressionValues.get(i);
            double alpha = alphas.get(i);
            num += (alpha * y);
            den += alpha;
        }

        return num / den;
    }
}

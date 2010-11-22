/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.utils.Util;
import java.util.ArrayList;
import org.openide.util.Exceptions;

/**
 *
 * @author iuri
 */
public class Sugeno extends Inference {

    private ArrayList<Double> alphas;
    private ArrayList<Double> expressionValues;

    public Sugeno() {
        super();
    }

    public Sugeno(RuleBase ruleBase, DataBase dataBase) {
        super(ruleBase, dataBase);
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
                min[i++] = pertinence.getRangeNormalValue(dataIn.getValueOfVariable(variable));
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

    @Override
    public String toString() {
        return "Sugeno";
    }

}

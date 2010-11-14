/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.utils.Util;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author iuri
 */
public class Sugeno extends Inference {

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
    public FunctionOutPut work(DataIn dataIn) {
        ArrayList<Double> alphas = minAlphas(dataIn);
        ArrayList<Double> results = evaluateExpressions(dataIn);


//TODO ESTA FALTANDO FAZER A MEDIA PONDERADA RESULTADO =(ALPHAS[I]*RESULTS[I]/SOMA DE ALPHAS)
//        E DEPOIS FAÇA ISSO :
//        Expression expression = new Expression();
//        expression.setOffset(RESULTADO);
//        return new FunctionOutPut(expression);

        return null;
//        ArrayList<String> variables = dataIn.getVariables();
//        ArrayList<ArrayList<Double>> listaEntradas = new ArrayList<ArrayList<Double>>();
//        for (String variable : variables) {
//            double value = dataIn.getValueOfVariable(variable);
//            ArrayList<Shape> funcPertinencias = dataBase.getIn(variable);
//            ArrayList<Double> pertinenciaValues = new ArrayList<Double>();
//            for (Shape pertinencia : funcPertinencias) {
//                pertinenciaValues.add(pertinencia.getRangeValue(value));
//            }
//            listaEntradas.add(pertinenciaValues);
//        }
//
//        Double alpha[][] = alfa(listaEntradas);
//
//
//    }
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
}

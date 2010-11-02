/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/**
 *
 * @author iuri
 */
public class Sugeno extends Inference {

    private DataBase dataBase;

    public Sugeno(DataBase dataBase) {
        this.dataBase = dataBase;
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
    public Shape work(DataIn dataIn) {
        ArrayList<String> variables = dataIn.getVariables();
        ArrayList<ArrayList<Double>> listaEntradas = new ArrayList<ArrayList<Double>>();
        for (String variable : variables) {
            double value = dataIn.getValueOfVariable(variable);
            ArrayList<Shape> funcPertinencias = dataBase.getIn(variable);
            ArrayList<Double> pertinenciaValues = new ArrayList<Double>();
            for (Shape pertinencia : funcPertinencias) {
                pertinenciaValues.add(pertinencia.getRangeValue(value));
            }
            listaEntradas.add(pertinenciaValues);
        }

        Double alpha[][] = alfa(listaEntradas);


    }
}

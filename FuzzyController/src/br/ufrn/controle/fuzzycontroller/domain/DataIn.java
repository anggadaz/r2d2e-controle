/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Demetrios
 */
public class DataIn {

    private HashMap<String, Double> variables;

    public DataIn() {
        variables = new HashMap<String, Double>();
    }

    public ArrayList<String> getVariables() {
        return new ArrayList<String>(variables.keySet());
    }

    public double getValueOfVariable(String variable) {
        return variables.get(variable);
    }

    public void addValue(String variable, Double value) {
        variables.put(variable, value);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Demetrios
 */
public class Expression {

    private HashMap<String, Double> constants;
    private double offset;

    public Expression() {
        constants = new HashMap<String, Double>();
        offset = 0;
    }

    public Expression(double offset) {
        this.offset = offset;
    }

    public void addConstant(String variable, double value) {
        constants.put(variable, value);
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public double evaluate(DataIn dataIn) {


        ArrayList<String> variables = dataIn.getVariables();

        double result = offset;

        for (String variable : variables) {
            Double value = dataIn.getValueOfVariable(variable);
            Double constant = constants.get(variable);
            result += (constant * value);
        }

        return result;
    }
}

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
    private String name;

    public Expression() {
        constants = new HashMap<String, Double>();
        offset = 0;
        name = "";
    }

    public Expression(double offset) {
        this.offset = offset;
        constants = new HashMap<String, Double>();
        name = "";
    }

    public Expression(String name) {
        this.name = name;
        constants = new HashMap<String, Double>();
        offset = 0;
    }

    public Expression(double offset, String name) {
        this.offset = offset;
        this.name = name;
        constants = new HashMap<String, Double>();
    }

    public void addConstant(String variable, double value) {
        constants.put(variable, value);
    }

    public Double getConstant(String variable) {
        return constants.get(variable);
    }

    public void setOffset(double offset) {
        this.offset = offset;
    }

    public String getName() {
        return name;
    }

    public double getOffset() {
        return offset;
    }

    public double evaluate(DataIn dataIn) {


        ArrayList<String> variables = dataIn.getVariables();

        double result = offset;

        for (String variable : variables) {
            Double value = dataIn.getValueOfVariable(variable);

            Double constant = constants.get(variable);

            if (constant == null) {
                constant = 0d;
            }

            result += (constant * value);
        }

        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}

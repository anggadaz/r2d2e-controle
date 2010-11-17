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
public class DataBase {

    private HashMap<String, ArrayList<FuncPertinence>> pertinenceIn;
    private HashMap<String, ArrayList<FuncPertinence>> pertinenceOut;
    private HashMap<String, ArrayList<Expression>> expressionOut;
    private HashMap<String, ArrayList<Double>> rangesIn;
    private HashMap<String, ArrayList<Double>> rangesOut;

    public DataBase() {
        pertinenceIn = new HashMap<String, ArrayList<FuncPertinence>>();
        pertinenceOut = new HashMap<String, ArrayList<FuncPertinence>>();
        expressionOut = new HashMap<String, ArrayList<Expression>>();
        rangesIn = new HashMap<String, ArrayList<Double>>();
        rangesOut = new HashMap<String, ArrayList<Double>>();
    }

    public ArrayList<FuncPertinence> getIn(String variableIn) {
        return pertinenceIn.get(variableIn);
    }

    public ArrayList<FuncPertinence> getOut(String variableOut) {
        return pertinenceOut.get(variableOut);
    }

    public ArrayList<Expression> getExpressionOut(String variableOut) {
        return expressionOut.get(variableOut);
    }

    public ArrayList<Double> getRangeIn(String variableIn) {
        return rangesIn.get(variableIn);
    }

    public ArrayList<Double> getRangeOut(String variableOut) {
        return rangesOut.get(variableOut);
    }

    public void addIn(String variableIn, FuncPertinence func) {
        ArrayList<FuncPertinence> list = pertinenceIn.get(variableIn);

        if (list == null) {
            list = new ArrayList<FuncPertinence>();
            pertinenceIn.put(variableIn, list);
        }

        list.add(func);

    }

    public void addOut(String variableOut, FuncPertinence func) {
        ArrayList<FuncPertinence> list = pertinenceOut.get(variableOut);

        if (list == null) {
            list = new ArrayList<FuncPertinence>();
            pertinenceOut.put(variableOut, list);
        }

        list.add(func);
    }

    public void addOut(String variableOut, Expression expr) {
        ArrayList<Expression> list = expressionOut.get(variableOut);

        if (list == null) {
            list = new ArrayList<Expression>();
            expressionOut.put(variableOut, list);
        }

        list.add(expr);
    }
    public void addIn(String variableOut, ArrayList<FuncPertinence> pertinences) {
        pertinenceIn.put(variableOut, pertinences);
    }

    public void addOut(String variableOut, ArrayList<FuncPertinence> pertinences) {
        pertinenceOut.put(variableOut, pertinences);
    }

    public void addExpressionOut(String variableOut, ArrayList<Expression> expressionsss){
        expressionOut.put(variableOut, expressionsss);
    }

    public void addRangeIn(String variableOut, ArrayList<Double> rangeIn) {
        rangesIn.put(variableOut, rangeIn);
    }

    public void addRangeOut(String variableOut, ArrayList<Double> rangeOut) {
        rangesOut.put(variableOut, rangeOut);
    }
}

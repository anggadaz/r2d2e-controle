/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import java.util.HashMap;

/**
 *
 * @author Demetrios
 */
public class Rule {

    private HashMap<String, Shape> premises;
    private HashMap<String, Shape> functionOuts;

    public Rule() {
        premises = new HashMap<String, Shape>();
        functionOuts = new HashMap<String, Shape>();
    }

    public void addPremise(String Variable, Shape geometry) {
        premises.put(Variable, geometry);
    }

    public void addFunctionOut(String variable, Shape shape) {
        functionOuts.put(variable, shape);
    }
    
    public Shape getInputShape(String var) {
        return premises.get(var);
    }

    public Shape getOutPutShape(String var){
        return functionOuts.get(var);
    }
}

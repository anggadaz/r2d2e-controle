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

    private HashMap<String, PremiseInfo> premises;
    private HashMap<String, Shape> functionOuts;

    public Rule() {
        premises = new HashMap<String, PremiseInfo>();
        functionOuts = new HashMap<String, Shape>();
    }

    public void addPremise(String Variable, boolean isOperationNot, Shape geometry) {
        premises.put(Variable, new PremiseInfo(geometry, isOperationNot));
    }

    public void addFunctionOut(String variable, Shape shape) {
        functionOuts.put(variable, shape);
    }

    public Shape getInputShape(String var) {
        PremiseInfo info = premises.get(var);
        return info != null ? info.getShape() : null;
    }

    public Shape getOutPutShape(String var) {
        Shape shape = functionOuts.get(var);
        return shape != null ? shape : null;
    }

    public boolean isOperationNot(String var) {
        PremiseInfo info = premises.get(var);
        return info != null ? info.isOperationNot() : false;
    }
}

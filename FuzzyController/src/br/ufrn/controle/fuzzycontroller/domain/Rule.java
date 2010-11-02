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
    private HashMap<String, FuncPertinence> functionOuts;

    public Rule() {
        premises = new HashMap<String, PremiseInfo>();
        functionOuts = new HashMap<String, FuncPertinence>();
    }

    public void addPremise(String Variable, boolean isOperationNot, FuncPertinence geometry) {
        premises.put(Variable, new PremiseInfo(geometry, isOperationNot));
    }

    public void addFunctionOut(String variable, FuncPertinence shape) {
        functionOuts.put(variable, shape);
    }

    public FuncPertinence getInputShape(String var) {
        PremiseInfo info = premises.get(var);
        return info != null ? info.getShape() : null;
    }

    public FuncPertinence getOutPutShape(String var) {
        FuncPertinence shape = functionOuts.get(var);
        return shape != null ? shape : null;
    }

    public boolean isOperationNot(String var) {
        PremiseInfo info = premises.get(var);
        return info != null ? info.isOperationNot() : false;
    }
}

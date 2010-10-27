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

    private HashMap<String,Shape> premises;
    private Shape funcOut;

    public Rule() {
        premises = new HashMap<String, Shape>();
        funcOut = new Shape();
    }

    public void addPremise(String Variable, Shape geometry){
        premises.put(Variable, geometry);
    }

    public void setFunctionOut(Shape functionOut){
        funcOut = functionOut;
    }

    public Shape getShape(String variable){
        return premises.get(variable);
    }

    public Shape getFunctionOut(){
        return funcOut;
    }
}

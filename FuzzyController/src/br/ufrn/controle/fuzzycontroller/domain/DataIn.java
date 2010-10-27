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
public class DataIn {

    private HashMap<String,Double> variables;

    public DataIn() {
        variables = new HashMap<String, Double>();
    }

    public String[] getVariables(){
        return (String[]) variables.keySet().toArray();
    }

    public double getValueOfVariable(String variable){
        return variables.get(variable);
    }

}

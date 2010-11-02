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

    HashMap<String, ArrayList<FuncPertinence>> pertinenceIn;
    HashMap<String, ArrayList<FuncPertinence>> pertinenceOut;

    public DataBase() {
        pertinenceIn = new HashMap<String, ArrayList<FuncPertinence>>();
        pertinenceOut = new HashMap<String, ArrayList<FuncPertinence>>();
    }

    public ArrayList<FuncPertinence> getIn(String variableIn) {
        return pertinenceIn.get(variableIn);
    }

    public ArrayList<FuncPertinence> getOut(String variableOut) {
        return pertinenceIn.get(variableOut);
    }
}

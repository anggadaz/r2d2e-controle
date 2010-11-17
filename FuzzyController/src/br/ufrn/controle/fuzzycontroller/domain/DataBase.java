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

    private HashMap<String, ArrayList<FuncPertinence>> pertinenceIn = new HashMap<String, ArrayList<FuncPertinence>>();
    private HashMap<String, ArrayList<FuncPertinence>> pertinenceOut = new HashMap<String, ArrayList<FuncPertinence>>();

    public ArrayList<FuncPertinence> getIn(String variableIn) {
        return pertinenceIn.get(variableIn);
    }

    public ArrayList<FuncPertinence> getOut(String variableOut) {
        return pertinenceOut.get(variableOut);
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

    public void addIn(String variableIn, ArrayList<FuncPertinence> pertinences) {
        pertinenceIn.put(variableIn, pertinences);
    }

    public void addOut(String variableOut, ArrayList<FuncPertinence> pertinences) {
        pertinenceOut.put(variableOut, pertinences);
    }
}

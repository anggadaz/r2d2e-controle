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

    private static HashMap<String, ArrayList<FuncPertinence>> pertinenceIn;
    private static HashMap<String, ArrayList<FuncPertinence>> pertinenceOut;

    static {
        pertinenceIn = new HashMap<String, ArrayList<FuncPertinence>>();
        pertinenceOut = new HashMap<String, ArrayList<FuncPertinence>>();
    }

    public static ArrayList<FuncPertinence> getIn(String variableIn) {
        return pertinenceIn.get(variableIn);
    }

    public static ArrayList<FuncPertinence> getOut(String variableOut) {
        return pertinenceOut.get(variableOut);
    }

    public static void addIn(String variableIn, FuncPertinence func) {
        ArrayList<FuncPertinence> list = pertinenceIn.get(variableIn);

        if (list == null) {
            list = new ArrayList<FuncPertinence>();
            pertinenceIn.put(variableIn, list);
        }

        list.add(func);

    }

    public static void addOut(String variableOut, FuncPertinence func) {
        ArrayList<FuncPertinence> list = pertinenceOut.get(variableOut);

        if (list == null) {
            list = new ArrayList<FuncPertinence>();
            pertinenceOut.put(variableOut, list);
        }

        list.add(func);
    }

    public static void addIn(String variableOut, ArrayList<FuncPertinence> pertinences) {
        pertinenceIn.put(variableOut, pertinences);
    }

    public static void addOut(String variableOut, ArrayList<FuncPertinence> pertinences) {
        pertinenceOut.put(variableOut, pertinences);
    }
}

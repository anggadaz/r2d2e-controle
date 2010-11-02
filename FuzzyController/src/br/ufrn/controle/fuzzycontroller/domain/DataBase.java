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

    HashMap<String, ArrayList<Shape>> pertinenceIn;
    HashMap<String, ArrayList<Shape>> pertinenceOut;

    public DataBase() {
        pertinenceIn = new HashMap<String, ArrayList<Shape>>();
        pertinenceOut = new HashMap<String, ArrayList<Shape>>();
    }

    public ArrayList<Shape> getIn(String variableIn) {
        return pertinenceIn.get(variableIn);
    }

    public ArrayList<Shape> getOut(String variableOut) {
        return pertinenceIn.get(variableOut);
    }
}

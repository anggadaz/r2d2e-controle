/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import java.util.ArrayList;

/**
 *
 * @author Demetrios
 */
public class RuleBase {

    private ArrayList<Rule> rules;

    public RuleBase() {
        rules = new ArrayList<Rule>();
    }

    public RuleBase(ArrayList<Rule> rules) {
        this.rules = rules;
    }

    public ArrayList<Rule> getRules() {
        return rules;
    }
}

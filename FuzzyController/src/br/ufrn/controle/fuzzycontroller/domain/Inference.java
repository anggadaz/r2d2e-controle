/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

/**
 *
 * @author demetrios
 */
public abstract class Inference {

    protected RuleBase ruleBase;
    protected int andFunction;

    public abstract Shape work(DataIn dataIn);

    public int getAndFunction() {
        return andFunction;
    }

    public void setAndFunction(int andFunction) {
        this.andFunction = andFunction;
    }

    public RuleBase getRuleBase() {
        return ruleBase;
    }

    public void setRuleBase(RuleBase ruleBase) {
        this.ruleBase = ruleBase;
    }
}

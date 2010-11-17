/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;

/**
 *
 * @author demetrios
 */
public abstract class Inference {

    protected RuleBase ruleBase;
    protected DataBase dataBase;
    protected int andFunction;

    public Inference(RuleBase ruleBase) {
        this.ruleBase = ruleBase;
        andFunction = ConstantsFuzzy.MIN_FUNCTION;
    }

    public Inference(DataBase dataBase) {
        this.dataBase = dataBase;
        andFunction = ConstantsFuzzy.MIN_FUNCTION;
    }

    public Inference(RuleBase ruleBase, DataBase dataBase) {
        this.ruleBase = ruleBase;
        this.dataBase = dataBase;
        andFunction = ConstantsFuzzy.MIN_FUNCTION;
    }

    public abstract FunctionOutPut work(DataIn dataIn);

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

    public DataBase getDataBase() {
        return dataBase;
    }

    public void setDataBase(DataBase dataBase) {
        this.dataBase = dataBase;
    }
}

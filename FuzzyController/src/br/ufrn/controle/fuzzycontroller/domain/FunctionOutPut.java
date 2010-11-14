/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

/**
 *
 * @author Demetrios
 */
public class FunctionOutPut {

    private FuncPertinence pertinence;
    private Expression expression;

    public FunctionOutPut() {
    }

    public FunctionOutPut(FuncPertinence pertinence) {
        this.pertinence = pertinence;
    }

    public FunctionOutPut(Expression expression) {
        this.expression = expression;
    }

    public Expression getExpression() {
        return expression;
    }

    public void setExpression(Expression expression) {
        this.expression = expression;
    }

    public FuncPertinence getPertinence() {
        return pertinence;
    }

    public void setPertinence(FuncPertinence pertinence) {
        this.pertinence = pertinence;
    }
}

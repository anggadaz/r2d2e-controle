/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncPertinence;

/**
 *
 * @author demetrios
 */
public class PremiseInfo {

    private FuncPertinence shape;
    private boolean OperationNot;

    public PremiseInfo(FuncPertinence shape, boolean OperationNot) {
        this.shape = shape;
        this.OperationNot = OperationNot;
    }

    public boolean isOperationNot() {
        return OperationNot;
    }

    public void setOperationNot(boolean OperationNot) {
        this.OperationNot = OperationNot;
    }

    public FuncPertinence getShape() {
        return shape;
    }

    public void setShape(FuncPertinence shape) {
        this.shape = shape;
    }
}

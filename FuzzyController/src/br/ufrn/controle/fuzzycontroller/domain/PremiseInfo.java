/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

/**
 *
 * @author demetrios
 */
public class PremiseInfo {

    private Shape shape;
    private boolean OperationNot;

    public PremiseInfo(Shape shape, boolean OperationNot) {
        this.shape = shape;
        this.OperationNot = OperationNot;
    }

    public boolean isOperationNot() {
        return OperationNot;
    }

    public void setOperationNot(boolean OperationNot) {
        this.OperationNot = OperationNot;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}

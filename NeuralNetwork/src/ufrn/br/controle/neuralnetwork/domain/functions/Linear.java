/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.functions;

/**
 *
 * @author Demetrios
 */
public class Linear implements ActivationFunction {

    public double getValue(double x) {
        return x;
    }

    public double getDerivativeValue(double x) {
        return 1;
    }

    @Override
    public String toString() {
        return "Linear";
    }
}

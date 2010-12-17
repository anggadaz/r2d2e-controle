/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.functions;

/**
 *
 * @author Demetrios
 */
public class Sigmoid implements ActivationFunction {

    public double getValue(double x) {
        return 1d / (1d + Math.exp(-x));
    }

    public double getDerivativeValue(double x) {
        return getValue(x) - Math.pow(getValue(x), 2);
    }
}

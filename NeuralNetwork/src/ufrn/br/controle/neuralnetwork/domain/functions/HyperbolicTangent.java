/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.functions;

/**
 *
 * @author Demetrios
 */
public class HyperbolicTangent implements ActivationFunction {

    public double getValue(double x) {
        return (1d - Math.exp(-x)) / (1 + Math.exp(-x));
    }

    public double getDerivativeValue(double x) {
        return 2 * getValue(x) - 2 * Math.pow(getValue(x), 2);
    }
}

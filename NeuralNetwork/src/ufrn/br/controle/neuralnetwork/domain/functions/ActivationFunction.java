/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.functions;

/**
 *
 * @author Demetrios
 */
public interface ActivationFunction {

    public double getValue(double x);

    public double getDerivativeValue(double x);
}

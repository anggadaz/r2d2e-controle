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
        Double d = (1d - Math.exp(-x)) / (1 + Math.exp(-x));

//        if(Double.isNaN(d)){
//            System.out.println("NaN");
//        }

        return d;
    }

    public double getDerivativeValue(double x) {
        return 2 * getValue(x) - 2 * Math.pow(getValue(x), 2);
    }

    @Override
    public String toString() {
        return "Hiperbolico";
    }
}

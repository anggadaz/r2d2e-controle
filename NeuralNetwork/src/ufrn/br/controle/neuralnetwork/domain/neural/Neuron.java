/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.neural;

import ufrn.br.controle.neuralnetwork.domain.functions.ActivationFunction;
import java.util.ArrayList;

/**
 *
 * @author Demetrios
 */
public class Neuron {

    private double gradient;
    private double biasWeight;
    private double bias;
    private double biasDeltaOmega;
    private double weightedSum;
    private ArrayList<Double> weights;
    private ArrayList<Double> deltaOmegas;
    private ActivationFunction activationFunction;

    public Neuron(double biasWeight, ArrayList<Double> weights, ActivationFunction activationFunction) {
        this.biasWeight = biasWeight;
        this.weights = weights;
        this.activationFunction = activationFunction;
        bias = 1;
        deltaOmegas = new ArrayList<Double>();
        for (int i = 0; i < weights.size(); i++) {
            deltaOmegas.add(0d);
        }
    }

    public double getOutPut() {
        return activationFunction.getValue(weightedSum);
    }

    public double getDerivateOutPut() {
        return activationFunction.getDerivativeValue(weightedSum);
    }

    public ActivationFunction getActivationFunction() {
        return activationFunction;
    }

    public void setActivationFunction(ActivationFunction activationFunction) {
        this.activationFunction = activationFunction;
    }

    public double getBias() {
        return bias;
    }

    public void setBias(double bias) {
        this.bias = bias;
    }

    public double getBiasWeight() {
        return biasWeight;
    }

    public void setBiasWeight(double biasWeight) {
        this.biasWeight = biasWeight;
    }

    public double getGradient() {
        return gradient;
    }

    public void setGradient(double gradient) {
        this.gradient = gradient;
    }

    public double getWeightedSum() {
        return weightedSum;
    }

    public void setWeightedSum(double weightedSum) {
        this.weightedSum = weightedSum;
    }

    public ArrayList<Double> getWeights() {
        return weights;
    }

    public void setWeights(ArrayList<Double> weights) {
        this.weights = weights;
    }

    public void setOmega(int index, double value) {
        deltaOmegas.set(index, value);
    }

    public double getOmega(int index) {
        return deltaOmegas.get(index);
    }

    public double getBiasDeltaOmega() {
        return biasDeltaOmega;
    }

    public void setBiasDeltaOmega(double biasDeltaOmega) {
        this.biasDeltaOmega = biasDeltaOmega;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pesos ");
        for (int i = 0; i < weights.size(); i++) {
            sb.append(weights.get(i));
        }
        sb.append(" deltaOmegas ");
        for (int i = 0; i < deltaOmegas.size(); i++) {
            sb.append(deltaOmegas.get(i));
        }

        sb.append(" gradiente ");
        sb.append(gradient);
        sb.append(" Soma Ponderada ");
        sb.append(weightedSum);
        sb.append(" Bias Peso ");
        sb.append(biasWeight);
        sb.append(" Bias DeltaOmega ");
        sb.append(biasDeltaOmega);
        sb.append(" Ativação ");
        sb.append(activationFunction);

        return sb.toString();
    }
}

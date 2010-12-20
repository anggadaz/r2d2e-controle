/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.neural;

import java.util.ArrayList;
import java.util.Random;
import ufrn.br.controle.neuralnetwork.domain.functions.ActivationFunction;
import ufrn.br.controle.neuralnetwork.shared.Constants;

/**
 *
 * @author Demetrios
 */
public class NeuralNetwork {

    private ArrayList<Layer> layers;
    private ArrayList<Double> meanSquaredErrors;
    private ArrayList<Double> localErros;

    public NeuralNetwork(int numbNeuronsIn, int numbNeuronsOut, int numbHiddenNeurons[], ActivationFunction activationFunctions[]) {
        meanSquaredErrors = new ArrayList<Double>();
        localErros = new ArrayList<Double>();
        layers = new ArrayList<Layer>();
        createNeuralNetwork(numbNeuronsIn, numbNeuronsOut, numbHiddenNeurons, activationFunctions);
    }

    private void createNeuralNetwork(int numbNeuronsIn, int numbNeuronsOut, int numbHiddenNeurons[], ActivationFunction activationFunctions[]) {

        ArrayList<Neuron> neuronsIn = new ArrayList<Neuron>();

        for (int i = 0; i < numbNeuronsIn; i++) {
            Neuron neuron = new Neuron(0, new ArrayList<Double>(), activationFunctions[0]);
            neuronsIn.add(neuron);
        }

        layers.add(new Layer(neuronsIn));

        for (int i = 0; i < numbHiddenNeurons.length; i++) {
            int numbHidden = numbHiddenNeurons[i];

            ArrayList<Neuron> neurons = new ArrayList<Neuron>();

            for (int j = 0; j < numbHidden; j++) {
                Neuron neuron = null;

                if (i == 0) {
                    neuron = new Neuron(rand(Constants.LOW_RAND, Constants.HIGH_RAND), generateRandWeights(numbNeuronsIn), activationFunctions[i + 1]);
                } else {
                    neuron = new Neuron(rand(Constants.LOW_RAND, Constants.HIGH_RAND), generateRandWeights(numbHiddenNeurons[i - 1]), activationFunctions[i + 1]);
                }

                neurons.add(neuron);
            }

            layers.add(new Layer(neurons));
        }

        ArrayList<Neuron> neuronsOut = new ArrayList<Neuron>();

        for (int i = 0; i < numbNeuronsOut; i++) {
            Neuron neuron = new Neuron(rand(Constants.LOW_RAND, Constants.HIGH_RAND), generateRandWeights(numbHiddenNeurons[numbHiddenNeurons.length - 1]), activationFunctions[activationFunctions.length - 1]);
            neuronsOut.add(neuron);
        }

        layers.add(new Layer(neuronsOut));

        for (int i = 0; i < layers.size(); i++) {
            if (i == 0) {
                layers.get(i).setForwardLayer(layers.get(i + 1));
            } else if (i == (layers.size() - 1)) {
                layers.get(i).setBackLayer(layers.get(i - 1));
            } else {
                layers.get(i).setBackLayer(layers.get(i - 1));
                layers.get(i).setForwardLayer(layers.get(i + 1));
            }
        }
    }

    private double rand(double low, double high) {
        Random random = new Random();
        return low + random.nextDouble() * (Math.abs(low) + Math.abs(high));
    }

    private ArrayList<Double> generateRandWeights(int numbWeight) {
        ArrayList<Double> out = new ArrayList<Double>();

        for (int i = 0; i < numbWeight; i++) {
            out.add(rand(Constants.LOW_RAND, Constants.HIGH_RAND));
        }

        return out;
    }

    private void updateNeuronsWeightedSum(ArrayList<Double> inValues) {
        for (Layer layer : layers) {
            layer.updateNeuronsWeightedSum(inValues);
        }
    }

    private void updateNeuronsWeight() {
        for (Layer layer : layers) {
            layer.updateWeight();
        }
    }

    private void calculateLocalError(ArrayList<Double> outValues) {

        Layer layer = layers.get(layers.size() - 1);

        double sum = 0;
        for (int i = 0; i < outValues.size(); i++) {
            sum += Math.pow(outValues.get(i) - layer.getNeuron(i).getOutPut(), 2);
        }

        localErros.add(sum / 2);
    }

    private double calculateMeanSquaredError() {
        double sum = 0;

        for (int i = 0; i < localErros.size(); i++) {
            sum += localErros.get(i);
        }

        return sum / localErros.size();
    }

    public void train(int maxItera, double errorQuadra, double learnRate, double porcValidation, ArrayList<ArrayList<Double>> inValues, ArrayList<ArrayList<Double>> outValues) {
        int iteration = 0;
        double globalError = 0;

        do {
            //para cada ponto da entrada
            for (int l = 0; l < inValues.size(); l++) {
                //atualiza os somatorios ponderados de cada neuronio
                updateNeuronsWeightedSum(inValues.get(l));
                //fase backward do fim ate a primeira camada escondida
                for (int k = layers.size() - 1; k > 0; k--) {
                    Layer layer = layers.get(k);
                    //calcula o gradiente
                    layer.updateNeuronsGradient(outValues.get(l));
                    //calcula o delta omega
                    layer.calculateDeltaOmega(learnRate);
                }
                //atualização dos pesos
                updateNeuronsWeight();
                //calcula o valor do erro local
                calculateLocalError(outValues.get(l));
            }

            globalError = calculateMeanSquaredError();

            meanSquaredErrors.add(globalError);

            iteration++;

        } while (globalError > errorQuadra && iteration < maxItera);

        System.out.println("acabou na iteração " + iteration);
        System.out.println("Global Error " + meanSquaredErrors.get(meanSquaredErrors.size()-1));
    }

    public ArrayList<Double> simulate(ArrayList<Double> inValues){
        updateNeuronsWeightedSum(inValues);

        ArrayList<Double> saida = new ArrayList<Double>();

        Layer layer = layers.get(layers.size()-1);

        for(int i = 0 ; i < layer.getNeuronsCount();i++){
            saida.add(layer.getNeuron(i).getOutPut());
        }

        return saida;
    }
}

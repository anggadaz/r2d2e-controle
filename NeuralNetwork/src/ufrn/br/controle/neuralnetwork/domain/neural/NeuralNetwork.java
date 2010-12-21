/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.neural;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import javax.swing.JProgressBar;
import ufrn.br.controle.neuralnetwork.domain.functions.ActivationFunction;
import ufrn.br.controle.neuralnetwork.shared.Constants;
import ufrn.br.controle.neuralnetwork.view.GraficoErroQuadratico;

/**
 *
 * @author Demetrios
 */
public class NeuralNetwork {

    private ArrayList<Layer> layers;
    private ArrayList<Double> meanSquaredErrors;
    private ArrayList<Double> localErros;
    private GraficoErroQuadratico grafico = new GraficoErroQuadratico();
    private boolean momentum = false;
    private boolean adaptative = false;

    public ArrayList<Double> getMeanSquaredErrors() {
        return meanSquaredErrors;
    }

    public GraficoErroQuadratico getGrafico() {
        return grafico;
    }

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

        ArrayList<Neuron> neuronsOut = null;

        if (numbHiddenNeurons != null) {
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

            neuronsOut = new ArrayList<Neuron>();

            for (int i = 0; i < numbNeuronsOut; i++) {
                Neuron neuron = new Neuron(rand(Constants.LOW_RAND, Constants.HIGH_RAND), generateRandWeights(numbHiddenNeurons[numbHiddenNeurons.length - 1]), activationFunctions[activationFunctions.length - 1]);
                neuronsOut.add(neuron);
            }
        } else {
            neuronsOut = new ArrayList<Neuron>();

            for (int i = 0; i < numbNeuronsOut; i++) {
                Neuron neuron = new Neuron(rand(Constants.LOW_RAND, Constants.HIGH_RAND), generateRandWeights(numbNeuronsIn), activationFunctions[activationFunctions.length - 1]);
                neuronsOut.add(neuron);
            }
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

    public void train(int maxItera, double errorQuadra, double learnRate, double alpha, double porcValidation, ArrayList<ArrayList<Double>> inValues, ArrayList<ArrayList<Double>> outValues, JProgressBar bar) {
        int iteration = 0;
        double globalError = 0;

        bar.setMaximum(maxItera);
        meanSquaredErrors.add(0d);

        ArrayList<ArrayList<Double>> inValuesTmp = copy(inValues);
        ArrayList<ArrayList<Double>> outValuesTmp = copy(outValues);

        do {

            shuffle(inValuesTmp, outValuesTmp);

            //para cada ponto da entrada
            for (int l = 0; l < inValuesTmp.size(); l++) {
                //atualiza os somatorios ponderados de cada neuronio
//                System.out.println("-------------------------------Iteration " + iteration);
//                System.out.println("ponto " + l + " in " + inValuesTmp.get(l) + " out " + outValuesTmp.get(l));
                updateNeuronsWeightedSum(inValuesTmp.get(l));
//                for (int k = 0; k < layers.size(); k++) {
//                    Layer layer = layers.get(k);
//                    System.out.println("camada " + k);
//                    for (int i = 0; i < layer.getNeuronsCount(); i++) {
//                        Neuron n = layer.getNeuron(i);
//                        System.out.println(n);
//                    }
//                }

                //fase backward do fim ate a primeira camada escondida
                for (int k = layers.size() - 1; k > 0; k--) {
                    Layer layer = layers.get(k);
                    //calcula o gradiente
                    layer.updateNeuronsGradient(outValuesTmp.get(l));
                    //calcula o delta omega
                    layer.calculateDeltaOmega(learnRate, alpha, momentum);
                }
                //atualização dos pesos
                updateNeuronsWeight();
                //calcula o valor do erro local
                calculateLocalError(outValuesTmp.get(l));
            }

            globalError = calculateMeanSquaredError();

            meanSquaredErrors.add(globalError);

            if (adaptative) {
                learnRate = adaptEta(learnRate);
            }

            localErros.clear();
            
            grafico.addObservation(meanSquaredErrors.size(), globalError);
            grafico.addObservation(meanSquaredErrors.size(), errorQuadra, 1);
//            System.out.println(globalError);

            bar.setValue(iteration);
            iteration++;

        } while (globalError > errorQuadra && iteration < maxItera);

        System.out.println("acabou na iteração " + iteration);
        System.out.println("Global Error " + meanSquaredErrors.get(meanSquaredErrors.size() - 1));
    }

    public ArrayList<Double> simulate(ArrayList<Double> inValues) {
        updateNeuronsWeightedSum(inValues);

        ArrayList<Double> saida = new ArrayList<Double>();

        Layer layer = layers.get(layers.size() - 1);

        for (int i = 0; i < layer.getNeuronsCount(); i++) {
            saida.add(layer.getNeuron(i).getOutPut());
        }

        return saida;
    }

    private void shuffle(ArrayList<ArrayList<Double>> inValues, ArrayList<ArrayList<Double>> outValues) {

        Random random = new Random();

        for (int i = 0; i < outValues.size(); i++) {
            int index = random.nextInt(inValues.size());

            ArrayList<Double> inAux = inValues.get(i);
            ArrayList<Double> outAux = outValues.get(i);

            inValues.set(i, inValues.get(index));
            outValues.set(i, outValues.get(index));

            inValues.set(index, inAux);
            outValues.set(index, outAux);
        }
    }

    private ArrayList<ArrayList<Double>> copy(ArrayList<ArrayList<Double>> inValues) {
        ArrayList<ArrayList<Double>> saida = new ArrayList<ArrayList<Double>>();

        for (ArrayList<Double> values : inValues) {
            saida.add(values);
        }

        return saida;
    }

    public boolean isMomentum() {
        return momentum;
    }

    public void setMomentum(boolean momentum) {
        this.momentum = momentum;
    }

    public double adaptEta(double eta) {
        if (1.05 * meanSquaredErrors.get(meanSquaredErrors.size() - 1) > meanSquaredErrors.get(meanSquaredErrors.size() - 2)) {
            return 0.7 * eta;
        } else if (meanSquaredErrors.get(meanSquaredErrors.size() - 1) <= meanSquaredErrors.get(meanSquaredErrors.size() - 2)) {
            return 1.03 * eta;
        } else {
            return eta;
        }
    }

    public boolean isAdaptative() {
        return adaptative;
    }

    public void setAdaptative(boolean adaptative) {
        this.adaptative = adaptative;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.domain.neural;

import java.util.ArrayList;

/**
 *
 * @author Demetrios
 */
public class Layer {

    private ArrayList<Neuron> neurons;
    private Layer backLayer;
    private Layer forwardLayer;
//    private ArrayList<ArrayList<Double>> deltaOmegas;
//    private ArrayList<Double> deltaBias;

    public Layer(ArrayList<Neuron> neurons) {
        this.neurons = neurons;
//        deltaOmegas = new ArrayList<ArrayList<Double>>();
//        deltaBias = new ArrayList<Double>();
    }

    public Layer getBackLayer() {
        return backLayer;
    }

    public void setBackLayer(Layer backLayer) {
        this.backLayer = backLayer;
    }

    public Layer getForwardLayer() {
        return forwardLayer;
    }

    public void setForwardLayer(Layer forwardLayer) {
        this.forwardLayer = forwardLayer;
    }

    public Neuron getNeuron(int i) {
        return neurons.get(i);
    }

    public int getNeuronsCount() {
        return neurons.size();
    }

    public void updateNeuronsWeightedSum(ArrayList<Double> inValues) {

        if (backLayer == null) {
            for (int i = 0; i < neurons.size(); i++) {
                neurons.get(i).setWeightedSum(inValues.get(i));
            }
        } else {
            for (Neuron neuron : neurons) {

                ArrayList<Double> weights = neuron.getWeights();

                double sum = 0;

                for (int i = 0; i < weights.size(); i++) {
                    Double weight = weights.get(i);
                    Neuron backNeuron = backLayer.getNeuron(i);
                    sum += (weight * backNeuron.getOutPut());
                }

                sum += (neuron.getBiasWeight() * neuron.getBias());

                neuron.setWeightedSum(sum);
            }
        }
    }

    public void updateNeuronsGradient(ArrayList<Double> outValues) {
        if (forwardLayer == null) {
            for (int i = 0; i < neurons.size(); i++) {
                Neuron neuron = neurons.get(i);
                neuron.setGradient((outValues.get(i) - neuron.getOutPut()) * neuron.getDerivateOutPut());
            }
        } else {
            for (int i = 0; i < neurons.size(); i++) {
                Neuron neuron = neurons.get(i);

                double sum = 0;

                for (int j = 0; j < backLayer.getNeuronsCount(); j++) {
                    Neuron backNeuron = backLayer.getNeuron(j);
                    sum += (neuron.getWeights().get(j) * backNeuron.getGradient());
                    sum += (neuron.getBiasWeight() * backNeuron.getGradient());
                }
//                for (int j = 0; j < forwardLayer.getNeuronsCount(); j++) {
//                    Neuron fowardNeuron = forwardLayer.getNeuron(j);
//                    sum += (fowardNeuron.getWeights().get(i) * fowardNeuron.getGradient());
//                    sum += (fowardNeuron.getBiasWeight() * fowardNeuron.getGradient());
//                }

                neuron.setGradient(neuron.getDerivateOutPut() * sum);
            }
        }
    }

    public void calculateDeltaOmega(double learnRate, double alpha, boolean momentum) {
        if (backLayer == null) {
            return;
        }

        for (int i = 0; i < neurons.size(); i++) {
            Neuron neuron = neurons.get(i);

//            ArrayList<Double> deltas = new ArrayList<Double>();

            for (int j = 0; j < backLayer.getNeuronsCount(); j++) {
                double delta = 0;

                if (momentum) {
                    delta = alpha * neuron.getOmega(j) + neuron.getGradient() * backLayer.getNeuron(j).getOutPut() * learnRate;
                } else {
                    delta = neuron.getGradient() * backLayer.getNeuron(j).getOutPut() * learnRate;
                }

                neuron.setOmega(j, delta);
//                deltas.add(delta);
            }


            double bi;

            if (momentum) {
                bi = alpha* neuron.getBiasDeltaOmega() + neuron.getGradient() * neuron.getBias() * learnRate;
            } else {
                bi = neuron.getGradient() * neuron.getBias() * learnRate;
            }

            neuron.setBiasDeltaOmega(bi);
//            deltaBias.add(bi);

//            deltaOmegas.add(deltas);
        }

    }

    public void updateWeight() {
        if (backLayer == null) {
            return;
        }

        for (int i = 0; i < neurons.size(); i++) {
            ArrayList<Double> weigths = neurons.get(i).getWeights();
//            ArrayList<Double> omegas = deltaOmegas.get(i);

            for (int j = 0; j < weigths.size(); j++) {
//                weigths.set(j, weigths.get(j) + omegas.get(j));
                weigths.set(j, weigths.get(j) + neurons.get(i).getOmega(j));
            }

//            neurons.get(i).setBiasWeight((neurons.get(i).getBiasWeight() + deltaBias.get(i)));
            neurons.get(i).setBiasWeight((neurons.get(i).getBiasWeight() + neurons.get(i).getBiasDeltaOmega()));
        }
    }
}

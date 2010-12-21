/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufrn.br.controle.neuralnetwork.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import ufrn.br.controle.neuralnetwork.domain.functions.ActivationFunction;
import ufrn.br.controle.neuralnetwork.domain.functions.HyperbolicTangent;
import ufrn.br.controle.neuralnetwork.domain.functions.Linear;
import ufrn.br.controle.neuralnetwork.domain.neural.NeuralNetwork;

/**
 *
 * @author demetrios
 */
public class main {

    private int numbNeuronsIn;
    private int numbNeuronsOut;
    private int numbHiddenNeurons[];
    private int maxItera;
    private double errorQuadra;
    private double learnRate;
    private double porcValidation;
    private ArrayList<ArrayList<Double>> inValues = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> outValues = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> inValiValues = new ArrayList<ArrayList<Double>>();
    private ArrayList<ArrayList<Double>> outValiValues = new ArrayList<ArrayList<Double>>();

    private boolean processLineParams(String line) {

        String[] params = line.split(" ");

        if (params.length >= 6 && params.length <= 8) {

            numbNeuronsIn = Integer.parseInt(params[0]);
            numbNeuronsOut = Integer.parseInt(params[1]);
            maxItera = Integer.parseInt(params[3]);
            errorQuadra = Double.parseDouble(params[4]);
            porcValidation = Double.parseDouble(params[5]);

            if (params.length == 7) {
                numbHiddenNeurons = new int[]{Integer.parseInt(params[6])};
            } else if (params.length == 8) {
                numbHiddenNeurons = new int[]{Integer.parseInt(params[6]), Integer.parseInt(params[7])};
            }

            return true;
        } else {
            System.out.println("LINHA DE PARAMENTROS ERRADO");
            return false;
        }
    }

    private void processLineData(String line) {
        String[] params = line.split(" ");

        ArrayList<Double> inData = new ArrayList<Double>();
        ArrayList<Double> outData = new ArrayList<Double>();

        for (int i = 0; i < params.length; i++) {
            String string = params[i];
            if (i < numbNeuronsIn) {
                inData.add(Double.parseDouble(string));
            } else {
                outData.add(Double.parseDouble(string));
            }
        }

        inValues.add(inData);
        outValues.add(outData);
    }

    public void processFile(File file) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String line = bufferedReader.readLine();

            if (!processLineParams(line)) {
                return;
            }

            while (bufferedReader.ready()) {
                line = bufferedReader.readLine();

                processLineData(line);
            }

            bufferedReader.close();
        } catch (IOException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void prepareValidation() {

        int size = inValues.size();

        int sizeValidation = (int) (size * (porcValidation / 100));

        for (int i = size - 1; i > size - sizeValidation; i--) {
            inValiValues.add(inValues.get(i));
            outValiValues.add(outValues.get(i));
            inValues.remove(i);
            outValues.remove(i);
        }
    }

    public static void main(String args[]) {

        main m = new main();
        m.processFile(new File("output1.txt"));
        m.prepareValidation();


        ActivationFunction af[] = null;

        if (m.numbHiddenNeurons == null) {
            af = new ActivationFunction[2];
            af[1] = new Linear();
        } else {
            af = new ActivationFunction[m.numbHiddenNeurons.length + 2];
            af[m.numbHiddenNeurons.length + 1] = new Linear();

            for (int i = 1; i <= m.numbHiddenNeurons.length; i++) {
                af[i] = new HyperbolicTangent();
            }
        }

        af[0] = new Linear();

        NeuralNetwork network = new NeuralNetwork(m.numbNeuronsIn, m.numbNeuronsOut, m.numbHiddenNeurons, af);
//        network.setMomentum(true);
//        network.setAdaptative(true);
        GraficoSaida graficoSaida = new GraficoSaida(m.numbNeuronsOut);

        JFrame frame = new JFrame();
//        frame.add(graficoSaida.getChart());
        frame.add(network.getGrafico().getChart());
        frame.setVisible(true);
        frame.pack();

        JFrame frame2 = new JFrame();
        frame2.add(graficoSaida.getChart());
//        frame2.add(network.getGrafico().getChart());
        frame2.setVisible(true);
        frame2.pack();

        network.train(m.maxItera, m.errorQuadra, 0.001, 0.1, 0, m.inValues, m.outValues);
        
        for (int i = 0; i < m.inValues.size(); i++) {
            ArrayList<Double> out = network.simulate(m.inValues.get(i));
            graficoSaida.addObservation(i, out.get(0), 0, false);
            graficoSaida.addObservation(i, m.outValues.get(i).get(0), 0, true);
//            System.out.println("Entrada :" + m.inValiValues.get(i));
//            System.out.println("Saida esperada :" + m.outValiValues.get(i));
//            System.out.println("Saida da Rede :" + out);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.domain;

import java.text.DecimalFormat;
import r2d2e.solution.tanksimulator.handler.MainViewHandler;

/**
 *
 * @author demetrios
 */
public class QuanserDriver {

    private static final String ACK = "ACK";
    private static final String WRONG_SENSOR_CHANNEL = "-5001";
    private static final String ERROR = "ERROR";
    private static final int VOLT_FACTOR = 5;
    private static final double COEF = 6.25;
    private Simulation simulation;
    private MainViewHandler handler;

    public QuanserDriver(Simulation simulation, MainViewHandler handler) {
        this.simulation = simulation;
        this.handler = handler;
    }

    public synchronized String readFromSensor(String channel, int ID) {
        int cha = convertToInt(channel, ID);
        switch (cha) {
            case 0:
                return readFromSensor1(ID);
            case 1:
                return readFromSensor2(ID);
            default:
                Logger.println("Canal do sensor nao conhecido ID = " + ID);
                return WRONG_SENSOR_CHANNEL;
        }
    }

    public synchronized String writeAtBomb(String channel, String volt, int ID) {
        boolean ok = verifyVoltage(volt, ID);
        if(!ok){
            return ERROR;
        }
        int cha = convertToInt(channel, ID);
        switch (cha) {
            case 0:
                writeAtBomb1(volt, ID);
                break;
            case 1:
                writeAtBomb2(volt, ID);
                break;
            default:
                Logger.println("Canal da bomba nao conhecido ID = " + ID);
                return ERROR;
        }
        return ACK;
    }

    private String readFromSensor1(int ID) {
        double water = simulation.getWaterLevel1();
        Logger.println("Ler do sensor 1. Nível da água em " + water + " cm. ID = " + ID);
        water /= COEF;
        return Double.toString(water);
    }

    private String readFromSensor2(int ID) {
        double water = simulation.getWaterLevel2();
        Logger.println("Ler do sensor 2. Nível da água em " + water + " cm. ID = " + ID);
        water /= COEF;
        return Double.toString(water);
    }

    private void writeAtBomb1(String volt, int ID) {
        double tensao = convertToDouble(volt, ID);
        simulation.setTensao(tensao * VOLT_FACTOR);
        UpdateStatus.updateSatus(UpdateStatus.GREEN_STATUS, "Simulação rodando.");
    }

    private void writeAtBomb2(String volt, int ID) {
    }

    private int convertToInt(String string, int ID) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException ex) {
            Logger.println("nao pode converter para int. ID =" + ID);
            return -1;
        }
    }

    private double convertToDouble(String string, int ID) {
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException ex) {
            Logger.println("can't convert to double ID =" + ID);
            return -1;
        }
    }

    private boolean verifyVoltage(String volt, int ID) {
        double tensao = convertToDouble(volt, ID);
        if (tensao > 3) {
            Logger.println("Tensao acima de 15 volt ID = " + ID);
            UpdateStatus.updateSatus(UpdateStatus.RED_STATUS, "TENSAO ACIMA DE 15 V!!!!!");
            handler.turnOff();
            return false;
        }
        if (tensao < -3) {
            Logger.println("Tensao abaixo de -15 volt ID = " + ID);
            UpdateStatus.updateSatus(UpdateStatus.RED_STATUS, "TENSAO ABAIXO DE -15 V!!!!!");
            handler.turnOff();
            return false;
        }
        return true;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.quanser;

import br.ufrn.controle.fuzzycontroller.quanser.QuanserClient;
import br.ufrn.controle.fuzzycontroller.quanser.QuanserClientException;

/**
 *
 * @author Demétrios
 */
public class Quanser {

    private QuanserClient quanserClient;
    private static String IP_QUANSER = "10.13.99.69";
    private static int PORT_QUANSER = 20081;//20081;
    private static int CHANNEL_BOMB = 0;
    private static double CALIBRATION1 = 0.0;//2.0;
    private static double CALIBRATION2 = 0.0;
    private static double VOLT_TO_LEVEL = 6.25;

    public Quanser() {
    }

    public void connect() {
        try {
            quanserClient = new QuanserClient(IP_QUANSER, PORT_QUANSER);
        } catch (QuanserClientException e) {
            System.out.println("Nao foi possível conectar com o servidor");
        }
    }

    public void writeBomb(double volt) {
        try {
            quanserClient.write(CHANNEL_BOMB, volt);
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
    }

    public double readSensor1() {
        double read = 0.0;
        try {
            read = quanserClient.read(0);
            read *= VOLT_TO_LEVEL;
            read -= CALIBRATION1;
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
        return read;
    }

    public double readSensor2() {
        double read = 0.0;
        try {
            read = quanserClient.read(1);
            read *= VOLT_TO_LEVEL;
            read -= CALIBRATION2;
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
        return read;
    }

    public boolean isServerOk() {
        return (quanserClient != null);
    }

    public void closeConnection() {
        try {
            if (quanserClient != null) {
                quanserClient.closeConnection();
            }
        } catch (QuanserClientException ex) {
            ex.printStackTrace();
        }
    }

    public void stopMotor() {
        writeBomb(0);
    }

    public static void setCALIBRATION1(double CALIBRATION1) {
        Quanser.CALIBRATION1 = CALIBRATION1;
    }

    public static void setCALIBRATION2(double CALIBRATION2) {
        Quanser.CALIBRATION2 = CALIBRATION2;
    }

    public static double getCALIBRATION1() {
        return CALIBRATION1;
    }

    public static double getCALIBRATION2() {
        return CALIBRATION2;
    }

    public static String getIP_QUANSER() {
        return IP_QUANSER;
    }

    public static void setIP_QUANSER(String IP_QUANSER) {
        Quanser.IP_QUANSER = IP_QUANSER;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import r2d2e.solution.moduloteste.quanser.QuanserClient;
import r2d2e.solution.moduloteste.quanser.QuanserClientException;

/**
 *
 * @author Demétrios
 */
public class Quanser {

    private QuanserClient quanserClient;
    public static String IP_QUANSER = "10.13.99.69";
    public static int PORT_QUANSER = 20081;//20081;
    private static int CHANNEL_BOMB = 0;
    private static double CALIBRATION1 = 0.0;//2.0;
    private static double CALIBRATION2 = 0.0;
    private static double VOLT_TO_LEVEL = 6.25;
    private static boolean SOMAR1 = true;
    private static boolean SOMAR2 = true;

    public Quanser() {
        try {
            quanserClient = new QuanserClient(IP_QUANSER, PORT_QUANSER);
        } catch (QuanserClientException e) {
            e.printStackTrace();
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
            if (SOMAR1) {
                read += CALIBRATION1;
            } else {
                read -= CALIBRATION1;
            }
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
            if (SOMAR2) {
                read += CALIBRATION2;
            } else {
                read -= CALIBRATION2;
            }
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
            quanserClient.closeConnection();
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

    public static void setSOMAR1(boolean SOMAR1) {
        Quanser.SOMAR1 = SOMAR1;
    }

    public static void setSOMAR2(boolean SOMAR2) {
        Quanser.SOMAR2 = SOMAR2;
    }
    
}

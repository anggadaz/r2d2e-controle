/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package r2d2e.solution.moduloteste.domain;

import br.ufrn.dca.controle.QuanserClient;
import br.ufrn.dca.controle.QuanserClientException;

/**
 *
 * @author Demétrios
 */
public class Quanser {

    private QuanserClient quanserClient;
    public static String IP_QUANSER = "10.13.99.69";
    public static int PORT_QUANSER = 20081;
    private static int CHANNEL_BOMB = 0;
    private static double CALIBRATION1 = 2.0;
    private static double CALIBRATION2 = 0.0;
    private static double VOLT_TO_LEVEL = 6.25;
    
    public Quanser() {
        try {
            quanserClient = new QuanserClient(IP_QUANSER, PORT_QUANSER);
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }         
    }
    
    public void writeBomb(double volt){
         try {
            quanserClient.write(CHANNEL_BOMB, volt);
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
    }

    public double readSensor1(){
        double read = 0.0;
        try {
            read =  quanserClient.read(0)* VOLT_TO_LEVEL + CALIBRATION1;
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
        return read;
    }
    public double readSensor2(){
        double read = 0.0;
        try {
            read =  quanserClient.read(0)* VOLT_TO_LEVEL + CALIBRATION2;
        } catch (QuanserClientException e) {
            e.printStackTrace();
        }
        return read;
    }
}

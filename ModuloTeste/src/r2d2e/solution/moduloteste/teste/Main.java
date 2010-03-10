/*
 * Main.java
 *
 * Created on March 14, 2008, 4:18 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.teste;

import br.ufrn.dca.controle.QuanserClient;
import br.ufrn.dca.controle.QuanserClientException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Leo
 */
public class Main {

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double a = 1.5;
        System.out.println(a);

        new Thread() {
            public void run() {
                QuanserClient quanserClient;
                try {
                    quanserClient = new QuanserClient("10.13.99.69", 20081);
//                    double _read = quanserClient.read(0);
//                    System.out.println("Leitura Canal 0: " + _read)
                    System.out.println("Gravando 1.2 volts no canal 4...");
                    boolean f = true;
                    while(f){
                        quanserClient.write(0, 1.5);
                        double _read = quanserClient.read(0);
                        System.out.println("Leitura Canal 0: " + (_read*6.25+2.0));
                    }
                    System.out.println("Morri");
                } catch (QuanserClientException ex) {
                    ex.printStackTrace();
                }
        }
        }.start();
    }
}

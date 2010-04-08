package r2d2e.solution.moduloteste.teste;


import java.util.logging.Level;
import java.util.logging.Logger;
import org.openide.util.Exceptions;
import r2d2e.solution.moduloteste.domain.Quanser;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author demetrios
 */
public class Teste extends Thread {

    public Teste() {
    }

    @Override
    public void run() {
        Quanser quanser = new Quanser();
        quanser.writeBomb(0);
        try {
            sleep(2000);
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
//        for (int i = 0; i < 5; i++) {
//            double q = quanser.readSensor1();
//            System.out.println("q " + q);
//            try {
//                sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            double q2 = quanser.readSensor1();
//            System.out.println("q2 " + q2);
//        }
//        quanser.writeBomb(2);
//        try {
//            sleep(3000);
//        } catch (InterruptedException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//        quanser.writeBomb(0.0);
//        try {
//            sleep(3000);
//        } catch (InterruptedException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//        quanser.writeBomb(3);
//        try {
//            sleep(5000);
//        } catch (InterruptedException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//        quanser.writeBomb(3.0);
//        try {
//            sleep(1000);
//        } catch (InterruptedException ex) {
//            Exceptions.printStackTrace(ex);
//        }
//        quanser.writeBomb(5);
        quanser.closeConnection();
    }


    public static void main(String args[]) {
        Teste t = new Teste();
        t.start();
    }
}

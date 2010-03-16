/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.openide.util.Exceptions;

/**
 *
 * @author demetrios
 */
public class ThreadCycle extends Thread {

    private double nivelAgua;
    private Double tensaoAtual;
    private long initTime;
    private Quanser quanser;
    private Timer t;
    
    public ThreadCycle(double tensao, double nivelAgua, Quanser quanser) {
        tensaoAtual = tensao;
        this.nivelAgua = nivelAgua;
        this.quanser = quanser;
    }

    @Override
    public void run() {
            initTime = System.currentTimeMillis();
            quanser.writeBomb(tensaoAtual);
            t = new Timer(100, null);
            final FillTank fillTank = new FillTank(quanser, t, tensaoAtual, initTime, nivelAgua);
            t.addActionListener(fillTank);
            t.start();
    }

    public void stopTimer(){
        t.stop();
    }
}

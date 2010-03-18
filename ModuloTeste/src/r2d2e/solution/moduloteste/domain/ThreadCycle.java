
package r2d2e.solution.moduloteste.domain;

import javax.swing.Timer;

/**
 *
 * @author Rivaldo
 */

public class ThreadCycle extends Thread {

    private double nivelAgua;
    private Double tensaoAtual;
    private Quanser quanser;

    private FillTank fillTank;
    
    public ThreadCycle(double tensao, double nivelAgua, Quanser quanser) {
        tensaoAtual = tensao;
        this.nivelAgua = nivelAgua;
        this.quanser = quanser;

        fillTank = new FillTank(quanser,100,tensao, nivelAgua);
    }

    @Override
    public void run() {

        quanser.writeBomb(tensaoAtual);
        
        fillTank.setInitTime(System.currentTimeMillis());
        fillTank.start();

    }

    public void stopTimer(){
        fillTank.stop();
    }
}

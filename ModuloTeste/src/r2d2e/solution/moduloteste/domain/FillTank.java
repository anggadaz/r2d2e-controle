/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author demetrios
 */
public class FillTank implements ActionListener {

    private Quanser quanser;
    private Timer time;
    private double nivelAqua;
    private double tensaoAtual;
    private double initTime;
    private double stopTime;
    
    public FillTank(Quanser quanser,Timer time,double tensaoAtual,double initTime,double nivelAqua){
        this.quanser = quanser;
        this.time = time;
        this.nivelAqua = nivelAqua;
        this.tensaoAtual = tensaoAtual;
        this.initTime = initTime;
    }

    public void actionPerformed(ActionEvent e) {
        double nivel = quanser.readSensor1();
        controlerInterface.tanquePanelUpdate(nivel);
        if (nivel >= nivelAqua) {
            stopTime = System.currentTimeMillis();
            quanser.writeBomb(0);
            double timeTotal = getTime();
            controlerInterface.updateTable(tensaoAtual, timeTotal, nivelAqua);
            controlerInterface.tanquePanelDry(quanser);
            controlerInterface.verifyTestEnd();
            time.stop();
        }
    }
    public double getTime() {
        return (double) ((stopTime - initTime) / 1000);
    }
}

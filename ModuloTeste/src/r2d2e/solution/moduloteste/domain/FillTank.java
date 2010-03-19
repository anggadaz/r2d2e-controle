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
public class FillTank extends Timer implements ActionListener {

    private Quanser quanser;
    private double nivelAqua;
    private double tensaoAtual;
    private long initTime;
    private long stopTime;


    public FillTank(Quanser quanser, int delay, double tensaoAtual, double nivelAqua) {

        super(delay, null);
        addActionListener(this);

        this.quanser = quanser;

        this.nivelAqua = nivelAqua;
        this.tensaoAtual = tensaoAtual;
        this.initTime = System.currentTimeMillis();

        controlerInterface.histoChart.clear();
    }

    public void actionPerformed(ActionEvent e) {

        double nivel = quanser.readSensor1();

        controlerInterface.tanquePanelUpdate(nivel);
        controlerInterface.histoChart.addNivelObservation(System.currentTimeMillis()-initTime, nivel);

        if (nivel >= nivelAqua) {
            stopTime = System.currentTimeMillis();

            quanser.writeBomb(0);
            double timeTotal = getTime();

            controlerInterface.barChart.addSeries(tensaoAtual, timeTotal);
            controlerInterface.updateBarChart();

            controlerInterface.updateTable(tensaoAtual, timeTotal, nivelAqua);
            controlerInterface.tanquePanelDry(quanser);
            controlerInterface.verifyTestEnd();
            stop();
        }
    }

    public void setInitTime(long init) {
        initTime = init;
    }

    public long getTime() {
        return (long) ((stopTime - initTime) / 1000);
    }
}

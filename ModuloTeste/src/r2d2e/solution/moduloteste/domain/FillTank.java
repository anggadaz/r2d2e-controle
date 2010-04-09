/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import r2d2e.solution.moduloteste.handler.TestModeHandler;

/**
 *
 * @author demetrios
 */
public class FillTank extends Timer implements ActionListener {

    private Quanser quanser;
    private double nivelAqua;
    private double tensaoAtual;
    private double initTime;
    private double stopTime;
    private long initT;

    public FillTank(Quanser quanser, int delay, double tensaoAtual, double nivelAqua) {

        super(delay, null);
        addActionListener(this);

        this.quanser = quanser;

        this.nivelAqua = nivelAqua;
        this.tensaoAtual = tensaoAtual;
        this.initTime = System.currentTimeMillis();
        this.initT = System.currentTimeMillis();

        TestModeHandler.histoChart.clear();
    }

    public void actionPerformed(ActionEvent e) {

        double nivel = quanser.readSensor1();
        if (nivel < 0) {
            nivel = 0;
        }
        controlerInterface.tanquePanelUpdate(nivel);
        TestModeHandler.histoChart.addNivelObservation(System.currentTimeMillis()-initT, nivel);
        if (nivel >= nivelAqua) {
            stopTime = System.currentTimeMillis();

            quanser.writeBomb(0);
            double timeTotal = getTime();

            TestModeHandler.barChart.addSeries(tensaoAtual, timeTotal);

            controlerInterface.updateTable(tensaoAtual, timeTotal, nivelAqua);
            controlerInterface.tanquePanelDry(quanser);
            controlerInterface.verifyTestEnd();
            stop();
        }
    }

    public void setInitTime(double init) {
        initTime = init;
    }

    public double getTime() {
        return (double) ((stopTime - initTime) / 1000);
    }
}

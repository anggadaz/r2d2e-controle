/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

/**
 *
 * @author demetrios
 */
public class ThreadCycle extends Thread{

    private double tensaoMax;
    private double tensaoMin;
    private double tensaoStep;
    private double nivelAgua;
    private Double tensaoAtual;
    private long initTime;
    private long stopTime;
    private boolean rodando = false;
    private Quanser quanser;
    
    public ThreadCycle(Double tensaoMax, Double tensaoMin, Double tensaoStep, Double nivelAgua,Quanser quanser) {
        this.tensaoMax = tensaoMax;
        this.tensaoMin = tensaoMin;
        this.tensaoStep = tensaoStep;
        this.nivelAgua = nivelAgua;
        this.quanser = quanser;
    }

    public void run() {
        if (tensaoAtual == null) {
            tensaoAtual = tensaoMin;
        } else {
            tensaoAtual += tensaoStep;
        }

        if (tensaoAtual >= tensaoMax) {
            rodando = false;
        } else {
            rodando = true;
            initTime = System.currentTimeMillis();
        }

        while (rodando) {
            quanser.writeBomb(tensaoAtual);
            double nivel = quanser.readSensor1();
            System.out.println("nivel " + nivel);
            controlerInterface.tanquePanelUpdate(nivel);
            if (nivel >= nivelAgua) {
                quanser.writeBomb(0);
                controlerInterface.tanquePanelDry(quanser);
                rodando = false;
                stopTime = System.currentTimeMillis();
                System.out.println("TIME " + getTime()+ " s");
            }
        }
        
    }

    public boolean isRodando() {
        return rodando;
    }

    public void setRodando(boolean rodando) {
        this.rodando = rodando;
    }
    public int getTime(){
        return (int) ((stopTime-initTime) / 1000);
    }

    public Double getTensaoAtual() {
        return tensaoAtual;
    }
    
}

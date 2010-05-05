/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.analise;

/**
 *
 * @author demetrios
 */
public class PeakTime {

    private double initTime;
    private double time = 0;
    private double nivelAnterior;
    private double setpointAnterior = 0.0;
    private boolean initTimeUpdated = true;
    private double peakValue = 0.0;

    public PeakTime() {
        this.initTime = System.currentTimeMillis();
    }

    public double calcPeakTime(double setPoint, double nivelAtual) {

        updateInitTime(setPoint);

        peakValue = getPeakValue(setPoint, nivelAtual);

        if (peakValue != 0.0) {
            time = convertToTwoPlaces(System.currentTimeMillis() - initTime) / 1000;
        }

        System.out.println("TIME " + time);
        System.out.println("peakValue " + peakValue);
        return time;
    }

    private double getPeakValue(double setPoint, double nivelAtual) {
        double peakValueTemp = 0.0;
        if (setPoint > setpointAnterior) {
            if (nivelAtual > setPoint) {
                if (nivelAtual >= nivelAnterior) {
                    nivelAnterior = nivelAtual;
                } else {
                    setpointAnterior = setPoint;
                    peakValueTemp = nivelAnterior;
                }
            }
        } else {
            if (setPoint < setpointAnterior) {
                if (nivelAtual < setPoint) {
                    if (nivelAtual <= nivelAnterior) {
                        nivelAnterior = nivelAtual;
                    } else {
                        setpointAnterior = setPoint;
                        peakValueTemp = nivelAnterior;
                    }
                }
            }
        }
        return peakValueTemp;
    }

    public double getInitTime() {
        return initTime;
    }

    public void setInitTime(double initTime) {
        this.initTime = initTime;
    }

    public double convertToTwoPlaces(double num) {
        num *= 100;
        num = Math.floor(num);
        num /= 100;
        return num;
    }

    private void updateInitTime(double setPoint) {
        System.out.println("SETPOINT " + setPoint);
        System.out.println("SETPOINTANT " + setpointAnterior);
        if (setPoint != setpointAnterior) {
            if (!initTimeUpdated) {
                System.out.println("atualizando tempo");
                initTime = System.currentTimeMillis();
                initTimeUpdated = true;
            }
        } else {
            initTimeUpdated = false;
        }
    }
}

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

    private double setPointAnt;
    private double initTime;
    private double nivelAnt = -100;
    private double time = 0;
    private boolean weGotIt = false;
    private boolean rising = true;

    public PeakTime(double setPointAnt) {
        this.setPointAnt = setPointAnt;
        this.initTime = System.currentTimeMillis();
    }

    public double calcPeakTime(double setPoint, double nivel) {

        System.out.println("SETPOINT " + setPoint);
        System.out.println("SETPOINTANT " + setPointAnt);
        System.out.println("NIVEL " + nivel);
        System.out.println("NIVELANT " + nivelAnt);

        if (setPoint == setPointAnt) {
            if (!weGotIt) {
                if (criterio(nivel)) {
                    time = System.currentTimeMillis() - initTime;
                }
            }
        } else {

            initTime = System.currentTimeMillis();

            risingUpdate(setPoint);

            setPointAnt = setPoint;

            time = 0;

            weGotIt = false;
        }
        double s = convertToTwoPlaces(time / 1000);
        System.out.println("TIME " + s);
        return s;
    }

    public double getInitTime() {
        return initTime;
    }

    public void setInitTime(double initTime) {
        this.initTime = initTime;
    }

    public double getSetPointAnt() {
        return setPointAnt;
    }

    public void setSetPointAnt(double setPointAnt) {
        this.setPointAnt = setPointAnt;
    }

    private boolean criterio(double nivel) {
        if (rising) {
            System.out.println("RISING");
            if (nivel+0.2 >= nivelAnt) {
                System.out.println("true");
                nivelAnt = nivel;
                return true;
            } else {
                System.out.println("false");
                weGotIt = true;
                return false;
            }
        } else {
            System.out.println("NOT RISING");
            if (nivel <= nivelAnt) {
                System.out.println("true");
                nivelAnt = nivel;
                return true;
            } else {
                System.out.println("false");
                weGotIt = true;
                return false;
            }
        }
    }

    public double convertToTwoPlaces(double num) {
        num *= 100;
        num = Math.floor(num);
        num /= 100;
        return num;
    }

    private void risingUpdate(double setPoint) {
        if (setPoint > setPointAnt) {
            rising = true;
        } else {
            rising = false;
        }
    }
}

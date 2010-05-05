/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.analise;

/**
 *
 * @author demetrios
 */
public class RiseTime {

    private double setPointAnt;
    private double initTime;
    private double time = 0;
    private boolean weGotIt = false;
    private boolean rising = true;

    public RiseTime(double setPointAnt) {
        this.setPointAnt = setPointAnt;
        this.initTime = System.currentTimeMillis();
    }

    public double calcRiseTime(double setPoint, double nivel) {

        if (setPoint == setPointAnt) {
            if (criterio(nivel, setPoint) && !weGotIt) {
                time = System.currentTimeMillis() - initTime;
                weGotIt = true;
            }
        } else {
            initTime = System.currentTimeMillis();

            risingUpdate(setPoint);

            setPointAnt = setPoint;

            time = 0;

            weGotIt = false;
        }
        
        return convertToTwoPlaces(time / 1000);
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

    private boolean criterio(double nivel, double setPoint) {
        if (rising) {
            if (nivel >= setPoint) {
                return true;
            } else {
                return false;
            }
        } else {
            if (nivel <= setPoint) {
                return true;
            } else {
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

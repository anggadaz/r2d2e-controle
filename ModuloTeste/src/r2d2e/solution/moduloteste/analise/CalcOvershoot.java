package r2d2e.solution.moduloteste.analise;

import r2d2e.solution.moduloteste.domain.controlerInterface;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author controle
 */
public class CalcOvershoot {

    public Double nivelAnterior = 0.0;
    public boolean overshootOK = false;
//    public Double setpointAnterior = 0.0;
//    public Double referencia = 0.0;
    public Double overShoot = null;
    public static boolean passouPeloSetPoint = false;

    public CalcOvershoot() {
    }

    public boolean isOvershootOK() {
        return overshootOK;
    }

//    public Double getSetpointAnterior() {
//        return setpointAnterior;
//    }
    public Double CalcOvershoot(Double nivelAtual, Double setPoint, Double setPointAnterior) {

        if (setPoint > setPointAnterior) {

            if (nivelAtual > setPoint) {
                if (nivelAtual >= nivelAnterior) {
                    nivelAnterior = nivelAtual;
                    overShoot = null;
                } else {
                    overShoot = nivelAnterior;
                }
            }
        }

        if (setPoint < setPointAnterior) {
            if (nivelAtual < setPoint) {
                if (nivelAtual < nivelAnterior) {
                    nivelAnterior = nivelAtual;
                    overShoot = null;
                } else {
                    overShoot = nivelAnterior;
                }
            }
        }
        return overShoot;
    }

    public Double calcPercentOvershoot(Double nivelAtual) {
        double setPoint = controlerInterface.SETPOINT;
        double setPointAnterior = controlerInterface.SETPOINT_ANTERIOR;

        Double over = CalcOvershoot(nivelAtual, setPoint, setPointAnterior);

        if (over == null) {
            return null;
        } else {
            Double ret;

            System.out.println("OVER " + over);
            System.out.println("SETPOINT " + setPoint);
            System.out.println("REFERENCIA " + setPointAnterior);

            if (over >= setPoint) {
                ret = (((over - setPoint) * 100) / Math.abs(setPoint - setPointAnterior));
            } else {
                ret = (((setPoint - over) * 100) / Math.abs(setPoint - setPointAnterior));
            }
            return ret;
        }
    }
}

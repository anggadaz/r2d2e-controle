package r2d2e.solution.moduloteste.analise;

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
    public Double setpointAnterior = 0.0;

    public CalcOvershoot() {
    }

    public boolean isOvershootOK() {
        return overshootOK;
    }

    public Double getSetpointAnterior() {
        return setpointAnterior;
    }

    public Double CalcOvershoot(Double setpoint, Double nivelAtual) {
        if(setpoint > setpointAnterior) {

            if (nivelAtual > setpoint) {
                if (nivelAtual >= nivelAnterior) {
                    nivelAnterior = nivelAtual;
                } else {
                    setpointAnterior = setpoint;
                    return nivelAnterior;
                }
            }
        }

        if(setpoint < setpointAnterior) {

            if (nivelAtual < setpoint) {
                if (nivelAtual < nivelAnterior) {
                    nivelAnterior = nivelAtual;
                } else {
                    setpointAnterior = setpoint;
                    return nivelAnterior;
                }
            }
        }

        return null;
    }
    
    public void clear() {
        nivelAnterior = setpointAnterior = 0.0;
        overshootOK = false;
    }

    public Double CalcPercentOvershoot(Double setpoint, Double nivelAtual){
        Double over = CalcOvershoot(setpoint, nivelAtual);

        if(over == null){
            return null;
        }
        else{
            Double ret;
            if(over >= setpoint ){
                ret = (((over-setpoint)*100)/setpoint);
                System.out.println("oversoot: " + over);
                System.out.println("oversoot(%): " + ret);
            }
            else{
                ret = (((setpoint-over)*100)/setpoint);
                System.out.println("oversoot: " + over);
                System.out.println("oversoot(%): " + ret);
            }
            return ret;
        }
    }
}
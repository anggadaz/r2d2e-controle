package r2d2e.solution.moduloteste.analise;

import r2d2e.solution.moduloteste.domain.controlerInterface;

/**
 *
 * @author Rivaldo Jr
 */
public class CalcOvershoot {

    public static final int NONE = 0;
    public static final int CALCULANDO = 1;
    public static final int FINALIZADO = 2;

    private int estado = NONE;

    private Double nivelAnterior = 0.0;
    
    private Double setpointAtual = 0.0;
    private Double setpointAnterior = 0.0;

    public CalcOvershoot(Double set) {
        controlerInterface.atualizarOverShoot(0.0);
        setSetpoint(set);
    }

    public void setSetpoint(Double set) {
        if(set != null) {
            setpointAnterior = setpointAtual;
            setpointAtual = set;
            estado = NONE;
        }
    }

    public void CalcOvershoot(Double nivelAtual) {
        
        // Overshoot já calculado
        if(estado == FINALIZADO) {
            return;
        }

        // Calcula nível máximo
        if (setpointAtual > setpointAnterior) {

            // Eita piula, passou do setpoint, vou calcular
            if (nivelAtual > setpointAtual) {

                estado = CALCULANDO;

                // Achei um maior
                if (nivelAtual > nivelAnterior) {
                    nivelAnterior = nivelAtual;
                } else { // Diminiu então pode ser tu
                    Double over = calcPercentOvershoot(nivelAnterior);
                    controlerInterface.atualizarOverShoot(over);
                }

            } else {

                // Subiu do setpoint e depois desceu, não calculo mais
                if( estado == CALCULANDO) {
                    estado = FINALIZADO;
                }

            }
        }

        // Calcula nível mínimo
        if (setpointAtual < setpointAnterior) {

            // Eita piula, passou do setpoint, vou calcular
            if (nivelAtual < setpointAtual) {

                estado = CALCULANDO;

                // Achei um menor
                if (nivelAtual < nivelAnterior) {
                    nivelAnterior = nivelAtual;
                } else { // Diminiu então pode ser tu
                    Double over = calcPercentOvershoot(nivelAnterior);
                    controlerInterface.atualizarOverShoot(over);
                }
            } else {

                // Desceu do setpoint e depois subiu, não calculo mais
                if( estado == CALCULANDO) {
                    estado = FINALIZADO;
                }
            }
        }

    }

    private Double calcPercentOvershoot(Double over) {

        if (over == null) {
            return null;
        } else {
            Double ret;

            System.out.println("OVER " + over);
            System.out.println("SETPOINT " + setpointAtual);
            System.out.println("REFERENCIA " + setpointAnterior);

            if (over >= setpointAtual) {
                ret = (((over - setpointAtual) * 100) / Math.abs(setpointAtual - setpointAnterior));
            } else {
                ret = (((setpointAtual - over) * 100) / Math.abs(setpointAtual - setpointAnterior));
            }
            return ret;
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.analise;

import r2d2e.solution.moduloteste.domain.controlerInterface;

/**
 *
 * @author demetrios
 */
public class PeakTime {

    public static final int NONE = 0;
    public static final int CALCULANDO = 1;
    public static final int FINALIZADO = 2;

    private int estado = NONE;
    private Long initTime = null;
    private Long finalTime = 0l;

    private Double nivelAnterior = 0.0;

    private Double setpointAtual = 0.0;
    private Double setpointAnterior = 0.0;

    public PeakTime(Double set) {
        controlerInterface.atualizarPeakTime(0.0);
        setSetpoint(set);
    }

    public void setSetpoint(Double set) {
        if(set != null) {
            setpointAnterior = setpointAtual;
            setpointAtual = set;
            initTime = null;
            finalTime = 0l;
            estado = NONE;
        }
    }

    public void calcPeakTime(Double nivelAtual) {

        if(estado == FINALIZADO) {
            return;
        }

        if(initTime == null) {
            initTime = System.currentTimeMillis();
            System.out.println("NOVO INIT TIME " + initTime);
        }

        // Calcula nível máximo
        if (setpointAtual > setpointAnterior) {

            // Eita piula, passou do setpoint, vou calcular
            if (nivelAtual > setpointAtual) {

                estado = CALCULANDO;

                // Achei um maior
                if (nivelAtual > nivelAnterior) {
                    nivelAnterior = nivelAtual;
                    finalTime = System.currentTimeMillis();
                } else { // Diminiu então pode ser tu
                    Double time = convertToTwoPlaces(finalTime - initTime) / 1000;
                    controlerInterface.atualizarPeakTime(time);
                    System.out.println("TEMPO FINAL " + finalTime);
                    System.out.println("TIME " + time);
                    System.out.println("NIVELPICO " + nivelAnterior);
                }

            } else {

                // Subiu do setpoint e depois desceu, não calculo mais
                /*if( estado == CALCULANDO) {
                    estado = FINALIZADO;
                }*/

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
                    Double time = convertToTwoPlaces(System.currentTimeMillis() - initTime) / 1000;
                    controlerInterface.atualizarPeakTime(time);
                }
            } else {

                // Desceu do setpoint e depois subiu, não calculo mais
                /*if( estado == CALCULANDO) {
                    estado = FINALIZADO;
                }*/
            }
        }

    }

    public double convertToTwoPlaces(double num) {
        num *= 100;
        num = Math.floor(num);
        num /= 100;
        return num;
    }

}

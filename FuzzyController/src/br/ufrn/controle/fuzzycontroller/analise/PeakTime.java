/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.analise;

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
        setSetpoint(set);
    }

    private void setSetpoint(Double set) {
        if (set != null) {
            setpointAnterior = setpointAtual;
            setpointAtual = set;
            initTime = null;
            finalTime = 0l;
            estado = NONE;
        }
    }

    public void calcPeakTime(Double nivelAtual) {

        if (estado == FINALIZADO) {
            return;
        }

        if (initTime == null) {
            initTime = System.currentTimeMillis();
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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.domain;

/**
 *
 * @author demetrios
 */
public class PlantModel {
    public static final int NIVEL_MAX = 33;

    private double nivel1Ante = 0;
    private double nivel1Atual = 0;
    private double nivel2 = 0;
    private double tensao = 0;
    private double tensaoAnte = 0;
    private boolean allowFlowOut1 = true;
    private boolean allowFlowOut2 = true;
    private boolean pause = false;

    public PlantModel() {
    }

    public double getNivelAtualTank1() {

        double tensaoTemp = tensao;
        double tensaoAnteTemp = tensaoAnte;

        if (pause) {
            tensaoTemp = 0.0;
            tensaoAnteTemp = 0.0;
        }

        double coefAgua;

        if (allowFlowOut1) {
            coefAgua = 0.9935;
        } else {
            coefAgua = 1;
        }

        nivel1Ante = nivel1Atual;

        double temp = coefAgua * nivel1Ante + 0.0148 * (tensaoTemp + tensaoAnteTemp);

        if (temp < NIVEL_MAX) {
            nivel1Atual = temp;
        }

        tensaoAnte = tensao;

        return nivel1Atual;
    }

    public double getNivelAtualTank2() {

        double nivel1AtualTemp = nivel1Atual;
        double nivel1AnteTemp = nivel1Ante;

        if (pause) {
            nivel1AtualTemp = 0.0;
            nivel1AnteTemp = 0.0;
        }

        double coefAgua;

        if (allowFlowOut2) {
            coefAgua = 0.9935;
        } else {
            coefAgua = 1;
        }

        double nivel1 = 0.0;
        if (allowFlowOut1) {
            nivel1 = nivel1AtualTemp + nivel1AnteTemp;
        } else {
            nivel1 = 0.0;
        }

        double temp = coefAgua * nivel2 + 0.0033 * nivel1;

        if (temp < NIVEL_MAX) {
            nivel2 = temp;
        }

        return nivel2;
    }

    public double getTensao() {
        return tensao;
    }

    public void setTensao(double tensaoAtual) {
        tensaoAnte = tensao;
        this.tensao = tensaoAtual;
    }

    public boolean isAllowFlowOut1() {
        return allowFlowOut1;
    }

    public void setAllowFlowOut1(boolean allowFlowOut1) {
        this.allowFlowOut1 = allowFlowOut1;
    }

    public boolean isAllowFlowOut2() {
        return allowFlowOut2;
    }

    public void setAllowFlowOut2(boolean allowFlowOut2) {
        this.allowFlowOut2 = allowFlowOut2;
    }

    public double getNivel1() {
        return nivel1Atual;
    }

    public double getNivel2() {
        return nivel2;
    }

    public boolean isPause() {
        return pause;
    }

    public void setPause(boolean pause) {
        this.pause = pause;
    }
}

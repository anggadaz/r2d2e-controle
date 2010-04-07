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

    private double nivel1Ante = 0;
    private double nivel1Atual = 0;
    private double nivel2 = 0;
    private double tensao = 0;
    private double tensaoAnte = 0;
    private boolean allowFlowOut1 = true;
    private boolean allowFlowOut2 = true;

    public PlantModel() {
    }

    public double getNivelAtualTank1() {

        double coefAgua;

        if (allowFlowOut1) {
            coefAgua = 0.9935;
        } else {
            coefAgua = 1;
        }

        nivel1Ante = nivel1Atual;

        double temp = coefAgua * nivel1Ante + 0.0148 * (tensao + tensaoAnte);

        if (temp <= 34) {
            nivel1Atual = temp;
        }

        tensaoAnte = tensao;

        return nivel1Atual;
    }

    public double getNivelAtualTank2() {

        double coefAgua;

        if (allowFlowOut2) {
            coefAgua = 0.9935;
        } else {
            coefAgua = 1;
        }

        double nivel1 = 0.0;
        if (allowFlowOut1) {
            nivel1 = nivel1Atual + nivel1Ante;
        } else {
            nivel1 = 0.0;
        }
        
        double temp = coefAgua * nivel2 + 0.0033 * nivel1;

        if (temp <= 34) {
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
}

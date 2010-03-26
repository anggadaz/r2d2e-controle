/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

import java.util.ArrayList;

/**
 *
 * @author R2D2E
 */
public abstract class Controller {

    //taxa de amostragem - default 0.1
    protected Double sampleRate = 0.1;
    //setpoint - default 20 cm.
    protected Double setPoint = 20.0;
    //valor do integral passado
    private Double pastIntegral;
    //valor do erro passado
    private Double pastError;
    //valor da variavel de processo passado
    private Double pastprocessVariable;

    //Contrutor default
    public Controller() {

        pastIntegral = 0.0;
        pastError = 0.0;
        pastprocessVariable = 0.0;
    }

    //Contrutor da classe com parametros.
    public Controller(Double sampleRate, Double setPoint) {

        this.sampleRate = sampleRate;
        this.setPoint = setPoint;
        pastIntegral = 0.0;
        pastError = 0.0;
        pastprocessVariable = 0.0;
    }

    //Funçao que calcula a ação proporcional de controle.
    public double proporcionalTerm(double kp, double processVariable) {
        return kp * error(processVariable);
    }

    //Funçao que calcula a ação integrativa de controle.
    public double integralTerm(double ki, double processVariable) {
        double inte = pastIntegral + ki * sampleRate * error(processVariable);
        pastIntegral = inte;
        return inte;
    }

    //Funçao que calcula a ação derivativa de controle.
    public double derivativeTerm(double kd, double processVariable) {
        double erro = error(processVariable);
        double deri = kd * ((erro - pastError) / sampleRate);
        pastError = erro;
        return deri;
    }

    //Funçao que calcula a segunda ação derivativa de controle.
    public double derivativeOutputTerm(double kd2, double processVariable) {
        double deriOut = kd2 * ((processVariable - pastprocessVariable) / sampleRate);
        pastprocessVariable = processVariable;
        return deriOut;
    }

    //Funçao que calcula um erro
    public double error(double processVariable) {
        return setPoint - processVariable;
    }

    /*
     * Método que deve ser sobrecarregado pelos que irao herdar essa classe.
     * Cada classe deve calcular o valor que se deve aplicar no tanque
     */
    public abstract double calculateOutput(double processVariable);

    public Double getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(Double sampleRate) {
        this.sampleRate = sampleRate;
    }

    public Double getSetPoint() {
        return setPoint;
    }

    public void setSetPoint(Double setPoint) {
        this.setPoint = setPoint;
    }
}

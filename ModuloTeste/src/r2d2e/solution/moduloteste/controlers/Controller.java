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
    protected Double setPoint = 15.0;
    //valor do integral passado
    protected Double pastIntegral;
    //valor do erro passado
    private Double pastError;
    //valor da variavel de processo passado
    private Double pastprocessVariable;
    private double proporcional = 0;
    private double integral = 0;
    private double derivative = 0;
    private double derivative2 = 0;
    private boolean inteCondi = true;

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
        double erro = error(processVariable);
        proporcional = kp * erro;

        return proporcional;
    }

    //Funçao que calcula a ação integrativa de controle.
    public double integralTerm(double ki, double processVariable) {
        integral = pastIntegral + ki * sampleRate * error(processVariable);
        return integral;
    }

    //Funçao que calcula a ação derivativa de controle.
    public double derivativeTerm(double kd, double processVariable) {
        double erro = error(processVariable);
        derivative = kd * ((erro - pastError) / sampleRate);
        pastError = erro;
        return derivative;
    }

    //Funçao que calcula a segunda ação derivativa de controle.
    public double derivativeOutputTerm(double kd2, double processVariable) {
        derivative2 = kd2 * ((processVariable - pastprocessVariable) / sampleRate);
        pastprocessVariable = processVariable;
        return derivative2;
    }

    //Funçao que calcula um erro
    public double error(double processVariable) {
        double erro = setPoint - processVariable;
        return erro;
    }

    protected double IntegralTest(double s, double p, double i, double d) {
        if (inteCondi) {
            if (s > 3 || s < -3) {
                s = p + d + pastIntegral;
            } else {
                pastIntegral = i;
            }
        } else {
            pastIntegral = i;
        }

        return s;
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

    public double getDerivative() {
        return derivative;
    }

    public double getDerivative2() {
        return derivative2;
    }

    public double getIntegral() {
        return integral;
    }

    public double getProporcional() {
        return proporcional;
    }

    public void setInteCondi(boolean inteCondi) {
        this.inteCondi = inteCondi;
    }
}

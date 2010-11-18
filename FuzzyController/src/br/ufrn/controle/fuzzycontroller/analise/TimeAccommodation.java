package br.ufrn.controle.fuzzycontroller.analise;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Erick
 *
 * To do: Pegar valor do grafico(Tempo x)
 *
 */
public class TimeAccommodation {

    private int criterio;
    private double initialTime;
    private double timeOfaccomodation;
    private boolean isaccomodated;
    private double setPoint;

    //Contrutor padrão esse deve ser utilizado, criterio 2, ts=0, estabilizado=false.
    public TimeAccommodation() {

        this.criterio = 2;
        this.timeOfaccomodation = 0;
        this.isaccomodated = false;
        this.initialTime = System.currentTimeMillis();
        this.setPoint = 0;
    }

    public TimeAccommodation(int criterio, double setPoint) {

        this.criterio = criterio;
        this.setPoint = setPoint;

        this.initialTime = System.currentTimeMillis();
        this.timeOfaccomodation = 0;
        this.isaccomodated = false;


    }

    public void init() {
        this.initialTime = System.currentTimeMillis();
    }

    public int getCriterio() {
        return criterio;
    }

    public void setCriterio(int criterio) {
        //Condição de erro criterio.
        if (criterio != 2 && criterio != 5 && criterio != 7 && criterio != 10) {
            System.out.println("Parametro invalido");
        } else {
            this.criterio = criterio;
        }
    }

    public double getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(double initialTime) {
        this.initialTime = initialTime;
    }

    public boolean isIsaccomodated() {
        return isaccomodated;
    }

    public void setIsaccomodated(boolean isaccomodated) {
        this.isaccomodated = isaccomodated;
    }

    public double getSetPoint() {
        return setPoint;
    }

    public void setSetPoint(double setPoint) {
        this.setPoint = setPoint;
    }

    public double getTimeOfaccomodation() {
        return timeOfaccomodation;
    }

    public void setTimeOfaccomodation(double timeOfaccomodation) {
        this.timeOfaccomodation = timeOfaccomodation;
    }

    //Metodo que calcula se o set point e o sensor estão dentro do tempo de acomodação.
    public boolean insidebouldering(Double sensor) {

        //calculo de porcentagem de margem.
        double boulderingAccommodation = (setPoint / 100) * this.criterio;

        //Condição de estar dentro da margem.
        if (sensor <= setPoint + boulderingAccommodation && sensor >= setPoint - boulderingAccommodation) {
            return true;
        }

        return false;
    }

    //Função chamada a cada tempo de execução da thread.
    public double calcTimeOfAcoomodation(double setPoint, double sensor) {


        if (this.setPoint == setPoint) {

            if (this.isaccomodated) {

                if (!insidebouldering(sensor)) {
                    this.isaccomodated = false;
                    this.timeOfaccomodation = 0;
                }
                return convertToTwoPlaces(this.timeOfaccomodation/1000);
            } else {
                if (insidebouldering(sensor)) {
                    this.isaccomodated = true;
                    //pegar o tempo, do grafico=x;
                    this.timeOfaccomodation = System.currentTimeMillis() - this.initialTime;
                }
                return convertToTwoPlaces(this.timeOfaccomodation/1000);
            }
        } //Temos um novo sepoint
        else {
            this.setPoint = setPoint;
            this.initialTime = System.currentTimeMillis();
            if (this.insidebouldering(sensor)) {
                this.isaccomodated = true;
                this.timeOfaccomodation = System.currentTimeMillis() - this.initialTime;
            } else {
                this.isaccomodated = false;
                this.timeOfaccomodation = 0;
            }

            return convertToTwoPlaces(this.timeOfaccomodation/1000);
        }
    }
    public double convertToTwoPlaces(double num) {
        num *= 100;
        num = Math.floor(num);
        num /= 100;
        return num;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.quanser.Quanser;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import java.util.ArrayList;
import org.openide.util.Exceptions;

/**
 *
 * @author demetrios
 */
public class FuzzyController extends Thread {

    private String name;
    private Inference inference;
    private Defuzzification defuzzification;
    private ArrayList<String> DataInType;
    private Quanser quanser;
    private volatile boolean ative = true;
    private int setPoint;
    private static final int NIVEL_MAX = 25;
    private static final int NIVEL_MIN = 3;
    private boolean limiteMaxTank2 = false;
    private double previousError1 = 0;
    private double previousError2 = 0;

    public FuzzyController(String name, Inference inference, Defuzzification defuzzification, ArrayList<String> DataInType, Quanser quanser) {
        this.name = name;
        this.inference = inference;
        this.defuzzification = defuzzification;
        this.DataInType = DataInType;
        this.quanser = quanser;
    }

    public FuzzyController(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (ative) {

            double level1 = quanser.readSensor1();
            double level2 = quanser.readSensor2();

            DataIn dataIn = createDataIn(level1, level2);

            Shape shape = inference.work(dataIn);
            double voltz = defuzzification.defuzzificate(shape);

            double realVoltz = travaTensao(voltz);

            realVoltz = travaNivel2(level2, realVoltz);

            realVoltz = travaNivel1(level1, realVoltz);

            quanser.writeBomb(realVoltz);

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    private double travaTensao(double tensaoAtual) {
        if (tensaoAtual > 3) {
            tensaoAtual = 3;
        }
        if (tensaoAtual < -3) {
            tensaoAtual = -3;
        }
        return tensaoAtual;
    }

    private double travaNivel1(double nivel, double tensaoAtual) {
        if (nivel < NIVEL_MIN && tensaoAtual < 0) {
            tensaoAtual = 0.0;
        } else {
            tensaoAtual = limiteSuperior(nivel, tensaoAtual);
        }
        return tensaoAtual;
    }

    private double travaNivel2(double nivel2, double tensaoAtual) {
        if (nivel2 > NIVEL_MAX && tensaoAtual >= 0) {
            limiteMaxTank2 = true;
            return -3;
        } else {
            limiteMaxTank2 = false;
            return tensaoAtual;
        }
    }

    private double limiteSuperior(double nivel, double tensaoAtual) {
        if (limiteMaxTank2) {
            return tensaoAtual;
        }
        if (nivel > NIVEL_MAX && tensaoAtual > 0) {
            tensaoAtual = 1.8;
            if (nivel >= 28) {
                tensaoAtual = -2;
            }
            return tensaoAtual;
        }
        return tensaoAtual;
    }

    private DataIn createDataIn(double level1, double level2) {
        DataIn dataIn = new DataIn();

        ArrayList<Double> valuesIn = new ArrayList<Double>();

        for (int i = 0; i < DataInType.size(); i++) {
            String string = DataInType.get(i);
            if (string.equals(ConstantsFuzzy.VARIABLE_ERROR_TANK1)) {
                valuesIn.add(setPoint - level1);
            } else if (string.equals(ConstantsFuzzy.VARIABLE_ERROR_TANK2)) {
                valuesIn.add(setPoint - level2);
            } else if (string.equals(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK1)) {
                valuesIn.add((setPoint - level1) - previousError1);
            } else if (string.equals(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2)) {
                valuesIn.add((setPoint - level2) - previousError2);
            }
        }

        for (int i = 0; i < valuesIn.size(); i++) {
            Double double1 = valuesIn.get(i);
            dataIn.addValue(DataInType.get(i), double1);
        }

        previousError1 = setPoint - level1;
        previousError2 = setPoint - level2;

        return dataIn;
    }

    public boolean isAtive() {
        return ative;
    }

    public void setAtive(boolean ative) {
        this.ative = ative;
    }

    public Defuzzification getDefuzzification() {
        return defuzzification;
    }

    public void setDefuzzification(Defuzzification defuzzification) {
        this.defuzzification = defuzzification;
    }

    public Inference getInference() {
        return inference;
    }

    public void setInference(Inference inference) {
        this.inference = inference;
    }

    public Quanser getQuanser() {
        return quanser;
    }

    public void setQuanser(Quanser quanser) {
        this.quanser = quanser;
    }

    public int getSetPoint() {
        return setPoint;
    }

    public void setSetPoint(int setPoint) {
        this.setPoint = setPoint;
    }

    @Override
    public String toString() {
        return name;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.analise.CalcOvershoot;
import br.ufrn.controle.fuzzycontroller.analise.PeakTime;
import br.ufrn.controle.fuzzycontroller.analise.RiseTime;
import br.ufrn.controle.fuzzycontroller.analise.TimeAccommodation;
import br.ufrn.controle.fuzzycontroller.handler.GraphHandler;
import br.ufrn.controle.fuzzycontroller.quanser.Quanser;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsGraph;
import br.ufrn.controle.fuzzycontroller.view.MainView;
import br.ufrn.controle.fuzzycontroller.view.TanquePanel;
import java.text.DecimalFormat;
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
    private SelectionsGraph selectionsGraph;
    private GraphHandler graphLevelHandler;
    private GraphHandler graphControlHandler;
    private Quanser quanser;
    private volatile boolean ative = true;
    private static final int NIVEL_MAX = 25;
    private static final int NIVEL_MIN = 3;
    private boolean limiteMaxTank2 = false;
    private double previousError1 = 0;
    private double previousError2 = 0;
    private double integralTension = 0;
    private TanquePanel tanquePanel;

    private CalcOvershoot calcOvershoot;
    private TimeAccommodation timeOfAccommodation;
    private RiseTime riseTime;
    private PeakTime peakTime;

    public FuzzyController(String name, Inference inference, Defuzzification defuzzification, ArrayList<String> DataInType) {
        this.name = name;
        this.inference = inference;
        this.defuzzification = defuzzification;
        this.DataInType = DataInType;
        quanser = new Quanser();
        createCalc();
    }

    public FuzzyController(String name) {
        this.name = name;
        createCalc();
    }

    private void createCalc() {
        calcOvershoot = new CalcOvershoot(ConstantsFuzzy.setPoint);
        timeOfAccommodation = new TimeAccommodation(ConstantsFuzzy.criterio, ConstantsFuzzy.setPoint);
        riseTime = new RiseTime(ConstantsFuzzy.setPoint);
        peakTime = new PeakTime(ConstantsFuzzy.setPoint);
    }

    @Override
    public void run() {

        quanser.connect();

        double level1Cal = quanser.readSensor1();
        double level2Cal = quanser.readSensor2();

        Quanser.setCALIBRATION1(level1Cal);
        Quanser.setCALIBRATION2(level2Cal);

        MainView.stati.clear();
        graphControlHandler.init();
        graphLevelHandler.init();
        timeOfAccommodation.init();
        riseTime.init();

        while (ative) {

            double level1 = quanser.readSensor1();
            double level2 = quanser.readSensor2();

            DataIn dataIn = createDataIn(level1, level2);

//            DataIn dataIn = new DataIn();
//            dataIn.addValue(ConstantsFuzzy.VARIABLE_ERROR_TANK2, 12.63);
//            dataIn.addValue(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, -0.01526);

            FunctionOutPut functionOutPut = inference.work(dataIn);

            if (functionOutPut == null) {
                break;
            }

            double voltz = defuzzification.defuzzificate(functionOutPut);

            double realVoltz = travaTensao(voltz);

//            integralTension += realVoltz;

            realVoltz = travaNivel2(level2, realVoltz);

            realVoltz = travaNivel1(level1, realVoltz);

            quanser.writeBomb(realVoltz);

            updateGraph(level1, level2, realVoltz);

            calcOvershoot.CalcOvershoot(level2);

            Double rise = riseTime.calcRiseTime(ConstantsFuzzy.setPoint, level2);
            atualizarRiseTime(rise);

            Double acomodation = timeOfAccommodation.calcTimeOfAcoomodation(ConstantsFuzzy.setPoint, level2);
            atualizaAcomodationTime(acomodation);

            peakTime.calcPeakTime(level2);

            tanquePanel.setLevelWater1(level1);
            tanquePanel.setLevelWater2(level2);

//            System.out.println("Erro2 " + dataIn.getValueOfVariable(ConstantsFuzzy.VARIABLE_ERROR_TANK2) + " derErro " +
//                    dataIn.getValueOfVariable(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2)
//                    + " saida " + voltz);

            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    }

    public static void atualizarRiseTime(Double rise){
        if(rise != null) {
            DecimalFormat decimal = new DecimalFormat("0.00");
            String valorFormatado = decimal.format(rise);
            MainView.stati.setRiseTime(valorFormatado);
        }
    }

    public static void atualizaAcomodationTime(Double acom) {
        if(acom != null) {
            DecimalFormat decimal = new DecimalFormat("0.00");
            String valorFormatado = decimal.format(acom);
            MainView.stati.setAcomodation(valorFormatado);
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

        for (int i = 0; i < DataInType.size(); i++) {
            String string = DataInType.get(i);
            if (string.equals(ConstantsFuzzy.VARIABLE_ERROR_TANK1)) {
                dataIn.addValue(string, putLimit(string, ConstantsFuzzy.setPoint - level1));
            }
            if (string.equals(ConstantsFuzzy.VARIABLE_ERROR_TANK2)) {
                dataIn.addValue(string, putLimit(string, ConstantsFuzzy.setPoint - level2));
            }
            if (string.equals(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK1)) {
                dataIn.addValue(string, putLimit(string, ((ConstantsFuzzy.setPoint - level1) - previousError1)));
            }
            if (string.equals(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2)) {
                dataIn.addValue(string, putLimit(string, (ConstantsFuzzy.setPoint - level2) - previousError2));
            }
        }

        previousError1 = ConstantsFuzzy.setPoint - level1;
        previousError2 = ConstantsFuzzy.setPoint - level2;

        return dataIn;
    }

    private void updateGraph(final double level1, final double level2, final double tension) {

        new Thread(new Runnable() {

            public void run() {
                if (selectionsGraph.isError1Selected()) {
                    graphLevelHandler.addValue(ConstantsGraph.ERRO1, ConstantsFuzzy.setPoint - level1);
                }

                if (selectionsGraph.isError2Selected()) {
                    graphLevelHandler.addValue(ConstantsGraph.ERRO2, ConstantsFuzzy.setPoint - level2);
                }

                if (selectionsGraph.isLevel1Selected()) {
                    graphLevelHandler.addValue(ConstantsGraph.NIVEL1, level1);
                }

                if (selectionsGraph.isLevel2Selected()) {
                    graphLevelHandler.addValue(ConstantsGraph.NIVEL2, level2);
                }

                if (selectionsGraph.isSetPointSelected()) {
                    graphLevelHandler.addValue(ConstantsGraph.SET_POINT, ConstantsFuzzy.setPoint);
                }

                graphControlHandler.addValue(ConstantsGraph.SINAL_CONTROLE, tension);

            }
        }).start();

    }

    public boolean isAtive() {
        return ative;
    }

    public void setAtive(boolean ative) {
        this.ative = ative;
        quanser.writeBomb(0);
        quanser.closeConnection();
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

//    public int getSetPoint() {
//        return setPoint;
//    }
//
//    public void setSetPoint(int setPoint) {
//        this.setPoint = setPoint;
//    }
    public SelectionsGraph getSelectionsGraph() {
        return selectionsGraph;
    }

    public void setSelectionsGraph(SelectionsGraph selectionsGraph) {
        this.selectionsGraph = selectionsGraph;
    }

    public void setGraphControlHandler(GraphHandler graphControlHandler) {
        this.graphControlHandler = graphControlHandler;
    }

    public void setGraphLevelHandler(GraphHandler graphLevelHandler) {
        this.graphLevelHandler = graphLevelHandler;
    }

    public TanquePanel getTanquePanel() {
        return tanquePanel;
    }

    public void setTanquePanel(TanquePanel tanquePanel) {
        this.tanquePanel = tanquePanel;
    }

    @Override
    public String toString() {
        return name;
    }

    private Double putLimit(String variable, double value) {
        ArrayList<Double> range = inference.getDataBase().getRangeIn(variable);

        if (value < range.get(0)) {
            return range.get(0);
        } else if (value > range.get(1)) {
            return range.get(1);
        }

        return value;
    }

    public ArrayList<String> getDataInType() {
        return DataInType;
}
}

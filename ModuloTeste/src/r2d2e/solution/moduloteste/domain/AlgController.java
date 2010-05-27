/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import r2d2e.solution.moduloteste.analise.CalcOvershoot;
import r2d2e.solution.moduloteste.analise.PeakTime;
import r2d2e.solution.moduloteste.analise.RiseTime;
import r2d2e.solution.moduloteste.analise.TimeAccommodation;
import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.controlers.ControllerCascade;
import r2d2e.solution.moduloteste.domain.graph.GraphNivel;
import r2d2e.solution.moduloteste.domain.graph.GraphControl;
import r2d2e.solution.moduloteste.domain.graph.GraphAction;
import r2d2e.solution.moduloteste.handler.ControlModeHandler;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author demetrios
 */
public class AlgController extends Timer implements ActionListener {

    public static final int NIVEL_MAX = 25;
    public static final int NIVEL_MIN = 3;

    private Controller controller;
    private Quanser quanser;
    private TanquePanel tanquePanel;

    private long initT;
    private boolean limiteMaxTank2 = false;
    private boolean ativo = true;

    private CalcOvershoot calcOvershoot;
    private TimeAccommodation timeOfAccommodation;
    private RiseTime riseTime;
    private PeakTime peakTime;

    public AlgController(int delay, Controller controller, TanquePanel tanquePanel, Quanser quanser, boolean intCond) {
        super(delay, null);
        addActionListener(this);
        this.controller = controller;
        this.quanser = quanser;
        this.tanquePanel = tanquePanel;
        this.initT = System.currentTimeMillis();

        controller.setInteCondi(intCond);
        calcOvershoot = new CalcOvershoot(controller.getSetPoint());
        timeOfAccommodation = new TimeAccommodation(controlerInterface.dataPanel.getCriterio(),controller.getSetPoint());
        riseTime = new RiseTime(controller.getSetPoint());
        peakTime = new PeakTime(controller.getSetPoint());
    }

    private void atualizarGrafico(final double nivel, final double set, final double tensao, final double trava) {

        new Thread() {

            @Override
            public void run() {
                long tempo = System.currentTimeMillis() - initT;

                ControlModeHandler.graphNivel.addNivel(tempo, nivel, GraphNivel.S_NIVEL);
                ControlModeHandler.graphNivel.addNivel(tempo, set, GraphNivel.S_SP);
                ControlModeHandler.graphNivel.addNivel(tempo, set - nivel, GraphNivel.S_ERRO);

                ControlModeHandler.graphTensao1.addTensao(tempo, controller.getProporcional(), GraphControl.S_P);
                ControlModeHandler.graphTensao1.addTensao(tempo, controller.getIntegral(), GraphControl.S_I);
                ControlModeHandler.graphTensao1.addTensao(tempo, controller.getDerivative(), GraphControl.S_D);
                ControlModeHandler.graphTensao1.addTensao(tempo, controller.getDerivative2(), GraphControl.S_D2);

                ControlModeHandler.graphTensao2.addTensao(tempo, tensao, GraphAction.S_ATUAL);
                ControlModeHandler.graphTensao2.addTensao(tempo, trava, GraphAction.S_TRAVA);
            }
        }.start();
    }

    private void atualizarGraficoMaster(final double nivel, final double set, final double tensao, final double trava) {

        new Thread() {

            @Override
            public void run() {
                long tempo = System.currentTimeMillis() - initT;

                Controller cascade = ((ControllerCascade) controller).getMaster();

                ControlModeHandler.graphNivel.addNivel(tempo, nivel, GraphNivel.M_NIVEL);
                ControlModeHandler.graphNivel.addNivel(tempo, set, GraphNivel.M_SP);
                ControlModeHandler.graphNivel.addNivel(tempo, set - nivel, GraphNivel.M_ERRO);

                ControlModeHandler.graphTensao1.addTensao(tempo, cascade.getProporcional(), GraphControl.M_P);
                ControlModeHandler.graphTensao1.addTensao(tempo, cascade.getIntegral(), GraphControl.M_I);
                ControlModeHandler.graphTensao1.addTensao(tempo, cascade.getDerivative(), GraphControl.M_D);
                ControlModeHandler.graphTensao1.addTensao(tempo, cascade.getDerivative2(), GraphControl.M_D2);

                ControlModeHandler.graphTensao2.addTensao(tempo, tensao, GraphAction.M_ATUAL);
                ControlModeHandler.graphTensao2.addTensao(tempo, trava, GraphAction.M_TRAVA);
            }
        }.start();
    }

    public void actionPerformed(ActionEvent e) {

        double nivel1 = quanser.readSensor1();
        double nivel2 = quanser.readSensor2();

        updateTanks(nivel1, nivel2);

        double nivel;

        if (ControlModeHandler.configGerais.CONTROLE == ConfigGerais.C_TANQUE1) {
            nivel = nivel1;
        } else {
            nivel = nivel2;
            System.out.println("dddfesgrgtr");
        }

        if (ativo) {

            if(controller instanceof ControllerCascade){
                ((ControllerCascade)controller).setProcessVariable2(nivel1);
            }

            double setP = controller.getSetPoint();

            double tensao = controller.calculateOutput(nivel);

            double tensaoAtual = travaTensao(tensao);

            tensaoAtual = travaNivel2(nivel2, tensaoAtual);

            tensaoAtual = travaNivel1(nivel1, tensaoAtual);

            quanser.writeBomb(tensaoAtual);

            atualizarGrafico(nivel, setP, tensao, tensaoAtual);

            calcOvershoot.CalcOvershoot(nivel);
            
            Double rise = riseTime.calcRiseTime(setP, nivel);
            controlerInterface.atualizarRiseTime(rise);

            Double acomodation = timeOfAccommodation.calcTimeOfAcoomodation(setP, nivel);
            controlerInterface.atualizaAcomodationTime(acomodation);

            peakTime.calcPeakTime(nivel);

            if (ControlModeHandler.configGerais.CONTROLE == ConfigGerais.C_TANQUE_CASCATA) {
                ControllerCascade cascade = (ControllerCascade) controller;
                atualizarGraficoMaster(nivel1, cascade.getNivelD(), cascade.getNivelD(), cascade.getNivelS());
            }

        }
    }

    private double travaNivel1(double nivel, double tensaoAtual) {
        if (nivel < NIVEL_MIN && tensaoAtual < 0) {
            tensaoAtual = 0.0;
        } else {
            tensaoAtual = limiteSuperior(nivel, tensaoAtual);
        }
        return tensaoAtual;
    }

    private void updateTanks(double nivel1, double nivel2) {
        tanquePanel.setLevelWater1(nivel1);
        tanquePanel.setLevelWater2(nivel2);
    }

    private double travaTensao(double tensaoAtual) {
        //testar se é [-3,3];
        if (tensaoAtual > 3) {
            tensaoAtual = 3;
        }
        if (tensaoAtual < -3) {
            tensaoAtual = -3;
        }
        return tensaoAtual;
    }

    public void setQuanser(Quanser quanser) {
        this.quanser = quanser;
    }

    private double limiteSuperior(double nivel, double tensaoAtual) {
        if (limiteMaxTank2) {
            return tensaoAtual;
        }
        if (nivel > NIVEL_MAX && tensaoAtual > 0) {
//            System.out.println("nivelAnte " + nivelAnte);
            tensaoAtual = 1.8;
            if (nivel >= 28) {
                tensaoAtual = -2;
            }
//            System.out.println("tensao " + tensaoAtual);
            return tensaoAtual;
        }
        return tensaoAtual;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setInteCondi(boolean inteCondi) {
        controller.setInteCondi(inteCondi);
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
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

    public void atualizarCriterioAcomodacao() {
        timeOfAccommodation.setCriterio(controlerInterface.dataPanel.getCriterio());
    }

    public void atualizarSetPoint(Double set) {
        peakTime.setSetpoint(set);
        calcOvershoot.setSetpoint(set);
    }

}

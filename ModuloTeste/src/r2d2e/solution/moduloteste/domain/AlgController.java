/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.controlers.PController;
import r2d2e.solution.moduloteste.domain.graph.GraphNivel;
import r2d2e.solution.moduloteste.domain.graph.GraphTensao1;
import r2d2e.solution.moduloteste.domain.graph.GraphTensao2;
import r2d2e.solution.moduloteste.handler.ControlModeHandler;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author demetrios
 */
public class AlgController extends Timer implements ActionListener {

    public static final int NIVEL_MAX = 26;
    public static final int NIVEL_MIN = 3;
    private Controller controller;
    private Quanser quanser;
    private TanquePanel tanquePanel;
    private double nivelAnte = 0;
    private long initT;

    public AlgController(int delay, Controller controller,TanquePanel tanquePanel,Quanser quanser, boolean intCond) {
        super(delay, null);
        addActionListener(this);
        this.controller = controller;
        this.quanser = quanser;
        this.tanquePanel = tanquePanel;
        this.initT = System.currentTimeMillis();

        controller.setInteCondi(intCond);
    }

    private void atualizarGrafico(double nivel, double set, double tensao, double trava) {

        long tempo = System.currentTimeMillis() - initT;

        ControlModeHandler.graphNivel.addNivel(tempo, nivel, GraphNivel.NIVEL);
        ControlModeHandler.graphNivel.addNivel(tempo, set, GraphNivel.SP);
        ControlModeHandler.graphNivel.addNivel(tempo, set - nivel, GraphNivel.ERRO);

        ControlModeHandler.graphTensao1.addTensao(tempo, controller.getProporcional(), GraphTensao1.P);
        ControlModeHandler.graphTensao1.addTensao(tempo, controller.getIntegral(), GraphTensao1.I);
        ControlModeHandler.graphTensao1.addTensao(tempo, controller.getDerivative(), GraphTensao1.D);
        ControlModeHandler.graphTensao1.addTensao(tempo, controller.getDerivative2(), GraphTensao1.D2);

        ControlModeHandler.graphTensao2.addTensao(tempo, tensao, GraphTensao2.ATUAL);
        ControlModeHandler.graphTensao2.addTensao(tempo, trava, GraphTensao2.TRAVA);
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println("\n------------------------------");
        System.out.println("controller " + controller);

        //Ler do tank
        double nivel1 = quanser.readSensor1();
        double nivel2 = quanser.readSensor1();

        tanquePanel.setLevelWater1(nivel1);
        tanquePanel.setLevelWater2(nivel2);

        double setP = controller.getSetPoint();

        System.out.println("nivel " + nivel1);
        //calcular valor de tensão
        double tensao = controller.calculateOutput(nivel1);
        double tensaoAtual = travaTensao(tensao);

        atualizarGrafico(nivel1, setP, tensao, tensaoAtual);

        writeBomb(nivel1, tensaoAtual);
    }

    private void writeBomb(double nivel, double tensaoAtual) {
        if (nivel < NIVEL_MIN && tensaoAtual < 0) {
            tensaoAtual = 0.0;
        } else {
            tensaoAtual = limiteSuperior(nivel, tensaoAtual);
        }
        nivelAnte = nivel;

        quanser.writeBomb(tensaoAtual);
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
        if (nivel >= NIVEL_MAX && tensaoAtual > 0) {
            System.out.println("nivelAnte " + nivelAnte);
            tensaoAtual = 1.8;
            if(nivel >= 30){
                tensaoAtual = -2;
            }
            System.out.println("tensao " + tensaoAtual);
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
}

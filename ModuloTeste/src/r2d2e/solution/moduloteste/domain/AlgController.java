/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import r2d2e.solution.moduloteste.controlers.Controller;

/**
 *
 * @author demetrios
 */
public class AlgController extends Timer implements ActionListener {
    public static final int NIVEL_MAX = 27;
    public static final int NIVEL_MIN = 3;

    private Controller controller;
    private Quanser quanser;

    public AlgController(int delay, Controller controller, Quanser quanser) {
        super(delay, null);
        addActionListener(this);
        this.controller = controller;
        this.quanser = quanser;
    }

    public void actionPerformed(ActionEvent e) {

        System.out.println("\n------------------------------");
        System.out.println("controller " + controller);

        //Ler do tank
        double nivel = quanser.readSensor1();

        System.out.println("nivel " + nivel);
        //calcular valor de tensão
        double tensaoAtual = controller.calculateOutput(nivel);

        tensaoAtual = travaTensao(tensaoAtual);
        System.out.println("tensaoAtual " + tensaoAtual);
        if (nivel < NIVEL_MIN && tensaoAtual < 0) {
            //Escrever na bomba
            quanser.writeBomb(0);
        } else {
            if (nivel >= NIVEL_MAX) {
                quanser.writeBomb(1.8);
            }else{
                quanser.writeBomb(tensaoAtual);
            }
        }
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
}

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

    private Controller controller;
    private Quanser quanser;

    public AlgController(int delay, Controller controller) {
        super(delay, null);
        addActionListener(this);
        this.controller = controller;
    }

    public void actionPerformed(ActionEvent e) {
        //Ler do tank
        //d = controller.calculateOutput0(VALOR DO NIVEL);
        //testar se é [-3,3];
        //Escrever na bomba
    }

    public void setQuanser(Quanser quanser) {
        this.quanser = quanser;
    }
}

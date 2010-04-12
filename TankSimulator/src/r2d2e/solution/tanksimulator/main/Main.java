/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.main;

import r2d2e.solution.tanksimulator.view.MainView;
import r2d2e.solution.tanksimulator.view.Splash;

/**
 *
 * @author demetrios
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                Splash.getInstance().inicializaSplash();
                new MainView().setVisible(true);
            }
        });
    }
}

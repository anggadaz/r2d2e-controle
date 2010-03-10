/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.handler;

import javax.swing.JSpinner;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.ThreadCycle;
import r2d2e.solution.moduloteste.domain.ThreadRead;
import r2d2e.solution.moduloteste.view.MainFrame;

/**
 *
 * @author Demétrios
 */
public class MainFrameHandler {

    private MainFrame mainFrame;
    private Quanser quanser;
    private ThreadCycle threadCycle;

    public MainFrameHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        quanser = new Quanser();
    }

    public void initTest() {
        Double tensaoMax = (Double) mainFrame.getSpinnerTMax().getValue();
        Double tensaoMin = (Double) mainFrame.getSpinnerTMin().getValue();
        Double tensaoStep = (Double) mainFrame.getSpinnerTI().getValue();
        Double nivelAgua = (Double) mainFrame.getSpinnerNA().getValue();
        threadCycle = new ThreadCycle(tensaoMax, tensaoMin, tensaoStep, nivelAgua, quanser);
    }

    public void stopTest() {
        threadCycle.setRodando(false);
    }

    public void cycle() {
        threadCycle.start();
    }
}

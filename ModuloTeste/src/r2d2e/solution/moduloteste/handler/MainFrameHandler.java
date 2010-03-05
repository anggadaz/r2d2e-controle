/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.ThreadRead;
import r2d2e.solution.moduloteste.view.MainFrame;

/**
 *
 * @author Demétrios
 */
public class MainFrameHandler {

    private MainFrame mainFrame;
    private Quanser quanser;

    public MainFrameHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public void initTest() {
        quanser = new Quanser();
        ThreadRead read = new ThreadRead(quanser);
        
    }

    public void stopTest() {
    }
}

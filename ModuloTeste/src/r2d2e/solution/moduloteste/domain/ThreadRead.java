
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package r2d2e.solution.moduloteste.domain;

/**
 *
 * @author Demétrios
 */
public class ThreadRead {

    public Quanser quanser;


    public ThreadRead(Quanser quanser){
        this.quanser = quanser;
    }

    public void run() {

        Double read = quanser.readSensor1();
    }
}

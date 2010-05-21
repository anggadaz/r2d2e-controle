/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.controlers;

/**
 *
 * @author demetrios
 */
public class ControllerCascade extends Controller {

    private Controller master;
    private Controller slave;

    public ControllerCascade(Double sampleRate, Double setPoint) {
        super(sampleRate, setPoint);
    }

    public ControllerCascade(Double sampleRate, Double setPoint, Controller master, Controller slave) {
        super(sampleRate, setPoint);
        this.master = master;
        this.slave = slave;
    }

    @Override
    public double calculateOutput(double processVariable) {
        double level1 = master.calculateOutput(processVariable);
        double tensao = slave.calculateOutput(level1);
        return tensao;
    }

    public Controller getMaster() {
        return master;
    }

    public void setMaster(Controller master) {
        this.master = master;
    }

    public Controller getSlave() {
        return slave;
    }

    public void setSlave(Controller slave) {
        this.slave = slave;
    }
}

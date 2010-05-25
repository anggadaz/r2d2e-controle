package r2d2e.solution.moduloteste.controlers;

import r2d2e.solution.moduloteste.view.ConfParametros;

/**
 *
 * @author demetrios
 */
public class ControllerCascade extends Controller {

    private Controller master;
    private Controller slave;

    public ControllerCascade() {
        super(ConfParametros.SAMPLE_RATE, 15d);
        master = null;
        slave = null;
    }

    @Override
    public double calculateOutput(double processVariable) {
        double level1 = master.calculateOutput(processVariable);
        double tensao = slave.calculateOutput(level1);
        return tensao;
    }

    @Override
    public Double getSetPoint() {
        return slave.getSetPoint();
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

    public void updateParametros(ConfParametros paramMaster,ConfParametros paramSlave ) {
        master = paramMaster.getSelectedController();
        slave = paramSlave.getSelectedController();

        master.updateParametros(paramMaster);
        slave.updateParametros(paramSlave);
    }

    @Override
    public void updateParametros(ConfParametros parametros) {
    }

}

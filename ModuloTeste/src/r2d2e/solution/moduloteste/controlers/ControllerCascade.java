package r2d2e.solution.moduloteste.controlers;

import r2d2e.solution.moduloteste.view.ConfParametros;

/**
 *
 * @author demetrios
 */
public class ControllerCascade extends Controller {

    private Controller master;
    private Controller slave;
    private double processVariable2;

    private double nivelD;
    private double nivelS;

    public ControllerCascade() {
        super(ConfParametros.SAMPLE_RATE, 15d);
        master = null;
        slave = null;
    }

    @Override
    public double calculateOutput(double processVariable) {
        System.out.println("---MASTER---");
        System.out.println("PV " + processVariable);

        nivelD = master.calculateOutput(processVariable);
        
        nivelD = travaLevel1(nivelD);

        System.out.println("LEVEL1 " + nivelD);

        System.out.println("---SLAVE---");
        
        slave.setSetPoint(nivelD);

        System.out.println("PV2 " + processVariable2);
        double tensao = slave.calculateOutput(processVariable2);
        
        System.out.println("tensao " + tensao);
        return tensao;
    }

    private double travaLevel1(double level1) {
        if (master.isInteCondi()) {
            System.out.println("VERIFICANDO TRAVA LEVEL1");
            if (level1 > 30) {
                level1 = 30;
            } else if (level1 < 0) {
                level1 = 0;
            }
            nivelS = level1;
        } else {
            nivelS = 0;
        }
        return level1;
    }

    public double getNivelD() {
        return nivelD;
    }

    public double getNivelS() {
        return nivelS;
    }

    public double getProcessVariable2() {
        return processVariable2;
    }

    public void setProcessVariable2(double processVariable2) {
        this.processVariable2 = processVariable2;
    }

    @Override
    public double getDerivative() {
        return slave.getDerivative();
    }

    @Override
    public double getDerivative2() {
        return slave.getDerivative2();
    }

    @Override
    public double getIntegral() {
        return slave.getIntegral();
    }

    @Override
    public double getProporcional() {
        return slave.getProporcional();
    }

    @Override
    public Double getSetPoint() {
        return master.getSetPoint();
    }

    @Override
    public void setSetPoint(Double setPoint) {
        master.setSetPoint(setPoint);
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

    public void updateParametros(ConfParametros paramMaster, ConfParametros paramSlave) {
        master = paramMaster.getSelectedController();
        slave = paramSlave.getSelectedController();

        master.updateParametros(paramMaster);
        slave.updateParametros(paramSlave);

        boolean ciMaster = paramMaster.getChkIntCond().isSelected();
        boolean ciSlave = paramSlave.getChkIntCond().isSelected();

        master.setInteCondi(ciMaster);
        master.setLimitesNivel(true);
        slave.setInteCondi(ciSlave);
    }
    
    @Override
    public void updateParametros(ConfParametros parametros) {
    }
}

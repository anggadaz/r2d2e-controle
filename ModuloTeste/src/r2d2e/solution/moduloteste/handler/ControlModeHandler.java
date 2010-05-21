package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.analise.CalcOvershoot;
import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.controlers.PController;
import r2d2e.solution.moduloteste.controlers.PDController;
import r2d2e.solution.moduloteste.controlers.PIController;
import r2d2e.solution.moduloteste.controlers.PID2Controller;
import r2d2e.solution.moduloteste.controlers.PIDController;
import r2d2e.solution.moduloteste.domain.AlgController;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.controlerInterface;
import r2d2e.solution.moduloteste.domain.graph.GraphNivel;
import r2d2e.solution.moduloteste.domain.graph.GraphControl;
import r2d2e.solution.moduloteste.domain.graph.GraphAction;
import r2d2e.solution.moduloteste.domain.graph.IGraphTime;
import r2d2e.solution.moduloteste.view.ConfParametros;
import r2d2e.solution.moduloteste.view.ConfigControle;
import r2d2e.solution.moduloteste.view.ControlPanel;
import r2d2e.solution.moduloteste.view.Modo3;
import r2d2e.solution.moduloteste.view.NovoFrame;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author controle
 */
public class ControlModeHandler {

    private static TanquePanel tanquePanel;
    private static ControlPanel controlPanel;
    private static AlgController algController;
    public static GraphNivel graphNivel;
    public static GraphControl graphTensao1;
    public static GraphAction graphTensao2;
    private static Controller controllerSelected;
    private static ConfParametros parametroNormal;
    private static ConfParametros parametrosMaster;
    private static ConfParametros parametrosSlave;

    public static void setIntegracaoCondi(boolean chk) {
        if (algController != null) {
            algController.setInteCondi(chk);
        }
    }

    private static Controller UpdateParametros(Double nivelNumb,ConfParametros parametros,Controller controller) throws NumberFormatException {
        if (controllerSelected instanceof PController) {
            String kp = parametros.getTextKP().getText();
            //            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            controllerSelected.setSetPoint(nivelNumb);
            ((PController) controllerSelected).setKp(Double.parseDouble(kp));
        }
        if (controllerSelected instanceof PDController) {
            String kp = parametros.getTextKP().getText();
            String kd = getKdValue(parametros);
            //            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            kd = fixNumber(kd);
            controllerSelected.setSetPoint(nivelNumb);
            ((PDController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PDController) controllerSelected).setKd(Double.parseDouble(kd));
        }
        if (controllerSelected instanceof PIController) {
            String kp = parametros.getTextKP().getText();
            String ki = getKIValue(parametros);
            //            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);
            controllerSelected.setSetPoint(nivelNumb);
            ((PIController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PIController) controllerSelected).setKi(Double.parseDouble(ki));
        }
        if (controllerSelected instanceof PIDController) {
            String kp = parametros.getTextKP().getText();
            String ki = getKIValue(parametros);
            String kd = getKdValue(parametros);
            //            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);
            kd = fixNumber(kd);
            controllerSelected.setSetPoint(nivelNumb);
            ((PIDController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PIDController) controllerSelected).setKi(Double.parseDouble(ki));
            ((PIDController) controllerSelected).setKd(Double.parseDouble(kd));
        }
        if (controllerSelected instanceof PID2Controller) {
            String kp = parametros.getTextKP().getText();
            String ki = getKIValue(parametros);
            String kd2 = getKdValue(parametros);
            //            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);
            kd2 = fixNumber(kd2);
            controllerSelected.setSetPoint(nivelNumb);
            ((PID2Controller) controllerSelected).setKp(Double.parseDouble(kp));
            ((PID2Controller) controllerSelected).setKi(Double.parseDouble(ki));
            ((PID2Controller) controllerSelected).setKd2(Double.parseDouble(kd2));
        }
        return controller;
    }

    public ControlModeHandler(NovoFrame frame) {
        tanquePanel = frame.getTanquePanel();
        controlPanel = frame.getControlPanel();

        parametroNormal = frame.getConfParametroNormal();
        parametrosMaster = frame.getConfParametroMaster();
        parametrosSlave = frame.getConfParametrosSlave();

        initChart();
    }

    private void initChart() {
        graphNivel = new GraphNivel(300000);
        graphTensao1 = new GraphControl(300000);
        graphTensao2 = new GraphAction(300000);

        controlPanel.initChart();

    }

    public static IGraphTime[] getChart() {
        return new IGraphTime[]{graphNivel, graphTensao1, graphTensao2};
    }

    private static Double getSetPoint() {
        String nivel = parametroNormal.getTextSetPoint().getText();
        nivel = fixNumber(nivel);

        if (nivel != null) {
            return Double.parseDouble(nivel);
        }

        return null;

    }

    public static Controller getControllerSelected() {
        return controllerSelected;
    }

    public static void setControllerSelected(Controller controllerSelected) {
        ControlModeHandler.controllerSelected = controllerSelected;
    }

    public static void updateVariables() {

        Double nivelNumb = getSetPoint();

        //updateSetPointAnterior(getSetPoint());
        if (AlgController.CONTROLAR_TANQUE == ConfigControle.CONTROLE_DOIS_COM_CASCATA) {

            Controller controllerMaster = parametrosMaster.getSelectedController();
            Controller controllerSlave = parametrosSlave.getSelectedController();

        } else {

            Controller control = parametroNormal.getSelectedController();
            controllerSelected = UpdateParametros(nivelNumb,parametroNormal,control);
        }



        if (algController != null) {
            algController.setController(controllerSelected);
            algController.atualizarCriterioAcomodacao();
            algController.atualizarSetPoint(getSetPoint());
        }

    }

    public void init(Quanser quanser) {
        boolean ok = parametroNormal.getChkIntCond().isSelected();
        algController = new AlgController(100, controllerSelected, tanquePanel, quanser, ok);
        algController.start();
        graphNivel.clear();
        graphTensao1.clear();
        graphTensao2.clear();
    }

    public static String fixNumber(String numb) {
        return numb.replace(",", ".");
    }

    public void stop(Quanser quanser) {
        algController.setAtivo(false);
        quanser.stopMotor();
    }

    public static void updateKD() {
        String d = parametroNormal.getTextTD().getText();
        parametroNormal.getTextKD().setText(d);
    }

    public static void updateKI() {
        String ti = parametroNormal.getTextTI().getText();
        if (ti != null && !ti.isEmpty()) {
            ti = fixNumber(ti);
            double d = Double.parseDouble(ti);
            Double resultado = 1.0 / d;
            parametroNormal.getTextKI().setText(resultado.toString());
        }
        System.out.println("ki2 " + parametroNormal.getTextKI().getText());
        System.out.println("ti2 " + parametroNormal.getTextTI().getText());
    }

    public static void updateTD() {
        String kd = parametroNormal.getTextKD().getText();
        parametroNormal.getTextTD().setText(kd);
    }

    public static void updateTI() {
        String td = parametroNormal.getTextKI().getText();
        if (td != null && !td.isEmpty()) {
            td = fixNumber(td);
            double d = Double.parseDouble(td);
            Double resultado = 1.0 / d;
            parametroNormal.getTextTI().setText(resultado.toString());
        }
        System.out.println("ki " + parametroNormal.getTextKI().getText());
        System.out.println("ti " + parametroNormal.getTextTI().getText());

    }

    private static String getKdValue(ConfParametros parametros) {
        boolean ok = parametros.getChkKD().isSelected();
        String kd = null;
        if (ok) {
            kd = parametros.getTextKD().getText();
        } else {
            kd = parametros.getTextTD().getText();
        }
        kd = fixNumber(kd);
        return kd;
    }

    private static String getKIValue(ConfParametros parametros) {
        boolean ok = parametros.getChkKI().isSelected();
        String ki = null;
        if (ok) {
            ki = parametros.getTextKI().getText();
            ki = fixNumber(ki);
        } else {
            String ti = parametros.getTextTI().getText();
            ti = fixNumber(ti);
            double d = Double.parseDouble(ti);
            Double resultado = 1.0 / d;
            ki = resultado.toString();
        }
        return ki;
    }

    public static ControlPanel getControlPanel() {
        return controlPanel;
    }
}

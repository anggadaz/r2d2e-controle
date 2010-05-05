package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.controlers.PController;
import r2d2e.solution.moduloteste.controlers.PDController;
import r2d2e.solution.moduloteste.controlers.PIController;
import r2d2e.solution.moduloteste.controlers.PID2Controller;
import r2d2e.solution.moduloteste.controlers.PIDController;
import r2d2e.solution.moduloteste.domain.AlgController;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.graph.GraphNivel;
import r2d2e.solution.moduloteste.domain.graph.GraphControl;
import r2d2e.solution.moduloteste.domain.graph.GraphAction;
import r2d2e.solution.moduloteste.domain.graph.IGraphTime;
import r2d2e.solution.moduloteste.view.ConfParametros;
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
    private static ConfParametros confControle;
    private static AlgController algController;

    public static GraphNivel graphNivel;
    public static GraphControl graphTensao1;
    public static GraphAction graphTensao2;

    private static Controller controllerSelected;

    public static void setIntegracaoCondi(boolean chk) {
        if (algController != null) {
            algController.setInteCondi(chk);
        }
    }

    public ControlModeHandler(NovoFrame frame) {
        tanquePanel = frame.getTanquePanel();
        controlPanel = frame.getControlPanel();
        confControle = frame.getConfControle();
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

    public static Controller getControllerSelected() {
        return controllerSelected;
    }

    public static void setControllerSelected(Controller control) {
        controllerSelected = control;
    }

    public static void updateVariables() {
        if (controllerSelected instanceof PController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PController) controllerSelected).setKp(Double.parseDouble(kp));
        }
        if (controllerSelected instanceof PDController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String kd = getKdValue();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            kd = fixNumber(kd);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PDController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PDController) controllerSelected).setKd(Double.parseDouble(kd));
        }
        if (controllerSelected instanceof PIController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String ki = getKIValue();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PIController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PIController) controllerSelected).setKi(Double.parseDouble(ki));
        }
        if (controllerSelected instanceof PIDController) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String ki = getKIValue();
            String kd = getKdValue();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);
            kd = fixNumber(kd);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PIDController) controllerSelected).setKp(Double.parseDouble(kp));
            ((PIDController) controllerSelected).setKi(Double.parseDouble(ki));
            ((PIDController) controllerSelected).setKd(Double.parseDouble(kd));
        }
        if (controllerSelected instanceof PID2Controller) {
            String nivel = confControle.getTextSetPoint().getText();
            String kp = confControle.getTextKP().getText();
            String ki = getKIValue();
            String kd2 = getKdValue();

            nivel = fixNumber(nivel);
            kp = fixNumber(kp);
            ki = fixNumber(ki);
            kd2 = fixNumber(kd2);

            controllerSelected.setSetPoint(Double.parseDouble(nivel));
            ((PID2Controller) controllerSelected).setKp(Double.parseDouble(kp));
            ((PID2Controller) controllerSelected).setKi(Double.parseDouble(ki));
            ((PID2Controller) controllerSelected).setKd2(Double.parseDouble(kd2));
        }
        if (algController != null) {
            algController.setController(controllerSelected);
            algController.atualizarCriterioAcomodacao();
        }

    }

    public void init(Quanser quanser) {
        boolean ok = confControle.getChkIntCond().isSelected();
        algController = new AlgController(100, controllerSelected,tanquePanel,quanser,ok);
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
        String d = confControle.getTextTD().getText();
        confControle.getTextKD().setText(d);
    }

    public static void updateKI() {
        String ti = confControle.getTextTI().getText();
        if (ti != null && !ti.isEmpty()) {
            ti = fixNumber(ti);
            double d = Double.parseDouble(ti);
            Double resultado = 1.0 / d;
            confControle.getTextKI().setText(resultado.toString());
        }
        System.out.println("ki2 " + confControle.getTextKI().getText());
        System.out.println("ti2 " + confControle.getTextTI().getText());
    }

    public static void updateTD() {
        String kd = confControle.getTextKD().getText();
        confControle.getTextTD().setText(kd);
    }

    public static void updateTI() {
        String td = confControle.getTextKI().getText();
        if (td != null && !td.isEmpty()) {
            td = fixNumber(td);
            double d = Double.parseDouble(td);
            Double resultado = 1.0 / d;
            confControle.getTextTI().setText(resultado.toString());
        }
        System.out.println("ki " + confControle.getTextKI().getText());
        System.out.println("ti " + confControle.getTextTI().getText());

    }

    private static String getKdValue() {
        boolean ok = confControle.getChkKD().isSelected();
        String kd = null;
        if (ok) {
            kd = confControle.getTextKD().getText();
        } else {
            kd = confControle.getTextTD().getText();
        }
        kd = fixNumber(kd);
        return kd;
    }

    private static String getKIValue() {
        boolean ok = confControle.getChkKI().isSelected();
        String ki = null;
        if (ok) {
            ki = confControle.getTextKI().getText();
            ki = fixNumber(ki);
        } else {
            String ti = confControle.getTextTI().getText();
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

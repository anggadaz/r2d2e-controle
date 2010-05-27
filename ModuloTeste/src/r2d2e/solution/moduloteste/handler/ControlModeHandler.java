package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.controlers.Controller;
import r2d2e.solution.moduloteste.controlers.ControllerCascade;
import r2d2e.solution.moduloteste.domain.AlgController;
import r2d2e.solution.moduloteste.domain.ConfigGerais;
import r2d2e.solution.moduloteste.domain.GenericXML;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.graph.ConfigGraph;
import r2d2e.solution.moduloteste.domain.graph.GraphNivel;
import r2d2e.solution.moduloteste.domain.graph.GraphControl;
import r2d2e.solution.moduloteste.domain.graph.GraphAction;
import r2d2e.solution.moduloteste.domain.graph.IGraphTime;
import r2d2e.solution.moduloteste.view.ConfParametros;
import r2d2e.solution.moduloteste.view.ControlPanel;
import r2d2e.solution.moduloteste.view.NovoFrame;
import r2d2e.solution.moduloteste.view.TanquePanel;

/**
 *
 * @author controle
 */
public class ControlModeHandler {

    private static TanquePanel tanquePanel;
    private static ControlPanel controlPanel;

    public static GraphNivel graphNivel;
    public static GraphControl graphTensao1;
    public static GraphAction graphTensao2;

    public static ConfigGraph configGraph;
    public static ConfigGerais configGerais;

    private static AlgController algController;
    private static Controller controllerSelected;
    private static ControllerCascade controllerCascade = new ControllerCascade();

    private static ConfParametros parametroNormal;
    private static ConfParametros parametrosMaster;
    private static ConfParametros parametrosSlave;


    public static void setIntegracaoCondi(boolean chk) {
        if (algController != null) {
            algController.setInteCondi(chk);
        }
    }

    public ControlModeHandler(NovoFrame frame) {

        tanquePanel = frame.getTanquePanel();
        controlPanel = frame.getControlPanel();

        parametroNormal = frame.getConfParametroNormal();
        parametrosMaster = frame.getConfParametroMaster();
        parametrosSlave = frame.getConfParametrosSlave();

        GenericXML genericXML = new GenericXML();
        configGraph = genericXML.readConfigGrafics();
        configGerais = genericXML.readConfigGerais();

        if(configGraph == null) {
            configGraph = new ConfigGraph();
        }

        if(configGerais == null) {
            configGerais = new ConfigGerais();
        }

        initChart();
    }

    public static void initChart() {
        graphNivel = new GraphNivel(300000, configGerais.CONTROLE);
        graphTensao1 = new GraphControl(300000, configGerais.CONTROLE);
        graphTensao2 = new GraphAction(300000, configGerais.CONTROLE);

        controlPanel.initChart();
        controlPanel.repaint();
    }

    public static IGraphTime[] getChart() {
        return new IGraphTime[]{graphNivel, graphTensao1, graphTensao2};
    }

    public static Controller getControllerSelected() {
        return controllerSelected;
    }

    public static void setControllerSelected(Controller controllerSelected) {
        ControlModeHandler.controllerSelected = controllerSelected;
    }

    public static void updateVariables() {

        if (configGerais.CONTROLE == ConfigGerais.C_TANQUE_CASCATA) {
            controllerCascade.updateParametros(parametrosMaster, parametrosSlave);
            controllerSelected = controllerCascade;

        } else {
            controllerSelected = parametroNormal.getSelectedController();
            controllerSelected.updateParametros(parametroNormal);
        }

        if (algController != null) {
            algController.setController(controllerSelected);
            algController.atualizarCriterioAcomodacao();
            algController.atualizarSetPoint(controllerSelected.getSetPoint());
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

    public void stop(Quanser quanser) {
        algController.setAtivo(false);
        quanser.stopMotor();
    }

    public static ControlPanel getControlPanel() {
        return controlPanel;
    }

    public static void atualizaOpcoes() {
        Quanser.setCALIBRATION1(configGerais.getCalibration(ConfigGerais.C_TANQUE1));
        Quanser.setCALIBRATION2(configGerais.getCalibration(ConfigGerais.C_TANQUE2));

        Quanser.setIP_QUANSER(configGerais.SERVIDOR);
    }
}

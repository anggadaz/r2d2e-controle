package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.UpdateWater;
import r2d2e.solution.moduloteste.domain.controlerInterface;
import r2d2e.solution.moduloteste.view.NovoFrame;
import r2d2e.solution.moduloteste.view.OpcoesGerais;

/**
 *
 * @author Rivaldo Jr
 */
public class MainFrameHandler {

    public static final int TEST_MOD = 0;
    public static final int CONTROL_MOD = 1;
    private NovoFrame mainFrame;
    private TestModeHandler testModeHandler;
    private ControlModeHandler controlModeHandler;
    private Quanser quanser;
    private UpdateWater updateWater;
    private int mode;

    public MainFrameHandler(NovoFrame mainFrame) {
        this.mainFrame = mainFrame;
        quanser = new Quanser();
        testModeHandler = new TestModeHandler(mainFrame, quanser);
        controlModeHandler = new ControlModeHandler(mainFrame);
        updateWater = new UpdateWater(100, mainFrame.getTanquePanel(), quanser);
    }

    public void enterTestMode() {

        if (mode == TEST_MOD) {
            return;
        }

        mode = TEST_MOD;
        // Trocar a carta
        mainFrame.changeCard(NovoFrame.CARD_CONF_TESTE);
    }

    public void enterControlMode() {

        if (mode == CONTROL_MOD) {
            return;
        }

        mode = CONTROL_MOD;
        // Trocar a carta
        mainFrame.changeCard(NovoFrame.CARD_CONF_CONTROLE);
    }

    public void play() {
        if (!quanser.isServerOk()) {
            quanser.connect();
            verifyCalibration();
            updateWater.start();
        }

        if (mode == TEST_MOD) {
            testModeHandler.initTest();
        }
        if (mode == CONTROL_MOD) {
            controlModeHandler.init(quanser);
        }
        mainFrame.getButtonPararTeste().setEnabled(true);
        mainFrame.getButtonIniciarTeste().setEnabled(false);
    }

    public void cycle() {
        if (mode == TEST_MOD) {
            testModeHandler.cycle();
        }
    }

    public void stop() {
        if (mode == TEST_MOD) {
            testModeHandler.stopTest();
        }
        if (mode == CONTROL_MOD) {
            controlModeHandler.stop(quanser);
        }
        mainFrame.getButtonPararTeste().setEnabled(false);
        mainFrame.getButtonIniciarTeste().setEnabled(true);
    }

    public void closeConnection() {
        quanser.closeConnection();
    }

    public void initOpcoesGerais() {
        OpcoesGerais gerais = new OpcoesGerais(mainFrame, true);
        gerais.setVisible(true);
    }

    private void verifyCalibration() {
        Double nivel_Min = quanser.readSensor1();
        controlerInterface.NIVEL_LOW_CALIBRATION = nivel_Min + 0.1;
        System.out.println("nivelMIN " + nivel_Min);
    }
}

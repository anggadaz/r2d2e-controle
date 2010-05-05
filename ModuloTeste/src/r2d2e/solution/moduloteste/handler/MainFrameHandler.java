package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.controlerInterface;
import r2d2e.solution.moduloteste.view.NovoFrame;
import r2d2e.solution.moduloteste.view.OpcoesGerais;
import r2d2e.solution.moduloteste.view.OpcoesGrafico;

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
    private int mode;

    public MainFrameHandler(NovoFrame mainFrame) {
        this.mainFrame = mainFrame;
        quanser = new Quanser();
        testModeHandler = new TestModeHandler(mainFrame, quanser);
        controlModeHandler = new ControlModeHandler(mainFrame);
       //updateWater = new UpdateWater(100, mainFrame.getTanquePanel(), );
    }

    public void enterTestMode() {

        if (mode == TEST_MOD) {
            return;
        }

        mode = TEST_MOD;
        // Trocar a carta
        mainFrame.changeCardConf(NovoFrame.CARD_CONF_TESTE);
        mainFrame.changeCardMain(NovoFrame.CARD_MAIN_TESTE);
    }

    public void enterControlMode() {

        if (mode == CONTROL_MOD) {
            return;
        }

        mode = CONTROL_MOD;
        // Trocar a carta
        mainFrame.changeCardConf(NovoFrame.CARD_CONF_CONTROLE);
        mainFrame.changeCardMain(NovoFrame.CARD_MAIN_CONTROLE);
    }

    public void play() {
        if (!quanser.isServerOk()) {
            quanser.connect();
            quanser.writeBomb(0);
            verifyCalibration();
            //updateWater.start();
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
        Double nivel_Min2 = quanser.readSensor2();
        Quanser.setCALIBRATION1(nivel_Min);
        Quanser.setCALIBRATION2(nivel_Min2);
        controlerInterface.NIVEL_LOW_CALIBRATION = nivel_Min + 0.1;
    }

    public void initOpcoesGrafico() {
        OpcoesGrafico janela = new OpcoesGrafico(mainFrame, true);
        janela.setVisible(true);
    }
}

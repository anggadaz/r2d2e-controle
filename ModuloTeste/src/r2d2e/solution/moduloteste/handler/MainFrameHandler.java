package r2d2e.solution.moduloteste.handler;

import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.view.NovoFrame;

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
        testModeHandler = new TestModeHandler(mainFrame,quanser);
        controlModeHandler = mainFrame.getConfControle().getControlModeHandler();
    }

    public void enterTestMode() {

        if(mode == TEST_MOD) {
            return;
        }

        mode = TEST_MOD;
        // Trocar a carta
        mainFrame.changeCard(NovoFrame.CARD_CONF_TESTE);
    }

    public void enterControlMode() {

        if(mode == CONTROL_MOD) {
            return;
        }

        mode = CONTROL_MOD;
        // Trocar a carta
        mainFrame.changeCard(NovoFrame.CARD_CONF_CONTROLE);
    }

    public void play() {
        if(mode == TEST_MOD) {
            testModeHandler.initTest();
        }
        if(mode == CONTROL_MOD) {
            controlModeHandler.init(quanser);
        }
    }

    public void cycle() {
        if(mode == TEST_MOD) {
            testModeHandler.cycle();
        }
    }

    public void stop() {
        if(mode == TEST_MOD) {
            testModeHandler.stopTest();
        }
    }
}

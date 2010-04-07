package r2d2e.solution.moduloteste.handler;

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

    private int mode;

    public MainFrameHandler(NovoFrame mainFrame) {
        this.mainFrame = mainFrame;
        testModeHandler = new TestModeHandler(mainFrame);
    }

    public void enterTestMode() {

        if(mode == TEST_MOD) {
            return;
        }

        mode = TEST_MOD;
        // Trocar a carta
    }

    public void enterControlMode() {

        if(mode == CONTROL_MOD) {
            return;
        }

        mode = CONTROL_MOD;
        // Trocar a carta
    }

    public void play() {
        if(mode == TEST_MOD) {
            testModeHandler.initTest();
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

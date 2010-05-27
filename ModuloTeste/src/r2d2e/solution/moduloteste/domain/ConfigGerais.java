package r2d2e.solution.moduloteste.domain;

/**
 *
 * @author Rivaldo Jr
 */
public class ConfigGerais {

    public static int MODO_TESTE = 0;
    public static int MODO_CONTROLE = 1;

    public static int C_TANQUE1 = 0;
    public static int C_TANQUE2 = 1;
    public static int C_TANQUE_CASCATA = 2;

    public int MODO = 1;
    public int CONTROLE = 0;

    public double CALIBRATION[] = {0,0};
    public boolean CAL_INICIAL = true;

    public String SERVIDOR = "10.13.99.69";

    public void setCalibration(int ix, double value) {
        CALIBRATION[ix] = value;
    }

    public double getCalibration(int ix) {
        return CALIBRATION[ix];
    }

    public void setModo(int m) {
        MODO = m;
    }

    public void save() {
        GenericXML genericXML = new GenericXML();
        genericXML.createXML(this);
    }

}

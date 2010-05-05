package r2d2e.solution.moduloteste.domain.graph;

/**
 *
 * @author Rivaldo Jr
 */
public class ConfigGraph {

    public static int NIVEL_TEMPO = 0;
    public static int SINAl_CONTROLE = 1;
    public static int ACAO_CONTROLE = 2;

    public static int MODO = 3;
    public static int GRAFICOS[] = {0,1,2};
    public static boolean EXTRA[] = {false, false, false};

    public static void setExtra(int ix, boolean active) {
        EXTRA[ix] = active;
    }

    public static void setGrafos(int ix, int grafico) {
        GRAFICOS[ix] = grafico;
    }

    public static void setModo(int m) {
        MODO = m;
    }

}

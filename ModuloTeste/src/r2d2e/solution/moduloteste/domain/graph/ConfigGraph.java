package r2d2e.solution.moduloteste.domain.graph;

import r2d2e.solution.moduloteste.domain.GenericXML;

/**
 *
 * @author Rivaldo Jr
 */
public class ConfigGraph {

    public static int NIVEL_TEMPO = 0;
    public static int SINAl_CONTROLE = 1;
    public static int ACAO_CONTROLE = 2;

    public int MODO = 3;
    public int GRAFICOS[] = {0,1,2};
    public boolean EXTRA[] = {false, false, false};

    public boolean JANELAEXTRA = false;

    public boolean seriesAction[] = {true, true, true, true};
    public boolean seriesNivel[] = {true, true, true, true, true, true};
    public boolean seriesControl[] = {true, true, true, true, true, true, true, true};

    public void setSeriesNivel(boolean serie[]) {
        seriesNivel = serie;
    }

    public void setSeriesAction(boolean[] seriesAction) {
        this.seriesAction = seriesAction;
    }

    public void setSeriesControl(boolean[] seriesControl) {
        this.seriesControl = seriesControl;
    }

    public void setExtra(int ix, boolean active) {
        EXTRA[ix] = active;
        JANELAEXTRA = EXTRA[0] || EXTRA[1] || EXTRA[2];
    }

    public void setGrafos(int ix, int grafico) {
        GRAFICOS[ix] = grafico;
    }

    public void setModo(int m) {
        MODO = m;
    }

    public void save() {
        GenericXML genericXML = new GenericXML();
        genericXML.createXML(this);
    }

}

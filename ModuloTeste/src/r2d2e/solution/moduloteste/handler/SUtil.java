package r2d2e.solution.moduloteste.handler;

import java.awt.Window;
import r2d2e.solution.moduloteste.view.ConfParametros;

/**
 *
 * @author Rivaldo Jr
 */
public class SUtil {

    public static String fixNumber(String numb) {
        return numb.replace(",", ".");
    }

    public static Double getSetPoint(ConfParametros parametros) {
        String nivel = parametros.getTextSetPoint().getText();
        nivel = SUtil.fixNumber(nivel);

        if (nivel != null) {
            return Double.parseDouble(nivel);
        }
        return null;
    }

    public static String getKdValue(ConfParametros parametros) {
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

    public static String getKIValue(ConfParametros parametros) {
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
    public static double twoPlaces(double n){
        double temp = n*100;
        temp = Math.ceil(temp);
        return temp/100;
    }

    public static void heightWindow(Window componente, int height, int duracao) {

        Window me = componente;

        int wInicial = me.getWidth();

        int inicial = me.getHeight();
        int change;
        int t = 0;
        int atual;

        change = height - inicial;
        atual = me.getHeight();

        if (atual > height) {
            while (atual > height) {

                me.setSize(wInicial, Math.round(easeIn(t++, inicial, change,
                        duracao)));
                me.repaint();

                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                }
                atual = me.getHeight();
            }

        } else {
            while (atual < height) {

                me.setSize(wInicial, Math.round(easeIn(t++, inicial, change,
                        duracao)));
                me.repaint();

                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                }
                atual = me.getHeight();
            }
        }
    }

    private static float easeIn(int time, int begginer, double change,
            int duration) {
        return (float) (change * time / duration + begginer);
    }
}

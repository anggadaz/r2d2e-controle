/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.domain;

import com.sun.j3d.utils.applet.MainFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import r2d2e.solution.tanksimulator.view.MainView;

/**
 *
 * @author demetrios
 */
public class UpdateStatus {

    private static JLabel icon;
    private static JLabel text;
    private static JTextField tensao;
    private static JTextField sensor1;
    private static JTextField sensor2;
    private static MainView mainView;
    public static String BLUE_STATUS = "/r2d2e/solution/tanksimulator/view/resource/ball_blue.png";
    public static String GREEN_STATUS = "/r2d2e/solution/tanksimulator/view/resource/ball_green.png";
    public static String RED_STATUS = "/r2d2e/solution/tanksimulator/view/resource/ball_red.png";
    public static String YELLOW_STATUS = "/r2d2e/solution/tanksimulator/view/resource/ball_yellow.png";
    public static int TENSAO = 0;
    public static int SENSOR1 = 1;
    public static int SENSOR2 = 2;

    public static void updateSatus(String iconImage, String txt) {
        ImageIcon i = new ImageIcon(mainView.getClass().getResource(iconImage));
        icon.setIcon(i);
        text.setText(txt);
    }

    public static void updateSatus(String iconImage) {
        ImageIcon i = new ImageIcon(mainView.getClass().getResource(iconImage));
        icon.setIcon(i);
    }

    public static void updateSatusText(String txt) {
        text.setText(txt);
    }

    public static void setInfo(int INF, String dado) {
        switch (INF) {
            case 0:
                tensao.setText(dado);
                break;
            case 1:
                sensor1.setText(dado);
                break;
            case 2:
                sensor2.setText(dado);
                break;
        }
    }

    public static void setIcon(JLabel icon) {
        UpdateStatus.icon = icon;
    }

    public static void setText(JLabel text) {
        UpdateStatus.text = text;
    }

    public static void setSensor1(JTextField sensor1) {
        UpdateStatus.sensor1 = sensor1;
    }

    public static void setSensor2(JTextField sensor2) {
        UpdateStatus.sensor2 = sensor2;
    }

    public static void setTensao(JTextField tensao) {
        UpdateStatus.tensao = tensao;
    }

    public static void setMainView(MainView mainView) {
        UpdateStatus.mainView = mainView;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.view;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 *
 * @author Demétrios
 */
public class TanquePanel extends JPanel {

    private BufferedImage tanqueImage;
    private BufferedImage waterImage;
    private int heightWater = 0;
    private int maxWidthWater;

    public TanquePanel() {
        loadImage();
        maxWidthWater = waterImage.getHeight();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(tanqueImage, 0, 50, null);
        g.drawImage(waterImage, 93, 62 + (maxWidthWater-heightWater), waterImage.getWidth(), heightWater, null);
    }
    
    @Override
    public Dimension getPreferredSize() {
        if (tanqueImage == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(tanqueImage.getWidth(null), tanqueImage.getHeight(null));
        }
    }

    public void setPercentWater(int PercentWater) {
        heightWater = (PercentWater * maxWidthWater) / 100;
        repaint();
    }

    private void loadImage() {
        try {
            tanqueImage = ImageIO.read(getClass().getResource("/solution/moduloteste/view/resources/tanque.jpg"));
            waterImage = ImageIO.read(getClass().getResource("/solution/moduloteste/view/resources/agua.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

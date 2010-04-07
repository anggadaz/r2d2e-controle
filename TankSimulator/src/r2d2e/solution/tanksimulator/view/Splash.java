package r2d2e.solution.tanksimulator.view;

/*
 * Splash.java
 *
 * Created on September 6, 2007, 8:15 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JWindow;

import org.openide.util.Exceptions;

/**
 *
 * @author Gustavo Leitão
 */
public class Splash extends JWindow {
    public static final String image = "/r2d2e/solution/tanksimulator/view/resource/r2d2e.jpg";
        
    // Imagem que ira aparecer no Splash    

    private Integer contSplash = 1;
    private int incremento = 1;
    
    Color color1;
    Color color2;
    
    private URL imgName = getClass().getResource(image);
    private static boolean loopThread = true;
    
    
    private Image splashImage;
    
    private static int roundIndex;
    private Thread myThread;
    
    private Paint gradientPaint;

    // Singleton pra garantir apenas uma unica instancia na memoria
    static {
        splash = new Splash();
    }

    public Splash()  {
        super();
        color1 = new Color(100,194,100);        
        color2 = new Color(73,114,73);                        
    }
    
    private static Splash splash;
    
    public static Splash getInstance(){
            return splash;
    }
    
    public void inicializaSplash()  {
        
        loopThread= true;
        
        splashImage = new ImageIcon(imgName).getImage();
        // Configura o tamanho do splash e a posicao na tela
        setSize(splashImage.getWidth(this), splashImage.getHeight(this));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = getSize();

        if (size.width > screenSize.width)
        size.width = screenSize.width;

        if (size.height > screenSize.height)
        size.height = screenSize.height;

        setLocation((screenSize.width - size.width) / 2, (screenSize.height - size.height) / 2);
        setVisible(true);       
        
        myThread = new Thread(){

            @Override
            public void run() {
                
                while(loopThread){
                    
                    paint(getGraphics());

                    try {
                        Thread.sleep(10);
                    }catch (InterruptedException ex) {
                        Exceptions.printStackTrace(ex);
                    }                    
                }                
            }
        };
        
        myThread.start();             
    }

    public void finalizaSplash() {
        loopThread = false;
        this.dispose();
    }
        
    private int countTxt = 0;    
    
    @Override
    public void paint(Graphics g1) {        

        Graphics2D g = (Graphics2D)g1;
        
        contSplash = contSplash + incremento;
        
        if (contSplash == 36 || contSplash == 1){
            incremento = -incremento;
        }        
        
        imgName = getClass().getResource(image);
        splashImage = new ImageIcon(imgName).getImage();
        
        g.drawImage(splashImage, 0, 0, getBackground(), this); 
        
                      
        final String[] pontos = {"", ".", "..", "..."};
                
        g.setPaintMode();
        g.setColor(new Color(73,85,6));
        
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString("Carregando"+pontos[roundIndex], 16, 386);
        countTxt++;        
        
        g.drawRect(0, 400, 540, 9);
        Rectangle bounds = getBounds();
        gradientPaint = new GradientPaint(0, (bounds.height/2), color1, bounds.width, bounds.height/2, color2);
        g.setPaint(gradientPaint);        
        g.fillRect(2, 402, 539, 6);
        
        if (countTxt > 10){
            
            color1 = new Color(73+countTxt,85+countTxt,6+countTxt);
            color2 = new Color(73,85,6);
            
            countTxt=0;
            roundIndex++;
        }
        
        if (roundIndex >= pontos.length){
            roundIndex = 0;
        }        
    }
}
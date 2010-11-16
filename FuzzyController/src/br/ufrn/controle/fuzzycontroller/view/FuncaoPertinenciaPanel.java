package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.FuncPertinence;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FuncaoPertinenciaPanel extends JPanel {

    private static int [] INPUT_SCALE = {0,5,10,15,20,25,30};
    private static int [] OUTPUT_SCALE = {-3,-2,-1,0,1,2,3};

    private ArrayList<FuncPertinence> funcs;
    private FuncPertinence dragTarget = null;

    private static int LIMITE_MIN = 10;
    private static int LIMITE_MAX = 20;
    private static int LIMITE_NUM = 2;

    private static int NUM_DIVISOES = 6;

    private boolean isOutput = false;

    public FuncaoPertinenciaPanel() {

        funcs = new ArrayList<FuncPertinence>();

//        funcs.add(new FuncaoTriangular(10,10,100,10,200));
//
//        funcs.add(new FuncaoTrapezoidal(new Point(10, 100), new Point(10, 10), new Point(100, 10), new Point(200,100)));

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boolean clicado = false;
                for (FuncPertinence funcaoPertinencia : funcs) {
                    if (funcaoPertinencia.contains(evt.getX(), evt.getY()) && !clicado) {
                        dragTarget = funcaoPertinencia;
                        dragTarget.mouseClicked();
                        clicado = true;
                    } else {
                        funcaoPertinencia.mouseClickedOut();
                    }
                }

                if (!clicado && dragTarget != null) {
                    dragTarget.mouseClickedOut();
                    dragTarget = null;
                }
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (dragTarget != null) {
                    dragTarget.mouseReleased(e);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (dragTarget != null) {
                    dragTarget.mousePressed(e);
                }
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                if (dragTarget != null) {
                    dragTarget.mouseDragged(evt);
                    repaint();
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // call superclass's paintComponent

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D

        drawAxis(g2d);
        drawScale(g2d);

        for (FuncPertinence funcaoPertinencia : funcs) {
            funcaoPertinencia.draw(g2d);
        }
    }

    private void drawScale(Graphics2D g2d)
    {
        GeneralPath path = new GeneralPath();

        g2d.setPaint(Color.MAGENTA);
        g2d.setStroke(new BasicStroke(2.0f));

        int posicao = LIMITE_MAX;
        int incrementoPixel = (getWidth() - 2 * LIMITE_MAX) / NUM_DIVISOES;

        // Eixo Y
        g2d.drawString("1", LIMITE_NUM, LIMITE_MAX);
        path.moveTo(LIMITE_MAX - 4, LIMITE_MAX);
        path.lineTo(LIMITE_MAX + 4, LIMITE_MAX);

        // Eixo X

        int[] scale;
        int deslocamento = 3;

        if (isOutput) {
            scale = OUTPUT_SCALE;
        } else {
            scale = INPUT_SCALE;
        }

        for (int i : scale) {

            g2d.drawString(Integer.toString(i), posicao-deslocamento, getHeight()-LIMITE_NUM);

            path.moveTo(posicao, getHeight() - LIMITE_MAX + 4);
            path.lineTo(posicao, getHeight() - LIMITE_MAX - 4);

            posicao += incrementoPixel;
        }

        g2d.draw(path);
    }

    private void drawAxis(Graphics2D g2d)
    {
        GeneralPath path = new GeneralPath();

        g2d.setPaint(Color.GRAY);
        g2d.setStroke(new BasicStroke(2.0f));

        // Eixo Y
        path.moveTo(LIMITE_MAX, LIMITE_MIN);
        path.lineTo(LIMITE_MAX, getHeight() - LIMITE_MIN);

        // Eixo X
        path.moveTo(LIMITE_MIN, getHeight() - LIMITE_MAX);
        path.lineTo(getWidth() - LIMITE_MIN, getHeight() - LIMITE_MAX);

        g2d.draw(path);

        //Seta em Y
        path.moveTo(LIMITE_MAX - 5, LIMITE_MIN);
        path.lineTo(LIMITE_MAX + 5, LIMITE_MIN);
        path.lineTo(LIMITE_MAX, LIMITE_MIN - 10);

        //Seta em x
        path.moveTo(getWidth() - LIMITE_MIN, getHeight() - LIMITE_MAX + 5);
        path.lineTo(getWidth() - LIMITE_MIN, getHeight() - LIMITE_MAX - 5);
        path.lineTo(getWidth() - LIMITE_MIN + 10, getHeight() - LIMITE_MAX);

        g2d.fill(path);
    }

    public void addFunc(FuncPertinence func) {

        if(func == null) {
            return;
        }

        funcs.add(func);
    }

    public ArrayList<FuncPertinence> getFuncsPertinencia() {
        return funcs;
    }

    public Point toPixelScale(Double pX, Double pY) {

        int limitReal;
        int limitPixel = getWidth() - 2*LIMITE_MAX;

        if(isOutput) {
            limitReal = OUTPUT_SCALE[NUM_DIVISOES] - OUTPUT_SCALE[0];
        } else {
            limitReal = INPUT_SCALE[NUM_DIVISOES] - INPUT_SCALE[0];
        }

        int altura;

        int x = (int) pX.doubleValue();
        int y = (x * limitPixel)/limitReal;

        y += (LIMITE_MAX);

        if(pY == 0) {
            altura = getHeight() - LIMITE_MAX;
        } else {
            altura = LIMITE_MAX;
        }

        return new Point(y,altura);
    }

    public Double toRealScale(Point point) {

        int limitReal;
        int limitPixel = getWidth() - 2*LIMITE_MAX;

        if(isOutput) {
            limitReal = OUTPUT_SCALE[NUM_DIVISOES] - OUTPUT_SCALE[0];
        } else {
            limitReal = INPUT_SCALE[NUM_DIVISOES] - INPUT_SCALE[0];
        }

        double x = point.x;
        Double y = (x * limitReal)/limitPixel;

        if(isOutput) {
            y += OUTPUT_SCALE[0];
        } else {
            y += INPUT_SCALE[0];
        }

        return y;
    }
}

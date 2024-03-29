package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.utils.Util;
import br.ufrn.controle.fuzzycontroller.view.retractable.ToolsPanel;
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

    private static final int FATOR = 100;

    private static final int MIN_DIV = 3;
    private static final int MAX_DIV = 8;

//    private static int [] INPUT_SCALE = {0,5,10,15,20,25,30};
//    private static int [] OUTPUT_SCALE = {-3,-2,-1,0,1,2,3};

    private ArrayList<Double> scale = new ArrayList<Double>();

    private ArrayList<FuncPertinence> funcs;
    private FuncPertinence dragTarget = null;

    private static int LIMITE_MIN = 10;
    private static int LIMITE_MAX = 20;
    private static int LIMITE_NUM = 2;

    private static int NUM_DIVISOES = 6;

    private boolean isOutput = false;

    public FuncaoPertinenciaPanel() {
        setBackground(new java.awt.Color(255, 255, 255));

        funcs = new ArrayList<FuncPertinence>();

//        funcs.add(new FuncaoTriangular(10,10,100,10,200));
//
//        funcs.add(new FuncaoTrapezoidal(new Point(10, 100), new Point(10, 10), new Point(100, 10), new Point(200,100)));

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                boolean clicado = false;
//                for (FuncPertinence funcaoPertinencia : funcs) {
//                    if (funcaoPertinencia.contains(evt.getX(), evt.getY()) && !clicado) {
//                        dragTarget = funcaoPertinencia;
//                        dragTarget.mouseClicked();
//                        clicado = true;
//                    } else {
//                        funcaoPertinencia.mouseClickedOut();
//                    }
//                }
//
//                if (!clicado && dragTarget != null) {
//                    dragTarget.mouseClickedOut();
//                    ToolsPanel.IODialog.clearFuncData();
//                    dragTarget = null;
//                }
//                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                boolean clicado = false;
                for (FuncPertinence funcaoPertinencia : funcs) {
                    if (funcaoPertinencia.contains(e.getX(), e.getY()) && !clicado) {
                        dragTarget = funcaoPertinencia;
                        dragTarget.mouseClicked();
                        clicado = true;
                    } else {
                        funcaoPertinencia.mouseClickedOut();
                    }
                }

                if (!clicado && dragTarget != null) {
                    dragTarget.mouseClickedOut();
                    if(IOPanel.FPanel != null) {
                        IOPanel.FPanel.clearFuncData();
                    }
                    dragTarget = null;
                }
                repaint();

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

    public void setRange(double min, double max) {

        scale.clear();

        double incremento;
        int div = MAX_DIV;

        int norma = (int) ( (max - min) * FATOR );

        while(div >= MIN_DIV && norma % div != 0) {
            div--;
        }

        NUM_DIVISOES = div;
        incremento = (norma/div);

        int minInt = (int)(min * FATOR);
        int maxInt = (int)(max * FATOR);

        for(int i = minInt; i <= maxInt; i += incremento) {
            scale.add(i/100.0);
        }

        for (FuncPertinence funcPertinence : funcs) {
            funcPertinence.recalculate();
        }

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g); // call superclass's paintComponent

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D

        drawAxis(g2d);
        drawScale(g2d);

        if(funcs != null) {
            for (FuncPertinence funcaoPertinencia : funcs) {
                funcaoPertinencia.draw(g2d);
            }
        }
    }

    public void setFuncs(ArrayList<FuncPertinence> funcs) {
        this.funcs = funcs;

        if(dragTarget != null) {
            dragTarget.mouseClickedOut();
            dragTarget = null;
        }

        repaint();
    }

    public void deletTarget() {

        if (dragTarget != null) {
            dragTarget.mouseClickedOut();
            funcs.remove(dragTarget);
            repaint();
        }
        
        dragTarget = null;
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

        int deslocamento = 3;

        for (double i : scale) {

            g2d.drawString(Double.toString(i), posicao-deslocamento, getHeight()-LIMITE_NUM);

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

        double limitReal;
        int limitPixel = getWidth() - 2*LIMITE_MAX;

        limitReal = scale.get(NUM_DIVISOES) - scale.get(0);

        int altura;

        double x = pX.doubleValue() - scale.get(0);
        int y = (int) ((x * limitPixel)/limitReal);

        y += (LIMITE_MAX);

        if(pY == 0) {
            altura = getHeight() - LIMITE_MAX;
        } else {
            altura = LIMITE_MAX;
        }

        return new Point(y,altura);
    }

    public Double toRealScale(Point point) {

        double limitReal;
        int limitPixel = getWidth() - 2*LIMITE_MAX;

        limitReal = scale.get(NUM_DIVISOES) - scale.get(0);

        double x = point.x;
        Double y = ((x-LIMITE_MAX) * limitReal)/limitPixel;

        y += scale.get(0);

        return y;
    }
}

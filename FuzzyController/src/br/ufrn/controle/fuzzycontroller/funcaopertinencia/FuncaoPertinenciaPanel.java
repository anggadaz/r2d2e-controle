package br.ufrn.controle.fuzzycontroller.funcaopertinencia;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import javax.swing.JPanel;

public class FuncaoPertinenciaPanel extends JPanel {

    private ArrayList<FuncaoPertinencia> funcs;
    private FuncaoPertinencia dragTarget = null;

    private int LIMITE_MIN = 10;
    private int LIMITE_MAX = 20;
    private int LIMITE_NUM = 2;

    private int RANGE_MIN = 0;
    private int RANGE_MAX = 1;

    public FuncaoPertinenciaPanel() {


        funcs = new ArrayList<FuncaoPertinencia>();

//        funcs.add(new FuncaoTriangular(10,10,100,10,200));
//
//        funcs.add(new FuncaoTrapezoidal(new Point(10, 100), new Point(10, 10), new Point(100, 10), new Point(200,100)));

        addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boolean clicado = false;
                for (FuncaoPertinencia funcaoPertinencia : funcs) {
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
//            public void mouseMoved(java.awt.event.MouseEvent evt) {
//                System.out.println("moved");
//            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // call superclass's paintComponent

        Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D

//        ArrayList<Area> x = new ArrayList<Area>();
        for (FuncaoPertinencia funcaoPertinencia : funcs) {
            funcaoPertinencia.draw(g2d);
//            x.add(new Area(funcaoPertinencia));
        }

//        Area y = new Area();
//
//        for (Area area : x) {
//            y.add(area);
//        }



//        g2d.draw(y);

        g2d.setPaint(Color.GRAY);
        g2d.setStroke(new BasicStroke(2.0f));

        GeneralPath reta = new GeneralPath();

        reta.moveTo(LIMITE_MAX, LIMITE_MIN);
        reta.lineTo(LIMITE_MAX, getHeight() - LIMITE_MIN);

        reta.moveTo(LIMITE_MIN, getHeight() - LIMITE_MAX);
        reta.lineTo(getWidth() - LIMITE_MIN, getHeight() - LIMITE_MAX);

        g2d.draw(reta);

        g2d.setPaint(Color.MAGENTA);
        g2d.setStroke(new BasicStroke(2.0f));

        int posicao = LIMITE_MAX;

        int incrementoPixel = (getWidth() - 2 * LIMITE_MAX) / 6;

        //Eixo X
        for (int i = -3; i <= 3; i++) {
            g2d.drawString(Integer.toString(i), posicao-3, getHeight()-LIMITE_NUM);
            reta.reset();
            reta.moveTo(posicao, getHeight() - LIMITE_MAX + 4);
            reta.lineTo(posicao, getHeight() - LIMITE_MAX - 4);

            g2d.draw(reta);

            posicao += incrementoPixel;
        }

        //Eixo Y
        g2d.drawString("1", LIMITE_NUM, LIMITE_MAX);
        reta.reset();
        reta.moveTo(LIMITE_MAX - 4, LIMITE_MAX);
        reta.lineTo(LIMITE_MAX + 4, LIMITE_MAX);

        g2d.draw(reta);

        //Seta em Y
        g2d.setPaint(Color.GRAY);
        reta.reset();
        reta.moveTo(LIMITE_MAX - 5, LIMITE_MIN);
        reta.lineTo(LIMITE_MAX + 5, LIMITE_MIN);
        reta.lineTo(LIMITE_MAX, LIMITE_MIN - 10);

        g2d.fill(reta);

        //Seta em x
        reta.reset();
        reta.moveTo(getWidth() - LIMITE_MIN, getHeight() - LIMITE_MAX + 5);
        reta.lineTo(getWidth() - LIMITE_MIN, getHeight() - LIMITE_MAX - 5);
        reta.lineTo(getWidth() - LIMITE_MIN + 10, getHeight() - LIMITE_MAX);

        g2d.fill(reta);

    }

    public void addFunc(FuncaoPertinencia func) {
        this.funcs.add(func);
    }

    public ArrayList<FuncaoPertinencia> getFuncsPertinencia() {
        return funcs;
    }
}

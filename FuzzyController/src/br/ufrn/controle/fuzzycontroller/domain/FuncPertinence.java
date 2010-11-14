/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.utils.Util;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.ArrayList;
import java.awt.Point;

/**
 *
 * @author Demetrios
 */
public class FuncPertinence extends Polygon {

    protected ArrayList<Line> lines;
    private String LinguisticTerm;

    private static final int GET_X = 10;
    private static final int GET_Y = 11;

    private ArrayList<Double> px = new ArrayList<Double>();
    private ArrayList<Double> py = new ArrayList<Double>();

    private Rectangle dragTarget = null;
    private ArrayList<Rectangle> retangs = new ArrayList<Rectangle>();

    private Color color = Color.BLACK;

    private int oldX = 0;

    public FuncPertinence(Point... p) {
        this();
        for (Point point : p) {
            addPoint(point.getX(), point.getY());
        }
    }
    
    public FuncPertinence() {
        lines = new ArrayList<Line>();
        LinguisticTerm = "";
    }

    public FuncPertinence(String LinguisticTerm) {
        this();
        this.LinguisticTerm = LinguisticTerm;
    }

//    public FuncPertinence(ArrayList<Line> lines, String LinguisticTerm) {
//        this.lines = lines;
//        this.LinguisticTerm = LinguisticTerm;
//    }

    /**
     * Metodo para avaliar o valor da funcao no ponto x. As classes filhas precisam
     * sobreescrever esse metodo.
     * @param x
     * @return
     */
    public double getRangeValue(double x) {
        return 0;
    }

//    public double getRangeValue(double value) {
//        double rangeValue = 0;
//
//        for (Line line : lines) {
//            rangeValue = line.RangeValue(value);
//            if (rangeValue != 0) {
//                break;
//            }
//        }
//
//        return rangeValue;
//    }

    public FuncPertinence cut(double rangeValue) {

        ArrayList<Double> xs = new ArrayList<Double>();

        FuncPertinence saida = new FuncPertinence();

        for (int i = 0; i < npoints-1; i++) {
            if (py.get(i)==0 && py.get(i+1) == 0) {
                continue;
            }

            double px1 = px.get(i);
            double py1 = py.get(i);
            double px2 = px.get(i+1);
            double py2 = py.get(i+1);

            double x = ((px2 - px1) / ((py2 - py1)) * (rangeValue - py1) + px1);

            xs.add(x);

            saida.addPoint(x, rangeValue);
            saida.addPoint(px.get(i), py.get(i));
            
        }
//        for (Line lineShape : lines) {
//
//            if (lineShape.getPoint1().getY() == 0 && lineShape.getPoint2().getY() == 0) {
//                continue;
//            }
//
//            double x = lineShape.domainValue(rangeValue);
//
//            xs.add(x);
//
////            Point endPoint = new Point(x, rangeValue);
////
////            Line newLine = new Line(endPoint, lineShape.getPoint1());
//
//            saida.addPoint(x, rangeValue);
//            saida.addPoint(lineShape.getPoint1().getX(), lineShape.getPoint1().getY());
//        }

        saida.addPoint(xs.get(0), rangeValue);
        saida.addPoint(xs.get(1), rangeValue);

        return saida;
    }

    public void addPoint(double x, double y) {
        //Converter para coordenada de pixels
        int xConvertido = (int) x;
        int yConvertido = (int) y;

        super.addPoint((int) x, (int) y);
        this.px.add(x);
        this.py.add(y);

        retangs.add(new Rectangle(xConvertido - 3, yConvertido - 3, 6, 6));
    }

//    public void setLines(ArrayList<Line> lines) {
//        this.lines = lines;
//    }



//    public void addLine(Line line) {
//        lines.add(line);
//    }

    public String getLinguisticTerm() {
        return LinguisticTerm;
    }

    public void setLinguisticTerm(String LinguisticTerm) {
        this.LinguisticTerm = LinguisticTerm;
    }

    public double[] getArrayOfX() {
        return Util.convertToArrayOfDouble(px);
    }

    public double[] getArrayOfY() {
        return Util.convertToArrayOfDouble(py);
    }

//    private double[] getArrayOfCoordenates(int axis) {
//
//        ArrayList<Double> out = new ArrayList<Double>();
//
//        for (int i = 0; i < lines.size(); i++) {
//
//            Line line = lines.get(i);
//
//            if (axis == GET_X) {
//                if (!out.contains(line.getPoint1().getX())) {
//                    out.add(line.getPoint1().getX());
//                }
//
//                if (!out.contains(line.getPoint2().getX())) {
//                    out.add(line.getPoint2().getX());
//                }
//            } else {
//                if (!out.contains(line.getPoint1().getY())) {
//                    out.add(line.getPoint1().getY());
//                }
//
//                if (!out.contains(line.getPoint2().getY())) {
//                    out.add(line.getPoint2().getY());
//                }
//            }
//
//        }
//
//        return Util.convertToArrayOfDouble(out);
//    }

    public FuncPertinence union(FuncPertinence shape) {
        FuncPertinence retorno = new FuncPertinence();
        double[] coords = new double[6];
        Area uniao = new Area(this);
        Area area = new Area(shape);

        uniao.add(area);

        PathIterator it = uniao.getPathIterator(null);
        
        while (!it.isDone()) {
            it.currentSegment(coords);
            retorno.addPoint((int) coords[0], (int) coords[1]);
            it.next();
        }
        return retorno;
    }

    public void draw(Graphics2D g) {
        GeneralPath path = new GeneralPath();

        path.moveTo(this.xpoints[0], this.ypoints[0]);
        for (int i = 1; i < npoints; i++) {
            path.lineTo(this.xpoints[i], this.ypoints[i]);
        }

        g.setPaint(color);
        g.draw(path);

        for (Rectangle rectangle : retangs) {
            g.fill(rectangle);
        }
    }
    public void fill(Graphics g) {
        g.fillPolygon(this);
    }

    public void mouseDragged(MouseEvent e) {
        if (dragTarget != null) {
            int index = retangs.indexOf(dragTarget);
            int direita = index + 1;
            int esquerda = index - 1;
            int x = e.getX();

            if (direita < retangs.size() && x > retangs.get(direita).x) {
                x = retangs.get(direita).x;
            }

            if (esquerda >= 0 && x < retangs.get(esquerda).x) {
                x = retangs.get(esquerda).x;
            }
            dragTarget.setLocation(x - 3, dragTarget.y);

            xpoints[retangs.indexOf(dragTarget)] = x;

        } else {
            this.translate(e.getX() - oldX, 0);

            for (Rectangle ret : retangs) {
                ret.translate(e.getX() - oldX, 0);

            }
        }
        oldX = e.getX();
        System.out.println("Drag");

    }

    public void mouseMoved(MouseEvent e) {
        System.out.println("Moved");
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Released");
        dragTarget = null;
    }

    public void mousePressed(MouseEvent e) {
        oldX = e.getX();

        if (dragTarget == null) {
            for (Rectangle ret : retangs) {
                if (ret.contains(e.getX(), e.getY())) {
                    dragTarget = ret;
                    break;
                }
            }
        }

        System.out.println(getRangeValue(e.getX()));
    }

    public void mouseClicked() {
        color = Color.RED;
    }

    public void mouseClickedOut() {
        color = Color.BLACK;
    }

    public double getMaxX() {
        double retorno = px.get(0);

        for (double valor : px) {
            if (retorno < valor) {
                retorno = valor;
            }
        }
        return retorno;
    }

    public double getMaxY() {
        double retorno = py.get(0);

        for (double valor : py) {
            if (retorno < valor) {
                retorno = valor;
            }
        }
        return retorno;
    }

    public double getMinX() {
        double retorno = px.get(0);

        for (double valor : px) {
            if (retorno > valor) {
                retorno = valor;
            }
        }
        return retorno;
    }

    public double getMinY() {
        double retorno = py.get(0);

        for (double valor : py) {
            if (retorno > valor) {
                retorno = valor;
            }
        }
        return retorno;
    }

    @Override
    public boolean contains(double x, double y) {
        if (npoints <= 2) {
            return false;
        }
        int hits = 0;

        int lastx = xpoints[npoints - 1];
        int lasty = ypoints[npoints - 1];
        int curx, cury;

        // Walk the edges of the polygon
        for (int i = 0; i < npoints; lastx = curx, lasty = cury, i++) {
            curx = xpoints[i];
            cury = ypoints[i];

            if (cury == lasty) {
                continue;
            }

            int leftx;
            if (curx < lastx) {
                if (x >= lastx) {
                    continue;
                }
                leftx = curx;
            } else {
                if (x >= curx) {
                    continue;
                }
                leftx = lastx;
            }

            double test1, test2;
            if (cury < lasty) {
                if (y < cury || y >= lasty) {
                    continue;
                }
                if (x < leftx) {
                    hits++;
                    continue;
                }
                test1 = x - curx;
                test2 = y - cury;
            } else {
                if (y < lasty || y >= cury) {
                    continue;
                }
                if (x < leftx) {
                    hits++;
                    continue;
                }
                test1 = x - lastx;
                test2 = y - lasty;
            }

            if (test1 < (test2 / (lasty - cury) * (lastx - curx))) {
                hits++;
            }
        }

        return ((hits & 1) != 0);
    }

}

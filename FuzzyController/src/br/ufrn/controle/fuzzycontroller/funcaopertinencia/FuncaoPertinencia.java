package br.ufrn.controle.fuzzycontroller.funcaopertinencia;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public abstract class FuncaoPertinencia extends Polygon {

    private int TOP;
    private int BOTTOM;

    private GeneralPath path = new GeneralPath();
    private Rectangle dragTarget = null;

    private ArrayList<Rectangle> retangs = new ArrayList<Rectangle>();
    private Color color = Color.BLACK;

    private int oldX = 0;

    public FuncaoPertinencia() {
        super();
    }

    public FuncaoPertinencia(Point... p) {
        for (Point point : p) {
            addPoint(point.x, point.y);
        }
    }

    /**
     * Funcao que avalia o valor de y da funcao. Eh necessario sobrescrever
     * @param x Valor de X
     * @return Retorna o valor de Y da funcao no ponto X.
     */
    public abstract double avaliate(int x);

    @Override
    public void addPoint(int x, int y) {
        super.addPoint(x, y);
        retangs.add(new Rectangle(x - 3, y - 3, 6, 6));
    }

    public void draw(Graphics2D g) {
        path.reset();

        path.moveTo(this.xpoints[0], this.ypoints[0]);
        for (int i = 1; i < npoints; i++) {
            path.lineTo(this.xpoints[i], this.ypoints[i]);
        }

        g.setPaint(color);
        g.draw(path);

        for (Rectangle rectangle : retangs) {
//            g.fillOval(rectangle.x-2, rectangle.y-2, 8, 8);
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

        System.out.println(avaliate(e.getX()));
    }

    public void mouseClicked() {
        color = Color.RED;
    }

    public void mouseClickedOut() {
        color = Color.BLACK;
    }

    public int getMaxX() {
        int retorno = xpoints[0];

        for (int x : xpoints) {
            if (retorno < x) {
                retorno = x;
            }
        }
        return retorno;
    }

    public int getMaxY() {
        int retorno = ypoints[0];

        for (int y : ypoints) {
            if (retorno < y) {
                retorno = y;
            }
        }
        return retorno;
    }

    public int getMinX() {
        int retorno = xpoints[0];

        for (int x : xpoints) {
            if (retorno > x) {
                retorno = x;
            }
        }
        return retorno;
    }

    public int getMinY() {
        int retorno = ypoints[0];

        for (int y : ypoints) {
            if (retorno > y) {
                retorno = y;
            }
        }
        return retorno;
    }

    public int getBOTTOM() {
        return BOTTOM;
    }

    public void setBOTTOM(int BOTTOM) {
        this.BOTTOM = BOTTOM;
    }

    public int getTOP() {
        return TOP;
    }

    public void setTOP(int TOP) {
        this.TOP = TOP;
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

    public Shape getShape() {
        return path;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

/**
 *
 * @author Demetrios
 */
public class Line {

    private Point point1;
    private Point point2;

    public Line(double x1, double y1, double x2, double y2) {
        point1 = new Point(x1, y1);
        point2 = new Point(x2, y2);
    }

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Line() {
        point1 = new Point(0, 0);
        point2 = new Point(0, 0);
    }

    public double distance() {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }

    public double RangeValue(double x) {

        if (x > point2.getX() || x < point1.getX()) {
            return 0;
        }

        double alpha = calculateCoeficientAngle();

        if (alpha == Integer.MAX_VALUE) {
            return point1.getY();
        } else {
            return alpha * (x - point1.getX()) + point1.getY();
        }
    }

    public double[] LineEquationCoeficients() {

        double alpha = calculateCoeficientAngle();

        //y - y1 = m(x-x1) = mx - y + (-mx1+y1)

        double a = alpha;
        double b = 1;
        double c = -alpha * point1.getX() + point1.getY();

        return new double[]{a, b, c};
    }

    public double domainValue(double y) {
        double alpha = calculateCoeficientAngle();

        return (y - point1.getY() + alpha * point1.getX()) / alpha;
    }

    private boolean isLineParallelEixoy() {

        double alpha = calculateCoeficientAngle();

        if (alpha == Integer.MAX_VALUE) {
            return true;
        } else {
            return false;
        }
    }

    private double calculateCoeficientAngle() {
        if (point2.getX() != point1.getX()) {
            return (point2.getY() - point1.getY()) / (point2.getX() - point1.getX());
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }
}

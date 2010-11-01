/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.utils.Util;
import java.util.ArrayList;

/**
 *
 * @author Demetrios
 */
public class Shape {

    protected ArrayList<Line> lines;
    private String LinguisticTerm;
    private static final int GET_X = 10;
    private static final int GET_Y = 11;

    public Shape() {
        lines = new ArrayList<Line>();
        LinguisticTerm = "";
    }

    public Shape(String LinguisticTerm) {
        this.LinguisticTerm = LinguisticTerm;
    }

    public Shape(ArrayList<Line> lines, String LinguisticTerm) {
        this.lines = lines;
        this.LinguisticTerm = LinguisticTerm;
    }

    public double getRangeValue(double value) {
        double rangeValue = 0;

        for (Line line : lines) {
            rangeValue = line.RangeValue(value);
            if (rangeValue != 0) {
                break;
            }
        }

        return rangeValue;
    }

    public Shape cut(double rangeValue) {

        ArrayList<Double> xs = new ArrayList<Double>();

        Shape saida = new Shape();

        for (Line lineShape : lines) {

            if (lineShape.getPoint1().getY() == 0 && lineShape.getPoint2().getY() == 0) {
                continue;
            }

            double x = lineShape.domainValue(rangeValue);

            xs.add(x);

            Point endPoint = new Point(x, rangeValue);

            Line newLine = new Line(endPoint, lineShape.getPoint1());

            saida.addLine(newLine);
        }

        saida.addLine(new Line(xs.get(0), rangeValue, xs.get(1), rangeValue));

        return saida;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public String getLinguisticTerm() {
        return LinguisticTerm;
    }

    public void setLinguisticTerm(String LinguisticTerm) {
        this.LinguisticTerm = LinguisticTerm;
    }

    public double[] getArrayOfX(){
        return getArrayOfCoordenates(GET_X);
    }
    
    public double[] getArrayOfY(){
        return getArrayOfCoordenates(GET_Y);
    }

    private double[] getArrayOfCoordenates(int axis) {

        ArrayList<Double> out = new ArrayList<Double>();

        for (int i = 0; i < lines.size(); i++) {

            Line line = lines.get(i);

            if (axis == GET_X) {
                if (!out.contains(line.getPoint1().getX())) {
                    out.add(line.getPoint1().getX());
                }

                if (!out.contains(line.getPoint2().getX())) {
                    out.add(line.getPoint2().getX());
                }
            } else {
                if (!out.contains(line.getPoint1().getY())) {
                    out.add(line.getPoint1().getY());
                }

                if (!out.contains(line.getPoint2().getY())) {
                    out.add(line.getPoint2().getY());
                }
            }
            
        }

        return Util.convertToArrayOfDouble(out);
    }

    public Shape union(Shape shape) {
        return null;
    }


}

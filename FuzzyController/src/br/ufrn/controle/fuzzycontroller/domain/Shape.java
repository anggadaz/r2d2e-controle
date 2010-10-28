/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import java.util.ArrayList;

/**
 *
 * @author Demetrios
 */
public class Shape {

    protected ArrayList<Line> lines;

    public Shape() {
        lines = new ArrayList<Line>();
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

    public ArrayList<Line> getLines() {
        return lines;
    }

    public void setLines(ArrayList<Line> lines) {
        this.lines = lines;
    }

    public void addLine(Line line) {
        lines.add(line);
    }
}

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

    protected ArrayList<Integer> points;

    public Shape() {
        this.points = new ArrayList<Integer>();
    }

    public int countPoints() {
        return points.size();
    }

    public ArrayList<Integer> getPoints() {
        return points;
    }
}

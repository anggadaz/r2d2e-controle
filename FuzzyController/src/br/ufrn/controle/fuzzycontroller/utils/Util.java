/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.utils;

import java.util.ArrayList;

/**
 *
 * @author demetrios
 */
public class Util {

    private static final int GET_MIN = 50;
    private static final int GET_MAX = 51;

    public static double[] convertToArrayOfDouble(ArrayList<Double> elements) {
        double[] doubles = new double[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            Double double1 = elements.get(i);
            doubles[i] = double1;
        }

        return doubles;
    }

    public static int[] convertToIntegerArray(ArrayList<Integer> elements) {
        int[] ints = new int[elements.size()];

        for (int i = 0; i < elements.size(); i++) {
            int ele = elements.get(i);
            ints[i] = ele;
        }

        return ints;
    }

    public static int[] min(double[] elements) {
        return maxMin(elements, GET_MIN);
    }

    public static int[] max(double[] elements) {
        return maxMin(elements, GET_MAX);
    }

    private static int[] maxMin(double[] elements, int getMax) {

        double maxMinNumber = elements[0];

        ArrayList<Integer> out = new ArrayList<Integer>();

        for (int i = 1; i < elements.length; i++) {

            double d = elements[i];

            boolean ok = false;

            if (getMax == GET_MAX) {
                if (d > maxMinNumber) {
                    ok = true;
                } else {
                    ok = false;
                }
            } else {
                if (d < maxMinNumber) {
                    ok = true;
                } else {
                    ok = false;
                }
            }

            if (ok) {
                maxMinNumber = d;
                out.clear();
                out.add(i);
            } else if (d == maxMinNumber) {
                out.add(i);
            }

        }

        return convertToIntegerArray(out);
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.utils.Util;
import java.util.AbstractList;
import java.util.ArrayList;

/**
 *
 * @author demetrios
 */
public class Defuzzification {

    private int defuzzificationType;

    public Defuzzification(int defuzzificationType) {
        this.defuzzificationType = defuzzificationType;
    }

    public double defuzzificate(FunctionOutPut functionOutPut) {

        FuncPertinence shape = functionOutPut.getPertinence();
        Expression expression = functionOutPut.getExpression();
        switch (defuzzificationType) {
            case ConstantsFuzzy.DEFUZZI_CENTROID:
                return centroid(shape);
            case ConstantsFuzzy.DEFUZZI_SOM:
                return som(shape);
            case ConstantsFuzzy.DEFUZZI_LOM:
                return lom(shape);
            case ConstantsFuzzy.DEFUZZI_MOM:
                return mom(shape);
            case ConstantsFuzzy.DEFUZZI_SUGENO:
                return sugeno(expression);
            default:
                return 0;
        }

    }

    private double centroid(FuncPertinence shape) {
        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        if (xs.length <= 0) {
            return 0;
        }

        ArrayList<double[]> points = putLimit(xs, ys);

        double[] centroPoint = Geometry.computePolygonCentroid(points.get(0), points.get(1));

        return centroPoint[0];
    }

    private double som(FuncPertinence shape) {
        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        if (xs.length <= 0) {
            return 0;
        }

        ArrayList<double[]> points = putLimit(xs, ys);

        int indeys[] = Util.max(points.get(1));

        return points.get(0)[indeys[0]];
    }

    private double lom(FuncPertinence shape) {

        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        if (xs.length <= 0) {
            return 0;
        }

        ArrayList<double[]> points = putLimit(xs, ys);

        int indeys[] = Util.max(points.get(1));

        return points.get(0)[indeys[indeys.length - 1]];
    }

    private double mom(FuncPertinence shape) {
        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        if (xs.length <= 0) {
            return 0;
        }

        ArrayList<double[]> points = putLimit(xs, ys);

        int indeys[] = Util.max(points.get(1));

        xs = points.get(0);
        ys = points.get(1);

        if (indeys.length == 1) {
            return xs[indeys[0]];
        }

        if (indeys.length > 2) {
            System.out.println("INDEX ACIMA DE 2");
//            return 0;
        }

        double x1 = xs[indeys[0]];
        double x2 = xs[indeys[1]];

        double diff = x2 - x1;

        return x1 + diff / 2;
    }

    private ArrayList<double[]> putLimit(double x[], double y[]) {

        ArrayList<double[]> saida = new ArrayList<double[]>();

        if (x.length != y.length) {
            System.out.println("LISTA COM TAMANHOS DIFERENTES");
            return null;
        }

        int n = x.length;

        ArrayList<Double> xs = new ArrayList<Double>();
        ArrayList<Double> ys = new ArrayList<Double>();

        for (int i = 0; i < n - 1; i++) {

            double px1 = x[i];
            double py1 = y[i];
            double px2 = x[i + 1];
            double py2 = y[i + 1];

            if (px2 > 3) {
                double y5 = ((py2 - py1) / (px2 - px1)) * (3 - px1) + py1;
                px2 = 3;
                py2 = y5;

                xs.add(px1);
                xs.add(px2);
                ys.add(py1);
                ys.add(py2);

                break;
            }

            xs.add(px1);
            ys.add(py1);
        }


        saida.add(Util.convertToArrayOfDouble(xs));
        saida.add(Util.convertToArrayOfDouble(ys));

        return saida;
    }

    private double sugeno(Expression expression) {
        return expression.evaluate(new DataIn());
    }

    public int getDefuzzificationType() {
        return defuzzificationType;
    }

    public void setDefuzzificationType(int defuzzificationType) {
        this.defuzzificationType = defuzzificationType;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.utils.Util;

/**
 *
 * @author demetrios
 */
public class Defuzzification {

    private int defuzzificationType;

    public Defuzzification() {
    }

    public double defuzzificate(Shape shape) {

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
                return sugeno(shape);
            default:
                return 0;
        }

    }

    private double centroid(Shape shape) {
        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        double[] centroPoint = Geometry.computePolygonCentroid(xs, ys);

        return centroPoint[0];
    }

    private double som(Shape shape) {
        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        int indeys[] = Util.max(ys);

        return xs[indeys[0]];
    }

    private double lom(Shape shape) {

        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        int indeys[] = Util.max(ys);

        return xs[indeys[indeys.length - 1]];
    }

    private double mom(Shape shape) {
        double[] xs = shape.getArrayOfX();
        double[] ys = shape.getArrayOfY();

        int indeys[] = Util.max(ys);

        if (indeys.length == 1) {
            return xs[indeys[0]];
        }

        double xSum = 0;
        for (int i = 0; i < indeys.length; i += 2) {

            if (i == indeys.length) {
                xSum += xs[indeys[i]];
            } else {
                int y = indeys[i];
                int y1 = indeys[i + 1];

                double xDiff = xs[y1] - xs[y];
                xSum += xDiff;
            }
        }

        return xSum/2;
    }
    private double sugeno(Shape shape){
        return shape.getArrayOfX()[0];
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.teste;

import br.ufrn.controle.fuzzycontroller.domain.DataIn;
import br.ufrn.controle.fuzzycontroller.domain.Mamdani;
import br.ufrn.controle.fuzzycontroller.domain.Line;
import br.ufrn.controle.fuzzycontroller.domain.Rule;
import br.ufrn.controle.fuzzycontroller.domain.Shape;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;

/**
 *
 * @author Demetrios
 */
public class main {

    public static void main(String args[]) {
        Mamdani inference = new Mamdani();

        Shape s = new Shape();

        s.addLine(new Line(0, 0, 3, 1));
        s.addLine(new Line(6, 0, 3, 1));
        s.addLine(new Line(0, 0, 6, 0));

        Shape i1 = new Shape();

        i1.addLine(new Line(1, 0, 3, 1));
        i1.addLine(new Line(5, 0, 3, 1));
        i1.addLine(new Line(1, 0, 5, 0));

        Shape i2 = new Shape();

        i2.addLine(new Line(0, 0, 1, 1));
        i2.addLine(new Line(1, 1, 3, 1));
        i2.addLine(new Line(3, 1, 5, 0));
        i2.addLine(new Line(0, 0, 5, 0));

        Rule r = new Rule();

//        r.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK1, i1);
//        r.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK1, i2);
        r.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, s);

        DataIn dataIn = new DataIn();
        dataIn.addValue(ConstantsFuzzy.VARIABLE_ERROR_TANK1, 0.3d);
        dataIn.addValue(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK1,2d);

//        inference.avaliateRule(r,dataIn);
    }
}

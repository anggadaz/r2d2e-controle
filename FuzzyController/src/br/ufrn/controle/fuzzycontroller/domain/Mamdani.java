/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import java.util.ArrayList;
import org.openide.util.Exceptions;

/**
 *
 * @author Demetrios
 */
public class Mamdani extends Inference{

    private final int numbThreads = 2;

    public Mamdani(RuleBase ruleBase) {
        super(ruleBase);
    }

    public FunctionOutPut work(DataIn dataIn) {

        ArrayList<Rule> rules = ruleBase.getRules();

        FuncPertinence shapeOut = new FuncPertinence(null);

        RulesAvaliationThread rats[] = new RulesAvaliationThread[numbThreads];

        int lengthPerThread = rules.size() / numbThreads;
        int rest = rules.size() % numbThreads;

        for (int i = 0; i < numbThreads - 1; i++) {
            rats[i] = new RulesAvaliationThread(i, i * lengthPerThread, lengthPerThread, rules, dataIn, shapeOut,andFunction);
        }

        rats[numbThreads - 1] = new RulesAvaliationThread(numbThreads - 1, numbThreads - 1 * lengthPerThread, lengthPerThread + rest, rules, dataIn, shapeOut,andFunction);

        for (int i = 0; i < numbThreads; i++) {
            rats[i].start();
        }

        for (int i = 0; i < numbThreads; i++) {
            try {
                rats[i].join();
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
        }

        return new FunctionOutPut(shapeOut);
    }
}

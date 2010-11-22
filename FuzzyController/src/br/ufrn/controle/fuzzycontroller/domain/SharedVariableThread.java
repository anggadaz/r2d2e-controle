/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncPertinence;

/**
 *
 * @author Demetrios
 */
public class SharedVariableThread {

    private FuncPertinence pertinence;

    public SharedVariableThread(FuncPertinence pertinence) {
        this.pertinence = pertinence;
    }

    public FuncPertinence getPertinence() {
        return pertinence;
    }

    public void setPertinence(FuncPertinence pertinence) {
        this.pertinence = pertinence;
    }
}

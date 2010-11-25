/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.teste;

import br.ufrn.controle.fuzzycontroller.quanser.Quanser;

/**
 *
 * @author Demetrios
 */
public class main {

    public static void main(String args[]) {
        Quanser q = new Quanser();
        q.connect();
        while(true){
            System.out.println("read1 " + q.readSensor1());
            System.out.println("read2 " + q.readSensor2());
        }
    }
}

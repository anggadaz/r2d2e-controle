/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.controle.fuzzycontroller.domain;

import java.text.DecimalFormat;
import javax.swing.JTextField;

/**
 *
 * @author Rivaldo Jr
 */
public class Statistics {

    JTextField over, rise, peek, acom;

    public Statistics(JTextField over, JTextField rise, JTextField peek, JTextField acom ) {
        this.over = over;
        this.rise = rise;
        this.peek = peek;
        this.acom = acom;
    }

    public void setOvershoot(Double d) {
        if(d != null) {
            DecimalFormat decimal = new DecimalFormat("0.00");
            String valorFormatado = decimal.format(d);
            over.setText(valorFormatado);
        }
    }

    public void setRiseTime(String s) {
        rise.setText(s);
    }

    public void setPeekTime(double d) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        String valorFormatado = decimal.format(d);
        peek.setText(valorFormatado);
    }

    public void setAcomodation(String s) {
        acom.setText(s);
    }

    public void clear() {
        over.setText("");
        rise.setText("");
        peek.setText("");
        acom.setText("");
    }


}

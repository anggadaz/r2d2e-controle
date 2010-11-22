/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.view.IOPanel;
import br.ufrn.siga.component.translucent.TranslucentButton;
import java.util.ArrayList;

/**
 *
 * @author Rivaldo Jr
 */
public class InputOutput extends TranslucentButton {

    public static int INPUT = 0;
    public static int OUTPUT = 1;
    public static int OUTPUT_SUGENO = 2;

    private int type = INPUT;
    private String variable = ConstantsFuzzy.VARIABLE_ERROR_TANK1;
    private String range = "";

    private IOPanel panel;

    ArrayList<FuncPertinence> funcs = new ArrayList<FuncPertinence>();

    public InputOutput() {
        super();
        addMouseEvent();
    }

    public InputOutput(int tipo, IOPanel parent) {
        super();
        setType(tipo);
        panel = parent;
        addMouseEvent();
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
        setToolTipText(variable);
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;

        if(type == INPUT) {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/circle_green.png")));
        } else {
            setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/circle_red.png")));
        }

    }

    public ArrayList<FuncPertinence> getFuncs() {
        return funcs;
    }

    public void setFuncs(ArrayList<FuncPertinence> funcs) {
        this.funcs = funcs;
    }

    public void addFunction(FuncPertinence fun) {
        funcs.add(fun);
    }

    public void removeFunction(FuncPertinence fun) {
        funcs.remove(fun);
    }

    private void addMouseEvent() {
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                myMouseReleased(evt);
            }
        });
    }

    public void select(boolean bool) {
        if(bool) {
            if(type == INPUT) {
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/selected_circle_green.png")));
            } else {
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/selected_circle_red.png")));
            }
        } else {
            if(type == INPUT) {
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/circle_green.png")));
            } else {
                setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/circle_red.png")));
            }
        }
    }

    private void myMouseReleased(java.awt.event.MouseEvent evt) {
        if (panel != null) {
            panel.setSelected(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj != null && obj instanceof InputOutput) {
            InputOutput temp = (InputOutput) obj;
            return variable.equals(temp.getVariable()) && range.equals(temp.getRange());
        }

        return false;
    }


}

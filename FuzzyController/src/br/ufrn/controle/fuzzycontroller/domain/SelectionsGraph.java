/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

/**
 *
 * @author Demetrios
 */
public class SelectionsGraph {

    private boolean level1Selected = true;
    private boolean level2Selected = true;
    private boolean error1Selected = true;
    private boolean error2Selected = true;
    private boolean setPointSelected = true;

    public boolean isError1Selected() {
        return error1Selected;
    }

    public void setError1Selected(boolean error1Selected) {
        this.error1Selected = error1Selected;
    }

    public boolean isError2Selected() {
        return error2Selected;
    }

    public void setError2Selected(boolean error2Selected) {
        this.error2Selected = error2Selected;
    }

    public boolean isLevel1Selected() {
        return level1Selected;
    }

    public void setLevel1Selected(boolean level1Selected) {
        this.level1Selected = level1Selected;
    }

    public boolean isLevel2Selected() {
        return level2Selected;
    }

    public void setLevel2Selected(boolean level2Selected) {
        this.level2Selected = level2Selected;
    }

    public boolean isSetPointSelected() {
        return setPointSelected;
    }

    public void setSetPointSelected(boolean setPoint) {
        this.setPointSelected = setPoint;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.ufrn.controle.fuzzycontroller.shared;

/**
 *
 * @author Demetrios
 */
public class ConstantsFuzzy {

    public static int criterio = 2;
    public static double setPoint = 15;

    public static final int MAMDAMI_TYPE = 1;
    public static final int TAKAGI_SUGENO_TYPE = 2;

    public static final int MIN_FUNCTION = 3;
    public static final int PROD_FUNCTION = 4;

    public static final int DEFUZZI_CENTROID = 5;
    public static final int DEFUZZI_SOM = 6;
    public static final int DEFUZZI_MOM = 7;
    public static final int DEFUZZI_LOM = 8;
    public static final int DEFUZZI_SUGENO = 9;

    public static final String MAMDAMI = "Mamdami";
    public static final String TAKAGI_SUGENO = "Takagi - Sugeno";

    public static final String VARIABLE_ERROR_TANK1 = "Erro Tanque 1";
    public static final String VARIABLE_ERROR_TANK2 = "Erro Tanque 2";
    public static final String VARIABLE_DERIVATIVE_TANK1 = "Derivada Tanque 1";
    public static final String VARIABLE_DERIVATIVE_TANK2 = "Derivada Tanque 2";
    public static final String VARIABLE_LEVEL1 = "Nível Tanque 1";
    public static final String VARIABLE_LEVEL2 = "Nível Tanque 2";

    public static final String VARIABLE_OUTPUT = "Saída";

    public static final String[] VARIABLES = new String[]{VARIABLE_ERROR_TANK1,VARIABLE_ERROR_TANK2,VARIABLE_DERIVATIVE_TANK1,VARIABLE_DERIVATIVE_TANK2,
        VARIABLE_LEVEL1,VARIABLE_LEVEL2,VARIABLE_OUTPUT};


}

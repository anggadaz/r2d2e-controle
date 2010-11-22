/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.controle.fuzzycontroller.domain;

import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import java.util.HashMap;

/**
 *
 * @author Demetrios
 */
public class Rule {

    private HashMap<String, PremiseInfo> premises;
    private HashMap<String, FunctionOutPut> functionOuts;

    public Rule() {
        premises = new HashMap<String, PremiseInfo>();
        functionOuts = new HashMap<String, FunctionOutPut>();
    }

    public void addPremise(String Variable, boolean isOperationNot, FuncPertinence geometry) {
        premises.put(Variable, new PremiseInfo(geometry, isOperationNot));
    }

    public void addFunctionOut(String variable, boolean isOperationNot, FuncPertinence shape) {
        FunctionOutPut func = new FunctionOutPut(shape);
        func.setOperationNot(isOperationNot);
        functionOuts.put(variable, func);
    }

    public void addFunctionOut(String variable, FuncPertinence shape) {
        FunctionOutPut func = new FunctionOutPut(shape);
        functionOuts.put(variable, func);
    }

    public void addFunctionOut(String variable, Expression expression) {
        FunctionOutPut func = new FunctionOutPut(expression);
        functionOuts.put(variable, func);
    }

    public FuncPertinence getInputShape(String var) {
        PremiseInfo info = premises.get(var);
        return info != null ? info.getShape() : null;
    }

    public FuncPertinence getOutPutShape(String var) {
        FunctionOutPut func = functionOuts.get(var);
        return func != null ? func.getPertinence() : null;
    }

    public Expression getOutPutExpression(String var) {
        FunctionOutPut func = functionOuts.get(var);
        return func != null ? func.getExpression() : null;
    }

    public boolean isOperationNot(String var) {
        PremiseInfo info = premises.get(var);
        return info != null ? info.isOperationNot() : false;
    }

    @Override
    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append("Se ");
        for (String entrada : premises.keySet()) {
            retorno.append("(");
            retorno.append(entrada);
            retorno.append(" é ");
            retorno.append(premises.get(entrada).isOperationNot() ? "não " : "");
            retorno.append(premises.get(entrada).getShape());
            retorno.append(") e ");
        }

        if (retorno.toString().trim().endsWith("e")) {
            int index = retorno.lastIndexOf("e");
            retorno.replace(index, retorno.length() - 1, "");
        }

        retorno.append(" Então (Saída é ");
        retorno.append(functionOuts.get(ConstantsFuzzy.VARIABLE_OUTPUT).isOperationNot() ? "não " : "");
        retorno.append(functionOuts.get(ConstantsFuzzy.VARIABLE_OUTPUT).getPertinence());
        retorno.append(")");

        return retorno.toString();
    }
}

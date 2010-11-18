/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainView.java
 *
 * Created on 21/10/2010, 23:48:25
 */
package br.ufrn.controle.fuzzycontroller.view;

import br.ufrn.controle.fuzzycontroller.domain.DataBase;
import br.ufrn.controle.fuzzycontroller.domain.Defuzzification;
import br.ufrn.controle.fuzzycontroller.domain.Expression;
import br.ufrn.controle.fuzzycontroller.domain.FuncPertinence;
import br.ufrn.controle.fuzzycontroller.domain.FuzzyController;
import br.ufrn.controle.fuzzycontroller.domain.Mamdani;
import br.ufrn.controle.fuzzycontroller.domain.Rule;
import br.ufrn.controle.fuzzycontroller.domain.RuleBase;
import br.ufrn.controle.fuzzycontroller.domain.SelectionsGraph;
import br.ufrn.controle.fuzzycontroller.domain.Sugeno;
import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncaoTrapezoidal;
import br.ufrn.controle.fuzzycontroller.funcaopertinencia.FuncaoTriangular;
import br.ufrn.controle.fuzzycontroller.shared.ConstantsFuzzy;
import br.ufrn.controle.fuzzycontroller.view.retractable.EmptyPanel;
import br.ufrn.controle.fuzzycontroller.view.retractable.FuzzyRetractable;
import br.ufrn.controle.fuzzycontroller.view.retractable.TankOptionsPanel;
import br.ufrn.controle.fuzzycontroller.view.retractable.ToolsPanel;
import br.ufrn.siga.component.retractable.RetractablePanel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author demetrios
 */
public class MainView extends javax.swing.JFrame {

    private FuzzyRetractable retractable;
    private RetractablePanel panelEmpty;
    private float crossSizeLock = 0.69f;
    private ArrayList<FuzzyController> controllers;
    private FuzzyController controllerSelected;
    private SelectionsGraph selectionsGraph;

    /** Creates new form MainView */
    public MainView() {
        initComponents();
        init();
    }

    private void init() {
        controllers = new ArrayList<FuzzyController>();
        retractable = new FuzzyRetractable(getLayeredPane());
        selectionsGraph = new SelectionsGraph();
        RetractablePanel toolRetractable = new RetractablePanel(retractable, new ToolsPanel(this), "Configuração", true);
        panelEmpty = new RetractablePanel(retractable, new EmptyPanel(), "", false);
        panelEmpty.setCrossSizeLock(Math.round(getWidth() * crossSizeLock));
        retractable.add(toolRetractable);
        retractable.add(panelEmpty);
        retractable.add(new RetractablePanel(retractable, new TankOptionsPanel(selectionsGraph, graphLevel.getGraphHandler()), "Opções De Gráficos", true));
        setPreferredSize(new Dimension(996, 550));
        setMinimumSize(new Dimension(996, 550));
        initialConfiguration();
        ConstantsFuzzy.setPoint = 15d;
    }

    @Override
    public void paint(Graphics g) {
        panelEmpty.setCrossSizeLock(Math.round(getWidth() * crossSizeLock));
        super.paint(g);

    }

    private void initialConfiguration() {
        createMandaniInitial();
        createSugenoInitial();
    }

    private void createMandaniInitial() {
        FuncaoTriangular errorNG = new FuncaoTriangular("ENG", new double[]{-54, -30, -8.333});
        FuncaoTriangular errorNM = new FuncaoTriangular("ENM", new double[]{-10.1, -5.159, 0});
        FuncaoTriangular errorZ = new FuncaoTriangular("EZ", new double[]{-1, 0, 1});
        FuncaoTriangular errorPM = new FuncaoTriangular("EPM", new double[]{0, 2.302, 10.7});
        FuncaoTriangular errorPG = new FuncaoTriangular("EPG", new double[]{5.952, 30, 54});

        FuncaoTriangular derErrorVN = new FuncaoTriangular("VN", new double[]{-1.445, -0.8, -0.0133});
        FuncaoTriangular derErrorVZ = new FuncaoTriangular("VZ", new double[]{-0.05, 0, 0.05});
        FuncaoTriangular derErrorVP = new FuncaoTriangular("VP", new double[]{0.01333, 0.8, 1.44});

        FuncaoTriangular outTNG = new FuncaoTriangular("TNG", new double[]{-5.71, -3.03, -1.04});
        FuncaoTriangular outTN = new FuncaoTriangular("TN", new double[]{-1.96, -1.02, -0.262});
        FuncaoTriangular outTZ = new FuncaoTriangular("TZ", new double[]{-0.389, 0.03968, 0.389});
        FuncaoTriangular outTP = new FuncaoTriangular("TP", new double[]{0.246, 1.02, 2.024});
        FuncaoTrapezoidal outTPG = new FuncaoTrapezoidal("TPG", new double[]{1.611, 2.02, 3.55, 4.86});
//--------------------------Erro negativo grande -------------------------------
        Rule rule1 = new Rule();
        rule1.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNG);
        rule1.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule1.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTNG);

        Rule rule2 = new Rule();
        rule2.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNG);
        rule2.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule2.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTNG);

        Rule rule3 = new Rule();
        rule3.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNG);
        rule3.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule3.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTN);
//-------------------------------------------------------------------------------
//--------------------------Erro negativo Médio -------------------------------
        Rule rule4 = new Rule();
        rule4.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNM);
        rule4.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule4.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTZ);

        Rule rule5 = new Rule();
        rule5.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNM);
        rule5.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule5.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTZ);

        Rule rule6 = new Rule();
        rule6.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNM);
        rule6.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule6.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTZ);
//-------------------------------------------------------------------------------
//--------------------------Erro zero -------------------------------
        Rule rule7 = new Rule();
        rule7.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorZ);
        rule7.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule7.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTZ);

        Rule rule8 = new Rule();
        rule8.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorZ);
        rule8.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule8.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTZ);

        Rule rule9 = new Rule();
        rule9.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorZ);
        rule9.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule9.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTZ);
//-------------------------------------------------------------------------------
//--------------------------Erro Positivo Medio -------------------------------------------
        Rule rule10 = new Rule();
        rule10.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPM);
        rule10.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule10.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTP);

        Rule rule11 = new Rule();
        rule11.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPM);
        rule11.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule11.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTP);

        Rule rule12 = new Rule();
        rule12.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPM);
        rule12.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule12.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTPG);
//-------------------------------------------------------------------------------
//--------------------------Erro Positivo Grande -------------------------------------------
        Rule rule13 = new Rule();
        rule13.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPG);
        rule13.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule13.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTPG);

        Rule rule14 = new Rule();
        rule14.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPG);
        rule14.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule14.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTPG);

        Rule rule15 = new Rule();
        rule15.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPG);
        rule15.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule15.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, outTPG);
//-------------------------------------------------------------------------------
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(rule4);
        rules.add(rule5);
        rules.add(rule6);
        rules.add(rule7);
        rules.add(rule8);
        rules.add(rule9);
        rules.add(rule10);
        rules.add(rule11);
        rules.add(rule12);
        rules.add(rule13);
        rules.add(rule14);
        rules.add(rule15);

        ArrayList<FuncPertinence> pertinencesError = new ArrayList<FuncPertinence>();
        ArrayList<FuncPertinence> pertinencesDerError = new ArrayList<FuncPertinence>();
        ArrayList<FuncPertinence> pertinencesOut = new ArrayList<FuncPertinence>();
        pertinencesError.add(errorNG);
        pertinencesError.add(errorNM);
        pertinencesError.add(errorZ);
        pertinencesError.add(errorPM);
        pertinencesError.add(errorPG);
        pertinencesDerError.add(derErrorVN);
        pertinencesDerError.add(derErrorVZ);
        pertinencesDerError.add(derErrorVP);
        pertinencesOut.add(outTNG);
        pertinencesOut.add(outTN);
        pertinencesOut.add(outTZ);
        pertinencesOut.add(outTP);
        pertinencesOut.add(outTPG);

        RuleBase ruleBase = new RuleBase(rules);

        DataBase dataBase = new DataBase();
        dataBase.addIn(ConstantsFuzzy.VARIABLE_ERROR_TANK2, pertinencesError);
        dataBase.addIn(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, pertinencesDerError);
        dataBase.addOut(ConstantsFuzzy.VARIABLE_OUTPUT, pertinencesOut);

        ArrayList<Double> rangeError = new ArrayList<Double>();
        rangeError.add(-30d);
        rangeError.add(30d);

        ArrayList<Double> rangeDerError = new ArrayList<Double>();
        rangeDerError.add(-0.8);
        rangeDerError.add(0.8);

        dataBase.addRangeIn(ConstantsFuzzy.VARIABLE_ERROR_TANK2, rangeError);
        dataBase.addRangeIn(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, rangeDerError);

        ArrayList<String> typesIn = new ArrayList<String>();
        typesIn.add(ConstantsFuzzy.VARIABLE_ERROR_TANK2);
        typesIn.add(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2);

        FuzzyController controller = new FuzzyController("Mandani (Padrão)", new Mamdani(ruleBase, dataBase), new Defuzzification(ConstantsFuzzy.DEFUZZI_CENTROID), typesIn);
        configure(controller);
        controllers.add(controller);
    }

    private void createSugenoInitial() {

        FuncaoTrapezoidal errorNG = new FuncaoTrapezoidal("ENG", new double[]{-59.7, -33.3, -19.6, -2.937});
        FuncaoTriangular errorNM = new FuncaoTriangular("ENM", new double[]{-3.88, -1.98, -0.238});
        FuncaoTriangular errorZ = new FuncaoTriangular("EZ", new double[]{-1, 0.397, 1});
        FuncaoTriangular errorPM = new FuncaoTriangular("EPM", new double[]{0.873, 2.62, 4.52});
        FuncaoTriangular errorPG = new FuncaoTriangular("EPG", new double[]{0.2381, 30, 59.8});

        FuncaoTriangular derErrorVN = new FuncaoTriangular("VN", new double[]{-3, -0.8, -0.02328});
        FuncaoTriangular derErrorVZ = new FuncaoTriangular("VZ", new double[]{-0.05, 0, 0.05});
        FuncaoTriangular derErrorVP = new FuncaoTriangular("VP", new double[]{0.03598, 0.8, 1.67});

        Expression satP = new Expression(2.3);
        Expression satN = new Expression(-1);
        Expression pi = new Expression();
        pi.addConstant(ConstantsFuzzy.VARIABLE_ERROR_TANK2, 0.03);
        pi.addConstant(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, 2);
//--------------------------Erro negativo grande -------------------------------
        Rule rule1 = new Rule();
        rule1.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNG);
        rule1.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule1.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, satN);

        Rule rule2 = new Rule();
        rule2.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNG);
        rule2.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule2.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, satN);

        Rule rule3 = new Rule();
        rule3.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNG);
        rule3.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule3.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, satN);
//-------------------------------------------------------------------------------
//--------------------------Erro negativo Médio -------------------------------
        Rule rule4 = new Rule();
        rule4.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNM);
        rule4.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule4.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);

        Rule rule5 = new Rule();
        rule5.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNM);
        rule5.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule5.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);

        Rule rule6 = new Rule();
        rule6.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorNM);
        rule6.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule6.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);
//-------------------------------------------------------------------------------
//--------------------------Erro zero -------------------------------
        Rule rule7 = new Rule();
        rule7.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorZ);
        rule7.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule7.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);

        Rule rule8 = new Rule();
        rule8.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorZ);
        rule8.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule8.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);

        Rule rule9 = new Rule();
        rule9.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorZ);
        rule9.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule9.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);
//-------------------------------------------------------------------------------
//--------------------------Erro Positivo Medio -------------------------------------------
        Rule rule10 = new Rule();
        rule10.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPM);
        rule10.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule10.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);

        Rule rule11 = new Rule();
        rule11.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPM);
        rule11.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule11.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pi);

        Rule rule12 = new Rule();
        rule12.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPM);
        rule12.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule12.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, satP);
//-------------------------------------------------------------------------------
//--------------------------Erro Positivo Grande -------------------------------------------
        Rule rule13 = new Rule();
        rule13.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPG);
        rule13.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVN);
        rule13.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, satP);

        Rule rule14 = new Rule();
        rule14.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPG);
        rule14.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVZ);
        rule14.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, satP);

        Rule rule15 = new Rule();
        rule15.addPremise(ConstantsFuzzy.VARIABLE_ERROR_TANK2, false, errorPG);
        rule15.addPremise(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, false, derErrorVP);
        rule15.addFunctionOut(ConstantsFuzzy.VARIABLE_OUTPUT, satP);
//-------------------------------------------------------------------------------
        ArrayList<Rule> rules = new ArrayList<Rule>();
        rules.add(rule1);
        rules.add(rule2);
        rules.add(rule3);
        rules.add(rule4);
        rules.add(rule5);
        rules.add(rule6);
        rules.add(rule7);
        rules.add(rule8);
        rules.add(rule9);
        rules.add(rule10);
        rules.add(rule11);
        rules.add(rule12);
        rules.add(rule13);
        rules.add(rule14);
        rules.add(rule15);

        ArrayList<FuncPertinence> pertinencesError = new ArrayList<FuncPertinence>();
        ArrayList<FuncPertinence> pertinencesDerError = new ArrayList<FuncPertinence>();
        ArrayList<Expression> pertinencesOut = new ArrayList<Expression>();

        pertinencesError.add(errorNG);
        pertinencesError.add(errorNM);
        pertinencesError.add(errorZ);
        pertinencesError.add(errorPM);
        pertinencesError.add(errorPG);

        pertinencesDerError.add(derErrorVN);
        pertinencesDerError.add(derErrorVZ);
        pertinencesDerError.add(derErrorVP);

        pertinencesOut.add(satP);
        pertinencesOut.add(satN);
        pertinencesOut.add(pi);


        RuleBase ruleBase = new RuleBase(rules);

        DataBase dataBase = new DataBase();
        dataBase.addIn(ConstantsFuzzy.VARIABLE_ERROR_TANK2, pertinencesError);
        dataBase.addIn(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, pertinencesDerError);
        dataBase.addExpressionOut(ConstantsFuzzy.VARIABLE_OUTPUT, pertinencesOut);

        ArrayList<Double> rangeError = new ArrayList<Double>();
        rangeError.add(-30d);
        rangeError.add(30d);

        ArrayList<Double> rangeDerError = new ArrayList<Double>();
        rangeDerError.add(-0.8);
        rangeDerError.add(0.8);

        dataBase.addRangeIn(ConstantsFuzzy.VARIABLE_ERROR_TANK2, rangeError);
        dataBase.addRangeIn(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2, rangeDerError);

        ArrayList<String> typesIn = new ArrayList<String>();
        typesIn.add(ConstantsFuzzy.VARIABLE_ERROR_TANK2);
        typesIn.add(ConstantsFuzzy.VARIABLE_DERIVATIVE_TANK2);

        FuzzyController controller = new FuzzyController("Sugeno (Padrão)", new Sugeno(ruleBase, dataBase), new Defuzzification(ConstantsFuzzy.DEFUZZI_SUGENO), typesIn);
        configure(controller);
        controllers.add(controller);
    }

    public void configure(FuzzyController controller) {
        controller.setSelectionsGraph(selectionsGraph);
        controller.setGraphLevelHandler(graphLevel.getGraphHandler());
        controller.setTanquePanel(tanquePanel);
        controller.setGraphControlHandler(graphContol.getGraphHandler());
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelBackGround = new javax.swing.JPanel();
        panelGraphs = new javax.swing.JPanel();
        graphLevel = new br.ufrn.controle.fuzzycontroller.view.Graph();
        graphContol = new br.ufrn.controle.fuzzycontroller.view.Graph();
        tanquePanel = new br.ufrn.controle.fuzzycontroller.view.TanquePanel();
        pnlPadding = new javax.swing.JPanel();
        panelSetPoint = new javax.swing.JPanel();
        lblSetPoint = new javax.swing.JLabel();
        txtSetPoint = new javax.swing.JFormattedTextField();
        buttonSetPoint = new javax.swing.JButton();
        DataPanel = new javax.swing.JPanel();
        lblOverShoot = new javax.swing.JLabel();
        txtOverShoot = new javax.swing.JTextField();
        lblSubida = new javax.swing.JLabel();
        txtSubida = new javax.swing.JTextField();
        lblPico = new javax.swing.JLabel();
        txtPico = new javax.swing.JTextField();
        lblAcomodation = new javax.swing.JLabel();
        txtAcomodation = new javax.swing.JTextField();
        lblFactorAcomo = new javax.swing.JLabel();
        comboFactorAcomo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelBackGround.setBackground(new java.awt.Color(255, 255, 255));
        panelBackGround.setLayout(new java.awt.BorderLayout());

        panelGraphs.setBackground(new java.awt.Color(255, 255, 255));
        panelGraphs.setLayout(new javax.swing.BoxLayout(panelGraphs, javax.swing.BoxLayout.PAGE_AXIS));

        graphLevel.setEIXO_X("Tempo ( Seg.)");
        graphLevel.setEIXO_Y("Nível");
        graphLevel.setTITLE("Nível X Tempo");

        javax.swing.GroupLayout graphLevelLayout = new javax.swing.GroupLayout(graphLevel);
        graphLevel.setLayout(graphLevelLayout);
        graphLevelLayout.setHorizontalGroup(
            graphLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        graphLevelLayout.setVerticalGroup(
            graphLevelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        panelGraphs.add(graphLevel);

        graphContol.setEIXO_X("Tempo (Seg.)");
        graphContol.setEIXO_Y("Tensão");
        graphContol.setTITLE("Ação de Controle");

        javax.swing.GroupLayout graphContolLayout = new javax.swing.GroupLayout(graphContol);
        graphContol.setLayout(graphContolLayout);
        graphContolLayout.setHorizontalGroup(
            graphContolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 533, Short.MAX_VALUE)
        );
        graphContolLayout.setVerticalGroup(
            graphContolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 241, Short.MAX_VALUE)
        );

        panelGraphs.add(graphContol);

        panelBackGround.add(panelGraphs, java.awt.BorderLayout.CENTER);

        tanquePanel.setOpaque(false);

        javax.swing.GroupLayout tanquePanelLayout = new javax.swing.GroupLayout(tanquePanel);
        tanquePanel.setLayout(tanquePanelLayout);
        tanquePanelLayout.setHorizontalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 245, Short.MAX_VALUE)
        );
        tanquePanelLayout.setVerticalGroup(
            tanquePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
        );

        panelBackGround.add(tanquePanel, java.awt.BorderLayout.WEST);

        pnlPadding.setBackground(new java.awt.Color(255, 255, 255));
        pnlPadding.setMinimumSize(new java.awt.Dimension(928, 50));
        pnlPadding.setOpaque(false);
        pnlPadding.setPreferredSize(new java.awt.Dimension(50, 50));

        panelSetPoint.setOpaque(false);
        panelSetPoint.setLayout(new java.awt.BorderLayout(10, 0));

        lblSetPoint.setText("SetPoint :");
        panelSetPoint.add(lblSetPoint, java.awt.BorderLayout.WEST);

        txtSetPoint.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        txtSetPoint.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtSetPoint.setText("15.00");
        panelSetPoint.add(txtSetPoint, java.awt.BorderLayout.CENTER);

        buttonSetPoint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/ufrn/controle/fuzzycontroller/view/resources/reload.png"))); // NOI18N
        buttonSetPoint.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));
        buttonSetPoint.setContentAreaFilled(false);
        buttonSetPoint.setFocusPainted(false);
        panelSetPoint.add(buttonSetPoint, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout pnlPaddingLayout = new javax.swing.GroupLayout(pnlPadding);
        pnlPadding.setLayout(pnlPaddingLayout);
        pnlPaddingLayout.setHorizontalGroup(
            pnlPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPaddingLayout.createSequentialGroup()
                .addGap(428, 428, 428)
                .addComponent(panelSetPoint, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addGap(246, 246, 246))
        );
        pnlPaddingLayout.setVerticalGroup(
            pnlPaddingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPaddingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSetPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        panelBackGround.add(pnlPadding, java.awt.BorderLayout.SOUTH);

        DataPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados de Controle"));
        DataPanel.setOpaque(false);

        lblOverShoot.setText("OverShoot (%) :");

        txtOverShoot.setEditable(false);
        txtOverShoot.setOpaque(false);

        lblSubida.setText("Tempo de Subida :");

        txtSubida.setEditable(false);
        txtSubida.setOpaque(false);

        lblPico.setText("Tempo de Pico :");

        txtPico.setEditable(false);
        txtPico.setOpaque(false);

        lblAcomodation.setText("Tempo de Acomodação :");

        txtAcomodation.setEditable(false);
        txtAcomodation.setOpaque(false);

        lblFactorAcomo.setText("Fator de Acomodação :");

        comboFactorAcomo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2 %", "5 %", "7 %", "10 %" }));

        javax.swing.GroupLayout DataPanelLayout = new javax.swing.GroupLayout(DataPanel);
        DataPanel.setLayout(DataPanelLayout);
        DataPanelLayout.setHorizontalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOverShoot, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lblOverShoot, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtSubida, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtPico, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtAcomodation, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(comboFactorAcomo, 0, 118, Short.MAX_VALUE)
                    .addComponent(lblFactorAcomo, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lblAcomodation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblPico, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(lblSubida, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                .addContainerGap())
        );
        DataPanelLayout.setVerticalGroup(
            DataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DataPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblOverShoot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtOverShoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSubida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAcomodation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtAcomodation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFactorAcomo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboFactorAcomo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        panelBackGround.add(DataPanel, java.awt.BorderLayout.EAST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 928, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBackGround, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<FuzzyController> getControllers() {
        return controllers;
    }

    public void setControllers(ArrayList<FuzzyController> controllers) {
        this.controllers = controllers;
    }

    public FuzzyController getControllerSelected() {
        return controllerSelected;
    }

    public void setControllerSelected(FuzzyController controllerSelected) {
        this.controllerSelected = controllerSelected;
    }

    public void startController() {
        if (controllerSelected == null) {
            return;
        }

        controllerSelected.start();
    }

    public void stopController() {
        controllerSelected.setAtive(false);
    }

    public Graph getGraphContol() {
        return graphContol;
    }

    public Graph getGraphLevel() {
        return graphLevel;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                SkinInitialize();
                new MainView().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DataPanel;
    private javax.swing.JButton buttonSetPoint;
    private javax.swing.JComboBox comboFactorAcomo;
    private br.ufrn.controle.fuzzycontroller.view.Graph graphContol;
    private br.ufrn.controle.fuzzycontroller.view.Graph graphLevel;
    private javax.swing.JLabel lblAcomodation;
    private javax.swing.JLabel lblFactorAcomo;
    private javax.swing.JLabel lblOverShoot;
    private javax.swing.JLabel lblPico;
    private javax.swing.JLabel lblSetPoint;
    private javax.swing.JLabel lblSubida;
    private javax.swing.JPanel panelBackGround;
    private javax.swing.JPanel panelGraphs;
    private javax.swing.JPanel panelSetPoint;
    private javax.swing.JPanel pnlPadding;
    private br.ufrn.controle.fuzzycontroller.view.TanquePanel tanquePanel;
    private javax.swing.JTextField txtAcomodation;
    private javax.swing.JTextField txtOverShoot;
    private javax.swing.JTextField txtPico;
    private javax.swing.JFormattedTextField txtSetPoint;
    private javax.swing.JTextField txtSubida;
    // End of variables declaration//GEN-END:variables

    private static void SkinInitialize() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);

        try { /*SubstanceBusinessLookAndFeel()*/
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (Exception e) {
            System.out.println("Substance Raven Graphite failed to initialize");
        }
    }
}

package r2d2e.solution.moduloteste.handler;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import r2d2e.solution.moduloteste.domain.DryTank;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.ThreadCycle;
import r2d2e.solution.moduloteste.domain.controlerInterface;
import r2d2e.solution.moduloteste.domain.graph.BarChart;
import r2d2e.solution.moduloteste.domain.graph.HistoChart;
import r2d2e.solution.moduloteste.view.ConfTeste;
import r2d2e.solution.moduloteste.view.NovoFrame;
import r2d2e.solution.moduloteste.view.TanquePanel;
import r2d2e.solution.moduloteste.view.TestePanel;

/**
 *
 * @author Rivaldo Jr
 */
public class TestModeHandler {

    public static TanquePanel tanquePanel;
    public static ConfTeste confPanel;
    public static TestePanel testePanel;

    public static JButton buttonInicio;
    public static JButton buttonCiclo;
    public static JButton buttonParar;


    public static BarChart barChart;
    public static HistoChart histoChart;
    
    private Quanser quanser;
    private ThreadCycle threadCycle;

    private int fatorTensaoReal = 5;

    private Double tensaoAtual;
    private Double tensaoMax;
    private Double tensaoStep;
    private Double nivelAgua;

    private double sumKm = 0;
    private int numInteracoesMax = 0;
    private int numInteracoesAtual = 0;

    public TestModeHandler(NovoFrame frame) {
        tanquePanel = frame.getTanquePanel();
        confPanel = frame.getConfTeste1();
        testePanel = frame.getTestePanel1();

        buttonInicio = frame.getButtonIniciarTeste();
        buttonCiclo = frame.getButtonNovoCiclo();
        buttonParar = frame.getButtonPararTeste();

        initChart();

        quanser = new Quanser();

        controlerInterface.tanquePanel = tanquePanel;
        controlerInterface.testModeHandler = this;
    }

    private void initChart() {
        barChart = new BarChart();
        histoChart = new HistoChart(30000);

        testePanel.getGraficoTensao().add(barChart.getChart());
        testePanel.getGraficoNivel().add(histoChart.getChart());
    }

    public void initTest() {
        tensaoMax = (Double) confPanel.getSpinnerTMax().getValue();
        tensaoAtual = (Double) confPanel.getSpinnerTMin().getValue();
        tensaoStep = (Double) confPanel.getSpinnerTI().getValue();
        nivelAgua = (Double) confPanel.getSpinnerNA().getValue();

        setEnable(false);
        controlerInterface.end = false;
        verifyCalibration();
        calculateInteracoesMax();
        cleanTable();

        numInteracoesAtual = 0;
        barChart.clear();
        histoChart.setRange(0.0, nivelAgua+2);

        buttonInicio.setEnabled(false);
        buttonParar.setEnabled(true);
        buttonCiclo.setEnabled(true);
    }

    public void cycle() {
        System.out.println("Tensao " + tensaoAtual);
        System.out.println("step " + tensaoStep);
        System.out.println("InteracoesAtual " + numInteracoesAtual);
        if ((numInteracoesAtual < numInteracoesMax) && quanser.isServerOk()) {
            threadCycle = new ThreadCycle(tensaoAtual, nivelAgua, quanser);
            threadCycle.start();
            tensaoAtual += tensaoStep;
            numInteracoesAtual += 1;
        }
        buttonCiclo.setEnabled(false);
    }

    public void stopTest() {
        setEnable(true);
        cleanInterface();
        quanser.stopMotor();
        numInteracoesAtual = 0;
        numInteracoesMax = 0;
        if (threadCycle != null) {
            threadCycle.stopTimer();
        }

        if (!controlerInterface.isDrying) {
            controlerInterface.end = true;
            controlerInterface.tanquePanelDry(quanser);
        }

        buttonInicio.setEnabled(true);
        buttonParar.setEnabled(false);
    }

    private void cleanInterface() {
        cleanTable();
        testePanel.getMediaField().setText("");
    }

    private void calculateInteracoesMax() {
        numInteracoesMax = (int) ((tensaoMax - tensaoAtual) / tensaoStep) + 1;
        System.out.println("NumIntera " + numInteracoesMax);
    }

    private void verifyCalibration() {
        Double nivel_Min = quanser.readSensor1();
        controlerInterface.NIVEL_LOW_CALIBRATION = nivel_Min + 0.1;
        System.out.println("nivelMIN " + nivel_Min);
    }

    private void setEnable(boolean enable) {
        confPanel.getSpinnerNA().setEnabled(enable);
        confPanel.getSpinnerTI().setEnabled(enable);
        confPanel.getSpinnerTMax().setEnabled(enable);
        confPanel.getSpinnerTMin().setEnabled(enable);
    }

    private void cleanTable() {
        DefaultTableModel dtm = (DefaultTableModel) testePanel.getTable().getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
        }
    }

    public void updateTable(double tensao, double tempo, double nivel) {
        double km = calculateKm(tensao, tempo, nivel);
        JTable table = testePanel.getTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        Vector linha = new Vector();
        linha.add(tensao);
        linha.add(tempo);
        linha.add(km);
        dtm.addRow(linha);
        sumKm += km;
    }

    public void verifyTestEnd() {
        if (numInteracoesAtual >= numInteracoesMax) {
            end();
        }
    }

    private void end() {
        Double mediaKm = avarageKm();
        JTextField field = testePanel.getMediaField();
        field.setText(mediaKm.toString());
        setEnable(true);
        controlerInterface.end = true;
        numInteracoesAtual = 0;
        numInteracoesMax = 0;
        buttonParar.setEnabled(false);
    }

    private double calculateKm(double tensao, double tempo, double nivel) {
        double raio = 2.2225;
        double volume = Math.PI * Math.pow(raio, 2) * nivel;
        return (volume / tempo) / (tensao * fatorTensaoReal);
    }

    public double avarageKm() {
        JTable table = testePanel.getTable();
        return sumKm / (table.getRowCount());
    }

    public void closeConnection() {
        quanser.closeConnection();
    }

    public void ciclyEnable() {
        buttonCiclo.setEnabled(true);
    }

    public static void tanquePanelUpdate(double nivel) {
        tanquePanel.setLevelWater2(nivel);
    }

    public static void clearCharts() {
        barChart.clear();
        histoChart.clear();
    }

}


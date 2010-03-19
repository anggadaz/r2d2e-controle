/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.handler;

import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.ThreadCycle;
import r2d2e.solution.moduloteste.domain.controlerInterface;
import r2d2e.solution.moduloteste.view.MainFrame;

/**
 *
 * @author Demétrios
 */
public class MainFrameHandler {

    private MainFrame mainFrame;
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

    public MainFrameHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        quanser = new Quanser();
    }

    public void initTest() {
        tensaoMax = (Double) mainFrame.getSpinnerTMax().getValue();
        tensaoAtual = (Double) mainFrame.getSpinnerTMin().getValue();
        tensaoStep = (Double) mainFrame.getSpinnerTI().getValue();
        nivelAgua = (Double) mainFrame.getSpinnerNA().getValue();
        setEnable(false);
        controlerInterface.end = false;
        verifyCalibration();
        calculateInteracoesMax();
        cleanTable();
        numInteracoesAtual = 0;
        controlerInterface.barChart.clear();
        mainFrame.getButtonPararTeste().setEnabled(true);
        mainFrame.getButtonNovoCiclo().setEnabled(true);
        controlerInterface.histoChart.setRange(0.0, nivelAgua+2);
    }

    public void stopTest() {

            setEnable(true);
            cleanInterface();
            quanser.stopMotor();
        mainFrame.getButtonPararTeste().setEnabled(false);
        numInteracoesAtual = 0;
        numInteracoesMax = 0;
        if (threadCycle != null) {
            threadCycle.stopTimer();
        }
            if (!controlerInterface.isDrying) {
                controlerInterface.end = true;
                controlerInterface.tanquePanelDry(quanser);
            }
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
            mainFrame.getButtonNovoCiclo().setEnabled(false);
        }
    }

    public void updateTable(double tensao, double tempo, double nivel) {
        double km = calculateKm(tensao, tempo, nivel);
        JTable table = mainFrame.getTable();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        Vector linha = new Vector();
        linha.add(tensao);
        linha.add(tempo);
        linha.add(km);
        dtm.addRow(linha);
        sumKm += km;
    }

    public void updateBarChart() {
        /*JPanel panel = mainFrame.getBarChartPanel();
        panel.removeAll();

        panel.add(controlerInterface.barChart.getChart());*/
    }

    public void verifyTestEnd() {
        if (numInteracoesAtual >= numInteracoesMax) {
            end();
        }
    }

    private void cleanTable() {
        DefaultTableModel dtm = (DefaultTableModel) mainFrame.getTable().getModel();
        for (int i = 0; i < dtm.getRowCount(); i++) {
            dtm.removeRow(i);
        }
    }

    private void end() {
        Double mediaKm = avarageKm();
        JTextField field = mainFrame.getMediaField();
        field.setText(mediaKm.toString());
        setEnable(true);
        controlerInterface.end = true;
        numInteracoesAtual = 0;
        numInteracoesMax = 0;
        mainFrame.getButtonPararTeste().setEnabled(false);
//        controlerInterface.barChart.addSeries(tensaoAtual - tensaoStep);
    }

    private double calculateKm(double tensao, double tempo, double nivel) {
        double raio = 2.2225;
        double volume = Math.PI * Math.pow(raio, 2) * nivel;
        return (volume / tempo) / (tensao * fatorTensaoReal);
    }

    public double avarageKm() {
        JTable table = mainFrame.getTable();
        return sumKm / (table.getRowCount());
    }

    private void setEnable(boolean enable) {
        mainFrame.getButtonIniciarTeste().setEnabled(enable);
        mainFrame.getSpinnerNA().setEnabled(enable);
        mainFrame.getSpinnerTI().setEnabled(enable);
        mainFrame.getSpinnerTMax().setEnabled(enable);
        mainFrame.getSpinnerTMin().setEnabled(enable);
    }

    private void cleanInterface() {
        cleanTable();
        mainFrame.getMediaField().setText("");
    }

    private void verifyCalibration() {
        Double nivel_Min = quanser.readSensor1();
        controlerInterface.NIVEL_LOW_CALIBRATION = nivel_Min + 0.1;
        System.out.println("nivelMIN " + nivel_Min);
    }

    public void closeConnection() {
        quanser.closeConnection();
    }

    private void calculateInteracoesMax() {
        numInteracoesMax = (int) ((tensaoMax - tensaoAtual) / tensaoStep) + 1;
        System.out.println("NumIntera " + numInteracoesMax);
    }

    public void ciclyEnable() {
        mainFrame.getButtonNovoCiclo().setEnabled(true);
    }
}

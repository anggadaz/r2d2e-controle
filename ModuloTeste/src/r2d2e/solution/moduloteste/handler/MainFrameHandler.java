/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.moduloteste.handler;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import r2d2e.solution.moduloteste.domain.Quanser;
import r2d2e.solution.moduloteste.domain.ThreadCycle;
import r2d2e.solution.moduloteste.domain.ThreadRead;
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
        mainFrame.getButtonPararTeste().setEnabled(true);
    }

    public void stopTest() {
        if(threadCycle != null){
            setEnable(true);
            cleanInterface();
            quanser.stopMotor();
            threadCycle.stopTimer();
            if(!controlerInterface.isDrying){
                controlerInterface.end = true;
                controlerInterface.tanquePanelDry(quanser);
            }
            mainFrame.getButtonPararTeste().setEnabled(false);
        }
    }

    public void cycle() {
        if ((tensaoAtual <= tensaoMax) && quanser.isServerOk()) {
            threadCycle = new ThreadCycle(tensaoAtual, nivelAgua, quanser);
            threadCycle.start();
            tensaoAtual += tensaoStep;
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
        mainFrame.getButtonNovoCiclo().setEnabled(true);
    }

    public void verifyTestEnd() {
        if (tensaoAtual > tensaoMax) {
            end();
        }
    }

    private void end() {
        Double mediaKm = avarageKm();
        JTextField field = mainFrame.getMediaField();
        field.setText(mediaKm.toString());
        setEnable(true);
        controlerInterface.end = true;
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
        mainFrame.getTable().removeAll();
        mainFrame.getMediaField().setText("");
    }

    private void verifyCalibration() {
        Double nivel_Min = quanser.readSensor1();
        controlerInterface.NIVEL_LOW_CALIBRATION = nivel_Min + 0.1;
        System.out.println("nivelMIN " + nivel_Min);
    }
}

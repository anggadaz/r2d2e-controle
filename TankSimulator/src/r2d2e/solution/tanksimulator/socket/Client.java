/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import r2d2e.solution.tanksimulator.domain.Logger;
import r2d2e.solution.tanksimulator.domain.QuanserDriver;
import r2d2e.solution.tanksimulator.domain.UpdateStatus;

/**
 *
 * @author demetrios
 */
public class Client extends Thread {

    private static final String REGEX = " ";
    private static final String READ = "READ";
    private static final String WRITE = "WRITE";
    private Socket socket;
    private int ID;
    private InputStream input;
    private PrintWriter output;
    private QuanserDriver driver;
    private boolean ativo = true;

    public Client(Socket socket, int id, QuanserDriver driver) {
        this.socket = socket;
        this.ID = id;
        this.driver = driver;
        getInputAndOutputStreams();
    }

    private void getInputAndOutputStreams() {
        try {
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            input = socket.getInputStream();
            Logger.println("Connection successful. ID = " + ID);
            UpdateStatus.updateSatusText("Conectado com o cliente " + socket.getInetAddress().getHostName() + "(" + socket.getInetAddress().getHostAddress() + ")");
        } catch (IOException ex) {
            Logger.println("Problema ao conectar os streams. ID = " + ID);
        }
    }

    @Override
    public void run() {
        processData();
        closeConnection();
    }

    private void processData() {
        do {
            try {
                if (input.available() > 0) {
                    processMsg();
                }
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.println("Nao consigo durmir. ID = " + ID);
                break;
            } catch (IOException ex) {
                Logger.println("Problema de I/O (available). ID = " + ID);
                break;
            }
        } while (ativo);
    }

    private void processMsg() {
        String message = (String) receiveLine();
        String[] splitMessage = message.split(REGEX);

        if (splitMessage[0].equals(READ)) {
            if (splitMessage.length == 2) {
                String value = driver.readFromSensor(splitMessage[1], ID);
                sendLine(value);
                return;
            }
        }
        if (splitMessage[0].equals(WRITE)) {
            if (splitMessage.length == 3) {
                String msg = driver.writeAtBomb(splitMessage[1], splitMessage[2], ID);
                sendLine(msg);
                return;
            }
        }
    }

    private String receiveLine() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
            return bufferedReader.readLine();
        } catch (IOException e) {
            Logger.println("Erro de I/O ao receber dados ID = " + ID);
            return null;
        }
    }

    private void sendLine(String send) {
        if (!send.contains("\n")) {
            send += "\n";
        }
        output.write(send);
        output.flush();
    }

    public void closeConnection() {
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException ex) {
            Logger.println("Problema ao fechar conexão ID = " + ID);
        }
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package r2d2e.solution.tanksimulator.socket;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import r2d2e.solution.tanksimulator.domain.Logger;
import r2d2e.solution.tanksimulator.domain.QuanserDriver;

public class QuanserServer extends Thread {

    public int port;
    private ServerSocket serverSocket;
    private Socket connection;
    private ArrayList<Client> clients;
    private QuanserDriver driver;
    private int ids = 0;
    private boolean ativo = true;

    public QuanserServer(int port, QuanserDriver driver) {
        clients = new ArrayList<Client>();
        this.port = port;
        this.driver = driver;
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(port);
            while (ativo) {
                Logger.println("Waiting for connection port = " + port);
                connection = serverSocket.accept();
                Logger.println("Connection received from " + connection.getInetAddress().getHostName());
                Client client = new Client(connection, ids,driver);
                client.start();
                clients.add(client);
                ids++;
            }
        } catch (IOException ex) {
            Logger.println("problema de I/O.");
        }
    }

    public void closeAllConnections(){
        for (int i = 0; i < clients.size(); i++) {
            Client client = clients.get(i);
            client.closeConnection();
        }
    }

    public void closeConnection(){
        try {
            serverSocket.close();
        } catch (IOException ex) {
            Logger.println("Problema ao desconectar o servidor.");
        }
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}

package r2d2e.solution.tanksimulator.testes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//: TCPServer1.java
//  SYNOPSIS:     TCPServer1 [port]
//  DESCRIPTION:  The program creates a TCP socket in the inet
//                listen for connections from TCPClients, accept
//                clients into private sockets.
////////////////////////////////////////////////////////////////
import java.io.*;
import java.net.*;

class EchoServe extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public EchoServe(Socket s)
            throws IOException {
        socket = s;
        System.out.println("Serving: " + socket);
        in =
                new BufferedReader(
                new InputStreamReader(
                socket.getInputStream()));
        // Enable auto-flush:
        out =
                new PrintWriter(
                new BufferedWriter(
                new OutputStreamWriter(
                socket.getOutputStream())), true);
        // If any of the above calls throw an
        // exception, the caller is responsible for
        // closing the socket. Otherwise the thread
        // will close it.
        start(); // Calls run()
    }

    public void run() {
        try {
            while (true) {
                System.out.println("....Server is waiting...");
                String str = in.readLine();
                if (str == null) {
                    break;
                }
                System.out.println("Received: " + str);
                System.out.println("From: " + socket);
                // send it back to user
                out.println(str);
            }
            System.out.println("Disconnected with.." + socket);
        } catch (IOException e) {
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
            }
        }
    }
}

public class TCPServer1 {

    static int PORT = 1525; // assign to next avalible Port.

    public static void main(String[] args)
            throws IOException {
//        if (args.length == 1) {
//            PORT = Integer.parseInt(args[0]); // assign to a given Port.
//        }
        // Create a Server Socket.
        ServerSocket s = new ServerSocket(PORT);
        InetAddress addrs = InetAddress.getLocalHost();
        // Or InetAddress  addrs= InetAddress.getByName("localhost");
        // Or InetAddress  addrs= InetAddress.getByName("127.0.0.1");

        System.out.println("TCP/Server running on : " + addrs + " ,Port " + s.getLocalPort());

        try {
            while (true) {
                // Blocks until a connection occurs:
                Socket socket = s.accept();
                try {
                    new EchoServe(socket);  // Handle the incoming Client.
                } catch (IOException e) {
                    // If it fails, close the socket,
                    // otherwise the thread will close it:
                    socket.close();
                }
            }
        } finally {
            s.close();
        }
    }
}

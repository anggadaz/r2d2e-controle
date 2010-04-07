package r2d2e.solution.tanksimulator.testes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


//: TCPClient1.java
// SYNOPSIS:       TCPCleint1 <hostid> <portnumber>
// DESCRIPTION:    The program creates a stream socket in the inet domain,
//                 Connect to TCPServer1,
//                 Get messages typed by a user and
//                 Send them to TCPServer1 running on hostid
//                 Then it waits for a reply from  the TCPServer1
//                 and show it back to the user, with a message
//                 indicating if there is an error during the round trip.
////////////////////////////////////////////////////////////////////////////
import java.net.*;
import java.io.*;

public class TCPClient1 {

    public static void main(String[] args)
            throws IOException {
//        if (args.length != 2) {
//            System.out.println("Usage: java TCPClient  hostid port#");
//            System.exit(0);
//        }
        // Passing null to getByName() produces the
        // special "Local Loopback" IP address, for
        // testing on one machine w/o a network:
        try {
//            InetAddress addr =
//                    InetAddress.getByName(args[0]);
            // Alternatively, you can use
            // the address or name:
            // InetAddress addr =
            //    InetAddress.getByName("127.0.0.1");
            // InetAddress addr =
            //    InetAddress.getByName("localhost");

            Socket socket =
                    new Socket("localhost", 1525);

            //
            // Guard everything in a try-finally to make
            // sure that the socket is closed:
            try {
                System.out.println("socket = " + socket);
                BufferedReader in =
                        new BufferedReader(
                        new InputStreamReader(
                        socket.getInputStream()));
                // Output is automatically flushed
                // by PrintWriter:
                PrintWriter out =
                        new PrintWriter(
                        new BufferedWriter(
                        new OutputStreamWriter(
                        socket.getOutputStream())), true);
                // read from keyboard input
//                DataInputStream myinput =
//                        new DataInputStream(
//                        new BufferedInputStream(System.in));
                try {
                    for (;;) {
//                        System.out.println("Type anything followed by RETURN, or Ctrl+D to  terminate the program.");
//                        String strin = myinput.readLine();
                        // Quit if the user typed ctrl+D
//                        if (strin == null) {
//                            break;
//                        } else {
                            String strin = new String("dsxcds");
                            out.println(strin);          // Send the message
//                        }
                        String strout = in.readLine();      // Recive it back
                        if (strin.length() == strout.length()) {  // Compare Both Strings
                            System.out.println("Echo is good");
                            System.out.println("Received: " + strout);
                        } else {
                            System.out.println("Echo bad -- string unequal" + strout);
                        }
                  
                        break;
                    } // of for ;;

                } catch (IOException e) {
                    e.printStackTrace();
                }
                // User is exiting
            } finally {
                System.out.println("EOF...exit");
                socket.close();
            }

        } catch (UnknownHostException e) {
            System.err.println("Can't find host");
            System.exit(1);
        } catch (SocketException e) {
            System.err.println("Can't open socket");
            e.printStackTrace();
            System.exit(1);
        }
    }
}

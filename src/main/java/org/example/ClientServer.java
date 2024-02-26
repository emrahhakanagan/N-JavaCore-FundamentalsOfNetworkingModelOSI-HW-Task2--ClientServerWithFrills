package org.example;

import java.io.*;
import java.net.Socket;

public class ClientServer {
    private static final String SERVER_ADDRESS = "netology.homework";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedReader sIn = new BufferedReader(new InputStreamReader(System.in))) {

            String fromServer, fromUser;

            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);

                if (fromServer.equals("Bye.")) {
                    break;
                }

                fromUser = sIn.readLine();
                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

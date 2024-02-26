package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    System.out.println("New connection accepted");
                    out.println("Write your name");
                    String name = in.readLine();

                    out.println("Are you child? (yes/no)");
                    String answer = in.readLine();

                    if ("yes".equalsIgnoreCase(answer)) {
                        out.println("Welcome to the kids area, " + name + "! Let's play!");
                    } else {
                        out.println("Welcome to the adult zone, " + name + "! Have a good rest, or a good working day!");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

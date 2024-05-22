package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final Integer PORT = 777;
    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(PORT)){
            System.out.println("Server started");
            while (true){
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);
                     BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                    String clientText = bufferedReader.readLine();
                    System.out.println("New connection established on port: " +clientSocket.getPort()+" Message:"+clientText);
                    printWriter.println("Hello visitor! Your port is "+clientSocket.getPort());;
                }

            }
        }
        catch (IOException e) {throw new IOException(e);}

}}

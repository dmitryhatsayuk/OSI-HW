package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public void start () throws IOException {
            try (Socket clientSocket = new Socket("localhost",Server.PORT);
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))){
                writer.println("I'm client");
                System.out.println(reader.readLine());}
            catch (IOException e){
                throw new IOException(e);
            }
        }
    }


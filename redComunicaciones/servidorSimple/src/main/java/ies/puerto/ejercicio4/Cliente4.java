package ies.puerto.ejercicio4;

import java.io.*;
import java.net.*;

public class Cliente4 {
    public static void main(String[] args) {
        System.out.println("Chat client initializing...");

        try (Socket socket = new Socket("localhost", 12345);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            Thread readThread = new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null) {
                        System.out.println("Message: " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            readThread.start();

            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
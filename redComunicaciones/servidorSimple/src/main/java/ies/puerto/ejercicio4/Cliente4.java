package ies.puerto.ejercicio4;

import java.io.*;
import java.net.*;

public class Cliente4 {
    public static void main(String[] args) {
<<<<<<< HEAD
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
=======

        Thread hiloCliente1 = new Thread(new clientRun("hola","localhost",12345));

    }
    private static class clientRun extends Thread{

        private String mensaje;
        private String host;
        private int port;

        public clientRun(String mensaje, String host, int port) {
            this.mensaje = mensaje;
            this.host = host;
            this.port = port;
        }

        public void run(){
            System.out.println("Cliente de chat iniciado...");

            try (Socket socket = new Socket(host, port);

                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                Thread readThread = new Thread(() -> {
                    try {
                        String response;
                        while ((response = in.readLine()) != null) {
                            System.out.println("Mensaje: " + response);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
>>>>>>> b332ae5 (feat:)

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
}
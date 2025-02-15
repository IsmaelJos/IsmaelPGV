package ies.puerto.ejercicio2;

import java.io.*;
import java.net.*;

public class Servidor2 {
    public static void main(String[] args){
        int port = 1234;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Servidor escuchando en el puerto " + port);
            String message = "";
            while (!message.equals("salir")) {
                Socket clientSocket = serverSocket.accept();  // Espera una conexión de cliente
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                while ((message = in.readLine()) != null ) {
                    if (message.equals("salir")){
                        break;
                    }
                    System.out.println("Recibido: " + message);
                    out.println("Eco: " + message);  // Responde al cliente
                }

                clientSocket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
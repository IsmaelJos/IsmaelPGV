package ies.puerto.ejercicio3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor3 {
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
                    if (isNumeric(message.replaceAll("\\s+",""))){
                        String[] splited = message.split("\\s+");
                        int messageSum = 0;
                        for(String split : splited){
                            messageSum += Integer.parseInt(split);
                        }
                        System.out.println("Recibido: " + message +" sumado "+messageSum);
                        out.println("Eco: " + message +" sumado "+messageSum);  // Responde al cliente
                    }else{
                        System.out.println("Recibido: " + message);
                        out.println("Eco: " + message);  // Responde al cliente
                    }
                }

                clientSocket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
}
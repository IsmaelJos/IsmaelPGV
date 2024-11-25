package ies.puerto.ejercicio2;

import ies.puerto.ejercicio1.Cliente;

import java.io.*;
import java.net.*;

public class Cliente2 {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 1234;
        Socket socket = null;
        try {
            socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

            String userInput;
            while ((userInput = console.readLine()) != null) {
                out.println(userInput);
                if (userInput.equals("salir")){
                    break;
                }
                System.out.println("Respuesta del servidor: " + in.readLine());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }



    }
}
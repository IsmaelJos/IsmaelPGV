package ies.puerto.ejercicio4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static ies.puerto.ejercicio4.Servidor4.clientWriters;

public class ClientHandler extends Thread {
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            clientWriters.add(out);

            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Message received: " + message);
                sendMessageToAllClients(message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            clientWriters.remove(out);
        }
    }

    private void sendMessageToAllClients(String message) {
        for (PrintWriter writer : clientWriters) {
            writer.println(message);
        }
    }
}
package ies.puerto.ejercicio4;

import java.io.*;
import java.net.*;
import java.util.Set;
import java.util.concurrent.*;

public class Servidor4 {
    public static final Set<PrintWriter> clientWriters = ConcurrentHashMap.newKeySet();
    public static void main(String[] args) {
        System.out.println("Chat server init...");
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            while (true) {
                new ClientHandler(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
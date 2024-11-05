package ies.puerto.ejercicio5;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor5 {

    public static void main(String[] args) {
        int port = 1234;
        initServer(port);
    }


    public static void initServer(int port){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Initing file server at port: " + port);
            while (true){
                Socket clientSocket = serverSocket.accept();
                new Thread(new FileHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

package ies.puerto.ejercicio5;

import java.io.*;
import java.net.Socket;
import java.util.Random;

public class Cliente5 {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 1234;

        startClient(host, port);
    }

    public static void startClient(String host, int port){
        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            InputStream in = socket.getInputStream();

            Random random = new Random();
            int rndNumFile = random.nextInt(10)+1;
            String filename = "file"+rndNumFile+".txt";

            out.println(filename);

            File fileReceived = new File("received_"+filename);

            try (FileOutputStream fileOutputStream = new FileOutputStream(fileReceived)){
                byte [] buffer = new byte[4096];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1 ){
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.flush();
                fileOutputStream.close();

                System.out.println("File received: " + fileReceived.getName());

                showFileContents(fileReceived);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void showFileContents(File fileReceived) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileReceived))){
            String line;
            System.out.println("Content of file: ");
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error while reading the file: ");
            throw new RuntimeException(e);
        }
    }
}

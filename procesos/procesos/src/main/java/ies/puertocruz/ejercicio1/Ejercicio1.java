package ies.puertocruz.ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "google.com");
        ProcessBuilder pb2 = new ProcessBuilder("ls");
        ProcessBuilder pb3 = new ProcessBuilder("printenv");

        List<ArrayList> processBuilders = new ArrayList<>();
        processBuilders.add(pb);
        processBuilders.add(pb2);
        processBuilders.add(pb3);

        try {
            for (int i = 0; i < processBuilders.size(); i++) {
                Process proceso = processBuilders[i].start();

            // Capturar la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            // Esperar a que termine el proceso
            int exitCode = processBuilders[i].waitFor();
            System.out.println("Código de salida: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

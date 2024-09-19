package ies.puertocruz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    
    public static void main(String[] args) {
        
        ProcessBuilder pb = new ProcessBuilder("java", "modificaFichero");
        pb.directory(new java.io.File("./classes/ies/puertocruz/modificaFichero.class"));
        
        try {
            
            Process proceso = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

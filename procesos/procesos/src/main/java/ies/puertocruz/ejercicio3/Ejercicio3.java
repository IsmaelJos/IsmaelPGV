package ies.puertocruz.ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;

public class Ejercicio3 {
    public static void main(String[] args) {
        
        ProcessBuilder pb = new ProcessBuilder("ls");
        File fileOutput = new File("procesos/procesos/src/main/java/ies/puertocruz/ejercicio3/output.txt");
        
        pb.redirectOutput(fileOutput);
        pb.redirectErrorStream(true);

        try {
            Process proceso = pb.start();

            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);
            

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package ies.puertocruz.ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

    public static void main(String[] args) {
        
        ProcessBuilder pb = new ProcessBuilder("dir");
        ProcessBuilder pb2 = new ProcessBuilder("ls");
        ProcessBuilder pb3 = new ProcessBuilder("printenv");

        try {
            
            Process proceso = pb.start();
            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);

            Process proceso2 = pb2.start();
            int exitCode2 = proceso2.waitFor();
            System.out.println("Código de salida: " + exitCode2);

            Process proceso3 = pb3.start();
            int exitCode3 = proceso3.waitFor();
            System.out.println("Código de salida: " + exitCode3);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

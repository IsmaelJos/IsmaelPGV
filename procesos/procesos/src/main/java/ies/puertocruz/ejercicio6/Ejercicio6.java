package ies.puertocruz.ejercicio6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio6 {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("java","procesos/procesos/src/main/java/ies/puertocruz/ejercicio6/WorkerClass.java","patatas fritas con queso");
        ProcessBuilder pb2 = new ProcessBuilder("java","procesos/procesos/src/main/java/ies/puertocruz/ejercicio6/WorkerClass.java","patatas fritas con tomate");
        ProcessBuilder pb3 = new ProcessBuilder("java","procesos/procesos/src/main/java/ies/puertocruz/ejercicio6/WorkerClass.java","patatas fritas con lechuga");
        ProcessBuilder pb4 = new ProcessBuilder("java","procesos/procesos/src/main/java/ies/puertocruz/ejercicio6/WorkerClass.java","patatas fritas con haburger");
        ProcessBuilder pb5 = new ProcessBuilder("java","procesos/procesos/src/main/java/ies/puertocruz/ejercicio6/WorkerClass.java","patatas fritas con lechuga");

        try {
            InnerEjercicio6(pb);
            InnerEjercicio6(pb2);
            InnerEjercicio6(pb3);
            InnerEjercicio6(pb4);
            InnerEjercicio6(pb5);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void InnerEjercicio6(ProcessBuilder pb) throws IOException, InterruptedException  {
    
        Process proceso = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            
            String linea;

            while ((linea = br.readLine())!= null) {
                System.out.println(linea);
            }

            int exitCode = proceso.waitFor();
            System.out.println("Código de salida: " + exitCode);
    } 
}

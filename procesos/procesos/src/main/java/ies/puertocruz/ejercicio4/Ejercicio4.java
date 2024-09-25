package ies.puertocruz.ejercicio4;

import java.io.IOException;

public class Ejercicio4 {
    
    static String [] EXEC_INFO = {
        "java", 
        "-cp", System.getProperty("java.class.path"), 
        "ies.puertocruz.ejercicio4.otroPrograma.java",
        "procesos/procesos/src/main/java/ies/puertocruz/ejercicio4/Texto.txt"
    };

    public static void main(String[] args) {
        
        System.out.println(ejecutarOtraClase(EXEC_INFO));

    }

    public static boolean ejecutarOtraClase(String[] infoExec){
        ProcessBuilder pb = new ProcessBuilder(infoExec);
        
        try {

            Process proceso = pb.start();

            int codigoSalida = proceso.waitFor();
            if (codigoSalida == 0) {
                return true;
            }
            
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        
        return false;
    }
}

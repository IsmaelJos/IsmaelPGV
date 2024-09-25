package ies.puertocruz.ejercicio5;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio5 {

    public static final String COMMAND = "cd juanito";
    public static void main(String[] args) {
        System.out.println(redirigirFallos(COMMAND));
    }
    public static boolean redirigirFallos(String comando){
        ProcessBuilder pb = new ProcessBuilder(comando.split(" "));
        pb.redirectErrorStream(true);

        try{
            Process proceso = pb.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String lineError;

            List<String> errorList = new ArrayList<>();

            while ((lineError = br.readLine())!= null) {
                errorList.add(lineError);
            }

            int exitCode = proceso.waitFor();
            if(exitCode == 1 && !errorList.isEmpty()){
                return true;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
    
}

package ies.puertocruz.ejercicio4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class otroPrograma {
    
    public static void main(String[] args) {
          if (args.length < 1) {
            return;
          }

        String nombreString = args[0];

        try (BufferedWriter br = new BufferedWriter(new FileWriter(nombreString))){
            br.write("esto es un mensaje de prueba");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    

}

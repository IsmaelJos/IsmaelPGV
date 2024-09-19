package ies.puertocruz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class modificaFichero {
    public static void main(String[] args) {

        try {
            File myObj = new File("./../archivo.txt");
        if (myObj.createNewFile()) {
            System.out.println("archivo creado: " + myObj.getName());
            FileWriter myWriter = new FileWriter(myObj.getName());
            myWriter.write("Escrito");
            myWriter.close();
        } else {
            FileWriter myWriter = new FileWriter(myObj.getName());
            myWriter.write("Escrito");
            myWriter.close();
        }
        } catch (IOException e) {
        System.out.println("ERROR.");
        e.printStackTrace();
        }
    }
}

package ies.puertocruz.ejercicio9;

import java.io.IOException;

public class Ejercicio9 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("ping", "-c", "30", "www.google.com");

        try {
            long tiempoInicio = System.currentTimeMillis();
            Process proceso = pb.start();

            boolean ejecutando = proceso.isAlive();
            while (ejecutando) {
                long tiempoFinal = System.currentTimeMillis();

                if ((tiempoFinal - tiempoInicio)>10000) {
                    proceso.destroy();
                    ejecutando = false;
                    System.out.println("Se ha superado el tiempo de espera");
                };

            }
            

            proceso.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

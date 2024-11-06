package ies.puerto.extras;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Semaforo {
    private static final Semaphore semaforo = new Semaphore(3);

    public static void main(String[] args) {
        // Creamos varios hilos para simular el acceso concurrente a un recurso
        for (int i = 1; i <= 5; i++) {
            new Trabajador("Trabajador " + i).start();
        }
    }

    static class Trabajador extends Thread {
        private String nombre;

        Random random = new Random();

        public Trabajador(String nombre) {
            this.nombre = nombre;
        }

        public void run() {
            try {
                System.out.println(nombre + " esperando para acceder al recurso...");

                // Adquirimos un permiso del semáforo
                semaforo.acquire();
                System.out.println(nombre + " ha obtenido acceso al recurso.");

                // Simulamos trabajo con el recurso
                Thread.sleep(random.nextInt(10000)+5000);

                // Liberamos el permiso después de usar el recurso
                System.out.println(nombre + " ha terminado y libera el recurso.");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                semaforo.release();
            }
        }
    }
}

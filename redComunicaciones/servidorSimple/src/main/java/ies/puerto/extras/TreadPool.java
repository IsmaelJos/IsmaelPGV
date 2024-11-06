package ies.puerto.extras;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TreadPool {
    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        for (int i = 1; i <= 5; i++) {
            Runnable tarea = new cosaRunneable("Tarea " + i);
            threadPool.submit(tarea);
        }

        threadPool.shutdown();

    }

    static class cosaRunneable implements Runnable{
        private String nombre;
        Random random = new Random();
        public cosaRunneable(String nombre) {
            this.nombre = nombre;
        }

        @Override
        public void run() {
            System.out.println(nombre + " está siendo ejecutada por el hilo " + Thread.currentThread().getName());
            try {
                Thread.sleep(random.nextInt(1000)+500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(nombre + " ha terminado.");
        }

    }

}



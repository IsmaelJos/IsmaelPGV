package ies.puerto.extras;

import java.util.Random;

public class Carrera implements Runnable{
    private String name;
    private int distance = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;

    public Carrera(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (distance < GOAL && !winnerDeclared) {
            int step = 10; // Avance aleatorio de 1 a 10
            distance += step;
            System.out.println(name + " avanzó " + step + " metros. Distancia total: " + distance + " metros.");

            if (distance >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " ha ganado la carrera!");
            }

            try {
                Thread.sleep(random.nextInt(1000)); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread jugador1 = new Thread(new Carrera("jugador 1"));
        Thread jugador2 = new Thread(new Carrera("Jugador 2"));

        jugador1.start();
        jugador2.start();
    }
}

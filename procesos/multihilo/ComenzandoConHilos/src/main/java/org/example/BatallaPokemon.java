package org.example;

import java.util.Random;

public class BatallaPokemon implements Runnable{

    private String name;
    private int vida = 200;
    private static boolean winnerDeclared = false;
    public BatallaPokemon(String name){
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (vida > 0 && !winnerDeclared) {
            int damage = random.nextInt(10) + 1; // Avance aleatorio de 1 a 10
            vida -= damage;
            System.out.println(name + " recibio " + damage + " puntos de daño. Vida restante: " + vida + " puntos de vida.");

            if (vida <= 0 && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " ha perdido el combate!");
            }

            try {
                Thread.sleep(500); // Pausa entre pasos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread pikachu = new Thread(new BatallaPokemon("Pikachu"));
        Thread charmander = new Thread(new BatallaPokemon("Charmander"));

        pikachu.start();
        charmander.start();
    }


}

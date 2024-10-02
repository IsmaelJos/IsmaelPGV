package org.example;

import java.util.Random;

public class CazaDeHorrocruxes implements Runnable {
    private String name;
    private int duracion;
    private static boolean winnerDeclared = false;
    public CazaDeHorrocruxes(String name){
        this.name = name;
    }



    @Override
    public void run() {
        Random random = new Random();

        try {
            Thread.sleep(random.nextInt(10000) + 1); // Pausa entre pasos
            if (!winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " ha encontrado el Horrocrux!");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread harry = new Thread(new CazaDeHorrocruxes("Harry"));
        Thread hermione = new Thread(new CazaDeHorrocruxes("Hermione"));
        Thread ron = new Thread(new CazaDeHorrocruxes("Ron"));

        harry.start();
        hermione.start();
        ron.start();
    }
}

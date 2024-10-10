package ies.puerto;

import java.util.Random;

public class Cazador extends Thread {
    private String nombre;
    private int monstruosAtrapados = 0;
    private int posX;
    private int posY;
    private Mapa mapa;
    

    public Cazador(String nombre) {
        this.nombre = nombre;
        this.mapa = new Mapa();
    }


    @Override
    public void run() {
        while (true) {
            // Lógica de movimiento
            // Intentar atrapar un monstruo
            // Aumentar el contador de monstruos atrapados
            try {
                Thread.sleep(new Random().nextInt(1000)); // Espera aleatoria
            } catch (InterruptedException e) {
                break; // Terminar el hilo si es interrumpido
            }
        }
    }

    public void atraparMonstruo() {
        monstruosAtrapados++;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
}

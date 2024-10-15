package ies.puerto;

import java.util.Random;

public class Cazador extends Thread {
    private String nombre;
    private int monstruosAtrapados = 0;
    private int posX;
    private int posY;
    private Mapa mapa;
    

    public Cazador(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.posX = new Random().nextInt(mapa.getSize());
        this.posY = new Random().nextInt(mapa.getSize());
    }


    @Override
    public void run() {
        mapa.addCazador(this);
        while (monstruosAtrapados<1) {
            try {
                Thread.sleep(new Random().nextInt(1000)); // Espera aleatoria
            } catch (InterruptedException e) {
                break; // Terminar el hilo si es interrumpido
            }
            boolean atrapado = mapa.moverCazador(this);
            // Lógica de movimiento
            // Intentar atrapar un monstruo
            // Aumentar el contador de monstruos atrapados
            
        }
    }

    public void atraparMonstruo() {
        monstruosAtrapados++;
        System.out.println(nombre+" ha atrapado un monstruo");
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

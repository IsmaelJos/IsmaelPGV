package ies.puerto;

import java.util.Random;

public class Monstruo extends Thread{

    private String nombre;
    private int posX;
    private int posY;
    private Mapa mapa;
    
    public Monstruo(String nombre, Mapa mapa) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.posX = new Random().nextInt(mapa.getSize());
        this.posY = new Random().nextInt(mapa.getSize());
    }

    @Override
    public void run() {
        boolean muerto = false;
        mapa.addMonstruo(this);
        while (muerto == false) {
            
            muerto = mapa.comprobarMonstruo(this);

            if (muerto == false) {
                mapa.moverMonstruo(this);
                System.out.println(nombre+" ha cambiado de sitio");
            }else{
                System.out.println(nombre+" ha muerto");
                break;
            }

            try {
                Thread.sleep(new Random().nextInt(10000)+5000); // Espera aleatoria
            } catch (InterruptedException e) {
                break; // Terminar el hilo si es interrumpido
            }
        }
    }
    
    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
    public int getPosX(){
        return posX;
    }
    public int getPosY(){
        return posY;
    }
}

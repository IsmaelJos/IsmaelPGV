package ies.puerto;

import java.util.Random;

public class Monstruo extends Thread {

    private String nombre;
    private int posX;
    private int posY;
    private Mapa mapa;
    private boolean encuevado = false;

    
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
        while(muerto == false) {

            try {
                Thread.sleep(new Random().nextInt(1000)+500); // Espera aleatoria
            } catch (InterruptedException e) {
                break; // Terminar el hilo si es interrumpido
            }

            muerto = mapa.comprobarMonstruo(this);

            if (muerto == false) {
                try {
                    mapa.moverMonstruo(this);

                    if(encuevado){
                        System.out.println(nombre+" ha entrado en la cueva");
                        Thread.sleep(new Random().nextInt(5000)+2000); // Espera aleatoria
                        System.out.println(nombre+" ha salido de la cueva");
                        mapa.salirCueva(this);
                        mapa.moverMonstruo(this);
                    }
                    System.out.println(nombre+" ha cambiado de sitio");
                } catch (InterruptedException ex) {

                }
            }else{
                break;
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
    public void setEncuevado(boolean encuevado){
        this.encuevado = encuevado;
    }
}

package ies.puerto;

import java.util.Random;

public class Monstruo extends Thread {

    private String nombre;
    private int posX;
    private int posY;
    private Mapa mapa;

    
    public Monstruo(String nombre, Mapa mapa, Cueva cueva) {
        this.nombre = nombre;
        this.mapa = mapa;
        this.posX = new Random().nextInt(mapa.getSize());
        this.posY = new Random().nextInt(mapa.getSize());
        this.cueva = cueva;
    }

    @Override
    public void run() {
        boolean muerto = false;

            while(muerto == false) {
  
            if (!cueva.isOccupied()){
                try {
                    cueva.enterCueva(this, mapGame);

                    Thread.sleep(4000);

                    cueva.exitCueva(this, mapGame);

                } catch (InterruptedExcep t ion e) {
                      Thread.currentThread().interrupt();
                }
            }

            try {
     

                break; // Terminar el hilo si es interrumpido
            }

     

     
            if (muerto == false) {
     

                System.out.println(nombre+" ha cambiado de sitio");
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
    public void setCueva(Cueva cueva){
        this.cueva = cueva;
    }
}

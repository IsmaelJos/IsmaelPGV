package ies.puerto;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JuegoCazadores3 {
    public static void main(String[] args) {
        
        int tiempoMaximo = 20000;

        boolean finalizar = false;
        
        Mapa mapa = new Mapa();

        ExecutorService threadPool = Executors.newFixedThreadPool(1);

        Runnable evento = new EventoAleatorio(mapa);

        long tiempoInicio = System.currentTimeMillis();

        threadPool.submit(evento);

        Monstruo monstruo1 = new Monstruo("monstruo1",mapa);
        Monstruo monstruo2 = new Monstruo("monstruo2",mapa);
        Thread hiloMonstruo1 = new Thread(monstruo1);
        Thread hiloMonstruo2 = new Thread(monstruo2);

        Cazador cazador1 = new Cazador("cazador1",mapa);
        Cazador cazador2 = new Cazador("cazador2",mapa);
        Thread hiloCazador1 = new Thread(cazador1);
        Thread hiloCazador2 = new Thread(cazador2);

        hiloCazador1.start();
        hiloCazador2.start();

        hiloMonstruo1.start();
        hiloMonstruo2.start();

        while(!finalizar){
            if(System.currentTimeMillis() - tiempoInicio >= tiempoMaximo) {

                System.out.println(cazador1.getNombre()+ " ha atrapado " +cazador1.getMonstruosAtrapados()+" monstruos"); 
                System.out.println(cazador2.getNombre()+ " ha atrapado " +cazador2.getMonstruosAtrapados()+" monstruos"); 
                
                hiloCazador1.interrupt();
                hiloCazador2.interrupt();
                hiloMonstruo1.interrupt();
                hiloMonstruo2.interrupt();
                finalizar = true;
            }
        }

        
        
    }
}

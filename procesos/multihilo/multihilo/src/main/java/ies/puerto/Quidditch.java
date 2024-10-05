package ies.puerto;

import java.util.Random;

public class Quidditch {

    public static void main(String[] args) {
        PartidoQuidditch partido1 = new PartidoQuidditch();

        Thread cazador1 = new Thread(new Cazador("cazador1", partido1));
        Thread cazador2 = new Thread(new Cazador("cazador2", partido1));
        Thread buscador = new Thread(new Buscador("buscador", partido1));

        cazador1.start();
        cazador2.start();
        buscador.start();
        
    }
}

class PartidoQuidditch {
    private boolean snitchAtrapada = false;

    public synchronized boolean isSnitchAtrapada() {
        return snitchAtrapada;
    }

    public synchronized void atraparSnitch(String buscador) {
        if (!snitchAtrapada) {
            snitchAtrapada = true;
            System.out.println(buscador + " atrapó la Snitch Dorada. El partido terminó");
        }
    }
}

class Cazador implements Runnable {
    private PartidoQuidditch partido;
    private String name;
    private int puntos;
    Random random = new Random();
    
    public Cazador(String name, PartidoQuidditch partido){
        this.name = name;
        this.partido = partido;
    }

    public void run() {

        try {
            
            while (!partido.isSnitchAtrapada()) {
                int goles = random.nextInt(10) + 1;
                puntos += goles;
                System.out.println(name+" tiene "+puntos+" puntos" );
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Buscador implements Runnable{
    private String name;
    private PartidoQuidditch partido;
    
    public Buscador(String name, PartidoQuidditch partido){
        this.name = name;
        this.partido = partido;
    }

    public void run() {
       try {

            Thread.sleep(5000);
            partido.atraparSnitch(name);
            

       } catch (InterruptedException e) {
            e.printStackTrace();
       }
    }

}

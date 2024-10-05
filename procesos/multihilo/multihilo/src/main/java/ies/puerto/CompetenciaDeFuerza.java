package ies.puerto;

import java.util.Random;

public class CompetenciaDeFuerza {
    public static void main(String[] args) {

            Pausar newTimer = new Pausar();

            Thread hiloThor = new Thread(new Superfuerza("Thor",newTimer));
            Thread hiloHulk = new Thread(new Superfuerza("Hulk",newTimer));
            Thread hiloTimer = new Thread(new Timer(newTimer));

            hiloTimer.start();
            hiloThor.start();
            hiloHulk.start();        
        

    }
}

class Superfuerza implements Runnable{

    Random random = new Random();
    private String name;
    private int peso = 1000;
    private Pausar timer;
    
    public Superfuerza(String name, Pausar timer) {
        this.name = name;
        this.timer = timer;
    }

    public void run() {
            do {
                int time = random.nextInt(peso) + 100;
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                peso += 1000;
            } while (!timer.isPaused());

            if (timer.isPaused()) {
                System.out.println(name +" ha levantado "+peso+" kilos");
            }

    }

}

class Timer implements Runnable{

    private Pausar timer;  

    public Timer(Pausar timer){
        this.timer=timer;
    }

    public void run() {
        
        try {
            Thread.sleep(5000);
            timer.pausar();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
class Pausar{
    boolean pausado = false;

    public synchronized boolean isPaused(){
        return pausado;
    }

    public synchronized void pausar() {
        if (!pausado) {
            pausado = true;
            System.out.println("Se ha terminado el tiempo");
        }
    }
}



















//&& random.nextBoolean()
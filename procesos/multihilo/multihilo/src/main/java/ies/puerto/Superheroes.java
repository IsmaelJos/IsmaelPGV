package ies.puerto;

import java.util.Random;

public class Superheroes {
    public static void main(String[] args) {
        
        Salvar gotham = new Salvar();
        
        Superheroe batman = new Superheroe("Batman", gotham);
        Superheroe superman = new Superheroe("Superman", gotham);

        Thread hilobatman = new Thread(batman);
        Thread hilosuperman = new Thread(superman);

        hilobatman.start();
        hilosuperman.start();

    }
}






class Superheroe implements Runnable{
    private Random random = new Random();
    private String name;
    private Salvar area;
    
    public Superheroe(String name, Salvar area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public void run() {
        try{
            
            int contador = 0;
            do {
                contador = random.nextInt(5) + 1;
                int time = random.nextInt(4000) + 1000;
                System.out.println(name + " salvo " + time + " personas.");
                Thread.sleep(time);
                if (area.isSave()) {
                    break;
                }
            } while (contador<5);
            
            if (!area.isSave()) {
                area.salvar(name);
            }
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}







class Salvar {
    private boolean salvado = false;

    public synchronized boolean isSave(){
        return salvado;
    }

    public synchronized void salvar(String name) {
        if (!salvado) {
            salvado = true;
            System.out.println("gracias a "+name+" la amenaza ha sido neutralizada");
        }
    }

}
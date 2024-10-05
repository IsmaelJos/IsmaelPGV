package ies.puerto;

import java.util.Random;

public class ExploradoresJedi {
    public static void main(String[] args) {
        Busqueda busqueda = new Busqueda();
        
        Explorador jedi1 = new Explorador("jedi1", busqueda);
        Explorador jedi2 = new Explorador("jedi2", busqueda);

        Thread hiloJedi1 = new Thread(jedi1);
        Thread hiloJedi2 = new Thread(jedi2);

        hiloJedi1.start();
        hiloJedi2.start();

    }
}

class Busqueda {
    private boolean found = false;

    public synchronized boolean isFound() {
        return found;
    }
    public synchronized void encontrarPista(String jedi) {
        if (!found) {
            found = true;
            System.out.println(jedi + " encontró una pista");
        }
    }

}

class Explorador implements Runnable{
    private Random random = new Random();
    private String name;
    private Busqueda search;
    
    public Explorador(String name, Busqueda search) {
        this.name = name;
        this.search = search;
    }

    @Override
    public void run() {
        try{
            while (!search.isFound()) {
                int time = random.nextInt(4000) + 1000;
                System.out.println(name + " buscando durante " + time + " meses.");
                Thread.sleep(time);

                if (!search.isFound()) {
                    search.encontrarPista(name);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

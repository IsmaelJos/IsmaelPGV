package org.example;

public class FabricaDeDroids implements Runnable{

    private int numSerie;

    public FabricaDeDroids(int numSerie) {
        this.numSerie = numSerie;
    }

    @Override
    public void run() {
        try {
            
            Thread.sleep(5000);
            System.out.println("Droide " + numSerie + " ensamblado");
            Thread.sleep(2000);
            System.out.println("Droide " + numSerie + " Activo");
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        Thread droide1 = new Thread(new FabricaDeDroids(1));
        Thread droide2 = new Thread(new FabricaDeDroids(2));
        droide1.start();
        droide2.start();
    }

}

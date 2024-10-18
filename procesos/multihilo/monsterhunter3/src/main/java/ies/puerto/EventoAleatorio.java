package ies.puerto;

public class EventoAleatorio implements Runnable {

    private Mapa mapa;
    
    public EventoAleatorio(Mapa mapa){
        this.mapa = mapa;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mapa.addEvento();
        System.out.println("Se ha añadido un powerUp al mapa");
    }
}

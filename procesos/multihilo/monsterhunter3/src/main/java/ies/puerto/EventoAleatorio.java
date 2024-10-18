package main.java.ies.puerto;

import ies.puerto.Mapa;

public class EventoAleatorio implements Runnable {

    private Mapa mapa;
    
    public EventoAleatorio(Mapa mapa){
        this.mapa = mapa;
    }

    @Override
    public void run() {
        mapa.addEvento();
    }

    

}

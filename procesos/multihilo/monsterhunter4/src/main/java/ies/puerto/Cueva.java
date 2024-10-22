package ies.puerto;

import java.util.concurrent.Semaphore;

public class Cueva {
    private final Semaphore semaphore;
    private Mapa mapa;

    public Cueva(Mapa mapa, Semaphore semaphore){
        this.mapa = mapa;
        this.semaphore = semaphore;
    }


}

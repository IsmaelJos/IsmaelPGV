package ies.puerto;

public class JuegoCazadores {
    public static void main(String[] args) {
        
        Mapa mapa = new Mapa();

        mapa.addMonstruo();
        mapa.addMonstruo();

        Cazador cazador1 = new Cazador("cazador1",mapa);
        Cazador cazador2 = new Cazador("cazador2",mapa);

        new Thread(cazador1).start();
        new Thread(cazador2).start();

        
    }
}

package ies.puerto;

public class JuegoCazadores2 {
    public static void main(String[] args) {
        
        Mapa mapa = new Mapa();

        Monstruo monstruo1 = new Monstruo("monstruo1",mapa);
        Monstruo monstruo2 = new Monstruo("monstruo2",mapa);

        Cazador cazador1 = new Cazador("cazador1",mapa);
        Cazador cazador2 = new Cazador("cazador2",mapa);

        new Thread(cazador1).start();
        new Thread(cazador2).start();


        new Thread(monstruo1).start();
        new Thread(monstruo2).start();

        
        
    }
}

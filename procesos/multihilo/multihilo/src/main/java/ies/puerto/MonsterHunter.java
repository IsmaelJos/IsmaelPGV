package ies.puerto;

import java.util.Random;

public class MonsterHunter {
    public static void main(String[] args) {
       
    }



    class Mapa {
        // Lógica del mapa y gestión de monstruos
    }



    class Monstruo {
        // Propiedades del monstruo
    }



    class Cazador extends Thread {
    private String nombre;
    private int monstruosAtrapados = 0;

    public Cazador(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        while (true) {
            // Lógica de movimiento
            // Intentar atrapar un monstruo
            // Aumentar el contador de monstruos atrapados
            try {
                Thread.sleep(new Random().nextInt(1000)); // Espera aleatoria
            } catch (InterruptedException e) {
                break; // Terminar el hilo si es interrumpido
            }
        }
    }

    public class JuegoCazadores {
        public static void main(String[] args) {
            // Crear instancias de cazadores y comenzar el juego
        }
    }

}
}

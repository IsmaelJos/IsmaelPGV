package ies.puerto;

public class JuegoCazadores {
    public static void main(String[] args) {
        
        int tiempoMaximo = 20000;
        
        boolean finalizar = false;

        Mapa mapa = new Mapa();

        mapa.addMonstruo();
        mapa.addMonstruo();

        long tiempoInicio = System.currentTimeMillis();

        Cazador cazador1 = new Cazador("cazador1",mapa);
        Cazador cazador2 = new Cazador("cazador2",mapa);

        Thread hiloCazador1 = new Thread(cazador1);
        Thread hiloCazador2 = new Thread(cazador2);
        hiloCazador1.start();
        hiloCazador2.start();
        
        while(!finalizar){
            if(System.currentTimeMillis() - tiempoInicio >= tiempoMaximo) {

                System.out.println(cazador1.getNombre()+ " ha atrapado " +cazador1.getMonstruosAtrapados()+" monstruos"); 
                System.out.println(cazador2.getNombre()+ " ha atrapado " +cazador2.getMonstruosAtrapados()+" monstruos"); 
                
                hiloCazador1.interrupt();
                hiloCazador2.interrupt();
                finalizar = true;
            }
        }
    }
}

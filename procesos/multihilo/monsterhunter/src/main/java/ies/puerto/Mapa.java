package ies.puerto;

public class Mapa {
    private String[][] map;
    private static int size = 10;
    private int cantidadMonstruos = 0;

    public Mapa() {
        this.map = new String[size][size]; // Inicializamos el mapa con ceros
        generarMapa();
    }
    private void generarMapa() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.map[i][j] = " * "; 
            }
        }
    }

    public void addMonstruo() {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " M ";
        }else{
            addMonstruo();
        }

    }

    public synchronized void addCazador(Cazador cazador) {
        int x = cazador.getPosX();
        int y = cazador.getPosY();
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
            cazador.setPos(x,y);
        }else{
            addCazador(cazador);
        }

    }
    public synchronized boolean moverCazador(Cazador cazador) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
            cazador.setPos(x,y);
            return false;
        }if(this.map[x][y].equals(" M ")){
            cazador.atraparMonstruo();
            map[x][y] = " C ";
            cazador.setPos(x,y);
            addMonstruo();
            return true;
        }if (this.map[x][y].equals(" C ")) {
            moverCazador(cazador);
            return false;
        }
        return false;
    }
    
}

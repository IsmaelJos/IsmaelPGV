package ies.puerto;

public class Mapa {
    private String[][] map;
    private static int size = 5;

    public Mapa() {
        this.map = new String[size][size]; // Inicializamos el mapa con ceros
        generarMapa();
    }
    private void generarMapa() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.map[i][j] = " * "; 
            }
        }
    }

    public void showMapa(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public synchronized void addMonstruo(Monstruo monstruo) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " M ";
            monstruo.setPos(x,y);
        }else{
            addMonstruo(monstruo);
        }

    }

    public synchronized boolean comprobarMonstruo(Monstruo monstruo) {
        int x = monstruo.getPosX();
        int y = monstruo.getPosY();
        if (this.map[x][y].equals(" C ")) {
            return true;
        }
        return false;
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

    public synchronized void moverMonstruo(Monstruo monstruo) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);

        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " M ";
            this.map[monstruo.getPosX()][monstruo.getPosY()] = " * ";
            monstruo.setPos(x,y);
        }else{
            moverMonstruo(monstruo);
            this.showMapa();
        }
    }

    public synchronized boolean moverCazador(Cazador cazador) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
            this.map[cazador.getPosX()][cazador.getPosY()] = " * ";
            cazador.setPos(x,y);
            return false;
            
        }if(this.map[x][y].equals(" M ")){
            cazador.atraparMonstruo();
            map[x][y] = " C ";
            this.map[cazador.getPosX()][cazador.getPosY()] = " * ";
            cazador.setPos(x,y);
            this.showMapa();
            return true;
            
        }if (this.map[x][y].equals(" C ")) {
            moverCazador(cazador);
            return false;
        }
        return false;
        
    }

    public int getSize(){
        return size;
    }
    
}

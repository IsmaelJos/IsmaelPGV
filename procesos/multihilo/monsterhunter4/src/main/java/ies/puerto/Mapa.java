package ies.puerto;

import java.util.concurrent.Semaphore;

public class Mapa {
    private String[][] map;
    private static int size = 5;
    private final Semaphore semaphore;

    public Mapa() {
        this.map = new String[size][size]; // Inicializamos el mapa con ceros
        generarMapa();
        this.semaphore = new Semaphore(1);
    }

    private void generarMapa() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.map[i][j] = " * ";
            }
        }
        addCueva();
    }

    public void showMapa() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public synchronized void addEvento() {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " S ";
        } else {
            addEvento();
        }

    }

    public void entrarCueva(Monstruo monstruo)throws InterruptedException{
        semaphore.acquire();
        monstruo.setEncuevado(true);
        map[monstruo.getPosX()][monstruo.getPosY()] = " * ";
    } 

    public void salirCueva(Monstruo monstruo)throws InterruptedException{
        monstruo.setEncuevado(false);
        semaphore.release();

    }

    public synchronized void addCueva (){
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " A ";
        } else {
            addCueva();
        }
    }

    
    public synchronized void addMonstruo(Monstruo monstruo) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " M ";
            monstruo.setPos(x, y);
        } else {
            addMonstruo(monstruo);
        }

    }

    public synchronized boolean comprobarMonstruo(Monstruo monstruo) {
        int x = monstruo.getPosX();
        int y = monstruo.getPosY();
        if (this.map[x][y].equals(" M ")) {
            return false;
        }
        return true;
    }

    public synchronized void addCazador(Cazador cazador) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
            cazador.setPos(x, y);
        } else {
            addCazador(cazador);
        }

    }

    public synchronized void moverMonstruo(Monstruo monstruo) throws InterruptedException {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);

        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " M ";
            this.map[monstruo.getPosX()][monstruo.getPosY()] = " * ";
            monstruo.setPos(x, y);
        }if (this.map[x][y].equals(" A ")) {
            entrarCueva(monstruo);
        } else {
            moverMonstruo(monstruo);
        }
    }

    public synchronized boolean moverCazador(Cazador cazador) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" S ")) {

            System.out.println(cazador.getNombre() + " a conseguido un poder");
            moverCazador(cazador);
            moverCazador(cazador);
            moverCazador(cazador);
            moverCazador(cazador);
            moverCazador(cazador);
            moverCazador(cazador);
        }
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
            this.map[cazador.getPosX()][cazador.getPosY()] = " * ";
            cazador.setPos(x, y);
            this.showMapa();
            return false;

        }
        if (this.map[x][y].equals(" M ")) {
            if (7 >= Math.random() * 10) {
                cazador.atraparMonstruo();
                map[x][y] = " C ";
                this.map[cazador.getPosX()][cazador.getPosY()] = " * ";
                cazador.setPos(x, y);
                this.showMapa();
                return true;
            } else {
                moverCazador(cazador);
            }

        }
        if (this.map[x][y].equals(" C ")||this.map[x][y].equals(" A ")) {
            moverCazador(cazador);
        }
        return false;

    }

    public int getSize() {
        return size;
    }

    public String[][] getMap() {
        return map;
    }
    

}

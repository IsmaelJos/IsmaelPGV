package ies.puerto;

public class Mapa {
    private String[][] map;
    private static int size = 5;

    public Mapa() {
        this.map = new String[size][size]; 
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

    public synchronized void addMonstruo() {
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
        int a = (int) (Math.random() * size);
        int b = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
            
        }else if(this.map[a][b].equals(" * ")){
            map[a][b] = " C ";
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
            this.map[cazador.getPosX()][cazador.getPosY()] = " * ";
            cazador.setPos(x,y);
            return false;
            
        }if(this.map[x][y].equals(" M ")){
            if( 7 >= Math.random() * 10){
                cazador.atraparMonstruo();
                map[x][y] = " C ";
                this.map[cazador.getPosX()][cazador.getPosY()] = " * ";
                cazador.setPos(x,y);
                this.showMapa();
                return true;
            }else{
                moverCazador(cazador);
            }
            
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

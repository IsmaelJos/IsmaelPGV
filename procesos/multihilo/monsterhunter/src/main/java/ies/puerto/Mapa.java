package ies.puerto;

public class Mapa {
    private String[][] map;
    private static int size = 10;

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
            System.out.println("posición ocupada");
        }

    }

    public void addCazador(int x, int y) {
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
        }else{
            System.out.println("posición ocupada");
        }

    }
    public void moverCazador(Cazador cazador) {
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        if (this.map[x][y].equals(" * ")) {
            map[x][y] = " C ";
            cazador.setPosX(x);
            cazador.setPosY(y);

        }if(this.map[x][y].equals(" M ")){
            cazador.atraparMonstruo();
            cazador.setPosX(x);
            cazador.setPosY(y);
        }
    }
}

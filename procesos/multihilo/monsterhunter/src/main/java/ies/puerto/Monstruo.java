package ies.puerto;

public class Monstruo {

    private String nombre;
    private int posX;
    private int posY;
    
    public Monstruo(String nombre) {
        this.nombre = nombre;
    }
    
    public void setPos(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }
}

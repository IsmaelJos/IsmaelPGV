package ies.puerto.extras;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class ExtraMH {

    public static void main(String[] args) {
        ArrayList<Monstruo> monstruos = new ArrayList<>();
        ListaMon listaMon = new ListaMon(monstruos);

        for (int i = 0; i <= 5; i++) {
            monstruos.add(new Monstruo(i,"Monstruo" + i));

            listaMon = new ListaMon(monstruos);

            new Thread(monstruos.get(i)).start();
        }
    }

    static class Monstruo implements Runnable{

        private int ID;
        private String nombre;
        private int HP = 3;


        public Monstruo(int ID, String nombre) {
            this.ID = ID;
            this.nombre = nombre;
        }

        @Override
        public void run() {


            while (HP > 0) {
                try {
                Random random = new Random();
                Thread.sleep(random.nextInt(10000) + 5000);
                ListaMon.Daniar(this.ID);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        public int getID() {
            return ID;
        }

        public void setID(int ID) {
            this.ID = ID;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getHP() {
            return HP;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Monstruo monstruo = (Monstruo) o;
            return ID == monstruo.ID;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ID);
        }
    }

    static class ListaMon {
        private static ArrayList<Monstruo> monstruos;

        public ListaMon(ArrayList<Monstruo> monstruos) {
            this.monstruos = monstruos;
        }

        public static void Daniar(int ID) {
            int objetivo = (int) (Math.random() * monstruos.size());
            if(objetivo == ID){
                Daniar(ID);
            }else{
                Monstruo monstruObjetivo = getMonstruoByID(ID);
                monstruObjetivo.setHP(monstruObjetivo.getHP()-1);
                monstruos.set(objetivo,monstruObjetivo);
            }

        }

        public ArrayList<Monstruo> getMonstruos() {
            return monstruos;
        }

        public void setMonstruos(ArrayList<Monstruo> monstruos) {
            this.monstruos = monstruos;
        }

        public static Monstruo getMonstruoByID(int ID){
            for (Monstruo monstruo : monstruos) {
                if(ID == monstruo.getID()){
                    return monstruo;
                }
            }
            return null;
        }

    }

}


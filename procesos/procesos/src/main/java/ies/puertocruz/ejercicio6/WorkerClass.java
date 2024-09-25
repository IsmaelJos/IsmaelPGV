package ies.puertocruz.ejercicio6;

public class WorkerClass {
    public static void main(String[] args) {
        String text = "";
        for (int i = 0; i < args.length; i++) {
            text += args[i];
        }
        System.out.println(text);
    }
}

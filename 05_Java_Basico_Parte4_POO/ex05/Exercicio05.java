package ex05;

public class Exercicio05 {
    static class Lampada {
        boolean ligada;
        void ligar() { ligada = true; }
        void desligar() { ligada = false; }
    }
    public static void main(String[] args) {
        Lampada l = new Lampada();
        l.ligar();
        System.out.println("Ligada? " + l.ligada);
        l.desligar();
        System.out.println("Ligada? " + l.ligada);
    }
}

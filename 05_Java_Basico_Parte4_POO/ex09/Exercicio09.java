package ex09;

public class Exercicio09 {
    static class Celular {
        String marca, modelo;
        Celular(String marca, String modelo) { this.marca = marca; this.modelo = modelo; }
    }
    public static void main(String[] args) {
        Celular c = new Celular("Samsung", "Galaxy S24");
        System.out.println(c.marca + " " + c.modelo);
    }
}

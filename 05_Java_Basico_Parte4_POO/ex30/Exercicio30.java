package ex30;

public class Exercicio30 {
    interface Filtro { boolean aceita(int numero); }
    public static void main(String[] args) {
        Filtro pares = new Filtro() { // classe anônima
            @Override public boolean aceita(int numero) { return numero % 2 == 0; }
        };
        for (int i = 1; i <= 10; i++) if (pares.aceita(i)) System.out.print(i + " ");
        System.out.println();
    }
}

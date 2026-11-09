package ex10;

public class Exercicio10 {
    enum Turno { MANHA, TARDE, NOITE }
    public static void main(String[] args) {
        for (Turno t : Turno.values()) System.out.println(t + " (posição " + t.ordinal() + ")");
    }
}

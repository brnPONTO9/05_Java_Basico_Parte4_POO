package ex22;

public class Exercicio22 {
    static abstract class Veiculo {
        abstract double calcularDiaria();
    }
    static class Carro extends Veiculo { double calcularDiaria() { return 150; } }
    static class Moto extends Veiculo { double calcularDiaria() { return 80; } }
    public static void main(String[] args) {
        Veiculo[] vs = {new Carro(), new Moto()};
        for (Veiculo v : vs) System.out.println(v.getClass().getSimpleName() + ": R$ " + v.calcularDiaria());
    }
}

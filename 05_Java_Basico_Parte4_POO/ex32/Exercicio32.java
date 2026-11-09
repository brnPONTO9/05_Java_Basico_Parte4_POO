package ex32;

public class Exercicio32 {
    interface CalculadoraFrete { double calcular(double peso); }
    static class Normal implements CalculadoraFrete { public double calcular(double peso) { return 10 + peso * 2; } }
    static class Expresso implements CalculadoraFrete { public double calcular(double peso) { return 25 + peso * 4; } }
    static class Retirada implements CalculadoraFrete { public double calcular(double peso) { return 0; } }
    public static void main(String[] args) {
        CalculadoraFrete[] cs = {new Normal(), new Expresso(), new Retirada()};
        for (CalculadoraFrete c : cs) System.out.println(c.getClass().getSimpleName() + ": R$ " + c.calcular(3));
    }
}

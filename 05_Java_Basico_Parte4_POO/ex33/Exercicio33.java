package ex33;

public class Exercicio33 {
    interface Pagamento { void pagar(double v); }
    interface CalculadoraFrete { double calcular(double peso); }
    static class Checkout {
        private final Pagamento pagamento;
        private final CalculadoraFrete frete;
        Checkout(Pagamento pagamento, CalculadoraFrete frete) { this.pagamento = pagamento; this.frete = frete; } // injeção por construtor
        void finalizar(double valor, double peso) {
            double total = valor + frete.calcular(peso);
            pagamento.pagar(total);
        }
    }
    public static void main(String[] args) {
        Checkout c = new Checkout(v -> System.out.println("Pago via Pix: R$ " + v), peso -> 10 + peso * 2);
        c.finalizar(200, 3);
    }
}

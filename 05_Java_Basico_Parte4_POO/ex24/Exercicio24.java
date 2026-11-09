package ex24;

public class Exercicio24 {
    interface FormaPagamento { void pagar(double valor); }
    static class Pix implements FormaPagamento {
        public void pagar(double v) { System.out.println("Pix: R$ " + v); }
    }
    static class Cartao implements FormaPagamento {
        public void pagar(double v) { System.out.printf("Cartão: R$ %.2f (com taxa)%n", v * 1.03); }
    }
    public static void main(String[] args) {
        FormaPagamento f = new Pix(); // referência polimórfica
        f.pagar(100);
        f = new Cartao();
        f.pagar(100);
    }
}

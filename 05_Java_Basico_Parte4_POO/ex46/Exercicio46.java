package ex46;

import java.util.List;
public class Exercicio46 {
    interface PoliticaDesconto { double desconto(double valor); }
    static class Nenhum implements PoliticaDesconto { public double desconto(double v) { return 0; } }
    static class Vip implements PoliticaDesconto { public double desconto(double v) { return v * 0.10; } }
    static class Black implements PoliticaDesconto { public double desconto(double v) { return v * 0.20; } }
    static class CheckoutService { // fechado para modificação: não muda ao criar novas políticas
        double total(double valor, List<PoliticaDesconto> politicas) {
            double d = 0;
            for (PoliticaDesconto p : politicas) d = Math.max(d, p.desconto(valor)); // aplica a melhor política
            return valor - d;
        }
    }
    public static void main(String[] args) {
        CheckoutService s = new CheckoutService();
        System.out.println(s.total(100, List.of(new Nenhum())));
        System.out.println(s.total(100, List.of(new Nenhum(), new Vip())));
        // nova política adicionada sem tocar no CheckoutService (aberto para extensão):
        PoliticaDesconto natal = v -> v * 0.15;
        System.out.println(s.total(100, List.of(new Vip(), natal)));
    }
}

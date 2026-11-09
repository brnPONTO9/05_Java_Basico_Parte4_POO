package ex25;

import java.util.ArrayList;
import java.util.List;
public class Exercicio25 {
    static class ItemPedido {
        final String produto; final int qtd; final double preco;
        ItemPedido(String produto, int qtd, double preco) { this.produto = produto; this.qtd = qtd; this.preco = preco; }
        double subtotal() { return qtd * preco; }
    }
    // Composição: os itens só existem dentro do Pedido (criados por ele)
    static class Pedido {
        private final List<ItemPedido> itens = new ArrayList<>();
        void adicionar(String produto, int qtd, double preco) { itens.add(new ItemPedido(produto, qtd, preco)); }
        double total() { double t = 0; for (ItemPedido i : itens) t += i.subtotal(); return t; }
    }
    public static void main(String[] args) {
        Pedido p = new Pedido();
        p.adicionar("Mouse", 2, 80);
        p.adicionar("Teclado", 1, 150);
        System.out.println("Total: R$ " + p.total());
    }
}

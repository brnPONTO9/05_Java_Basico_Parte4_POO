package ex41;

import java.util.*;
public class Exercicio41 {
    record Produto(String nome, double preco) {}
    record ItemCarrinho(Produto produto, int quantidade) {
        ItemCarrinho { if (quantidade <= 0) throw new IllegalArgumentException("Quantidade inválida"); }
        double subtotal() { return produto.preco() * quantidade; }
    }
    record Cupom(String codigo, double percentual) {}
    static class Carrinho {
        private final List<ItemCarrinho> itens = new ArrayList<>();
        private Cupom cupom;
        void adicionar(Produto p, int qtd) { itens.add(new ItemCarrinho(p, qtd)); }
        void aplicarCupom(Cupom c) { this.cupom = c; }
        double subtotal() { return itens.stream().mapToDouble(ItemCarrinho::subtotal).sum(); }
        double total() { // o total é sempre calculado, nunca definido por setter
            double s = subtotal();
            return cupom == null ? s : s - s * cupom.percentual() / 100;
        }
    }
    public static void main(String[] args) {
        Carrinho c = new Carrinho();
        c.adicionar(new Produto("Mouse", 80), 2);
        c.adicionar(new Produto("Teclado", 150), 1);
        System.out.println("Subtotal: " + c.subtotal());
        c.aplicarCupom(new Cupom("PROMO10", 10));
        System.out.println("Total com cupom: " + c.total());
    }
}

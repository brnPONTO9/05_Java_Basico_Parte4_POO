package ex49;

import java.util.*;
public class Exercicio49 {
    // Núcleo do sistema de pedidos: tipos = Produto, ItemPedido (records), StatusPedido (enum),
    // Pedido, Estoque (interface), EstoqueMemoria, GatewayPagamento (interface), GatewayPix, PedidoService
    enum StatusPedido { CRIADO, PAGO, RECUSADO }
    record Produto(int id, String nome, double preco) {}
    record ItemPedido(Produto produto, int quantidade) { double subtotal() { return produto.preco() * quantidade; } }
    static class Pedido {
        private static int seq = 0;
        final int numero = ++seq;
        private final List<ItemPedido> itens = new ArrayList<>();
        private StatusPedido status = StatusPedido.CRIADO;
        void adicionar(ItemPedido i) { itens.add(i); }
        List<ItemPedido> itens() { return List.copyOf(itens); }
        double total() { return itens.stream().mapToDouble(ItemPedido::subtotal).sum(); }
        StatusPedido status() { return status; }
        void definirStatus(StatusPedido s) { this.status = s; }
    }
    interface Estoque { boolean reservar(Produto p, int qtd); }
    static class EstoqueMemoria implements Estoque {
        private final Map<Integer, Integer> saldo = new HashMap<>();
        EstoqueMemoria(Map<Integer, Integer> inicial) { saldo.putAll(inicial); }
        public boolean reservar(Produto p, int qtd) {
            int atual = saldo.getOrDefault(p.id(), 0);
            if (atual < qtd) return false;
            saldo.put(p.id(), atual - qtd);
            return true;
        }
    }
    interface GatewayPagamento { boolean cobrar(double valor); }
    static class GatewayPix implements GatewayPagamento { public boolean cobrar(double v) { return v < 10_000; } }
    static class PedidoService { // injeção de dependência pelo construtor
        private final Estoque estoque;
        private final GatewayPagamento gateway;
        PedidoService(Estoque e, GatewayPagamento g) { this.estoque = e; this.gateway = g; }
        void fechar(Pedido p) {
            for (ItemPedido i : p.itens())
                if (!estoque.reservar(i.produto(), i.quantidade())) throw new IllegalStateException("Sem estoque de " + i.produto().nome());
            p.definirStatus(gateway.cobrar(p.total()) ? StatusPedido.PAGO : StatusPedido.RECUSADO);
        }
    }
    public static void main(String[] args) {
        Produto mouse = new Produto(1, "Mouse", 80), monitor = new Produto(2, "Monitor", 900);
        PedidoService svc = new PedidoService(new EstoqueMemoria(Map.of(1, 10, 2, 1)), new GatewayPix());
        Pedido p1 = new Pedido();
        p1.adicionar(new ItemPedido(mouse, 2));
        p1.adicionar(new ItemPedido(monitor, 1));
        svc.fechar(p1);
        System.out.println("Pedido " + p1.numero + ": " + p1.total() + " -> " + p1.status());
        Pedido p2 = new Pedido();
        p2.adicionar(new ItemPedido(monitor, 1));
        try { svc.fechar(p2); } catch (IllegalStateException e) { System.out.println("Pedido " + p2.numero + ": " + e.getMessage()); }
    }
}

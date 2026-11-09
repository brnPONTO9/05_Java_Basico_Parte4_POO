package ex34;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
public class Exercicio34 {
    record Item(String nome, double preco) {}
    // Antes: uma classe Pedido fazia as três coisas. Depois: três responsabilidades.
    static class Pedido {
        private final List<Item> itens;
        Pedido(List<Item> itens) { this.itens = itens; }
        List<Item> itens() { return itens; }
        double total() { return itens.stream().mapToDouble(Item::preco).sum(); }
    }
    static class ReciboFormatter {
        String formatar(Pedido p) {
            StringBuilder sb = new StringBuilder("RECIBO\n");
            for (Item i : p.itens()) sb.append(String.format("%s ... %.2f%n", i.nome(), i.preco()));
            return sb.append(String.format("TOTAL: %.2f", p.total())).toString();
        }
    }
    static class ReciboRepositorio {
        void salvar(Path destino, String conteudo) throws IOException { Files.writeString(destino, conteudo); }
    }
    public static void main(String[] args) throws IOException {
        Pedido p = new Pedido(List.of(new Item("Mouse", 80), new Item("Teclado", 150)));
        String recibo = new ReciboFormatter().formatar(p);
        Path arquivo = Files.createTempFile("recibo", ".txt");
        new ReciboRepositorio().salvar(arquivo, recibo);
        System.out.println(Files.readString(arquivo));
        Files.delete(arquivo);
    }
}

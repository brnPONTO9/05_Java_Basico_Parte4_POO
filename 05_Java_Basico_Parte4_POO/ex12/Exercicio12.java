package ex12;

public class Exercicio12 {
    static class Produto {
        private final String nome;
        private final double preco;
        Produto(String nome, double preco) {
            if (preco < 0) throw new IllegalArgumentException("Preço não pode ser negativo");
            this.nome = nome;
            this.preco = preco;
        }
        String getNome() { return nome; }
        double getPreco() { return preco; }
    }
    public static void main(String[] args) {
        System.out.println(new Produto("Caneta", 2.5).getPreco());
        try { new Produto("Erro", -1); } catch (IllegalArgumentException e) { System.out.println("Erro: " + e.getMessage()); }
    }
}

package ex15;

public class Exercicio15 {
    static class Produto {
        private final int codigo;
        private final String nome;
        private final double preco;
        Produto(int codigo, String nome, double preco) { this.codigo = codigo; this.nome = nome; this.preco = preco; }
        @Override public String toString() { return String.format("[%d] %s - R$ %.2f", codigo, nome, preco); }
    }
    public static void main(String[] args) {
        System.out.println(new Produto(1, "Notebook", 3500));
    }
}

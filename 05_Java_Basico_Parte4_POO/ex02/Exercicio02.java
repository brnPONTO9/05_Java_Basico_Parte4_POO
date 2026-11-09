package ex02;

public class Exercicio02 {
    static class Produto {
        String nome;
        double preco;
        Produto(String nome, double preco) { this.nome = nome; this.preco = preco; }
    }
    public static void main(String[] args) {
        Produto[] ps = {new Produto("Mouse", 80), new Produto("Teclado", 150), new Produto("Monitor", 900)};
        Produto maisCaro = ps[0];
        for (Produto p : ps) if (p.preco > maisCaro.preco) maisCaro = p;
        System.out.println("Mais caro: " + maisCaro.nome + " (R$ " + maisCaro.preco + ")");
    }
}

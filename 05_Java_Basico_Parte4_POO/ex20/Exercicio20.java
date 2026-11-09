package ex20;

import java.util.Scanner;
public class Exercicio20 {
    static class Produto {
        final String nome; final double preco;
        Produto(String nome, double preco) {
            if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório");
            if (preco <= 0) throw new IllegalArgumentException("Preço deve ser maior que zero");
            this.nome = nome; this.preco = preco;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Nome: ");
                String nome = in.nextLine();
                System.out.print("Preço: ");
                double preco = Double.parseDouble(in.nextLine().replace(',', '.'));
                Produto p = new Produto(nome, preco);
                System.out.println("Produto criado: " + p.nome + " - R$ " + p.preco);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Dados inválidos: " + e.getMessage() + ". Tente de novo.");
            }
        }
    }
}

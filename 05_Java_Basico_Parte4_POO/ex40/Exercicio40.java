package ex40;

import java.util.Scanner;
public class Exercicio40 {
    static class Cliente {
        private final String nome, email;
        Cliente(String nome, String email) {
            if (nome == null || nome.isBlank()) throw new IllegalArgumentException("Nome obrigatório");
            if (email == null || !email.contains("@")) throw new IllegalArgumentException("E-mail inválido");
            this.nome = nome.trim(); this.email = email.trim();
        }
        @Override public String toString() { return nome + " <" + email + ">"; }
    }
    // App só lê e mostra; a validação fica em Cliente
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Cadastro de clientes (nome vazio encerra a leitura com erro de validação)");
        while (true) {
            System.out.print("Nome (ou 'sair'): ");
            String nome = in.nextLine();
            if (nome.equalsIgnoreCase("sair")) break;
            System.out.print("E-mail: ");
            String email = in.nextLine();
            try { System.out.println("Cadastrado: " + new Cliente(nome, email)); }
            catch (IllegalArgumentException e) { System.out.println("Erro: " + e.getMessage()); }
        }
    }
}

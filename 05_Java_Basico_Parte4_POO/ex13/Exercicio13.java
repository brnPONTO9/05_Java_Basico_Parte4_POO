package ex13;

public class Exercicio13 {
    static class Cliente {
        private final String nome, email;
        Cliente(String nome) { this(nome, "(sem e-mail)"); }
        Cliente(String nome, String email) { this.nome = nome; this.email = email; }
        @Override public String toString() { return nome + " <" + email + ">"; }
    }
    public static void main(String[] args) {
        System.out.println(new Cliente("Ana"));
        System.out.println(new Cliente("Bruno", "bruno@email.com"));
    }
}

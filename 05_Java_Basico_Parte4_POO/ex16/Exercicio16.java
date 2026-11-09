package ex16;

import java.util.Objects;
public class Exercicio16 {
    static class Usuario {
        private final int id;
        private final String nome;
        Usuario(int id, String nome) { this.id = id; this.nome = nome; }
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Usuario u)) return false;
            return id == u.id; // identidade lógica = id
        }
        @Override public int hashCode() { return Objects.hash(id); }
    }
    public static void main(String[] args) {
        Usuario a = new Usuario(1, "Ana"), b = new Usuario(1, "Ana Maria"), c = new Usuario(2, "Ana");
        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("a.equals(c): " + a.equals(c));
        System.out.println("hashCodes iguais (a,b): " + (a.hashCode() == b.hashCode()));
    }
}

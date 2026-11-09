package ex26;

import java.util.ArrayList;
import java.util.List;
public class Exercicio26 {
    static class Professor {
        final String nome;
        Professor(String nome) { this.nome = nome; }
    }
    // Agregação: a Universidade apenas referencia professores que já existem fora dela
    static class Universidade {
        final String nome;
        final List<Professor> professores = new ArrayList<>();
        Universidade(String nome) { this.nome = nome; }
    }
    public static void main(String[] args) {
        Professor p = new Professor("Dra. Flávia");
        Universidade u = new Universidade("Faccat");
        u.professores.add(p);
        System.out.println(u.nome + " tem " + u.professores.size() + " professor(es)");
        u = null; // a universidade deixa de existir...
        System.out.println(p.nome + " continua existindo");
    }
}

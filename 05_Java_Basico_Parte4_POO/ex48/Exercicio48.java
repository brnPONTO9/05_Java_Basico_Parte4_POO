package ex48;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class Exercicio48 {
    record Livro(int id, String titulo) {}
    record Usuario(int id, String nome, boolean premium) {}
    interface PoliticaEmprestimo { int prazoDias(Usuario u); int limiteLivros(Usuario u); }
    static class PoliticaPadrao implements PoliticaEmprestimo {
        public int prazoDias(Usuario u) { return u.premium() ? 21 : 7; }
        public int limiteLivros(Usuario u) { return u.premium() ? 5 : 2; }
    }
    static class Emprestimo {
        final Livro livro; final Usuario usuario; final LocalDate retirada, vencimento;
        Emprestimo(Livro l, Usuario u, LocalDate retirada, int prazo) {
            this.livro = l; this.usuario = u; this.retirada = retirada; this.vencimento = retirada.plusDays(prazo);
        }
        long diasAtraso(LocalDate hoje) { return Math.max(0, ChronoUnit.DAYS.between(vencimento, hoje)); }
    }
    static class Biblioteca {
        private final PoliticaEmprestimo politica;
        private final List<Emprestimo> abertos = new ArrayList<>();
        Biblioteca(PoliticaEmprestimo p) { this.politica = p; }
        Emprestimo emprestar(Livro l, Usuario u, LocalDate hoje) {
            long comUsuario = abertos.stream().filter(e -> e.usuario.equals(u)).count();
            if (comUsuario >= politica.limiteLivros(u)) throw new IllegalStateException(u.nome() + " atingiu o limite de livros");
            if (abertos.stream().anyMatch(e -> e.livro.equals(l))) throw new IllegalStateException("Livro já emprestado: " + l.titulo());
            Emprestimo e = new Emprestimo(l, u, hoje, politica.prazoDias(u));
            abertos.add(e);
            return e;
        }
    }
    public static void main(String[] args) {
        Biblioteca b = new Biblioteca(new PoliticaPadrao());
        Usuario ana = new Usuario(1, "Ana", false);
        LocalDate hoje = LocalDate.of(2025, 3, 1);
        Emprestimo e = b.emprestar(new Livro(1, "Java"), ana, hoje);
        System.out.println("Vencimento: " + e.vencimento + " | atraso em 20/03: " + e.diasAtraso(LocalDate.of(2025, 3, 20)) + " dias");
        b.emprestar(new Livro(2, "SQL"), ana, hoje);
        try { b.emprestar(new Livro(3, "Spring"), ana, hoje); } catch (IllegalStateException ex) { System.out.println("Erro: " + ex.getMessage()); }
    }
}

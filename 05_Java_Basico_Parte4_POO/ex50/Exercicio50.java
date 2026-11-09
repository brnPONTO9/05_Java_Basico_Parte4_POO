package ex50;

import java.util.*;
/*
 * Sistema escolhido: ACADEMIA.
 * Domínio: Aluno (cliente), Plano (abstração), Treino, Academia (agrega alunos e planos).
 * Relações: Academia 1..* Aluno (agregação) | Aluno -> Plano (associação) | Aluno 1..* Treino (composição).
 * Encapsulamento: campos private; Polimorfismo: Plano.mensalidade(); Abstração: Plano é abstrata.
 */
public class Exercicio50 {
    static abstract class Plano {
        abstract String nome();
        abstract double mensalidade();
    }
    static class PlanoBasico extends Plano {
        String nome() { return "Básico"; }
        double mensalidade() { return 90; }
    }
    static class PlanoPremium extends Plano {
        String nome() { return "Premium"; }
        double mensalidade() { return 160; }
    }
    static class Treino {
        private final String nome; private final int minutos;
        Treino(String nome, int minutos) { this.nome = nome; this.minutos = minutos; }
        int minutos() { return minutos; }
        @Override public String toString() { return nome + " (" + minutos + " min)"; }
    }
    static class Aluno {
        private final String nome;
        private final Plano plano;
        private final List<Treino> treinos = new ArrayList<>();
        Aluno(String nome, Plano plano) { this.nome = nome; this.plano = plano; }
        void registrarTreino(String nome, int minutos) {
            if (minutos <= 0) throw new IllegalArgumentException("Duração inválida");
            treinos.add(new Treino(nome, minutos));
        }
        int minutosTotais() { return treinos.stream().mapToInt(Treino::minutos).sum(); }
        String nome() { return nome; }
        Plano plano() { return plano; }
        List<Treino> treinos() { return List.copyOf(treinos); }
    }
    static class Academia {
        private final List<Aluno> alunos = new ArrayList<>();
        void matricular(Aluno a) { alunos.add(a); }
        double faturamentoMensal() { return alunos.stream().mapToDouble(a -> a.plano().mensalidade()).sum(); }
        void relatorio() {
            for (Aluno a : alunos)
                System.out.printf("%s - plano %s - R$ %.2f - %d min treinados %s%n", a.nome(), a.plano().nome(), a.plano().mensalidade(), a.minutosTotais(), a.treinos());
            System.out.printf("Faturamento mensal: R$ %.2f%n", faturamentoMensal());
        }
    }
    public static void main(String[] args) {
        Academia ac = new Academia();
        Aluno ana = new Aluno("Ana", new PlanoPremium()), bruno = new Aluno("Bruno", new PlanoBasico());
        ana.registrarTreino("Musculação", 60);
        ana.registrarTreino("Spinning", 45);
        bruno.registrarTreino("Esteira", 30);
        ac.matricular(ana);
        ac.matricular(bruno);
        ac.relatorio();
    }
}

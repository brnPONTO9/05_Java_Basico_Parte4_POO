package ex27;

public class Exercicio27 {
    static class Pessoa {
        protected final String nome;
        Pessoa(String nome) { this.nome = nome; }
    }
    static class Aluno extends Pessoa {
        private final String matricula;
        Aluno(String nome, String matricula) {
            super(nome); // chama o construtor da superclasse
            this.matricula = matricula;
        }
        @Override public String toString() { return nome + " (" + matricula + ")"; }
    }
    public static void main(String[] args) { System.out.println(new Aluno("Ana", "2025001")); }
}

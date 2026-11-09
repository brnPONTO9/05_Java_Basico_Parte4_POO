package ex21;

public class Exercicio21 {
    static class Funcionario {
        protected final String nome;
        protected final double salario;
        Funcionario(String nome, double salario) { this.nome = nome; this.salario = salario; }
        double percentualBonus() { return 0.05; }
        double calcularBonus() { return salario * percentualBonus(); }
    }
    static class Gerente extends Funcionario {
        Gerente(String nome, double salario) { super(nome, salario); }
        @Override double percentualBonus() { return 0.20; }
    }
    public static void main(String[] args) {
        Funcionario[] fs = {new Funcionario("Ana", 3000), new Gerente("Bruno", 8000)};
        for (Funcionario f : fs) System.out.println(f.nome + ": bônus de R$ " + f.calcularBonus());
    }
}

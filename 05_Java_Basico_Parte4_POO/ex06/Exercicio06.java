package ex06;

public class Exercicio06 {
    static class Aluno {
        double nota1, nota2;
        Aluno(double nota1, double nota2) { this.nota1 = nota1; this.nota2 = nota2; }
        double calcularMedia() { return (nota1 + nota2) / 2; }
    }
    public static void main(String[] args) {
        System.out.println("Média: " + new Aluno(7, 9).calcularMedia());
    }
}

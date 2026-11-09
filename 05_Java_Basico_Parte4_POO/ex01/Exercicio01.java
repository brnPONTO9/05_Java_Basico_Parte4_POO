package ex01;

public class Exercicio01 {
    static class Pessoa {
        String nome;
        int idade;
        Pessoa(String nome, int idade) { this.nome = nome; this.idade = idade; }
    }
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Ana", 25), p2 = new Pessoa("Bruno", 31);
        System.out.println(p1.nome + ", " + p1.idade + " anos");
        System.out.println(p2.nome + ", " + p2.idade + " anos");
    }
}

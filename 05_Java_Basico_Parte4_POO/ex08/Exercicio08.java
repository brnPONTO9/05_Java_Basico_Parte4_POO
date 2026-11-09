package ex08;

public class Exercicio08 {
    static class Curso {
        String nome;
        int cargaHoraria;
        Curso(String nome, int cargaHoraria) { this.nome = nome; this.cargaHoraria = cargaHoraria; }
    }
    public static void main(String[] args) {
        Curso c = new Curso("Java Básico", 60);
        System.out.println(c.nome + " - " + c.cargaHoraria + "h");
    }
}

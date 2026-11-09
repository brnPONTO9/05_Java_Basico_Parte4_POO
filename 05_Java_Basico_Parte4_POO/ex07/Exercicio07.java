package ex07;

public class Exercicio07 {
    static class Livro {
        String titulo;
        boolean disponivel = true;
        Livro(String titulo) { this.titulo = titulo; }
        void emprestar() {
            if (!disponivel) { System.out.println(titulo + " já está emprestado"); return; }
            disponivel = false;
            System.out.println(titulo + " emprestado");
        }
        void devolver() { disponivel = true; System.out.println(titulo + " devolvido"); }
    }
    public static void main(String[] args) {
        Livro l = new Livro("Clean Code");
        l.emprestar();
        l.emprestar();
        l.devolver();
    }
}

package ex35;

public class Exercicio35 {
    record Email(String valor) {
        Email { // construtor compacto com validação
            if (valor == null || !valor.matches("[^@\\s]+@[^@\\s]+\\.[^@\\s]+"))
                throw new IllegalArgumentException("E-mail inválido: " + valor);
        }
        String dominio() { return valor.substring(valor.indexOf('@') + 1); }
    }
    public static void main(String[] args) {
        Email e = new Email("ana@faccat.br");
        System.out.println(e + " -> domínio " + e.dominio());
        try { new Email("invalido"); } catch (IllegalArgumentException ex) { System.out.println("Erro: " + ex.getMessage()); }
    }
}

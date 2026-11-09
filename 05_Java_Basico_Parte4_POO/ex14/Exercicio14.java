package ex14;

public class Exercicio14 {
    static final class Cpf {
        private final String numero;
        Cpf(String numero) {
            String digitos = numero == null ? "" : numero.replaceAll("\\D", "");
            if (digitos.length() != 11) throw new IllegalArgumentException("CPF deve ter 11 dígitos");
            this.numero = digitos;
        }
        String getNumero() { return numero; }
        @Override public String toString() { return numero.substring(0, 3) + "." + numero.substring(3, 6) + "." + numero.substring(6, 9) + "-" + numero.substring(9); }
    }
    public static void main(String[] args) {
        System.out.println(new Cpf("12345678901"));
        try { new Cpf("123"); } catch (IllegalArgumentException e) { System.out.println("Erro: " + e.getMessage()); }
    }
}

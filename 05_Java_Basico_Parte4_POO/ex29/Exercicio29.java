package ex29;

public class Exercicio29 {
    static class Validador {
        static class Resultado {
            final boolean valido; final String mensagem;
            Resultado(boolean valido, String mensagem) { this.valido = valido; this.mensagem = mensagem; }
        }
        static Resultado validarEmail(String email) {
            if (email == null || !email.contains("@")) return new Resultado(false, "E-mail sem @");
            return new Resultado(true, "E-mail válido");
        }
    }
    public static void main(String[] args) {
        Validador.Resultado r1 = Validador.validarEmail("ana@email.com"), r2 = Validador.validarEmail("ana.email.com");
        System.out.println(r1.valido + " - " + r1.mensagem);
        System.out.println(r2.valido + " - " + r2.mensagem);
    }
}

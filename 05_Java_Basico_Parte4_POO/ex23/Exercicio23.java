package ex23;

public class Exercicio23 {
    interface Autenticavel { boolean autenticar(String senha); }
    static class Usuario implements Autenticavel {
        public boolean autenticar(String senha) { return "user123".equals(senha); }
    }
    static class Administrador implements Autenticavel {
        public boolean autenticar(String senha) { return "admin@2025".equals(senha); }
    }
    public static void main(String[] args) {
        Autenticavel u = new Usuario(), a = new Administrador();
        System.out.println(u.autenticar("user123") + " " + a.autenticar("errada"));
    }
}

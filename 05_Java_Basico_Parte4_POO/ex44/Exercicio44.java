package ex44;

public class Exercicio44 {
    // Interface Segregation: interfaces pequenas, cada canal implementa só o que suporta
    interface EnviaTexto { void enviarTexto(String destino, String msg); }
    interface EnviaAnexo { void enviarAnexo(String destino, String arquivo); }
    interface EnviaPush { void enviarPush(String token, String msg); }

    static class Email implements EnviaTexto, EnviaAnexo {
        public void enviarTexto(String d, String m) { System.out.println("E-mail para " + d + ": " + m); }
        public void enviarAnexo(String d, String a) { System.out.println("E-mail para " + d + " com anexo " + a); }
    }
    static class Sms implements EnviaTexto { // SMS não suporta anexo: não é obrigado a implementar
        public void enviarTexto(String d, String m) { System.out.println("SMS para " + d + ": " + m); }
    }
    static class App implements EnviaPush {
        public void enviarPush(String t, String m) { System.out.println("Push para " + t + ": " + m); }
    }
    public static void main(String[] args) {
        new Email().enviarTexto("ana@x.com", "Olá");
        new Email().enviarAnexo("ana@x.com", "nota.pdf");
        new Sms().enviarTexto("5199999-0000", "Olá");
        new App().enviarPush("tok123", "Novidade!");
    }
}

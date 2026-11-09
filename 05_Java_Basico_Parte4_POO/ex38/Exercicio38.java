package ex38;

public class Exercicio38 {
    interface Notificador { void enviar(String msg); }
    static class Email implements Notificador { public void enviar(String m) { System.out.println("[E-mail] " + m); } }
    static class Sms implements Notificador { public void enviar(String m) { System.out.println("[SMS] " + m); } }
    static class Console implements Notificador { public void enviar(String m) { System.out.println("[Console] " + m); } }
    static class NotificadorFactory {
        static Notificador criar(String tipo) {
            return switch (tipo.toLowerCase()) {
                case "email" -> new Email();
                case "sms" -> new Sms();
                case "console" -> new Console();
                default -> throw new IllegalArgumentException("Tipo desconhecido: " + tipo);
            };
        }
    }
    public static void main(String[] args) {
        for (String cfg : new String[]{"email", "sms", "console"}) NotificadorFactory.criar(cfg).enviar("Olá!");
        try { NotificadorFactory.criar("fax"); } catch (IllegalArgumentException e) { System.out.println("Erro: " + e.getMessage()); }
    }
}

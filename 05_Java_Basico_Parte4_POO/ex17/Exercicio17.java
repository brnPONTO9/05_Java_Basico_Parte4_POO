package ex17;

public class Exercicio17 {
    enum Prioridade {
        BAIXA(72), MEDIA(24), ALTA(4);
        private final int slaHoras;
        Prioridade(int slaHoras) { this.slaHoras = slaHoras; }
        int getSlaHoras() { return slaHoras; }
    }
    public static void main(String[] args) {
        for (Prioridade p : Prioridade.values()) System.out.println(p + ": SLA de " + p.getSlaHoras() + "h");
    }
}

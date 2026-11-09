package ex04;

public class Exercicio04 {
    static class Conta {
        double saldo;
        void depositar(double valor) { saldo += valor; }
    }
    public static void main(String[] args) {
        Conta c = new Conta();
        c.depositar(150);
        c.depositar(50);
        System.out.println("Saldo: " + c.saldo);
    }
}

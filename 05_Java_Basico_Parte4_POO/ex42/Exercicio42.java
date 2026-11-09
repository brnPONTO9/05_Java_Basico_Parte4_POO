package ex42;

import java.util.*;
public class Exercicio42 {
    static class Conta {
        private final String titular;
        private double saldo;
        private final List<String> extrato = new ArrayList<>();
        Conta(String titular, double saldoInicial) {
            if (saldoInicial < 0) throw new IllegalArgumentException("Saldo inicial negativo");
            this.titular = titular; this.saldo = saldoInicial;
        }
        void depositar(double v) {            // operação: Depósito
            if (v <= 0) throw new IllegalArgumentException("Depósito deve ser positivo");
            saldo += v; extrato.add("DEPÓSITO +" + v);
        }
        void sacar(double v) {                // operação: Saque
            if (v <= 0) throw new IllegalArgumentException("Saque deve ser positivo");
            if (v > saldo) throw new IllegalStateException("Saldo insuficiente");
            saldo -= v; extrato.add("SAQUE -" + v);
        }
        static void transferir(Conta de, Conta para, double v) { // operação: Transferência (atômica)
            de.sacar(v);
            para.depositar(v);
        }
        double getSaldo() { return saldo; }
        List<String> getExtrato() { return List.copyOf(extrato); }
        String getTitular() { return titular; }
    }
    public static void main(String[] args) {
        Conta a = new Conta("Ana", 500), b = new Conta("Bruno", 100);
        Conta.transferir(a, b, 200);
        System.out.println(a.getTitular() + ": " + a.getSaldo() + " | " + b.getTitular() + ": " + b.getSaldo());
        try { Conta.transferir(a, b, 5000); } catch (IllegalStateException e) { System.out.println("Erro: " + e.getMessage()); }
        System.out.println("Saldos preservados: " + a.getSaldo() + " e " + b.getSaldo());
        System.out.println(a.getExtrato());
    }
}

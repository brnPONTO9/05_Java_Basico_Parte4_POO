package ex11;

public class Exercicio11 {
    static class Conta {
        private double saldo;
        void depositar(double v) { if (v > 0) saldo += v; }
        boolean sacar(double v) {
            if (v <= 0 || v > saldo) return false;
            saldo -= v;
            return true;
        }
        double getSaldo() { return saldo; }
    }
    public static void main(String[] args) {
        Conta c = new Conta();
        c.depositar(100);
        System.out.println("Saque 30: " + c.sacar(30));
        System.out.println("Saque 500: " + c.sacar(500));
        System.out.println("Saldo: " + c.getSaldo());
    }
}

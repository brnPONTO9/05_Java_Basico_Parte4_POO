package ex37;

public class Exercicio37 {
    sealed interface Resultado permits Sucesso, Erro {}
    record Sucesso(String valor) implements Resultado {}
    record Erro(String motivo) implements Resultado {}
    static Resultado dividir(int a, int b) {
        return b == 0 ? new Erro("divisão por zero") : new Sucesso(String.valueOf(a / b));
    }
    static String descrever(Resultado r) {
        return switch (r) { // o compilador garante que todos os casos foram tratados
            case Sucesso s -> "OK: " + s.valor();
            case Erro e -> "FALHA: " + e.motivo();
        };
    }
    public static void main(String[] args) {
        System.out.println(descrever(dividir(10, 2)));
        System.out.println(descrever(dividir(1, 0)));
    }
}

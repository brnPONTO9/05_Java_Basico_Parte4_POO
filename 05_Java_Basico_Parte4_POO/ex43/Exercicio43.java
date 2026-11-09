package ex43;

public class Exercicio43 {
    interface GatewayPagamento { boolean cobrar(String cliente, double valor); }
    static class GatewaySimulado implements GatewayPagamento {
        public boolean cobrar(String cliente, double valor) {
            System.out.println("[Gateway] cobrando R$ " + valor + " de " + cliente);
            return valor <= 1000; // regra de aprovação simulada
        }
    }
    static class GatewayFake implements GatewayPagamento { // para testes
        private final boolean resposta;
        GatewayFake(boolean resposta) { this.resposta = resposta; }
        public boolean cobrar(String c, double v) { return resposta; }
    }
    static class Checkout { // depende só da interface
        private final GatewayPagamento gateway;
        Checkout(GatewayPagamento gateway) { this.gateway = gateway; }
        String finalizar(String cliente, double valor) {
            return gateway.cobrar(cliente, valor) ? "Pagamento aprovado" : "Pagamento recusado";
        }
    }
    public static void main(String[] args) {
        System.out.println(new Checkout(new GatewaySimulado()).finalizar("Ana", 500));
        System.out.println(new Checkout(new GatewaySimulado()).finalizar("Ana", 5000));
        // "teste": com o fake o resultado é previsível
        System.out.println("Teste fake aprova: " + new Checkout(new GatewayFake(true)).finalizar("X", 1));
        System.out.println("Teste fake recusa: " + new Checkout(new GatewayFake(false)).finalizar("X", 1));
    }
}

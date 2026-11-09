package ex31;

public class Exercicio31 {
    enum StatusPedido { CRIADO, PAGO, ENVIADO, CANCELADO }
    static class Pedido {
        private StatusPedido status = StatusPedido.CRIADO;
        void pagar() {
            if (status != StatusPedido.CRIADO) throw new IllegalStateException("Só pedido CRIADO pode ser pago (atual: " + status + ")");
            status = StatusPedido.PAGO;
        }
        void enviar() {
            if (status != StatusPedido.PAGO) throw new IllegalStateException("Só pedido PAGO pode ser enviado (atual: " + status + ")");
            status = StatusPedido.ENVIADO;
        }
        void cancelar() {
            if (status == StatusPedido.ENVIADO || status == StatusPedido.CANCELADO)
                throw new IllegalStateException("Não é possível cancelar pedido " + status);
            status = StatusPedido.CANCELADO;
        }
        StatusPedido getStatus() { return status; }
    }
    public static void main(String[] args) {
        Pedido p = new Pedido();
        p.pagar();
        p.enviar();
        System.out.println("Status: " + p.getStatus());
        try { p.cancelar(); } catch (IllegalStateException e) { System.out.println("Erro: " + e.getMessage()); }
        try { p.pagar(); } catch (IllegalStateException e) { System.out.println("Erro: " + e.getMessage()); }
    }
}

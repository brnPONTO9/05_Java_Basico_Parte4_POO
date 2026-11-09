package ex28;

public class Exercicio28 {
    static abstract class Relatorio {
        // Template Method: a ordem das etapas é fixa (final)
        public final void gerar() {
            System.out.println(cabecalho());
            System.out.println(corpo());
            System.out.println(rodape());
        }
        protected abstract String cabecalho();
        protected abstract String corpo();
        protected abstract String rodape();
    }
    static class RelatorioVendas extends Relatorio {
        protected String cabecalho() { return "=== VENDAS ==="; }
        protected String corpo() { return "Total do mês: R$ 12.000,00"; }
        protected String rodape() { return "Fim do relatório"; }
    }
    public static void main(String[] args) { new RelatorioVendas().gerar(); }
}

package ex45;

public class Exercicio45 {
    /*
     * ANTES (viola Liskov): Ave tinha voar(); Pinguim extends Ave precisava lançar exceção em voar().
     * Um código que usa Ave e chama voar() quebraria com Pinguim, ou seja, a subclasse não substitui a superclasse.
     *
     * DEPOIS: separamos o comportamento "voar" em uma interface; só quem voa implementa.
     * Mudança documentada: Ave deixa de ter voar(); surge a interface Voador.
     */
    static class AveRuim { void voar() { System.out.println("voando"); } }
    static class PinguimRuim extends AveRuim {
        @Override void voar() { throw new UnsupportedOperationException("Pinguim não voa"); }
    }

    static abstract class Ave { abstract String nome(); }
    interface Voador { void voar(); }
    static class Pardal extends Ave implements Voador {
        String nome() { return "Pardal"; }
        public void voar() { System.out.println("Pardal voando"); }
    }
    static class Pinguim extends Ave {
        String nome() { return "Pinguim"; }
        void nadar() { System.out.println("Pinguim nadando"); }
    }
    public static void main(String[] args) {
        try { new PinguimRuim().voar(); } catch (UnsupportedOperationException e) { System.out.println("Violação de Liskov: " + e.getMessage()); }
        Voador v = new Pardal();
        v.voar();
        new Pinguim().nadar();
    }
}

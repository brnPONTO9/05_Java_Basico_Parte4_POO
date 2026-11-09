package ex36;

public class Exercicio36 {
    record Coordenada(double lat, double lon) {}
    public static void main(String[] args) {
        Coordenada a = new Coordenada(-29.65, -50.78), b = new Coordenada(-29.65, -50.78), c = new Coordenada(0, 0);
        System.out.println("a.equals(b): " + a.equals(b)); // true: equals gerado compara os componentes
        System.out.println("a == b: " + (a == b));         // false: objetos diferentes
        System.out.println("a.equals(c): " + a.equals(c));
        System.out.println(a);
    }
}

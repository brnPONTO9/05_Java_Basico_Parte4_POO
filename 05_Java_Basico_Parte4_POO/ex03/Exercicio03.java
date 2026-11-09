package ex03;

public class Exercicio03 {
    static class Retangulo {
        double largura, altura;
        Retangulo(double largura, double altura) { this.largura = largura; this.altura = altura; }
        double area() { return largura * altura; }
    }
    public static void main(String[] args) {
        System.out.println("Área: " + new Retangulo(4, 2.5).area());
    }
}

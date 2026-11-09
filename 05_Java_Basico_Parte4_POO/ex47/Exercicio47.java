package ex47;

import java.util.List;
public class Exercicio47 {
    sealed interface Comando permits Criar, Remover, Listar {}
    record Criar(String nome) implements Comando {}
    record Remover(String nome) implements Comando {}
    record Listar() implements Comando {}
    static final java.util.List<String> dados = new java.util.ArrayList<>();
    static void processar(Comando c) {
        switch (c) {
            case Criar cr -> { dados.add(cr.nome()); System.out.println("Criado: " + cr.nome()); }
            case Remover r -> { System.out.println(dados.remove(r.nome()) ? "Removido: " + r.nome() : "Não existe: " + r.nome()); }
            case Listar l -> System.out.println("Itens: " + dados);
        }
    }
    public static void main(String[] args) {
        for (Comando c : List.of(new Criar("A"), new Criar("B"), new Listar(), new Remover("A"), new Remover("Z"), new Listar())) processar(c);
    }
}

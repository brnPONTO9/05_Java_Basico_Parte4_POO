package br.edu.app;

import br.edu.modelo.Aluno;

// Exercício 18: classe App em outro package usando br.edu.modelo.Aluno
public class App {
    public static void main(String[] args) {
        Aluno a = new Aluno("Carla");
        System.out.println("Aluno: " + a.getNome());
    }
}

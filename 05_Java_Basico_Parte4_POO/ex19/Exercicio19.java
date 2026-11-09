package ex19;

import java.time.LocalDate;
import java.time.Period;
public class Exercicio19 {
    static class DataNascimento {
        private final LocalDate data;
        DataNascimento(LocalDate data) { this.data = data; }
        int idadeEm(LocalDate referencia) { return Period.between(data, referencia).getYears(); }
    }
    public static void main(String[] args) {
        DataNascimento d = new DataNascimento(LocalDate.of(2000, 5, 20));
        System.out.println(d.idadeEm(LocalDate.of(2025, 5, 19))); // 24
        System.out.println(d.idadeEm(LocalDate.of(2025, 5, 20))); // 25
    }
}

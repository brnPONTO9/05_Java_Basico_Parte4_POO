package ex39;

import java.util.*;
public class Exercicio39 {
    interface Repositorio<T> {
        void salvar(T item);
        Optional<T> buscarPorId(int id);
        List<T> listar();
    }
    record Cliente(int id, String nome) {}
    static class ClienteRepositorioMemoria implements Repositorio<Cliente> {
        private final Map<Integer, Cliente> dados = new LinkedHashMap<>();
        public void salvar(Cliente c) { dados.put(c.id(), c); }
        public Optional<Cliente> buscarPorId(int id) { return Optional.ofNullable(dados.get(id)); }
        public List<Cliente> listar() { return List.copyOf(dados.values()); }
    }
    public static void main(String[] args) {
        Repositorio<Cliente> repo = new ClienteRepositorioMemoria();
        repo.salvar(new Cliente(1, "Ana"));
        repo.salvar(new Cliente(2, "Bruno"));
        System.out.println(repo.buscarPorId(2).orElseThrow());
        System.out.println(repo.buscarPorId(9).isPresent());
        System.out.println(repo.listar());
    }
}

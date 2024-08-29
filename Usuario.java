import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um usuário da biblioteca.
 * Extende a classe Pessoa e contém a matrícula do usuário e uma lista de livros emprestados.
 */

public class Usuario extends Pessoa {
    private String id;
    private List<Livro> livrosEmprestados = new ArrayList<>();
    private static final int LIMITE_LIVROS = 5;

    /**
     * Construtor da classe Usuario.
     * @param nome Nome do usuário.
     * @param bi BI do usuário.
     * @param idade Idade do usuário.
     * @param email Email do usuário.
     * @param id Matrícula do usuário.
     */

    public Usuario(String nome, String bi, int idade, String email, String id) {
        super(nome, bi, idade, email);
        this.id = id;
    }

    // Getters
    public String getId() {
        return id;
    }

    public List<Livro> getLivrosEmprestados() {
        return livrosEmprestados;
    }

    /**
     * Adiciona um livro à lista de livros emprestados pelo usuário.
     * @param livro Livro a ser adicionado à lista de empréstimos do usuário.
     */

    public void adicionarLivroEmprestado(Livro livro) {
        if (livrosEmprestados.size() >= LIMITE_LIVROS) {
            throw new IllegalStateException("Limite de livros emprestados atingido.");
        }

        if (!livro.isDisponivel()) {
            throw new IllegalStateException("Livro indisponível para empréstimo.");
        }

        livrosEmprestados.add(livro);
        livro.emprestar();
    }

    /**
     * Remove um livro da lista de livros emprestados pelo usuário.
     * @param livro Livro a ser removido da lista de empréstimos do usuário.
     */

    public void removerLivroEmprestado(Livro livro) {
        if (!livrosEmprestados.contains(livro)) {
            throw new IllegalStateException("Este livro não foi emprestado por este usuário.");
        }

        livrosEmprestados.remove(livro);
        livro.devolver();
    }

    /**
     * Método que retorna uma representação textual dos dados do usuário.
     * @return String contendo as informações do usuário.
     */

    @Override
    public String toString() {
        return "Usuário: " + this.getNome() + " | Matrícula: " + this.getId() + " | Livros emprestados: " + livrosEmprestados.size();
    }
}

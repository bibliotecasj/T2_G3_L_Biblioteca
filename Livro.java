/**
 * Classe que representa um livro na biblioteca.
 * Contém informações sobre o título, autor, ISBN e a disponibilidade do livro.
 */

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponivel;

    /**
     * Construtor da classe Livro.
     * Um novo livro é considerado disponível por padrão.
     * @param titulo Título do livro.
     * @param autor Autor do livro.
     * @param isbn ISBN do livro.
     */

    public Livro(String titulo, String autor, String isbn) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setIsbn(isbn);
        this.disponivel = true;
    }

    /** Getters e Setters com validação */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("Título não pode ser vazio.");
        }
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor != null && !autor.isEmpty()) {
            this.autor = autor;
        } else {
            throw new IllegalArgumentException("Autor não pode ser vazio.");
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn != null && isbn.matches("^(97(8|9))?\\d{9}(\\d|X)$")) {  /** Validação básica de ISBN-10 ou ISBN-13  */
            this.isbn = isbn;
        } else {
            throw new IllegalArgumentException("ISBN inválido.");
        }
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**  Métodos adicionais para manipular o estado do livro */
    public void emprestar() {
        if (this.isDisponivel()) {
            this.setDisponivel(false);
        } else {
            throw new IllegalStateException("Livro já está emprestado.");
        }
    }

    public void devolver() {
        if (!this.isDisponivel()) {
            this.setDisponivel(true);
        } else {
            throw new IllegalStateException("Livro já está disponível.");
        }
    }

    /**
     * Método que retorna uma representação textual dos dados do livro.
     * @return String contendo as informações do livro.
     */

    @Override
    public String toString() {
        return "Livro: " + this.getTitulo() + " | Autor: " + this.getAutor() + " | ISBN: " + this.getIsbn() + " | Disponível: " + (this.isDisponivel() ? "Sim" : "Não");
    }
}

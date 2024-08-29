/**
 * Classe que representa uma Pessoa na biblioteca, contendo informações básicas como nome, BI, idade e email.
 * Pode ser utilizada para representar tanto um bibliotecário quanto um usuário.
 */

public class Pessoa {
    private String nome;
    private String bi;
    private int idade;
    private String email;

    /**
     * Construtor da classe Pessoa.
     * @param nome Nome da pessoa.
     * @param bi Número de Identificação (BI) da pessoa.
     * @param idade Idade da pessoa.
     * @param email Email da pessoa.
     */

    public Pessoa(String nome, String bi, int idade, String email) {
        this.setNome(nome);
        this.setBi(bi);
        this.setIdade(idade);
        this.setEmail(email);
    }

    /**  Getters e Setters com validação */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade >= 0) {
            this.idade = idade;
        } else {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        if (bi != null && !bi.isEmpty()) {
            this.bi = bi;
        } else {
            throw new IllegalArgumentException("BI não pode ser vazio.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido.");
        }
    }

    /**
     * Método que retorna uma representação textual dos dados da pessoa.
     * @return String contendo as informações da pessoa.
     */

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + " | Idade: " + this.getIdade() + " | BI No. : " + this.getBi() + " | Email: " + this.getEmail();
    }
}

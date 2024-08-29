/**
 * Classe que representa um bibliotecário no sistema.
 * Extende a classe Pessoa e adiciona informações sobre matrícula e setor.
 */

public class Bibliotecario extends Pessoa {
    private String id;
    private String sector;
    
    /**
     * Construtor da classe Bibliotecário.
     * @param nome Nome do bibliotecário.
     * @param bi BI do bibliotecário.
     * @param idade Idade do bibliotecário.
     * @param email Email do bibliotecário.
     * @param id Id do bibliotecário.
     * @param sector Setor no qual o bibliotecário trabalha.
     */

    public Bibliotecario(String nome, String bi, int idade, String email, String id, String sector) {
        super(nome, bi, idade, email);
        this.setId(id);
        this.setSector(sector);
    }

    /**  Getters e Setters com validação  */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id != null && !id.isEmpty()) {
            this.id = id;
        } else {
            throw new IllegalArgumentException("Matrícula não pode ser vazia.");
        }
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        if (sector != null && !sector.isEmpty()) {
            this.sector = sector;
        } else {
            throw new IllegalArgumentException("Sector não pode ser vazio.");
        }
    }

    /**
     * Método que retorna uma representação textual dos dados do bibliotecário.
     * @return String contendo as informações do bibliotecário.
     */

    @Override
    public String toString() {
        return super.toString() + " | Matrícula: " + this.getId() + " | Sector: " + this.getSector();
    }
}

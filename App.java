import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

            /*  Sistema de gestão de biblioteca Universitária
            
            *   Clévio Nelson Tivane 
            *   Delmiro Sandra Manuel Chongo
            *   Didyon José Mondlhane 
            *   Isabel José Tovela */


/**
 * Classe principal do sistema de gestão da biblioteca.
 * Contém métodos que implementam as funcionalidades descritas no estudo de caso, como cadastro, empréstimo e devolução de livros.
 */

public class App {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Livro> livros = new ArrayList<>();

    /**
     * Método principal que inicia o sistema de gestão de biblioteca.
     * O usuário escolhe se é um bibliotecário ou um usuário.
     */

    public static void main(String[] args) {
        escolherUsuario();
    }

    /**
     * Permite ao operador escolher se é um bibliotecário ou um usuário.
     * A escolha define quais funcionalidades estarão disponíveis.
     */

    public static void escolherUsuario() {
        Scanner ler = new Scanner(System.in);

        System.out.println("|Seleccione o tipo de operador que és :");
        System.out.println("1. Bibliotecário");
        System.out.println("2. Usuário");
        int operador = ler.nextInt();

        if (operador == 1) {
            System.out.println("Bem vindo, Senhor Bibliotecário!");
            bibliotecario();
        } else if (operador == 2) {
            System.out.println("Bem vindo, Senhor Usuário!");
            usuario();
        } else {
            System.out.println("Opção inválida.");
            escolherUsuario();
        }
    }

     /**
     * Exibe o menu e as opções específicas para bibliotecários.
     * O bibliotecário pode cadastrar usuários, adicionar e remover livros, além de calcular multas.
     */

    public static void bibliotecario() {
        Scanner ler = new Scanner(System.in);
        byte opcao;

        do {
            System.out.println("|Sistema de Gestão de Biblioteca|");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Adicionar Livro");
            System.out.println("3. Remover Livro");
            System.out.println("4. Cálculo de Multa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextByte();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(ler);
                    break;
                case 2:
                    adicionarLivro(ler);
                    break;
                case 3:
                    removerLivro(ler);
                    break;
                case 4:
                    calcularMulta(ler);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 5);
    }

    /**
     * Exibe o menu e as opções específicas para usuários.
     * O usuário pode realizar empréstimos, devoluções e verificar multas.
     */

    public static void usuario() {
        Scanner ler = new Scanner(System.in);
        byte opcao;

        do {
            System.out.println("|Sistema de Gestão de Biblioteca|");
            System.out.println("1. Empréstimo de Livro");
            System.out.println("2. Devolução de Livro");
            System.out.println("3. Cálculo de Multa");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = ler.nextByte();
            ler.nextLine();

            switch (opcao) {
                case 1:
                    emprestarLivro(ler);
                    break;
                case 2:
                    devolverLivro(ler);
                    break;
                case 3:
                    calcularMulta(ler);
                    break;
                case 4:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    /**
     * Permite ao bibliotecário cadastrar um novo usuário.
     * @param ler Scanner usado para entrada de dados.
     */

    public static void cadastrarUsuario(Scanner ler) {
        System.out.println("Cadastro de Usuário:");
        System.out.print("Nome: ");
        String nome = ler.nextLine();
        System.out.print("BI: ");
        String bi = ler.nextLine();
        System.out.print("Idade: ");
        int idade = ler.nextInt();
        ler.nextLine();
        System.out.print("Email: ");
        String email = ler.nextLine();
        System.out.print("Id: ");
        String id = ler.nextLine();

        Usuario usuario = new Usuario(nome, bi, idade, email, id);
        usuarios.add(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    /**
     * Permite ao bibliotecário adicionar um novo livro ao sistema.
     * @param ler Scanner usado para entrada de dados.
     */

    public static void adicionarLivro(Scanner ler) {
        System.out.println("Adição de Livro:");
        System.out.print("Título: ");
        String titulo = ler.nextLine();
        System.out.print("Autor: ");
        String autor = ler.nextLine();
        System.out.print("ISBN: ");
        String isbn = ler.nextLine();

        Livro livro = new Livro(titulo, autor, isbn);
        livros.add(livro);
        System.out.println("Livro adicionado com sucesso!");
    }

    public static void removerLivro(Scanner ler) {
        System.out.println("Remoção de Livro:");
        System.out.print("ISBN do livro a ser removido: ");
        String isbn = ler.nextLine();

        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                livros.remove(livro);
                System.out.println("Livro removido com sucesso!");
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    public static void emprestarLivro(Scanner ler) {
        System.out.print("Insira o seu id: ");
        String id = ler.nextLine();
        Usuario usuario = encontrarUsuario(id);

        if (usuario != null) {
            System.out.print("Insira o ISBN do livro: ");
            String isbn = ler.nextLine();

            for (Livro livro : livros) {
                if (livro.getIsbn().equals(isbn) && livro.isDisponivel()) {
                    usuario.adicionarLivroEmprestado(livro);
                    livro.setDisponivel(false);
                    System.out.println("Livro emprestado com sucesso!");
                    return;
                }
            }
            System.out.println("Livro não disponível.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void devolverLivro(Scanner ler) {
        System.out.print("Insira o seu id: ");
        String id = ler.nextLine();
        Usuario usuario = encontrarUsuario(id);

        if (usuario != null) {
            System.out.print("Insira o ISBN do livro: ");
            String isbn = ler.nextLine();

            for (Livro livro : usuario.getLivrosEmprestados()) {
                if (livro.getIsbn().equals(isbn)) {
                    usuario.removerLivroEmprestado(livro);
                    livro.setDisponivel(true);
                    System.out.println("Livro devolvido com sucesso!");
                    return;
                }
            }
            System.out.println("Livro não encontrado nos empréstimos.");
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }

    public static void calcularMulta(Scanner ler) {
        System.out.println("Calculando multa... (Funcionalidade por adicionar ao sistema!!!).");
    }

    public static Usuario encontrarUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
}

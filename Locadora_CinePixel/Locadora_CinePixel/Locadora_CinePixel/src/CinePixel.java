package br.com.cinepixel.ui;
import br.com.cinepixel.modelos.*;
import br.com.cinepixel.service.Locadora;

import java.util.Scanner;

public class CinePixel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locadora locadora = new Locadora();

        // Seed: um administrador/gerente para testes
        locadora.registrarFuncionario(new Administrador("Admin", "00000000000", "adm@cine.com", "admin", "1234"));
        locadora.cadastrarFilme("Matrix", 1999);
        locadora.cadastrarFilme("A Origem", 2010);

        while (true) {
            System.out.println("\n=== Cine Pixel ===");
            if (!locadora.estaLogado()) {
                System.out.println("1. Registrar funcionário");
                System.out.println("2. Entrar (login)");
                System.out.println("0. Sair");
                System.out.print("Opção: ");
                String opc = scanner.nextLine().trim();

                switch (opc) {
                    case "1" -> {
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Login: ");
                        String login = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        System.out.print("Cargo (1-ADM,2-GERENTE,3-COLABORADOR): ");
                        String tipo = scanner.nextLine().trim();

                        Funcionario f;
                        if ("1".equals(tipo)) f = new Administrador(nome, cpf, email, login, senha);
                        else if ("2".equals(tipo)) f = new Gerente(nome, cpf, email, login, senha);
                        else f = new Colaborador(nome, cpf, email, login, senha);

                        boolean ok = locadora.registrarFuncionario(f);
                        System.out.println(ok ? "Funcionário registrado com sucesso!" : "Falha: login já existente.");
                    }
                    case "2" -> {
                        System.out.print("Login: ");
                        String login = scanner.nextLine();
                        System.out.print("Senha: ");
                        String senha = scanner.nextLine();
                        if (locadora.entrar(login, senha)) {
                            System.out.println("Login efetuado! Bem-vindo " + locadora.getFuncionarioLogado().getNomeCompleto());
                        } else {
                            System.out.println("Login/senha inválidos.");
                        }
                    }
                    case "0" -> {
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }

            } else {
                // Menu logado — opções que variam por cargo
                Funcionario atual = locadora.getFuncionarioLogado();
                System.out.println("Logado como: " + atual.getNomeCompleto() + " (" + atual.getCargo() + ")");
                System.out.println("1. Listar filmes disponíveis");
                System.out.println("2. Alugar filme");
                System.out.println("3. Devolver filme");
                System.out.println("4. Cadastrar filme (somente gerente/adm)");
                System.out.println("5. Listar todos funcionários (somente adm)");
                System.out.println("6. Sair (logout)");
                System.out.println("0. Encerrar programa");
                System.out.print("Opção: ");
                String opc = scanner.nextLine().trim();

                switch (opc) {
                    case "1" -> {
                        Filme[] lista = locadora.listarFilmesDisponiveis();
                        if (lista.length == 0) System.out.println("Nenhum filme disponível.");
                        else for (Filme f : lista) System.out.println(f);
                    }
                    case "2" -> {
                        System.out.print("Id do filme para alugar: ");
                        try {
                            int id = Integer.parseInt(scanner.nextLine());
                            boolean alugado = locadora.alugarFilme(id);
                            System.out.println(alugado ? "Filme alugado com sucesso." : "Falha ao alugar (id inválido ou indisponível).");
                        } catch (NumberFormatException e) {
                            System.out.println("Id inválido.");
                        }
                    }
                    case "3" -> {
                        System.out.print("Id do filme para devolver: ");
                        try {
                            int id = Integer.parseInt(scanner.nextLine());
                            boolean ok = locadora.devolverFilme(id);
                            System.out.println(ok ? "Filme devolvido." : "Falha ao devolver (id inválido).");
                        } catch (NumberFormatException e) {
                            System.out.println("Id inválido.");
                        }
                    }
                    case "4" -> {
                        // permissões: GERENTE ou ADM
                        if (atual.getCargo() == Funcionario.Cargo.GERENTE || atual.getCargo() == Funcionario.Cargo.ADM) {
                            System.out.print("Título: ");
                            String titulo = scanner.nextLine();
                            System.out.print("Ano: ");
                            try {
                                int ano = Integer.parseInt(scanner.nextLine());
                                locadora.cadastrarFilme(titulo, ano);
                                System.out.println("Filme cadastrado.");
                            } catch (NumberFormatException e) {
                                System.out.println("Ano inválido.");
                            }
                        } else {
                            System.out.println("Acesso negado: apenas gerente/adm pode cadastrar filmes.");
                        }
                    }
                    case "5" -> {
                        // apenas ADM pode listar todos os funcionários
                        if (atual.getCargo() == Funcionario.Cargo.ADM) {
                            Funcionario[] todos = locadora.listarFuncionarios();
                            for (Funcionario f : todos) System.out.println(f);
                        } else {
                            System.out.println("Acesso negado: apenas administrador.");
                        }
                    }
                    case "6" -> {
                        locadora.sair();
                        System.out.println("Logout efetuado.");
                    }
                    case "0" -> {
                        System.out.println("Encerrando...");
                        scanner.close();
                        return;
                    }
                    default -> System.out.println("Opção inválida.");
                }
            }
        }
    }
}

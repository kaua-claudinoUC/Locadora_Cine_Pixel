package br.com.cinepixel.service;

import br.com.cinepixel.modelos.Filme;
import br.com.cinepixel.modelos.Funcionario;

import java.util.Arrays;

/**
 * Locadora - armazenamento em arrays para funcionários e filmes.
 */
public class Locadora {

    private static final int CAPACIDADE_INICIAL_FUNCIONARIOS = 10;
    private static final int CAPACIDADE_INICIAL_FILMES = 20;

    private Funcionario[] funcionarios;
    private int quantidadeFuncionarios = 0;

    private Filme[] filmes;
    private int quantidadeFilmes = 0;
    private int proximoIdFilme = 1;

    // sessão
    private Funcionario funcionarioLogado = null;

    public Locadora() {
        this.funcionarios = new Funcionario[CAPACIDADE_INICIAL_FUNCIONARIOS];
        this.filmes = new Filme[CAPACIDADE_INICIAL_FILMES];
    }

    // -------------------------------
    // FUNCIONÁRIOS
    // -------------------------------

    public boolean registrarFuncionario(Funcionario f) {
        if (f == null) return false;
        if (buscarFuncionarioPorLogin(f.getLogin()) != null) return false; // login já existe
        aumentarCapacidadeFuncionarios();
        funcionarios[quantidadeFuncionarios++] = f;
        return true;
    }

    private void aumentarCapacidadeFuncionarios() {
        if (quantidadeFuncionarios >= funcionarios.length) {
            funcionarios = Arrays.copyOf(funcionarios, funcionarios.length * 2);
        }
    }

    private Funcionario buscarFuncionarioPorLogin(String login) {
        if (login == null) return null;
        for (int i = 0; i < quantidadeFuncionarios; i++) {
            Funcionario f = funcionarios[i];
            if (f != null && login.equals(f.getLogin())) {
                return f;
            }
        }
        return null;
    }

    public Funcionario[] listarFuncionarios() {
        return Arrays.copyOf(funcionarios, quantidadeFuncionarios);
    }

    // -------------------------------
    // AUTENTICAÇÃO / SESSÃO
    // -------------------------------

    public boolean entrar(String login, String senha) {
        Funcionario f = buscarFuncionarioPorLogin(login);
        if (f != null && f.getSenha().equals(senha)) {
            funcionarioLogado = f;
            return true;
        }
        return false;
    }

    public void sair() {
        funcionarioLogado = null;
    }

    public boolean estaLogado() {
        return funcionarioLogado != null;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    // -------------------------------
    // FILMES
    // -------------------------------

    public Filme cadastrarFilme(String titulo, int ano) {
        if (titulo == null || titulo.isBlank()) return null;
        aumentarCapacidadeFilmes();
        Filme f = new Filme(proximoIdFilme++, titulo, ano);
        filmes[quantidadeFilmes++] = f;
        return f;
    }

    private void aumentarCapacidadeFilmes() {
        if (quantidadeFilmes >= filmes.length) {
            filmes = Arrays.copyOf(filmes, filmes.length * 2);
        }
    }

    public Filme buscarFilmePorId(int id) {
        for (int i = 0; i < quantidadeFilmes; i++) {
            Filme f = filmes[i];
            if (f != null && f.getId() == id) return f;
        }
        return null;
    }

    public Filme[] listarTodosFilmes() {
        return Arrays.copyOf(filmes, quantidadeFilmes);
    }

    public Filme[] listarFilmesDisponiveis() {
        Filme[] temp = new Filme[quantidadeFilmes];
        int c = 0;
        for (int i = 0; i < quantidadeFilmes; i++) {
            Filme f = filmes[i];
            if (f != null && f.getDisponivel()) temp[c++] = f;
        }
        return Arrays.copyOf(temp, c);
    }

    public boolean alugarFilme(int id) {
        Filme f = buscarFilmePorId(id);
        if (f == null) return false;
        return f.alugar();
    }

    public boolean devolverFilme(int id) {
        Filme f = buscarFilmePorId(id);
        if (f == null) return false;
        f.devolver();
        return true;
    }


    //Funçõs para tentarmos adicionar, ou deixarmos no sonho, kkkk
    //A exclusão tbem usa o id para localizar o filme: excluirFilme(int id), mas precisa verificar como montar exatamente
    //o metodo.
    // Buscar filme por texto acho meio ruim, em videos parece dar problema com a busca.

}

package br.com.cinepixel.modelos;

// Esta é a classe-mãe para Herança.
public class Funcionario {

    public enum Cargo {
        ADM(1), GERENTE(2), COLABORADOR(3);

        private final int codigo;
        Cargo(int codigo) { this.codigo = codigo; }
        public int getCodigo() { return codigo; }
    }

    // Atributos
    private String nomeCompleto;
    private String cpf;        // apenas números de teste por enquanto
    private String email;
    private Cargo cargo;
    private String login;
    private String senha;      // mantemos simples por enquanto

    // Construtor (recebe cargo; se passar null, assume COLABORADOR)
    public Funcionario(String nomeCompleto, String cpf, String email, String login, String senha, Cargo cargo) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo == null ? Cargo.COLABORADOR : cargo;
    }

    // Construtor auxiliar que assume COLABORADOR
    public Funcionario(String nomeCompleto, String cpf, String email, String login, String senha) {
        this(nomeCompleto, cpf, email, login, senha, Cargo.COLABORADOR);
    }

    // Getters / Setters
    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Cargo getCargo() { return cargo; }
    public void setCargo(Cargo cargo) { this.cargo = cargo; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    // Método a ser sobrescrito nas subclasses
    public void apresentar() {
        System.out.println("Nome: " + this.nomeCompleto);
        System.out.println("Email: " + this.email);
        System.out.println("Cargo: " + this.cargo);
    }

    // Representação textual do objeto (útil para imprimir e debugar)
    @Override
    public String toString() {
        return String.format("%s | CPF: %s | Email: %s | Cargo: %s | Login: %s",
                nomeCompleto, cpf, email, cargo, login);
    }
}

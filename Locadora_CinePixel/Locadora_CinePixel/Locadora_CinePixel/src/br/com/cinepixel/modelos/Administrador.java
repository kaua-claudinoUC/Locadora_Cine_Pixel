package br.com.cinepixel.modelos;

// Herança.
// A classe Administrador herda da classe Funcionario, reutilizando seus atributos e métodos.

public class Administrador extends Funcionario {

    public Administrador(String nomeCompleto, String cpf, String email, String login, String senha) {
        super(nomeCompleto, cpf, email, login, senha, Cargo.ADM);
    }

    @Override
    public void apresentar() {
        System.out.println("--- Funcionário (Administrador) ---");
        super.apresentar();
        System.out.println("----------------------------------");
    }
}

package br.com.cinepixel.modelos;

// Herança.
// A classe Gerente herda da classe Funcionario, reutilizando seus atributos e métodos.

public class Gerente extends Funcionario {

    public Gerente(String nomeCompleto, String cpf, String email, String login, String senha) {
        //A palavra-chave 'super' chama o construtor da classe-mãe. Passa o cargo explicitamente como Cargo.GERENTE
        super(nomeCompleto, cpf, email, login, senha, Cargo.GERENTE);
    }

//      Polimorfismo.
//      O método 'apresentar' da classe-mãe está sendo sobrescrito (@Override)
//      para fornecer um comportamento específico para a classe Gerente.

    @Override
    public void apresentar() {
        System.out.println("--- Funcionário (Gerente) ---");
        super.apresentar(); // aproveita a apresentação da classe-mãe
        System.out.println("-----------------------------");
    }
}

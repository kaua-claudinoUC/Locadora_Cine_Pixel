package br.com.cinepixel.modelos;

// Herança.
// A classe Colaborador herda da classe Funcionario, reutilizando seus atributos e métodos.

public class Colaborador extends Funcionario {

    public Colaborador(String nomeCompleto, String cpf, String email, String login, String senha) {
        //A palavra-chave 'super' chama o construtor da classe-mãe. Passa o cargo explicitamente como Cargo.COLABORADOR
        super(nomeCompleto, cpf, email, login, senha, Cargo.COLABORADOR);
    }

//      Polimorfismo.
//      O método 'apresentar' da classe-mãe está sendo sobrescrito (@Override)
//      para fornecer um comportamento específico para a classe Colaborador.

    @Override
    public void apresentar() {
        System.out.println("--- Funcionário (Colaborador) ---");
        super.apresentar(); // aproveita a apresentação da classe-mãe
        System.out.println("-----------------------------");
    }
}

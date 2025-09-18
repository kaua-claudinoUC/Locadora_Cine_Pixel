package br.com.cinepixel.modelos;

// Classes e Objetos.
// Esta é a segunda classe própria, representando uma entidade do sistema.
public class Filme {

    // Encapsulamento. Atributos privados.
    private int id;
    private String titulo;
    private int ano;
    private String genero;
    private boolean disponivel = true;

    //Construtores. Construtor parametrizado.
    public Filme(int id, String titulo, int ano) {
        this.id = id;
        this.titulo = titulo;
        this.ano = ano;
    }

    //Get e Set para acesso controlado.
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
    public String getGenero() { return genero; }
    public boolean getDisponivel() { return disponivel; }

    public boolean alugar() {
        if (!disponivel) return false;
        disponivel = false;
        return true;
    }

    public void devolver() {
        disponivel = true;
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " (" + ano + ") - disponível: " + disponivel;
    }
}

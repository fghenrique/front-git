package br.com.fabricio.consumirgit.model;


public class Roles {

    public Roles() {}

    public Roles(String nome) {
        this.nome = nome;
    }

    private Integer id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

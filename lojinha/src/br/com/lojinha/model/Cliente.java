package br.com.lojinha.model;

public class Cliente {

    private int id;
    private String nome;

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String toString() {
        return "Cliente: " + nome;
    }
}
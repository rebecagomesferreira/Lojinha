package br.com.lojinha.model;

public class TipoPagamento {

    private int idTipoPagamento;
    private String nome;

    public TipoPagamento() {
    }

    public TipoPagamento(int idTipoPagamento, String nome) {
        this.idTipoPagamento = idTipoPagamento;
        this.nome = nome;
    }

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

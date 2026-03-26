package br.com.lojinha.model;

public class ItemPedido {

    private int idItensPedido;
    private int idPedido;
    private Produto produto;
    private int quantidade;

    public ItemPedido() {
    }

    public ItemPedido(int idItensPedido, int idPedido, Produto produto, int quantidade) {
        this.idItensPedido = idItensPedido;
        this.idPedido = idPedido;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public int getIdItensPedido() {
        return idItensPedido;
    }

    public void setIdItensPedido(int idItensPedido) {
        this.idItensPedido = idItensPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

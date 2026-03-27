package br.com.lojinha.model;

public class ItemPedido {

    private int id;
    private Produto produto;
    private int quantidade;

    public ItemPedido(int id, Produto produto, int quantidade) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public String toString() {
        return produto + " | Qtd: " + quantidade + " | Subtotal: R$" + getSubtotal();
    }
}
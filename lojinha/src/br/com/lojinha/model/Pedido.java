package br.com.lojinha.model;

import java.util.List;

public class Pedido {

    private int id;
    private Cliente cliente;
    private List<ItemPedido> itens;
    private TipoPagamento pagamento;

    public Pedido(int id, Cliente cliente, List<ItemPedido> itens, TipoPagamento pagamento) {
        this.id = id;
        this.cliente = cliente;
        this.itens = itens;
        this.pagamento = pagamento;
    }

    public double getTotal() {
        return itens.stream().mapToDouble(ItemPedido::getSubtotal).sum();
    }

    public String toString() {
        return cliente +
                "\nItens: " + itens +
                "\nPagamento: " + pagamento +
                "\nTotal: R$" + getTotal();
    }
}
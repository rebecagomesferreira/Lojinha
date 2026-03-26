package br.com.lojinha.model;

import java.util.List;

public class Pedido {

    private int idPedido;
    private String data;
    private Cliente cliente;
    private TipoPagamento tipoPagamento;
    private List<ItemPedido> itens;
    private double total;

    public Pedido() {
    }

    public Pedido(int idPedido, String data, Cliente cliente, TipoPagamento tipoPagamento, List<ItemPedido> itens, double total) {
        this.idPedido = idPedido;
        this.data = data;
        this.cliente = cliente;
        this.tipoPagamento = tipoPagamento;
        this.itens = itens;
        this.total = total;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

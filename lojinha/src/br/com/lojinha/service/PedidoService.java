package br.com.lojinha.service;

import br.com.lojinha.model.*;

import java.util.ArrayList;
import java.util.List;

public class PedidoService {

    private List<ItemPedido> carrinho = new ArrayList<>();
    private Cliente cliente;
    private static int contadorItem = 1;

    public PedidoService(Cliente cliente) {
        this.cliente = cliente;
    }

    public void adicionarItem(Produto produto, int quantidade) {

        if (quantidade <= 0) {
            System.out.println("Quantidade inválida!");
            return;
        }

        if (produto.getEstoque() < quantidade) {
            System.out.println("Estoque insuficiente!");
            return;
        }

        produto.setEstoque(produto.getEstoque() - quantidade);

        ItemPedido item = new ItemPedido(contadorItem++, produto, quantidade);
        carrinho.add(item);

        System.out.println("Item adicionado!");
    }

    public void exibirCarrinho() {
        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        carrinho.forEach(System.out::println);
    }

    public void finalizarPedido(TipoPagamento pagamento) {

        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        Pedido pedido = new Pedido(1, cliente, new ArrayList<>(carrinho), pagamento);

        System.out.println("\nPedido finalizado:");
        System.out.println(pedido);

        carrinho.clear();
    }
}
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

    public void finalizarPedido(TipoPagamento tipoPagamento) {

        if (carrinho.isEmpty()) {
            System.out.println("Carrinho vazio!");
            return;
        }

        Pedido pedido = new Pedido(1, cliente, new ArrayList<>(carrinho), tipoPagamento);

        System.out.println("\nPedido:");
        System.out.println(pedido);

        carrinho.clear();

        Pagamento pagamento = new Pagamento(pedido, tipoPagamento);

        //adicioando o singleton
        pagamento.processar();

        System.out.println("\nPedido:");
        System.out.println(pedido);

        System.out.println("\nDetalhes do pagamento:");
        System.out.println(pagamento);

        carrinho.clear();
    }
}
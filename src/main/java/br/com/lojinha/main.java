package br.com.lojinha;

import br.com.lojinha.model.*;
import java.util.*;

public class Lojinha {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente(1, "Ana", "12345678900", "01/01/2000");

        List<Produto> produtos = new ArrayList<>();

        produtos.add(new Produto(1, "Notebook", 3000.0, 10));
        produtos.add(new Produto(2, "Mouse", 100.0, 20));
        produtos.add(new Produto(3, "Teclado", 200.0, 15));

        List<ItemPedido> carrinho = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== LOJINHA =====");
            System.out.println("1 - Ver produtos");
            System.out.println("2 - Adicionar ao carrinho");
            System.out.println("3 - Ver carrinho");
            System.out.println("4 - Finalizar compra");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("\n--- PRODUTOS ---");
                    for (Produto p : produtos) {
                        System.out.println(p.getIdProduto() + " - " + p.getNome() + " | R$ " + p.getPreco());
                    }
                    break;

                case 2:
                    System.out.print("Digite o ID do produto: ");
                    int id = sc.nextInt();

                    Produto produtoEscolhido = null;

                    for (Produto p : produtos) {
                        if (p.getIdProduto() == id) {
                            produtoEscolhido = p;
                        }
                    }

                    if (produtoEscolhido != null) {
                        System.out.print("Quantidade: ");
                        int qtd = sc.nextInt();

                        ItemPedido item = new ItemPedido(1, 1, produtoEscolhido, qtd);
                        carrinho.add(item);

                        System.out.println("Produto adicionado!");
                    } else {
                        System.out.println("Produto nao encontrado!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- CARRINHO ---");
                    double total = 0;

                    for (ItemPedido item : carrinho) {
                        double subtotal = item.getQuantidade() * item.getProduto().getPreco();
                        total += subtotal;

                        System.out.println(item.getProduto().getNome() +
                                " | Qtd: " + item.getQuantidade() +
                                " | Subtotal: R$ " + subtotal);
                    }

                    System.out.println("TOTAL: R$ " + total);
                    break;

                case 4:
                    System.out.println("\nEscolha forma de pagamento:");
                    System.out.println("1 - Dinheiro");
                    System.out.println("2 - Cartao");

                    int tipo = sc.nextInt();

                    TipoPagamento pagamento;

                    if (tipo == 1) {
                        pagamento = new TipoPagamento(1, "Dinheiro");
                    } else {
                        pagamento = new TipoPagamento(2, "Cartao");
                    }

                    double totalFinal = 0;

                    for (ItemPedido item : carrinho) {
                        totalFinal += item.getQuantidade() * item.getProduto().getPreco();
                    }

                    Pedido pedido = new Pedido(
                            1,
                            "26/03/2026",
                            cliente,
                            pagamento,
                            carrinho,
                            totalFinal
                    );

                    System.out.println("\n===== COMPRA FINALIZADA =====");
                    System.out.println("Cliente: " + pedido.getCliente().getNome());
                    System.out.println("Pagamento: " + pedido.getTipoPagamento().getNome());
                    System.out.println("Total: R$ " + pedido.getTotal());

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}

package br.com.lojinha;

import br.com.lojinha.model.*;
import br.com.lojinha.service.PedidoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cliente cliente = new Cliente(1, "Carol");

        List<Produto> produtos = new ArrayList<>();
        produtos.add(new Produto(1, "Notebook", 3000.0, 5));
        produtos.add(new Produto(2, "Mouse", 100.0, 10));
        produtos.add(new Produto(3, "Teclado", 200.0, 8));

        PedidoService pedidoService = new PedidoService(cliente);

        int opcao = 0;

        do {
            System.out.println("\n1 - Listar produtos");
            System.out.println("2 - Adicionar ao carrinho");
            System.out.println("3 - Ver carrinho");
            System.out.println("4 - Finalizar pedido");
            System.out.println("0 - Sair");

            if (!sc.hasNextInt()) {
                System.out.println("Entrada inválida!");
                sc.next();
                continue;
            }

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:
                    produtos.forEach(System.out::println);
                    break;

                case 2:
                    System.out.print("ID do produto: ");
                    int idProduto = sc.nextInt();

                    Produto produto = produtos.stream()
                            .filter(p -> p.getId() == idProduto)
                            .findFirst()
                            .orElse(null);

                    if (produto == null) {
                        System.out.println("Produto não encontrado!");
                        break;
                    }

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    pedidoService.adicionarItem(produto, quantidade);
                    break;

                case 3:
                    pedidoService.exibirCarrinho();
                    break;

                case 4:
                    System.out.println("Forma de pagamento:");
                    System.out.println("1 - PIX | 2 - CARTAO | 3 - DINHEIRO");

                    int tipo = sc.nextInt();

                    TipoPagamento pagamento = TipoPagamento.fromInt(tipo);

                    if (pagamento == null) {
                        System.out.println("Pagamento inválido!");
                        break;
                    }

                    pedidoService.finalizarPedido(pagamento);
                    break;
            }

        } while (opcao != 0);

        sc.close();
    }
}
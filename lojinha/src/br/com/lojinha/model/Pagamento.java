package br.com.lojinha.model;

import br.com.lojinha.service.ConexaoPagamento;

public class Pagamento {

    private static int contador = 1;

    private int id;
    private Pedido pedido;
    private TipoPagamento tipo;
    private boolean status;

    public Pagamento(Pedido pedido, TipoPagamento tipo) {
        this.id = contador++;
        this.pedido = pedido;
        this.tipo = tipo;
    }

    public void processar() {

        ConexaoPagamento conexao = ConexaoPagamento.getInstancia();

        boolean resultado = conexao.pagar(pedido.getTotal(), tipo);

        this.status = resultado;

        if (resultado) {
            System.out.println("Pagamento aprovado!");
        } else {
            System.out.println("Pagamento recusado!");
        }
    }

    @Override
    public String toString() {
        return "Pagamento ID: " + id +
                "\nTipo: " + tipo +
                "\nStatus: " + (status ? "APROVADO" : "RECUSADO");
    }
}
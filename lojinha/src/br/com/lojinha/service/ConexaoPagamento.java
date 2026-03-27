package br.com.lojinha.service;

import br.com.lojinha.model.TipoPagamento;

public class ConexaoPagamento {

    private static ConexaoPagamento instancia;

    private ConexaoPagamento() {
        System.out.println("Conectado ao sistema externo de pagamento...");
    }

    //criar instancia caso não haja uma já criada
    public static ConexaoPagamento getInstancia() {
        if (instancia == null) {
            instancia = new ConexaoPagamento();
        }
        return instancia;
    }

    //simulando um pagamento
    public boolean pagar(double valor, TipoPagamento tipo) {

        if (tipo == TipoPagamento.PIX) {
            return true;
        }

        if (tipo == TipoPagamento.CARTAO) {
            return valor <= 2000;
        }
        //no pagamento em dinheiro o valor é aleatório
        return Math.random() > 0.2;
    }
}
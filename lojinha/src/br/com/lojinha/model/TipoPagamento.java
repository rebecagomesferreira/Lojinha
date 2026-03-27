package br.com.lojinha.model;

public enum TipoPagamento {

    PIX,
    CARTAO,
    DINHEIRO;

    public static TipoPagamento fromInt(int opcao) {
        switch (opcao) {
            case 1: return PIX;
            case 2: return CARTAO;
            case 3: return DINHEIRO;
            default: return null;
        }
    }
}
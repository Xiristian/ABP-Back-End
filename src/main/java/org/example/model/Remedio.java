package org.example.model;

public class Remedio extends ProdutoQuantitavel{

    private String contraIndicacoes;

    public Remedio(Long id, String descricao, String observacao, Double valor, String contraIndicacoes) {
        super(id, descricao, observacao, valor);
        this.contraIndicacoes = contraIndicacoes;
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }

    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }
}


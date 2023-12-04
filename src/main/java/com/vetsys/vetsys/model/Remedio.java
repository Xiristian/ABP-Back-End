package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("remedio")
public class Remedio extends ProdutoQuantitavel{

    @Column(name = "contra_indicacoes")
    private String contraIndicacoes;

    public Remedio(Produto produto) {
        super(produto.getId(), produto.getDescricao(), produto.getObservacao(), produto.getValor());
    }

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }
    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public Remedio(Long id, String descricao, String observacao, Double valor, String contraIndicacoes) {
        super(id, descricao, observacao, valor);
        this.contraIndicacoes = contraIndicacoes;
    }

    public Remedio() { }
}



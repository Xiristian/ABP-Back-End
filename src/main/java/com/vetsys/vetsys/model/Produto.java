package com.vetsys.vetsys.model;

public class Produto extends EntitiyId {
    private String descricao;
    private String observacao;
    private Double valor;

    public Produto(Long id, String descricao, String observacao, Double valor) {
        super(id);
        this.descricao = descricao;
        this.observacao = observacao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}



package com.vetsys.vetsys.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto")
public class Produto extends EntitiyId {
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String observacao;
    @Column(nullable = false)
    private Double valor;

    public Produto(Long id, String descricao, String observacao, Double valor) {
        super(id);
        this.descricao = descricao;
        this.observacao = observacao;
        this.valor = valor;
    }

    public Produto() {

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



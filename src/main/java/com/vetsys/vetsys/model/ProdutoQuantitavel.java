package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ProdutoQuantitavel extends Produto{
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produtoQuantitavel;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    public Produto getProdutoQuantitavel() {
        return produtoQuantitavel;
    }

    public void setProdutoQuantitavel(Produto produtoQuantitavel) {
        this.produtoQuantitavel = produtoQuantitavel;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}

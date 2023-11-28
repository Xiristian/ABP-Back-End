package com.vetsys.vetsys.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("ProdutoQuantitavelAtendimento")
public class ProdutoQuantitavelAtendimento extends ProdutoAtendimento {

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produtoQuantitavel;

    @Column(name = "quantidade", nullable = false)
    private int quantidade;
    @Column(name = "valor_total", nullable = false)
    private Double valorTotal;

    public ProdutoQuantitavelAtendimento(Long id, Double valor, Double desconto, Produto produtoQuantitavel, int quantidade, Double valorTotal) {
        super(id, valor, desconto);
        this.produtoQuantitavel = produtoQuantitavel;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public ProdutoQuantitavelAtendimento() {
    }
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



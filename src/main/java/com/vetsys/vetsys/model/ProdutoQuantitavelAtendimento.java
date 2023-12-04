package com.vetsys.vetsys.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("produto_quantitavel_atendimento")
public class ProdutoQuantitavelAtendimento extends ProdutoAtendimento {

    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "valor_total")
    private Double valorTotal;

    public ProdutoQuantitavelAtendimento(Long id, Produto produto, Double valor, Double desconto, Atendimento atendimento, int quantidade, Double valorTotal) {
        super(id, produto, valor, desconto, atendimento);
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public ProdutoQuantitavelAtendimento() {
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



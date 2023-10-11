package com.vetsys.vetsys.model;

public class ProdutoQuantitavelAtendimento extends ProdutoAtendimento {

    private ProdutoQuantitavel produtoQuantitavel;
    private int quantidade;
    private Double valorTotal;

    public ProdutoQuantitavelAtendimento(Long id, Double valor, Double desconto, ProdutoQuantitavel produtoQuantitavel, int quantidade, Double valorTotal) {
        super(id, valor, desconto);
        this.produtoQuantitavel = produtoQuantitavel;
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
    }

    public ProdutoQuantitavel getProdutoQuantitavel() {
        return produtoQuantitavel;
    }

    public void setProdutoQuantitavel(ProdutoQuantitavel produtoQuantitavel) {
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


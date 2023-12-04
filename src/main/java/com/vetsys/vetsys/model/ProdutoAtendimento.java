package com.vetsys.vetsys.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto_atendimento")
public class ProdutoAtendimento extends EntitiyId{
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private Double desconto;

    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    @JsonIgnore
    private Atendimento atendimento;

    public ProdutoAtendimento(Long id, Produto produto, Double valor, Double desconto, Atendimento atendimento) {
        super(id);
        this.produto = produto;
        this.valor = valor;
        this.desconto = desconto;
        this.atendimento = atendimento;
    }

    public ProdutoAtendimento() {

    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }
}

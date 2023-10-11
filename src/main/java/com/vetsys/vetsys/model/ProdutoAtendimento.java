package com.vetsys.vetsys.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_produto_atendimento")
public class ProdutoAtendimento extends EntitiyId{
    @Column(nullable = false)
    private Double valor;
    @Column(nullable = false)
    private Double desconto;

    public ProdutoAtendimento(Long id, Double valor, Double desconto) {
        super(id);
        this.valor = valor;
        this.desconto = desconto;
    }

    public ProdutoAtendimento() {

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
}

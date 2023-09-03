package org.example.model;

public class Produto_Atendimento extends EntitiyId{
    private Double valor;
    private Double desconto;

    public Produto_Atendimento(Long id, Double valor, Double desconto) {
        super(id);
        this.valor = valor;
        this.desconto = desconto;
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

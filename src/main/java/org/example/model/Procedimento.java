package org.example.model;

public class Procedimento extends Produto{
    private Tipo tipo;
    public Procedimento(Long id, String descricao, String observacao, Double valor, Tipo tipo) {
        super(id, descricao, observacao, valor);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}

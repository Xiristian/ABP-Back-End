package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("procedimento")
public class Procedimento extends Produto{
    @Column(nullable = true)
    private Tipo tipo;
    public Procedimento(Long id, String descricao, String observacao, Double valor, Tipo tipo) {
        super(id, descricao, observacao, valor);
        this.tipo = tipo;
    }
    public Procedimento() {
        super();
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}

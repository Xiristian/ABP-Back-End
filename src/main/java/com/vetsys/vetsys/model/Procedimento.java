package com.vetsys.vetsys.model;

import javax.persistence.*;

@Entity
@DiscriminatorValue("procedimento")
public class Procedimento extends Produto{
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo")
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

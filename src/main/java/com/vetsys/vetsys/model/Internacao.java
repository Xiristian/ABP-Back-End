package com.vetsys.vetsys.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("internacao")
public class Internacao extends Produto{

    public Internacao(Long id, String descricao, String observacao, Double valor) {
        super(id, descricao, observacao, valor);
    }
    public Internacao() {

    }
}

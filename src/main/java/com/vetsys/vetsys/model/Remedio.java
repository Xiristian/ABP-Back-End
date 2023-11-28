package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Remedio")
public class Remedio extends ProdutoQuantitavel{

    @Column(name = "contra_indicacoes", nullable = false)
    private String contraIndicacoes;

    public String getContraIndicacoes() {
        return contraIndicacoes;
    }
    public void setContraIndicacoes(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public Remedio(String contraIndicacoes) {
        this.contraIndicacoes = contraIndicacoes;
    }

    public Remedio() { }
}



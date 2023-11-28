package com.vetsys.vetsys.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("produto_quantitavel")
public class ProdutoQuantitavel extends Produto{
    public ProdutoQuantitavel(Long id, String descricao, String observacao, Double valor) {
        super(id, descricao, observacao, valor);
    }

    public ProdutoQuantitavel() {
    }
}
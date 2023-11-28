package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("material")
public class Material extends ProdutoQuantitavel{
    public Material() {
    }
}

package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Material")
public class Material extends ProdutoQuantitavel{

    @Column(name = "curativo")
    private String curativo;

    public String getCurativo() {
        return curativo;
    }

    public void setCurativo(String curativo) {
        this.curativo = curativo;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    private String faixa;

    public Material (String curativo ){
        this.curativo = curativo;
    }

    public Material() {
    }
}
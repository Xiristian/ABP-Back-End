package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Empregado extends Pessoa {

  @Column(name = "area_atuacao")
  private String areaAtuacao;
  @Column(name = "cfmv")
  private String cfmv;

  public Empregado() {
  }

  public Empregado(Long id, String nome, String telefone, String endereco, String email, String areaAtuacao, String cfmv) {
    super(id, nome, telefone, endereco, email);
    this.areaAtuacao = areaAtuacao;
    this.cfmv = cfmv;
  }

  public String getAreaAtuacao() {
    return areaAtuacao;
  }

  public void setAreaAtuacao(String areaAtuacao) {
    this.areaAtuacao = areaAtuacao;
  }

  public String getCfmv() {
    return cfmv;
  }

  public void setCfmv(String cfmv) {
    this.cfmv = cfmv;
  }


}

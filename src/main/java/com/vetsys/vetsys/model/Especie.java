package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Especie extends EntitiyId {

  @Column(nullable = false)
  private String descricao;

  public Especie() {
  }
  public Especie(Long id, String descricao) {
    super(id);
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


}

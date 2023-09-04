package org.example.model;

public class Especie extends EntitiyId {

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

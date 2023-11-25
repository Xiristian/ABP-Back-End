package com.vetsys.vetsys.resource.representation;

public class AnimalDTO {

  private Long id;
  private String nome;
  private int idade;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  public Long getEspecieId() {
    return especieId;
  }

  public void setEspecieId(Long especieId) {
    this.especieId = especieId;
  }

  public String getPorte() {
    return porte;
  }

  public void setPorte(String porte) {
    this.porte = porte;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  private Long especieId;
  private String porte;
  private String observacao;


}

package org.example.model;

public class Animal extends EntitiyId {
  private String nome;
  private int idade;
  private Especie especie;
  private Porte porte;
  private String observacao;

  public Animal() {
  }
  public Animal(Long id, String nome, int idade, Especie especie, Porte porte, String observacao) {
    super(id);
    this.nome = nome;
    this.idade = idade;
    this.especie = especie;
    this.porte = porte;
    this.observacao = observacao;
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

  public Especie getEspecie() {
    return especie;
  }

  public void setEspecie(Especie especie) {
    this.especie = especie;
  }

  public Porte getPorte() {
    return porte;
  }

  public void setPorte(Porte porte) {
    this.porte = porte;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }


}

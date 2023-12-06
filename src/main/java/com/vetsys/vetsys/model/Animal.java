package com.vetsys.vetsys.model;
import javax.persistence.*;

@Entity
public class Animal extends EntitiyId {
  @Column(name = "nome")
  private String nome;

  @Column(name = "idade")
  private int idade;

  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "especie_id")
  private Especie especie;
  @Enumerated(EnumType.STRING)
  @Column(name = "porte")  private Porte porte;

  @Column(name = "observacao")
  private String observacao;

  @ManyToOne(cascade = CascadeType.DETACH)
  @JoinColumn(name = "tutor_id")
  private Tutor tutor;

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

  public Tutor getTutor() {
    return tutor;
  }

  public void setTutor(Tutor tutor) {
    this.tutor = tutor;
  }
}

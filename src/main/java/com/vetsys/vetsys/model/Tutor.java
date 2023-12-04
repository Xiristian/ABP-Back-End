package com.vetsys.vetsys.model;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Tutor extends Pessoa{
  @Column(name = "cpf")
  private String cpf;

  @OneToMany(mappedBy = "tutor", cascade = CascadeType.ALL)
  private List<Animal> animais;

  public Tutor() {
  }

  public Tutor(Long id, String nome, String telefone, String endereco, String email, String cpf, List<Animal> animais) {
    super(id, nome, telefone, endereco, email);
    this.cpf = cpf;
    this.animais = animais;
  }
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public List<Animal> getAnimais() {
    return animais;
  }

  public void setAnimais(List<Animal> animais) {
    this.animais = animais;
  }

  public void addAnimais(Animal animal){
    this.animais.add(animal);
  }

  public void delAnimais(Animal animal){
    this.animais.remove(animal);
  }



}


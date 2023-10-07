package com.vetsys.vetsys.model;
import java.util.List;

public class Tutor extends Pessoa{
  private String cpf;
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


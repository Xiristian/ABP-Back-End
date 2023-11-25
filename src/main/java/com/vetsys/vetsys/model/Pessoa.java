package com.vetsys.vetsys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa extends EntitiyId {

 @Column(name = "nome")
  private String nome;
 @Column(name = "telefone")
  private String telefone;
 @Column(name = "endereco")
  private String endereco;
 @Column(name = "email")
  private String email;

  public Pessoa() {
  }
  public Pessoa(Long id, String nome, String telefone, String endereco, String email) {
    super(id);
    this.nome = nome;
    this.telefone = telefone;
    this.endereco = endereco;
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


}

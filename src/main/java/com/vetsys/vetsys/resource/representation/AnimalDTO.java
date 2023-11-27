package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.Porte;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class AnimalDTO {

  private Long id;
  private String nome;
  private int idade;
  private Long especieId;
  private Porte porte;
  private String observacao;
  
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


  public static AnimalDTO fromEntity(Animal animal){
    AnimalDTO dto = new AnimalDTO();
    dto.setId(animal.getId());
    dto.setObservacao(animal.getObservacao());
    dto.setIdade(animal.getIdade());
    dto.setNome(animal.getNome());
    dto.setEspecieId(animal.getEspecieId());
    dto.setPorte(animal.getPorte());

    return dto;
  }

  public Animal toEntity(){
    Animal animal = new Animal();
    animal.setId(this.getId());
    animal.setObservacao(this.getObservacao());
    animal.setIdade(this.getIdade());
    animal.setNome(this.getNome());
    animal.setEspecieId(this.getEspecieId());
    animal.setPorte(this.getPorte());
    return animal;
  }

  public static Page<AnimalDTO> fromEntity(Page<Animal> animalPage){
    List<AnimalDTO> animalDTOList = animalPage.getContent().stream()
      .map(AnimalDTO::fromEntity) .collect(Collectors.toList());
    return new PageImpl<>(animalDTOList, animalPage.getPageable(), animalPage.getTotalElements());
  }

}

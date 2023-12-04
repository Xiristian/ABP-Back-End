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
  private EspecieDTO especie;
  private Porte porte;
  private String observacao;
  private TutorDTO tutor;
  
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

  public EspecieDTO getEspecie() {
    return especie;
  }

  public void setEspecie(EspecieDTO especie) {
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

  public TutorDTO getTutor() {
    return tutor;
  }

  public void setTutor(TutorDTO tutor) {
    this.tutor = tutor;
  }

  public static AnimalDTO fromEntity(Animal animal){
    AnimalDTO dto = new AnimalDTO();
    dto.setId(animal.getId());
    dto.setObservacao(animal.getObservacao());
    dto.setIdade(animal.getIdade());
    dto.setNome(animal.getNome());
    if (animal.getEspecie() != null){
      dto.setEspecie(EspecieDTO.fromEntity(animal.getEspecie()));
    }
    if (animal.getTutor() != null){
      dto.setTutor(TutorDTO.fromEntity(animal.getTutor()));
    }
    dto.setPorte(animal.getPorte());
    return dto;
  }

  public Animal toEntity(){
    Animal animal = new Animal();
    animal.setId(this.getId());
    animal.setObservacao(this.getObservacao());
    animal.setIdade(this.getIdade());
    animal.setNome(this.getNome());
    if (this.getEspecie() != null){
      animal.setEspecie(this.getEspecie().toEntity());
    }
    if (this.getTutor() != null){
      animal.setTutor(this.getTutor().toEntity());
    }
    animal.setPorte(this.getPorte());
    return animal;
  }

  public static Page<AnimalDTO> fromEntity(Page<Animal> animalPage){
    List<AnimalDTO> animalDTOList = animalPage.getContent().stream()
      .map(AnimalDTO::fromEntity) .collect(Collectors.toList());
    return new PageImpl<>(animalDTOList, animalPage.getPageable(), animalPage.getTotalElements());
  }

  public static List<AnimalDTO> fromEntity(List<Animal> animais) {
    return animais.stream().map(AnimalDTO::fromEntity).collect(Collectors.toList());
  }

  public static List<Animal> toEntity(List<AnimalDTO> dtos) {
    return dtos.stream().map(dto -> dto.toEntity()).collect(Collectors.toList());
  }

}

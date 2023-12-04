package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class TutorDTO {
  private Long id;
  private String nome;
  private String telefone;
  private String endereco;
  private String email;

  private String cpf;
  //private List<AnimalDTO> animais;

  public TutorDTO() {
  }

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

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  /*public List<AnimalDTO> getAnimais() {
    return animais;
  }

  public void setAnimais(List<AnimalDTO> animais) {
    this.animais = animais;
  }*/

  public static TutorDTO fromEntity(Tutor tutor){
    TutorDTO dto = new TutorDTO();
    dto.setId(tutor.getId());
    dto.setNome(tutor.getNome());
    dto.setTelefone(tutor.getTelefone());
    dto.setEndereco(tutor.getEndereco());
    dto.setEmail(tutor.getEmail());
    dto.setCpf(tutor.getCpf());
    //dto.setAnimais(AnimalDTO.fromEntity(tutor.getAnimais()));
    return dto;
  }

  public Tutor toEntity(){
    Tutor tutor = new Tutor();
    tutor.setId(this.getId());
    tutor.setNome(this.getNome());
    tutor.setTelefone(this.getTelefone());
    tutor.setEndereco(this.getEndereco());
    tutor.setEmail(this.getEmail());
    tutor.setCpf(this.getCpf());
    return tutor;
  }

  public static Page<TutorDTO> fromEntity(Page<Tutor> tutorPage){
    List<TutorDTO> tutorDTOList = tutorPage.getContent().stream()
      .map(TutorDTO::fromEntity).collect(Collectors.toList());
    return new PageImpl<>(tutorDTOList, tutorPage.getPageable(), tutorPage.getTotalElements());
  }
}

package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import java.util.List;
import java.util.stream.Collectors;

public class TutorDTO {

  private String cpf;
  private List<Animal> animais;

  public TutorDTO() {
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

  public static TutorDTO fromEntity(Tutor tutor){
    TutorDTO dto = new TutorDTO();
    dto.setCpf(tutor.getCpf());
    dto.setAnimais(tutor.getAnimais());
    return dto;
  }

  public Tutor toEntity(){
    Tutor tutor = new Tutor();
    tutor.setCpf(this.getCpf());
    tutor.setAnimais(this.getAnimais());
    return tutor;
  }

  public static Page<TutorDTO> fromEntity(Page<Tutor> tutorPage){
    List<TutorDTO> tutorDTOList = tutorPage.getContent().stream()
      .map(TutorDTO::fromEntity).collect(Collectors.toList());
    return new PageImpl<>(tutorDTOList, tutorPage.getPageable(), tutorPage.getTotalElements());
  }
}

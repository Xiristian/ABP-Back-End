package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Empregado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class EmpregadoDTO {
  private String areaAtuacao;
  private String cfmv;

  public String getAreaAtuacao() {
    return areaAtuacao;
  }

  public void setAreaAtuacao(String areaAtuacao) {
    this.areaAtuacao = areaAtuacao;
  }

  public String getCfmv() {
    return cfmv;
  }
  public void setCfmv(String cfmv) {
    this.cfmv = cfmv;
  }

  public static EmpregadoDTO fromEntity(Empregado empregado){
    EmpregadoDTO dto = new EmpregadoDTO();
    dto.setAreaAtuacao(empregado.getAreaAtuacao());
    dto.setCfmv(String.valueOf(empregado.getCfmv()));

    return dto;
  }

  public Empregado toEntity(){
    Empregado empregado = new Empregado();
    empregado.setAreaAtuacao(this.getAreaAtuacao());
    empregado.setCfmv(this.getCfmv());

    return empregado;
  }

  public static Page<EmpregadoDTO> fromEntity(Page<Empregado> empregadoPage){
    List<EmpregadoDTO> listaEmpregadoDTO = empregadoPage.getContent().stream()
      .map(EmpregadoDTO::fromEntity)
      .collect(Collectors.toList());
    return new PageImpl<>(listaEmpregadoDTO, empregadoPage.getPageable(), empregadoPage.getTotalElements());
  }

}




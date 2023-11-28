package com.vetsys.vetsys.resource.representation;

import com.vetsys.vetsys.model.Empregado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;
import java.util.stream.Collectors;

public class EmpregadoDTO {
  private Long id;
  private String nome;
  private String telefone;
  private String endereco;
  private String email;
  private String areaAtuacao;
  private String cfmv;

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
    dto.setId(empregado.getId());
    dto.setNome(empregado.getNome());
    dto.setTelefone(empregado.getTelefone());
    dto.setEndereco(empregado.getEndereco());
    dto.setEmail(empregado.getEmail());
    dto.setAreaAtuacao(empregado.getAreaAtuacao());
    dto.setCfmv(String.valueOf(empregado.getCfmv()));

    return dto;
  }

  public Empregado toEntity(){
    Empregado empregado = new Empregado();
    empregado.setId(this.getId());
    empregado.setNome(this.getNome());
    empregado.setTelefone(this.getTelefone());
    empregado.setEndereco(this.getEndereco());
    empregado.setEmail(this.getEmail());
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




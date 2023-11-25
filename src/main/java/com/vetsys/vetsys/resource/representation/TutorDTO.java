package com.vetsys.vetsys.resource.representation;

import java.util.List;

public class TutorDTO {

  private String cpf;
  private List<Long> animaisIds;

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public List<Long> getAnimaisIds() {
    return animaisIds;
  }

  public void setAnimaisIds(List<Long> animaisIds) {
    this.animaisIds = animaisIds;
  }
}

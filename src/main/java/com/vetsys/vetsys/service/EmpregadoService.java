package com.vetsys.vetsys.service;

import com.vetsys.vetsys.repository.EmpregadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EmpregadoService {

  private EmpregadoRepository empregadoRepository;

  @Autowired
  public EmpregadoService(EmpregadoRepository empregadoRepository) {

    this.empregadoRepository = empregadoRepository;
  }

}

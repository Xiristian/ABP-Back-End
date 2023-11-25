package com.vetsys.vetsys.resource;
import com.vetsys.vetsys.service.EmpregadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/emprego")
public class EmpregadoController  {
  private  EmpregadoService empregadoService;

  @Autowired
  public EmpregadoController(EmpregadoService empregadoService) {
    this.empregadoService = empregadoService;
  }
}

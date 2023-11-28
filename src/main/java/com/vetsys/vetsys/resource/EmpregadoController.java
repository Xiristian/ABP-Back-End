package com.vetsys.vetsys.resource;
import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.Empregado;
import com.vetsys.vetsys.service.EmpregadoService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/empregado")
public class EmpregadoController extends AbstractController {
  @Autowired
  private EmpregadoService service;

  @Autowired
  public EmpregadoController(EmpregadoService empregadoService) {
    this.service = empregadoService;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody @Valid Empregado entity) {
    Empregado save = service.salvar(entity);
    return ResponseEntity.created(URI.create("/api/empregado/" + entity.getId())).body(save);
  }

  @GetMapping
  public ResponseEntity findAll() {
    List<Empregado> Empregado = service.buscaTodos();
    return ResponseEntity.ok(Empregado);
  }

  @GetMapping("{id}")
  public ResponseEntity findById(@PathVariable("id") Long id) {
    Empregado Empregado = service.buscaPorId(id);
    return ResponseEntity.ok(Empregado);
  }

  @DeleteMapping("{id}")
  public ResponseEntity remove(@PathVariable("id") Long id) {
    service.remover(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Empregado entity) {
    try {
      Empregado alterado = service.alterar(id, entity);
      return ResponseEntity.ok().body(alterado);
    } catch (NotFoundException nfe) {
      return ResponseEntity.noContent().build();
    }
  }
}

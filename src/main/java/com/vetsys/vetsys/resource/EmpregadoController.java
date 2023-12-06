package com.vetsys.vetsys.resource;
import com.vetsys.vetsys.model.Empregado;
import com.vetsys.vetsys.resource.representation.EmpregadoDTO;
import com.vetsys.vetsys.service.EmpregadoService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

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
  public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size){
    Page<Empregado> empregados = service.buscaTodos(filter, PageRequest.of(page, size));
    Page<EmpregadoDTO> empregadosDTO = EmpregadoDTO.fromEntity(empregados);
    return ResponseEntity.ok(empregadosDTO);
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

package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Empregado;
import com.vetsys.vetsys.model.Tutor;
import com.vetsys.vetsys.service.NotFoundException;
import com.vetsys.vetsys.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/tutor")
public class TutorController extends AbstractController {

  @Autowired
  private TutorService service;

  @Autowired
  public TutorController(TutorService tutorService) {

    this.service = tutorService;
  }

  @PostMapping
  public ResponseEntity create(@RequestBody @Valid Tutor entity) {
    Tutor save = service.salvar(entity);
    return ResponseEntity.created(URI.create("/api/tutor/" + entity.getId())).body(save);
  }

  @GetMapping
  public ResponseEntity findAll() {
    List< Tutor>  Tutor = service.buscaTodos();
    return ResponseEntity.ok( Tutor);
  }

  @GetMapping("{id}")
  public ResponseEntity findById(@PathVariable("id") Long id) {
    Tutor  Tutor = service.buscaPorId(id);
    return ResponseEntity.ok( Tutor);
  }

  @DeleteMapping("{id}")
  public ResponseEntity remove(@PathVariable("id") Long id) {
    service.remover(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity update(@PathVariable("id") Long id, @RequestBody  Tutor entity) {
    try {
      Tutor alterado = service.alterar(id, entity);
      return ResponseEntity.ok().body(alterado);
    } catch (NotFoundException nfe) {
      return ResponseEntity.noContent().build();
    }
  }

}

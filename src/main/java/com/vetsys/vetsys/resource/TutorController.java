package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Tutor;
import com.vetsys.vetsys.resource.representation.TutorDTO;
import com.vetsys.vetsys.service.NotFoundException;
import com.vetsys.vetsys.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

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
  public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                @RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size){
    Page<Tutor> tutores = service.buscaTodos(filter, PageRequest.of(page, size));
    Page<TutorDTO> tutoresDTO = TutorDTO.fromEntity(tutores);
    return ResponseEntity.ok(tutoresDTO);
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

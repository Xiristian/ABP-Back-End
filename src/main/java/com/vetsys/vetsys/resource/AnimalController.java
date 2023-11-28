package com.vetsys.vetsys.resource;
import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.service.AnimalService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/animais")
public class AnimalController extends AbstractController{

  @Autowired
  private  AnimalService service;

  @PostMapping
  public ResponseEntity create(@RequestBody @Valid Animal entity){
    Animal save = service.salvar(entity);
    return ResponseEntity.created(URI.create("/api/animais/" + entity.getId())).body(save);
  }

  @GetMapping
  public ResponseEntity findAll(){
    List<Animal> animal = service.buscaTodos();
    return ResponseEntity.ok(animal);
  }

  @GetMapping("{id}")
  public ResponseEntity findById(@PathVariable("id") Long id){
    Animal animal = service.buscaPorId(id);
    return ResponseEntity.ok(animal);
  }

  @DeleteMapping("{id}")
  public ResponseEntity remove(@PathVariable("id") Long id){
    service.remover(id);
    return ResponseEntity.noContent().build();
  }

  @PutMapping("{id}")
  public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Animal entity){
    try {
      Animal alterado = service.alterar(id, entity);
      return ResponseEntity.ok().body(alterado);
    } catch (NotFoundException nfe){
      return ResponseEntity.noContent().build();
    }
  }
}

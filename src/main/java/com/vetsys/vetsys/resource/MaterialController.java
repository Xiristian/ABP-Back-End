package com.vetsys.vetsys.resource;


import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.Material;
import com.vetsys.vetsys.service.AnimalService;
import com.vetsys.vetsys.service.MaterialService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/materiais")
public class MaterialController extends AbstractController{

    @Autowired
    private MaterialService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Material entity){
        Material save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/materiais/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Material> material = service.buscaTodos();
        return ResponseEntity.ok(material);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Material material = service.buscaPorId(id);
        return ResponseEntity.ok(material);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Material entity){
        try {
            Material alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }
}

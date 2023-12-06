package com.vetsys.vetsys.resource;


import com.vetsys.vetsys.model.Material;
import com.vetsys.vetsys.resource.representation.MaterialDTO;
import com.vetsys.vetsys.service.MaterialService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/material")
public class MaterialController extends AbstractController{

    @Autowired
    private MaterialService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Material entity){
        Material save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/material/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<Material> materiais = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<MaterialDTO> materiaisDTO = MaterialDTO.fromEntity(materiais);
        return ResponseEntity.ok(materiaisDTO);
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

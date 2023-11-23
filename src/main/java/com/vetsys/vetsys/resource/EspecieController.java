package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Especie;
import com.vetsys.vetsys.resource.DTOs.EspecieDTO;
import com.vetsys.vetsys.service.EspecieService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/especie")
public class EspecieController extends AbstractController {
    @Autowired
    private EspecieService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Especie entity){
        Especie save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/especie/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<Especie> produtos = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<EspecieDTO> produtosDTO = EspecieDTO.fromEntity(produtos);
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Especie especie = service.buscaPorId(id);
        return ResponseEntity.ok(especie);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Especie entity){
        try {
            Especie alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }

}

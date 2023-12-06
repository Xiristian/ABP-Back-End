package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Remedio;
import com.vetsys.vetsys.resource.representation.RemedioDTO;
import com.vetsys.vetsys.service.NotFoundException;
import com.vetsys.vetsys.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/remedio")
public class RemedioController extends AbstractController{

    @Autowired
    private RemedioService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Remedio entity){
        Remedio save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/remedio/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<Remedio> remedios = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<RemedioDTO> remediosDTO = RemedioDTO.fromEntity(remedios);
        return ResponseEntity.ok(remediosDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Remedio remedio = service.buscaPorId(id);
        return ResponseEntity.ok(remedio);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Remedio entity){
        try {
            Remedio alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }
}

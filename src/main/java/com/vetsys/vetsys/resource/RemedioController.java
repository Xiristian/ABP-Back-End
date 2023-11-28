package com.vetsys.vetsys.resource;



import com.vetsys.vetsys.model.Remedio;
import com.vetsys.vetsys.service.NotFoundException;
import com.vetsys.vetsys.service.RemedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/Remedio")
public class RemedioController extends AbstractController{

    @Autowired
    private RemedioService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Remedio entity){
        Remedio save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/Remedio/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Remedio> remedio = service.buscaTodos();
        return ResponseEntity.ok(remedio);
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

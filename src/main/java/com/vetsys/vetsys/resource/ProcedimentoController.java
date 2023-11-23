package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Procedimento;
import com.vetsys.vetsys.service.ProcedimentoService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/procedimento")
public class ProcedimentoController extends AbstractController {
    @Autowired
    private ProcedimentoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Procedimento entity){
        Procedimento save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/procedimento/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(){
        List<Procedimento> procedimentos = service.buscaTodos();
        return ResponseEntity.ok(procedimentos);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Procedimento procedimento = service.buscaPorId(id);
        return ResponseEntity.ok(procedimento);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Procedimento entity){
        try {
            Procedimento alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }

}

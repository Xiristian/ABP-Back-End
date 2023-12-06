package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Procedimento;
import com.vetsys.vetsys.resource.representation.ProcedimentoDTO;
import com.vetsys.vetsys.service.ProcedimentoService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

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
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<Procedimento> procedimentos = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<ProcedimentoDTO> procedimentosDTO = ProcedimentoDTO.fromEntity(procedimentos);
        return ResponseEntity.ok(procedimentosDTO);
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

package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Internacao;
import com.vetsys.vetsys.model.Internacao;
import com.vetsys.vetsys.resource.representation.InternacaoDTO;
import com.vetsys.vetsys.service.InternacaoService;
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
@RequestMapping("/api/internacao")
public class InternacaoController extends AbstractController {
    @Autowired
    private InternacaoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Internacao entity){
        Internacao save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/internacao/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<Internacao> internacoes = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<InternacaoDTO> internacoesDTO = InternacaoDTO.fromEntity(internacoes);
        return ResponseEntity.ok(internacoesDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Internacao internacao = service.buscaPorId(id);
        return ResponseEntity.ok(internacao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Internacao entity){
        try {
            Internacao alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }

}

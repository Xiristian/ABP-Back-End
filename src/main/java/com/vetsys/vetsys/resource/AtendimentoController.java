package com.vetsys.vetsys.resource;
import com.vetsys.vetsys.model.Atendimento;
import com.vetsys.vetsys.resource.representation.AtendimentoDTO;
import com.vetsys.vetsys.service.AtendimentoService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("api/atendimento")
public class AtendimentoController extends AbstractController{

    @Autowired
    private  AtendimentoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid AtendimentoDTO dto){
        Atendimento entity = dto.toEntity();
        Atendimento save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/atendimento/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<Atendimento> animais = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<AtendimentoDTO> animaisDTO = AtendimentoDTO.fromEntity(animais);
        return ResponseEntity.ok(animaisDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Atendimento atendimento = service.buscaPorId(id);
        return ResponseEntity.ok(atendimento);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Atendimento entity){
        try {
            Atendimento alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }
}

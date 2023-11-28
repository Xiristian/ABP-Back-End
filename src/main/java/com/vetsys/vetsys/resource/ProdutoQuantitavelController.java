package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.Produto;
import com.vetsys.vetsys.model.ProdutoQuantitavel;
import com.vetsys.vetsys.resource.representation.ProdutoDTO;
import com.vetsys.vetsys.resource.representation.ProdutoQuantitavelDTO;
import com.vetsys.vetsys.service.AnimalService;
import com.vetsys.vetsys.service.NotFoundException;
import com.vetsys.vetsys.service.ProdutoQuantitavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("api/produtoquantitavel")
public class ProdutoQuantitavelController extends AbstractController{

    @Autowired
    private ProdutoQuantitavelService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid ProdutoQuantitavel entity){
        ProdutoQuantitavel save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/produtoquantitavel/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<ProdutoQuantitavel> produtosQuantitaveis = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<ProdutoQuantitavelDTO> produtosQuantitaveisDTO = ProdutoQuantitavelDTO.fromEntity(produtosQuantitaveis);
        return ResponseEntity.ok(produtosQuantitaveisDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        ProdutoQuantitavel produtoquantitavel = service.buscaPorId(id);
        return ResponseEntity.ok(produtoquantitavel);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ProdutoQuantitavel entity){
        try {
            ProdutoQuantitavel alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }
}

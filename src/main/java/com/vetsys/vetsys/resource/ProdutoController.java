package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.model.Produto;
import com.vetsys.vetsys.resource.representation.ProdutoDTO;
import com.vetsys.vetsys.service.ProdutoService;
import com.vetsys.vetsys.service.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends AbstractController {
    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Produto entity){
        Produto save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/produto/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size){
        Page<Produto> produtos = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<ProdutoDTO> produtosDTO = ProdutoDTO.fromEntity(produtos);
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id){
        Produto produto = service.buscaPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id){
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity){
        try {
            Produto alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe){
            return ResponseEntity.noContent().build();
        }
    }

}

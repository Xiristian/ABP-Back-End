package com.vetsys.vetsys.service;
import com.vetsys.vetsys.model.Produto;
import com.vetsys.vetsys.model.ProdutoQuantitavel;
import com.vetsys.vetsys.model.QProduto;
import com.vetsys.vetsys.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Produto salvar(Produto entity) {
        if (!repository.findAll(QProduto.produto.descricao.eq(entity.getDescricao())).isEmpty()){
            throw new ValidationException("Já existe um produto com essa descrição cadastrada!");
        }
        return repository.save(entity);
    }

    public List<Produto> buscaTodos(String filter) {
        return repository.findAll(filter, Produto.class);
    }

    public Page<Produto> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Produto.class, pageable);
    }

    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Produto alterar(Long id, Produto entity) {
        Optional<Produto> existingProdutoOptional = repository.findById(id);
        if (existingProdutoOptional.isEmpty()){
            throw new NotFoundException("Produto não encontrado");
        }

        Produto existingProduto = existingProdutoOptional.get();
        modelMapper.map(entity, existingProduto);
        return repository.save(existingProduto);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }
}


 
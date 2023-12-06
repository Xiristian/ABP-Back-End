package com.vetsys.vetsys.service;


import com.vetsys.vetsys.model.ProdutoQuantitavel;
import com.vetsys.vetsys.model.QProdutoQuantitavel;
import com.vetsys.vetsys.repository.ProdutoQuantitavelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoQuantitavelService {

    @Autowired
    private ProdutoQuantitavelRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    public ProdutoQuantitavel salvar(ProdutoQuantitavel entity) {
        if (!repository.findAll(QProdutoQuantitavel.produtoQuantitavel.descricao.eq(entity.getDescricao())).isEmpty()){
            throw new ValidationException("Já existe um produto com essa descrição cadastrada!");
        }
        return repository.save(entity);
    }

    public List<ProdutoQuantitavel> buscaTodos(String filter) {
        return repository.findAll(filter, ProdutoQuantitavel.class);
    }

    public Page<ProdutoQuantitavel> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, ProdutoQuantitavel.class, pageable);
    }

    public ProdutoQuantitavel buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProdutoQuantitavel alterar(Long id, ProdutoQuantitavel entity) {
        Optional<ProdutoQuantitavel> existingProdutoQuantitavelOptional = repository.findById(id);
        if (existingProdutoQuantitavelOptional.isEmpty()){
            throw new NotFoundException("Produto não encontrado");
        }

        ProdutoQuantitavel existingProdutoQuantitavel = existingProdutoQuantitavelOptional.get();
        modelMapper.map(entity, existingProdutoQuantitavel);
        return repository.save(existingProdutoQuantitavel);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}

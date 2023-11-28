package com.vetsys.vetsys.service;


import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.ProdutoQuantitavel;
import com.vetsys.vetsys.model.QAnimal;
import com.vetsys.vetsys.repository.ProdutoQuantitavelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProdutoQuantitavelService {

    @Autowired
    private ProdutoQuantitavelRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    public ProdutoQuantitavel salvar(ProdutoQuantitavel entity) {
        if (!repository.findAll(QProdutoQuantitavel.produtoquantitavel.eq(entity.getProdutoQuantitavel())).isEmpty()){
            throw new ValidationException("Não existe uma observação cadastrada!");
        }
        return repository.save(entity);
    }

    public List<ProdutoQuantitavel> buscaTodos() {
        return repository.findAll();
    }

    public ProdutoQuantitavel buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ProdutoQuantitavel alterar(Long id, ProdutoQuantitavel entity) {
        Optional<ProdutoQuantitavel> existingProdutoQuantitavelOptional = repository.findById(id);
        if (existingProdutoQuantitavelOptional.isEmpty()){
            throw new NotFoundException(" não encontrado");
        }

        ProdutoQuantitavel existingProdutoQuantitavel = existingProdutoQuantitavelOptional.get();
        modelMapper.map(entity, existingProdutoQuantitavel);
        return repository.save(existingProdutoQuantitavel);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}

}

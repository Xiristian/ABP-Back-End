package com.vetsys.vetsys.service;


import com.vetsys.vetsys.model.Material;
import com.vetsys.vetsys.repository.MaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {


    @Autowired
    private MaterialRepository repository;
    @Autowired
    private ModelMapper modelMapper;


    public Material salvar(Material entity) {
        if (!repository.findAll(QMaterial.material.quantidade.q(entity.getQuantidade())).isEmpty())
            throw new ValidationException("Não existe uma quantidade cadastrada!");
        return repository.save(entity);
    }

    public List<Material> buscaTodos() {
        return repository.findAll();
    }

    public Material buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Material alterar(Long id, Material entity) {
        Optional<Material> existingMaterialOptional = repository.findById(id);
        if (existingMaterialOptional.isEmpty()){
            throw new NotFoundException("Material não encontrado");
        }

        Material existingMaterial = existingMaterialOptional.get();
        modelMapper.map(entity, existingMaterial);
        return repository.save(existingMaterial);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}

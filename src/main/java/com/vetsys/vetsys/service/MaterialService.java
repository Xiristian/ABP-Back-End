package com.vetsys.vetsys.service;


import com.vetsys.vetsys.model.Material;
import com.vetsys.vetsys.model.QMaterial;
import com.vetsys.vetsys.repository.MaterialRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        if (!repository.findAll(QMaterial.material.descricao.eq(entity.getDescricao())).isEmpty()){
            throw new ValidationException("Já existe um material com essa descrição cadastrada!");
        }
        return repository.save(entity);
    }

    public List<Material> buscaTodos(String filter) {
        return repository.findAll(filter, Material.class);
    }

    public Page<Material> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Material.class, pageable);
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

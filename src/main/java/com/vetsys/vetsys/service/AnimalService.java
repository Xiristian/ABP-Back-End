package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.Especie;
import com.vetsys.vetsys.model.Produto;
import com.vetsys.vetsys.model.QAnimal;
import com.vetsys.vetsys.repository.AnimalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

  @Autowired
  private AnimalRepository repository;
  @Autowired
  private ModelMapper modelMapper;

  public Animal salvar(Animal entity) {
    return repository.save(entity);
  }

  public List<Animal> buscaTodos(String filter) {
    return repository.findAll(filter, Animal.class);
  }

  public Page<Animal> buscaTodos(String filter, Pageable pageable) {
    return repository.findAll(filter, Animal.class, pageable);
  }

  public Animal buscaPorId(Long id) {
    return repository.findById(id).orElse(null);
  }


  public Animal alterar(Long id, Animal entity) {
    Optional<Animal> existingAnimalOptional = repository.findById(id);
    if (existingAnimalOptional.isEmpty()){
      throw new NotFoundException("Animal não encontrado");
    }

    Animal existingAnimal = existingAnimalOptional.get();
    modelMapper.map(entity, existingAnimal);
    return repository.save(existingAnimal);
  }


  public void remover(Long id) {
    repository.deleteById(id);
  }
}

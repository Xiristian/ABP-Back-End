package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.*;
import com.vetsys.vetsys.repository.TutorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorService {

  @Autowired
  private TutorRepository repository;

  @Autowired
  private ModelMapper modelMapper;

  public Tutor salvar(Tutor entity) {
    if (!repository.findAll(QTutor.tutor.cpf.eq(entity.getCpf())).isEmpty()){
      throw new ValidationException("Já existe um tutor com esse CPF cadastrado!");
    }
    return repository.save(entity);
  }

  public List<Tutor> buscaTodos(String filter) {
    return repository.findAll(filter, Tutor.class);
  }

  public Page<Tutor> buscaTodos(String filter, Pageable pageable) {
    return repository.findAll(filter, Tutor.class, pageable);
  }

  public Tutor buscaPorId(Long id) {
    return repository.findById(id).orElse(null);
  }


  public Tutor alterar(Long id, Tutor entity) {
    Optional<Tutor> existingAnimalOptional = repository.findById(id);
    if (existingAnimalOptional.isEmpty()){
      throw new NotFoundException("Tutor não encontrado");
    }

    Tutor existingTutor = existingAnimalOptional.get();
    modelMapper.map(entity, existingTutor);
    return repository.save(existingTutor);
  }


  public void remover(Long id) {
    repository.deleteById(id);
  }
}


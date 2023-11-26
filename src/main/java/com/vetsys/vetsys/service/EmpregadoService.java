package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.Empregado;
import com.vetsys.vetsys.model.QAnimal;
import com.vetsys.vetsys.model.QEmpregado;
import com.vetsys.vetsys.repository.EmpregadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmpregadoService {

  @Autowired
  private EmpregadoRepository repository;
  @Autowired
  private ModelMapper modelMapper;

  public Empregado salvar(Empregado entity) {
    if (!repository.findAll(QEmpregado.empregado.eq(entity.getCfmv())).isEmpty()){
      throw new ValidationException("Não existe uma observação cadastrada!");
    }
    return repository.save(entity);
  }


  public List<Empregado> buscaTodos() {
    return repository.findAll();
  }


  public Empregado buscaPorId(Long id) {
    return repository.findById(id).orElse(null);
  }


  public Empregado alterar(Long id, Empregado entity) {
    Optional<Empregado> existingEmpregadolOptional = repository.findById(id);
    if (existingEmpregadolOptional.isEmpty()){
      throw new NotFoundException("Animal não encontrado");
    }

    Empregado existingEmpregado = existingEmpregadolOptional.get();
    modelMapper.map(entity, existingEmpregado);
    return repository.save(existingEmpregado);
  }


  public void remover(Long id) {
    repository.deleteById(id);
  }
}

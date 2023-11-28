package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.Animal;
import com.vetsys.vetsys.model.QAnimal;
import com.vetsys.vetsys.model.Remedio;
import com.vetsys.vetsys.repository.MaterialRepository;
import com.vetsys.vetsys.repository.RemedioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class RemedioService {

    @Autowired
    private RemedioRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Remedio salvar(Remedio entity) {
        if (!repository.findAll(QRemedio.remedio.contraIndicacoes.eq(entity.getContraIndicacoes())).isEmpty()){
            throw new ValidationException("Não existe uma observação cadastrada!");
        }
        return repository.save(entity);
    }

    public List<Remedio> buscaTodos() {
        return repository.findAll();
    }

    public Remedio buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Remedio alterar(Long id, Remedio entity) {
        Optional<Remedio> eexistingRemedioOptional = repository.findById(id);
        if (eexistingRemedioOptional.isEmpty()){
            throw new NotFoundException("Remedio não encontrado");
        }

        Remedio existingRemedio = eexistingRemedioOptional.get();
        modelMapper.map(entity, existingRemedio);
        return repository.save(existingRemedio);
    }

}

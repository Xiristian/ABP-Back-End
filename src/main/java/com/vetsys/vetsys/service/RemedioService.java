package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.Produto;
import com.vetsys.vetsys.model.Remedio;
import com.vetsys.vetsys.repository.RemedioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RemedioService {

    @Autowired
    private RemedioRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Remedio salvar(Remedio entity) {
        return repository.save(entity);
    }

    public List<Remedio> buscaTodos(String filter) {
        return repository.findAll(filter, Remedio.class);
    }

    public Page<Remedio> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Remedio.class, pageable);
    }

    public Remedio buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Remedio alterar(Long id, Remedio entity) {
        Optional<Remedio> existingRemedioOptional = repository.findById(id);
        if (existingRemedioOptional.isEmpty()){
            throw new NotFoundException("Remédio não encontrado");
        }

        Remedio existingRemedio = existingRemedioOptional.get();
        modelMapper.map(entity, existingRemedio);
        return repository.save(existingRemedio);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

}

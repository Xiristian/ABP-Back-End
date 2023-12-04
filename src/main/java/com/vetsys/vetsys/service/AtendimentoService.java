package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.Atendimento;
import com.vetsys.vetsys.repository.AtendimentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Atendimento salvar(Atendimento entity) {
        return repository.save(entity);
    }

    public List<Atendimento> buscaTodos(String filter) {
        return repository.findAll(filter, Atendimento.class);
    }

    public Page<Atendimento> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Atendimento.class, pageable);
    }

    public Atendimento buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Atendimento alterar(Long id, Atendimento entity) {
        Optional<Atendimento> existingAtendimentoOptional = repository.findById(id);
        if (existingAtendimentoOptional.isEmpty()){
            throw new NotFoundException("Atendimento não encontrado");
        }

        Atendimento existingAtendimento = existingAtendimentoOptional.get();
        modelMapper.map(entity, existingAtendimento);
        return repository.save(existingAtendimento);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }
}

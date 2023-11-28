package com.vetsys.vetsys.service;
import com.vetsys.vetsys.model.Procedimento;
import com.vetsys.vetsys.model.QProcedimento;
import com.vetsys.vetsys.repository.ProcedimentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedimentoService {
    @Autowired
    private ProcedimentoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Procedimento salvar(Procedimento entity) {
        if (!repository.findAll(QProcedimento.procedimento.descricao.eq(entity.getDescricao())).isEmpty()){
            throw new ValidationException("Já existe um procedimento com essa descrição cadastrada!");
        }
        return repository.save(entity);
    }

    public List<Procedimento> buscaTodos(String filter) {
        return repository.findAll(filter, Procedimento.class);
    }

    public Page<Procedimento> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Procedimento.class, pageable);
    }

    public Procedimento buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Procedimento alterar(Long id, Procedimento entity) {
        Optional<Procedimento> existingProcedimentoOptional = repository.findById(id);
        if (existingProcedimentoOptional.isEmpty()){
            throw new NotFoundException("Procedimento não encontrado");
        }

        Procedimento existingProcedimento = existingProcedimentoOptional.get();
        modelMapper.map(entity, existingProcedimento);
        return repository.save(existingProcedimento);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}


 
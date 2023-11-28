package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.Internacao;
import com.vetsys.vetsys.model.QInternacao;
import com.vetsys.vetsys.repository.InternacaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InternacaoService {
    @Autowired
    private InternacaoRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    public Internacao salvar(Internacao entity) {
        if (!repository.findAll(QInternacao.internacao.descricao.eq(entity.getDescricao())).isEmpty()){
            throw new ValidationException("Já existe um internação com essa descrição cadastrada!");
        }
        return repository.save(entity);
    }


    public List<Internacao> buscaTodos() {
        return repository.findAll();
    }

    public List<Internacao> buscaTodos(String filter) {
        return repository.findAll(filter, Internacao.class);
    }

    public Page<Internacao> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Internacao.class, pageable);
    }

    public Internacao buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Internacao alterar(Long id, Internacao entity) {
        Optional<Internacao> existingInternacaoOptional = repository.findById(id);
        if (existingInternacaoOptional.isEmpty()){
            throw new NotFoundException("Internacao não encontrado");
        }

        Internacao existingInternacao = existingInternacaoOptional.get();
        modelMapper.map(entity, existingInternacao);
        return repository.save(existingInternacao);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }
}

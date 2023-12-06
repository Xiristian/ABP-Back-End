package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.*;
import com.vetsys.vetsys.repository.AtendimentoRepository;
import com.vetsys.vetsys.repository.MaterialRepository;
import com.vetsys.vetsys.repository.ProdutoRepository;
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
    private ProdutoRepository produtoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Atendimento salvar(Atendimento entity) {
        validaProdutos(entity);
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
        validaProdutos(entity);
        Atendimento existingAtendimento = existingAtendimentoOptional.get();
        modelMapper.map(entity, existingAtendimento);
        existingAtendimento.setId(id);
        existingAtendimento.setDataAtendimento(entity.getDataAtendimento());
        existingAtendimento.setAnimal(entity.getAnimal());
        existingAtendimento.setTutor(entity.getTutor());
        existingAtendimento.setEmpregado(entity.getEmpregado());
        existingAtendimento.setHouveInternacao(entity.getHouveInternacao());
        existingAtendimento.setValorTotal(entity.getValorTotal());
        return repository.save(existingAtendimento);
    }

    private void validaProdutos(Atendimento entity) {
        boolean existemInternacoes = false;

        for (int i = 0; i < entity.getProdutoAtendimento().size(); i++) {
            Produto produto = produtoRepository.findById(entity.getProdutoAtendimento().get(i).getProduto().getId()).orElse(null);

            if (entity.getProdutoAtendimento().get(i) instanceof InternacaoAtendimento && !(produto instanceof Internacao)) {
                throw new ValidationException("Produto não é uma internação");

            } else if (entity.getProdutoAtendimento().get(i) instanceof ProcedimentoAtendimento && !(produto instanceof Procedimento)) {
                throw new ValidationException("Produto não é um procedimento");

            } else if (entity.getProdutoAtendimento().get(i) instanceof ProdutoQuantitavelAtendimento) {
                if (!(produto instanceof Remedio) && !(produto instanceof Material)) {
                    throw new ValidationException("Produto não é um remédio ou material");
                }
            }
            if (entity.getProdutoAtendimento().get(i) instanceof InternacaoAtendimento) {
                existemInternacoes = true;
            }
        }
        if (entity.getHouveInternacao() != existemInternacoes) {
            throw new ValidationException("O campo 'Houve internação' o e os registros de 'Internação' diferem no sistema!");
        }
    }
    public void remover(Long id) {
        repository.deleteById(id);
    }
}

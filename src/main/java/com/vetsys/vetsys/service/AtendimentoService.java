package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.*;
import com.vetsys.vetsys.repository.AnimalRepository;
import com.vetsys.vetsys.repository.AtendimentoRepository;
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
    private AnimalRepository animalRepository;
    @Autowired
    private ModelMapper modelMapper;

    public Atendimento salvar(Atendimento entity) {
        validaEntidades(entity);
        validaProdutos(entity);
        validaTutorAnimal(entity);
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
        validaEntidades(entity);
        validaProdutos(entity);
        validaTutorAnimal(entity);
        Optional<Atendimento> existingAtendimentoOptional = repository.findById(id);
        if (existingAtendimentoOptional.isEmpty()) {
            throw new NotFoundException("Atendimento não encontrado");
        }
        Atendimento existingAtendimento = existingAtendimentoOptional.get();
        modelMapper.map(entity, existingAtendimento);
        existingAtendimento.setId(id);
        existingAtendimento.setDataAtendimento(entity.getDataAtendimento());
        existingAtendimento.setAnimal(entity.getAnimal());
        existingAtendimento.setTutor(entity.getTutor());
        existingAtendimento.setEmpregado(entity.getEmpregado());
        existingAtendimento.setHouveInternacao(entity.getHouveInternacao());
        existingAtendimento.setValorTotal(entity.getValorTotal());
        existingAtendimento.setProdutoAtendimento(entity.getProdutoAtendimento());
        return repository.save(existingAtendimento);
    }

    private void validaProdutos(Atendimento entity) {
        boolean existemInternacoes = false;
        Double valorTotal = 0.0;

        for (int i = 0; i < entity.getProdutoAtendimento().size(); i++) {
            Produto produto = produtoRepository.findById(entity.getProdutoAtendimento().get(i).getProduto().getId())
                    .orElse(null);

            if (entity.getProdutoAtendimento().get(i) instanceof InternacaoAtendimento) {
                if (!(produto instanceof Internacao)) {
                    throw new ValidationException("Produto não é uma internação");
                }
                if (((InternacaoAtendimento) entity.getProdutoAtendimento().get(i)).getQuantidadeDias() <= 0) {
                    throw new ValidationException("Data de liberação deve ser maior que a data de internação");
                }
                if (((InternacaoAtendimento) entity.getProdutoAtendimento().get(i)).getValorTotal() <= 0) {
                    throw new ValidationException("Valor total do produto deve ser maior que zero");
                }
                valorTotal += ((InternacaoAtendimento) entity.getProdutoAtendimento().get(i)).getValorTotal();
            } else if (entity.getProdutoAtendimento().get(i) instanceof ProcedimentoAtendimento) {
                if (!(produto instanceof Procedimento)) {
                    throw new ValidationException("Produto não é um procedimento");
                }
                if (((ProcedimentoAtendimento) entity.getProdutoAtendimento().get(i)).getValorTotal() <= 0) {
                    throw new ValidationException("Valor total do produto deve ser maior que zero");
                }
                valorTotal += ((ProcedimentoAtendimento) entity.getProdutoAtendimento().get(i)).getValorTotal();
            } else if (entity.getProdutoAtendimento().get(i) instanceof ProdutoQuantitavelAtendimento) {
                if (!(produto instanceof Remedio) && !(produto instanceof Material)) {
                    throw new ValidationException("Produto não é um remédio ou material");
                }
                if (((ProdutoQuantitavelAtendimento) entity.getProdutoAtendimento().get(i)).getQuantidade() <= 0) {
                    throw new ValidationException("Quantidade do produto deve ser maior que zero");
                }
                if (((ProdutoQuantitavelAtendimento) entity.getProdutoAtendimento().get(i)).getValorTotal() <= 0) {
                    throw new ValidationException("Valor total do produto deve ser maior que zero");
                }
                valorTotal += ((ProdutoQuantitavelAtendimento) entity.getProdutoAtendimento().get(i)).getValorTotal();
            } else {
                throw new ValidationException("Produto não é um remédio, material, procedimento ou internação");
            }
            if (entity.getProdutoAtendimento().get(i) instanceof InternacaoAtendimento) {
                existemInternacoes = true;
            }
            if (produto.getValor() > entity.getProdutoAtendimento().get(i).getValor()) {
                throw new ValidationException(
                        "Valor do produto do atendimento não pode ser menor que o valor do produto cadastrado");
            }
            entity.getProdutoAtendimento().get(i).setAtendimento(entity);
        }
        if (entity.getHouveInternacao() != existemInternacoes) {
            throw new ValidationException(
                    "O campo 'Houve internação' o e os registros de 'Internação' diferem no sistema!");
        }
        entity.setValorTotal(valorTotal);
    }

    private void validaTutorAnimal(Atendimento entity) {
        Animal animal = animalRepository.findById(entity.getAnimal().getId()).orElse(null);
        if (animal.getTutor().getId() != entity.getTutor().getId()) {
            throw new ValidationException("O tutor do animal não é o mesmo do atendimento!");
        }
    }

    private void validaEntidades(Atendimento entity) {
        if (entity.getAnimal().getId() != null && entity.getAnimal().getId() <= 0) {
            throw new ValidationException("Animal não informado");
        }
        if (entity.getTutor().getId() != null && entity.getTutor().getId() <= 0) {
            throw new ValidationException("Tutor não informado");
        }
        if (entity.getEmpregado().getId() != null && entity.getEmpregado().getId() <= 0) {
            throw new ValidationException("Empregado não informado");
        }
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}

/*
 * Regras de negócio
 * - O valor total do atendimento deve ser a soma dos valores totais dos
 * produtos
 * - O valor total de um produto deve ser a multiplicação da quantidade pelo
 * valor unitário menos o desconto
 * - Os campos referentes a quantidade e valor unitário devem ser maiores que
 * zero
 * - O tutor do animal deve ser o mesmo do atendimento
 * - Caso o campo 'Houve internação' seja marcado, deve haver pelo menos um
 * produto do tipo 'Internação'
 * - Caso o campo 'Houve internação' não seja marcado, não deve haver nenhum
 * produto do tipo 'Internação'
 * - No cadastro de pessoa o CPF e o CFMV devem ser únicos
 * - No cadastro de pessoa o email deve ser válido
 * - Cada atendimento deve estar associado a um empregado, um animal e um tutor
 * - A data de internação deve ser menor que a data de liberação
 * - A quantidade de dias de internação deve ser a diferença entre a data de
 * liberação e a data de internação
 * - O tipo de produto informado no atendimento deve ser o mesmo do cadastro do
 * produto
 * - A descrição do produto deve ser única
 * - O valor do produto do atendimento não pode ser menor que o valor do produto
 * cadastrado
 */
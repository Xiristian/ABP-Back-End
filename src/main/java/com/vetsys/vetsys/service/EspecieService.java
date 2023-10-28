package com.vetsys.vetsys.service;

import com.vetsys.vetsys.model.Especie;
import com.vetsys.vetsys.model.QEspecie;
import com.vetsys.vetsys.repository.EspecieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EspecieService {


    @Autowired
    private EspecieRepository repository;

    @Autowired
    private ModelMapper modelMapper;


    public Especie salvar(Especie entity) {
        if (!repository.findAll(QEspecie.especie.descricao.eq(entity.getDescricao())).isEmpty()){
            throw new ValidationException("Já existe uma espécie com essa descrição cadastrada!");
        }
        return repository.save(entity);
    }


    public List<Especie> buscaTodos() {
        return repository.findAll();
    }


    public Especie buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }


    public Especie alterar(Long id, Especie entity) {
        Optional<Especie> existingProduoOptional = repository.findById(id);
        if (existingProduoOptional.isEmpty()){
            throw new NotFoundException("Espécie não encontrado");
        }

        Especie existingEspecie = existingProduoOptional.get();
        modelMapper.map(entity, existingEspecie);
        return repository.save(existingEspecie);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }
}
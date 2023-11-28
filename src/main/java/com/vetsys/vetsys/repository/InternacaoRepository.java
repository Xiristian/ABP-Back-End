package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternacaoRepository extends JpaRepository<Internacao, Long>, CustomQuerydslPredicateExecutor<Internacao>{
}

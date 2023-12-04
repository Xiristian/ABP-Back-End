package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>, CustomQuerydslPredicateExecutor<Atendimento> {
}
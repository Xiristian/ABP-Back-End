package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Procedimento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long>, CustomQuerydslPredicateExecutor<Procedimento>{
}

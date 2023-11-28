package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long>,CustomQuerydslPredicateExecutor<Empregado> {
}


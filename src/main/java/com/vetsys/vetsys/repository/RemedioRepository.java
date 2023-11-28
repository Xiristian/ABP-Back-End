package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long>,CustomQuerydslPredicateExecutor<Remedio>{
}

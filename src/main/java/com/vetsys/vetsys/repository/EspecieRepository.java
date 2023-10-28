package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Long>, CustomQuerydslPredicateExecutor<Especie>  {
}

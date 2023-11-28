package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.ProdutoQuantitavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoQuantitavelRepository extends JpaRepository<ProdutoQuantitavel, Long>, CustomQuerydslPredicateExecutor<ProdutoQuantitavel>{
}

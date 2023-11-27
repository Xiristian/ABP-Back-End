package com.vetsys.vetsys.repository;
import com.vetsys.vetsys.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>, CustomQuerydslPredicateExecutor<Pessoa> {
}

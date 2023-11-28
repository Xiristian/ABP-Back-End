package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long>, CustomQuerydslPredicateExecutor<Animal> {
}

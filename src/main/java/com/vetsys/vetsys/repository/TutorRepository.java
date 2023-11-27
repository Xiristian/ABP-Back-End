package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Long>, CustomQuerydslPredicateExecutor<Tutor>{

}

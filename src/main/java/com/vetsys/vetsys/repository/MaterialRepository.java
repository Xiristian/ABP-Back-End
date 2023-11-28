package com.vetsys.vetsys.repository;

import com.vetsys.vetsys.model.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long>, CustomQuerydslPredicateExecutor<Material> {
}
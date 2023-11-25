package com.vetsys.vetsys.service;

import com.vetsys.vetsys.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnimalService {
  private  AnimalRepository animalRepository;

  @Autowired
  public AnimalService(AnimalRepository animalRepository) {

    this.animalRepository = animalRepository;
  }

}

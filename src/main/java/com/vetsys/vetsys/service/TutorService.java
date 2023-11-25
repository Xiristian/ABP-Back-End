package com.vetsys.vetsys.service;

import com.vetsys.vetsys.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TutorService {

  private TutorRepository tutorRepository;

  @Autowired
  public TutorService(TutorRepository tutorRepository) {
    this.tutorRepository = tutorRepository;
  }



}

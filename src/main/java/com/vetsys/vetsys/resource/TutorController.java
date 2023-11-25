package com.vetsys.vetsys.resource;

import com.vetsys.vetsys.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tutores")
public class TutorController {
  private final TutorService tutorService;

  @Autowired
  public TutorController(TutorService tutorService) {

    this.tutorService = tutorService;
  }

}

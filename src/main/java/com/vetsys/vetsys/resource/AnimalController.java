package com.vetsys.vetsys.resource;
import com.vetsys.vetsys.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/animais")
public class AnimalController {

  private  AnimalService animalService;
  @Autowired
  public AnimalController(AnimalService animalService) {
    this.animalService = animalService;
  }

}

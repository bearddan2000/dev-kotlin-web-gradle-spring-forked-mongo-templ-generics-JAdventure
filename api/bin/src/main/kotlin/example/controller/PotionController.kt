package example.controller;

import example.model.Potion;
import example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ragcrix
 */
@RestController
@RequestMapping("/potions")
class PotionController {

  @Autowired
  lateinit var itemService: GenericService<Potion>

  @GetMapping("/name/{value}")
  fun getByName(@PathVariable("value") value: String): String = itemService.findByField(Potion::class.java, "name", value).toString()

  @GetMapping("/")
  fun getAll(): String = itemService.findAll(Potion::class.java).joinToString { it -> it.toString() }
}

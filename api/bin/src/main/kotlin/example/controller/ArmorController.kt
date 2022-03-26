package example.controller;

import example.model.Armor;
import example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ragcrix
 */
@RestController
@RequestMapping("/armors")
class ArmorController {

  @Autowired
  lateinit var itemService: GenericService<Armor>

  @GetMapping("/name/{value}")
  fun getByName(@PathVariable("value") value: String): String = itemService.findByField(Armor::class.java, "name", value).toString()

  @GetMapping("/")
  fun getAll(): String = itemService.findAll(Armor::class.java).joinToString { it -> it.toString() }
}

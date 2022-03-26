package example.controller;

import example.model.Weapon;
import example.service.GenericService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ragcrix
 */
@RestController
@RequestMapping("/weapons")
class WeaponController {

  @Autowired
  lateinit var itemService: GenericService<Weapon>

  @GetMapping("/name/{value}")
  fun getByName(@PathVariable("value") value: String): String = itemService.findByField(Weapon::class.java, "name", value).toString()

  @GetMapping("/")
  fun getAll(): String = itemService.findAll(Weapon::class.java).joinToString { it -> it.toString() }
}

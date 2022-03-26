package example.controller;

import example.model.Food;
import example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ragcrix
 */
@RestController
@RequestMapping("/foods")
class FoodController {

  @Autowired
  lateinit var itemService: GenericService<Food>

  @GetMapping("/name/{value}")
  fun getByName(@PathVariable("value") value: String): String = itemService.findByField(Food::class.java, "name", value).toString()

  @GetMapping("/")
  fun getAll(): String = itemService.findAll(Food::class.java).joinToString { it -> it.toString() }
}

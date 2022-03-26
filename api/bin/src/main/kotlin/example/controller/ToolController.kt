package example.controller;

import example.model.Tool;
import example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ragcrix
 */
@RestController
@RequestMapping("/tools")
class ToolController {

  @Autowired
  lateinit var itemService: GenericService<Tool>

  @GetMapping("/name/{value}")
  fun getByName(@PathVariable("value") value: String): String = itemService.findByField(Tool::class.java, "name", value).toString()

  @GetMapping("/")
  fun getAll(): String = itemService.findAll(Tool::class.java).joinToString { it -> it.toString() }
}

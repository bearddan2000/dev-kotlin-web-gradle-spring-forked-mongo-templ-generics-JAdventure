package example.controller;

import example.model.Location;
import example.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author ragcrix
 */
@RestController
@RequestMapping("/locations")
class LocationController {

  @Autowired
  lateinit var itemService: GenericService<Location>

  @GetMapping("/coor/{value}")
  fun getByCoor(@PathVariable("value") value: String): String = itemService.findByField(Location::class.java, "coordinate", value).toString()

  @GetMapping("/")
  fun getAll(): String = itemService.findAll(Location::class.java).joinToString { it -> it.toString() }
}

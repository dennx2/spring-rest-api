package com.humber.j2ee.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.humber.j2ee.model.Dish;
import com.humber.j2ee.service.DishService;

@RestController
@RequestMapping("/api")
public class HomeController {
	
	@Autowired
	private DishService dishService;
	
	@GetMapping("/dishes")
	public List<Dish> getAllDishes() {
		return dishService.getAllDishes();
	}
	
	@GetMapping("/dish/{id}")
	public Optional<Dish> getDishById(@PathVariable int id) {
		return dishService.getDishById(id);
	}
	
//	@PostMapping("/dish")
//	public void addDish(@RequestBody Dish dish) {
//		dishService.addDish(dish);
//		
//	}
	
	@PostMapping("/dish")
	public ResponseEntity addDish(@RequestBody Dish dish) {
		
		try {
			dishService.addDish(dish);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	
	
	@PutMapping("/dish")
	public ResponseEntity updateDish(@RequestBody Dish dish) {
		
		try {
			dishService.updateDish(dish);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();		
	}
	
	
	
	@DeleteMapping("/dish/{id}")
	public ResponseEntity deleteDish(@PathVariable int id) {
		try {
			dishService.deleteDish(id);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}

		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	
	
	
	
	
	

}

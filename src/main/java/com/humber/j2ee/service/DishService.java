package com.humber.j2ee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.humber.j2ee.data.DishDB;
import com.humber.j2ee.model.Dish;

@Service
public class DishService {

	public List<Dish> getAllDishes() {
		return DishDB.dishes;
	}

	public Optional<Dish> getDishById(int id) {
		// another way to write the same thing, but less efficient
//		DishDB.dishes.stream().filter(a -> a.getId() == id).collect(Collectors.toList()).get(0);	

		// if you return with Optional<> then you don't need .get() as .findFirst() returns Optional<>
//		return DishDB.dishes.stream().filter(a -> a.getId() == id).findFirst().get();
		return DishDB.dishes.stream().filter(a -> a.getId() == id).findFirst();

	}

	
	// add a dish with a dish object
	public void addDish(Dish dish) throws Exception {
		boolean isExists = DishDB.dishes.stream().anyMatch(a -> a.getId() == dish.getId());
		if (isExists)
			throw new Exception("A dish with this ID already exists.");

		DishDB.dishes.add(dish);

	}
	
	// update dish with a dish object	
	public void updateDish(Dish dish) throws Exception {
		boolean isExists = DishDB.dishes.stream().anyMatch(a -> a.getId() == dish.getId());
		if (!isExists)
			throw new Exception("A dish with this ID does not exist.");
		
		Dish currentDish =  DishDB.dishes.stream().filter(a -> a.getId() == dish.getId()).findFirst().get();
		currentDish.setName(dish.getName());
		currentDish.setPrice(dish.getPrice());
		currentDish.setCategory(dish.getCategory());
		currentDish.setCusine(dish.getCusine());
		currentDish.setDescription(dish.getDescription());
		
	}
	
	
	// delete a dish by id
	public void deleteDish(int id) throws Exception {
		boolean isExists = DishDB.dishes.stream().anyMatch(a -> a.getId() == id);
		if (!isExists)
			throw new Exception("A dish with this ID does not exist.");
		
		Dish dish = DishDB.dishes.stream().filter(a -> a.getId() == id).findFirst().get();
		DishDB.dishes.remove(dish);

	}

}

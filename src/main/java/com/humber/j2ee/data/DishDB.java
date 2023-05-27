package com.humber.j2ee.data;

import java.util.ArrayList;
import java.util.List;

import com.humber.j2ee.model.Dish;

public class DishDB {

	public static List<Dish> dishes = new ArrayList<>();
		
	// you want the code below to run but there is no MAIN method. use static.
	static {
		dishes.add(new Dish(1, "Pizza", 12, "Veg", "Italian", ""));
		dishes.add(new Dish(2, "Dhokla", 5, "Veg", "Gujrati", ""));
		dishes.add(new Dish(3, "Noodles", 13, "Chicken", "Chinese", ""));
		dishes.add(new Dish(4, "Chole Bhature", 15, "Veg", "North Indian", ""));
	}
}

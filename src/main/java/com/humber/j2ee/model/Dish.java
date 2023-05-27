package com.humber.j2ee.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish implements Serializable {

	private int id;
	private String name;
	private double price;
	private String category;
	private String cusine;
	private String description;
	
}

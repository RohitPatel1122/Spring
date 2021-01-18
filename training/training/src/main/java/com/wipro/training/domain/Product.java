package com.wipro.training.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	int id;
	String name;
	
	String madeIn;
	float price;
	public Product(String name, String madeIn, float price) {
		super();
		this.name = name;
		this.madeIn = madeIn;
		this.price = price;
	}
	
	
}

package com.careercamp.service;

import java.util.Comparator;

import com.careercamp.dto.Product;

public class PriceSorter implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		return (int) (p1.getPrice() - p2.getPrice());
	}

}

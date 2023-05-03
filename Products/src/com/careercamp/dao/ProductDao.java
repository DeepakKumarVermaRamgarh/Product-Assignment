package com.careercamp.dao;

import java.util.List;

import com.careercamp.dto.Product;
import com.careercamp.service.ProductNotFoundException;

public interface ProductDao {
	boolean addProduct(Product product);
	List<Product> getAllProducts();
	boolean deleteProductById(int prodId) throws ProductNotFoundException;
//	boolean updateProduct(Product prodId) throws ProductNotFoundException;
	Product getProductById(int prodId) throws ProductNotFoundException;
	Product getProductByName(String prodName) throws ProductNotFoundException;
	List<Product> getProductsByPriceOrder(boolean ascending);
	List<Product> getProductByDiscountOrder(boolean ascending);
	boolean updateProduct(int prodId, Product p) throws ProductNotFoundException;
}

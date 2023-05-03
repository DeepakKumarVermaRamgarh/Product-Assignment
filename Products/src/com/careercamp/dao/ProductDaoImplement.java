package com.careercamp.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.careercamp.dto.Product;
import com.careercamp.service.ProductNotFoundException;

public class ProductDaoImplement implements ProductDao {

	private static List<Product> products;

	static {
		products = new ArrayList<>();
	}

	@Override
	public boolean addProduct(Product product) {
		return products.add(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return products;
	}

	@Override
	public boolean deleteProductById(int prodId) throws ProductNotFoundException {
		for (Product product : products) {
			if (product.getProdId() == prodId) {
				products.remove(product);
				return true;
			}
		}
		throw new ProductNotFoundException("Product with prodId " + prodId + " not found.");
	}

	@Override
	public boolean updateProduct(int prodId, Product p) throws ProductNotFoundException {
		Product product = getProductById(prodId);
		product.setProdName(p.getProdName());
		product.setPrice(p.getPrice());
		product.setQuantity(p.getQuantity());
		product.setDiscount(p.getDiscount());
		return true;
	}

	@Override
	public Product getProductById(int prodId) throws ProductNotFoundException {
		for (Product product : products) {
			if (product.getProdId() == prodId) {
				return product;
			}
		}
		throw new ProductNotFoundException("Product with prodId " + prodId + " not found.");
	}

	@Override
	public Product getProductByName(String prodName) throws ProductNotFoundException {
		for(Product product:products) {
			if(product.getProdName() == prodName) return product;
		}
		throw new ProductNotFoundException("Product with name " + prodName + " not found.");
	}

	@Override
	public List<Product> getProductsByPriceOrder(boolean ascending) {
		if(ascending == true) {
			Collections.sort(products, new Comparator<Product>() {
				public int compare(Product p1, Product p2) {
					return Double.compare(p1.getPrice(), p2.getPrice());
				}
			} );
		}else {
			Collections.sort(products, new Comparator<Product>() {
				public int compare(Product p1, Product p2) {
					return Double.compare(p2.getPrice(), p1.getPrice());
				}
			} );
		}
		return products;
	}

	@Override
	public List<Product> getProductByDiscountOrder(boolean ascending) {
		if(ascending == true) {
			Collections.sort(products, new Comparator<Product>() {
				public int compare(Product p1, Product p2) {
					return Double.compare(p1.getDiscount(), p2.getDiscount());
				}
			} );
		}else {
			Collections.sort(products, new Comparator<Product>() {
				public int compare(Product p1, Product p2) {
					return Double.compare(p2.getDiscount(), p1.getDiscount());
				}
			} );
		}
		return products;
	}

}











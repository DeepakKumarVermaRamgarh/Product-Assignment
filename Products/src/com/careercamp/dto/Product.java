package com.careercamp.dto;


public class Product {
	private int prodId;
	private String prodName;
	private double price;
	private int quantity;
	private double discount;
	private static int count = 0;

	public Product(String prodName, double price, int quantity, double discount) {
		Product.count++;
		this.prodId = Product.count;
		this.setProdName(prodName);
		this.setPrice(price);
		this.setQuantity(quantity);
		this.setDiscount(discount);
	}

	public int getProdId() {
		return prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", price=" + price + ", quantity=" + quantity
				+ ", discount=" + discount + "]";
	}
	
	public void printProduct() {
		System.out.println("Product with ID " + this.prodId + " found: " + this.getProdName() + " " + this.getPrice() + " " + this.getDiscount()+" ");
	}

}

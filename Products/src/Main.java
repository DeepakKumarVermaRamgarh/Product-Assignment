import java.util.List;
import java.util.Scanner;

import com.careercamp.dao.ProductDao;
import com.careercamp.dao.ProductDaoImplement;
import com.careercamp.dto.Product;
import com.careercamp.service.InputHelper;
import com.careercamp.service.ProductNotFoundException;

public class Main {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDao productDao = new ProductDaoImplement();

        while (true) {
            System.out.println("Enter operation number:\n"
            		+ "1. Add product\n"
            		+ "2. Display all products\n"
            		+ "3. Delete product by ID\n"
            		+ "4. Update product\n"
            		+ "5. Search product by ID\n"
            		+ "6. Search product by name\n"
            		+ "7. Display all products by price\n"
            		+ "8. Display all products by discount\n"
            		+ "9. Exit");
            
            
//            try {
//                choice = scanner.nextInt();
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid Input. Please enter an integer value.");
//                scanner.next();
//                continue;
//            }     
            
            int choice = InputHelper.takeValidInput("choice", Integer.class, scanner);
            
			switch (choice) {
                case 1:
                    System.out.println("Enter product details:");
                    System.out.print("Name: ");
                    scanner.nextLine();
//                    String name = scanner.nextLine();
                    String name = InputHelper.takeValidInput("Name", String.class, scanner);
                    System.out.print("Price: ");
//                    double price = scanner.nextDouble();
                    double price = InputHelper.takeValidInput("Price", Double.class, scanner);
                    System.out.print("Quantity: ");
//                    int quantity = scanner.nextInt();
                    int quantity = InputHelper.takeValidInput("Quantity", Integer.class, scanner);
                    System.out.print("Discount: ");
//                    double discount = scanner.nextDouble();
                    double discount = InputHelper.takeValidInput("Discount", Double.class, scanner);;
                    
                    productDao.addProduct(new Product(name, price, quantity, discount));
                    System.out.println("Product added successfully");
                    break;

                case 2:
                    System.out.println("All products:");
                    List<Product> productList = productDao.getAllProducts();
                    for (Product product : productList) {
                        System.out.println(product.getProdId() + " " + product.getProdName() + " " + product.getPrice() + " " + product.getQuantity() + " " + product.getDiscount());
                    }
                    break;

                case 3:
                    System.out.print("Enter product ID to delete: ");
//                    int deleteId = scanner.nextInt();
                    int deleteId = InputHelper.takeValidInput("Product ID", Integer.class, scanner);
                    try {
                        productDao.deleteProductById(deleteId);
                        System.out.println("Product with ID " + deleteId + " deleted successfully");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter product ID to update: ");
//                    int updateId = scanner.nextInt();
                    int updateId = InputHelper.takeValidInput("Product ID", Integer.class, scanner);
                    try {
                        Product productToUpdate = productDao.getProductById(updateId);
                        System.out.print("Enter new name (leave blank to skip): ");
                        scanner.nextLine();
//                        String newName = scanner.nextLine();
                        String newName = InputHelper.takeValidInput("New Name", String.class, scanner);
                        if (!newName.isBlank()) {
                            productToUpdate.setProdName(newName);
                        }
                        System.out.print("Enter new price (leave 0 to skip): ");
//                        double newPrice = scanner.nextDouble();
                        double newPrice = InputHelper.takeValidInput("New Price", Double.class, scanner);
                        if (newPrice != 0) {
                            productToUpdate.setPrice(newPrice);
                        }
                        System.out.print("Enter new quantity (leave 0 to skip): ");
//                        int newQuantity = scanner.nextInt();
                        int newQuantity = InputHelper.takeValidInput("New Quantity", Integer.class, scanner);
                        if (newQuantity != 0) {
                            productToUpdate.setQuantity(newQuantity);
                        }
                        System.out.print("Enter new discount (leave 0 to skip): ");
//                        double newDiscount = scanner.nextDouble();
                        double newDiscount  = InputHelper.takeValidInput("New Discount", Double.class, scanner);
                        if (newDiscount != 0) {
                            productToUpdate.setDiscount(newDiscount);
                        }
                        productDao.updateProduct(updateId, productToUpdate);
                        System.out.println("Product with ID " + updateId + " updated successfully");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter product ID to search: ");
//                    int searchId = scanner.nextInt();
                    int searchId = InputHelper.takeValidInput("Product ID", Integer.class, scanner);
                    try {
                        Product productById = productDao.getProductById(searchId);
                        System.out.println("Product with ID " + searchId + " found: " + productById.getProdName() + " " + productById.getPrice() + " " + productById.getDiscount()+" ");
                    }catch (Exception e) {
                    	 System.out.println(e.getMessage());
					}
                    break;
                    
                case 6:
                	System.out.println("Enter product name to search: ");
//                	String pname = scanner.nextLine();
                	String pname = InputHelper.takeValidInput("Product Name", String.class, scanner);
                	try {
                		Product p = productDao.getProductByName(pname);
                		System.out.println("Product with Name " + pname + " found: " + p.getProdName() + " " + p.getPrice() + " " + p.getDiscount()+" ");
                	}catch (Exception e) {
						System.out.println(e.getMessage());
					}
                	break;
                	
                case 7:
                	List<Product> products = productDao.getProductsByPriceOrder(true);
                	for(Product p:products) {
                		p.printProduct();
                	}
                	break;
                
                case 8:
                	List<Product> prod = productDao.getProductByDiscountOrder(true);
                	for(Product p:prod) {
                		p.printProduct();
                	}
                	break;
                case 9:
                	System.exit(0);
                	break;
                	
                default:
                	System.out.println("Invalid Input.");
            }
        }
	}
}
                	
                	
                	
                	
                	
                	
                	
                	
                	
                	

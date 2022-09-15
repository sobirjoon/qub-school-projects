package part03;
import java.awt.Color;
import java.awt.Font;
import console.Console;
import part01.Department;
import part01.Menu;
import part01.Product;

import java.util.ArrayList;
import java.util.InputMismatchException;

import javax.swing.ImageIcon;

public class WarehouseApp {

	static String title;
	 
	static Warehouse data = new Warehouse("Sobirjon Ergashev"); 
	static String options[] = {
			  "Add new product", 
			  "Delete a product", 
			  "List products for Department",
			  "List all products" , 
			  "Add Stock for a Product", 
			  "Sales Report",
			  "Record Purchase", 
			  "Exit" }; 
	 
	static ConsoleMenu console; 

	public static void main(String[] args) {

		// creates new console GUI window 
		title = "WAREHOUSE APP";
		console = new ConsoleMenu(title, options, true);
		console.setSize(800, 600);
		console.setVisible(true); 
		console.setBgColour(Color.WHITE); 
		console.setFont(new Font("Courier", Font.BOLD, 20)); 
		console.setColour(Color.BLACK);
		//SHOWS owner name of warehouse
		String owner = "Warehouse owner: ";
		console.println(owner + data.getName() + "\n");
		
		boolean finished = false;
		do {
			console.display();
			int choice = console.getUserChoice();
			processChoice(choice); 

		} while (!finished);
		console.clear();
	}

	private static void processChoice(int choice) {
		switch (choice) {
		case 1:
			addNewProduct();
			break;
		case 2:
			deleteProduct();
			break;
		case 3:
			listProductsDept();
			break;
		case 4:
			listAllProducts();
			break;
		case 5:
			addStockProducts();
			break;
		case 6:
			reportSales();
			break;
		case 7:
			recordPurchase();
			break;
		default:
			console.println("Option " + choice + " is invalid");
		}
		console.println("");
	}	
	
	/**
	 * it adds new product to warehouse
	 * asks manufacturer, model, price, Department, and quantity
	 */
	private static void addNewProduct() {
		String intro = " -->  Add New Product";
		console.println(title + intro);
		display((title + intro).length()); 

		String make = "";
		do {
			console.print("#-- Manufacturer : ");
			make = console.readLn();
			make = make.trim();

			if (make.isEmpty()) {
				console.println("**Please enter a valid manufacturer names String input**");
			}

		} while (make.trim().isEmpty());

		String model = "";
		do {
			console.print("#-- Model : ");
			model = console.readLn();
			model = model.trim();

			if (model.isEmpty()) {
				console.println("**Please enter a valid Model Name input**");
			}
		} while (model.trim().isEmpty());

		double price = 0;
		boolean validInputDb = false;
		do {
			console.print("#-- Price £ : ");
			try {
				String input = console.readLn();
				input.trim().isEmpty();
				price = Double.parseDouble(input);
				validInputDb = true;
			} catch (NumberFormatException  e) {
				console.println("Please enter valid price for the product.");
				console.println("");
			}
		} while (!validInputDb);

		console.print("#-- Department : ");
		Department department = getDepartment();

		int quantity = 0;
		boolean validInputInt = false;
		do {

			String str = "\nIf you want to skip, enter 0.";
			console.println(str);
			console.print("#-- Quantity £ : ");
			try {
				String input = console.readLn();
				input.trim().isEmpty();
				quantity = Integer.parseInt(input);
				validInputInt = true;
			} catch (NumberFormatException  e) {
				console.println("Please enter valid amount of quantity of the product.");
				console.readLn();
			}
		} while (!validInputInt);

		String description = "";
		do {
			console.print("#-- Description : ");
			description = console.readLn();
			description = description.trim();

			if (description.isEmpty()) {
				console.println("**Please enter a valid Model Name input**");
			}
		} while (description.trim().isEmpty());
		
		
		if (data.search(make, model) != null) {
			String str = "This product has been added before. Please double check!\n";
			console.println("\nOops! " + str);
		} else if (data.addProduct(make, model, price, department, quantity, description) != null) {
			String str = "\nCongrats!" + " ";
			console.print(str + "You have successfully added a new product.\n");
		} else {
			console.println("\nOops! Check it again!\n");
		}
	}
	
	/**
	 * it deletes product in warehouse via using product code
	 */
	private static void deleteProduct() {
		String intro = "--> Delete Product";
		console.println(title + intro);
		display((title + intro).length());

		console.print("Enter Code:");
		String code = console.readLn();
		code = code.trim();
		data.deleteProduct(code);
		console.println("");
	}
	
	/**
	 * it shows you specific departments to get products of each department
	 */
	private static void listProductsDept() {
		String intro = " -> List all products by Department";
		console.println(title + intro);
		display((title + intro).length());
		Department department = getDepartment();
		ArrayList<ProductDetail> products = data.search(department);
		
		if (products.size() == 0) {
			console.println("No products available. Please Add Products.");
		}

		console.println("\n" + ":::" + department.toString()  + ":::" + "\n");
		for (ProductDetail product : products) {
			console.println(product.toString());
			console.println(product.getImage());
		} 
		
	}  
	
	/**
	 * it list all products under each department
	 */
	private static void listAllProducts() {
		String intro = " | List all products available";
		console.println(title + intro);
		display((title + intro).length());

		if (data.getAllProducts() == null) {
			console.println("No products available. Please Add Products.");
			return;
		}
		
		for(ProductDetail product : data.getAllProducts()) {
			console.println(product.toString());
			console.print(product.getImage()); 
		}
		
	}

	/**
	 * it adds stock for a product via using product code and asks quantity
	 */
	private static void addStockProducts() {
		String intro = " -->  Add Stock for a Product";
		console.println(title + intro);
		display((title + intro).length());

		// Get product code
		String code = "";

		boolean validInputCode = false;
		do {
			console.print("Enter product code : ");
			code = console.readLn();
			code = code.trim();
			if(data.search(code) != null) {
				validInputCode = true;
				break;
			} else {
				console.println("Please enter valid product code.");
				console.println("");
			}
			
		} while (!validInputCode);
		
		boolean validInputInt = false;
		int quantity = 0;
		do {
			console.print("Enter new product quantity : ");
			try {
				String input = console.readLn();
				quantity = Integer.parseInt(input);
				validInputInt = true;
			} catch (NumberFormatException e) {
				console.println("Please enter valid amount of quantity of the product.");
				console.println("");
			}
		} while (!validInputInt);
		if (data.restock(code, quantity)) {
			console.println("\n" + "You have added stock for a product successfully");
		}

	}

	/**
	 * it shows you the amount of purchases and shows top product purchases
	 */
	private static void reportSales() {
		String intro = title + " -->  REPORT SALES";
		console.println(intro);
		display(intro.length());
		
		Product[] products = data.getAllProducts();
		
		Product temp;
		
		for (int i = 0; i < products.length; i++) {
            for (int j = i + 1; j < products.length; j++) {
                if (products[i].getPurchases() < products[j].getPurchases()) {
                	temp = products[i];
                	products[i] = products[j];
                	products[j] = temp;
                }
            }
        }
		
		for(Product prod: products) {
			console.println(prod.toString());
		}

	}

	/**
	 * it shows you the amount of purchases and updates the quantity of product
	 */
	private static void recordPurchase() {
		String intro = " -->  Add Stock for a Product";
		console.println(title + intro);
		display((title + intro).length());

		// Get product code
		String code = "";
		boolean validInputCode = false;
		do {
			console.print("Enter product code : ");
			code = console.readLn();
			code = code.trim();
			if(data.search(code) != null) {
				validInputCode = true;
				break;
			} else {
				console.println("Please enter valid product code.");
				console.println("");
			}
			
		} while (!validInputCode);

		int quantity = 0;
		boolean validInputInt = false;
		do {
			console.print("How many product purchased : ");
			try {
				String input = console.readLn();
				quantity = Integer.parseInt(input);
				validInputInt = true;
			} catch (NumberFormatException e) {
				console.println("Please enter valid amount of purchases of the product.");
				console.println("");
			}
		} while (!validInputInt);

		Product product = data.search(code);

		boolean isError = false;
		for (int i = 0; i < quantity; i++) {
			if (!product.recordPurchase()) {
				isError = true;
			}
		}
		if (isError) {

			console.println("\nInsufficent quantity to complete the purchase\n");
		}

		console.println(product);

	}

	/**
	 * it helps you to select department when adding new product or getting products under each department
	 * @return
	 */
	private static Department getDepartment() {
		String options[] = { "Electrical", "Photographic", "Computing", "Books", "Music", "Fashion", "Other"};
		String str = ("\nSelect a department");
		display(str, options);
		
		int choice = console.getUserChoice();
		 
		switch (choice) {

		case 1:
			return Department.ELECTRICAL;
		case 2:
			return Department.PHOTOGRAPHIC;
		case 3:
			return Department.COMPUTING;
		case 4:
			return Department.BOOKS;
		case 5:
			return Department.MUSIC;
		case 6:
			return Department.FASHION;
		default:
			return Department.OTHER;
		} 
	}

	/**
	 * it displays array options
	 * @param str
	 * @param options
	 */
	private static void display(String str, String[] options) {
		console.println(title);
		for(int count=0;count<title.length();count++) {
			console.print("+");
		}
		console.println(); 
		for(int option=1; option<=options.length; option++) {
			console.println(option + ". " + options[option-1] );
		}
		console.println();
	}		
	
	/**
	 * it prints equals by calculating the number of words 
	 * @param count
	 */
	private static void display(int count) {
		for (int i = 0; i < count; i++) {
			console.print("=");
		}
		console.println("");
	
	}
	
}
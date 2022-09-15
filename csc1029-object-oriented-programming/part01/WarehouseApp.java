package part01;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import part01.Menu;

public class WarehouseApp {

	private static Scanner input = new Scanner(System.in);
	static String title = "WAREHOUSE APP";
	static Warehouse data = new Warehouse("Sobirjon Ergashev's");

	public static void main(String[] args) {
		
		String owner = "Warehouse owner: ";
		System.out.println(owner + data.getName() + "\n");
		
		String options[] = { 
				"Add new product",
				"Delete a product",  
				"List products for Department",
				"List all products" , 
				"Add Stock for a Product", 
				"Sales Report", 
				"Record Purchase", 
				"Exit" };
		Menu sysMen = new Menu(title, options);
		boolean finished = false;
		do {
			int choice = sysMen.getUserChoice();
			if (choice == options.length) {
				finished = true;
			} else {
				processChoice(choice);
			}
		} while (!finished);
		System.out.println("Goodbye!");
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
			System.out.println("Option " + choice + " is invalid");
		}
		System.out.println();
	}
	/**
	 * it adds new product to warehouse
	 * asks manufacturer, model, price, Department, and quantity
	 */
	private static void addNewProduct() {
		String intro = " -->  Add New Product";
		System.out.println(title + intro);
		printEquals((title + intro).length());

		String make = "";
		do {
			System.out.print("#-- Manufacturer : ");
			make = input.next();
			make = make.trim();

			if (make.isEmpty()) {
				System.out.println("**Please enter a valid manufacturer names String input**");
			}

		} while (make.trim().isEmpty());

		String model = "";
		do {
			System.out.print("#-- Model : ");
			model = input.next();
			model = model.trim();

			if (model.isEmpty()) {
				System.out.println("**Please enter a valid Model Name input**");
			}
		} while (model.trim().isEmpty());

		double price = 0;
		boolean validInputDb = false;
		do {
			System.out.print("#-- Price £ : ");
			try {
				price = input.nextDouble();
				validInputDb = true;
			} catch (InputMismatchException nfe) {
				System.out.println("Please enter valid price for the product.");
				input.nextLine();
			}
		} while (!validInputDb);

		System.out.print("#-- Department : ");
		Department department = getDepartment();

		int quantity = 0;
		boolean validInputInt = false;
		do {

			String str = "\nIf you want to skip, enter 0.";
			System.out.println(str);
			System.out.print("#-- Quantity £ : ");
			try {
				quantity = input.nextInt();
				validInputInt = true;
			} catch (InputMismatchException nfe) {
				System.out.println("Please enter valid amount of quantity of the product.");
				input.nextLine();
			}
		} while (!validInputInt);

		if (data.search(make, model) != null) {
			String str = "This product has been added before. Please double check!\n";
			System.out.println("\nOops! " + str);
		} else if (data.addProduct(make, model, price, department, quantity) != null) {
			String str = "\nCongrats!" + " ";
			System.out.print(str + "You have successfully added a new product.\n");
		} else {
			System.out.println("\nOops! Check it again!\n");
		}
	}
	/**
	 * it deletes product in warehouse via using product code
	 */
	private static void deleteProduct() {
		String intro = "--> Delete Product";
		System.out.println(title + intro);
		printEquals((title + intro).length());

		System.out.print("Enter Code:");
		String code = input.nextLine();
		code = code.trim();
		data.deleteProduct(code);
		System.out.println();
	}

	/**
	 * it shows you specific departments to get products of each department
	 */
	private static void listProductsDept() {
		String intro = " -> List all products by Department";
		System.out.println(title + intro);
		printEquals((title + intro).length());

		Department department = getDepartment();
		ArrayList<Product> products = data.search(department);
		
		if (products.size() == 0) {
			System.out.println("No products available. Please Add Products.");
		}

		for (Product product : products) {
			System.out.println(product.toString());
		}
	}
	
	/**
	 * it list all products under each department
	 */
	private static void listAllProducts() {
		String intro = " | List all products available";
		System.out.println(title + intro);
		printEquals((title + intro).length());

		if (data.getAllProducts() == null) {
			System.out.println("No products available. Please Add Products.");
			return;
		}
		
		System.out.println(data.toString());

	}

	/**
	 * it adds stock for a product via using product code and asks quantity
	 */
	private static void addStockProducts() {
		String intro = " -->  Add Stock for a Product";
		System.out.println(title + intro);
		printEquals((title + intro).length());

		// Get product code
		String code = "";
		do {
			System.out.print("Enter product code : ");
			code = input.next();
			code = code.trim();

			if (code.isEmpty()) {
				System.out.println("**Please enter a valid product code String input**");
			}

		} while (code.trim().isEmpty());

		int quantity = 0;
		boolean validInputInt = false;
		do {
			System.out.print("Enter new product quantity : ");
			try {
				quantity = input.nextInt();
				validInputInt = true;
			} catch (InputMismatchException nfe) {
				System.out.println("Please enter valid amount of quantity of the product.");
				input.nextLine();
			}
		} while (!validInputInt);
		if (data.restock(code, quantity)) {
			System.out.println();
		}

	}

	/**
	 * it shows you the amount of purchases and shows top product purchases
	 */
	private static void reportSales() {
		String intro = title + " -->  REPORT SALES";
		System.out.println(intro);
		printEquals(intro.length());
		
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
			System.out.println(prod.toString());
		}

	}

	/**
	 * it shows you the amount of purchases and updates the quantity of product
	 */
	private static void recordPurchase() {
		String intro = " -->  Add Stock for a Product";
		System.out.println(title + intro);
		printEquals((title + intro).length());

		// Get product code
		String code = "";
		do {
			System.out.print("Enter product code : ");
			code = input.next();
			code = code.trim();

			if (code.isEmpty()) {
				System.out.println("**Please enter a valid product code String input**");
			}

		} while (code.trim().isEmpty());

		int quantity = 0;
		boolean validInputInt = false;
		do {
			System.out.print("How many product purchased : ");
			try {
				quantity = input.nextInt();
				validInputInt = true;
			} catch (InputMismatchException nfe) {
				System.out.println("Please enter valid amount of purchases of the product.");
				input.nextLine();
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

			System.out.println("\nInsufficent quantity to complete the purchase\n");
		}

		System.out.println(product);

	}

	/**
	 * it helps you to select department when adding new product or getting products under each department
	 * @return
	 */
	private static Department getDepartment() {
		String options[] = { "Electrical", "Photographic", "Computing", "Books", "Music", "Fashion", "Other" };
		Menu chooseDept = new Menu("\nSelect a department", options);
		int choice = chooseDept.getUserChoice();
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
	 * it prints equals by calculating the number of words
	 * @param count
	 */
	private static void printEquals(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

}

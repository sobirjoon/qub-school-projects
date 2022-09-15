package part01;

import java.util.ArrayList;


public class Warehouse implements iWare {
	private ArrayList<Product> data;
	private String name;

	/**
	 *  It returns name of warehouse owner
	 * @param name
	 */
	public Warehouse(String name) {
		this.data = new ArrayList<Product>();
		this.name = name;
		defaultProducts();
	} 
 
	/**
	 * 
	 * @return 
	 */
	public Product[] getAllProducts() {
		if (!data.isEmpty()) {
			Product[] products = new Product[data.size()];
			for (int i = 0; i < data.size(); i++) {
				products[i] = data.get(i);
			} 
			return products; 
		}
		
		return null;
	}

	/**
	 * it adds new product to warehouse
	 * @param make
	 * @param model
	 * @param price
	 * @param dept
	 * @return
	 */
	public String addProduct(String make, String model, double price, Department dept) {
	
		Product prod = new Product(make, model, price, dept);
		if (prod != null) {
			this.data.add(prod);
		}
		

		return "OK"; 
	
	}  

	/**
	 * it adds new product to warehouse
	 * @param make
	 * @param model
	 * @param price
	 * @param dept
	 * @param qty
	 * @return
	 */
	public String addProduct(String make, String model, double price, Department dept, int qty) {
		
		Product prod = new Product(make, model, price, dept, qty);
		if (prod != null) {
			this.data.add(prod);
		}
		

		return "OK"; 
	}

	/**
	 * it deletes product from warehouse using the code
	 * @param prod
	 * @return
	 */
	public boolean deleteProduct(String code) {

		int index;
		boolean found = false;
		for( index=0; index<data.size(); index++) {
			Product prod = data.get(index);
			if ( prod.getCode().equals(code) ) {
				found = true;
				break;
			}
		} 
		if (found) {
			data.remove(index);
			System.out.println("Product Deleted Successfully");
		}  
		
		return false; 
		} 

	/**
	 * it restocks product by updating quantity using product code
	 * @param name
	 * @param code
	 * @return
	 */
	public boolean restock(String code, int quantity) {
		Product product = search(code);
		
		if(product == null) { 
			return false;}
		
		product.addToQuantity(quantity);
		
	
		return true;
	}

	/**
	 * it finds product in warehouse using product code
	 * @param code
	 * @return
	 */
	public Product search(String code) {
		
		Product tempProd = null;
		for (Product prod: data) {
			if(prod.getCode().equals(code)) {
				tempProd = prod;
			} 
		}
		return tempProd;
	}

	/**
	 * it finds product in warehouse using product manufacturer, model
	 * @param make
	 * @param model
	 * @return
	 */
	public Product search(String make, String model) {
		Product tempProd = null;
		for (Product prod: data) {
			if(prod.getMake().equals(make) && prod.getModel().equals(model)) {
				tempProd = prod;
			}
		}
		
		return tempProd;
	}

	/**
	 * it finds product in warehouse using product department
	 * @param dept
	 * @return
	 */
	public ArrayList<Product> search(Department dept) {
		
		ArrayList<Product> tempProducts = new ArrayList<Product>();
		
		for (Product data: getAllProducts()) {
			if(data.getDepartment().equals(dept)) {
				tempProducts.add(data);
			}
		}
		
		return tempProducts;

	}

	/**
	 * it shows the details of product
	 */
	public String toString() {
		Department[] departments = {
				Department.ELECTRICAL, 
				Department.PHOTOGRAPHIC, 
				Department.COMPUTING, 
				Department.BOOKS,
				Department.MUSIC, 
				Department.FASHION, 
				Department.OTHER};
		
		String str = "";

		for(int i = 0; i < departments.length; i++) {
			str += departments[i].toString() +"\n\n";
			for(Product prod: search(departments[i])) {
				str += prod.toString() + "\n";
			}

			if(search(departments[i]).isEmpty()) {
				str += "No products found for this department\n";
			}

		}
		
		return str;

	}

	
	/**
	 * it returns name of warehouse owner
	 */
	public String getName() {
		return this.name;
	}
 
	private void defaultProducts() {
		
		Product Eproduct1 = new Product("TV MADE", "ABC-TV", 199.9, Department.ELECTRICAL, 23);
		Product Eproduct2 = new Product("British Radio", "BCD-Radio", 299.9, Department.ELECTRICAL, 10);
		
		data.add(Eproduct1);
		data.add(Eproduct2);
	
		Product Pproduct1 = new Product("Photograph Production", "POO-Model", 799.9, Department.PHOTOGRAPHIC, 20);
		Product Pproduct2 = new Product("Photography", "BUU-Model", 279.9, Department.PHOTOGRAPHIC, 20);
		
		data.add(Pproduct1);
		data.add(Pproduct2);
		
		Product Cproduct1 = new Product("Apple Inc.", "Apple Macintosh 1984", 1999.9, Department.COMPUTING, 5);
		Product Cproduct2 = new Product("Microsoft Inc.", "Windows 95", 999.9, Department.COMPUTING, 10);
		
		data.add(Cproduct1);
		data.add(Cproduct2);
		
		Product Bproduct1 = new Product("Cambridge Press.", "Learn English Grammar", 8.0, Department.BOOKS, 1);
		Product Bproduct2 = new Product("Oxford Press.", "Learn English Grammar", 8.0, Department.BOOKS, 2);
		
		data.add(Bproduct1);
		data.add(Bproduct2);
		
		Product Mproduct1 = new Product("Michael Jackson.", "Worst collections", 44.0, Department.MUSIC, 43);
		Product Mproduct2 = new Product("Michael Jackson.", "Best collection", 24.0, Department.MUSIC, 25);
		
		data.add(Mproduct1);
		data.add(Mproduct2);
		
		Product Fproduct1 = new Product("Turkey Textile.", "ABC-Model", 9.9, Department.FASHION, 50);
		Product Fproduct2 = new Product("Turkey Textile.", "BCD-Model", 9.9, Department.FASHION, 50);
		
		data.add(Fproduct1);
		data.add(Fproduct2);
		
		Product Oproduct1 = new Product("Intel-A", "ABC-Model", 199.9, Department.OTHER, 20);
		Product Oproduct2 = new Product("Intel-B", "BCD-Model", 299.9, Department.OTHER, 20);
		
		data.add(Oproduct1);
		data.add(Oproduct2);
	}

}
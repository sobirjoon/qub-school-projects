package part03;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import part01.Department;
import part01.Product;
import part01.iWare;


public class Warehouse {
	private ArrayList<ProductDetail> data;
	private String name;

	/**
	 * it creates new warehouse with the owner name
	 * @param name
	 */
	public Warehouse(String name) {
		this.data = new ArrayList<ProductDetail>();
		this.name = name;
		defaultProducts();
	}

	/**
	 * you can get all products using this method
	 * @return
	 */
	public ProductDetail[] getAllProducts() {
		if (!data.isEmpty()) {
			ProductDetail[] products = new ProductDetail[data.size()];
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
	public String addProduct(String make, String model, double price, Department dept, String description) {
	
		ProductDetail prod = new ProductDetail(make, model, price, dept, 0, description, null);
		if (prod != null) {
			this.data.add(prod);
		}
		

		return "OK"; 
	
	}  

	/**
	 * it adds new product to warehouse with quantity
	 * @param make
	 * @param model
	 * @param price
	 * @param dept
	 * @param qty
	 * @return
	 */
	public String addProduct(String make, String model, double price, Department dept, int qty, String description) {
		
		ProductDetail prod = new ProductDetail(make, model, price, dept, qty, description, null);
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
			ProductDetail prod = data.get(index);
			if ( prod.getCode().equals(code) ) {
				found = true;
				break;
			}
		} 
		if (found) {
			data.remove(index);
			System.out.println("ProductDetail Deleted Successfully");
		}  
		
		return false; 
		} 

	/**
	 * it restocks the product with updating quantity by finding product with code
	 * @param name
	 * @param code
	 * @return
	 */
	public boolean restock(String code, int quantity) {
		ProductDetail product = search(code);
		
		if(product == null) { 
			return false;}
		
		product.addToQuantity(quantity);
		
	
		return true;
	}

	/**
	 * 
	 * @param code
	 * @return
	 */
	public ProductDetail search(String code) {
		
		ProductDetail tempProd = null;
		
		for (ProductDetail prod: data) {
			if(prod.getCode().equals(code)) {
				tempProd = prod;
			}
		}
		
		return tempProd;
	}

	/**
	 * 
	 * @param make
	 * @param model
	 * @return
	 */
	public ProductDetail search(String make, String model) {
		ProductDetail tempProd = null;
		for (ProductDetail prod: data) {
			if(prod.getMake().equals(make)&&prod.getModel().equals(model)) {
				tempProd = prod;
			}
		}
		
		return tempProd;
	}
	
	/**
	 * 
	 * @param dept
	 * @return
	 */
	public ArrayList<ProductDetail> search(Department dept) {
		
		ArrayList<ProductDetail> tempProducts = new ArrayList<ProductDetail>();
		
		for (ProductDetail data: getAllProducts()) {
			if(data.getDepartment().equals(dept)) {
				tempProducts.add(data);
			}
		} 
		
		return tempProducts; 

	}

	/**
	 * 
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
			str += "\n\n" + "***" + departments[i].toString() + "***" +"\n\n";
			for(ProductDetail prod: search(departments[i])) {
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

	/**
	 * it shows all default products
	 */
	private void defaultProducts() {
		String description = "This product is made by clever people so it is useful for humans and easy their effort with its features ";
		String path = "Images\\";
		
		ImageIcon img1 = new ImageIcon(path + "E0001" + ".png");
		ImageIcon img2 = new ImageIcon(path + "E0002" + ".png");
		ProductDetail Eproduct1 = new ProductDetail("TV MADE", "ABC-TV", 199.9, Department.ELECTRICAL, 23, description, img1);
		ProductDetail Eproduct2 = new ProductDetail("British Radio", "BCD-Radio", 299.9, Department.ELECTRICAL, 10, description, img2);
		  
		data.add(Eproduct1);
		data.add(Eproduct2);
	
		ImageIcon img3 = new ImageIcon(path + "P0003" + ".png");
		ImageIcon img4 = new ImageIcon(path + "P0004" + ".png");
		ProductDetail Pproduct1 = new ProductDetail("Photograph ProductDetailion", "POO-Model", 799.9, Department.PHOTOGRAPHIC, 20, description, img3);
		ProductDetail Pproduct2 = new ProductDetail("Photography", "BUU-Model", 279.9, Department.PHOTOGRAPHIC, 20, description, img4);
		
		data.add(Pproduct1);
		data.add(Pproduct2);
		
		ImageIcon img5 = new ImageIcon(path + "C0005" + ".png");
		ImageIcon img6 = new ImageIcon(path + "C0006" + ".png");
		ProductDetail Cproduct1 = new ProductDetail("Apple Inc.", "Apple Macintosh 1984", 1999.9, Department.COMPUTING, 5, description, img5);
		ProductDetail Cproduct2 = new ProductDetail("Microsoft Inc.", "Windows 95", 999.9, Department.COMPUTING, 10, description, img6);
		
		data.add(Cproduct1);
		data.add(Cproduct2);
		
		ImageIcon img7 = new ImageIcon(path + "B0007" + ".png");
		ImageIcon img8 = new ImageIcon(path + "B0008" + ".png");
		ProductDetail Bproduct1 = new ProductDetail("Cambridge Press.", "Learn English Grammar", 8.0, Department.BOOKS, 1, description, img7);
		ProductDetail Bproduct2 = new ProductDetail("Oxford Press.", "Learn English Grammar", 8.0, Department.BOOKS, 2, description, img8);
		
		data.add(Bproduct1);
		data.add(Bproduct2);
		
		ImageIcon img9 = new ImageIcon(path + "M0009" + ".png");
		ImageIcon img10 = new ImageIcon(path + "M0010" + ".png");
		ProductDetail Mproduct1 = new ProductDetail("Michael Jackson.", "Worst collections", 44.0, Department.MUSIC, 43, description, img9);
		ProductDetail Mproduct2 = new ProductDetail("Michael Jackson.", "Best collection", 24.0, Department.MUSIC, 25, description, img10);
		
		data.add(Mproduct1);
		data.add(Mproduct2);
		
		ImageIcon img11 = new ImageIcon(path + "F0011" + ".png");
		ImageIcon img12 = new ImageIcon(path + "F0012" + ".png");
		ProductDetail Fproduct1 = new ProductDetail("Turkey Textile.", "ABC-Model", 9.9, Department.FASHION, 50, description, img11);
		ProductDetail Fproduct2 = new ProductDetail("Turkey Textile.", "BCD-Model", 9.9, Department.FASHION, 50, description, img12);
		
		data.add(Fproduct1);
		data.add(Fproduct2);
		
		ImageIcon img13 = new ImageIcon(path + "O0013" + ".png");
		ImageIcon img14 = new ImageIcon(path + "O0014" + ".png");
		ProductDetail Oproduct1 = new ProductDetail("Intel-A", "ABC-Model", 199.9, Department.OTHER, 20, description, img13);
		ProductDetail Oproduct2 = new ProductDetail("Intel-B", "BCD-Model", 299.9, Department.OTHER, 20, description, img14);
		
		data.add(Oproduct1);
		data.add(Oproduct2);
	}

}

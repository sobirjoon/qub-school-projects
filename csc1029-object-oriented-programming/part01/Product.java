package part01;

public class Product implements iPro {

	private String code;
	private String make;
	private String model;
	private double price;
	private int quantity;
	private int purchases;
	private Department dept;

	private static int nextCodeNumber = 001;
 
	/**
	 * Product constructor to create Product object
	 * @param make - Manufacturer 
	 * @param model - Product model
	 * @param price - Price
	 * @param dept - Specific department for each product
	 * @param quantity - the amount of products 
	 */

	public Product(String make, String model, double price, Department dept, int quantity) {
		this.code = useNextCode(dept);
		this.make = make;
		this.model = model;
		this.price = price;
		this.dept = dept;
		this.quantity = quantity;
	}
 
	/**
	 * Product constructor to create Product object
	 * @param make - Manufacturer 
	 * @param model - Product model
	 * @param price - Price
	 * @param dept - Specific department for each product
	 */
	public Product(String make, String model, double price, Department dept) {
		this.code = useNextCode(dept);
		this.make = make;
		this.model = model;
		this.price = price;
		this.dept = dept;

	}
 
	/*
	 * Getters
	 */
	
	/** This is a getter
	 * return product code
	 * @return Product Code
	 */
	public String getCode() {
		return this.code;
	}

	/** This is a getter
	 * return manufacturer
	 * @return Product manufacturer
	 */
	public String getMake() {
		return this.make;
	}
	
	/** This is a getter
	 * return product model
	 * @return Product model
	 */
	public String getModel() {
		return this.model;
	}

	/** This is a getter
	 * return product price
	 * @return Product price
	 */
	public double getPrice() {
		return this.price;
	}

	/** This is a getter
	 * return the amount of products
	 * @return Product quantity
	 */
	public int getQuantity() {
		return this.quantity;
	}

	/** This is a getter
	 * return product department
	 * @return Product department
	 */
	public Department getDepartment() {
		return this.dept;
	}
	
	/**  This is a getter
	 * @return purchases 
	 */
	public int getPurchases() {
		return this.purchases;
	}

	/**
	 * This is a method to assign product code to products automatically
	 * @param dept
	 * @return product code
	 */
	private String useNextCode(Department dept) {
		int tempNextNumberCode = nextCodeNumber++;
		char letterCode;
		
		switch (dept) {
		case ELECTRICAL:
			letterCode = 'E';
			break;
		case PHOTOGRAPHIC:
			letterCode = 'P';
			break;
		case COMPUTING:
			letterCode = 'C';
			break;
		case BOOKS:
			letterCode = 'B';
			break;
		case MUSIC:
			letterCode = 'M';
			break;
		case FASHION:
			letterCode = 'F';
			break;
		default:
			letterCode = 'O';
			break;
		}
		
		String tempCode = letterCode + "" + String.format("%04d", tempNextNumberCode);
		
		return tempCode;
	}
	
	/**
	 * it shows the details of product
	 */
	public String toString() {
		String str = "Product Code : " + this.code + "\n";
		str += "Manufacturer : " + this.make + "\n";
		str += "Model : " + this.model + "\n";
		str += "Price : " + this.price + " £\n";
		str += "Quantity : " + this.quantity + "\n";
		str += "Purchases : " + this.purchases + "\n";
		str += "Department : " + this.dept + "\n";
		return str;
	}

	/**
	 * it updates the amount of product in warehouse
	 */
	public void addToQuantity(int quantity) {
		this.quantity += quantity;
	}

	/**
	 * it records how many products purchased and how many of them left in warehouse
	 */
	public boolean recordPurchase() {
		if (quantity <= 0) {
			return false;
		}
		
		this.purchases++;
		this.quantity--;
		
		return true;
	}



}

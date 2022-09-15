package part03;

import javax.swing.ImageIcon;

import part01.Department;
import part01.Product;

public class ProductDetail extends Product{
	private String description;
	private ImageIcon image;
	
	/**
	 * creates new product with extra features @param description @param image
	 * @param make
	 * @param model
	 * @param price
	 * @param dept
	 * @param quantity
	 * @param description
	 * @param image
	 */
	public ProductDetail(String make, String model, double price, Department dept, int quantity, String description, ImageIcon image) {
		super(make, model, price, dept);
		this.description = description;
		if(image != null) {
			this.image = image;
		} else {
			this.image = new ImageIcon("Images\\" + "default" + ".png");
		}
	}

	/**
	 * it returns description of product
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * it returns the product image
	 * @return
	 */
	public ImageIcon getImage() {
		return this.image;
	}
	
	
	/**
	 * it shows the details of product
	 */
	@Override
	/**
	 * it shows all details of product
	 */
	public String toString() {
		String str = "\nProduct Code : " + super.getCode() + "\n";
		str += "Manufacturer : " + super.getMake() + "\n";
		str += "Model : " + super.getModel() + "\n";
		str += "Price : " + super.getPrice() + " £\n";
		str += "Quantity : " + super.getQuantity() + "\n";
		str += "Purchases : " + super.getPurchases() + "\n";
		str += "Department : " + super.getDepartment() + "\n";
		str += "Description : " + getDescription() + "\n";
		str += "Product image: " ;
		return str;
	}

}

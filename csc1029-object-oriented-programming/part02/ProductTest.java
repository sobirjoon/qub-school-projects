package part02;

import part01.Department;
import part01.Product;

public class ProductTest {
	
	private static String make = "ABC";
	private static String model = "123";
	private static double price = 200;
	private static int quantity = 20;
	private static Department dept = Department.BOOKS;
	private static int purchase = 1;

	public static void main(String[] args) {
		testCase1();
		testCase2();
		testCase3();
		testCase4();
		testCase5();
		testCase6();
		testCase7();
		testCase8();
		testCase9();
		testCase10();
		testCase11();
		testCase12();
		
	}

	private static void testCase1() {
		System.out.println("++++++++++++ Test Case 1 - without quantity ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept);
			 Product prod = new Product(make, model, price, dept);
			 String code = prod.getCode();
			 System.out.println("Get Product code: " + code);
			 System.out.println("Output: ");
			 System.out.println(prod.toString());
			 String exOutput = "B0001";
			 if(code.equals(exOutput)) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 1 ++++++++++++");
		
		
	}


	private static void testCase2() {
		System.out.println("\n++++++++++++ Test Case 2 - Create Product qty ++++++++++++");
		try {
			System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept + " " + quantity);
			Product prod = new Product(make, model, price, dept, quantity);
			String code = prod.getCode();
			System.out.println("Get Product code: " + code);
			String exOutput = "B0002";
			 System.out.println("Output: ");
			 System.out.println(prod.toString());
			if(code.equals(exOutput)) {
				System.out.println("Passed");
			} else {
				System.out.println("Failed");
			}
			} catch(Exception ex) {
				System.out.println("Exception");
			}
		System.out.println("++++++++++++ End Test Case 2 ++++++++++++");
		}

	private static void testCase3() {
		System.out.println("\n++++++++++++ Test Case 3 - Get Code ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept);
			 Product prod = new Product(make, model, price, dept);
			
			 System.out.println("Expected Output: ");
			 String exOutput = "B0003";
			 System.out.println(exOutput);
			 System.out.println("Actual Output: ");
			 String output = prod.getCode();
			 System.out.println(output);
			 if(output.equals(exOutput)) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 3 ++++++++++++");
	}

	private static void testCase4() {
		System.out.println("\n++++++++++++ Test Case 4 - Get Make ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept + " " + purchase);
			 Product prod = new Product(make, model, price, dept);
			
			 System.out.println("Expected Output: ");
			 int exOutput = 1;
			 System.out.println(exOutput);
			 System.out.println("Actual Output: ");
			 int output = prod.getPurchases();
			 System.out.println(output);
			 if (output==exOutput) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 4 ++++++++++++");
	}

	private static void testCase5() {
		System.out.println("\n++++++++++++ Test Case 5 - Get Model ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept);
			 Product prod = new Product(make, model, price, dept);
			
			 System.out.println("Expected Output: ");
			 String exOutput = "123";
			 System.out.println(exOutput);
			 System.out.println("Actual Output: ");
			 String output = prod.getModel();
			 System.out.println(output);
			 if(output.equals(exOutput)) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 5 ++++++++++++");
	
	}

	private static void testCase6() {
		System.out.println("\n++++++++++++ Test Case 6 - Get Price ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept);
			 Product prod = new Product(make, model, price, dept);
			
			 System.out.println("Expected Output: ");
			 double exOutput = 200;
			 System.out.println(exOutput);
			 System.out.println("Actual Output: ");
			 double output = prod.getPrice();
			 System.out.println(output);
			 if(output == exOutput) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 6 ++++++++++++");
		
	}

	private static void testCase7() {
		System.out.println("\n++++++++++++ Test Case 7 - Record purchases, single purchases ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept + " " + quantity);
			 Product prod = new Product(make, model, price, dept, quantity);
			 boolean recordPurchase = prod.recordPurchase();
			 System.out.println("Get purchase: " + recordPurchase);
			 boolean exOutput = true;
			 if(recordPurchase==exOutput) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 7 ++++++++++++");
	}

	private static void testCase8() {
		System.out.println("\n++++++++++++ Test Case 8 - Record purchaces, make and model are null ++++++++++++");
		try {
			 Product prod = new Product(null, null, price, dept);
				System.out.println("Input: " + null +  ", "  + null + ", "  + price +  ", " + dept);
				System.out.println("Actual Output: " + prod.toString());
			 String exOutput = null;
			 System.out.println("Expected Output: " + exOutput);
			 if(prod.equals(exOutput)) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 8 ++++++++++++");
	}

	private static void testCase9() {
		System.out.println("\n++++++++++++ Test Case 9 - Create Product with incorrect department ++++++++++++");
		try {
			 Product prod = new Product(make, model, price, dept);
				System.out.println("Input: " + make +  ", "  + model + ", "  + price +  ", " + dept);
				System.out.println("Actual Output: " + prod.recordPurchase());
			 String exOutput = null;
			 System.out.println("Expected Output: " + exOutput);
			 if(prod.equals(exOutput)) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 9 ++++++++++++");
	}

	private static void testCase10() {
		System.out.println("\n++++++++++++ Test Case 10 - Get Quantity ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept + " " + quantity);
			 Product prod = new Product(make, model, price, dept, quantity);
			
			 System.out.println("Expected Output: ");
			 int exOutput = 20;
			 System.out.println(exOutput);
			 System.out.println("Actual Output: ");
			 int output = prod.getQuantity();
			 System.out.println(output);
			 if(output==exOutput) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 10 ++++++++++++");
		
	}
	
	private static void testCase11() {
		System.out.println("++++++++++++ Test Case 11 - addToQuantity ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept + " " + quantity);
			 Product prod = new Product(make, model, price, dept, quantity);
			
			 System.out.println("Expected Output: ");
			 int exOutput = 31;
			 System.out.println(exOutput);
			 System.out.println("Actual Output: ");
			 prod.addToQuantity(11);
			 int output = prod.getQuantity();
			 System.out.println(output);
			 if(output==exOutput) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 11 ++++++++++++");		
	}

	private static void testCase12() {
		System.out.println("\n++++++++++++ Test Case 12 - toString  ++++++++++++");
		try {
				System.out.println("Create Product: " + make +  " "  + model + " "  + price +  " " + dept);
			 Product prod = new Product(make, model, price, dept);
			
			 System.out.println("Expected Output: ");
			 String exOutput = "Product Code : B0012\n"
			 		+ "Manufacturer : ABC\n"
			 		+ "Model : 123\n"
			 		+ "Price : 200.0 £\n"
			 		+ "Quantity : 0\n"
			 		+ "Purchases : 0\n"
			 		+ "Department : Books\n";
			 System.out.println(exOutput);
			 System.out.println("Actual Output: ");
			 String output = prod.toString();
			 System.out.println(output);
			 if(output.equals(exOutput)) {
				 System.out.println("Passed");
			 } else {
				 System.out.println("Failed");
			 }
		} catch(Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 12 ++++++++++++");		
	}
}
package part02;

import part01.Department;
import part01.Product;
import part01.Warehouse;

public class WarehouseTest {

	private static Warehouse warehouse = new Warehouse("Name");
	private static String make = "ABC";
	private static String model = "123";
	private static double price = 200;
	private static int quantity = 20;
	private static Department dept = Department.BOOKS;
	private static int purchase = 1;

	public static void main(String[] args) {
		testCase1();
		testCase2();
//		testCase3();
//		testCase4();
//		testCase5();
//		testCase6();
//		testCase7();
//		testCase8();
//		testCase9();
//		testCase10();
//		testCase11();
	}

	private static void testCase1() {
		System.out.println("\n++++++++++++ Test Case 1- Warehouse ++++++++++++");
		try {
			System.out.println("add Product: " + make + " " + model + " " + price + " " + dept);
			String prod = warehouse.addProduct(make, model, price, dept);
			String output = prod.toString();
			String exOutput = "OK";
			System.out.println("Expected Output: ");
			System.out.println(exOutput);
			System.out.println("Actual Output: ");
			System.out.println(output);
			if (output.equals(exOutput)) {
				System.out.println("Passed");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 1 ++++++++++++");
	}

	private static void testCase2() {
		System.out.println("\n++++++++++++ Test Case 2 - Create Product qty ++++++++++++");
		try {
			System.out.println("add Product: " + make + " " + model + " " + price + " " + dept + " " + quantity);
			String prod = warehouse.addProduct(make, model, price, dept, quantity);
			String output = prod.toString();
			String exOutput = "OK";
			System.out.println("Expected Output: ");
			System.out.println(exOutput);
			System.out.println("Actual Output: ");
			System.out.println(output);
			if (output.equals(exOutput)) {
				System.out.println("Passed");
			} else {
				System.out.println("Failed");
			}
		} catch (Exception ex) {
			System.out.println("Exception");
		}
		System.out.println("++++++++++++ End Test Case 2 ++++++++++++");
	}

	private static void testCase3() {

	}

	private static void testCase4() {

	}

	private static void testCase5() {

	}

	private static void testCase6() {

	}

	private static void testCase7() {

	}

	private static void testCase8() {

	}

	private static void testCase9() {

	}

	private static void testCase10() {

	}

	private static void testCase11() {

	}

}

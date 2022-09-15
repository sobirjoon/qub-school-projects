/**
 * 
 * @author Sobirjon Ergashev
 * @description This is a tester class for Q1.java
 *
 */

public class Q1Tester {

	public static void main(String[] args) {


		// c. (question c.)
		
		
		System.out.println("\nTest: GetOp(char)\n \nExpected token: " + TokenType.OP_ADD);
		
		getOp('+');
		getOp('5'); 
		
		// d. 
		System.out.println("\nExpected token: " + TokenType.COMMA);
		getSymbol(',');
		getSymbol('5'); 


		// e. 

		System.out.println("\nTest: GetOp(String)\n \nExpected token:  " + TokenType.OP_EQUAL);
		getOp("==");
		getOp("bl");

		// f.

		System.out.println("\nTest: GetOp(String)\n \nExpected token:  " + TokenType.HOBBITS_SAY);
	
		weeHobbits("HobbitsSay");
		weeHobbits("bla bla");
	
		// h.

		System.out.print("\nTest: \"isLetter\" method.");
		testLetter('h');;
		testLetter('5');
 
		// i.

		System.out.print("Test: \"isDigit\" method.");
		testDigit('1'); 
		testDigit('k');
 
		// j.

		System.out.print("Test: \"isWhiteSpace\" method.");
		testWhiteSpace(' ');;
		testWhiteSpace('5');
		

		// k.

		System.out.print("Test: \"isLineBreak\" method.");
		testNewLine('\n');
		testNewLine('5');
		
	}

	// this method check whether return value type is single operator TokenType or not by calling Tester method
	public static void getOp(char name) {  
		
		TokenType singleOperator = Q1.getOp(name);
		Tester(singleOperator);
	}  
	
	// this method check whether return value type is symbol TokenType or not and by calling Tester method
	public static void getSymbol(char name) {

		TokenType weeSymbol = Q1.getSymbol(name);
		Tester(weeSymbol);
	}  
	
	// this method check whether return value type is hobbits TokenType or not by calling Tester method
	public static void weeHobbits(String name) {
		
		TokenType hobbitsSay = Q1.getHobbits(name);
		Tester(hobbitsSay);
	}  
	// this method check whether return value type is double operator TokenType or not by calling Tester method
	
	public static void getOp(String name) {

		TokenType weeSymbol = Q1.getOp(name);

		Tester(weeSymbol);
	}  
	
	
	/**
	 * when this method is called, it checks whether name is corresponding TokenType or null
	 * @param name
	 */
	public static void Tester (TokenType name) { 
	if ( name != null) { 
		
		System.out.println("Result: "  + name);
		
	} else  {
		
		System.out.println("Expected: " + null + "\nResult: "  + name);
		} 
	}
		
	// this method check whether return value type is boolean or not by calling FalseTrue method
 
	public static void testLetter(char name) {

		boolean letter = Q1.isLetter(name);
		FalseTrue(letter);
	} 
	
	// this method check whether return value type is boolean or not by calling FalseTrue method
	
	public static void testDigit(char name) {
		
		boolean digit = Q1.isDigit(name);
		FalseTrue(digit);
	} 	
	 
	// this method check whether return value type is boolean or not by calling FalseTrue method
	
	public static void testWhiteSpace(char name) {
		
		boolean iswhitespace = Q1.isWhiteSpace(name);
		FalseTrue(iswhitespace);
	} 
	
	// this method check whether return value type is boolean or not by calling FalseTrue method
	
	public static void testNewLine(char name) {
		
		boolean newline = Q1.isLineBreak(name);
		FalseTrue(newline);
	} 
	
	/**
	 * when this method is called, it checks whether return value is true or false
	 * @param result
	 * @return true or false
	 */
	
	public static boolean FalseTrue (boolean result) {
	
		if (result == true) {
			System.out.print("\n\nResult: " + result);
			System.out.println("\nExpect: " + true);
		} else {
			System.out.print("Result: " + result);
			System.out.println("\nExpect: " + false + "\n");
		}
		return result;
 
	} 

	
}

/**
 * 
 * @author Sobirjon Ergashev
 * @description This is a tester class for Q1.java
 *
 */

public class Q1TesterKeywords {

	/**
	 * this method is tester case for checking @TokenType getKeyword (String) method
	 * @param args
	 */
	public static void main(String[] args) {

		
	
		// c. (question c.)
		
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_STATIC);
		weeKeywordTester("if");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("boom");
		
		
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_ELSE);
		weeKeywordTester("else");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("boom");

		
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_INT);
		weeKeywordTester("int");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("boom");

		
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_STRING);
		weeKeywordTester("String");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("boom");
		
		
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_PUBLIC);
		weeKeywordTester("public");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("boom");

		
		
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_CLASS);
		weeKeywordTester("class");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("boom");
		
	
		
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_VOID);
		weeKeywordTester("void");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("boom");

		

	
		System.out.println("\nTesting TokenType: " + TokenType.KEYWORD_STATIC);
		weeKeywordTester("static");
		
		System.out.println("Expected: " + null);
		weeKeywordTester("sdstatic");

		
		 
	}
	/**
	 * when this method is called in main method, it checks whether parameter name is keyword or not then prints result
	 * @return keyword name or null
	 * @param name
	 */
	public static void weeKeywordTester(String name) { 
		String name1 = name;
		
		TokenType getKeyword = Q1.getKeyword(name1);
		
		if (getKeyword != null)	{
			
			System.out.println("Result: " + getKeyword);
		
		} else if (getKeyword == null) { 
		
			System.out.println("Result: "  + getKeyword); 
	
		} 
		
}

}

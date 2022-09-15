/**
 * 
 * @author Sobirjon Ergashev
 * @date November, 2021
 * @location Queen's University Belfast, United Kingdom.
 *
 */

public class Q1 {
	
	// a.

	public static void main(String[] args) {

		TokenType op1 = getOp('+');
		System.out.println("op1: " + op1);

		TokenType op2 = getOp("==");
		System.out.println("op2: " + op2);

		TokenType sym = getSymbol('{');
		System.out.println("symbol: " + sym);

		TokenType keyword = getKeyword("int");
		System.out.println("keyword: " + keyword);

		TokenType hobbits = getHobbits("HobbitsSay");
		System.out.println("hobbits: " + hobbits);

		boolean letter = isLetter('a');
		System.out.println("letter: " + letter);

		boolean digit = isDigit('0');
		System.out.println("digit: " + digit);

		boolean whiteSpace = isWhiteSpace(' ');
		System.out.println("whiteSpace: " + whiteSpace);

		boolean newline = isLineBreak('\n');
		System.out.println("newline: " + newline);
	}

	// c.

	/**
	 * 
	 * @param ch the character is one of operators (+,-,*,/)
	 * @return the corresponding TokenType or it returns null
	 * @see the specification weeJava Specification.pdf
	 */
	public static TokenType getOp(char ch) {
		TokenType singleOperator = null;

		// c.
		if (ch == '*') {
			singleOperator = TokenType.OP_MULTIPLY;
		}

		else if (ch == '/') {
			singleOperator = TokenType.OP_DIVIDE;
		}

		else if (ch == '%') {
			singleOperator = TokenType.OP_MOD;
		}

		else if (ch == '+') {
			singleOperator = TokenType.OP_ADD;
		}

		else if (ch == '-') {
			singleOperator = TokenType.OP_SUBTRACT;
			
		} else if (ch == '=') {
			singleOperator = TokenType.OP_ASSIGN;
			
		} else if (ch == '<') {
			singleOperator = TokenType.OP_LESS;
			
		}	else if (ch == '>') {
			singleOperator = TokenType.OP_GREATER;
		}


		return singleOperator;

	}

	// d.

	/**
	 * @param s the string is one of double char operators
	 * @return the corresponding TokenType or it returns null
	 * @see the specification weeJava Specification.pdf
	 */
	public static TokenType getOp(String s) {
		TokenType doubleOperator = null;

		if (s.equals("<=")) {
			doubleOperator = TokenType.OP_LESSEQUAL;
		}
		else if (s.equals(">=")) {
			doubleOperator = TokenType.OP_GREATEREQUAL;
		}

		else if (s.equals("==")) {
			doubleOperator = TokenType.OP_EQUAL;
		}

		else if (s.equals("!=")) {
			doubleOperator = TokenType.OP_NOTEQUAL;
		}

		return doubleOperator;
	}

	// e.

	/**
	 * @param ch the character is one of symbols in weeJava
	 * @return token type or it returns null
	 * @see the specification weeJava Specification.pdf
	 */
	public static TokenType getSymbol(char ch) {

		TokenType weeSymbol = null;

		if (ch == '(') {
			weeSymbol = TokenType.LEFT_PAREN;
		}

		else if (ch == ')') {
			weeSymbol = TokenType.RIGHT_PAREN;
		}

		else if (ch == '{') {
			weeSymbol = TokenType.LEFT_BRACE;
		}

		else if (ch == '}') {
			weeSymbol = TokenType.RIGHT_BRACE;
		}

		else if (ch == '[') {
			weeSymbol = TokenType.LEFT_BRACKET;
		} 

		else if (ch == ']') {
			weeSymbol = TokenType.RIGHT_BRACKET;
		}

		else if (ch == ';') {
			weeSymbol = TokenType.SEMICOLON;
		}

		else if (ch == ',') {
			weeSymbol = TokenType.COMMA;
		}

		return weeSymbol;
	}

	// f.

	/**
	 * @param c the string is one of the keywords in weeJava
	 * @return the token type or it returns null
	 * @see the specification weeJava Specification.pdf
	 */
	public static TokenType getKeyword(String s) {
		TokenType weeKeyword = null;
		
		if (s.equals("if")) {
			weeKeyword = TokenType.KEYWORD_IF;
		} 
		
		else if (s.equals("else")) { 
			weeKeyword = TokenType.KEYWORD_ELSE;
		} 
		
		else if (s.equals("int")) {
			weeKeyword = TokenType.KEYWORD_INT;
		}

		else if (s.equals("String")) {
			weeKeyword = TokenType.KEYWORD_STRING;
		}

		else if (s.equals("public")) {
			weeKeyword = TokenType.KEYWORD_PUBLIC;
		}

		else if (s.equals("class")) {
			weeKeyword = TokenType.KEYWORD_CLASS;
		}

		else if (s.equals("void")) {
			weeKeyword = TokenType.KEYWORD_VOID;
		}

		else if (s.equals("static")) {
			weeKeyword = TokenType.KEYWORD_STATIC;
		}

		return weeKeyword;

	}

	// g.

	/**
	 * @param s the string is one of the two Hobbits method names
	 * @return token type or it returns null
	 * @see the specification weeJava Specification.pdf
	 */
	public static TokenType getHobbits(String s) {

		TokenType getHobbit = null;

		if (s.equals("HobbitsSay")) {
			getHobbit = TokenType.HOBBITS_SAY;
		}

		else if (s.equals("HobbitsDo")) {
			getHobbit = TokenType.HOBBITS_DO;

		}

		return getHobbit;

	}

	// h.

	/**
	 * @param ch is a letter
	 * @return if ch is a letter, it returns true otherwise false
	 * @see the specification weeJava Specification.pdf
	 */
	public static boolean isLetter(char ch) {

		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
			return true;
		}
		return false;
	}

	// i.

	/**
	 * @param ch is a digit
	 * @return if ch is a digit(9 to 1), it returns true otherwise false
	 * @see the specification weeJava Specification.pdf
	 */
	public static boolean isDigit(char ch) {

		if (ch >= '0' && ch <= '9') {
			return true;
		}
		return false;

	}

	// j.

	/**
	 * @param ch is a whitespace character
	 * @return if ch is a whitespace character, it returns true otherwise false
	 * @see the specification weeJava Specification.pdf
	 */

	public static boolean isWhiteSpace(char ch) {
		
		if (ch == ' ' || ch == '	') {
			return true;
		}

		return false;
	}
		
		

	

	// k.

	/**
	 * 
	 * @param ch is a new-line character
	 * @return if ch is a new-line character, it returns true otherwise false
	 * @see the specification weeJava Specification.pdf
	 */
	public static boolean isLineBreak(char ch) {
		if (ch == '\n') {
			return true;
		}
		return false;
	}

}


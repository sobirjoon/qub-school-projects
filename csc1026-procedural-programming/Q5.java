import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q5 {

	public static void main(String[] args) {

		// scan("src/WeeJavaExample.txt");

		System.out.println("## Q5Example1:");
		scan("src/Q5Example1.txt");

		System.out.println("## Q5Example2:");
		scan("src/Q5Example2.txt");

		System.out.println("## Q5Example3:");
		scan("src/Q5Example3.txt");
	}

	public static void scan(String fname) {
		String prog = readFile2String(fname);
 
		int n = prog.length();
		int index = 0;
		int lineNumber = 1;
		
		int leftBrace = 0;
		int rightBrace = 0;

		while (index < n) {
 
			char ch = prog.charAt(index);
			boolean whiteSpace = isWhiteSpace(ch);
			boolean newline = isLineBreak(ch);
			TokenType sym = getSymbol(ch);
			TokenType op = getOp(ch);
																																																			///		TokenType op1 = getOp(prog.substring(index, index+2)); 																					// if index == n-1, DO NOT DO THIS 
			boolean letter = isLetter(ch);
			boolean digit = isDigit(ch);

			

				
			
			if (whiteSpace) {

				index++;
				continue;

			} else if (newline) {

				lineNumber++;
				index++;
				continue;

			} else if (sym != null) { 
				letter = isLetter(ch);
				if (sym == TokenType.LEFT_BRACE) {
					leftBrace++;
				} else if (sym == TokenType.RIGHT_BRACE) {
					rightBrace++;
				} else if(letter) {
					 System.out.println("String literal is not properly cloased by a double-quote " + ch);
						System.out.println("at Line " + lineNumber);
						index++;
					
				}
				index++;
				continue;
			
			} else if (op != null || ch == '!') {

				String operator = "";
				operator += ch;
				index++;

				while (index < n) {
					ch = prog.charAt(index);

					operator += ch;

					if (getOp(operator) != null) {
				//		System.out.println(lineNumber + ", " + getOp(operator) + ", " + operator);
						break;

					} else if (getOp(operator) == null) {
						index--;
						ch = prog.charAt(index);
				//		System.out.println(lineNumber + ", " + op + ", " + ch);
						break;

					}

				}

				index++;
				continue;

			} else if (letter) {  // find a letter 

				String word = "";
				word += ch;
				index++;
				while (index < n) {
					ch = prog.charAt(index);

					letter = isLetter(ch);
					digit = isDigit (ch);
					sym = getSymbol(ch);

					if (letter || digit ) {
						word += ch;
						index++;
					} else if (sym != null) {
						word += ch;
						index++; }
					else {
						break;
					}

				}

				TokenType keyword = getKeyword(word);
				TokenType hobbits = getHobbits(word);
				// check the word which can be a variable name or keyword or hobbits
				if (keyword != null) {

			//		System.out.println(lineNumber + ", " + keyword + ", " + word);

				} else if (hobbits != null) {

		//			System.out.println(lineNumber + ", " + hobbits + ", " + word);

				} else {
		//			System.out.println(lineNumber + ", " + TokenType.IDENTIFIER + ", " + word);
					continue;

				}

			} else if (digit) { // find the first digit of a number and print it

				String number = "";
				number += ch;
				index++;
				while (index < n) {
					ch = prog.charAt(index);
					digit = isDigit(ch);
					letter = isLetter(ch);
					if (digit) {
						number += ch;
						index++;

					} else if (letter) {
						System.out.println("Syntax error on token \"" + number + "\", delete this token ");
						System.out.println("at Line " + lineNumber);
						break;
					} else {
						break;
					}
				}

		//		System.out.println(lineNumber + ", " + TokenType.INTEGER + ", " + number);
				continue;

			} else if (ch == '\"') {  // find the beginning of a string literal

				String str = "";
				str += ch;
				index++;

				while (index < n) {
					ch = prog.charAt(index);

					if (ch == '\"') { // find the end of a string literal

						str += ch;
						index++; 
						break;
					} else 
						break; 

				}

				System.out.println("String literal is not properly closed by a double-quote");
				continue;

			} else {
			//	System.out.println("Something unexpected happened at " + index + ": " + ch);
				index++;
				continue; }
			}
	
		if (leftBrace != rightBrace) {
			System.out.println("Syntax error, insert \"}\" to complete classBody ");
			System.out.println("at Line " + lineNumber);

		}
		
	}

	/**
	 * reads the specified file
	 * 
	 * @param fname the required file name
	 * @return the content of the file
	 */
	public static String readFile2String(String fname) {

		String content = null;
		try {

			content = new String(Files.readAllBytes(Paths.get(fname)));

		} catch (IOException e) {

			System.out.println("Fail to read a file");
		}

		return content;

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

		} else if (ch == '>') {
			singleOperator = TokenType.OP_GREATER;
		} else if (ch == ';') {
			singleOperator = TokenType.SEMICOLON;
		}

		else if (ch == ',') {
			singleOperator = TokenType.COMMA;
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
		} else if (s.equals(">=")) {
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

		return weeSymbol;
	}

	// f.

	/**
	 * @param c the string is one of the keywords in weeJava
	 * @return the token type or it returns null
	 * @see the specification weeJava Specification.pdf
	 */
	public static TokenType getKeyword(String c) {
		TokenType weeKeyword = null;

		if (c.equals("if")) {
			weeKeyword = TokenType.KEYWORD_IF;

		} else if (c.equals("else")) {
			weeKeyword = TokenType.KEYWORD_ELSE;

		} else if (c.equals("int")) {
			weeKeyword = TokenType.KEYWORD_INT;
		}

		else if (c.equals("String")) {
			weeKeyword = TokenType.KEYWORD_STRING;
		}

		else if (c.equals("public")) {
			weeKeyword = TokenType.KEYWORD_PUBLIC;
		}

		else if (c.equals("class")) {
			weeKeyword = TokenType.KEYWORD_CLASS;
		}

		else if (c.equals("void")) {
			weeKeyword = TokenType.KEYWORD_VOID;
		}

		else if (c.equals("static")) {
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
	public static TokenType getHobbits(String c) {

		TokenType getHobbit = null;

		if (c.equals("HobbitsSay")) {
			getHobbit = TokenType.HOBBITS_SAY;
		}

		else if (c.equals("HobbitsDo")) {
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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q4 {

	public static void main(String[] args) {

		scan("src/WeeJavaExample.txt");

	}

	public static void scan(String fname) {
		String prog = readFile2String(fname);

		int n = prog.length();  // n = to the length of the string being scanned
		int index = 0;
		int lineNumber = 1;

		while (index < n) {  // while the current character is less than the total characters the loop will run 

			char ch = prog.charAt(index); // current character

			boolean whiteSpace = isWhiteSpace(ch);
			boolean newline = isLineBreak(ch);
			TokenType sym = getSymbol(ch);
			TokenType op = getOp(ch);
			boolean letter = isLetter(ch);
			boolean digit = isDigit(ch);

			if (whiteSpace) {  // skip white spaces and move to the next character

				index++;
				continue;

			} else if (newline) { // skip newlines

				lineNumber++;  // the line number is increased by one and the index increases by one
				index++;
				continue;

			} else if (sym != null) { // getSymbol is called and if it doesn't return null then this is carried out


				System.out.println(lineNumber + ", " + sym + ", " + ch);
				index++;   // the index is increased and the loop is continued to the next character
				continue;

			} else if (op != null || ch == '!') {

				String operator = "";
				operator += ch;
				index++; 		// index increases by one to check the next character

				while (index < n) { // this while loop adds the next character onto the current character in operator
					ch = prog.charAt(index);

					operator += ch;

					if (getOp(operator) != null) {  // if the string operator doesn't return null it reutrn a double operator so this is carried out and the while statement ends
						System.out.println(lineNumber + ", " + getOp(operator) + ", " + operator);
						break;

					} else if (getOp(operator) == null) {  // if the operator does return null when put into getOp(s) then it must be a single operator and so this branch is carried out
						index--;						// the index is reduced by one to return it to the previous operator (the single operator)
						ch = prog.charAt(index);
						System.out.println(lineNumber + ", " + op + ", " + ch);
						break;

					}

				}

				index++;
				continue;

			} else if (letter) {  // if the current character is a letter then this branch is executed 

				String word = "";
				word += ch;
				index++; 
				while (index < n) {   // while the current index is less than the total the loop will continue 
					ch = prog.charAt(index);

					letter = isLetter(ch);    // the loop takes the current letter and adds it onto the word until it hits something that isn't a letter and then stops

					if (letter) {
						word += ch;
						index++;
					} else {
						break;
					}

				}
				// once the word is made the word runs through the two methods getKeyword and getHobbits to find its tokentype
				TokenType keyword = getKeyword(word);
				TokenType hobbits = getHobbits(word);
				
				// this checks which method didn't return null and if neither hobbits or keyword returned a value then it is assigned the identifier tokentype 
				if (keyword != null) {

					System.out.println(lineNumber + ", " + keyword + ", " + word);

				} else if (hobbits != null) {

					System.out.println(lineNumber + ", " + hobbits + ", " + word);

				} else {
					System.out.println(lineNumber + ", " + TokenType.IDENTIFIER + ", " + word);
					continue;

				}

			} else if (digit) { // find the first digit of a number and print it

				String number = "";
				number += ch;
				index++;
				while (index < n) {
					ch = prog.charAt(index);
					digit = isDigit(ch);
					if (digit) {
						number += ch;
						index++;

					} else {
						break;
					}
				}

				System.out.println(lineNumber + ", " + TokenType.INTEGER + ", " + number);
				continue;

			} else if (ch == '\"') { // once a double quotation mark is encountered this string takes place

                String str = "";		// new string made
                str += ch;				// current character is added to the current string
                index++;			// index increases by one

				while (index < n) {
					ch = prog.charAt(index);

				if (isLetter(ch)) {  // check it is a letter or not

						str += ch;
						index++;

					} else if (ch == '\'' || ch == '!' || ch == ':') { // check whether ch equals one of them

						str += ch;
						index++;
						continue;
					} else if (isWhiteSpace(ch)) { // check whether it is whitespace or not then skip it

						str += ch;
						index++;
						continue;
					} else if (ch == '\"') { // find the end of a string literal

						str += ch;
						index++;
						continue;
					} else
						break; 

				}

				System.out.println(lineNumber + ", " + TokenType.STRING + ", " + str);
				continue;

			} else {
				System.out.println("Something unexpected happened at " + index + ": " + ch);
				index++;
				continue;
			}

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

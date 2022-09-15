import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Q3 {

	public static void main(String[] args) {

		System.out.println("## Q3Example1:");
		scan("src/Q3Example1.txt");

		System.out.println("\n## Q3Example2:");
		scan("src/Q3Example2.txt");
	}

	public static String readFile2String(String fname) {

		String content = null;
		try {
			content = new String(Files.readAllBytes(Paths.get(fname)));
		} catch (IOException e) {
			System.out.println("Fail to read a file");
		}
		return content;

	}
	// Q3 part
	/**
	 * this scan method reads texts and skip two types of weeJava comments in the text: // and multi comments 
	 * @param fname
	 */
	public static void scan(String fname) {
		String text = readFile2String(fname);

		int n = text.length();
		int index = 0;
		while (index < n) {
			char ch = text.charAt(index); // current character
			char ch_next = ' '; // next character
			if (index < n - 1)
				ch_next = text.charAt(index + 1);

			if (((ch == '/' || ch == '*') && (ch_next == '/' || ch_next == '*'))) {
					// to skip every character until a newline while pattern is encountered
				while (!isLineBreak(ch)) {
					index++;		 // skip it
					ch = text.charAt(index); 
				}
				index++;
			} else if (ch == ' ' && ch_next == '*' && ch == ' ') {

				while (!isLineBreak(ch)) {
					index++;
					ch = text.charAt(index);
				}
				index++;

			}

			else {
				System.out.print(ch);  // print result
			}
			index++;
		}
	}

	// Q1 part
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
	public static TokenType getKeyword(String c) {
		TokenType weeKeyword = null;

		if (c.equals("if")) {
			weeKeyword = TokenType.KEYWORD_IF;
		}

		else if (c.equals("else")) {
			weeKeyword = TokenType.KEYWORD_ELSE;
		}

		else if (c.equals("int")) {
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

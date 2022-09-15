
public enum TokenType {


	/**
	 * Used for the method: getOp(char ch)
	 * weeJava Operators: 
	 */ 
 
	OP_MULTIPLY, 	
	OP_DIVIDE, 		
	OP_MOD, 		
	OP_ADD, 
	OP_SUBTRACT,

	/**
	 * Used for the method: getOp(String s)
	 * weeJava Operators 
	 */
	
	OP_LESS,
	OP_LESSEQUAL,
	OP_GREATER,
	OP_GREATEREQUAL,
	OP_EQUAL,
	OP_NOTEQUAL,
	OP_ASSIGN,

	/**
	 * Used for the method: getSymbol (char ch)
	 * weeJava Symbols 
	 */
	
	LEFT_PAREN,
	RIGHT_PAREN,
	LEFT_BRACE,
	RIGHT_BRACE,
	LEFT_BRACKET,
	RIGHT_BRACKET,
	SEMICOLON,
	COMMA,
	

	/**
	 * Used for the method: getHobbits(String s)
	 * weeJava Hobbits methods
	 * 
	 */ 

	HOBBITS_SAY,
	HOBBITS_DO,
	

			
	/**
	 * Used for the method: getKeyword(String s)
	 * All reserved keywords in weeJava
	 */
	
	KEYWORD_IF,
	KEYWORD_ELSE,
	KEYWORD_INT,
	KEYWORD_STRING,
	KEYWORD_PUBLIC,
	KEYWORD_CLASS,
	KEYWORD_VOID,
	KEYWORD_STATIC,

	IDENTIFIER,
	INTEGER,
	STRING,


}


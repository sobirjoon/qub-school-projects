package part03;

import java.awt.Color;
import java.awt.Font;

import console.Console;


public class ConsoleMenu extends Console{

	private static final long serialVersionUID = 1L;
	private String items[];
	private String title;
	
	public ConsoleMenu(String title, String data[], boolean b) {
		super(b);
		this.title = title;
		this.items = data;

	}
	

	protected void display() {
		
		println(title);
		for(int count=0;count<title.length()+2;count++) {
			print("+");
		} 
		println();
		for(int option=1; option<=items.length; option++) {
			println(option + ". " + items[option-1] );
		}
		println(); 
	}
	
	public int getUserChoice() {
		int choice = 0;
		
		do {
			try {
				print("Enter Selection: ");
				String input = readLn();
				input = input.trim();
				choice = Integer.parseInt(input);
				if (choice == items.length) {
					System.exit(choice); 
				}
				return  choice;
			} 
			catch (Exception ex) {
				println("Invalid menu option - try again!");
				println();
			}
		} while(true);
		
	}
	
	
}

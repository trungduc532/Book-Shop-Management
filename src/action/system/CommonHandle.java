/**
 * 59102901
 */
package action.system;

import java.util.Scanner;

/**
 * Common handle
 * 
 * @author Trung Duc
 * @see 2022/10
 */
public class CommonHandle {
	/**
	 * Scanner
	 */
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Input your choice
	 * 
	 * @return
	 */
	public static int inputChoice() {
		System.out.print("INPUT YOUR CHOICE: ");
		int choice = Integer.parseInt(scanner.nextLine());
		return choice;
	}
	
	/**
	 * Clean screen console 
	 */
	public static final void cleanScreen() {
		for(int i = 0; i <= 50; i++) {
			System.out.println();
		}
	}
	
	/**
	 * Continue program
	 */
	public static boolean continueProgram() {
		System.out.print("DO YOU WANT TO CONTINUE ? (y/n): ");
		String answer = scanner.nextLine();
		if(answer.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
}

package change;

import java.util.Scanner;

public class CashRegister {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		float price = 0.0F;
		float moneyTendered = 0.0F;
		int changeTotal = 0;
		int unitQuantities[] = new int[10];
		String choice = "";
		boolean running = true;

		System.out.println("___________ChangeBeastExtreme!!!1!___________");

		while (running) {
			// get price and money tendered from user
			price = prompt(keyboard, "**** Enter the price of the item in decimal form (ex: 5.89): ");
			moneyTendered = prompt(keyboard, "**** Enter the money tendered in decimal form (ex: 10.25): ");
			
			if (validAmount(price, moneyTendered)) { // check if valid amounts
				changeTotal = getChangeAmount(price, moneyTendered); // determine total change needed
				unitQuantities = convertChange(changeTotal); // determine quantities of each unit needed
				changeToStrings(unitQuantities, changeTotal); // print them out
				
				System.out.println("Run again? (Y/N)");
				choice = keyboard.next();
				if (choice.toLowerCase().equals("y")) {
					running = true;
				} else {
					System.out.println();
					running = false;
				}
			}
		}
	}

	// prompt with String, ensure money values are positive
	static float prompt(Scanner sc, String string) {
		float result = 0.0F;
		do {
			System.out.print(string);
			result = sc.nextFloat();
			if (result <= 0) {
				System.out.println("Invalid input. Try again...");
			}
		} while (result <= 0);
		return result;
	}

	// Display an appropriate message if the customer provided 
	// too little money or the exact amount.
	static boolean validAmount(float price, float given) {
		float diff = given - price;
		if (diff == 0.0F) {
			System.out.println("Exact change given. No change needed.\n");
			return false;
		} else if (diff < 0) {
			System.out.println("Not enough money given. Ask customer for more money.\n");
			return false;
		} else {
			return true;
		}
	}

	// get the number of bills that should be given to the customer.
	static int getChangeAmount(float price, float given) {
		double change = (given - price) * 100.0;
		return (int) (Math.round(change));
	}

	// Modulo the total amount of change into each separate unit quantity,
	// represented by a specific place in the array change[]
	static int[] convertChange(int total) {
		int change[] = new int[10];
		int temp = total;
		int values[] = { 10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1 };
		// loop through the values in array, modulo the change to respective
		// values, assign those values to the returning array
		for (int i = 0; i < values.length; i++) {
			if (total >= values[i]) {
				temp %= values[i];
				change[i] = total / values[i];
				total = temp;
			}
		}
		return change;
	}

	// printout proper string including whether amounts are plural or singular
	static void changeToStrings(int change[], int totalChange) {
		String quantities[] = { "hundred dollar bill", "fifty dollar bill", "twenty dollar bill", "ten dollar bill",
				"five dollar bill", "one dollar bill", "quarter", "dime", "nickel", "pennies" };
		// location of last element that has a value, this is so program
		// knows where to put the period in output
		int last = 9;
		for (int i = change.length-1; i > 0; i--) {
			if (change[i] == 0) {
				last--;
			} else {
				break;
			}
		}
		
		// determine whether to make the quantities plural, then print.
		System.out.print("Result: ");
		for (int i = 0; i < change.length; i++) {
			if (change[i] > 1 && i != 9) {
				quantities[i] += "s";
			}
			if (i == 9 && change[i] == 1) {
				quantities[9] = "penny";
			}
			if (change[i] > 0 && i < last) {
				System.out.print(change[i] + " " + quantities[i] + ", ");
			} else if (change[i] > 0 && i == last) {
				System.out.print(change[i] + " " + quantities[i] + ".\n");
			}
		}
	}
}

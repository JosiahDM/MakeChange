package change;

import java.util.Scanner;

public class CashRegister {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		float price = 0.0F;
		float moneyTendered = 0.0F;
		int changeTotal = 0;
		int unitQuantities[] = new int[10];
		
		price = promptPrice(keyboard);
		moneyTendered = promptMoneyTendered(keyboard);
		if (validAmount(price, moneyTendered)) {
			changeTotal = getChangeAmount(price, moneyTendered);
			
			unitQuantities = convertChange(changeTotal);
			
			changeToStrings(unitQuantities, changeTotal);
		}
	}
	
	// The user is prompted asking for the price of the item.
	static float promptPrice(Scanner sc) {
		float userPrice = 0.0F;
		System.out.println("Enter the price of the item: ");
		userPrice = sc.nextFloat();
		return userPrice;
	}
	
	//The user is prompted asking how much 
	// money was tendered by the customer.
	static float promptMoneyTendered(Scanner sc) {
		float tendered = 0.0F;
		System.out.println("Enter the money tendered in decimal form (ex 10.25):");
		tendered = sc.nextFloat();
		return tendered;
	}
	
	// Display an appropriate message if the customer provided 
	// too little money or the exact amount.
	static boolean validAmount(float price, float given) {
		float diff = given - price;
		if (diff == 0.0F) {
			System.out.println("Exact change given. No change needed.");
			return false;
		} else if (diff < 0) {
			System.out.println("Not enough money given. Ask customer for more money.");
			return false;
		} else {
			return true;
		}
	}
	
	// get the number of bills that should be given to the customer.
	static int getChangeAmount(float price, float given) {
		double change = (given-price) * 100.0;
		return (int)(Math.round(change));
	}
	
	// Modulo the total amount of change into each separate unit quantity, represented by
	// a specific place in the array change[]
	static int[] convertChange(int total) {
		int change[] = new int[10];
		int temp = total;
		int values[] = {10000, 5000, 2000, 1000, 500, 100, 25, 10, 5, 1};
		
		// loop through the values in array, modulo the change to respective values,
		// assign those values to the returning array
		for (int i = 0; i < values.length; i++) {
			if (total >= values[i]) {
				temp %= values[i];
				change[i] = total/values[i];
				total = temp;
			}
		}
		return change;
	}
	
	// printout proper string including whether amounts are plural or singular
	static void changeToStrings(int change[], int totalChange) {
		String quantities[] = {
				"hundred dollar bill", "fifty dollar bill", "twenty dollar bill", 
				"ten dollar bill", "five dollar bill", "one dollar bill", "quarter", "dime", "nickel", "pennies"
		};
		
		// determine whether to make the quantities plural.
		for (int i = 0; i < change.length; i++) {
			if (change[i] > 1) {
				quantities[i]+="s";
			} 
			if (i == 9 && change[i] == 1) {
				quantities[9] = "penny";
			}
		}
		
		System.out.print("Result: ");
		for (int i = 0; i < change.length; i++) {
			if (change[i] > 0 && i != 9) {
				System.out.print(change[i] + " " + quantities[i] + ", ");
			}
			if(i == 9) {
				System.out.println(change[i] + " " + quantities[i] + ".");
			}
		}	
	}
	
	
	
}

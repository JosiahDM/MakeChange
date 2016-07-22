package change;

import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		float price = 0.0F;
		float moneyTendered = 0.0F;
		int dollars = 0;
		int cents = 0;
		
		price = promptPrice(keyboard);
		moneyTendered = promptMoneyTendered(keyboard);
		if (validAmount(price, moneyTendered)) {
			
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
	
}

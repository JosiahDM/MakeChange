package change;

import java.util.Scanner;

public class CashRegister {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		float price = 0.0F;
		float moneyTendered = 0.0F;
		int dollars = 0;
		int cents = 0;
		
		
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
		return 0;
	}
	
	// Display an appropriate message if the customer provided 
	// too little money or the exact amount.
	static boolean validAmount() {
		return false;
	}
	
}

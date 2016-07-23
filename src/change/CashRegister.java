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
		return (int)(Math.ceil(change));
	}
	
	// Modulo the total amount of change into each separate unit quantity, represented by
	// a specific place in the array change[]
	static int[] convertChange(int total) {
		int change[] = new int[10];
		int temp = total;
		if (total >= 10000) {   // 100$ bill - change[0]
			temp %= 10000;
			change[0] = total/10000;
			total = temp;
		}
		if (total >= 5000) { // $50 bill - change[1]
			temp %= 5000;
			change[1] = total/5000;
			total = temp;
		}
		if (total >= 2000) { // $20 bill- change[2]
			temp %= 2000;
			change[2] = total/2000;
			total = temp;
		}
		if (total >= 1000) { // $10 bill - change[3]
			temp %= 1000;
			change[3] = total/1000;
			total = temp;
		}
		if (total >= 500) { // $5 bill - change[4]
			temp %= 500;
			change[4] = total/500;
			total = temp;
		}
		if (total >= 100) { // $1 bill - change[5]
			temp %= 100;
			change[5] = total/100;
			total = temp;
		}
		if (total >= 25) {
			temp %= 25;       		// change[6]  quarters
			change[6] = total/25;
			total = temp;
		}
		if (total >= 10) {
			temp %= 10;
			change[7] = total/10; 	// change[7] dimes
			total = temp;
		}
		if (total >= 5) { 
			temp %= 5;
			change[8] = total/5;   	// change[8]  nickels
			total = temp;
		}
		if (total > 0) { 
			change[9] = total; 		// change[9] pennies
		}
		return change;
	}
	
	// printout proper string including whether amounts are plural or singular
	static void changeToStrings(int change[], int totalChange) {
//		String hundred; String fifty; String twenty; String ten;
//		String five; String one; String Q; String D; String N; String P;
		String quantities[] = {
				"hundred dollar bill", "fifty dollar bill", "twenty dollar bill", 
				"ten dollar bill", "five dollar bill", "one dollar bill", "quarter", "dime", "nickel", "pennies"
		};
					
		for (int i = 0; i < change.length; i++) {
			if (change[i] > 1) {
				quantities[i]+="s";
				System.out.println(quantities[i] + " In if...");
			} 
			if (i == 9 && change[i] > 1) {
				quantities[9] = "pennies";
			}
		}
		
		System.out.print("Result: " + change[0] + " " + quantities[0] + ", ");
		System.out.print(change[1] + " " + quantities[1] + ", ");
		System.out.print(change[2] + " " + quantities[2] + ", ");
		System.out.print(change[3] + " " + quantities[3] + ", ");
		System.out.print(change[4] + " " + quantities[4] + ", ");
		System.out.println(change[5] + " " + quantities[5] + ", ");
		System.out.print(change[6] + " " + quantities[6] + ", ");
		System.out.print(change[7] + " " + quantities[7] + ", ");
		System.out.print(change[8] + " " + quantities[8] + ", ");
		System.out.println(change[9] + " " + quantities[9] + ".");		
	}
	
	
	
}

package change;

import java.util.Scanner;

public class CashRegister {
	
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		float price = 0.0F;
		float moneyTendered = 0.0F;
		int bills = 0;
		int cents = 0;
		int coins[] = new int[4];
		
		price = promptPrice(keyboard);
		moneyTendered = promptMoneyTendered(keyboard);
		if (validAmount(price, moneyTendered)) {
			//bills = getDollars(price, moneyTendered);
			cents = getCents(price, moneyTendered);
			coins = centsToCoins(cents);
			coinsToStrings(coins);
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
	static int getDollars(float price, float given) {
		int change = (int)(given - price);
		return change;
	}
	
	// display number of coins that should be given to the customer.
	static int getCents(float price, float given) {
		float change = (int)(given - price);
		float changeDecimal = given - price;
		float cents = changeDecimal - change;
		cents *= 100;
		return (int)cents;
	}
	
	// put coins into array for string processing
	static int[] centsToCoins(int cents) {
		int coins[] = new int[4]; 
		int temp = cents;
		if (cents >= 25) {
			temp %= 25;       		// coins[0]  quarters
			coins[0] = cents/25;
			cents = temp;
		}
		if (cents >= 10) {
			temp %= 10;
			coins[1] = cents/10; 	// coins[1] dimes
			cents = temp;
		}
		if (cents >= 5) { 
			temp %= 5;
			coins[2] = cents/5;   	// coins[2]  nickels
			cents = temp;
		}
		if (cents > 0) { 
			coins[3] = cents; 		// coins[3] pennies
		}
		return coins;
	}
	
	// printout proper string including whether amounts are plural or singular
	static void coinsToStrings(int coins[]) {
		String Q; String D; String N; String P;
		if (coins[0] == 1) {
			Q = "quarter";
		} else {
			Q = "quarters";
		}
		if (coins[1] == 1) {
			D = "dime";
		} else {
			D = "dimes";
		} 
		if (coins[2] == 1) {
			N = "nickel";
		} else {
			N = "nickels";
		}
		if (coins[3] == 1) {
			P = "penny";
		} else {
			P = "pennies";
		}
		System.out.print("Result: " + coins[0] + " " + Q + ", ");
		System.out.print(coins[1] + " " + D + ", ");
		System.out.print(coins[2] + " " + N + ", ");
		System.out.println(coins[3] + " " + P + ".");
	}
	
	
	
}

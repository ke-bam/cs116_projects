//Keven Craven, CS116
package assignmentThree;

import java.util.Scanner;
public class shopping {

	public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
		
		//Represents the list of fruits available in the grocery store
		String[] fruits = {"Orange", "Apple", "Banana", "Kiwi", "Pear"};
		
		//Represents the cost of each fruit
		double[] fruitsCost = {0.5, 0.4, 0.1, 0.25, 0.75};
		
		//Represents the number of fruits available in the grocery store
		int[] availableStock = {100, 100, 100, 100, 100};
		
		//Declaring array and variables
		int[] quantity;
		double totalCost = 0;
		int choice = 1;

		//This while loop, as long as the input is not 2, will execute and pull up the menu 
		while(choice == 1) {
			System.out.println("Press 1 for shopping\nPress 2 to exit"); 
			choice = input.nextInt();
			
			if(choice == 2) break;
			else {
				//display the available stock
				display(fruits, fruitsCost, availableStock);
				//prompt the user to enter the fruits purchased and their corresponding quantity
				quantity = purchaseQuantity(fruits.length);
				//update the available stock
				availableStock = updateAvailableStock(availableStock, quantity);	
				//display the purchase cost per fruit
				totalCost = generatePurchaseReceipt(fruits, fruitsCost, quantity);
				//display the total cost of shopping
				System.out.println("The total cost of shopping is " + totalCost);
				System.out.println();
			}

		}
			
	}
	
	public static void display(String fruits[], double fruitsCost[], int availableStock[]) { //This method is responsible for displaying the menu if the user presses 1
		int i;
		System.out.printf("Number\t\tFruit\t\tPrice\t\tAvailable quantity\n==========================================================\n"); //This is the top of the menu
		
		for(i = 0; i < fruits.length; i++) //This for loop is responsible for displaying the rest of the menu. As long as i is less than the length of the array, it will be printed
			System.out.printf(i + "\t\t" + fruits[i] +"\t\t"+ fruitsCost[i]+ " per " + fruits[i] + "\t\t" + availableStock[i] + "\n"); //This print statement prints out the rest of the menu and grabs the arrays
		System.out.println(""); //Used for creating a gap under the menu
	}
	
	public static int[] purchaseQuantity (int length) { //This method is responsible for gathering the quantity of stock purchased
		System.out.printf("Enter the item number and quantity. Enter -1 for end of purchase" + "\n");
		Scanner input = new Scanner(System.in);
		int itemNumber = 0, itemQuantity = 0;
		int [] itemsBought = new int [length];
		boolean loop = true;
		
		while (loop) { //This while loop will continue until -1 is entered
			
			itemNumber = input.nextInt();
			
			if(itemNumber == -1) {
				loop = false;
				break;
			}
			
			else {
				itemQuantity = input.nextInt();
				
				switch(itemNumber) { //Switch statement checks to see if which number was selected and adds it accordingly
					case 0: 
						itemsBought [0] += itemQuantity; 
						break;
					case 1:
						itemsBought [1] += itemQuantity;
						break; 
					case 2:
						itemsBought [2] += itemQuantity;
						break;
					case 3:
						itemsBought [3] += itemQuantity;
						break; 
					case 4:
						itemsBought [4] += itemQuantity;
						break;
					default: 
						break;
				}
				
			}	
		}
			return itemsBought;
			
	}
		
	public static int [] updateAvailableStock (int availableStock [], int itemsBought[]) { //This method updates the stock depending on how many fruits the customer wanted
		int [] array = new int [availableStock.length];
		int i = 0;
		int thisStock = 0, thisQuantity = 0;
		
		for(i = 0; i < availableStock.length; i++) {//For loop calculates the remaining stock. Current stock - amount user wants
			thisStock = availableStock[i];
			thisQuantity = itemsBought[i];
			array[i] = thisStock - thisQuantity;
		}

		return array;
	}
	
	public static double generatePurchaseReceipt (String fruits[], double fruitsCost[], int quantity[]) {//This method is responsible for printing out the receipt
		int i = 0;
		double cost = 0, tempCost = 0;
		System.out.printf("Item\t\tQty\t\tCost\n==========================================");//Top of the receipt
		for(i = 0; i < fruits.length; i++) {
			tempCost = fruitsCost[i] * quantity [i];
			cost += tempCost; 
			if(quantity[i]>0) {
				System.out.printf("\n%s\t\t%d\t\t%.2f", fruits[i], quantity[i], tempCost);//The output is formatted so it looks fancy
			}
			
		}
		System.out.printf("\n==========================================\n");//Bottom of the receipt
		return cost;
	}

	}
	
	
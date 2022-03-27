package homework1;
import java.util.Scanner;
public class hw1 {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		int knuts = 0, sickles = 0, galleons = 0, userInput = 0;
		
		System.out.print("Enter the currency in knuts: ");
		userInput = input.nextInt();
		knuts = userInput;
		
		if (knuts >= 29) { // don't need to convert if there are less than 29 knuts
			sickles = knuts / 29;
			
			if (sickles < 17) { // not enough sickles to make a galleon
				knuts = knuts % 29;
			} else {
				galleons = sickles / 17; // divide to get number of galleons
				sickles = sickles % 17; // get remainder of galleons division
				
				// subtract amount of knuts converted to sickles & galleons from total knut count
				knuts = knuts - (sickles * 29) - (galleons * 17 * 29);  
			}			
		} 
			System.out.println(userInput + " knuts = " + galleons + " galleons " + sickles + " sickles " + knuts + " knuts");

	}
}

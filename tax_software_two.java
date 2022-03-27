import java.util.Scanner; //Import scanner
public class tax_software_two {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //Create the scanner
		//Declare all of the variables that will be used. Variables are set to 0 so the program will have no errors.
		double user_input, paid_taxes, exceeding_amount = 0, remaining_amount = 0, adjusted_income, taxes_owed = 0, extra_tax = 0, standard_deduction = 12000; 
		int tax_bracket = 0; //This variable is for the tax bracket and is set to 0 so the code has no issues.
		
		System.out.println("Please enter your annual income ($): "); //Prompt user to enter income.
		System.out.println("Please enter your taxes paid to the IRS: "); //Prompt user to enter the amount they have paid to the IRS.
		user_input = input.nextDouble(); //First input from user is stored here.
		paid_taxes = input.nextDouble(); //Second input from user is stored here.
		
		if(user_input < 10000) { //This if statement determines if the user's annual income is under $10k.
			tax_bracket = 1; //User's tax bracket is 1 (default amount owed is $0).
			adjusted_income = user_input - standard_deduction; //User's income is recalculated by subtracting it by the standard deduction amount ($12,000).
			taxes_owed = 0; //Because of their income, the user will have to pay no taxes.
			remaining_amount = taxes_owed - paid_taxes; //This is responsible for determining what the leftover will be, whether it's how much the user still owes or how much of a refund they should get. 
		}
		else if(user_input >= 10000 && user_input < 25000) { //Determines if the user's income is greater than or equal to $10k and less than $25k.
			adjusted_income = user_input - standard_deduction; //User's income is recalculated by subtracting it by the standard deduction amount ($12,000).
			tax_bracket = 2; //User's tax bracket is 2 (default amount owed is $0).
			taxes_owed = adjusted_income * .15; // Taxes owed are calculated by multiplying the adjusted income by 15%. This gathers how much tax they will be paying. 
			remaining_amount = taxes_owed - paid_taxes;	//This is responsible for determining what the leftover will be, whether it's how much the user still owes or how much of a refund they should get.
		}
		else if(user_input >= 25000 && user_input < 75000) { //Determines if the user's income is greater than or equal to $25k and less than $75k.
			adjusted_income = user_input - standard_deduction; //User's income is recalculated by subtracting it by the standard deduction amount ($12,000).
			tax_bracket = 3; //User's tax bracket is 3 (default amount owed is $3,750).
			exceeding_amount = adjusted_income - 25000; //Determines how much a user must pay, which is 20% of the amount exceeding $25k.
			extra_tax = exceeding_amount * .20; //Extra taxes are calculated by multiplying the exceeding amount by 20%. This gathers how much tax they will be paying on the amount exceeding $25,000.
			taxes_owed = 3750 + extra_tax; //Taxes owed are calculated by taking $3,750 (default amount) and adding extra_tax.
			remaining_amount = taxes_owed - paid_taxes; //This is responsible for determining what the leftover will be, whether it's how much the user still owes or how much of a refund they should get.
		}
		else if(user_input >= 75000 && user_input < 150000 ) { //Determines if user's income is greater than or equal to $75k and less than $150k.
			adjusted_income = user_input - standard_deduction; //User's income is recalculated by subtracting it by the standard deduction amount ($12,000).
			tax_bracket = 4; //User's tax bracket is 4 (default amount owed is $15,000).
			exceeding_amount = adjusted_income - 75000; //Determines how much a user must pay, which is 25% of the amount exceeding $75k.
			extra_tax = exceeding_amount * .25; //Extra taxes are calculated by multiplying the exceeding amount by 25%. This gathers how much tax they will be paying on the amount exceeding $75,000.
			taxes_owed = 15000 + extra_tax; //Taxes owed are calculated by taking $15k (default amount) and adding extra_tax.
			remaining_amount = taxes_owed - paid_taxes; //This is responsible for determining what the leftover will be, whether it's how much the user still owes or how much of a refund they should get.
		}
		else if(user_input >= 150000 && user_input < 300000) { //Determines if the user's income is greater than or equal to $150k and less than $300k.
			adjusted_income = user_input - standard_deduction; //User's income is recalculated by subtracting it by the standard deduction amount ($12,000).
			tax_bracket = 5; //User's tax bracket is set to 5 (default amount owed is $37,500).
			exceeding_amount = adjusted_income - 150000; //Determines how much a user must pay, which 30% of the amount exceeding $150k.
			extra_tax = exceeding_amount * .30; //Extra taxes are calculated by multiplying the exceeding amount by 30%. This gathers how much tax they will be paying on the amount exceeding $150,000.
			taxes_owed = 37500 + extra_tax; //Taxes owed are calculated by taking $37,500 (default amount) and adding extra_tax.
			remaining_amount = taxes_owed - paid_taxes; //This is responsible for determining what the leftover will be, whether it's how much the user still owes or how much of a refund they should get.
		}
		else {  //If other conditions are not met, the program will determine the user's income if it is greater than or equal to $300k.
			adjusted_income = user_input - standard_deduction; //User's income is recalculated by subtracting it by the standard deduction amount ($12,000).
			tax_bracket = 6; //User's tax bracket is 6 (default amount owed is $45,000).
			exceeding_amount = adjusted_income - 300000; //Upon entering the sixth bracket, a user must pay 35% of the amount exceeding $300k.
			extra_tax = exceeding_amount * .35; // Extra taxes are calculated by multiplying the exceeding amount by 35%. This gathers how much tax they will be paying on the amount exceeding $300,000.
			taxes_owed = 45000 + extra_tax; //Taxes owed are calculated by taking $45,000 (default amount) and adding extra_tax.
			remaining_amount = taxes_owed - paid_taxes; //This is responsible for determining what the leftover will be, whether it's how much the user still owes or how much of a refund they should get.
			
		}
		
		System.out.println("Your tax bracket is " + tax_bracket); //Outputs what the user's tax bracket is.
		System.out.println("Total taxes owed to the IRS: $" + taxes_owed); //Outputs the amount of money that the user owed to the IRS for the year.
		
		if (taxes_owed > paid_taxes){ //This if statement checks to see if the user is eligible for a refund, or if they are not.
			System.out.println("You owe money to the IRS: $" + remaining_amount); //If the user is not eligible for a refund, they're told so and what amount.
		}
		else { //If the user does not owe any taxes, they are eligible for a refund.
			System.out.println("Your tax refund is: $" + remaining_amount*-1); //If the user is eligible for a refund, they're told the amount. The *-1 is to make the remaining amount positive instead of negative.
		}
		

	}
}

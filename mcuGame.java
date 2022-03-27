import java.util.*; //Import java scanner
public class mcuGame {

	public static void main(String[] args) { //Main that is used to hold the entire program
		Scanner input = new Scanner(System.in); //Create the scanner
		int maxDamage1 = 0, maxDamage2 = 0, p1Health = 100, p2Health = 100, p1Damage = 0, p2Damage = 0; //Declared the variables that will be used. maxDamage1/2 are for both of the players' max damages, p1/2Health is each players' health (both always start at 100). Other variables are set to 0 so they are initialized 
																										//p1/2Damage will later hold the damage that each Avenger does (randomly determined based on their maxDamage)
																										
		int x = 1; //This is the variable used to check that the while loop is still true
		
		String playerOne, p1Tag, p2Tag, playerTwo, winningTag = " ", winner = " "; //String variables that are used to hold names. playerOne/playerTwo hold the players' names, p1/2Tag holds their tag lines, winningTag is used to hold the tag line of the winner (determined in the nested if statement).
																				   //The winner variable is later used to hold the name of the winning Avenger
		
		System.out.print("---Player 1---\nName: "); //Prompts player one to enter their Avenger's name. \n is only used to cut down on one print statement
		playerOne = input.nextLine(); //Assigns the Avenger's name to playerOne
		System.out.print("MaxDamage: "); //Prompts the first player to enter the maximum amount of damage that their Avenger can deal
		maxDamage1 = Integer.parseInt(input.nextLine()); //Takes the line and assigns the integer value to the variable maxDamage1
		System.out.print("Tagline: "); //Prompts player one to enter their Avenger's tag line
		p1Tag = input.nextLine(); //The tag line is then assigned to this variable
		
		System.out.print("---Player 2---\nName: "); //Prompts player two to enter their Avenger's name. \n is only used to cut down on one print statement
		playerTwo = input.nextLine(); //Assigns player two's Avenger name to the variable
		System.out.print("MaxDamage: "); //Prompts the second player to enter the maximum amount of damage that their Avenger can deal
		maxDamage2 = Integer.parseInt(input.nextLine()); //Takes the line and assigns the integer value to the variable maxDamage2
		System.out.print("Tagline: "); //Prompts player two to enter their Avenger's tag line
		p2Tag = input.nextLine(); //The tag line is then assigned to this variable
		
		System.out.println(playerOne + " and " + playerTwo + " have entered the arena. Let the fight begin..\n-------------------------------------"); //After the players have entered their information, this tells which Avengers are entering the arena
		while (x > 0) { //While loop that will continue until x < 1. X is only set to 0 when an Avenger's health is 0
			if(p1Health > 0 && p2Health > 0) { //This if statement is responsible for the logic of the program. It checks to see that both of the players health are above 0
				p1Damage = new Random().nextInt(maxDamage1); //This variable is responsible for randomizing the attack damage. The ceiling is determined by what the user entered for their Avenger's max attack
				p2Damage = new Random().nextInt(maxDamage2); //This variable is responsible for randomizing the attack damage. The ceiling is determined by what the user entered for their Avenger's max attack
				p1Health -= p2Damage; //Each Avenger has 100 hit points, and it is stored in this variable. p1Health is then subtracted by the amount of damage that player two has done
				p2Health -= p1Damage; //Each Avenger has 100 hit points, and it is stored in this variable. p1Health is then subtracted by the amount of damage that player one has done
				
				if(p1Health < 1 || p2Health < 1) { //This if statement checks if either players' health is below one
					if(p1Health < 1) { //This if statement is responsible for checking if player one's health is below one
						p1Health = 0; //Player one's health is set to 0. Doing this disallows any negative numbers for hit points. If an Avenger has 5 hit points and their opponent deals 6, their health will show 0 instead of -1
						winner = playerTwo; //Being that player one has no more hit points, the winner variable is set to player two, as they still have hit points
						winningTag = p2Tag; //This variable is assigned player two's tag line
						x = 0; //X is 1, so setting x to 0 will mean that the while loop will end 
					}
					else if(p2Health < 1) { //If the second player's health is less than 1, then this will execute
						p2Health = 0; //Player two will have their health set to 0 so it does not go into the negatives
						winner = playerOne; //Player one is then assigned the winner because player two has no more hit points
						winningTag = p1Tag; //Player one's tag line is assigned to this variable
						x = 0; //X is 1, so setting x to 0 will mean that the while loop will end
					}
				}
				
				if(p1Health > -1 && p2Health > -1) { //This statement executes as long as the above if condition is true. This means that both Avengers have 1 or more hit points remaining and the battle will continue
					System.out.println(playerOne + " just dealt " + p1Damage + " damage to " + playerTwo + ". " + playerTwo + " now has " + p2Health + " hp remaining"); //Output for the damage that player one has done to player two. It tells how many hit points player two has left
					System.out.println(playerTwo + " just dealt " + p2Damage + " damage to " + playerOne + ". " + playerOne + " now has " + p1Health + " hp remaining"); //Output for the damage that player two has done to player one. It tells how many hit points player one has left
				}
				else { //Used just in case something happens. It will prevent an infinite loop
					x = 0; //Used to break out of the loop, as x must be greater than 0 in order to be true
				}
			}
		}
		System.out.println(winner + " wins. " + winner + " says " + winningTag); //Outside of the loop, this will tell who the winner was and what their tag line was
	}
}
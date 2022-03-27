package hw4_2;
// Keven Craven, CS 116, HW 4
import java.util.*; //Import the scanner

public class House_ {
 public static void main(String[] args) { // Main method
     Scanner userInput = new Scanner(System.in); // Create the scanner and call it userInput
     int size, roof, perimeter; // Will be used for holding the user input, roof size & making calculations.
     int i, j; // Will be used for iteration
     char border, fill; // Declare the character variables that will store the border and the fill
     double area; // Declare the area variable to hold the area

     // Prompts the user to enter a house size, which is then assigned to the designated variable.
     // Size 5 will give a user a base of 5, but a roof of 7
     System.out.print("Please enter the size of the house that you want: "); // Output to ask the user to enter house size.
     size = userInput.nextInt(); // size variable is used to take the user's input
     roof = size + 2; // Add 2 to accommodate roof overhang.

     // Prompts the user to enter what border they would like & then assigns it to designated variable.
     System.out.print("Please enter what border character you want: "); // Output to ask the user to enter what border char they want.
     border = userInput.next().charAt(0); // border variable is used to take user's input.

     // Prompts the user to enter the character they'd like for the fill of the house & then assigns it to variable.
     System.out.print("Please enter what fill character you want: "); // Output to ask the user what fill char they want.
     fill = userInput.next().charAt(0); // fill variable is used to take the user's input.
     
     /*----------- CALCULATION CODE. This chunk of code is responsible for the calculations. -----------*/
     perimeter = 3 * size + 2 * (size + 2) + 2; // This line is used to calculate the total perimeter of the house.
     area = (size * size) + ((Math.sqrt(3) / 4) * roof * roof); // This line is used to calculate the total area of the house.

     System.out.println("The perimeter of the house is " + perimeter + " units."); //Outputs what the perimeter of the house is.
     System.out.println("The area of the house is " + area + " units."); //Outputs what the area of the house is.
     System.out.println("The house looks like: "); // Outputs above the house to say what it looks like.

     /*----------- ROOF CODE. This chunk of the code is responsible for creating the roof. -----------*/
     // Main for-loop for the roof. i is used as the counter for the columns of the roof.
     // i cannot be <= due to the fact that it will mess up the structure of the roof very slightly.
     for (i = 0; i < roof; i++) { // This for-loop is the heart of the roof. 
         // Responsible for adding the required spaces. We want a triangle & x amount of spaces are needed to make it
         for (j = 0; j < size - i + 1; j++) { // This for-loop determines if a space needs to be printed or not.
             System.out.print(" "); // This print statement outputs a space.
         }

         // This loop is responsible for outputting the border & the fill that (where appropriate) the user chose.
         for (j = 0; j <= i; j++) {  
             // The last line of the roof needs four border characters, while the rest only need two.
             if (i == roof - 1) { // Runs only if on the last row of the roof.
                 // This statement ensures that the fill character isn't placed in the first and last two iterations.
                 if (j != 0 && j != 1 && j != i - 1 && j != i) {
                     System.out.print(fill + " "); // Outputs the fill that the user chose and adds a space after.
                 } else { // With the border of the roof, there should be 4 border characters in this line.
                     System.out.print(border + " "); // Outputs the user's border along with a space.
                 }
             } 
             else { // This fills all but the last line of the roof
                 if (j != 0 && j != i) { // Ensures fill characters aren't placed in the spots of the border characters.
                     System.out.print(fill + " "); // Outputs the fill that the user chose and adds a space after.
                 }
                 else { // With the border of the roof, there should only be 2 pieces of border on a given row.
                     System.out.print(border + " "); // Outputs the user's border along with a space.
                 }
             }
         }
         System.out.println(""); //Creates a new line every time the main for-loop executes.
     }

     /*----------- BASE CODE. This chunk of code is responsible for creating the base of the house. -----------*/
     // size is - 1 is used here since the bottom border is printed outside of this loop.
     for (i = 0; i < size - 1; i++) { // This for-loop is the heart of the base.
         // This print statement is responsible for the space before the base of the house starts.
         // The house would not be aligned if this was not here.
         System.out.print("  ");
         // This for-loop is responsible for determining where the border and the filler need to go.
         for (j = 0; j < size; j++) { // This if statement determines where the filler will go.
             if (i == size - 2) { // Only print the border character for the last line.
                 System.out.print(border + " "); // Outputs the border that the user chose followed by a space.
             } 
             else {
                 if (j != 0 && j != size - 1) { // This if statement determines if filler is needed.
                     System.out.print(fill + " "); // This outputs the filler that the user chose followed by a space.
                 }
                 else { // If the above statement is false, then print the border characters.
                     // Because you only need 2 pieces of border per line, if j is 0 or j is size - 1, then print a border.
                     System.out.print(border + " "); // Outputs the border that the user chose followed by a space.
                 }
             }
         }
         // After each iteration of the main for-loop runs, a new line is printed, so then the program can
         // properly output the house and have it not all be on a single line.
         System.out.println(""); 
     }

 }
}
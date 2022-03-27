package cw;
import java.util.*;
public class cw10 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int userOption;
		double speed, distance, time;
		System.out.print("What calculation do you want to perform?\nOption 1: Speed\nOption 2: Distance\nOption 3: Compute time\nOption 4: Exit program\nPlease enter your option number: ");
		userOption = input.nextInt();
		
		do {
			switch(userOption) {
			case 1: System.out.print("Please enter the distance and time to compute speed: ");
					distance = input.nextDouble();
					time = input.nextDouble();
					speed = distance/time;
					System.out.println("The speed is " + speed + " mph");
					break;
			case 2: System.out.print("Please enter the speed and time to compute the distance: ");
					speed = input.nextDouble();
					time = input.nextDouble();
					distance = speed * time;
					System.out.println("The distance is " + distance + " miles");
					break; 
			case 3: System.out.print("Please enter the distance and speed to compute time: ");
					distance = input.nextDouble();
					speed = input.nextDouble();
					time = distance / speed;
					System.out.println("The time is " + time + " hours");
					break;
			
			}
			System.out.print("Please enter an option number: ");
			userOption = input.nextInt();
			
		} while(userOption != 4);
		
		System.out.println("Thank you!");
	}

}

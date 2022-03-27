package misc;
import java.util.*;
public class CW9 {
	public static void main(String[] args) {
		int i, j, n = 10;
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		n = input.nextInt();
		for(i = 1; i <= n; i++) {
			for(j = 1; j <= n - 1; j++) {
				if(j == 1 || j == n - 1) {
					System.out.print("*");
				}
				if(j == i - 1 && j != n -1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}	
	}
}
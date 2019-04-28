package hw;
	import java.util.Scanner; 
public class Hw_2_6 {
	public static void main (String[] atgs){
		Scanner input = new Scanner (System.in);
		System.out.println("Enter a number between 0 and 1000:");
		int number = input.nextInt();
		int sum_of_digits = (number/100)+((number/10)-(number/100)*10)+number-((number/10)-(number/100)*10)*10-(number/100)*100;
		
		System.out.println("The sum of the digits is " + sum_of_digits);
	}
	
}
